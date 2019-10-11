package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdCovLine implements Serializable, Cloneable {
	private Integer compCode;
	private String covLineCode;
	private String covLineName;
	private String status;
	private java.util.Date createDate;
	private String createBy;
	private java.util.Date updDate;
	private String updBy;
	private String covTermRiderInd;
	private String gender;
	private java.math.BigDecimal age;

	public void setCompCode(Integer compCode) {
		this.compCode = compCode;
	}
	public Integer getCompCode() {
		return compCode;
	}
	public void setCovLineCode(String covLineCode) {
		this.covLineCode = covLineCode;
	}
	public String getCovLineCode() {
		return covLineCode;
	}
	public void setCovLineName(String covLineName) {
		this.covLineName = covLineName;
	}
	public String getCovLineName() {
		return covLineName;
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
	public void setCovTermRiderInd(String covTermRiderInd) {
		this.covTermRiderInd = covTermRiderInd;
	}
	public String getCovTermRiderInd() {
		return covTermRiderInd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.math.BigDecimal getAge() {
		return age;
	}
	public void setAge(java.math.BigDecimal age) {
		this.age = age;
	}
	
	private static final String Table = "prod_cov_line";
	private static final String Alias = "as_prod_cov_line";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrCovLineCode = Alias+".cov_line_code";
	public static final String DBStrCovLineName = Alias+".cov_line_name";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrCovTermRiderInd = Alias+".cov_term_rider_ind";
	
	@Override
	public ProdCovLine clone() {
		ProdCovLine o = null;
		try{
			o = (ProdCovLine)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
	
}

