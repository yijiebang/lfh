package com.reinfo.ipoly.module.models;

public class QuotPlanDetail extends IlfQuotPlan {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String planInd;
	private String productType;
	private String productLine;
	private int sort;

	public String getPlanInd() {
		return planInd;
	}

	public void setPlanInd(String planInd) {
		this.planInd = planInd;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
}
