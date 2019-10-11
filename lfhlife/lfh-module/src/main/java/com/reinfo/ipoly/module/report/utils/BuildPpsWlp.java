package com.reinfo.ipoly.module.report.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import com.reinfo.ipoly.module.models.IlfQuot;
import com.reinfo.ipoly.module.models.Pol;
import com.reinfo.ipoly.module.models.Polval;
import com.reinfo.ipoly.module.models.PolvalWlp;
import com.reinfo.ipoly.module.models.Pps;
import com.reinfo.ipoly.module.models.PpsWlp;
import com.reinfo.ipoly.module.models.QuotPlanDetail;
import com.reinfo.ipoly.module.models.Rider;
import com.reinfo.ipoly.module.models.RiderWlp;
import com.reinfo.ipoly.module.utils.Constants;
import com.reinfo.ipoly.module.utils.*;

public class BuildPpsWlp implements BuildPps {

	private static DecimalFormat dFormat = new DecimalFormat("#,##0.00");
	private static DecimalFormat iFormat = new DecimalFormat("#,##0");
	private IlfQuot quot;
	
	private List<QuotPlanDetail> planList;
	
	private QuotPlanDetail basicPlan;
	
	public BuildPpsWlp (IlfQuot quot, List<QuotPlanDetail> planList){
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
		PpsWlp pps = new PpsWlp();
    	pps.setSysVersion("v2019.09.10");
		pps.setTemplateName("pps"+quot.getQuotPlan().toLowerCase());
    	pps.setPpsNo(quot.getQuotNo());//建議書編號
		pps.setPpsRefNo(quot.getQuotRefno());//參考編號 :
		pps.setPpsDate(Date.from(quot.getQuotDate().toInstant()));//日期
		pps.setAgentCode(StringUtils.isBlank(quot.getQuotAgtId())?"":quot.getQuotAgtId()+"/ANG");//營業員註冊編號 :
    	pps.setAgentName(quot.getQuotAgtName());//建議人
    	pps.setAgentPhone(quot.getQuotAgtTel());//聯絡電話

    	pps.setInsuredName(quot.getQuotFinsuredName());//被保人姓名
    	pps.setInsuredAge(quot.getQuotFinsuredAge());//年齡
    	pps.setInsuredGender("M".equals(quot.getQuotFinsuredGender())?"男":"女");//性別
    	pps.setInsuredSmoke("N".equals(quot.getQuotFinsuredSmoker())?"非吸烟":"吸烟");//吸烟習慣

		//pps.setPayMode(getPayMode(quot.getQuotPaymode()));//繳費模式
		pps.setPolLvlP("是");//均衡式保费
		pps.setPolGrtRt("是");//保证费率
		pps.setBasicPlan(Constants.getProdCovLineMap2.get(quot.getQuotPlan()));//基本計劃名
    	pps.setCcy(quot.getQuotCcy());//getCcyNameOth(quot.getQuotCcy()));//貨幣
    	pps.setTotalAPm(dFormat.format(quot.getQuotTotalPrem()));
    	
    	int surTill = 65;
    	int age = quot.getQuotFinsuredAge();
    	if(age>50 && age<=60){
    		surTill = 70;
    	}else if(age>60){
    		surTill = 80;
    	}
    	int numYear = surTill - age;
    	pps.setAtAge(surTill);
    	pps.setAtAgeTotal(0);    	
    	
    	String ccy = quot.getQuotCcy();
    	if(ccy.equalsIgnoreCase("USD")){
    		pps.setIntRateL("4.26%");
    		pps.setIntRateH("5.66%");
    	}else{ //MOP & HKD
    		pps.setIntRateL("3.51%");
    		pps.setIntRateH("4.91%");
    	}
    	
		LinkedList<Rider> riders = buildPpsRiderData();
		if(riders!=null && riders.size()>0){
			pps.setRiders(riders);
			pps.setRidLab1("附加保障");
		}else{
			pps.setRiders(new LinkedList<Rider>());
		}
		
		int basicSA = 0;
		BigDecimal basAPm = new BigDecimal("0");
		BigDecimal totalMPm = new BigDecimal("0");
		BigDecimal riderSuminsured = new BigDecimal("0");
		String productLine = "";
		String productType = "";
		pps.setBasicWithWpPB("");
        pps.setWpPbPlan("");
        pps.setWpPbDesc("");
        pps.setPolMTm(100-age);//保障年期
		for(QuotPlanDetail plan: planList){
			String planInd = plan.getPlanInd();
			totalMPm = totalMPm.add(plan.getQuplanAnnPremium()==null?new BigDecimal("0"):plan.getQuplanAnnPremium());
			if("B".equalsIgnoreCase(planInd)){
				basicSA = plan.getQuplanSumInsured().intValue();
				basAPm = plan.getQuplanAnnPremium();
			}else{
				productType = plan.getProductType();
				if(productType!=null){
					if(productType.equalsIgnoreCase("BASIC_PLAN_WAIVER_OF_PREMIUM")){				
						pps.setBasicWithWpPB(WlpConstant.BASIC_WITH_WP);
						pps.setWpPbPlan(WlpConstant.WAIVER_OF_PREMIUM_PROTECTION);
						pps.setWpPbDesc(WlpConstant.WP_DESC);//. doc.otherConfig.wpDesc;
					}else if (productType.equalsIgnoreCase("PAYER_BENEFIT")){
						pps.setBasicWithWpPB(WlpConstant.BASIC_WITH_PB);//doc.otherConfig.basicWithPb;
                        pps.setWpPbPlan(WlpConstant.PAYER_BENEFIT_PROTECTION);
                        pps.setWpPbDesc(WlpConstant.PB_DESC);// = doc.otherConfig.pbDesc;
					}
				}
				
				productLine = plan.getProductLine();				
				if(productLine!=null && productLine.equalsIgnoreCase("ai")){
					riderSuminsured = plan.getQuplanSumInsured()==null?new BigDecimal("0"):plan.getQuplanSumInsured();
					pps.setAiSA(   dFormat.format(riderSuminsured.multiply(new BigDecimal("1")).setScale(0)));
					pps.setAi105SA(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.01")).setScale(0)));
					pps.setAi106SA(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.0025")).setScale(0)));
					pps.setAi107SA(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.01")).setScale(0)));
					pps.setAi108SA(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.01")).setScale(0)));
					pps.setAi109SA1(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.03")).setScale(0)));
					pps.setAi109SA2(dFormat.format(new BigDecimal("1000")));//
					pps.setAi109SA3("0.5%");//
					pps.setAi305SA1(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.25")).setScale(0)));
					pps.setAi305SA2(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.75")).setScale(0)));
					pps.setAi306SA( dFormat.format(riderSuminsured.multiply(new BigDecimal("0.3")).setScale(0)));
					pps.setAi307SA1(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.5")).setScale(0)));
					pps.setAi307SA2(dFormat.format(riderSuminsured.multiply(new BigDecimal("1")).setScale(0)));
					pps.setAi308SA1(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.7")).setScale(0)));
					pps.setAi308SA2(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.5")).setScale(0)));
					pps.setAi309SA1(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.4")).setScale(0)));
					pps.setAi309SA2(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.3")).setScale(0)));
					pps.setAi310SA11(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.3")).setScale(0)));
					pps.setAi310SA12(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.2")).setScale(0)));
					pps.setAi310SA21(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.15")).setScale(0)));
					pps.setAi310SA22(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.1")).setScale(0)));
					pps.setAi311SA11(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.1")).setScale(0)));
					pps.setAi311SA12(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.075")).setScale(0)));
					pps.setAi311SA21(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.075")).setScale(0)));
					pps.setAi311SA22(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.05")).setScale(0)));
					pps.setAi311SA31(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.05")).setScale(0)));
					pps.setAi311SA32(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.02")).setScale(0)));
					pps.setAi312SA1(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.15")).setScale(0)));
					pps.setAi312SA2(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.05")).setScale(0)));
					pps.setAi312SA3(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.03")).setScale(0)));
					pps.setAi313SA(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.1")).setScale(0)));
					pps.setAi314SA(dFormat.format(riderSuminsured.multiply(new BigDecimal("0.075")).setScale(0)));
					
				}
			}
		}
		
		pps.setWpPbLab(WlpConstant.RIDER);
		pps.setBasMPm(iFormat.format(basicSA));//保费摘要
		pps.setPayMode(getPaymode(quot.getQuotPaymode()));
		pps.setBasicSA(iFormat.format(basicSA));
		pps.setBasAPm(dFormat.format(basAPm));
		pps.setTotalMPm(dFormat.format(totalMPm));
		pps.setTotalMPmDesc("每年總保費");		
		pps.setBasAnzedPm(dFormat.format(basAPm));
 		LinkedList<Pol> pols = buildPpsPolData();
		if(pols!=null && pols.size()>0){
			pps.setPols(pols);
		}else{
			pps.setPols(new LinkedList<Pol>());
		}
		LinkedList<Polval> polvals = buildPpsPolvalData();
		if(polvals!=null && polvals.size()>0){
			pps.setPolvals(polvals);
		}else{
			pps.setPolvals(new LinkedList<Polval>());
		}
		
		return pps;
	}
	
	private void initBasicPlan(){
		for(QuotPlanDetail plan: planList){
			String planInd = plan.getPlanInd();			
			if("B".equalsIgnoreCase(planInd)){				
				setBasicPlan(plan);				
				break;				
			}
		}
	}

	@Override
	public LinkedList<Rider> buildPpsRiderData() {
		// TODO Auto-generated method stub
		LinkedList<Rider> riders = new LinkedList<>();
		if(planList!=null && planList.size()>1){
			
			int i=0;
			for(QuotPlanDetail plan: planList){
				String planInd = plan.getPlanInd();
				if("R".equalsIgnoreCase(planInd)){
					String tmpl = "";
					RiderWlp rider = new RiderWlp();
					rider.setRidLab1("附加保障");
					rider.setRidLab2("附加保障");
					rider.setRiderPlan(plan.getQuplanRiderCodeDesc());
					rider.setRidAPm("");
					rider.setRidMPm("");
					rider.setPayMode("");
					rider.setRidPTm(0);
					rider.setRidLvlp("");
					rider.setRidGrtRt("");
					rider.setRiderSA(iFormat.format(plan.getQuplanSumInsured()));//投保额
					rider.setRiderSAcover((plan.getQuplanSumInsured()==null || plan.getQuplanSumInsured().doubleValue()==0)?"":iFormat.format(plan.getQuplanSumInsured()));
					rider.setRidAPm(dFormat.format(plan.getQuplanAnnPremium()));
					if(!"WP".equals(plan.getProductLine())){ //no template for waiver of premium
						if(Utility.HasDigit(plan.getQuplanRiderCode())){//特殊字符，包含数字的都是需要再查一次tab
							if("DD".equals(plan.getProductLine())){
								tmpl = "dd30_template.docx";
							}else if("WP".equals(plan.getProductLine())){
								continue;
							}else{
								tmpl = plan.getProductLine().toLowerCase()+"_template.docx";
							}
						}else{//不包含数字，属于基本附加类型
							tmpl = plan.getQuplanRiderCode().toLowerCase()+"_template.docx";
						}
						rider.setRiderTemplate(tmpl);
					}
					riders.add(rider);
					i = i++;
				}
			}

			
		}		
		
		return riders;
	}

	@Override
	public LinkedList<Pol> buildPpsPolData() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public LinkedList<Polval> buildPpsPolvalData() {
		// TODO Auto-generated method stub
		LinkedList<Polval> list=new LinkedList<>();
		int[] years = new int[]{1, 2, 3, 4, 5, 10, 15, 20, 25, 30};
		for(int year: years){
			PolvalWlp val = new PolvalWlp();
			val.setPolYr(year);//年份

			val.setTotalPaid(dFormat.format(basicPlan.getQuplanAnnPremium().multiply(new BigDecimal(year)).setScale(0, BigDecimal.ROUND_UP)));//每年交多少 年繳保費*年

			BigDecimal grtvalsv=new BigDecimal(0.00);
			val.setGrtValSV(dFormat.format(grtvalsv));//現金價值、保證可得金額

			BigDecimal grtvaldb=basicPlan.getQuplanSumInsured().setScale(0, BigDecimal.ROUND_UP);
			val.setGrtValDB(dFormat.format(grtvaldb));//身故賠償，保證可得金額



			BigDecimal accDiv=new BigDecimal(0.00);
			val.setAccDiv(dFormat.format(accDiv));// 非保証可得金額

			val.setTotalDB(dFormat.format(grtvaldb.add(accDiv)));//現金價值，總額


			val.setTotalSV(dFormat.format(grtvalsv.add(accDiv)));////身故賠償，總額 = 身故賠償，保證可得金額 + 非保証可的金額
			val.setTotalSVH("0.00");
			list.add(val);
		}

		return list;
	}




	/**计算本年累计股利
	 * Calculate accumulated dividend of this year
	 * Input Parameter:
	 * param.polYear: Policy year
	 * param.div: Current year dividen
	 * param.interestRate: Interest rate
	 * param.lastAccumulatedDiv: Last year accumulated dividend
	 * param.waivedPremium: Waived premium
	 * @param param
 	 */
	public String calcAccumulatedDividend(BigDecimal  param,String ccy){
		//1.得到費率
		BigDecimal interestRate=new BigDecimal("USD".equals(ccy)?0.0426:0.0351);
		BigDecimal rate = interestRate.add(new BigDecimal(1));
      return "";
	}

	public String getPaymode(String paymode){
  		switch(paymode){
			case "A" :
				//语句
				return  "年缴";
 			case "S" :
				//语句
				return "半年繳";
 			case "Q" :
				//语句
				return "季繳";
 			case "M" :
				//语句
				return "月繳";
 			default : //可选
 		}
		return "";


	}

	public QuotPlanDetail getBasicPlan() {
		return basicPlan;
	}

	public void setBasicPlan(QuotPlanDetail basicPlan) {
		this.basicPlan = basicPlan;
	}
	
	

}
