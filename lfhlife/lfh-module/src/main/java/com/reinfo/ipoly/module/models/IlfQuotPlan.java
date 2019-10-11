package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class IlfQuotPlan implements Serializable, Cloneable {
	private String quplanNo;
	private String quplanPlanCode;
	private String quplanRiderCode;
	private String quplanRiderCodeDesc;
	private String quplanRiderClass;
	private String quplanRiderClassDesc;
	private java.math.BigDecimal quplanSumInsured;
	private java.math.BigDecimal quplanAnnPremium;
	private java.util.Date quplanCdate;
	private String quplanCuser;
	private java.util.Date quplanAdate;
	private String quplanAuser;
	private Integer quplanSeqno;

	private String product_line;

	public String getProduct_line() {
		return product_line;
	}

	public void setProduct_line(String product_line) {
		this.product_line = product_line;
	}

	public void setQuplanNo(String quplanNo) {
		this.quplanNo = quplanNo;
	}
	public String getQuplanNo() {
		return quplanNo;
	}
	public void setQuplanPlanCode(String quplanPlanCode) {
		this.quplanPlanCode = quplanPlanCode;
	}
	public String getQuplanPlanCode() {
		return quplanPlanCode;
	}
	public void setQuplanRiderCode(String quplanRiderCode) {
		this.quplanRiderCode = quplanRiderCode;
	}
	public String getQuplanRiderCode() {
		return quplanRiderCode;
	}
	public void setQuplanRiderCodeDesc(String quplanRiderCodeDesc) {
		this.quplanRiderCodeDesc = quplanRiderCodeDesc;
	}
	public String getQuplanRiderCodeDesc() {
		return quplanRiderCodeDesc;
	}
	public void setQuplanRiderClass(String quplanRiderClass) {
		this.quplanRiderClass = quplanRiderClass;
	}
	public String getQuplanRiderClass() {
		return quplanRiderClass;
	}
	public void setQuplanRiderClassDesc(String quplanRiderClassDesc) {
		this.quplanRiderClassDesc = quplanRiderClassDesc;
	}
	public String getQuplanRiderClassDesc() {
		return quplanRiderClassDesc;
	}
	public void setQuplanSumInsured(java.math.BigDecimal quplanSumInsured) {
		this.quplanSumInsured = quplanSumInsured;
	}
	public java.math.BigDecimal getQuplanSumInsured() {
		return quplanSumInsured;
	}
	public void setQuplanAnnPremium(java.math.BigDecimal quplanAnnPremium) {
		this.quplanAnnPremium = quplanAnnPremium;
	}
	public java.math.BigDecimal getQuplanAnnPremium() {
		return quplanAnnPremium;
	}
	public void setQuplanCdate(java.util.Date quplanCdate) {
		this.quplanCdate = quplanCdate;
	}
	public java.util.Date getQuplanCdate() {
		return quplanCdate;
	}
	public void setQuplanCuser(String quplanCuser) {
		this.quplanCuser = quplanCuser;
	}
	public String getQuplanCuser() {
		return quplanCuser;
	}
	public void setQuplanAdate(java.util.Date quplanAdate) {
		this.quplanAdate = quplanAdate;
	}
	public java.util.Date getQuplanAdate() {
		return quplanAdate;
	}
	public void setQuplanAuser(String quplanAuser) {
		this.quplanAuser = quplanAuser;
	}
	public String getQuplanAuser() {
		return quplanAuser;
	}
	public Integer getQuplanSeqno() {
		return quplanSeqno;
	}
	public void setQuplanSeqno(Integer quplanSeqno) {
		this.quplanSeqno = quplanSeqno;
	}
  
	private static final String Table = "ilf_quot_plan";
	private static final String Alias = "as_ilf_quot_plan";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrQuplanNo = Alias+".quplan_no";
	public static final String DBStrQuplanPlanCode = Alias+".quplan_plan_code";
	public static final String DBStrQuplanRiderCode = Alias+".quplan_rider_code";
	public static final String DBStrQuplanRiderCodeDesc = Alias+".quplan_rider_code_desc";
	public static final String DBStrQuplanRiderClass = Alias+".quplan_rider_class";
	public static final String DBStrQuplanRiderClassDesc = Alias+".quplan_rider_class_desc";
	public static final String DBStrQuplanSumInsured = Alias+".quplan_sum_insured";
	public static final String DBStrQuplanAnnPremium = Alias+".quplan_ann_premium";
	public static final String DBStrQuplanCdate = Alias+".quplan_cdate";
	public static final String DBStrQuplanCuser = Alias+".quplan_cuser";
	public static final String DBStrQuplanAdate = Alias+".quplan_adate";
	public static final String DBStrQuplanAuser = Alias+".quplan_auser";
	
	@Override
	public IlfQuotPlan clone() {
		IlfQuotPlan o = null;
		try{
			o = (IlfQuotPlan)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

