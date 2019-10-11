package com.reinfo.ipoly.module.models;

import java.math.BigDecimal;
import java.util.List;

public class QuationProd{

	private String quotNo;
	private String quotPlanWaiver;
	private String quotPlanCode;
	private String quotPlanCodeDesc;
	private BigDecimal quotTotalPrem;
	private BigDecimal quotTotalPremAnn;
	private List<Code> quotplanList;
	
	public String getQuotNo() {
		return quotNo;
	}
	public void setQuotNo(String quotNo) {
		this.quotNo = quotNo;
	}
	public String getQuotPlanWaiver() {
		return quotPlanWaiver;
	}
	public void setQuotPlanWaiver(String quotPlanWaiver) {
		this.quotPlanWaiver = quotPlanWaiver;
	}
	public String getQuotPlanCode() {
		return quotPlanCode;
	}
	public void setQuotPlanCode(String quotPlanCode) {
		this.quotPlanCode = quotPlanCode;
	}
	public String getQuotPlanCodeDesc() {
		return quotPlanCodeDesc;
	}
	public void setQuotPlanCodeDesc(String quotPlanCodeDesc) {
		this.quotPlanCodeDesc = quotPlanCodeDesc;
	}
	public BigDecimal getQuotTotalPrem() {
		return quotTotalPrem;
	}
	public void setQuotTotalPrem(BigDecimal quotTotalPrem) {
		this.quotTotalPrem = quotTotalPrem;
	}
	public BigDecimal getQuotTotalPremAnn() {
		return quotTotalPremAnn;
	}
	public void setQuotTotalPremAnn(BigDecimal quotTotalPremAnn) {
		this.quotTotalPremAnn = quotTotalPremAnn;
	}
	public List<Code> getQuotplanList() {
		return quotplanList;
	}
	public void setQuotplanList(List<Code> quotplanList) {
		this.quotplanList = quotplanList;
	}
}
