package com.reinfo.ipoly.module.controllers;

import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.minlog.Log;
import com.reinfo.ipoly.common.config.SystemCode;
import com.reinfo.ipoly.common.exception.ApplicationException;
import com.reinfo.ipoly.common.mappers.common.Criteria;
import com.reinfo.ipoly.module.base.controllers.BaseWebController;
import com.reinfo.ipoly.module.mappers.ProdCovInitMapper;
import com.reinfo.ipoly.module.models.IlfQuotPlan;
import com.reinfo.ipoly.module.models.ProdCovClass;
import com.reinfo.ipoly.module.models.ProdCovTab;
import com.reinfo.ipoly.module.services.ProdCovClassService;
import com.reinfo.ipoly.module.services.ProdCovTabService;
import com.reinfo.ipoly.module.utils.Constants;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * <p>Title: ProdCovClassController</p>
 * <p>Description: 获得附加保险类别 </p>
 *
 * @author Jerry
 * @date 2019年8月21日
 */
@RestController
@RequestMapping(value = "prodCovClass")
public class ProdCovClassController extends BaseWebController {

    public static final Logger LOG = LoggerFactory.getLogger(ProdCovClassController.class);


    @Autowired
    ProdCovClassService prodCovClassService;

    @Autowired
    ProdCovTabService prodCovTabServic;

    @Autowired
    ProdCovInitMapper prodCovInitDao;

    /**
     * <p>Title: getAdditionalInsurance</p>
     * <p>Description:获得基本计划下的附加类别 </p>
     *
     * @param jsonObject
     * @return
     * @throws ApplicationException
     */
    @ResponseBody
    @RequestMapping(value = "getAdditionalInsurance.json")
    public Map<String, Object> getAdditionalInsurance(@RequestBody JSONObject jsonObject) throws ApplicationException {
        long starttimr = System.currentTimeMillis();

        String ccy = jsonObject.getString("ccy");
        String covCode = jsonObject.getString("covCode");
        String covCodeDisp = jsonObject.getString("covCodeDisp");
        String quplanNo = jsonObject.getString("quplanNo");

        List<IlfQuotPlan> list1 = prodCovInitDao.getIlfQuotPlanDQ(quplanNo, covCodeDisp);//定期
        List<IlfQuotPlan> list2 = prodCovInitDao.getIlfQuotPlanJB(quplanNo, covCodeDisp);//基本

        //获取付款人年龄、次被保人年龄、拟被保人年龄
        int subAge = 0;
        int age = 0;
        int payerAge = 0;
        age = jsonObject.getInteger("age");
        if (!StringUtil.isBlank(jsonObject.getString("subAge"))) {
            subAge = Integer.valueOf(jsonObject.getString("subAge"));
        }
        if (!StringUtil.isBlank(jsonObject.getString("payerAge"))) {
            payerAge = Integer.valueOf(jsonObject.getString("payerAge"));
        }
        boolean hflag = false;

        Map<String, List<ProdCovClass>> body = new LinkedHashMap<>();
        String message = "success";
        int code = 1000;

        if (StringUtil.isBlank(covCode)) {
            code = SystemCode.REQUEST_PARAMETER_FAILURE.getCode();
            message = SystemCode.REQUEST_PARAMETER_FAILURE.getMessage();
            Log.error("在入参中沒有取到covCode值");

            throw new ApplicationException(code, "{}[covCode:{}]", message, jsonObject);//直接抛出错误信息，不进行下面的操作
        }
        ProdCovTab tab = new ProdCovTab();
        tab.setCovCode(covCode);
        List<ProdCovTab> list = prodCovTabServic.getTabList(tab);//获得所有的保障及豁免

        List<ProdCovTab> listdw = new LinkedList<ProdCovTab>();//定期
        List<ProdCovTab> listwj = new LinkedList<ProdCovTab>();//危疾

        List<ProdCovTab> listB = new LinkedList<ProdCovTab>();//豁免
        List<ProdCovTab> listR = new LinkedList<ProdCovTab>();//定期豁免
        List<ProdCovTab> listY = new LinkedList<ProdCovTab>();//住院类型保障
        List<ProdCovTab> listN = new LinkedList<ProdCovTab>();//其他类型保障

        list.forEach((tblist) -> {     //jdk1.8新特性
            if ("N".equals(tblist.getClassInd())) {//class_ind='N'
                if ("".equals(tblist.getWpType())) {//危疾、定期
                    if ("LTR".equals(tblist.getProductLine())) {
                        listdw.add(tblist);

                    }else{
                        listwj.add(tblist);
                    }

                }
                if ("B".equals(tblist.getWpType())) {//豁免
                    listB.add(tblist);
                }
                if ("R".equals(tblist.getWpType())) {//定期豁免
                    listR.add(tblist);
                }

            } else {//class_ind='Y'   基本类型附加保障.有class
                if ("".equals(tblist.getWpType())) {
                    if("Y".equals(tblist.getMedInd())){//住院
                        listY.add(tblist);
                    }else{
                        listN.add(tblist);
                    }

                }
            }
        });

        //存放定期类型的map
        Map<String, List<ProdCovClass>> dwMap = getListDW(listdw, list1);
        if (!dwMap.isEmpty()) {
            body.putAll(dwMap);
        }


        //其他基本
        Map<String, List<ProdCovClass>> jbbzMap = getListY(listN, ccy, list2);
        if (!jbbzMap.isEmpty()) {
            body.putAll(jbbzMap);
        }
        //存放危急类型的map
        Map<String, List<ProdCovClass>> wjMap = getListDW(listwj, list1);
        if (!wjMap.isEmpty()) {
            body.putAll(wjMap);
        }
        //住院
        Map<String, List<ProdCovClass>> jbbyyyMap = getListY(listY, ccy, list2);
        if (!jbbyyyMap.isEmpty()) {
            body.putAll(jbbyyyMap);
        }

        //定期豁免
        Map<String, List<ProdCovClass>> dqhmMap = getListDWHM(listR, quplanNo, covCodeDisp);
        if (!dqhmMap.isEmpty()) {
            body.putAll(dqhmMap);
        }


        //存放豁免
        Map<String, List<ProdCovClass>> hmMap = getListB(listB, age, payerAge, quplanNo, covCodeDisp);
        if (!hmMap.isEmpty()) {
            hflag = true;
            body.putAll(hmMap);
        }

        ProdCovTab prodCovTab= prodCovInitDao.getProductLine(covCode);
        String suminput="";
        if(prodCovTab!=null){
              suminput= prodCovTab.getSumInd();
        }

        Map<String, Object> mapOUT = new LinkedHashMap<>();
        mapOUT.put("message", message);
        mapOUT.put("responseCode", code);
        mapOUT.put("hmflag", hflag);
        mapOUT.put("sumInd",suminput);//基本計劃是否有輸入框 I/N
        mapOUT.put("body", body);
        long endttimr = System.currentTimeMillis();
        long a = starttimr - endttimr;
        System.out.println("接口耗时:" + a + "(毫秒)");
        return mapOUT;
    }

    /*
         跟據等额定期的code查询等额定期的豁免
         T001>WT001
     */
    @ResponseBody
    @RequestMapping(value = "getExemption.json")
    public Map<String, Object> getExemption(@RequestBody JSONObject jsonObject) throws ApplicationException {

        String covCode = jsonObject.getString("covCode");
        String covCodeDEDQ = jsonObject.getString("covCodeDEDQ");

        if (!StringUtil.isBlank(jsonObject.getString("covCode"))) {
            covCode = jsonObject.getString("covCode");
        }
        if (!StringUtil.isBlank(jsonObject.getString("covCodeDEDQ"))) {
            covCodeDEDQ = jsonObject.getString("covCodeDEDQ");
        }
        String message = "success";
        int code = 1000;

        if (StringUtil.isBlank(covCode)) {
            code = SystemCode.REQUEST_PARAMETER_FAILURE.getCode();
            message = SystemCode.REQUEST_PARAMETER_FAILURE.getMessage();
            Log.error("在入参中沒有取到covCode值");

            throw new ApplicationException(code, "{}[covCode:{}]", message, jsonObject);//直接抛出错误信息，不进行下面的操作
        }
        ProdCovTab tab = new ProdCovTab();
        tab.setCovCode(covCode);
        tab.setProductLine("W" + covCodeDEDQ);//拼接 等额定期某个选项， T001 >WT001
        List<ProdCovTab> list = prodCovTabServic.getTabList(tab);//查询基本类型下面的某个类型
        List<ProdCovClass> dwMap = getListDWHMld(list);
        if (dwMap == null) {
            code = SystemCode.NO_DATA.getCode();
            message = SystemCode.NO_DATA.getMessage();
            throw new ApplicationException(code, "{}[covCode:{}]", message, jsonObject);//直接抛出错误信息，不进行下面的操作
        }

        Map<String, Object> mapOUT = new LinkedHashMap<>();
        mapOUT.put("message", message);
        mapOUT.put("responseCode", code);
        mapOUT.put("body", dwMap);
        return mapOUT;
    }


    /***
     * 得到定期和危疾
     * @param listdw
     * @return
     */
    public Map<String, List<ProdCovClass>> getListDW(List<ProdCovTab> listdw, List<IlfQuotPlan> list1) {
        Map<String, String> prodCovLineMap = Constants.getProdCovLineMap;

        Map<String, List<ProdCovClass>> dwMap = new LinkedHashMap<String, List<ProdCovClass>>();

        for (ProdCovTab tablistdw : listdw) {
            String name = prodCovLineMap.get(tablistdw.getProductLine());
            if (name == null) {
                break;
            }
            ProdCovClass hmbf = new ProdCovClass();
            hmbf.setCovCode(tablistdw.getCovCode());
            hmbf.setCovClass(tablistdw.getCovCode());
            hmbf.setClassNameOth(tablistdw.getCovNameOth());
            hmbf.setCovNameOth(name);
            hmbf.setShowSumInsured("Y");
            hmbf.setDefaultval("Y");
            hmbf.setCovTermRiderInd("Y");
            if (list1 != null) {
                list1.forEach((p) -> {
                    if (("LTR".equals(p.getProduct_line()) || "DD".equals(p.getProduct_line())) && tablistdw.getCovCode().equals(p.getQuplanRiderCode())) {//危急/定期
                        hmbf.setSelected(true);//默認值，選中了
                        hmbf.setInputPremium(p.getQuplanSumInsured());
                        hmbf.setSumPremium(p.getQuplanAnnPremium());
                    }
                });
            }
            if (dwMap.containsKey(tablistdw.getProductLine())) {
                List<ProdCovClass> list2 = dwMap.get(tablistdw.getProductLine());
                list2.add(hmbf);
                dwMap.put(tablistdw.getProductLine(), list2);
            } else {
                List<ProdCovClass> list2 = new ArrayList<>();
                list2.add(hmbf);
                dwMap.put(tablistdw.getProductLine(), list2);
            }
        }
        return dwMap;
    }

    /**
     * 得到基本附加保障
     *
     * @param listY
     * @param ccy
     * @return
     */
    public Map<String, List<ProdCovClass>> getListY(List<ProdCovTab> listY, String ccy, List<IlfQuotPlan> list2) {
        Map<String, List<ProdCovClass>> jbbzMap = new LinkedHashMap<String, List<ProdCovClass>>();
        List<ProdCovClass> c = new ArrayList<>();
        for (ProdCovTab p : listY) {
            c = prodCovClassService
                    .getDataBy(new Criteria().addWhere(ProdCovClass.DBStrCovCode, p.getCovCode())
                            .addWhere(ProdCovClass.DBStrCcy + "='" + ccy + "' or " + ProdCovClass.DBStrCcy + " = '*'", new Object[]{" ", ""}).addAscOrder(ProdCovClass.DBStrCovClass));
            if (c.size() > 0) {//没有下拉框的值，界面不显示

                for (ProdCovClass c2 : c) {
                    if (list2 != null) {

                        for (IlfQuotPlan p2 : list2) {
                            System.out.println(c2.getCovCode() + " / " + p2.getQuplanRiderCode() + " / " + c2.getCovClass() + " / " + p2.getQuplanRiderClass());
                            if (c2.getCovCode().equals(p2.getQuplanRiderCode()) && c2.getCovClass().equals(p2.getQuplanRiderClass())) {//

                                c2.setSelected(true);//默認值，選中了
                                c2.setInputPremium(p2.getQuplanSumInsured());
                                c2.setSumPremium(p2.getQuplanAnnPremium());
                                break;
                            }
                        }
                    }
                    if ("I".equals(p.getSumInd())) {//根据prod_tab表数据的sum_ind字段判断是否有输入框
                        c2.setShowSumInsured("Y");
                    } else {//没有输入框
                        c2.setShowSumInsured("N");
                    }
                    c2.setCovTermRiderInd("N");

                }
                jbbzMap.put(p.getCovCode(), c);
            }
        }
        return jbbzMap;
    }

    /**
     * 得到豁免保费保障的数据,类型：基本豁免/付款人豁免
     *
     * @param listB
     * @param age
     * @param payerAge
     * @return
     */
    public Map<String, List<ProdCovClass>> getListB(List<ProdCovTab> listB, int age, int payerAge, String quplanNo, String covCodeDisp) {
        Map<String, List<ProdCovClass>> hmMap = new LinkedHashMap<String, List<ProdCovClass>>();
        listB.forEach((p) -> {

            List<ProdCovClass> c = new ArrayList<ProdCovClass>();
            int flag = hmFlag(age, payerAge);//计算豁免范围 0=无豁免，1=付款人豁免 2=基本-豁免

            if (flag == 1) { //付款人豁免
                if ("PB".equals(p.getProductLine())) {//付款人豁免
                    ProdCovClass hmbf = new ProdCovClass();
                    hmbf.setCovCode(p.getCovCode());
                    hmbf.setCovClass("*");
                    hmbf.setClassNameOth(p.getCovNameOth());
                    hmbf.setCovNameOth("付款者豁免保費");
                    hmbf.setShowSumInsured("W");//豁免，前端用于做显示隐藏
                    hmbf.setCovTermRiderInd("N");

                    List<IlfQuotPlan> list3 = prodCovInitDao.getIlfQuotPlanhm(quplanNo, covCodeDisp, "PB");//基本豁免

                    if (list3 != null) {
                        list3.forEach((p2) -> {
                            if (p.getCovCode().equals(p2.getQuplanRiderCode())) {
                                hmbf.setSelected(true);
                                hmbf.setSumPremium(p2.getQuplanAnnPremium());
                            }
                        });
                    }
                    c.add(hmbf);
                    hmMap.put(p.getCovCode(), c);
                }
            } else if (flag == 2) {     //基本豁免
                List<IlfQuotPlan> list3 = prodCovInitDao.getIlfQuotPlanhm(quplanNo, covCodeDisp, "WP");//基本豁免

                if ("WP".equals(p.getProductLine())) {//豁免保费
                    ProdCovClass hmbf = new ProdCovClass();
                    hmbf.setCovCode(p.getCovCode());
                    hmbf.setCovClass("*");
                    hmbf.setClassNameOth(p.getCovNameOth());
                    hmbf.setCovNameOth("豁免保费 - 基本");
                    hmbf.setShowSumInsured("W");//豁免，前端用于做显示隐藏
                    hmbf.setCovTermRiderInd("N");
                    if (list3 != null) {
                        list3.forEach((p2) -> {
                            if (p.getCovCode().equals(p2.getQuplanRiderCode())) {
                                hmbf.setSelected(true);
                                hmbf.setSumPremium(p2.getQuplanAnnPremium());
                            }
                        });
                    }
                    c.add(hmbf);
                    hmMap.put(p.getCovCode(), c);
                }

            } else {//没有豁免
                hmMap.put(p.getCovCode(), c);
            }
        });
        return hmMap;
    }

    /***
     * 得到定期和危疾
     * @param listR
     * @return
     */
    public Map<String, List<ProdCovClass>> getListDWHM(List<ProdCovTab> listR, String quplanNo, String covCodeDisp) {
        Map<String, List<ProdCovClass>> DQhmMap = new LinkedHashMap<String, List<ProdCovClass>>();
        List<ProdCovClass> c = new ArrayList<ProdCovClass>();
        listR.forEach((tablistdw) -> {
            ProdCovClass hmbf = new ProdCovClass();
            hmbf.setCovCode(tablistdw.getCovCode());
            hmbf.setCovClass(tablistdw.getCovCode());
            hmbf.setClassNameOth(tablistdw.getCovNameOth());
            hmbf.setCovNameOth("豁免保費 - 定期 ");
            hmbf.setShowSumInsured("F");
            hmbf.setDefaultval("Y");//CLASS="*"
            hmbf.setCovTermRiderInd("Y");
            List<IlfQuotPlan> list3 = prodCovInitDao.getIlfQuotPlanhm(quplanNo, covCodeDisp, "WP");//
            if (list3 != null) {
                list3.forEach((p2) -> {
                    if (tablistdw.getCovCode().equals(p2.getQuplanRiderCode())) {
                        hmbf.setSelected(true);
                        hmbf.setSumPremium(p2.getQuplanAnnPremium());
                    }
                });
            }
            c.add(hmbf);
        });

        DQhmMap.put("LTR-T", c);
        return DQhmMap;
    }

    /***
     * 聯動
     * 得到定期
     * @param listR
     * @return
     */
    public List<ProdCovClass> getListDWHMld(List<ProdCovTab> listR) {
        Map<String, List<ProdCovClass>> DQhmMap = new LinkedHashMap<String, List<ProdCovClass>>();
        List<ProdCovClass> c = new ArrayList<ProdCovClass>();
        listR.forEach((tablistdw) -> {
            ProdCovClass hmbf = new ProdCovClass();
            hmbf.setCovCode(tablistdw.getCovCode());
            hmbf.setCovClass(tablistdw.getCovCode());
            hmbf.setClassNameOth(tablistdw.getCovNameOth());
            hmbf.setCovNameOth("豁免保費 - 定期 ");
            hmbf.setShowSumInsured("W");
            hmbf.setDefaultval("Y");//CLASS="*"
            hmbf.setCovTermRiderInd("Y");
            c.add(hmbf);
        });
        return c;
    }

    /**
     * 跟據年龄判断是否拥有豁免权
     *
     * @param age
     * @param payerAge
     * @return
     */
    public int hmFlag(int age, int payerAge) {
        LOG.info("拟被保人年龄age = " + age + " , 付款人年龄payAge = " + payerAge);
        int i = 0;

        if (age < 18 && (payerAge >= 18 && payerAge <= 55)) {//拟被保人年龄在18岁以下，而且付款人年龄在18-55之间，是付款人豁免
            i = 1;
            LOG.info("范围:付款人豁免  |-//-|  age<18 && (payerAge>=18 && payerAge<=55");
        }
        if (age >= 18) {//拟被保人年龄在18岁以上 那么都是基本豁免
            i = 2;
            LOG.info("范围:基本豁免  |-//-|  age>=18");

        }
        if (age < 18 && (payerAge < 18 || payerAge > 55)) {//拟被保人年龄在18岁以下，而且付款人年龄小于18或者大于55之间，是没有豁免
            i = 0;
            LOG.info("范围:没有豁免  |-//-|  age<18 && (payerAge<18 || payerAge > 55");

        }

        return i;
    }

    /**
     * 格式化金额，分隔符千
     * @param bd
     * @return
     */
    public static String parseNumber(BigDecimal bd) {
        String pattern=  "###,###.00";
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(bd);
    }

    public static void main(String[] args) {
       System.out.println(parseNumber(new BigDecimal(2020.01)));
    }

}

/******sql
 *
 select order_seq,tb1.class_ind,tb1.wp_type,tb1.cov_code,tb1.cov_name_oth,tb1.product_line
 from  prod_cov_tab tb1
 where  exists
 (select * from  prod_cov_rid r1 where r1.cov_code='1001' and r1.rid_code=tb1.cov_code) order by class_ind,wp_type,order_seq
 ********/