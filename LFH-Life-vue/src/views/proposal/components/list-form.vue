<template>
  <v-form>
    <v-container fluid pt-0>
      <v-layout>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.quotAgtId" label="營業員註冊編號" clearable prepend-icon="toc" hide-details />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.quotAgtName" label="營業員" clearable prepend-icon="work" hide-details />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.quotPlan" label="基本計劃" clearable prepend-icon="receipt" hide-details />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.quotNo" label="建議書編號" clearable prepend-icon="toc" hide-details />
        </v-flex>
      </v-layout>
      <v-layout>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.quotFinsuredName" label="擬被保人姓名" clearable prepend-icon="person" hide-details />
        </v-flex>
        <v-flex xs12 md3>
          <v-text-field v-model="formData.quotRefno" label="參考" clearable prepend-icon="youtube_searched_for" hide-details />
        </v-flex>
        <v-flex xs12 md3>
          <v-menu v-model="datePickerShow" :close-on-content-click="false" :nudge-right="4" offset-y min-width="290px">
            <template v-slot:activator="{ on }">
              <v-text-field v-model="formData.quotDateStr" label="日期" prepend-icon="event" clearable readonly hide-details v-on="on" />
            </template>
            <v-date-picker v-model="formData.quotDateStr" locale :first-day-of-week="1" no-title @input="datePickerShow = false" />
          </v-menu>
        </v-flex>
        <v-flex xs12 md3>
          <v-btn style="background: #f0ad4e;color: #fff;" @click="search"> <v-icon>search</v-icon> 搜索</v-btn>
          <v-btn style="background: #52a5b5;color: #fff;" :to="{ name: 'ProposalAdd' }"><v-icon>add</v-icon>新增</v-btn>
        </v-flex>
      </v-layout>
    </v-container>
  </v-form>
</template>
<script type = 'text/javascript'>
export default {
  name: 'HomeForm',
  data: () => ({
    formData: {
      quotAgtId: '',
      quotFinsuredName: '',
      quotPlan: '',
      quotNo: '',
      quotAgtName: '',
      quotRefno: '',
      quotDate: ''
    },
    datePickerShow: false
  }),
  computed: {},
  created() {},
  methods: {
    search() {
      this.$emit('submit', { ...this.formData })
    }
  }
}
</script>
<style lang='scss' scoped>
</style>
