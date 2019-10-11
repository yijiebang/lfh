const state = {
  currentStep: 1, // 当前是第几步
  previewed: false, // 是否預覽
  salesInfo: {
    salesId: '',
    salesName: '',
    proposalId: '',
    tel: '',
    reference: '',
    date: new Date()
  },
  client1Info: {
    name: '',
    age: '',
    gender: 'M',
    isSmoker: 'N'
  },
  client2Info: {
    name: '',
    age: '',
    gender: '',
    isSmoker: ''
  },
  client3Info: {
    name: '',
    age: '',
    gender: '',
    isSmoker: ''
  },
  plan: {
    plan: '',
    planName: '',
    year: '',
    yearName: ' ',
    money: '',
    payType: '',
    bonusType: 1,
    basePlan: 0.0000,
    wppb: 1.0
  },
  planDetail: {}
}

const copyState = deepClone(state)

function deepClone(obj) {
  const newObj = obj instanceof Array ? [] : {}
  for (const i in obj) {
    newObj[i] = typeof obj[i] === 'object' ? deepClone(obj[i]) : obj[i]
  }
  return newObj
}

const mutations = {
  // 更新步骤
  UPDATE_STEP: (state, step) => {
    state.currentStep = step
  },
  // 更新是否预览过的状态
  UPDATE_PREVIEWED: (state, previewed) => {
    state.previewed = previewed
  },
  // 设置客户信息
  SET_INFO: (state, { salesInfo, client1Info, client2Info, client3Info }) => {
    if (salesInfo) {
      state.salesInfo = { ...salesInfo }
    }
    if (client1Info) {
      state.client1Info = { ...client1Info }
    }
    if (client2Info) {
      state.client2Info = { ...client2Info }
    }
    if (client3Info) {
      state.client3Info = { ...client3Info }
    }
  },
  // 设置计划
  SET_PLAN: (state, plan) => {
    state.plan = { ...plan }
  },
  // 设置计划详情
  SET_PLAN_DETAIL: (state, planDetail) => {
    state.planDetail = { ...planDetail }
  },
  // 清理所有数据
  RESET_STATE: (state) => {
    for (var i in copyState) {
      state[i] = copyState[i]
    }
  }
}

const actions = {}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
