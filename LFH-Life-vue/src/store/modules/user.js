// import Vue from 'vue'
import router from '@/router'
import { setUserInfo, removeUserInfo } from '@/utils/user'

import api from '@/plugins/apiRequest'
import { homeName } from '@/config/app'

const state = {
  info: ''
}

const mutations = {
  SET_INFO: (state, info) => {
    state.info = info
  }
}

const actions = {
  // user login
  login({ commit }, req) {
    commit('SET_INFO', {
      roles: ['admin'],
      introduction: 'I am a super administrator',
      avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
      name: 'Super Admin'
    })
    router.replace({ name: homeName })
    // return new Promise((resolve, reject) => {
    //   api.login(req).then(response => {
    //     commit('SET_INFO', response)
    //     setUserInfo(response)
    //     router.replace({ name: homeName })
    //     resolve()
    //   })
    // })
  },
  // get user info
  getInfo({ commit, state }) {
    return new Promise((resolve, reject) => {
      api
        .getInfo()
        .then(response => {
          if (!response) {
            reject('Verification failed, please Login again.')
          }
          const userInfo = response.data
          commit('SET_INFO', userInfo)
          setUserInfo(response)
          resolve(response)
        })
        .catch(error => {
          reject(error)
        })
    })
  },

  // user logout
  logout({ commit, state }) {
    commit('SET_INFO', {})
    removeUserInfo()
    router.push('/login')
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
