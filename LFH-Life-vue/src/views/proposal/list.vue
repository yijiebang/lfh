<template>
  <div>
    <list-form @submit="val => getList(val)" />
    <list-table :items="items" :total="total" @page-change="pageChange" />
  </div>
</template>
<script type='text/javascript'>
import { mapState, mapMutations } from 'vuex'
import ListForm from './components/list-form'
import ListTable from './components/list-table'
export default {
  name: '',
  components: {
    ListForm,
    ListTable
  },
  data() {
    return {
      page: 1,
      total: 0,
      limit: 10,
      items: []
    }
  },
  computed: {
    ...mapState({
      user: state => state.user.info
    })
  },
  created() {
    this.getList()
    this.authority()
  },
  methods: {
    ...mapMutations(['user/SET_INFO']),
    pageChange({ rowsPerPage: limit, page }) {
      this.limit = limit
      this.page = page
      // this.getList()
    },
    async getList(searchVal) {
      const { page, limit } = this
      const data = {
        currentPageNo: page,
        pageSize: limit,
        ...searchVal
      }
      const res = await this.$api.showformtablelist(data)
      this.items = res.body.tabList
    },
    async authority() {
      var str = location.href // 取得整个地址栏
      var num = str.indexOf('?')
      str = str.substr(num + 1) // 取得所有参数   stringvar.substr(start [, length ]
      const res = await this.$api.authority()
      if (res.responseCode !== 1000) {
        if (str !== 'lpuid=bank001') {
          this.$router.push('/404')
        } else {
          this['user/SET_INFO']('')
        }
      } else {
        this['user/SET_INFO'](res.body.loginUsername)
      }
    }
  }
}
</script>
<style lang='scss' scoped>
</style>
