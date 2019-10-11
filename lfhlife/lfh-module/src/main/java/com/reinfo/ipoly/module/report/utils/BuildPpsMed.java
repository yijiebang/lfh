package com.reinfo.ipoly.module.report.utils;

 import com.reinfo.ipoly.module.models.*;
import com.reinfo.ipoly.module.utils.Constants;
  import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class BuildPpsMed implements BuildPps {

    private static DecimalFormat dFormat = new DecimalFormat("#,##0.00");
    private static DecimalFormat iFormat = new DecimalFormat("#,##0");

    private IlfQuot quot;
    private List<QuotPlanDetail> planList;
    private QuotPlanDetail basicPlan;

    public BuildPpsMed(IlfQuot quot, List<QuotPlanDetail> planList) {
        this.quot = quot;
        this.planList = planList;
        initBasicPlan(); //initial Basic Plan
    }

    public IlfQuot getQuot() {
        return quot;
    }

    public void setQuot(IlfQuot quot) {
        this.quot = quot;
    }

    public List<QuotPlanDetail> getPlanList() {
        return planList;
    }

    public void setPlanList(List<QuotPlanDetail> planList) {
        this.planList = planList;
    }

    @Override
    public Pps buildPpsData() {
        // TODO Auto-generated method stub
        PpsMed pps = new PpsMed();
        pps.setTemplateName("pps" + quot.getQuotPlan().toLowerCase());

        pps.setSysVersion("v2019.09.10");
        pps.setAgentCode(StringUtils.isBlank(quot.getQuotAgtId()) ? "" : quot.getQuotAgtId() + "/ANG");//營業員註冊編號 :
        pps.setAgentName(quot.getQuotAgtName());//建議人
        pps.setAgentPhone(quot.getQuotAgtTel());//聯絡電話
        pps.setPpsNo(quot.getQuotNo());//建議書編號
        pps.setPpsRefNo(quot.getQuotRefno());//參考編號 :
        pps.setPpsDate(Date.from(quot.getQuotDate().toInstant()));//日期


        pps.setInsuredName(quot.getQuotFinsuredName());//被保人姓名
        pps.setInsuredAge(quot.getQuotFinsuredAge());//年齡
        pps.setInsuredGender("M".equals(quot.getQuotFinsuredGender()) ? "男" : "女");//性別
        pps.setInsuredSmoke("N".equals(quot.getQuotFinsuredSmoker()) ? "非吸烟" : "吸烟");//吸烟習慣


        pps.setBasicPlan(Constants.getProdCovLineMap2.get(quot.getQuotPlan()));//基本計劃名
        pps.setCcy(FunctionUtil.getCcyNameOth(quot.getQuotCcy()));//getCcyNameOth(quot.getQuotCcy()));//貨幣

        BigDecimal basAPm = new BigDecimal("0");
        BigDecimal totalMPm = new BigDecimal("0");

        for (QuotPlanDetail plan : planList) {
            String planInd = plan.getPlanInd();
            totalMPm = totalMPm.add(plan.getQuplanAnnPremium() == null ? new BigDecimal("0") : plan.getQuplanAnnPremium());
            if ("B".equalsIgnoreCase(planInd)) {
                 basAPm = plan.getQuplanAnnPremium();
            }
            if ("R".equalsIgnoreCase(planInd)) {
                String riderClass=plan.getQuplanRiderClass();//1=基本 2=優越 3=至
                pps.setHiPlan(FunctionUtil.getHiClassName(riderClass));
                pps.setHiSA("480");
                if(quot.getQuotCcy().equals("USD")) {
                    pps.setHiSA("60");
                }
                pps.setHiDays("730");

            }
        }

        pps.setBasAPm(dFormat.format(basAPm));//年繳保費


        LinkedList<Rider> riders = buildPpsRiderData();
        if (riders != null && riders.size() > 0) {
            pps.setRiders(riders);
            pps.setRidLab1("附加保障");
        } else {
            pps.setRidLab1("");
            pps.setRiders(FunctionUtil.buildPpsRiderNoData());
        }


        pps.setTotalMPmDesc("每年總保費");        pps.setTotalMPm(dFormat.format(totalMPm));
        pps.setTotalAPm(dFormat.format(quot.getQuotTotalPrem()));//總保額



        /***************************************************   PDF-保障摘要.   *******************************************************************/
        pps.setmPlan(FunctionUtil.getMplanName(quot.getQuotPlan().toLowerCase()));

        pps.setHs01SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs01SA"));
        pps.setHs02SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs02SA"));
        pps.setHs03SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs03SA"));
        pps.setHs04SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs04SA"));
        pps.setHs05SA1(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs05SA1"));
        pps.setHs05SA2(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs05SA2"));
        pps.setHs05SA3(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs05SA3"));
        pps.setHs05SA4(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs05SA4"));

        pps.setHs06SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs06SA")+"%");
        pps.setHs07SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs07SA")+"%");

        pps.setHs08SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs08SA"));
        pps.setHs09SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs09SA"));

        pps.setM10SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"m10SA"));
        pps.setM11SA(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"m11SA"));

        pps.setHs01D(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs01D"));
        pps.setHs02D(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs02D"));
        pps.setHs04D(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs04D"));
        pps.setHs09D(FunctionUtil.getValue(quot.getQuotPlan().toLowerCase(),quot.getQuotCcy(),"hs09D"));


       // pps.setPolvals(new LinkedList<Polval>());


        return pps;
    }


    private void initBasicPlan() {
        for (QuotPlanDetail plan : planList) {
            String planInd = plan.getPlanInd();
            if ("B".equalsIgnoreCase(planInd)) {
                setBasicPlan(plan);
                break;
            }
        }
    }

    /***
     * 如果選了附加類，有附加類，那麽肯定是HI,舊系統中固定的附加=hi
     * @return
     */
    @Override
    public LinkedList<Rider> buildPpsRiderData() {
        // TODO Auto-generated method stub
        LinkedList<Rider> riders = new LinkedList<>();
        if (planList != null && planList.size() > 1) {

            int i = 0;
            for (QuotPlanDetail plan : planList) {
                String planInd = plan.getPlanInd();
                if ("R".equalsIgnoreCase(planInd)) {
                    String tmpl = "";
                    RiderMed rider = new RiderMed();
                    rider.setRidLab1("附加保障");
                    rider.setRidLab2("");
                    rider.setRiderPlan(plan.getQuplanRiderCodeDesc()+" - "+FunctionUtil.getHiClassName(plan.getQuplanRiderClass()));
                    rider.setRidAPm(dFormat.format(plan.getQuplanAnnPremium()));

                     //med中附加類模板只有一個hi 所以可以直接給固定值
                    tmpl = plan.getQuplanRiderCode().toLowerCase() + "_template.docx";

                    rider.setRiderTemplate(tmpl);
                     riders.add(rider);
                    i = i++;
                }
            }
        }

        return riders;
    }

    @Override
    public LinkedList<Pol> buildPpsPolData() {
        return null;
    }

    @Override
    public LinkedList<Polval> buildPpsPolvalData() {
        return null;
    }




    public QuotPlanDetail getBasicPlan() {
        return basicPlan;
    }

    public void setBasicPlan(QuotPlanDetail basicPlan) {
        this.basicPlan = basicPlan;
    }






}


