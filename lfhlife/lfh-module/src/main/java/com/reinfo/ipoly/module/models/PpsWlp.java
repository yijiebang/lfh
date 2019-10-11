package com.reinfo.ipoly.module.models;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PpsWlp implements Pps {

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
	private int ltrYr;
	private int ltrSA;
	private String ltrExtraDesc;
	private String ltrDesc1;
	private String ltrRidLab1;
	private String ltrWpPbPlan;
	private String ltrWpPbDesc;
	private String ltrtemplate;
	private String attachTo;
	private String dd30Desc;
	private String citemplate;
	
	private String aiSA;           //  = productData.sumInsured.formatMoney(0);
	private String ai105SA;        //     = (productData.sumInsured * 0.01).formatMoney(0);
	private String ai106SA;        //     = (productData.sumInsured * 0.0025).formatMoney(0);
	private String ai107SA;        //     = (productData.sumInsured * 0.01).formatMoney(0);
	private String ai108SA;        //     = (productData.sumInsured * 0.01).formatMoney(0);
	private String ai109SA1;       //      = (productData.sumInsured * 0.03).formatMoney(0);
	private String ai109SA2;       //      = productDoc.otherConfig.ai109SA2.formatMoney(0);
	private String ai109SA3;       //      = productDoc.otherConfig.ai109SA3;
	private String ai305SA1;       //      = (productData.sumInsured * 0.25).formatMoney(0);
	private String ai305SA2;       //      = (productData.sumInsured * 0.75).formatMoney(0);
	private String ai306SA;        //     = (productData.sumInsured * 0.3).formatMoney(0);
	private String ai307SA1;       //      = (productData.sumInsured * 0.5).formatMoney(0);
	private String ai307SA2;       //      = productData.sumInsured.formatMoney(0);
	private String ai308SA1;       //      = (productData.sumInsured * 0.7).formatMoney(0);
	private String ai308SA2;       //      = (productData.sumInsured * 0.5).formatMoney(0);
	private String ai309SA1;       //      = (productData.sumInsured * 0.4).formatMoney(0);
	private String ai309SA2;       //      = (productData.sumInsured * 0.3).formatMoney(0);
	private String ai310SA11;      //       = (productData.sumInsured * 0.3).formatMoney(0);
	private String ai310SA12;      //       = (productData.sumInsured * 0.2).formatMoney(0);
	private String ai310SA21;      //       = (productData.sumInsured * 0.15).formatMoney(0);
	private String ai310SA22;      //       = (productData.sumInsured * 0.1).formatMoney(0);
	private String ai311SA11;      //       = (productData.sumInsured * 0.1).formatMoney(0);
	private String ai311SA12;      //       = (productData.sumInsured * 0.075).formatMoney(0);
	private String ai311SA21;      //       = (productData.sumInsured * 0.075).formatMoney(0);
	private String ai311SA22;      //       = (productData.sumInsured * 0.05).formatMoney(0);
	private String ai311SA31;      //       = (productData.sumInsured * 0.05).formatMoney(0);
	private String ai311SA32;      //       = (productData.sumInsured * 0.02).formatMoney(0);
	private String ai312SA1;       //      = (productData.sumInsured * 0.15).formatMoney(0);
	private String ai312SA2;       //      = (productData.sumInsured * 0.05).formatMoney(0);
	private String ai312SA3;       //      = (productData.sumInsured * 0.03).formatMoney(0);
	private String ai313SA;        //     = (productData.sumInsured * 0.1).formatMoney(0);
	private String ai314SA;        //     = (productData.sumInsured * 0.075).formatMoney(0);
	
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
	public int getLtrYr() {
		return ltrYr;
	}
	public void setLtrYr(int ltrYr) {
		this.ltrYr = ltrYr;
	}
	public int getLtrSA() {
		return ltrSA;
	}
	public void setLtrSA(int ltrSA) {
		this.ltrSA = ltrSA;
	}
	public String getLtrExtraDesc() {
		return ltrExtraDesc;
	}
	public void setLtrExtraDesc(String ltrExtraDesc) {
		this.ltrExtraDesc = ltrExtraDesc;
	}
	public String getLtrDesc1() {
		return ltrDesc1;
	}
	public void setLtrDesc1(String ltrDesc1) {
		this.ltrDesc1 = ltrDesc1;
	}
	public String getLtrRidLab1() {
		return ltrRidLab1;
	}
	public void setLtrRidLab1(String ltrRidLab1) {
		this.ltrRidLab1 = ltrRidLab1;
	}
	public String getLtrWpPbPlan() {
		return ltrWpPbPlan;
	}
	public void setLtrWpPbPlan(String ltrWpPbPlan) {
		this.ltrWpPbPlan = ltrWpPbPlan;
	}
	public String getLtrWpPbDesc() {
		return ltrWpPbDesc;
	}
	public void setLtrWpPbDesc(String ltrWpPbDesc) {
		this.ltrWpPbDesc = ltrWpPbDesc;
	}
	public String getLtrtemplate() {
		return ltrtemplate;
	}
	public void setLtrtemplate(String ltrtemplate) {
		this.ltrtemplate = ltrtemplate;
	}
	public String getAttachTo() {
		return attachTo;
	}
	public void setAttachTo(String attachTo) {
		this.attachTo = attachTo;
	}
	public String getDd30Desc() {
		return dd30Desc;
	}
	public void setDd30Desc(String dd30Desc) {
		this.dd30Desc = dd30Desc;
	}
	public String getCitemplate() {
		return citemplate;
	}
	public void setCitemplate(String citemplate) {
		this.citemplate = citemplate;
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
	public String getAiSA() {
		return aiSA;
	}
	public void setAiSA(String aiSA) {
		this.aiSA = aiSA;
	}
	public String getAi105SA() {
		return ai105SA;
	}
	public void setAi105SA(String ai105sa) {
		ai105SA = ai105sa;
	}
	public String getAi106SA() {
		return ai106SA;
	}
	public void setAi106SA(String ai106sa) {
		ai106SA = ai106sa;
	}
	public String getAi107SA() {
		return ai107SA;
	}
	public void setAi107SA(String ai107sa) {
		ai107SA = ai107sa;
	}
	public String getAi108SA() {
		return ai108SA;
	}
	public void setAi108SA(String ai108sa) {
		ai108SA = ai108sa;
	}
	public String getAi109SA1() {
		return ai109SA1;
	}
	public void setAi109SA1(String ai109sa1) {
		ai109SA1 = ai109sa1;
	}
	public String getAi109SA2() {
		return ai109SA2;
	}
	public void setAi109SA2(String ai109sa2) {
		ai109SA2 = ai109sa2;
	}
	public String getAi109SA3() {
		return ai109SA3;
	}
	public void setAi109SA3(String ai109sa3) {
		ai109SA3 = ai109sa3;
	}
	public String getAi305SA1() {
		return ai305SA1;
	}
	public void setAi305SA1(String ai305sa1) {
		ai305SA1 = ai305sa1;
	}
	public String getAi305SA2() {
		return ai305SA2;
	}
	public void setAi305SA2(String ai305sa2) {
		ai305SA2 = ai305sa2;
	}
	public String getAi306SA() {
		return ai306SA;
	}
	public void setAi306SA(String ai306sa) {
		ai306SA = ai306sa;
	}
	public String getAi307SA1() {
		return ai307SA1;
	}
	public void setAi307SA1(String ai307sa1) {
		ai307SA1 = ai307sa1;
	}
	public String getAi307SA2() {
		return ai307SA2;
	}
	public void setAi307SA2(String ai307sa2) {
		ai307SA2 = ai307sa2;
	}
	public String getAi308SA1() {
		return ai308SA1;
	}
	public void setAi308SA1(String ai308sa1) {
		ai308SA1 = ai308sa1;
	}
	public String getAi308SA2() {
		return ai308SA2;
	}
	public void setAi308SA2(String ai308sa2) {
		ai308SA2 = ai308sa2;
	}
	public String getAi309SA1() {
		return ai309SA1;
	}
	public void setAi309SA1(String ai309sa1) {
		ai309SA1 = ai309sa1;
	}
	public String getAi309SA2() {
		return ai309SA2;
	}
	public void setAi309SA2(String ai309sa2) {
		ai309SA2 = ai309sa2;
	}
	public String getAi310SA11() {
		return ai310SA11;
	}
	public void setAi310SA11(String ai310sa11) {
		ai310SA11 = ai310sa11;
	}
	public String getAi310SA12() {
		return ai310SA12;
	}
	public void setAi310SA12(String ai310sa12) {
		ai310SA12 = ai310sa12;
	}
	public String getAi310SA21() {
		return ai310SA21;
	}
	public void setAi310SA21(String ai310sa21) {
		ai310SA21 = ai310sa21;
	}
	public String getAi310SA22() {
		return ai310SA22;
	}
	public void setAi310SA22(String ai310sa22) {
		ai310SA22 = ai310sa22;
	}
	public String getAi311SA11() {
		return ai311SA11;
	}
	public void setAi311SA11(String ai311sa11) {
		ai311SA11 = ai311sa11;
	}
	public String getAi311SA12() {
		return ai311SA12;
	}
	public void setAi311SA12(String ai311sa12) {
		ai311SA12 = ai311sa12;
	}
	public String getAi311SA21() {
		return ai311SA21;
	}
	public void setAi311SA21(String ai311sa21) {
		ai311SA21 = ai311sa21;
	}
	public String getAi311SA22() {
		return ai311SA22;
	}
	public void setAi311SA22(String ai311sa22) {
		ai311SA22 = ai311sa22;
	}
	public String getAi311SA31() {
		return ai311SA31;
	}
	public void setAi311SA31(String ai311sa31) {
		ai311SA31 = ai311sa31;
	}
	public String getAi311SA32() {
		return ai311SA32;
	}
	public void setAi311SA32(String ai311sa32) {
		ai311SA32 = ai311sa32;
	}
	public String getAi312SA1() {
		return ai312SA1;
	}
	public void setAi312SA1(String ai312sa1) {
		ai312SA1 = ai312sa1;
	}
	public String getAi312SA2() {
		return ai312SA2;
	}
	public void setAi312SA2(String ai312sa2) {
		ai312SA2 = ai312sa2;
	}
	public String getAi312SA3() {
		return ai312SA3;
	}
	public void setAi312SA3(String ai312sa3) {
		ai312SA3 = ai312sa3;
	}
	public String getAi313SA() {
		return ai313SA;
	}
	public void setAi313SA(String ai313sa) {
		ai313SA = ai313sa;
	}
	public String getAi314SA() {
		return ai314SA;
	}
	public void setAi314SA(String ai314sa) {
		ai314SA = ai314sa;
	}


	
	
	
	
}
