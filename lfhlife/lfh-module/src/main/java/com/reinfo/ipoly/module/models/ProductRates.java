package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProductRates implements Serializable, Cloneable {
	private String compCode;
	private String covCode;
	private String covClass;
	private String covBand;
	private String basicPlanCode;
	private String gender;
	private String smokeInd;
	private String currency;
	private String payMode;
	private String issAge;
	private String rateType;
	private String rateMode;
	private java.util.Date effectiveDate;
	private java.util.Date expiryDate;
	private Integer revision;
	private java.util.Date createdDate;
	private java.util.Date updatedDate;
	private String status;
	private Object rateList;

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}
	public String getCompCode() {
		return compCode;
	}
	public void setCovCode(String covCode) {
		this.covCode = covCode;
	}
	public String getCovCode() {
		return covCode;
	}
	public void setCovClass(String covClass) {
		this.covClass = covClass;
	}
	public String getCovClass() {
		return covClass;
	}
	public void setCovBand(String covBand) {
		this.covBand = covBand;
	}
	public String getCovBand() {
		return covBand;
	}
	public void setBasicPlanCode(String basicPlanCode) {
		this.basicPlanCode = basicPlanCode;
	}
	public String getBasicPlanCode() {
		return basicPlanCode;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public void setSmokeInd(String smokeInd) {
		this.smokeInd = smokeInd;
	}
	public String getSmokeInd() {
		return smokeInd;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrency() {
		return currency;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setIssAge(String issAge) {
		this.issAge = issAge;
	}
	public String getIssAge() {
		return issAge;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateMode(String rateMode) {
		this.rateMode = rateMode;
	}
	public String getRateMode() {
		return rateMode;
	}
	public void setEffectiveDate(java.util.Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public java.util.Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setExpiryDate(java.util.Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public java.util.Date getExpiryDate() {
		return expiryDate;
	}
	public void setRevision(Integer revision) {
		this.revision = revision;
	}
	public Integer getRevision() {
		return revision;
	}
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}
	public java.util.Date getCreatedDate() {
		return createdDate;
	}
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public java.util.Date getUpdatedDate() {
		return updatedDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setRateList(Object rateList) {
		this.rateList = rateList;
	}
	public Object getRateList() {
		return rateList;
	}
  
	private static final String Table = "product_rates";
	private static final String Alias = "as_product_rates";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrCovClass = Alias+".cov_class";
	public static final String DBStrCovBand = Alias+".cov_band";
	public static final String DBStrBasicPlanCode = Alias+".basic_plan_code";
	public static final String DBStrGender = Alias+".gender";
	public static final String DBStrSmokeInd = Alias+".smoke_ind";
	public static final String DBStrCurrency = Alias+".currency";
	public static final String DBStrPayMode = Alias+".pay_mode";
	public static final String DBStrIssAge = Alias+".iss_age";
	public static final String DBStrRateType = Alias+".rate_type";
	public static final String DBStrRateMode = Alias+".rate_mode";
	public static final String DBStrEffectiveDate = Alias+".effective_date";
	public static final String DBStrExpiryDate = Alias+".expiry_date";
	public static final String DBStrRevision = Alias+".revision";
	public static final String DBStrCreatedDate = Alias+".created_date";
	public static final String DBStrUpdatedDate = Alias+".updated_date";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrRateList = Alias+".rate_list";
	
	@Override
	public ProductRates clone() {
		ProductRates o = null;
		try{
			o = (ProductRates)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

