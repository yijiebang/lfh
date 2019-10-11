package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdPremLimt implements Serializable, Cloneable {
	private Integer compCode;
	private String covCode;
	private String payMode;
	private String ccy;
	private String ctyGroup;
	private java.math.BigDecimal minPrem;
	private java.math.BigDecimal minPolPrem;
	private String ruleDescEng;
	private String ruleDescOth;
	private java.math.BigDecimal bpMinPrem;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private String createBy;
	private java.util.Date createDate;
	private java.util.Date updDate;
	private String updBy;
	private String apprBy;
	private java.util.Date apprDate;
	private java.math.BigDecimal maxPrem;
	private java.math.BigDecimal maxPolPrem;
	private String custType;

	public void setCompCode(Integer compCode) {
		this.compCode = compCode;
	}
	public Integer getCompCode() {
		return compCode;
	}
	public void setCovCode(String covCode) {
		this.covCode = covCode;
	}
	public String getCovCode() {
		return covCode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCtyGroup(String ctyGroup) {
		this.ctyGroup = ctyGroup;
	}
	public String getCtyGroup() {
		return ctyGroup;
	}
	public void setMinPrem(java.math.BigDecimal minPrem) {
		this.minPrem = minPrem;
	}
	public java.math.BigDecimal getMinPrem() {
		return minPrem;
	}
	public void setMinPolPrem(java.math.BigDecimal minPolPrem) {
		this.minPolPrem = minPolPrem;
	}
	public java.math.BigDecimal getMinPolPrem() {
		return minPolPrem;
	}
	public void setRuleDescEng(String ruleDescEng) {
		this.ruleDescEng = ruleDescEng;
	}
	public String getRuleDescEng() {
		return ruleDescEng;
	}
	public void setRuleDescOth(String ruleDescOth) {
		this.ruleDescOth = ruleDescOth;
	}
	public String getRuleDescOth() {
		return ruleDescOth;
	}
	public void setBpMinPrem(java.math.BigDecimal bpMinPrem) {
		this.bpMinPrem = bpMinPrem;
	}
	public java.math.BigDecimal getBpMinPrem() {
		return bpMinPrem;
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
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate() {
		return createDate;
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
	public void setApprBy(String apprBy) {
		this.apprBy = apprBy;
	}
	public String getApprBy() {
		return apprBy;
	}
	public void setApprDate(java.util.Date apprDate) {
		this.apprDate = apprDate;
	}
	public java.util.Date getApprDate() {
		return apprDate;
	}
	public void setMaxPrem(java.math.BigDecimal maxPrem) {
		this.maxPrem = maxPrem;
	}
	public java.math.BigDecimal getMaxPrem() {
		return maxPrem;
	}
	public void setMaxPolPrem(java.math.BigDecimal maxPolPrem) {
		this.maxPolPrem = maxPolPrem;
	}
	public java.math.BigDecimal getMaxPolPrem() {
		return maxPolPrem;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustType() {
		return custType;
	}
  
	private static final String Table = "prod_prem_limt";
	private static final String Alias = "as_prod_prem_limt";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrPayMode = Alias+".pay_mode";
	public static final String DBStrCcy = Alias+".ccy";
	public static final String DBStrCtyGroup = Alias+".cty_group";
	public static final String DBStrMinPrem = Alias+".min_prem";
	public static final String DBStrMinPolPrem = Alias+".min_pol_prem";
	public static final String DBStrRuleDescEng = Alias+".rule_desc_eng";
	public static final String DBStrRuleDescOth = Alias+".rule_desc_oth";
	public static final String DBStrBpMinPrem = Alias+".bp_min_prem";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	public static final String DBStrMaxPrem = Alias+".max_prem";
	public static final String DBStrMaxPolPrem = Alias+".max_pol_prem";
	public static final String DBStrCustType = Alias+".cust_type";
	
	@Override
	public ProdPremLimt clone() {
		ProdPremLimt o = null;
		try{
			o = (ProdPremLimt)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

