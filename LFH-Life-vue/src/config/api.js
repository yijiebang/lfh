/**
 * api相关配置
 *  key: 定义方法名，在组件内通过 this.$api[key](params) 来调用
 *  value: 定义接口地址。如果为String类型则是post请求 ，Array: 第一项是接口地址, 第二项是method
 */
module.exports = {
  // user
  login: ['/login/login.json', 'post'],
  logout: ['/user/logout', 'post'],
  getInfo: ['/user/info'],
  authority: ['/login/authority.json', 'post'],
  updatePwd: ['/login/updatepwd.json', 'post'],
  // proposal
  proposalList: ['/proposal/list', 'get'],
  proposalAdd: ['/proposal/add', 'post'],
  proposalDetail: ['/proposal/detail', 'post'],
  showformtablelist: ['/quotations/showformtablelist.json', 'post'],
  prodCovLineList: ['/prodCovLine/showlinelist.json', 'post'],
  countryCcyList: ['/prodCovLine/showccylist.json', 'post'],
  payModeList: ['/prodCovLine/showpaymodelist.json', 'post'],
  productList: ['/prodCovLine/showproductlist.json', 'post'],
  insuredamount: ['/calculation/insuredamount.json', 'post'],
  getSumPremium: ['/prodPremRate/getSumPremium.json', 'post'],
  getAdditionalInsurance: ['/prodCovClass/getAdditionalInsurance.json', 'post'],
  premiumamount: ['/calculation/premiumamount.json', 'post'],
  insert: ['/quotations/insertdata.json', 'post'],
  insertPlan: ['/quotations/insertplan.json', 'post'],
  getQuotationList: ['/quotations/getQuotationList.json', 'post'],
  getRemitList: ['/prodCovClass/getExemption.json', 'post'],
  showquotdetail: ['/quotations/showquotdetail.json', 'post'],
  downLoad: ['/mailMerge/proposalDownload.json', 'post'],
  editInsured: ['/quotations/editinsured.json', 'post']
}
