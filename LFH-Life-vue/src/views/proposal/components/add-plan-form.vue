<template>
  <v-form>
    <v-container fluid>
      <v-layout wrap>
        <v-flex xs12 md4>
          <v-select
            ref="planSelect"
            v-model.trim="$v.formData.plan.$model"
            :error-messages="planErrors"
            label="基本計劃"
            :items="planItems"
            @change="updOtherSelect"
          />
        </v-flex>
        <v-flex xs12 md2>
          <v-select
            v-model.trim="$v.formData.year.$model"
            :error-messages="yearErrors"
            label="年期"
            :disabled="isDisable"
            :items="yearItems"
            @change="updYearSelect"
          />
        </v-flex>
        <v-flex xs12 md2>
          <v-select
            v-model.trim="$v.formData.money.$model"
            :error-messages="moneyErrors"
            label="貨幣"
            :items="moneyItems"
          />
        </v-flex>
        <v-flex xs12 md2>
          <v-select v-model="formData.payType" label="繳費辦法" :items="payTypeItems" />
        </v-flex>
        <v-flex xs12 md2>
          <v-select v-model="formData.bonusType" label="紅利選擇" :items="bonusTypeItems" />
        </v-flex>
        <v-flex xs12 md4>
          <v-text-field label="聯保" :value="client2" readonly @click.stop="showDialog" />
        </v-flex>
        <v-flex xs12 md2>
          <v-text-field v-model.number="formData.basePlan" label="基本計劃LOADING" />
        </v-flex>
        <v-flex xs12 md2>
          <v-text-field v-model.number="formData.wppb" label="WP/PB FACTOR" />
        </v-flex>
      </v-layout>
    </v-container>
    <v-dialog v-model="dialog" persistent max-width="500px">
      <add-info-client
        ref="client2"
        title="次擬被保人"
        :info="client2Info"
        :client-disabled="clientDisabled"
        class="greenClient"
        actions
        @cancel="cancelHandler"
        @confirm="confirmHandler"
      />
    </v-dialog>
  </v-form>
</template>
<script type = 'text/javascript'>
import axios from 'axios'
import { validationMixin } from 'vuelidate'
import { required } from 'vuelidate/lib/validators'
import AddInfoClient from './add-info-client'
import { mapState } from 'vuex'
import { filterGender, filterSmoker } from '@/filters/proposal'

export default {
  name: 'ProposalAddPlanForm',
  components: { AddInfoClient },
  mixins: [validationMixin],
  data() {
    return {
      formData: {
        plan: '',
        year: '',
        money: '',
        planName: '',
        yearName: '',
        payType: '',
        bonusType: '',
        basePlan: '0.0000',
        wppb: '1.0'
      },
      quotDetail: {},
      clientDisabled: false,
      // client2: '',
      planItems: [],
      yearItems: [],
      moneyItems: [],
      payTypeItems: [],
      bonusTypeItems: [{ text: 'A-積存升息', value: 1 }],
      dialog: false,
      isDisable: false
    }
  },
  validations: {
    formData: {
      plan: { required },
      year: { required },
      money: { required }
    }
  },
  computed: {
    ...mapState({
      currentStep: state => state.proposal.currentStep,
      salesInfo: state => state.proposal.salesInfo,
      client1Info: state => state.proposal.client1Info,
      client2Info: state => state.proposal.client2Info,
      plan: state => state.proposal.plan
    }),
    client2() {
      const { name, age, gender, isSmoker } = this.client2Info
      if (!name) {
        return ''
      }
      const genderVal = filterGender(gender)
      const smokerVal = filterSmoker(isSmoker)
      return `${name}，${age}歲，${genderVal}，${smokerVal}`
    },
    planErrors() {
      const plan = this.$v.formData.plan
      if (!plan.$dirty) return ''
      if (!plan.required) return '請選擇基本計劃'
      return ''
    },
    yearErrors() {
      const year = this.$v.formData.year
      if (!year.$dirty) return ''
      if (!year.required) return '請選擇年期'
      return ''
    },
    moneyErrors() {
      const money = this.$v.formData.money
      if (!money.$dirty) return ''
      if (!money.required) return '請選擇貨幣'
      return ''
    }
  },
  watch: {
    currentStep(val) {
      if (val === 2) {
        // 说明激活了当前组件所在的步骤
        axios.all([this.getProdList(), this.getPlanDetail()]).then(() => {
          // 如果基本计划没有值则展开选项
          if (!this.formData.plan) {
            setTimeout(() => this.$refs.planSelect.onClick(), 450)
          }
        })
      }
    }
  },
  methods: {
    confirmHandler() {
      this.$refs.client2.getData()
    },
    cancelHandler() {
      this.$refs.client2.reset()
      this.dialog = false
    },
    async getProdList() {
      const res = await this.$api.prodCovLineList({gender: filterGender(this.client1Info.gender), age: this.client1Info.age})
      this.planItems = res.body.prodList
    },
    async updOtherSelect(val) {
      this.yearItems = []
      this.moneyItems = []
      this.payTypeItems = []
      // this.formData.plan = val
      this.getYearItem(val, 1)
    },
    async getYearItem(val, item) {
      const genderVal = filterGender(this.client1Info.gender)
      const res = await this.$api.productList({ productLine: val, gender: genderVal, age: this.client1Info.age })
      this.yearItems = res.body.tabList
      if (item === 1) {
        this.formData.year = this.yearItems[0].value
        this.formData.yearName = this.yearItems[0].text
        this.getMoneyItem(this.yearItems[0].value, 1)
        this.getPayItem(this.yearItems[0].value, 1)
        this.formData.bonusType = this.bonusTypeItems[0].value
      }
      if (this.yearItems.find(item => item.text === '')) {
        this.isDisable = true
        this.formData.year = this.yearItems[0].value
        this.formData.yearName = ''
      } else {
        this.isDisable = false
      }
      if (this.planItems.length > 0) {
        this.formData.planName = this.planItems.find(item => item.value === this.formData.plan)['text']
        this.formData.yearName = this.yearItems.find(item => item.value === this.formData.year)['text']
      }
    },
    async getMoneyItem(val, item) {
      const ccyRes = await this.$api.countryCcyList({ covCode: val })
      this.moneyItems = ccyRes.body.ccyList
      if (item === 1) {
        this.formData.money = this.moneyItems[0].value
      }
    },
    async getPayItem(val, item) {
      const modRes = await this.$api.payModeList({ covCode: val })
      this.payTypeItems = modRes.body.modeList
      if (item === 1) {
        this.formData.payType = this.payTypeItems[0].value
      }
    },
    async updYearSelect(val) {
      var covCode = val
      this.formData.yearName = this.yearItems.find(item => item.value === this.formData.year)['text']
      // get Money List
      const ccyRes = await this.$api.countryCcyList({ covCode: covCode })
      this.moneyItems = ccyRes.body.ccyList
      // get payMode List
      const modRes = await this.$api.payModeList({ covCode: covCode })
      this.payTypeItems = modRes.body.modeList
    },
    getData() {
      const v = this.$v
      v.$touch()
      if (!v.$error) {
        // const { plan, planName, year, yearName, money, payType, bonusType, basePlan, wppb } = this.formData
        return { ...this.formData }
      }
    },
    async getPlanDetail() {
      const res = await this.$api.showquotdetail({ quotNo: this.salesInfo.proposalId })
      if (res) {
        this.quotDetail = res.body.quotDetail
        if (this.quotDetail.quotPlan !== null) {
          this.getYearItem(this.quotDetail.quotPlan)
          this.getMoneyItem(this.quotDetail.quotYears)
          this.getPayItem(this.quotDetail.quotYears)
          this.formData.plan = this.quotDetail.quotPlan
          this.formData.year = this.quotDetail.quotYears
          this.formData.money = this.quotDetail.quotCcy
          this.formData.payType = this.quotDetail.quotPaymode
          this.formData.bonusType = this.bonusTypeItems[0].value
          this.formData.basePlan = this.quotDetail.quotLoading.toFixed(4)
          this.formData.wppb = this.quotDetail.quotFactor.toFixed(1)
        }
      }
    },
    showDialog() {
      this.dialog = true
      if (this.dialog) {
        this.clientDisabled = true
      }
    }
  }
}
</script>
<style lang='scss'>
  .greenClient .v-card__title{
    background: #1ab394 !important;
  }
</style>
