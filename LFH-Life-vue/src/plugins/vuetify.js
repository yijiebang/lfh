/**
 * 本项目用了 vuetify-loader （在vue.config.js里配置）
 * 有一些注意事项 https://vuetifyjs.com/zh-Hans/framework/a-la-carte
 */
import Vue from 'vue'
import Vuetify from 'vuetify/lib'
import 'material-design-icons-iconfont'
import 'vuetify/src/stylus/app.styl'
// import 'vuetify/dist/vuetify.min.css'

import enLang from 'vuetify/es5/locale/en'
import zhLang from 'vuetify/es5/locale/zh-Hans'
import i18n from '../i18n'
import Snackbar from '../components/snackbar/index'

Vue.use(Vuetify, {
  lang: {
    locales: { enLang, zhLang },
    current: 'enLang'
  }
})

Vue.prototype.$message = Snackbar
const that = Vue.prototype
that.$locale = {
  use(lang) {
    i18n.locale = lang
    that.$vuetify.lang.current = lang === 'zh-CN' ? 'zhLang' : 'enLang'
    localStorage.setItem('VUE-ADMIN-VUETIFY_LANGUAGE', lang)
  },
  current() {
    return i18n.locale
  }
}
