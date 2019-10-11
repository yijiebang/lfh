package com.reinfo.ipoly.module.models;

import java.math.BigDecimal;

public class Code {

	private String quplanRiderCode;
	private String quplanRiderCodeDesc;
	private String quplanRiderClass;
	private String quplanRiderClassDesc;
	private BigDecimal quplanSumInsured;
	private BigDecimal quplanAnnPremium;
	private String quplanTermRiderIndex;

	public String getQuplanRiderCode() {
		return quplanRiderCode;
	}
	public void setQuplanRiderCode(String quplanRiderCode) {
		this.quplanRiderCode = quplanRiderCode;
	}
	public String getQuplanRiderCodeDesc() {
		return quplanRiderCodeDesc;
	}
	public void setQuplanRiderCodeDesc(String quplanRiderCodeDesc) {
		this.quplanRiderCodeDesc = quplanRiderCodeDesc;
	}
	public String getQuplanRiderClass() {
		return quplanRiderClass;
	}
	public void setQuplanRiderClass(String quplanRiderClass) {
		this.quplanRiderClass = quplanRiderClass;
	}
	public String getQuplanRiderClassDesc() {
		return quplanRiderClassDesc;
	}
	public void setQuplanRiderClassDesc(String quplanRiderClassDesc) {
		this.quplanRiderClassDesc = quplanRiderClassDesc;
	}
	public BigDecimal getQuplanSumInsured() {
		return quplanSumInsured;
	}
	public void setQuplanSumInsured(BigDecimal quplanSumInsured) {
		this.quplanSumInsured = quplanSumInsured;
	}
	public BigDecimal getQuplanAnnPremium() {
		return quplanAnnPremium;
	}
	public void setQuplanAnnPremium(BigDecimal quplanAnnPremium) {
		this.quplanAnnPremium = quplanAnnPremium;
	}
	public String getQuplanTermRiderIndex() {
		return quplanTermRiderIndex;
	}
	public void setQuplanTermRiderIndex(String quplanTermRiderIndex) {
		this.quplanTermRiderIndex = quplanTermRiderIndex;
	}
}
