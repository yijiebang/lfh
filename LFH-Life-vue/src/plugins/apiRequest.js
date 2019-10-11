import Vue from 'vue'
import Axios from 'axios'
import store from '@/store'
import { getToken } from '@/utils/user'
import apiConf from '@/config/api'
import { baseUrl } from '@/config/app'
// console.log(process.env)
const service = Axios.create({
  baseURL: process.env.NODE_ENV !== 'production' ? baseUrl.dev : baseUrl.pro,
  headers: {
    'content-type': 'application/json;charset=utf-8'
  },
  timeout: 60000
})

/* eslint-disable no-param-reassign */
service.interceptors.request.use(
  request => {
    if (store.getters.token) {
      request.headers['X-Token'] = getToken()
    }
    return request
  },
  error => {
    console.warn(error)
    return Promise.reject(error)
  }
)

service.interceptors.response.use(
  response => response,
  error => {
    console.warn('err' + error) // for debug
    Vue.prototype.$message({
      text: '獲取數據超時',
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

function access(url, param, method) {
  param = param || {}
  let ret = null
  const upperMethod = method.toUpperCase()

  /* eslint-disable no-underscore-dangle */
  const __randNum = Math.random()

  if (upperMethod === 'POST') {
    ret = service.post(url, param, { params: { __randNum } })
  } else if (upperMethod === 'PUT') {
    ret = service.put(url, param, { params: { __randNum } })
  } else if (upperMethod === 'DELETE') {
    ret = service.delete(url, { params: { ...param, __randNum } })
  } else {
    ret = service.get(url, { params: { ...param, __randNum } })
  }

  return ret.then(res => {
    const { data: resData } = res
    if (resData.responseCode === 1000) {
      return resData
    } else {
      if (resData.responseCode === 5000) {
        store.dispatch('user/logout').then(() => {
          location.reload()
        })
      } else {
        // Vue.prototype.$message({
        //   text: resData.message || 'Error',
        //   type: 'error'
        // })
        return resData
      }
    }
    return res
  })
}

// 根据 api.config.js 配置往this上挂载对应的方法
export default new function getAPI() {
  const apiMap = apiConf
  Object.keys(apiMap).forEach(key => {
    const [url, method = 'post'] = apiMap[key]
    this[key] = params => access(url, params, method)
  })
}()
