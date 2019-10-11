package com.reinfo.ipoly.module.models;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class IlfQuot implements Serializable, Cloneable {
	private String quotNo;
	
	@JsonFormat(pattern="MM/dd/yyyy", timezone = "GMT+8")
	private java.util.Date quotDate;
	private String quotRefno;
	private String quotAgtId;
	private String quotAgtName;
	private String quotAgtTel;
	private String quotPlan;
	private String quotYears;
	private String quotCcy;
	private String quotPaymode;
	private String quotDividend;
	private String quotJointLife;
	private java.math.BigDecimal quotLoading;
	private java.math.BigDecimal quotFactor;
	private String quotPlanWaiver;
	private String quotFinsuredName;
	private Integer quotFinsuredAge;
	private String quotFinsuredGender;
	private String quotFinsuredSmoker;
	private String quotSinsuredName;
	private Integer quotSinsuredAge;
	private String quotSinsuredGender;
	private String quotSinsuredSmoker;
	private String quotWinsuredName;
	private Integer quotWinsuredAge;
	private String quotWinsuredGender;
	private String quotWinsuredSmoker;
	private String quotPlanCode;
	private String quotPlanCodeDesc;
	private java.math.BigDecimal quotTotalPrem;
	private java.math.BigDecimal quotTotalPremAnn;
	private java.util.Date quotCdate;
	private String quotCuser;
	private java.util.Date quotAdate;
	private String quotAuser;
    private String quotDateStr;
    private String quotStatus;
	
	public void setQuotNo(String quotNo) {
		this.quotNo = quotNo;
	}
	public String getQuotNo() {
		return quotNo;
	}
	public void setQuotDate(java.util.Date quotDate) {
		this.quotDate = quotDate;
	}
	public java.util.Date getQuotDate() {
		return quotDate;
	}
	public void setQuotRefno(String quotRefno) {
		this.quotRefno = quotRefno;
	}
	public String getQuotRefno() {
		return quotRefno;
	}
	public void setQuotAgtId(String quotAgtId) {
		this.quotAgtId = quotAgtId;
	}
	public String getQuotAgtId() {
		return quotAgtId;
	}
	public void setQuotAgtName(String quotAgtName) {
		this.quotAgtName = quotAgtName;
	}
	public String getQuotAgtName() {
		return quotAgtName;
	}
	public void setQuotAgtTel(String quotAgtTel) {
		this.quotAgtTel = quotAgtTel;
	}
	public String getQuotAgtTel() {
		return quotAgtTel;
	}
	public void setQuotPlan(String quotPlan) {
		this.quotPlan = quotPlan;
	}
	public String getQuotPlan() {
		return quotPlan;
	}
	public void setQuotYears(String quotYears) {
		this.quotYears = quotYears;
	}
	public String getQuotYears() {
		return quotYears;
	}
	public void setQuotCcy(String quotCcy) {
		this.quotCcy = quotCcy;
	}
	public String getQuotCcy() {
		return quotCcy;
	}
	public void setQuotPaymode(String quotPaymode) {
		this.quotPaymode = quotPaymode;
	}
	public String getQuotPaymode() {
		return quotPaymode;
	}
	public void setQuotDividend(String quotDividend) {
		this.quotDividend = quotDividend;
	}
	public String getQuotDividend() {
		return quotDividend;
	}
	public void setQuotJointLife(String quotJointLife) {
		this.quotJointLife = quotJointLife;
	}
	public String getQuotJointLife() {
		return quotJointLife;
	}
	public void setQuotLoading(java.math.BigDecimal quotLoading) {
		this.quotLoading = quotLoading;
	}
	public java.math.BigDecimal getQuotLoading() {
		return quotLoading;
	}
	public void setQuotFactor(java.math.BigDecimal quotFactor) {
		this.quotFactor = quotFactor;
	}
	public java.math.BigDecimal getQuotFactor() {
		return quotFactor;
	}
	public void setQuotPlanWaiver(String quotPlanWaiver) {
		this.quotPlanWaiver = quotPlanWaiver;
	}
	public String getQuotPlanWaiver() {
		return quotPlanWaiver;
	}
	public void setQuotFinsuredName(String quotFinsuredName) {
		this.quotFinsuredName = quotFinsuredName;
	}
	public String getQuotFinsuredName() {
		return quotFinsuredName;
	}
	public void setQuotFinsuredAge(Integer quotFinsuredAge) {
		this.quotFinsuredAge = quotFinsuredAge;
	}
	public Integer getQuotFinsuredAge() {
		return quotFinsuredAge;
	}
	public void setQuotFinsuredGender(String quotFinsuredGender) {
		this.quotFinsuredGender = quotFinsuredGender;
	}
	public String getQuotFinsuredGender() {
		return quotFinsuredGender;
	}
	public void setQuotFinsuredSmoker(String quotFinsuredSmoker) {
		this.quotFinsuredSmoker = quotFinsuredSmoker;
	}
	public String getQuotFinsuredSmoker() {
		return quotFinsuredSmoker;
	}
	public void setQuotSinsuredName(String quotSinsuredName) {
		this.quotSinsuredName = quotSinsuredName;
	}
	public String getQuotSinsuredName() {
		return quotSinsuredName;
	}
	public void setQuotSinsuredAge(Integer quotSinsuredAge) {
		this.quotSinsuredAge = quotSinsuredAge;
	}
	public Integer getQuotSinsuredAge() {
		return quotSinsuredAge;
	}
	public void setQuotSinsuredGender(String quotSinsuredGender) {
		this.quotSinsuredGender = quotSinsuredGender;
	}
	public String getQuotSinsuredGender() {
		return quotSinsuredGender;
	}
	public void setQuotSinsuredSmoker(String quotSinsuredSmoker) {
		this.quotSinsuredSmoker = quotSinsuredSmoker;
	}
	public String getQuotSinsuredSmoker() {
		return quotSinsuredSmoker;
	}
	public void setQuotWinsuredName(String quotWinsuredName) {
		this.quotWinsuredName = quotWinsuredName;
	}
	public String getQuotWinsuredName() {
		return quotWinsuredName;
	}
	public void setQuotWinsuredAge(Integer quotWinsuredAge) {
		this.quotWinsuredAge = quotWinsuredAge;
	}
	public Integer getQuotWinsuredAge() {
		return quotWinsuredAge;
	}
	public void setQuotWinsuredGender(String quotWinsuredGender) {
		this.quotWinsuredGender = quotWinsuredGender;
	}
	public String getQuotWinsuredGender() {
		return quotWinsuredGender;
	}
	public void setQuotWinsuredSmoker(String quotWinsuredSmoker) {
		this.quotWinsuredSmoker = quotWinsuredSmoker;
	}
	public String getQuotWinsuredSmoker() {
		return quotWinsuredSmoker;
	}
	public void setQuotPlanCode(String quotPlanCode) {
		this.quotPlanCode = quotPlanCode;
	}
	public String getQuotPlanCode() {
		return quotPlanCode;
	}
	public void setQuotPlanCodeDesc(String quotPlanCodeDesc) {
		this.quotPlanCodeDesc = quotPlanCodeDesc;
	}
	public String getQuotPlanCodeDesc() {
		return quotPlanCodeDesc;
	}
	public void setQuotTotalPrem(java.math.BigDecimal quotTotalPrem) {
		this.quotTotalPrem = quotTotalPrem;
	}
	public java.math.BigDecimal getQuotTotalPrem() {
		return quotTotalPrem;
	}
	public void setQuotTotalPremAnn(java.math.BigDecimal quotTotalPremAnn) {
		this.quotTotalPremAnn = quotTotalPremAnn;
	}
	public java.math.BigDecimal getQuotTotalPremAnn() {
		return quotTotalPremAnn;
	}
	public void setQuotCdate(java.util.Date quotCdate) {
		this.quotCdate = quotCdate;
	}
	public java.util.Date getQuotCdate() {
		return quotCdate;
	}
	public void setQuotCuser(String quotCuser) {
		this.quotCuser = quotCuser;
	}
	public String getQuotCuser() {
		return quotCuser;
	}
	public void setQuotAdate(java.util.Date quotAdate) {
		this.quotAdate = quotAdate;
	}
	public java.util.Date getQuotAdate() {
		return quotAdate;
	}
	public void setQuotAuser(String quotAuser) {
		this.quotAuser = quotAuser;
	}
	public String getQuotAuser() {
		return quotAuser;
	}
  
	private static final String Table = "ilf_quot";
	private static final String Alias = "as_ilf_quot";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrQuotNo = Alias+".quot_no";
	public static final String DBStrQuotDate = Alias+".quot_date";
	public static final String DBStrQuotRefno = Alias+".quot_refno";
	public static final String DBStrQuotAgtId = Alias+".quot_agt_id";
	public static final String DBStrQuotAgtName = Alias+".quot_agt_name";
	public static final String DBStrQuotAgtTel = Alias+".quot_agt_tel";
	public static final String DBStrQuotPlan = Alias+".quot_plan";
	public static final String DBStrQuotYears = Alias+".quot_years";
	public static final String DBStrQuotCcy = Alias+".quot_ccy";
	public static final String DBStrQuotPaymode = Alias+".quot_paymode";
	public static final String DBStrQuotDividend = Alias+".quot_dividend";
	public static final String DBStrQuotJointLife = Alias+".quot_joint_life";
	public static final String DBStrQuotLoading = Alias+".quot_loading";
	public static final String DBStrQuotFactor = Alias+".quot_factor";
	public static final String DBStrQuotPlanWaiver = Alias+".quot_plan_waiver";
	public static final String DBStrQuotFinsuredName = Alias+".quot_finsured_name";
	public static final String DBStrQuotFinsuredAge = Alias+".quot_finsured_age";
	public static final String DBStrQuotFinsuredGender = Alias+".quot_finsured_gender";
	public static final String DBStrQuotFinsuredSmoker = Alias+".quot_finsured_smoker";
	public static final String DBStrQuotSinsuredName = Alias+".quot_sinsured_name";
	public static final String DBStrQuotSinsuredAge = Alias+".quot_sinsured_age";
	public static final String DBStrQuotSinsuredGender = Alias+".quot_sinsured_gender";
	public static final String DBStrQuotSinsuredSmoker = Alias+".quot_sinsured_smoker";
	public static final String DBStrQuotWinsuredName = Alias+".quot_winsured_name";
	public static final String DBStrQuotWinsuredAge = Alias+".quot_winsured_age";
	public static final String DBStrQuotWinsuredGender = Alias+".quot_winsured_gender";
	public static final String DBStrQuotWinsuredSmoker = Alias+".quot_winsured_smoker";
	public static final String DBStrQuotPlanCode = Alias+".quot_plan_code";
	public static final String DBStrQuotPlanCodeDesc = Alias+".quot_plan_code_desc";
	public static final String DBStrQuotTotalPrem = Alias+".quot_total_prem";
	public static final String DBStrQuotTotalPremAnn = Alias+".quot_total_prem_ann";
	public static final String DBStrQuotCdate = Alias+".quot_cdate";
	public static final String DBStrQuotCuser = Alias+".quot_cuser";
	public static final String DBStrQuotAdate = Alias+".quot_adate";
	public static final String DBStrQuotAuser = Alias+".quot_auser";
	
	@Override
	public IlfQuot clone() {
		IlfQuot o = null;
		try{
			o = (IlfQuot)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
	public String getQuotDateStr() {
		return quotDateStr;
	}
	public void setQuotDateStr(String quotDateStr) {
		this.quotDateStr = quotDateStr;
	}
	public String getQuotStatus() {
		return quotStatus;
	}
	public void setQuotStatus(String quotStatus) {
		this.quotStatus = quotStatus;
	}
}

