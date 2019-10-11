package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdCovRid implements Serializable, Cloneable {
	private Integer compCode;
	private String covCode;
	private String covBand;
	private String ridCode;
	private String ridBand;
	private String ridClass;
	private String ctyGroup;
	private String compulsoryInd;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private java.util.Date createDate;
	private String createBy;
	private java.util.Date updDate;
	private String updBy;
	private java.util.Date apprDate;
	private String apprBy;
	private Integer orderSeq;
	private java.util.Date effDate;
	private java.util.Date expDate;

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
	public void setCovBand(String covBand) {
		this.covBand = covBand;
	}
	public String getCovBand() {
		return covBand;
	}
	public void setRidCode(String ridCode) {
		this.ridCode = ridCode;
	}
	public String getRidCode() {
		return ridCode;
	}
	public void setRidBand(String ridBand) {
		this.ridBand = ridBand;
	}
	public String getRidBand() {
		return ridBand;
	}
	public void setRidClass(String ridClass) {
		this.ridClass = ridClass;
	}
	public String getRidClass() {
		return ridClass;
	}
	public void setCtyGroup(String ctyGroup) {
		this.ctyGroup = ctyGroup;
	}
	public String getCtyGroup() {
		return ctyGroup;
	}
	public void setCompulsoryInd(String compulsoryInd) {
		this.compulsoryInd = compulsoryInd;
	}
	public String getCompulsoryInd() {
		return compulsoryInd;
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
	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}
	public Integer getOrderSeq() {
		return orderSeq;
	}
	public void setEffDate(java.util.Date effDate) {
		this.effDate = effDate;
	}
	public java.util.Date getEffDate() {
		return effDate;
	}
	public void setExpDate(java.util.Date expDate) {
		this.expDate = expDate;
	}
	public java.util.Date getExpDate() {
		return expDate;
	}
  
	private static final String Table = "prod_cov_rid";
	private static final String Alias = "as_prod_cov_rid";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrCovBand = Alias+".cov_band";
	public static final String DBStrRidCode = Alias+".rid_code";
	public static final String DBStrRidBand = Alias+".rid_band";
	public static final String DBStrRidClass = Alias+".rid_class";
	public static final String DBStrCtyGroup = Alias+".cty_group";
	public static final String DBStrCompulsoryInd = Alias+".compulsory_ind";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrOrderSeq = Alias+".order_seq";
	public static final String DBStrEffDate = Alias+".eff_date";
	public static final String DBStrExpDate = Alias+".exp_date";
	
	@Override
	public ProdCovRid clone() {
		ProdCovRid o = null;
		try{
			o = (ProdCovRid)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

