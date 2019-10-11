<template>
  <v-data-table
    :headers="headers"
    :items="items"
    :total-items="total"
    disable-initial-sort
    class="elevation-1"
    @update:pagination="val => $emit('page-change', val)"
  >
    <template v-slot:items="{ item }" v-slot:scope="item">
      <tr @dblclick="openDetail(item)">
        <td>{{ item.quotNo }}</td>
        <td>{{ item.quotFinsuredName }}</td>
        <td>{{ item.quotRefno }}</td>
        <td>{{ item.quotDate }}</td>
        <td>{{ }}</td>
        <td>{{ }}</td>
      </tr>
    </template>
  </v-data-table>
</template>
<script type = 'text/javascript'>
export default {
  name: 'ProposalListTable',
  props: {
    items: {
      type: Array,
      required: true
    },
    total: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      headers: [
        { text: '建議書編號', value: 'quotNo' },
        { text: '擬被保人姓名', value: 'quotFinsuredName' },
        { text: '參考', value: 'quotRefno' },
        { text: '日期', value: 'quotDate' },
        { text: '保單號碼', value: '' },
        { text: '簽發日期', value: 'quotDate' }
      ]
    }
  },
  computed: {},
  created() {},
  methods: {
    changeHandler() {
      this.$emit('change')
    },
    openDetail(row) {
      console.log(row)
      this.$router.push({path: '/proposal/add', query: {quotNo: row.quotNo, detail: true}})
    }
  }
}
</script>
<style lang='scss' scoped>
</style>
