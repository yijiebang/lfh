package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class ProdCovTab implements Serializable, Cloneable {
	private String covCode;
	private String covCodeDisp;
	private String covName;
	private String covNameOth;
	private java.util.Date effDate;
	private java.util.Date expDate;
	private java.util.Date launchDate;
	private String productLine;
	private java.math.BigDecimal version;
	private String planInd;
	private String medInd;
	private String premInd;
	private String sumInd;
	private String occupClassInd;
	private String classInd;
	private String bandInd;
	private String levelPrem;
	private Integer renewTerm;
	private String commPolfee;
	private String singlePremInd;
	private String loadInd;
	private String divInd;
	private String puaInd;
	private String rpuInd;
	private String anuInd;
	private String csvInd;
	private String couInd;
	private String dbInd;
	private String sbInd;
	private String wpType;
	private String partialWp;
	private String tmProdInd;
	private String mortgageInd;
	private String mortInt;
	private String unitLink;
	private String deductFundValue;
	private String splitAcc;
	private java.math.BigDecimal deductPortion;
	private Integer staAgeMale;
	private Integer endAgeMale;
	private Integer premMataMale;
	private Integer premMattMale;
	private Integer polMataMale;
	private Integer polMattMale;
	private Integer staAgeFemale;
	private Integer endAgeFemale;
	private Integer premMataFemale;
	private Integer premMattFemale;
	private Integer polMataFemale;
	private Integer polMattFemale;
	private String yrsInHk;
	private String multIns;
	private String multCov;
	private String keymanExclInd;
	private String defaultValue;
	private Integer orderSeq;
	private Integer scrOrderSeq;
	private Integer seq;
	private Integer refCnt;
	private String status;
	private java.util.Date createDate;
	private String createBy;
	private java.util.Date updDate;
	private String updBy;
	private java.util.Date apprDate;
	private String apprBy;
	private String formType;
	private String payorInd;
	private String wholeLifeInd;
	private String mortgageType;
	private Integer staAgeDayFemale;
	private Integer staAgeDayMale;
	private Integer crRptCode;
	private String addRiderInd;
	private String premMatAsBas;
	private String polMatAsBas;
	private String commYrRule;
	private String nfProdLine;
	private String unitValuation;
	private String annuityConvInd;
	private String fundChrgInclComm;
	private String eduType;
	private String hasEti;
	private String bonInd;
	private String couponRateType;
	private String deathBenefitType;
	private String deathBenefitRateType;
	private String hasMaturityPayout;
	private String hasGio;
	private String hasRop;
	private String lumpSumOpt;
	private String premRebateOpt;
	private String termDivInd;
	private String hasIndexation;
	private String noClaimBonusInd;
	private String hasPremWaive;
	private String premRebateBeneficiary;
	private String premWaiveBeneficiary;
	private String noClaimBonusBeneficiary;
	private String exclWaiveOnWr;
	private String exclWaiveOnWp;
	private String allwOwnerPayorDiff;
	private String termAfterClaim;
	private String conversionType;
	private String issueNav;
	private String annuityPayoutMtd;
	private String annuityPayoutPeriod;
	private String jointLifeInd;
	private java.math.BigDecimal accTerm;
	private java.math.BigDecimal extraRopRate;
	private String gender;
	private java.math.BigDecimal age;
	private String effDateStr;

	public void setCovCode(String covCode) {
		this.covCode = covCode;
	}
	public String getCovCode() {
		return covCode;
	}
	public void setCovCodeDisp(String covCodeDisp) {
		this.covCodeDisp = covCodeDisp;
	}
	public String getCovCodeDisp() {
		return covCodeDisp;
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
	public void setEffDate(java.util.Date effDate) {
		this.effDate = effDate;
	}
	public java.util.Date getEffDate() {
		return effDate;
	}
	public void setExpDate(java.util.Date expDate) {
		this.expDate = expDate;
	}
	public java.util.Date getExpDate() {
		return expDate;
	}
	public void setLaunchDate(java.util.Date launchDate) {
		this.launchDate = launchDate;
	}
	public java.util.Date getLaunchDate() {
		return launchDate;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setVersion(java.math.BigDecimal version) {
		this.version = version;
	}
	public java.math.BigDecimal getVersion() {
		return version;
	}
	public void setPlanInd(String planInd) {
		this.planInd = planInd;
	}
	public String getPlanInd() {
		return planInd;
	}
	public void setMedInd(String medInd) {
		this.medInd = medInd;
	}
	public String getMedInd() {
		return medInd;
	}
	public void setPremInd(String premInd) {
		this.premInd = premInd;
	}
	public String getPremInd() {
		return premInd;
	}
	public void setSumInd(String sumInd) {
		this.sumInd = sumInd;
	}
	public String getSumInd() {
		return sumInd;
	}
	public void setOccupClassInd(String occupClassInd) {
		this.occupClassInd = occupClassInd;
	}
	public String getOccupClassInd() {
		return occupClassInd;
	}
	public void setClassInd(String classInd) {
		this.classInd = classInd;
	}
	public String getClassInd() {
		return classInd;
	}
	public void setBandInd(String bandInd) {
		this.bandInd = bandInd;
	}
	public String getBandInd() {
		return bandInd;
	}
	public void setLevelPrem(String levelPrem) {
		this.levelPrem = levelPrem;
	}
	public String getLevelPrem() {
		return levelPrem;
	}
	public void setRenewTerm(Integer renewTerm) {
		this.renewTerm = renewTerm;
	}
	public Integer getRenewTerm() {
		return renewTerm;
	}
	public void setCommPolfee(String commPolfee) {
		this.commPolfee = commPolfee;
	}
	public String getCommPolfee() {
		return commPolfee;
	}
	public void setSinglePremInd(String singlePremInd) {
		this.singlePremInd = singlePremInd;
	}
	public String getSinglePremInd() {
		return singlePremInd;
	}
	public void setLoadInd(String loadInd) {
		this.loadInd = loadInd;
	}
	public String getLoadInd() {
		return loadInd;
	}
	public void setDivInd(String divInd) {
		this.divInd = divInd;
	}
	public String getDivInd() {
		return divInd;
	}
	public void setPuaInd(String puaInd) {
		this.puaInd = puaInd;
	}
	public String getPuaInd() {
		return puaInd;
	}
	public void setRpuInd(String rpuInd) {
		this.rpuInd = rpuInd;
	}
	public String getRpuInd() {
		return rpuInd;
	}
	public void setAnuInd(String anuInd) {
		this.anuInd = anuInd;
	}
	public String getAnuInd() {
		return anuInd;
	}
	public void setCsvInd(String csvInd) {
		this.csvInd = csvInd;
	}
	public String getCsvInd() {
		return csvInd;
	}
	public void setCouInd(String couInd) {
		this.couInd = couInd;
	}
	public String getCouInd() {
		return couInd;
	}
	public void setDbInd(String dbInd) {
		this.dbInd = dbInd;
	}
	public String getDbInd() {
		return dbInd;
	}
	public void setSbInd(String sbInd) {
		this.sbInd = sbInd;
	}
	public String getSbInd() {
		return sbInd;
	}
	public void setWpType(String wpType) {
		this.wpType = wpType;
	}
	public String getWpType() {
		return wpType;
	}
	public void setPartialWp(String partialWp) {
		this.partialWp = partialWp;
	}
	public String getPartialWp() {
		return partialWp;
	}
	public void setTmProdInd(String tmProdInd) {
		this.tmProdInd = tmProdInd;
	}
	public String getTmProdInd() {
		return tmProdInd;
	}
	public void setMortgageInd(String mortgageInd) {
		this.mortgageInd = mortgageInd;
	}
	public String getMortgageInd() {
		return mortgageInd;
	}
	public void setMortInt(String mortInt) {
		this.mortInt = mortInt;
	}
	public String getMortInt() {
		return mortInt;
	}
	public void setUnitLink(String unitLink) {
		this.unitLink = unitLink;
	}
	public String getUnitLink() {
		return unitLink;
	}
	public void setDeductFundValue(String deductFundValue) {
		this.deductFundValue = deductFundValue;
	}
	public String getDeductFundValue() {
		return deductFundValue;
	}
	public void setSplitAcc(String splitAcc) {
		this.splitAcc = splitAcc;
	}
	public String getSplitAcc() {
		return splitAcc;
	}
	public void setDeductPortion(java.math.BigDecimal deductPortion) {
		this.deductPortion = deductPortion;
	}
	public java.math.BigDecimal getDeductPortion() {
		return deductPortion;
	}
	public void setStaAgeMale(Integer staAgeMale) {
		this.staAgeMale = staAgeMale;
	}
	public Integer getStaAgeMale() {
		return staAgeMale;
	}
	public void setEndAgeMale(Integer endAgeMale) {
		this.endAgeMale = endAgeMale;
	}
	public Integer getEndAgeMale() {
		return endAgeMale;
	}
	public void setPremMataMale(Integer premMataMale) {
		this.premMataMale = premMataMale;
	}
	public Integer getPremMataMale() {
		return premMataMale;
	}
	public void setPremMattMale(Integer premMattMale) {
		this.premMattMale = premMattMale;
	}
	public Integer getPremMattMale() {
		return premMattMale;
	}
	public void setPolMataMale(Integer polMataMale) {
		this.polMataMale = polMataMale;
	}
	public Integer getPolMataMale() {
		return polMataMale;
	}
	public void setPolMattMale(Integer polMattMale) {
		this.polMattMale = polMattMale;
	}
	public Integer getPolMattMale() {
		return polMattMale;
	}
	public void setStaAgeFemale(Integer staAgeFemale) {
		this.staAgeFemale = staAgeFemale;
	}
	public Integer getStaAgeFemale() {
		return staAgeFemale;
	}
	public void setEndAgeFemale(Integer endAgeFemale) {
		this.endAgeFemale = endAgeFemale;
	}
	public Integer getEndAgeFemale() {
		return endAgeFemale;
	}
	public void setPremMataFemale(Integer premMataFemale) {
		this.premMataFemale = premMataFemale;
	}
	public Integer getPremMataFemale() {
		return premMataFemale;
	}
	public void setPremMattFemale(Integer premMattFemale) {
		this.premMattFemale = premMattFemale;
	}
	public Integer getPremMattFemale() {
		return premMattFemale;
	}
	public void setPolMataFemale(Integer polMataFemale) {
		this.polMataFemale = polMataFemale;
	}
	public Integer getPolMataFemale() {
		return polMataFemale;
	}
	public void setPolMattFemale(Integer polMattFemale) {
		this.polMattFemale = polMattFemale;
	}
	public Integer getPolMattFemale() {
		return polMattFemale;
	}
	public void setYrsInHk(String yrsInHk) {
		this.yrsInHk = yrsInHk;
	}
	public String getYrsInHk() {
		return yrsInHk;
	}
	public void setMultIns(String multIns) {
		this.multIns = multIns;
	}
	public String getMultIns() {
		return multIns;
	}
	public void setMultCov(String multCov) {
		this.multCov = multCov;
	}
	public String getMultCov() {
		return multCov;
	}
	public void setKeymanExclInd(String keymanExclInd) {
		this.keymanExclInd = keymanExclInd;
	}
	public String getKeymanExclInd() {
		return keymanExclInd;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}
	public Integer getOrderSeq() {
		return orderSeq;
	}
	public void setScrOrderSeq(Integer scrOrderSeq) {
		this.scrOrderSeq = scrOrderSeq;
	}
	public Integer getScrOrderSeq() {
		return scrOrderSeq;
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
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getFormType() {
		return formType;
	}
	public void setPayorInd(String payorInd) {
		this.payorInd = payorInd;
	}
	public String getPayorInd() {
		return payorInd;
	}
	public void setWholeLifeInd(String wholeLifeInd) {
		this.wholeLifeInd = wholeLifeInd;
	}
	public String getWholeLifeInd() {
		return wholeLifeInd;
	}
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	public String getMortgageType() {
		return mortgageType;
	}
	public void setStaAgeDayFemale(Integer staAgeDayFemale) {
		this.staAgeDayFemale = staAgeDayFemale;
	}
	public Integer getStaAgeDayFemale() {
		return staAgeDayFemale;
	}
	public void setStaAgeDayMale(Integer staAgeDayMale) {
		this.staAgeDayMale = staAgeDayMale;
	}
	public Integer getStaAgeDayMale() {
		return staAgeDayMale;
	}
	public void setCrRptCode(Integer crRptCode) {
		this.crRptCode = crRptCode;
	}
	public Integer getCrRptCode() {
		return crRptCode;
	}
	public void setAddRiderInd(String addRiderInd) {
		this.addRiderInd = addRiderInd;
	}
	public String getAddRiderInd() {
		return addRiderInd;
	}
	public void setPremMatAsBas(String premMatAsBas) {
		this.premMatAsBas = premMatAsBas;
	}
	public String getPremMatAsBas() {
		return premMatAsBas;
	}
	public void setPolMatAsBas(String polMatAsBas) {
		this.polMatAsBas = polMatAsBas;
	}
	public String getPolMatAsBas() {
		return polMatAsBas;
	}
	public void setCommYrRule(String commYrRule) {
		this.commYrRule = commYrRule;
	}
	public String getCommYrRule() {
		return commYrRule;
	}
	public void setNfProdLine(String nfProdLine) {
		this.nfProdLine = nfProdLine;
	}
	public String getNfProdLine() {
		return nfProdLine;
	}
	public void setUnitValuation(String unitValuation) {
		this.unitValuation = unitValuation;
	}
	public String getUnitValuation() {
		return unitValuation;
	}
	public void setAnnuityConvInd(String annuityConvInd) {
		this.annuityConvInd = annuityConvInd;
	}
	public String getAnnuityConvInd() {
		return annuityConvInd;
	}
	public void setFundChrgInclComm(String fundChrgInclComm) {
		this.fundChrgInclComm = fundChrgInclComm;
	}
	public String getFundChrgInclComm() {
		return fundChrgInclComm;
	}
	public void setEduType(String eduType) {
		this.eduType = eduType;
	}
	public String getEduType() {
		return eduType;
	}
	public void setHasEti(String hasEti) {
		this.hasEti = hasEti;
	}
	public String getHasEti() {
		return hasEti;
	}
	public void setBonInd(String bonInd) {
		this.bonInd = bonInd;
	}
	public String getBonInd() {
		return bonInd;
	}
	public void setCouponRateType(String couponRateType) {
		this.couponRateType = couponRateType;
	}
	public String getCouponRateType() {
		return couponRateType;
	}
	public void setDeathBenefitType(String deathBenefitType) {
		this.deathBenefitType = deathBenefitType;
	}
	public String getDeathBenefitType() {
		return deathBenefitType;
	}
	public void setDeathBenefitRateType(String deathBenefitRateType) {
		this.deathBenefitRateType = deathBenefitRateType;
	}
	public String getDeathBenefitRateType() {
		return deathBenefitRateType;
	}
	public void setHasMaturityPayout(String hasMaturityPayout) {
		this.hasMaturityPayout = hasMaturityPayout;
	}
	public String getHasMaturityPayout() {
		return hasMaturityPayout;
	}
	public void setHasGio(String hasGio) {
		this.hasGio = hasGio;
	}
	public String getHasGio() {
		return hasGio;
	}
	public void setHasRop(String hasRop) {
		this.hasRop = hasRop;
	}
	public String getHasRop() {
		return hasRop;
	}
	public void setLumpSumOpt(String lumpSumOpt) {
		this.lumpSumOpt = lumpSumOpt;
	}
	public String getLumpSumOpt() {
		return lumpSumOpt;
	}
	public void setPremRebateOpt(String premRebateOpt) {
		this.premRebateOpt = premRebateOpt;
	}
	public String getPremRebateOpt() {
		return premRebateOpt;
	}
	public void setTermDivInd(String termDivInd) {
		this.termDivInd = termDivInd;
	}
	public String getTermDivInd() {
		return termDivInd;
	}
	public void setHasIndexation(String hasIndexation) {
		this.hasIndexation = hasIndexation;
	}
	public String getHasIndexation() {
		return hasIndexation;
	}
	public void setNoClaimBonusInd(String noClaimBonusInd) {
		this.noClaimBonusInd = noClaimBonusInd;
	}
	public String getNoClaimBonusInd() {
		return noClaimBonusInd;
	}
	public void setHasPremWaive(String hasPremWaive) {
		this.hasPremWaive = hasPremWaive;
	}
	public String getHasPremWaive() {
		return hasPremWaive;
	}
	public void setPremRebateBeneficiary(String premRebateBeneficiary) {
		this.premRebateBeneficiary = premRebateBeneficiary;
	}
	public String getPremRebateBeneficiary() {
		return premRebateBeneficiary;
	}
	public void setPremWaiveBeneficiary(String premWaiveBeneficiary) {
		this.premWaiveBeneficiary = premWaiveBeneficiary;
	}
	public String getPremWaiveBeneficiary() {
		return premWaiveBeneficiary;
	}
	public void setNoClaimBonusBeneficiary(String noClaimBonusBeneficiary) {
		this.noClaimBonusBeneficiary = noClaimBonusBeneficiary;
	}
	public String getNoClaimBonusBeneficiary() {
		return noClaimBonusBeneficiary;
	}
	public void setExclWaiveOnWr(String exclWaiveOnWr) {
		this.exclWaiveOnWr = exclWaiveOnWr;
	}
	public String getExclWaiveOnWr() {
		return exclWaiveOnWr;
	}
	public void setExclWaiveOnWp(String exclWaiveOnWp) {
		this.exclWaiveOnWp = exclWaiveOnWp;
	}
	public String getExclWaiveOnWp() {
		return exclWaiveOnWp;
	}
	public void setAllwOwnerPayorDiff(String allwOwnerPayorDiff) {
		this.allwOwnerPayorDiff = allwOwnerPayorDiff;
	}
	public String getAllwOwnerPayorDiff() {
		return allwOwnerPayorDiff;
	}
	public void setTermAfterClaim(String termAfterClaim) {
		this.termAfterClaim = termAfterClaim;
	}
	public String getTermAfterClaim() {
		return termAfterClaim;
	}
	public void setConversionType(String conversionType) {
		this.conversionType = conversionType;
	}
	public String getConversionType() {
		return conversionType;
	}
	public void setIssueNav(String issueNav) {
		this.issueNav = issueNav;
	}
	public String getIssueNav() {
		return issueNav;
	}
	public void setAnnuityPayoutMtd(String annuityPayoutMtd) {
		this.annuityPayoutMtd = annuityPayoutMtd;
	}
	public String getAnnuityPayoutMtd() {
		return annuityPayoutMtd;
	}
	public void setAnnuityPayoutPeriod(String annuityPayoutPeriod) {
		this.annuityPayoutPeriod = annuityPayoutPeriod;
	}
	public String getAnnuityPayoutPeriod() {
		return annuityPayoutPeriod;
	}
	public void setJointLifeInd(String jointLifeInd) {
		this.jointLifeInd = jointLifeInd;
	}
	public String getJointLifeInd() {
		return jointLifeInd;
	}
	public void setAccTerm(java.math.BigDecimal accTerm) {
		this.accTerm = accTerm;
	}
	public java.math.BigDecimal getAccTerm() {
		return accTerm;
	}
	public void setExtraRopRate(java.math.BigDecimal extraRopRate) {
		this.extraRopRate = extraRopRate;
	}
	public java.math.BigDecimal getExtraRopRate() {
		return extraRopRate;
	}
  
	private static final String Table = "prod_cov_tab";
	private static final String Alias = "as_prod_cov_tab";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCovCode = Alias+".cov_code";
	public static final String DBStrCovCodeDisp = Alias+".cov_code_disp";
	public static final String DBStrCovName = Alias+".cov_name";
	public static final String DBStrCovNameOth = Alias+".cov_name_oth";
	public static final String DBStrEffDate = Alias+".eff_date";
	public static final String DBStrExpDate = Alias+".exp_date";
	public static final String DBStrLaunchDate = Alias+".launch_date";
	public static final String DBStrProductLine = Alias+".product_line";
	public static final String DBStrVersion = Alias+".version";
	public static final String DBStrPlanInd = Alias+".plan_ind";
	public static final String DBStrMedInd = Alias+".med_ind";
	public static final String DBStrPremInd = Alias+".prem_ind";
	public static final String DBStrSumInd = Alias+".sum_ind";
	public static final String DBStrOccupClassInd = Alias+".occup_class_ind";
	public static final String DBStrClassInd = Alias+".class_ind";
	public static final String DBStrBandInd = Alias+".band_ind";
	public static final String DBStrLevelPrem = Alias+".level_prem";
	public static final String DBStrRenewTerm = Alias+".renew_term";
	public static final String DBStrCommPolfee = Alias+".comm_polfee";
	public static final String DBStrSinglePremInd = Alias+".single_prem_ind";
	public static final String DBStrLoadInd = Alias+".load_ind";
	public static final String DBStrDivInd = Alias+".div_ind";
	public static final String DBStrPuaInd = Alias+".pua_ind";
	public static final String DBStrRpuInd = Alias+".rpu_ind";
	public static final String DBStrAnuInd = Alias+".anu_ind";
	public static final String DBStrCsvInd = Alias+".csv_ind";
	public static final String DBStrCouInd = Alias+".cou_ind";
	public static final String DBStrDbInd = Alias+".db_ind";
	public static final String DBStrSbInd = Alias+".sb_ind";
	public static final String DBStrWpType = Alias+".wp_type";
	public static final String DBStrPartialWp = Alias+".partial_wp";
	public static final String DBStrTmProdInd = Alias+".tm_prod_ind";
	public static final String DBStrMortgageInd = Alias+".mortgage_ind";
	public static final String DBStrMortInt = Alias+".mort_int";
	public static final String DBStrUnitLink = Alias+".unit_link";
	public static final String DBStrDeductFundValue = Alias+".deduct_fund_value";
	public static final String DBStrSplitAcc = Alias+".split_acc";
	public static final String DBStrDeductPortion = Alias+".deduct_portion";
	public static final String DBStrStaAgeMale = Alias+".sta_age_male";
	public static final String DBStrEndAgeMale = Alias+".end_age_male";
	public static final String DBStrPremMataMale = Alias+".prem_mata_male";
	public static final String DBStrPremMattMale = Alias+".prem_matt_male";
	public static final String DBStrPolMataMale = Alias+".pol_mata_male";
	public static final String DBStrPolMattMale = Alias+".pol_matt_male";
	public static final String DBStrStaAgeFemale = Alias+".sta_age_female";
	public static final String DBStrEndAgeFemale = Alias+".end_age_female";
	public static final String DBStrPremMataFemale = Alias+".prem_mata_female";
	public static final String DBStrPremMattFemale = Alias+".prem_matt_female";
	public static final String DBStrPolMataFemale = Alias+".pol_mata_female";
	public static final String DBStrPolMattFemale = Alias+".pol_matt_female";
	public static final String DBStrYrsInHk = Alias+".yrs_in_hk";
	public static final String DBStrMultIns = Alias+".mult_ins";
	public static final String DBStrMultCov = Alias+".mult_cov";
	public static final String DBStrKeymanExclInd = Alias+".keyman_excl_ind";
	public static final String DBStrDefaultValue = Alias+".default_value";
	public static final String DBStrOrderSeq = Alias+".order_seq";
	public static final String DBStrScrOrderSeq = Alias+".scr_order_seq";
	public static final String DBStrSeq = Alias+".seq";
	public static final String DBStrRefCnt = Alias+".ref_cnt";
	public static final String DBStrStatus = Alias+".status";
	public static final String DBStrCreateDate = Alias+".create_date";
	public static final String DBStrCreateBy = Alias+".create_by";
	public static final String DBStrUpdDate = Alias+".upd_date";
	public static final String DBStrUpdBy = Alias+".upd_by";
	public static final String DBStrApprDate = Alias+".appr_date";
	public static final String DBStrApprBy = Alias+".appr_by";
	public static final String DBStrFormType = Alias+".form_type";
	public static final String DBStrPayorInd = Alias+".payor_ind";
	public static final String DBStrWholeLifeInd = Alias+".whole_life_ind";
	public static final String DBStrMortgageType = Alias+".mortgage_type";
	public static final String DBStrStaAgeDayFemale = Alias+".sta_age_day_female";
	public static final String DBStrStaAgeDayMale = Alias+".sta_age_day_male";
	public static final String DBStrCrRptCode = Alias+".cr_rpt_code";
	public static final String DBStrAddRiderInd = Alias+".add_rider_ind";
	public static final String DBStrPremMatAsBas = Alias+".prem_mat_as_bas";
	public static final String DBStrPolMatAsBas = Alias+".pol_mat_as_bas";
	public static final String DBStrCommYrRule = Alias+".comm_yr_rule";
	public static final String DBStrNfProdLine = Alias+".nf_prod_line";
	public static final String DBStrUnitValuation = Alias+".unit_valuation";
	public static final String DBStrAnnuityConvInd = Alias+".annuity_conv_ind";
	public static final String DBStrFundChrgInclComm = Alias+".fund_chrg_incl_comm";
	public static final String DBStrEduType = Alias+".edu_type";
	public static final String DBStrHasEti = Alias+".has_eti";
	public static final String DBStrBonInd = Alias+".bon_ind";
	public static final String DBStrCouponRateType = Alias+".coupon_rate_type";
	public static final String DBStrDeathBenefitType = Alias+".death_benefit_type";
	public static final String DBStrDeathBenefitRateType = Alias+".death_benefit_rate_type";
	public static final String DBStrHasMaturityPayout = Alias+".has_maturity_payout";
	public static final String DBStrHasGio = Alias+".has_gio";
	public static final String DBStrHasRop = Alias+".has_rop";
	public static final String DBStrLumpSumOpt = Alias+".lump_sum_opt";
	public static final String DBStrPremRebateOpt = Alias+".prem_rebate_opt";
	public static final String DBStrTermDivInd = Alias+".term_div_ind";
	public static final String DBStrHasIndexation = Alias+".has_indexation";
	public static final String DBStrNoClaimBonusInd = Alias+".no_claim_bonus_ind";
	public static final String DBStrHasPremWaive = Alias+".has_prem_waive";
	public static final String DBStrPremRebateBeneficiary = Alias+".prem_rebate_beneficiary";
	public static final String DBStrPremWaiveBeneficiary = Alias+".prem_waive_beneficiary";
	public static final String DBStrNoClaimBonusBeneficiary = Alias+".no_claim_bonus_beneficiary";
	public static final String DBStrExclWaiveOnWr = Alias+".excl_waive_on_wr";
	public static final String DBStrExclWaiveOnWp = Alias+".excl_waive_on_wp";
	public static final String DBStrAllwOwnerPayorDiff = Alias+".allw_owner_payor_diff";
	public static final String DBStrTermAfterClaim = Alias+".term_after_claim";
	public static final String DBStrConversionType = Alias+".conversion_type";
	public static final String DBStrIssueNav = Alias+".issue_nav";
	public static final String DBStrAnnuityPayoutMtd = Alias+".annuity_payout_mtd";
	public static final String DBStrAnnuityPayoutPeriod = Alias+".annuity_payout_period";
	public static final String DBStrJointLifeInd = Alias+".joint_life_ind";
	public static final String DBStrAccTerm = Alias+".acc_term";
	public static final String DBStrExtraRopRate = Alias+".extra_rop_rate";
	
	@Override
	public ProdCovTab clone() {
		ProdCovTab o = null;
		try{
			o = (ProdCovTab)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
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
	public String getEffDateStr() {
		return effDateStr;
	}
	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}
}

