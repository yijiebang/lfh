package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdPolFee implements Serializable, Cloneable {
	private Integer compCode;
	private String covCode;
	private String payMode;
	private java.util.Date effDate;
	private String ccy;
	private Integer covYr;
	private Integer polFee;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private String createBy;
	private java.util.Date createDate;
	private String updBy;
	private java.util.Date updDate;
	private String apprBy;
	private java.util.Date apprDate;

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
	public void setEffDate(java.util.Date effDate) {
		this.effDate = effDate;
	}
	public java.util.Date getEffDate() {
		return effDate;
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
	public void setPolFee(Integer polFee) {
		this.polFee = polFee;
	}
	public Integer getPolFee() {
		return polFee;
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
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	public String getUpdBy() {
		return updBy;
	}
	public void setUpdDate(java.util.Date updDate) {
		this.updDate = updDate;
	}
	public java.util.Date getUpdDate() {
		return updDate;
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
  
	private static final String Table = "prod_pol_fee";
	private static final String Alias = "as_prod_pol_fee";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrPayMode = Alias+".pay_mode";
	public static final String DBStrEffDate = Alias+".eff_date";
	public static final String DBStrCcy = Alias+".ccy";
	public static final String DBStrCovYr = Alias+".cov_yr";
	public static final String DBStrPolFee = Alias+".pol_fee";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	
	@Override
	public ProdPolFee clone() {
		ProdPolFee o = null;
		try{
			o = (ProdPolFee)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

