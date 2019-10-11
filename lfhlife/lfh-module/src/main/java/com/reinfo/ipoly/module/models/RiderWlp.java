package com.reinfo.ipoly.module.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RiderWlp implements Rider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ridLab1;
	private String riderPlan;
	private int ridMtm;
	private String ridLab2;
	private String ridAPm;
	private String ridMPm;
	private String payMode;
	private int ridPTm;
	private String ridLvlp;
	private String ridGrtRt;
	private String riderSAcover;
	private String riderSA;
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
	public int getRidMtm() {
		return ridMtm;
	}
	public void setRidMtm(int ridMtm) {
		this.ridMtm = ridMtm;
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
	public String getRidMPm() {
		return ridMPm;
	}
	public void setRidMPm(String ridMPm) {
		this.ridMPm = ridMPm;
	}
	
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public int getRidPTm() {
		return ridPTm;
	}
	public void setRidPTm(int ridPTm) {
		this.ridPTm = ridPTm;
	}
	public String getRidLvlp() {
		return ridLvlp;
	}
	public void setRidLvlp(String ridLvlp) {
		this.ridLvlp = ridLvlp;
	}
	public String getRidGrtRt() {
		return ridGrtRt;
	}
	public void setRidGrtRt(String ridGrtRt) {
		this.ridGrtRt = ridGrtRt;
	}
	public String getRiderSAcover() {
		return riderSAcover;
	}
	public void setRiderSAcover(String riderSAcover) {
		this.riderSAcover = riderSAcover;
	}
	public String getRiderSA() {
		return riderSA;
	}
	public void setRiderSA(String riderSA) {
		this.riderSA = riderSA;
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
