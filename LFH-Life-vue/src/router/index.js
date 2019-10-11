import Vue from 'vue'
import Router from 'vue-router'
import routerConfig from './routerConfig'

const routerMap = []

const recursiveRouterConfig = (config = []) => {
  config.forEach(item => {
    const route = {
      path: item.path,
      name: item.layout ? '' : item.name,
      component: item.layout || item.component,
      meta: { ...item.meta },
      children: item.layout
        ? [
          {
            path: '',
            name: item.name,
            component: item.component,
            meta: { ...item.meta }
          }
        ]
        : []
    }
    // if (Array.isArray(item.children)) {
    //   recursiveRouterConfig(item.children)
    // }
    routerMap.push(route)
  })

  return routerMap
}

const routes = recursiveRouterConfig(routerConfig)

Vue.use(Router)

const router = new Router({
  base: process.env.BASE_URL,
  routes
})

export default router
