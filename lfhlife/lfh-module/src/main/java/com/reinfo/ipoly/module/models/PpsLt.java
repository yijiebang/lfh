package com.reinfo.ipoly.module.models;

import java.util.Date;
import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PpsLt extends Plan implements Pps {

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
	private Date ppsDate;
	private String insuredName;
	private int insuredAge;
	private String insuredGender;
	private String insuredSmoke;
	private String totalMPmDesc;
	private String basicPlan;
	private String ccy;
	private String basicSA;
	private String basAPm;
	private String totalAPm;
	private String totalMPm;
	private int ltYr;
	private String ltDesc1;
	private String ltDesc2;
	private String templateName;
	private String wpPbPlan;
	private String wpPbDesc;
	private String ridLab1;
	private String wpPbLab;
	
	@JsonProperty("rider")
	private LinkedList<Rider> riders;

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

	public Date getPpsDate() {
		return ppsDate;
	}

	public void setPpsDate(Date ppsDate) {
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

	public String getTotalMPmDesc() {
		return totalMPmDesc;
	}

	public void setTotalMPmDesc(String totalMPmDesc) {
		this.totalMPmDesc = totalMPmDesc;
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

	public String getTotalAPm() {
		return totalAPm;
	}

	public void setTotalAPm(String totalAPm) {
		this.totalAPm = totalAPm;
	}

	public String getTotalMPm() {
		return totalMPm;
	}

	public void setTotalMPm(String totalMPm) {
		this.totalMPm = totalMPm;
	}

	public int getLtYr() {
		return ltYr;
	}

	public void setLtYr(int ltYr) {
		this.ltYr = ltYr;
	}

	public String getLtDesc1() {
		return ltDesc1;
	}

	public void setLtDesc1(String ltDesc1) {
		this.ltDesc1 = ltDesc1;
	}

	public String getLtDesc2() {
		return ltDesc2;
	}

	public void setLtDesc2(String ltDesc2) {
		this.ltDesc2 = ltDesc2;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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

	public LinkedList<Rider> getRiders() {
		return riders;
	}

	public void setRiders(LinkedList<Rider> riders) {
		this.riders = riders;
	}


}
