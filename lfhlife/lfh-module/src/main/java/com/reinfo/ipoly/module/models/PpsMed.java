package com.reinfo.ipoly.module.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;

public class PpsMed implements Pps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sysVersion;
	private String agentCode;
	private String agentName;
	private String agentPhone;
	private String ppsNo;
	private String ppsRefNo;
	@JsonFormat(pattern="dd/MM/yy", timezone = "GMT+8")
	private java.util.Date ppsDate;
	private String insuredName;
	private int insuredAge;
	private String insuredGender;
	private String insuredSmoke;
	private String payMode;
	private String basicPlan;
	private String ccy;
	private String basicSA;
	private String basAPm;
	private String basAPmInt;
	private String basMPm;
	private String basAnzedPm;
	private String totalAPm;
	private String totalMPmDesc;
	private String totalMPm;
	private String basicWithWpPB;
	private String wpPbPlan;
	private String wpPbDesc;
	private String ridLab1;
	private String wpPbLab;
	private int atAge;
	private int atAgeTotal;
	private int atAgeCsv;
	private int atAgeDiv;
	private int atAgeTotalPaid;
	private int atAgeNet;
	private String divOpt;
	private int vanishYr;
	
	
	private String intRate;
	private String intRateL;
	private String intRateH;
	private String rateType;
	private int polMTm;
	private int polPTm;
	private String polLvlP;
	private String polGrtRt;
	private String polYrM;
	private int totalPaidM;
	private int grtValM;
	private int accDivLM;
	private int totalSVLM;
	private int accDivM;
	private int totalSVM;
	private int accDivHM;
	private int totalSVHM;
	private String templateName;

	private String mPlan;
	private String hiPlan;
	private String hiSA;
	private String hiDays;
	private String hs01SA;
	private String hs02SA;
	private String hs03SA;
	private String hs04SA;
	private String hs05SA1;
	private String hs05SA2;
	private String hs05SA3;
	private String hs05SA4;
	private String hs06SA;
	private String hs07SA;
	private String hs08SA;
	private String hs09SA;
	private String m10SA;
	private String m11SA;
	private String m12SA;
	private String hs01D;
	private String hs02D;
	private String hs04D;
	private String hs09D;

	public String getHiPlan() {
		return hiPlan;
	}

	public void setHiPlan(String hiPlan) {
		this.hiPlan = hiPlan;
	}

	public String getHiSA() {
		return hiSA;
	}

	public void setHiSA(String hiSA) {
		this.hiSA = hiSA;
	}

	public String getHiDays() {
		return hiDays;
	}

	public void setHiDays(String hiDays) {
		this.hiDays = hiDays;
	}

	public String getmPlan() {
		return mPlan;
	}

	public void setmPlan(String mPlan) {
		this.mPlan = mPlan;
	}

	public String getHs01SA() {
		return hs01SA;
	}

	public void setHs01SA(String hs01SA) {
		this.hs01SA = hs01SA;
	}

	public String getHs02SA() {
		return hs02SA;
	}

	public void setHs02SA(String hs02SA) {
		this.hs02SA = hs02SA;
	}

	public String getHs03SA() {
		return hs03SA;
	}

	public void setHs03SA(String hs03SA) {
		this.hs03SA = hs03SA;
	}

	public String getHs04SA() {
		return hs04SA;
	}

	public void setHs04SA(String hs04SA) {
		this.hs04SA = hs04SA;
	}

	public String getHs05SA1() {
		return hs05SA1;
	}

	public void setHs05SA1(String hs05SA1) {
		this.hs05SA1 = hs05SA1;
	}

	public String getHs05SA2() {
		return hs05SA2;
	}

	public void setHs05SA2(String hs05SA2) {
		this.hs05SA2 = hs05SA2;
	}

	public String getHs05SA3() {
		return hs05SA3;
	}

	public void setHs05SA3(String hs05SA3) {
		this.hs05SA3 = hs05SA3;
	}

	public String getHs05SA4() {
		return hs05SA4;
	}

	public void setHs05SA4(String hs05SA4) {
		this.hs05SA4 = hs05SA4;
	}

	public String getHs06SA() {
		return hs06SA;
	}

	public void setHs06SA(String hs06SA) {
		this.hs06SA = hs06SA;
	}

	public String getHs07SA() {
		return hs07SA;
	}

	public void setHs07SA(String hs07SA) {
		this.hs07SA = hs07SA;
	}

	public String getHs08SA() {
		return hs08SA;
	}

	public void setHs08SA(String hs08SA) {
		this.hs08SA = hs08SA;
	}

	public String getHs09SA() {
		return hs09SA;
	}

	public void setHs09SA(String hs09SA) {
		this.hs09SA = hs09SA;
	}

	public String getM10SA() {
		return m10SA;
	}

	public void setM10SA(String m10SA) {
		this.m10SA = m10SA;
	}

	public String getM11SA() {
		return m11SA;
	}

	public void setM11SA(String m11SA) {
		this.m11SA = m11SA;
	}

	public String getM12SA() {
		return m12SA;
	}

	public void setM12SA(String m12SA) {
		this.m12SA = m12SA;
	}

	public String getHs01D() {
		return hs01D;
	}

	public void setHs01D(String hs01D) {
		this.hs01D = hs01D;
	}

	public String getHs02D() {
		return hs02D;
	}

	public void setHs02D(String hs02D) {
		this.hs02D = hs02D;
	}

	public String getHs04D() {
		return hs04D;
	}

	public void setHs04D(String hs04D) {
		this.hs04D = hs04D;
	}

	public String getHs09D() {
		return hs09D;
	}

	public void setHs09D(String hs09D) {
		this.hs09D = hs09D;
	}

	@JsonProperty("rider")
	private LinkedList<Rider> riders;
	
	@JsonProperty("pol")
	private LinkedList<Pol> pols;
	
	@JsonProperty("polval")
	private LinkedList<Polval> polvals;
	
	public String getSysVersion() {
		return sysVersion;
	}
	public void setSysVersion(String sysVersion) {
		this.sysVersion = sysVersion;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentPhone() {
		return agentPhone;
	}
	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}
	public String getPpsNo() {
		return ppsNo;
	}
	public void setPpsNo(String ppsNo) {
		this.ppsNo = ppsNo;
	}
	public String getPpsRefNo() {
		return ppsRefNo;
	}
	public void setPpsRefNo(String ppsRefNo) {
		this.ppsRefNo = ppsRefNo;
	}
	public java.util.Date getPpsDate() {
		return ppsDate;
	}
	public void setPpsDate(java.util.Date ppsDate) {
		this.ppsDate = ppsDate;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public int getInsuredAge() {
		return insuredAge;
	}
	public void setInsuredAge(int insuredAge) {
		this.insuredAge = insuredAge;
	}
	public String getInsuredGender() {
		return insuredGender;
	}
	public void setInsuredGender(String insuredGender) {
		this.insuredGender = insuredGender;
	}
	public String getInsuredSmoke() {
		return insuredSmoke;
	}
	public void setInsuredSmoke(String insuredSmoke) {
		this.insuredSmoke = insuredSmoke;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getBasicPlan() {
		return basicPlan;
	}
	public void setBasicPlan(String basicPlan) {
		this.basicPlan = basicPlan;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getBasicSA() {
		return basicSA;
	}
	public void setBasicSA(String basicSA) {
		this.basicSA = basicSA;
	}
	public String getBasAPm() {
		return basAPm;
	}
	public void setBasAPm(String basAPm) {
		this.basAPm = basAPm;
	}
	public String getBasAPmInt() {
		return basAPmInt;
	}
	public void setBasAPmInt(String basAPmInt) {
		this.basAPmInt = basAPmInt;
	}
	public String getBasMPm() {
		return basMPm;
	}
	public void setBasMPm(String basMPm) {
		this.basMPm = basMPm;
	}
	public String getBasAnzedPm() {
		return basAnzedPm;
	}
	public void setBasAnzedPm(String basAnzedPm) {
		this.basAnzedPm = basAnzedPm;
	}
	public String getTotalAPm() {
		return totalAPm;
	}
	public void setTotalAPm(String totalAPm) {
		this.totalAPm = totalAPm;
	}
	public String getTotalMPmDesc() {
		return totalMPmDesc;
	}
	public void setTotalMPmDesc(String totalMPmDesc) {
		this.totalMPmDesc = totalMPmDesc;
	}
	public String getTotalMPm() {
		return totalMPm;
	}
	public void setTotalMPm(String totalMPm) {
		this.totalMPm = totalMPm;
	}
	public String getBasicWithWpPB() {
		return basicWithWpPB;
	}
	public void setBasicWithWpPB(String basicWithWpPB) {
		this.basicWithWpPB = basicWithWpPB;
	}
	public String getWpPbPlan() {
		return wpPbPlan;
	}
	public void setWpPbPlan(String wpPbPlan) {
		this.wpPbPlan = wpPbPlan;
	}
	public String getWpPbDesc() {
		return wpPbDesc;
	}
	public void setWpPbDesc(String wpPbDesc) {
		this.wpPbDesc = wpPbDesc;
	}
	public String getRidLab1() {
		return ridLab1;
	}
	public void setRidLab1(String ridLab1) {
		this.ridLab1 = ridLab1;
	}
	public String getWpPbLab() {
		return wpPbLab;
	}
	public void setWpPbLab(String wpPbLab) {
		this.wpPbLab = wpPbLab;
	}
	public int getAtAge() {
		return atAge;
	}
	public void setAtAge(int atAge) {
		this.atAge = atAge;
	}
	public int getAtAgeTotal() {
		return atAgeTotal;
	}
	public void setAtAgeTotal(int atAgeTotal) {
		this.atAgeTotal = atAgeTotal;
	}
	public int getAtAgeCsv() {
		return atAgeCsv;
	}
	public void setAtAgeCsv(int atAgeCsv) {
		this.atAgeCsv = atAgeCsv;
	}
	public int getAtAgeDiv() {
		return atAgeDiv;
	}
	public void setAtAgeDiv(int atAgeDiv) {
		this.atAgeDiv = atAgeDiv;
	}
	public int getAtAgeTotalPaid() {
		return atAgeTotalPaid;
	}
	public void setAtAgeTotalPaid(int atAgeTotalPaid) {
		this.atAgeTotalPaid = atAgeTotalPaid;
	}
	public int getAtAgeNet() {
		return atAgeNet;
	}
	public void setAtAgeNet(int atAgeNet) {
		this.atAgeNet = atAgeNet;
	}
	public String getDivOpt() {
		return divOpt;
	}
	public void setDivOpt(String divOpt) {
		this.divOpt = divOpt;
	}
	public int getVanishYr() {
		return vanishYr;
	}
	public void setVanishYr(int vanishYr) {
		this.vanishYr = vanishYr;
	}
	
	public String getIntRate() {
		return intRate;
	}
	public void setIntRate(String intRate) {
		this.intRate = intRate;
	}
	public String getIntRateL() {
		return intRateL;
	}
	public void setIntRateL(String intRateL) {
		this.intRateL = intRateL;
	}
	public String getIntRateH() {
		return intRateH;
	}
	public void setIntRateH(String intRateH) {
		this.intRateH = intRateH;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public int getPolMTm() {
		return polMTm;
	}
	public void setPolMTm(int polMTm) {
		this.polMTm = polMTm;
	}
	public int getPolPTm() {
		return polPTm;
	}
	public void setPolPTm(int polPTm) {
		this.polPTm = polPTm;
	}
	public String getPolLvlP() {
		return polLvlP;
	}
	public void setPolLvlP(String polLvlP) {
		this.polLvlP = polLvlP;
	}
	public String getPolGrtRt() {
		return polGrtRt;
	}
	public void setPolGrtRt(String polGrtRt) {
		this.polGrtRt = polGrtRt;
	}
	public String getPolYrM() {
		return polYrM;
	}
	public void setPolYrM(String polYrM) {
		this.polYrM = polYrM;
	}
	public int getTotalPaidM() {
		return totalPaidM;
	}
	public void setTotalPaidM(int totalPaidM) {
		this.totalPaidM = totalPaidM;
	}
	public int getGrtValM() {
		return grtValM;
	}
	public void setGrtValM(int grtValM) {
		this.grtValM = grtValM;
	}
	public int getAccDivLM() {
		return accDivLM;
	}
	public void setAccDivLM(int accDivLM) {
		this.accDivLM = accDivLM;
	}
	public int getTotalSVLM() {
		return totalSVLM;
	}
	public void setTotalSVLM(int totalSVLM) {
		this.totalSVLM = totalSVLM;
	}
	public int getAccDivM() {
		return accDivM;
	}
	public void setAccDivM(int accDivM) {
		this.accDivM = accDivM;
	}
	public int getTotalSVM() {
		return totalSVM;
	}
	public void setTotalSVM(int totalSVM) {
		this.totalSVM = totalSVM;
	}
	public int getAccDivHM() {
		return accDivHM;
	}
	public void setAccDivHM(int accDivHM) {
		this.accDivHM = accDivHM;
	}
	public int getTotalSVHM() {
		return totalSVHM;
	}
	public void setTotalSVHM(int totalSVHM) {
		this.totalSVHM = totalSVHM;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public LinkedList<Rider> getRiders() {
		return riders;
	}
	public void setRiders(LinkedList<Rider> riders) {
		this.riders = riders;
	}
	public LinkedList<Pol> getPols() {
		return pols;
	}
	public void setPols(LinkedList<Pol> pols) {
		this.pols = pols;
	}
	public LinkedList<Polval> getPolvals() {
		return polvals;
	}
	public void setPolvals(LinkedList<Polval> polvals) {
		this.polvals = polvals;
	}



	
	
	
	
}
