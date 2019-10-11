<template>
  <div>
    <add-info-sales ref="infoSales" :info="salesInfo" disabled />
    <v-container fluid class="py-0 px-3">
      <v-layout>
        <v-flex xs12 md4>
          <v-text-field :value="client1" label="擬被保人" disabled />
        </v-flex>
      </v-layout>
    </v-container>
    <v-divider />
    <add-plan-form ref="planForm" />
    <v-layout justify-space-between class="mt-4">
      <v-btn style="background: #52a5b5;color: #fff;" @click="pre"><v-icon>arrow_back</v-icon>上一步</v-btn>
      <v-btn style="background: #52a5b5;color: #fff;" @click="next">下一步<v-icon>arrow_forward</v-icon></v-btn>
    </v-layout>
  </div>
</template>
<script type = 'text/javascript'>
import { mapState, mapMutations } from 'vuex'
import { filterSmoker, filterGender } from '@/filters/proposal'

import AddInfoSales from './add-info-sales'
import AddPlanForm from './add-plan-form'

export default {
  name: 'ProposalAddPlan',
  components: { AddInfoSales, AddPlanForm },
  data() {
    return {}
  },
  computed: {
    ...mapState({
      currentStep: state => state.proposal.currentStep,
      salesInfo: state => state.proposal.salesInfo,
      client1Info: state => state.proposal.client1Info,
      client2Info: state => state.proposal.client2Info,
      plan: state => state.proposal.plan
    }),
    client1() {
      const { name, age, gender, isSmoker } = this.client1Info
      if (!name) {
        return ''
      }
      const genderVal = filterGender(gender)
      const smokerVal = filterSmoker(isSmoker)
      return `${name}，${age}歲，${genderVal}，${smokerVal}`
    }
  },
  watch: {
    currentStep(val) {
      if (val === 2 && this.quotNo !== undefined) {
        this.getDetail()
      }
    }
  },
  created() {
    this.quotNo = this.$route.query.quotNo
  },
  methods: {
    ...mapMutations(['proposal/SET_PLAN']),
    pre() {
      console.log('上一步')
      this.$emit('pre')
    },
    async next() {
      const plan = this.$refs.planForm.getData()
      const { year, money, payType, bonusType, basePlan, wppb } = plan
      const { age, gender, isSmoker} = this.client1Info
      var quotJointLife
      if (this.client2Info !== undefined) {
        quotJointLife = 'Y'
      } else {
        quotJointLife = ''
      }
      const { proposalId } = this.salesInfo
      const param = {
        quotFinsuredAge: age,
        quotFinsuredGender: gender,
        quotFinsuredSmoker: isSmoker,
        quotNo: proposalId,
        quotPlan: plan.plan,
        quotYears: year,
        quotCcy: money,
        quotPaymode: payType,
        quotDividend: bonusType,
        quotJointLife: quotJointLife,
        quotLoading: basePlan,
        quotFactor: wppb
      }
      if (!plan) {
        return console.warn('表單數據未填寫')
      }
      const res = await this.$api.insert(param)
      console.log(res)
      this['proposal/SET_PLAN'](plan)
      this.$emit('next')
    },
    async getDetail() {
      const res = await this.$api.showquotdetail({quotNo: this.$route.query.quotNo})
      var quotDetail = res.body.quotDetail
      // Step 2
      var sexName = quotDetail.quotFinsuredGender
      if (sexName === 'F') {
        sexName = '女'
      } else {
        sexName = '男'
      }
      var smokeName = quotDetail.quotFinsuredSmoker
      if (smokeName === 'N') {
        smokeName = '非吸煙者'
      } else {
        smokeName = '吸煙者'
      }
      this.$refs.planForm.updOtherSelect(quotDetail.quotYears)
    }
  }
}
</script>
<style lang='scss' scoped>
</style>
