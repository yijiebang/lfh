package com.reinfo.ipoly.module.models;

import org.olap4j.type.SetType;

import java.math.BigDecimal;

public class ProdRateParm {
	private  String covCode;
	private  String sex;
	private  String smoke;
	private  String ccy;
	private  BigDecimal inputPremium;
	private  Integer issAge;
	private  BigDecimal sumPremium;//计算出来的保费
	private String covClass;//下拉框的value
	private String showSumInsured;//是否有保额输入框，Y=有，N=没有，计算公式不一样，Y= 保额 * 费率 + scall   N= 费率
	private String type;//保障类型名称
	private Value value;//下拉框
	private String key;
	private String defaultval;//现在用于判断是否定期或者危疾 Y/N Y是
	private String covTermRiderInd;//判斷rider code

	private  BigDecimal basePlan,wppb;//基本計劃和定期loding,豁免loding

	public BigDecimal getBasePlan() {
		return basePlan;
	}

	public void setBasePlan(BigDecimal basePlan) {
		this.basePlan = basePlan;
	}

	public BigDecimal getWppb() {
		return wppb;
	}

	public void setWppb(BigDecimal wppb) {
		this.wppb = wppb;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCovTermRiderInd() {
		return covTermRiderInd;
	}

	public void setCovTermRiderInd(String covTermRiderInd) {
		this.covTermRiderInd = covTermRiderInd;
	}

	public String getDefaultval() {
		return defaultval;
	}

	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Value getValue() {
		return value;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSmoke() {
		return smoke;
	}
	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	  

	public String getShowSumInsured() {
		return showSumInsured;
	}
	public void setShowSumInsured(String showSumInsured) {
		this.showSumInsured = showSumInsured;
	}
	public String getCovClass() {
		return covClass;
	}
	public void setCovClass(String covClass) {
		this.covClass = covClass;
	}
	public BigDecimal getSumPremium() {
		return sumPremium;
	}
	public void setSumPremium(BigDecimal sumPremium) {
		this.sumPremium = sumPremium;
	}
	public String getCovCode() {
		return covCode;
	}
	public void setCovCode(String covCode) {
		this.covCode = covCode;
	}
	public BigDecimal getInputPremium() {
		return inputPremium;
	}

	public void setInputPremium(BigDecimal inputPremium) {
		this.inputPremium = inputPremium;
	}

 

	public Integer getIssAge() {
		return issAge;
	}
	public void setIssAge(Integer issAge) {
		this.issAge = issAge;
	}
	public ProdRateParm() {}
	public ProdRateParm(String CovCode, String sex,String smoke,BigDecimal inputPremium,String ccy,Integer issAge) {
		this.covCode=CovCode;
		this.sex=sex;
		this.smoke=smoke;
		this.ccy=ccy;
		this.inputPremium=inputPremium;
		this.issAge=issAge;
	}
	  
	@Override
	public String toString() {
 		return super.toString();
	}

	public class Value{
		private String value;
		private String text;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}
}
