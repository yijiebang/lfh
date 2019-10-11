module.exports = {
  /**
   * @description 配置显示在浏览器标签的title
   */
  title: '保险管理后台',
  /**
   * @description token在Cookie中存储的天数，默认1天
   */
  cookieExpires: 1,
  /**
   * @description api请求
   */

  baseUrl: {
    dev: 'http://localhost:8899/lfh',
    pro: 'http://share.tpddns.cn:8899/lfh'
  },
  /**
   * @description 默认打开的首页的路由name值，默认为home
   */
  homeName: 'ProposalList'
}
