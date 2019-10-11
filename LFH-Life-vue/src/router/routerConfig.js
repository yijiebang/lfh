import Layout from '@/layout/Layout'

const arr = [
  { path: '/login', name: 'Login', component: () => import('@/views/user/login'), meta: { title: '登錄' } },
  {
    path: '/password',
    name: 'Password',
    layout: Layout,
    component: () => import('@/views/user/password'),
    meta: { title: '修改密碼' }
  },
  {
    path: '/',
    name: 'ProposalList',
    layout: Layout,
    component: () => import('@/views/proposal/list'),
    meta: { title: '列表' }
  },
  {
    path: '/proposal/add',
    name: 'ProposalAdd',
    layout: Layout,
    component: () => import('@/views/proposal/add'),
    meta: { title: '新增' }
  },
  {
    path: '*',
    name: '404',
    layout: Layout,
    component: () => import(/* webpackChunkName: "ParkLotList" */ '@/views/error-page/404')
  }
]

export default arr
