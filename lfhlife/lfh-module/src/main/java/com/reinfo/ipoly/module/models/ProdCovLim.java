package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdCovLim implements Serializable, Cloneable {
	private Integer compCode;
	private String ruleName;
	private String groups;
	private String planInd;
	private String covBand;
	private String ccy;
	private String ctyGroup;
	private String limCovCode;
	private String sex;
	private String province;
	private String occupation;
	private Integer ageFrom;
	private Integer ageTo;
	private Integer birthdaysFrom;
	private Integer birthdaysTo;
	private java.math.BigDecimal incomeFrom;
	private java.math.BigDecimal incomeTo;
	private java.math.BigDecimal minSumIns;
	private java.math.BigDecimal maxSumIns;
	private java.math.BigDecimal maxTsa;
	private java.math.BigDecimal maxClaim;
	private Integer timesOfBas;
	private Integer timesOfTerm;
	private String sameAs;
	private String ruleDescEng;
	private String ruleDescOth;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private java.util.Date createDate;
	private String createBy;
	private java.util.Date updDate;
	private String updBy;
	private java.util.Date apprDate;
	private String apprBy;
	private String payMode;
	private java.math.BigDecimal rtuAmtFrom;
	private java.math.BigDecimal alsAmtFrom;

	public void setCompCode(Integer compCode) {
		this.compCode = compCode;
	}
	public Integer getCompCode() {
		return compCode;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getGroups() {
		return groups;
	}
	public void setPlanInd(String planInd) {
		this.planInd = planInd;
	}
	public String getPlanInd() {
		return planInd;
	}
	public void setCovBand(String covBand) {
		this.covBand = covBand;
	}
	public String getCovBand() {
		return covBand;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getCcy() {
		return ccy;
	}
	public void setCtyGroup(String ctyGroup) {
		this.ctyGroup = ctyGroup;
	}
	public String getCtyGroup() {
		return ctyGroup;
	}
	public void setLimCovCode(String limCovCode) {
		this.limCovCode = limCovCode;
	}
	public String getLimCovCode() {
		return limCovCode;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvince() {
		return province;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}
	public Integer getAgeFrom() {
		return ageFrom;
	}
	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}
	public Integer getAgeTo() {
		return ageTo;
	}
	public void setBirthdaysFrom(Integer birthdaysFrom) {
		this.birthdaysFrom = birthdaysFrom;
	}
	public Integer getBirthdaysFrom() {
		return birthdaysFrom;
	}
	public void setBirthdaysTo(Integer birthdaysTo) {
		this.birthdaysTo = birthdaysTo;
	}
	public Integer getBirthdaysTo() {
		return birthdaysTo;
	}
	public void setIncomeFrom(java.math.BigDecimal incomeFrom) {
		this.incomeFrom = incomeFrom;
	}
	public java.math.BigDecimal getIncomeFrom() {
		return incomeFrom;
	}
	public void setIncomeTo(java.math.BigDecimal incomeTo) {
		this.incomeTo = incomeTo;
	}
	public java.math.BigDecimal getIncomeTo() {
		return incomeTo;
	}
	public void setMinSumIns(java.math.BigDecimal minSumIns) {
		this.minSumIns = minSumIns;
	}
	public java.math.BigDecimal getMinSumIns() {
		return minSumIns;
	}
	public void setMaxSumIns(java.math.BigDecimal maxSumIns) {
		this.maxSumIns = maxSumIns;
	}
	public java.math.BigDecimal getMaxSumIns() {
		return maxSumIns;
	}
	public void setMaxTsa(java.math.BigDecimal maxTsa) {
		this.maxTsa = maxTsa;
	}
	public java.math.BigDecimal getMaxTsa() {
		return maxTsa;
	}
	public void setMaxClaim(java.math.BigDecimal maxClaim) {
		this.maxClaim = maxClaim;
	}
	public java.math.BigDecimal getMaxClaim() {
		return maxClaim;
	}
	public void setTimesOfBas(Integer timesOfBas) {
		this.timesOfBas = timesOfBas;
	}
	public Integer getTimesOfBas() {
		return timesOfBas;
	}
	public void setTimesOfTerm(Integer timesOfTerm) {
		this.timesOfTerm = timesOfTerm;
	}
	public Integer getTimesOfTerm() {
		return timesOfTerm;
	}
	public void setSameAs(String sameAs) {
		this.sameAs = sameAs;
	}
	public String getSameAs() {
		return sameAs;
	}
	public void setRuleDescEng(String ruleDescEng) {
		this.ruleDescEng = ruleDescEng;
	}
	public String getRuleDescEng() {
		return ruleDescEng;
	}
	public void setRuleDescOth(String ruleDescOth) {
		this.ruleDescOth = ruleDescOth;
	}
	public String getRuleDescOth() {
		return ruleDescOth;
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
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setRtuAmtFrom(java.math.BigDecimal rtuAmtFrom) {
		this.rtuAmtFrom = rtuAmtFrom;
	}
	public java.math.BigDecimal getRtuAmtFrom() {
		return rtuAmtFrom;
	}
	public void setAlsAmtFrom(java.math.BigDecimal alsAmtFrom) {
		this.alsAmtFrom = alsAmtFrom;
	}
	public java.math.BigDecimal getAlsAmtFrom() {
		return alsAmtFrom;
	}
  
	private static final String Table = "prod_cov_lim";
	private static final String Alias = "as_prod_cov_lim";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCompCode = Alias+".comp_code";
	public static final String DBStrRuleName = Alias+".rule_name";
	public static final String DBStrGroups = Alias+".groups";
	public static final String DBStrPlanInd = Alias+".plan_ind";
	public static final String DBStrCovBand = Alias+".cov_band";
	public static final String DBStrCcy = Alias+".ccy";
	public static final String DBStrCtyGroup = Alias+".cty_group";
	public static final String DBStrLimCovCode = Alias+".lim_cov_code";
	public static final String DBStrSex = Alias+".sex";
	public static final String DBStrProvince = Alias+".province";
	public static final String DBStrOccupation = Alias+".occupation";
	public static final String DBStrAgeFrom = Alias+".age_from";
	public static final String DBStrAgeTo = Alias+".age_to";
	public static final String DBStrBirthdaysFrom = Alias+".birthdays_from";
	public static final String DBStrBirthdaysTo = Alias+".birthdays_to";
	public static final String DBStrIncomeFrom = Alias+".income_from";
	public static final String DBStrIncomeTo = Alias+".income_to";
	public static final String DBStrMinSumIns = Alias+".min_sum_ins";
	public static final String DBStrMaxSumIns = Alias+".max_sum_ins";
	public static final String DBStrMaxTsa = Alias+".max_tsa";
	public static final String DBStrMaxClaim = Alias+".max_claim";
	public static final String DBStrTimesOfBas = Alias+".times_of_bas";
	public static final String DBStrTimesOfTerm = Alias+".times_of_term";
	public static final String DBStrSameAs = Alias+".same_as";
	public static final String DBStrRuleDescEng = Alias+".rule_desc_eng";
	public static final String DBStrRuleDescOth = Alias+".rule_desc_oth";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrPayMode = Alias+".pay_mode";
	public static final String DBStrRtuAmtFrom = Alias+".rtu_amt_from";
	public static final String DBStrAlsAmtFrom = Alias+".als_amt_from";
	
	@Override
	public ProdCovLim clone() {
		ProdCovLim o = null;
		try{
			o = (ProdCovLim)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

