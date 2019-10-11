// import Vue from 'vue'
import router from './index'
// import store from '@/store'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import { getUserInfo } from '@/utils/user' // get token from cookie
import getPageTitle from '@/utils/get-page-title'
import i18n from '../i18n'

NProgress.configure({ showSpinner: false }) // NProgress Configuration

const supportedLangs = ['zh-CN', 'en']
const whiteList = ['/login'] // no redirect whitelist
router.beforeEach(async(to, from, next) => {
  // start progress bar
  NProgress.start()

  // set page title
  document.title = getPageTitle(to.meta.title)

  // determine whether the user has logged in
  const hasToken = getUserInfo()

  if (hasToken) {
    next()
  } else {
    /* has no token*/

    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.beforeEach((to, from, next) => {
  const { locale } = to.query

  if (locale) {
    /* eslint-disable no-param-reassign */
    delete to.query.locale
    if (supportedLangs.includes(locale)) {
      i18n.locale = locale
      localStorage.setItem('VUE-ADMIN-VUETIFY_LANGUAGE', locale)
    }
  }

  next()
})
router.afterEach(() => {
  NProgress.done()
})
