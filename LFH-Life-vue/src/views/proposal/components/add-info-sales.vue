<template>
  <v-form ref="formInfoSales">
    <v-container fluid>
      <v-layout>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.proposalId" label="建議書編號" disabled />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.date" label="日期" disabled />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.reference" label="參考" :disabled="disabled" />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field
            v-model="formData.salesId"
            label="營業員註冊編號"
            :disabled="disabled"
            suffix=" /ANG"
          />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.salesName" label="營業員" :disabled="disabled" />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.tel" label="聯絡電話" :disabled="disabled" />
        </v-flex>
      </v-layout>
    </v-container>
  </v-form>
</template>
<script type = 'text/javascript'>

export default {
  name: 'ProposalAddInfoSales',
  props: {
    disabled: {
      type: Boolean,
      default: false
    },
    info: {
      type: Object,
      default: function() {
        return {}
      }
    }
  },
  data() {
    return {
      formData: {
        proposalId: '',
        date: '',
        reference: '',
        salesId: '',
        salesName: '',
        tel: ''
      },
      rules: {
        required: value => !!value || '請輸入'
      }
    }
  },
  watch: {
    info(val) {
      this.formData = { ...this.info }
      this.formData.date = this.formatterDate(new Date())
    }
  },
  created() {
    this.formData = { ...this.info }
    this.formData.date = this.formatterDate(new Date())
  },
  methods: {
    // 日期格式化
    formatterDate(date) {
      var year = date.getFullYear()
      var month = date.getMonth() + 1
      month = month < 10 ? '0' + month : month
      var day = date.getDate()
      day = day < 10 ? ('0' + day) : day
      return month + '/' + day + '/' + year
    },
    getData() {
      // const isPass = this.$refs.formInfoSales.validate()
      // return isPass ? { ...this.formData } : undefined
      return { ...this.formData }
    }
  }
}
</script>
<style lang='scss' scoped>
</style>
