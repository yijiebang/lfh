package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdCountryMod implements Serializable, Cloneable {
	private Integer compCode;
	private String ctyGroup;
	private String covCode;
	private String payMode;
	private java.math.BigDecimal modFac;
	private Integer coverMth;
	private String modeNameEng;
	private String modeNameOth;
	private Integer modFacDiv;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private java.util.Date createDate;
	private String createBy;
	private java.util.Date updDate;
	private String updBy;
	private java.util.Date apprDate;
	private String apprBy;
	private String coeffType;

	public void setCompCode(Integer compCode) {
		this.compCode = compCode;
	}
	public Integer getCompCode() {
		return compCode;
	}
	public void setCtyGroup(String ctyGroup) {
		this.ctyGroup = ctyGroup;
	}
	public String getCtyGroup() {
		return ctyGroup;
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
	public void setModFac(java.math.BigDecimal modFac) {
		this.modFac = modFac;
	}
	public java.math.BigDecimal getModFac() {
		return modFac;
	}
	public void setCoverMth(Integer coverMth) {
		this.coverMth = coverMth;
	}
	public Integer getCoverMth() {
		return coverMth;
	}
	public void setModeNameEng(String modeNameEng) {
		this.modeNameEng = modeNameEng;
	}
	public String getModeNameEng() {
		return modeNameEng;
	}
	public void setModeNameOth(String modeNameOth) {
		this.modeNameOth = modeNameOth;
	}
	public String getModeNameOth() {
		return modeNameOth;
	}
	public void setModFacDiv(Integer modFacDiv) {
		this.modFacDiv = modFacDiv;
	}
	public Integer getModFacDiv() {
		return modFacDiv;
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
	public void setCoeffType(String coeffType) {
		this.coeffType = coeffType;
	}
	public String getCoeffType() {
		return coeffType;
	}
  
	private static final String Table = "prod_country_mod";
	private static final String Alias = "as_prod_country_mod";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrCtyGroup = Alias+".cty_group";
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrPayMode = Alias+".pay_mode";
	public static final String DBStrModFac = Alias+".mod_fac";
	public static final String DBStrCoverMth = Alias+".cover_mth";
	public static final String DBStrModeNameEng = Alias+".mode_name_eng";
	public static final String DBStrModeNameOth = Alias+".mode_name_oth";
	public static final String DBStrModFacDiv = Alias+".mod_fac_div";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrCoeffType = Alias+".coeff_type";
	
	@Override
	public ProdCountryMod clone() {
		ProdCountryMod o = null;
		try{
			o = (ProdCountryMod)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

