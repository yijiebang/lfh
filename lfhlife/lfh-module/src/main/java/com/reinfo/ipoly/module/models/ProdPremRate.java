package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdPremRate implements Serializable, Cloneable {
	private String covCode;
	private java.util.Date effDate;
	private String covClass;
	private String covBand;
	private String sex;
	private String smoke;
	private String ccy;
	private Integer covYr;
	private String payMode;
	private Integer premTerm;
	private Integer benefitTerm;
	private Integer issAge;
	private Integer refundAge;
	private java.math.BigDecimal premRate;
	private java.math.BigDecimal wpRate;
	private String planCode;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private java.util.Date createDate;
	private String createBy;
	private java.util.Date updDate;
	private String updBy;
	private java.util.Date apprDate;
	private String apprBy;
	private Integer scale;

	public void setCovCode(String covCode) {
		this.covCode = covCode;
	}
	public String getCovCode() {
		return covCode;
	}
	public void setEffDate(java.util.Date effDate) {
		this.effDate = effDate;
	}
	public java.util.Date getEffDate() {
		return effDate;
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
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCovYr(Integer covYr) {
		this.covYr = covYr;
	}
	public Integer getCovYr() {
		return covYr;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPremTerm(Integer premTerm) {
		this.premTerm = premTerm;
	}
	public Integer getPremTerm() {
		return premTerm;
	}
	public void setBenefitTerm(Integer benefitTerm) {
		this.benefitTerm = benefitTerm;
	}
	public Integer getBenefitTerm() {
		return benefitTerm;
	}
	public void setIssAge(Integer issAge) {
		this.issAge = issAge;
	}
	public Integer getIssAge() {
		return issAge;
	}
	public void setRefundAge(Integer refundAge) {
		this.refundAge = refundAge;
	}
	public Integer getRefundAge() {
		return refundAge;
	}
	public void setPremRate(java.math.BigDecimal premRate) {
		this.premRate = premRate;
	}
	public java.math.BigDecimal getPremRate() {
		return premRate;
	}
	public void setWpRate(java.math.BigDecimal wpRate) {
		this.wpRate = wpRate;
	}
	public java.math.BigDecimal getWpRate() {
		return wpRate;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setRefCnt(Integer refCnt) {
		this.refCnt = refCnt;
	}
	public Integer getRefCnt() {
		return refCnt;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setUpdDate(java.util.Date updDate) {
		this.updDate = updDate;
	}
	public java.util.Date getUpdDate() {
		return updDate;
	}
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	public String getUpdBy() {
		return updBy;
	}
	public void setApprDate(java.util.Date apprDate) {
		this.apprDate = apprDate;
	}
	public java.util.Date getApprDate() {
		return apprDate;
	}
	public void setApprBy(String apprBy) {
		this.apprBy = apprBy;
	}
	public String getApprBy() {
		return apprBy;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public Integer getScale() {
		return scale;
	}
  
	private static final String Table = "prod_prem_rate";
	private static final String Alias = "as_prod_prem_rate";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrEffDate = Alias+".eff_date";
	public static final String DBStrCovClass = Alias+".cov_class";
	public static final String DBStrCovBand = Alias+".cov_band";
	public static final String DBStrSex = Alias+".sex";
	public static final String DBStrSmoke = Alias+".smoke";
	public static final String DBStrCcy = Alias+".ccy";
	public static final String DBStrCovYr = Alias+".cov_yr";
	public static final String DBStrPayMode = Alias+".pay_mode";
	public static final String DBStrPremTerm = Alias+".prem_term";
	public static final String DBStrBenefitTerm = Alias+".benefit_term";
	public static final String DBStrIssAge = Alias+".iss_age";
	public static final String DBStrRefundAge = Alias+".refund_age";
	public static final String DBStrPremRate = Alias+".prem_rate";
	public static final String DBStrWpRate = Alias+".wp_rate";
	public static final String DBStrPlanCode = Alias+".plan_code";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrScale = Alias+".scale";
	
	@Override
	public ProdPremRate clone() {
		ProdPremRate o = null;
		try{
			o = (ProdPremRate)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

