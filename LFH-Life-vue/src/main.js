import Vue from 'vue'
import App from './App.vue'
import router from './router'

import i18n from './i18n'

import '@/styles/common.scss'
import '@/styles/transition.scss'
import '@/styles/layout.scss'

import apiRequest from './plugins/apiRequest'
import './plugins/vuetify'
import './router/permission'

import './components/svg-icon'

Vue.prototype.$api = apiRequest

import store from './store'

const supportedLangs = ['zh-CN', 'en']
const userLocale = navigator.language || navigator.userLanguage

i18n.locale = localStorage.getItem('VUE-ADMIN-VUETIFY_LANGUAGE') || (supportedLangs.includes(userLocale) ? userLocale : 'zh-CN')
Vue.prototype.$locale.use(i18n.locale)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  i18n,
  render: h => h(App)
}).$mount('#app')
