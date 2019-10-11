package com.reinfo.ipoly.module.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RiderMed implements Rider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ridLab1;
	private String riderPlan;
 	private String ridLab2;
	private String ridAPm;

 	private int seq;
	
	@JsonIgnore
	private String riderTemplate;

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

	public String getRidLab2() {
		return ridLab2;
	}
	public void setRidLab2(String ridLab2) {
		this.ridLab2 = ridLab2;
	}
	public String getRidAPm() {
		return ridAPm;
	}
	public void setRidAPm(String ridAPm) {
		this.ridAPm = ridAPm;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRiderTemplate() {
		return riderTemplate;
	}
	public void setRiderTemplate(String riderTemplate) {
		this.riderTemplate = riderTemplate;
	}
	
	
	
}
