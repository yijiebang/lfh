<template>
  <div>
    <add-info-sales ref="infoSales" :info="salesInfo" />
    <v-container fluid>
      <v-layout>
        <v-flex xs12 md4>
          <add-info-client ref="infoClient1" title="擬被保人" class="blueClient" :info="client1Info" />
        </v-flex>
        <v-flex xs12 md4 class="mx-4">
          <add-info-client
            ref="infoClient2"
            title="次擬被保人"
            class="greenClient"
            :valite="false"
            :info="client2Info"
          />
        </v-flex>
        <v-flex xs12 md4>
          <add-info-client
            ref="infoClient3"
            title="付款者豁免保费专用"
            class="orangeClient"
            :valite="false"
            :pay-input="payInput"
            :info="client3Info"
          />
        </v-flex>
      </v-layout>
      <v-layout justify-space-between class="mt-4">
        <v-btn style="background: #52a5b5;color: #fff;" @click="goBack()">
          <v-icon>arrow_back</v-icon>返回
        </v-btn>
        <v-btn style="background: #52a5b5;color: #fff;" @click="next">
          下一步
          <v-icon>arrow_forward</v-icon>
        </v-btn>
      </v-layout>
    </v-container>
  </div>
</template>
<script type = 'text/javascript'>
import { mapMutations, mapState } from 'vuex'
import { disableHistory } from '@/filters/index'
import AddInfoSales from './add-info-sales'
import AddInfoClient from './add-info-client'
export default {
  name: 'ProposalAddInfo',
  components: { AddInfoSales, AddInfoClient },
  data() {
    return {
      formData: {
        name: '',
        age: '',
        gender: '',
        isSmoker: ''
      },
      payInput: true,
      years: ''
    }
  },
  computed: {
    ...mapState({
      user: state => state.user.info,
      currentStep: state => state.proposal.currentStep,
      salesInfo: state => state.proposal.salesInfo,
      client1Info: state => state.proposal.client1Info,
      client2Info: state => state.proposal.client2Info,
      client3Info: state => state.proposal.client3Info,
      plan: state => state.proposal.plan,
      previewed: state => state.proposal.previewed
    })
  },
  watch: {
    currentStep(val) {
      if (val === 1) {
        if (!this.previewed) {
          this.getDetail()
        } else {
          // 已经进入第三步，并且预览之后点击修改来的
          // 新創建訂單
          this.createNewOrder()
          this['proposal/UPDATE_PREVIEWED'](false)
        }
      }
    }
  },
  beforeCreate() {
    disableHistory(document.URL)
  },
  created() {
    var quotNo = this.$route.query.quotNo
    if (quotNo != null) {
      this.getDetail()
    }
  },
  methods: {
    ...mapMutations(['proposal/SET_INFO', 'proposal/RESET_STATE', 'proposal/SET_PLAN', 'proposal/UPDATE_PREVIEWED']),
    async createNewOrder() {
      const req = { quotNo: this.salesInfo.proposalId }
      const res = await this.$api.editInsured(req)
      if (res.body && typeof res.body === 'object') {
        const newInfo = {...this.salesInfo, proposalId: res.body.quotNo}
        this['proposal/SET_INFO']({
          salesInfo: newInfo
        })
      }
    },
    async next() {
      const ref = this.$refs
      const salesInfo = ref.infoSales.getData()
      const client1Info = ref.infoClient1.getData()
      var client2Info = ref.infoClient2.getData()
      var client3Info = ref.infoClient3.getData2()
      if (!client1Info) {
        return console.warn('表單數據未填寫')
      }
      if (client2Info === undefined) {
        client2Info = this.formData
      }
      if (client3Info === undefined) {
        client3Info = this.formData
      }
      if (
        this.client1Info.age !== client1Info.age ||
        this.client1Info.gender !== client1Info.gender ||
        this.client1Info.isSmoker !== client1Info.isSmoker
      ) {
        this['proposal/RESET_STATE']({ plan: this.$store.state.plan })
      }
      // 新增
      const { date, proposalId, reference, salesId, salesName, tel } = salesInfo
      const { name, age, gender, isSmoker } = client1Info

      const data = {
        quotNo: proposalId,
        quotDate: date,
        quotRefno: reference,
        quotAgtId: salesId,
        quotAgtName: salesName,
        quotAgtTel: tel,
        quotYears: this.years,
        quotFinsuredName: name,
        quotFinsuredAge: age,
        quotFinsuredGender: gender,
        quotFinsuredSmoker: isSmoker,
        quotSinsuredName: client2Info.name,
        quotSinsuredAge: client2Info.age,
        quotSinsuredGender: client2Info.gender,
        quotSinsuredSmoker: client2Info.isSmoker,
        quotWinsuredName: client3Info.name,
        quotWinsuredAge: client3Info.age,
        quotWinsuredGender: client3Info.gender,
        quotWinsuredSmoker: client3Info.isSmoker
      }
      const res = await this.$api.insert(data)
      const quotNo = res.body.quotNo
      salesInfo.proposalId = quotNo

      this['proposal/SET_INFO']({
        salesInfo,
        client1Info,
        client2Info,
        client3Info
      })
      this.$emit('next')
    },
    goBack() {
      if (this.user !== '') {
        this.$router.push('/')
      } else {
        this.$router.push('/login')
      }
    },
    async getDetail() {
      const res = await this.$api.showquotdetail({ quotNo: this.$route.query.quotNo })
      var quotDetail = res.body.quotDetail
      this.years = quotDetail.quotYears
      // Step1
      const salesInfo = {
        proposalId: quotDetail.quotNo,
        date: quotDetail.quotDate,
        reference: quotDetail.quotRefno,
        salesId: quotDetail.quotAgtId,
        salesName: quotDetail.quotAgtName,
        tel: quotDetail.quotAgtTel
      }
      const client1Info = {
        name: quotDetail.quotFinsuredName,
        age: quotDetail.quotFinsuredAge,
        gender: quotDetail.quotFinsuredGender,
        isSmoker: quotDetail.quotFinsuredSmoker
      }
      const client2Info = {
        name: quotDetail.quotSinsuredName,
        age: quotDetail.quotSinsuredAge,
        gender: quotDetail.quotSinsuredGender,
        isSmoker: quotDetail.quotSinsuredSmoker
      }
      const client3Info = {
        name: quotDetail.quotWinsuredName,
        age: quotDetail.quotWinsuredAge,
        gender: quotDetail.quotWinsuredGender,
        isSmoker: quotDetail.quotWinsuredSmoker
      }
      if (this.$route.query.quotNo !== undefined) {
        this['proposal/SET_INFO']({
          salesInfo,
          client1Info,
          client2Info,
          client3Info
        })
      }
    }
  }
}
</script>
<style lang='scss'>
  .blueClient .v-card__title{
    background: #337ab7 !important;
  }
  .greenClient .v-card__title{
    background: #1ab394 !important;
  }
  .orangeClient .v-card__title {
    background: #f8ac59 !important;
  }
</style>
