package com.reinfo.ipoly.module.report.utils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.reinfo.ipoly.module.models.IlfQuot;
import com.reinfo.ipoly.module.models.Pol;
import com.reinfo.ipoly.module.models.Polval;
import com.reinfo.ipoly.module.models.Pps;
import com.reinfo.ipoly.module.models.PpsLt;
import com.reinfo.ipoly.module.models.ProdCovTab;
import com.reinfo.ipoly.module.models.QuotPlanDetail;
import com.reinfo.ipoly.module.models.Rider;
import com.reinfo.ipoly.module.models.RiderLt;
import com.reinfo.ipoly.module.utils.Constants;
import com.reinfo.ipoly.module.utils.Utility;

public class BuildPpsLt implements BuildPps {

	private IlfQuot quot;

	private List<QuotPlanDetail> planList;

	private ProdCovTab prod;

	public BuildPpsLt(IlfQuot quot, List<QuotPlanDetail> planList, ProdCovTab prod) {
		this.quot = quot;
		this.planList = planList;
		this.prod = prod;
	}

	@Override
	public Pps buildPpsData() {
		PpsLt pps = new PpsLt();
		pps.setSysVersion("v2019.09.10");
		pps.setTemplateName("pps" + quot.getQuotPlan().toLowerCase());
		pps.setPpsNo(quot.getQuotNo());
		pps.setPpsRefNo(quot.getQuotRefno());
		pps.setPpsDate(Date.from(quot.getQuotDate().toInstant()));
		pps.setAgentCode(quot.getQuotAgtId());
		pps.setAgentName(quot.getQuotAgtName());
		pps.setAgentPhone(quot.getQuotAgtTel());

		pps.setInsuredName(quot.getQuotFinsuredName());
		pps.setInsuredAge(quot.getQuotFinsuredAge());
		pps.setInsuredGender("M".equals(quot.getQuotFinsuredGender()) ? "男" : "女");
		pps.setInsuredSmoke("N".equals(quot.getQuotFinsuredSmoker()) ? "非吸烟" : "吸烟");

		DecimalFormat df = new DecimalFormat(",###,##0");
		DecimalFormat de = new DecimalFormat(",###,##0.00");

		pps.setLtYr("M".equals(quot.getQuotFinsuredGender()) ? prod.getPolMattMale() : prod.getPolMattFemale());
		pps.setLtDesc1("*	保證可獲續保至被保人年滿七十五歲而毋須驗身。期滿續保之保費將按被保人當時年齡計算。");
		pps.setLtDesc2("*	被保人可於六十五歲前將本計劃轉換為其他終身或儲蓄壽險計劃，而毋須重新接受核保。");

		pps.setBasicPlan(Constants.getProdCovLineMap2.get(quot.getQuotPlan()) + " - " + pps.getLtYr() + " 年期");
		pps.setCcy("MOP".equals(quot.getQuotCcy()) ? "澳門元" : "HKD".equals(quot.getQuotCcy()) ? "港元" : "美元");
		pps.setBasicSA(df.format(planList.get(0).getQuplanSumInsured()));
		pps.setBasAPm(de.format(planList.get(0).getQuplanAnnPremium()));

		pps.setTotalAPm(de.format(quot.getQuotTotalPrem()));
		pps.setTotalMPm(de.format(quot.getQuotTotalPremAnn()));
		if ("A".equals(quot.getQuotPaymode())) {
			pps.setTotalMPmDesc("每年總保費");
		} else if ("S".equals(quot.getQuotPaymode())) {
			pps.setTotalMPmDesc("每半年總保費");
		} else if ("Q".equals(quot.getQuotPaymode())) {
			pps.setTotalMPmDesc("每季總保費");
		} else {
			pps.setTotalMPmDesc("每月總保費");
		}

		pps.setWpPbLab("");
		pps.setWpPbPlan("");
		pps.setWpPbDesc("");
		pps.setRidLab1("");
		if (StringUtils.isNotBlank(quot.getQuotPlanWaiver())) {
			pps.setWpPbLab("附加保障");
			pps.setRidLab1("附加保障");
			pps.setWpPbPlan("豁免保費保障");
			pps.setWpPbDesc("若被保人於六十歲前因意外或疾病導致完全及永久傷殘，以致連續六個月或以上喪失工作能力， 我們將豁免定期壽險之保費，直至痊癒為止。豁免保費期間計劃仍然維持生效。");
		}

		addPlan(pps);
		
		LinkedList<Rider> riders = buildPpsRiderData();
		if (riders != null) {
			pps.setRiders(riders);
		} else {
			pps.setRiders(new LinkedList<Rider>());
		}

		return pps;
	}

	@Override
	public LinkedList<Rider> buildPpsRiderData() {
		DecimalFormat df = new DecimalFormat(",###,##0");
		DecimalFormat de = new DecimalFormat(",###,##0.00");
		LinkedList<Rider> riderList = new LinkedList<>();
		if (planList != null && planList.size() > 1) {
			for (int i = 1; i < planList.size(); i++) {
				RiderLt rider = new RiderLt();
				if ("W3001".equals(planList.get(i).getQuplanRiderCode())) {
					rider.setRiderPlan("豁免保費保障");
					rider.setRiderSAcover("");
				} else if ("HI".equals(planList.get(i).getQuplanRiderCode())
						|| "HS".equals(planList.get(i).getQuplanRiderCode())) {
					rider.setRiderPlan(splitString(planList.get(i).getQuplanRiderClassDesc()));
					rider.setRiderSAcover("");
				} else {
					rider.setRiderPlan(addString(planList.get(i).getQuplanRiderCodeDesc()) + " - "
							+ splitString(planList.get(i).getQuplanRiderClassDesc()));
					rider.setRiderSAcover(planList.get(i).getQuplanSumInsured() != null
							? df.format(planList.get(i).getQuplanSumInsured())
							: "");
				}
				rider.setRidAPm(
						planList.get(i).getQuplanAnnPremium() != null ? de.format(planList.get(i).getQuplanAnnPremium())
								: "");
				
				String tmpl = "";
				if (Utility.HasDigit(planList.get(i).getQuplanRiderCode())) {// 特殊字符，包含数字的都是需要再查一次tab
					if ("DD".equals(planList.get(i).getProductLine())) {
						tmpl = "dd30_template.docx";
					} else if ("WP".equals(planList.get(i).getProductLine())) {
						riderList.add(rider);
						continue;
					} else {
						tmpl = planList.get(i).getProductLine().toLowerCase() + "_template.docx";
					}
				} else {// 不包含数字，属于基本附加类型
					tmpl = planList.get(i).getQuplanRiderCode().toLowerCase() + "_template.docx";
				}
				rider.setRiderTemplate(tmpl);
				riderList.add(rider);
			}
			return riderList;
		}

		RiderLt rider = new RiderLt();
		rider.setRidLab1("附加保障");
		rider.setRiderPlan("");
		rider.setRidAPm("");
		rider.setRiderSAcover("");
		riderList.add(rider);
		return riderList;
	}

	@Override
	public LinkedList<Pol> buildPpsPolData() {
		return null;
	}

	@Override
	public LinkedList<Polval> buildPpsPolvalData() {
		return null;
	}

	public static String addString(String str) {
		if (StringUtils.isNotBlank(str)) {
			str = str.substring(0, 4) + "保障";
		}
		return str;
	}

	public String splitString(String str) {
		if (StringUtils.isNotBlank(str)) {
			String strs[] = str.split("：");
			str = strs.length > 1 ? strs[1] : str;
		}
		return str;
	}

	public void addPlan(PpsLt pps) {
		DecimalFormat df = new DecimalFormat(",###,##0");
		for(QuotPlanDetail plan : planList) {
			Double prem = plan.getQuplanSumInsured() != null ? plan.getQuplanSumInsured().doubleValue() : null;
			switch (plan.getQuplanRiderCode()) {
			case "AI":
				pps.setAiSA(df.format(prem));
				pps.setAi105SA(df.format(prem * 0.01));
				pps.setAi106SA(df.format(prem * 0.0025));
				pps.setAi107SA(df.format(prem * 0.01));
				pps.setAi108SA(df.format(prem * 0.01));
				pps.setAi109SA1(df.format(prem * 0.03));
				pps.setAi109SA2("1000");
				pps.setAi109SA3("0.5%");
				pps.setAi305SA1(df.format(prem * 0.25));
				pps.setAi305SA2(df.format(prem * 0.75));
				pps.setAi306SA(df.format(prem * 0.3));
				pps.setAi307SA1(df.format(prem * 0.5));
				pps.setAi307SA2(df.format(prem));
				pps.setAi308SA1(df.format(prem * 0.7));
				pps.setAi308SA2(df.format(prem * 0.5));
				pps.setAi309SA1(df.format(prem * 0.4));
				pps.setAi309SA2(df.format(prem * 0.3));
				pps.setAi310SA11(df.format(prem * 0.3));
				pps.setAi310SA12(df.format(prem * 0.2));
				pps.setAi310SA21(df.format(prem * 0.15));
				pps.setAi310SA22(df.format(prem * 0.1));
				pps.setAi311SA11(df.format(prem * 0.1));
				pps.setAi311SA12(df.format(prem * 0.075));
				pps.setAi311SA21(df.format(prem * 0.075));
				pps.setAi311SA22(df.format(prem * 0.05));
				pps.setAi311SA31(df.format(prem * 0.05));
				pps.setAi311SA32(df.format(prem * 0.02));
				pps.setAi312SA1(df.format(prem * 0.15));
				pps.setAi312SA2(df.format(prem * 0.05));
				pps.setAi312SA3(df.format(prem * 0.03));
				pps.setAi313SA(df.format(prem * 0.1));
				pps.setAi314SA(df.format(prem * 0.075));
				break;
			case "AD":
				pps.setAdSA(df.format(prem));
				pps.setAd04SA(df.format(prem * 0.5));
				pps.setAd05SA(df.format(prem * 0.25));
				break;
			case "ADB":
				pps.setAdbSA(df.format(prem));
				break;
			case "HS":
				pps.setHs01D("90");
				pps.setHs02D("90");
				pps.setHs04D("15");
				pps.setHs09D("30");
				pps.setHs06SA("40%");
				pps.setHs07SA("40%");
				switch(plan.getQuplanRiderClass()) {
				case "1":
					pps.setHsPlan("基本");
					pps.setHs01SA("480");
					pps.setHs02SA("480");
					pps.setHs03SA("6000");
					pps.setHs04SA("2000");
					pps.setHs05SA1("30000");
					pps.setHs05SA2("24000");
					pps.setHs05SA3("12000");
					pps.setHs05SA4("4400");
					pps.setHs08SA("2000");
					pps.setHs09SA("160");
					if(quot.getQuotCcy().equals("USD")) {
						pps.setHs01SA("60");
						pps.setHs02SA("60");
						pps.setHs03SA("750");
						pps.setHs04SA("250");
						pps.setHs05SA1("3750");
						pps.setHs05SA2("3000");
						pps.setHs05SA3("1500");
						pps.setHs05SA4("550");
						pps.setHs08SA("250");
						pps.setHs09SA("20");
					}
					break;
				case "2":
					pps.setHsPlan("優越");
					pps.setHs01SA("1000");
					pps.setHs02SA("1000");
					pps.setHs03SA("10000");
					pps.setHs04SA("3600");
					pps.setHs05SA1("46000");
					pps.setHs05SA2("36800");
					pps.setHs05SA3("18400");
					pps.setHs05SA4("6800");
					pps.setHs08SA("2000");
					pps.setHs09SA("240");
					if(quot.getQuotCcy().equals("USD")) {
						pps.setHs01SA("125");
						pps.setHs02SA("125");
						pps.setHs03SA("1250");
						pps.setHs04SA("450");
						pps.setHs05SA1("5750");
						pps.setHs05SA2("4600");
						pps.setHs05SA3("2300");
						pps.setHs05SA4("850");
						pps.setHs08SA("500");
						pps.setHs09SA("30");
					}
					break;
				case "3":
					pps.setHsPlan("至尊");
					pps.setHs01SA("2000");
					pps.setHs02SA("2000");
					pps.setHs03SA("18000");
					pps.setHs04SA("5000");
					pps.setHs05SA1("72000");
					pps.setHs05SA2("57600");
					pps.setHs05SA3("28800");
					pps.setHs05SA4("10800");
					pps.setHs08SA("6000");
					pps.setHs09SA("400");
					if(quot.getQuotCcy().equals("USD")) {
						pps.setHs01SA("250");
						pps.setHs02SA("250");
						pps.setHs03SA("2250");
						pps.setHs04SA("625");
						pps.setHs05SA1("9000");
						pps.setHs05SA2("7200");
						pps.setHs05SA3("3600");
						pps.setHs05SA4("1350");
						pps.setHs08SA("750");
						pps.setHs09SA("50");
					}
					break;
				case "4":
					pps.setHsPlan("基本");
					pps.setHs01SA("480");
					pps.setHs02SA("480");
					pps.setHs03SA("6000");
					pps.setHs04SA("2000");
					pps.setHs05SA1("30000");
					pps.setHs05SA2("24000");
					pps.setHs05SA3("12000");
					pps.setHs05SA4("4400");
					pps.setHs08SA("2000");
					pps.setHs09SA("160");
					if(quot.getQuotCcy().equals("USD")) {
						pps.setHs01SA("60");
						pps.setHs02SA("60");
						pps.setHs03SA("750");
						pps.setHs04SA("250");
						pps.setHs05SA1("3750");
						pps.setHs05SA2("3000");
						pps.setHs05SA3("1500");
						pps.setHs05SA4("550");
						pps.setHs08SA("250");
						pps.setHs09SA("20");
					}
					break;
				case "5":
					pps.setHsPlan("優越");
					pps.setHs01SA("1000");
					pps.setHs02SA("1000");
					pps.setHs03SA("10000");
					pps.setHs04SA("3600");
					pps.setHs05SA1("46000");
					pps.setHs05SA2("36800");
					pps.setHs05SA3("18400");
					pps.setHs05SA4("6800");
					pps.setHs08SA("4000");
					pps.setHs09SA("240");
					if(quot.getQuotCcy().equals("USD")) {
						pps.setHs01SA("125");
						pps.setHs02SA("125");
						pps.setHs03SA("1250");
						pps.setHs04SA("450");
						pps.setHs05SA1("5750");
						pps.setHs05SA2("4600");
						pps.setHs05SA3("2300");
						pps.setHs05SA4("850");
						pps.setHs08SA("500");
						pps.setHs09SA("30");
					}
					break;
				case "6":
					pps.setHsPlan("至尊");
					pps.setHs01SA("2000");
					pps.setHs02SA("2000");
					pps.setHs03SA("18000");
					pps.setHs04SA("5000");
					pps.setHs05SA1("72000");
					pps.setHs05SA2("57600");
					pps.setHs05SA3("28800");
					pps.setHs05SA4("10800");
					pps.setHs08SA("6000");
					pps.setHs09SA("400");
					if(quot.getQuotCcy().equals("USD")) {
						pps.setHs01SA("250");
						pps.setHs02SA("250");
						pps.setHs03SA("2250");
						pps.setHs04SA("625");
						pps.setHs05SA1("9000");
						pps.setHs05SA2("7200");
						pps.setHs05SA3("3600");
						pps.setHs05SA4("1350");
						pps.setHs08SA("750");
						pps.setHs09SA("50");
					}
					break;
				}
				break;
			case "HI":
				pps.setHiPlan("基本");
				pps.setHiSA("480");
				if(quot.getQuotCcy().equals("USD")) {
					pps.setHiSA("60");
				}
				pps.setHiDays("730");
				break;
			}
		}
	}
}
