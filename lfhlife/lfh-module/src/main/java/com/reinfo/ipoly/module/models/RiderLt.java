package com.reinfo.ipoly.module.models;

public class RiderLt implements Rider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int seq;
	private String ridLab1;
	private String riderPlan;
	private String riderSAcover;
	private String ridAPm;
	
	private String riderTemplate;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRidLab1() {
		return ridLab1;
	}
	public void setRidLab1(String ridLab1) {
		this.ridLab1 = ridLab1;
	}
	public String getRiderPlan() {
		return riderPlan;
	}
	public void setRiderPlan(String riderPlan) {
		this.riderPlan = riderPlan;
	}
	public String getRiderSAcover() {
		return riderSAcover;
	}
	public void setRiderSAcover(String riderSAcover) {
		this.riderSAcover = riderSAcover;
	}
	public String getRidAPm() {
		return ridAPm;
	}
	public void setRidAPm(String ridAPm) {
		this.ridAPm = ridAPm;
	}
	public String getRiderTemplate() {
		return riderTemplate;
	}
	public void setRiderTemplate(String riderTemplate) {
		this.riderTemplate = riderTemplate;
	}
	
	
}
