import Mock from 'mockjs'
import api from '../src/config/api'

const data = Mock.mock({
  'items|100': [
    {
      id: '@id',
      salesId: '@natural(100000, 999999)', // 销售id
      salesName: '@name', // 销售姓名
      'plan|1': ['plan-1', 'plan-2', 'plan-3', 'plan-4'], // 计划
      proposalId: '@natural(100000, 999999)', // 建议书编号
      insuredName: '@name', // 被保人姓名
      'reference|1': ['reference-1', 'reference-2', 'reference-3', 'reference-4'], // 参考
      date: '@now(second)', // 日期
      policyNum: '@natural(100000, 999999)', // 保单号码
      createDate: '@now(second)' // 签发日期≠
    }
  ]
})
console.log(api.getAdditionalInsurance)

export default [
  {
    url: api.proposalList[0],
    type: api.proposalList[1],
    response: config => {
      let { page, limit } = config.query
      page = Number(page)
      limit = Number(limit)
      const start = (page - 1) * limit
      const items = data.items
      // if (keyword) {
      //   items = items.filter(item => item.name.indexOf(keyword) > -1)
      // }
      console.log(start, start + limit)
      return {
        code: 1000,
        data: {
          total: items.length,
          list: items.slice(start, start + limit)
        }
      }
    }
  },
  {
    url: api.getAdditionalInsurance[0],
    type: api.getAdditionalInsurance[1],
    response: config => {
      return require('./list.json')
    }
  }
]
