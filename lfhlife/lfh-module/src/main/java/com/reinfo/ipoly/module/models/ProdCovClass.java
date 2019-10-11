package com.reinfo.ipoly.module.models;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProdCovClass implements Serializable, Cloneable {
	private Integer compCode;
	private String covCode;
	private String covClass;//int类型改成String
	private String ccy;
	private String className;
	private String classNameOth;
	private String covName;
	private String covNameOth;

	private String showSumInsured;	//新增一个字段，用于判断是否有保额输入框，保持和旧的一样
	private String covTermRiderInd;//判斷rider code

	private boolean selected;   //是否選中 ，true/false
 	private BigDecimal inputPremium,sumPremium;  //保額 //年繳保費

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setSumPremium(BigDecimal sumPremium) {
		this.sumPremium = sumPremium;
	}

	private String sumIns;
	private String sumInsOth;

	private java.math.BigDecimal sumInsVal;
	private String defaultval;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private java.util.Date updDate;
	private String updBy;
	private String createBy;
	private java.util.Date createDate;
	private String apprBy;
	private java.util.Date apprDate;




	public BigDecimal getInputPremium() {
		return inputPremium;
	}

	public void setInputPremium(BigDecimal inputPremium) {
		this.inputPremium = inputPremium;
	}

	public BigDecimal getSumPremium() {
		return sumPremium;
	}

	public String getCovTermRiderInd() {
		return covTermRiderInd;
	}

	public void setCovTermRiderInd(String covTermRiderInd) {
		this.covTermRiderInd = covTermRiderInd;
	}

	public String getShowSumInsured() {
		return showSumInsured;
	}
	public void setShowSumInsured(String showSumInsured) {
		this.showSumInsured = showSumInsured;
	}
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
	public void setCovClass(String covClass) {
		this.covClass = covClass;
	}
	public String getCovClass() {
		return covClass;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getCcy() {
		return ccy;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassName() {
		return className;
	}
	public void setClassNameOth(String classNameOth) {
		this.classNameOth = classNameOth;
	}
	public String getClassNameOth() {
		return classNameOth;
	}
	public void setCovName(String covName) {
		this.covName = covName;
	}
	public String getCovName() {
		return covName;
	}
	public void setCovNameOth(String covNameOth) {
		this.covNameOth = covNameOth;
	}
	public String getCovNameOth() {
		return covNameOth;
	}
	public void setSumIns(String sumIns) {
		this.sumIns = sumIns;
	}
	public String getSumIns() {
		return sumIns;
	}
	public void setSumInsOth(String sumInsOth) {
		this.sumInsOth = sumInsOth;
	}
	public String getSumInsOth() {
		return sumInsOth;
	}
	public void setSumInsVal(java.math.BigDecimal sumInsVal) {
		this.sumInsVal = sumInsVal;
	}
	public java.math.BigDecimal getSumInsVal() {
		return sumInsVal;
	}
	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
	}
	public String getDefaultval() {
		return defaultval;
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
  
	private static final String Table = "prod_cov_class";
	private static final String Alias = "as_prod_cov_class";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrCovClass = Alias+".cov_class";
	public static final String DBStrCcy = Alias+".ccy";
	public static final String DBStrClassName = Alias+".class_name";
	public static final String DBStrClassNameOth = Alias+".class_name_oth";
	public static final String DBStrCovName = Alias+".cov_name";
	public static final String DBStrCovNameOth = Alias+".cov_name_oth";
	public static final String DBStrSumIns = Alias+".sum_ins";
	public static final String DBStrSumInsOth = Alias+".sum_ins_oth";
	public static final String DBStrSumInsVal = Alias+".sum_ins_val";
	public static final String DBStrDefaultval = Alias+".defaultval";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	
	@Override
	public ProdCovClass clone() {
		ProdCovClass o = null;
		try{
			o = (ProdCovClass)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}

}

