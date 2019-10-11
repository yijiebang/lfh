package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Secfl implements Serializable, Cloneable {
	private String secOffice;
	private String secDept;
	private String secCls;
	private String secAgt;
	private Long secYear;
	private String secId;
	private String secSec;
	private Long secEndst;
	private String secLast;
	private Object secCover;
	private Object secClsdes;
	private String secScls;
	private java.util.Date secEffdate;
	private java.util.Date secExpdate;
	private java.util.Date secEndstEff;
	private java.util.Date secEndstExp;
	private java.util.Date secMaFr;
	private java.util.Date secMaTo;
	private Object secVehno;
	private String secCcy;
	private java.math.BigDecimal secTsi;
	private java.math.BigDecimal secRate;
	private java.math.BigDecimal secCDisc;
	private java.math.BigDecimal secCCom;
	private java.math.BigDecimal secCTcom;
	private java.math.BigDecimal secCBrok;
	private java.math.BigDecimal secCMib;
	private java.math.BigDecimal secCLevy;
	private java.math.BigDecimal secCNcb;
	private java.math.BigDecimal secCSur;
	private java.math.BigDecimal secCFga;
	private java.math.BigDecimal secCTax;
	private String secDrprt;
	private java.util.Date secCdate;
	private java.util.Date secAdate;
	private String secCuser;
	private String secAuser;
	private Long secLock;
	private java.math.BigDecimal secCLoad;
	private java.math.BigDecimal secCSdisc;
	private java.math.BigDecimal secExRate;
	private Object secXref;
	private Object secAgtRef;
	private java.math.BigDecimal secPremium;
	private String secPrmBy;
	private java.math.BigDecimal secPrmFtr;
	private java.math.BigDecimal secAddprm;
	private java.math.BigDecimal secSurcharge;
	private java.math.BigDecimal secNetprm;
	private String secIsr;
	private java.util.Date secTestFr;
	private java.util.Date secTestTo;
	private java.math.BigDecimal secDepprm;
	private String secLoc;
	private Object motModeldes;
	private String motDoor;
	private Object motBody;
	private Object motAddval;
	private Object motClauses;
	private String motHpowner;
	private Object motBlacklist;
	private java.math.BigDecimal motLdAge;
	private java.math.BigDecimal motLdModel;
	private java.math.BigDecimal motLdAdriver;
	private java.math.BigDecimal motLdOthers;
	private String motUse1;
	private Object eccAisr;
	private String eccIsrbus;
	private java.math.BigDecimal eccCval;
	private java.math.BigDecimal eccIndem;
	private Object eccSite;
	private Object eccPeriod;
	private java.math.BigDecimal motBprm;
	private java.math.BigDecimal motGprm;
	private Object motOccup;
	private String motMrhid1;
	private Long motMrhver1;
	private String motMrhid2;
	private Long motMrhver2;
	private Object secRemark;
	private Object secEndtype;
	private String secSt;
	private java.util.Date secStdate;
	private java.util.Date secIssdate;
	private Object secCvnote;
	private String secCrnote;
	private String secEndprt;
	private java.util.Date secChgsEff;
	private java.math.BigDecimal secDisc;
	private java.math.BigDecimal secCom;
	private java.math.BigDecimal secMib;
	private java.math.BigDecimal secBrok;
	private java.math.BigDecimal secTax;
	private java.math.BigDecimal secFga;
	private java.math.BigDecimal secLevy;
	private java.math.BigDecimal secAccum;
	private String secSuragt;
	private String secSetagt;
	private Object secVersion;
	private String secSchby;
	private Long secDoc;
	private String secDocid;
	private Long secVer;
	private String secBrn1;
	private String secBrn2;
	private String secBrn3;
	private Integer secCoshare;
	private Long secMedyear;
	private Long secMedarea;
	private Object secMedcard;
	private String mohVehnochn1;
	private String secMainttype;
	private java.util.Date secMaintfr;
	private java.util.Date secMaintto;
	private Long secMaintdays;
	private String secSpaccpt;
	private String secSaleman;
	private String secWrpsts;
	private String secPaymode;
	private String secCligrp;
	private String secCommplan;
	private String secSvcagt;
	private String secCommto;
	private String secComm4this;
	private String secPaymthd;
	private String secCommchgd;
	private java.math.BigDecimal secDisc01;
	private java.math.BigDecimal secMprmrate1;
	private java.math.BigDecimal secMprmrate2;
	private String secCommtable;
	private Long secExtEndst;
	private java.math.BigDecimal secMinprm;
	private String secMinprmOr;
	private String secTraIpa;
	private String secRategrp;
	private String secSaleteam;
	private String secSalearea;
	private String secSaleleader;
	private String secInternal;
	private String secSaledept;
	private String secReinstate;
	private String secAgtdept;
	private Long secPayterm;
	private String secPrtonsoa;
	private Long secFeecount;
	private java.math.BigDecimal secNumber1;
	private String secString1;
	private String secBankRef;
	private String secRicomgn;
	private String secAutopixy;
	private String secPreexist;
	private Double secMaster;
	private String secBillfreq;
	private String secSchm;
	private String secPrdid;
	private Long secGrpendst1;
	private String secBilling;
	private java.math.BigDecimal secMpremium;
	private Object secNote1;
	private java.util.Date secVarFr;
	private java.util.Date secVarTo;
	private String secVarOpt;
	private String secMaintOpt;
	private String secTestOpt;
	private String secVarDm;
	private Integer secVarDmno;
	private String secMaintDm;
	private Integer secMaintDmno;
	private String secTestDm;
	private Integer secTestDmno;
	private java.util.Date secSusFr;
	private java.util.Date secSusTo;

	public void setSecOffice(String secOffice) {
		this.secOffice = secOffice;
	}
	public String getSecOffice() {
		return secOffice;
	}
	public void setSecDept(String secDept) {
		this.secDept = secDept;
	}
	public String getSecDept() {
		return secDept;
	}
	public void setSecCls(String secCls) {
		this.secCls = secCls;
	}
	public String getSecCls() {
		return secCls;
	}
	public void setSecAgt(String secAgt) {
		this.secAgt = secAgt;
	}
	public String getSecAgt() {
		return secAgt;
	}
	public void setSecYear(Long secYear) {
		this.secYear = secYear;
	}
	public Long getSecYear() {
		return secYear;
	}
	public void setSecId(String secId) {
		this.secId = secId;
	}
	public String getSecId() {
		return secId;
	}
	public void setSecSec(String secSec) {
		this.secSec = secSec;
	}
	public String getSecSec() {
		return secSec;
	}
	public void setSecEndst(Long secEndst) {
		this.secEndst = secEndst;
	}
	public Long getSecEndst() {
		return secEndst;
	}
	public void setSecLast(String secLast) {
		this.secLast = secLast;
	}
	public String getSecLast() {
		return secLast;
	}
	public void setSecCover(Object secCover) {
		this.secCover = secCover;
	}
	public Object getSecCover() {
		return secCover;
	}
	public void setSecClsdes(Object secClsdes) {
		this.secClsdes = secClsdes;
	}
	public Object getSecClsdes() {
		return secClsdes;
	}
	public void setSecScls(String secScls) {
		this.secScls = secScls;
	}
	public String getSecScls() {
		return secScls;
	}
	public void setSecEffdate(java.util.Date secEffdate) {
		this.secEffdate = secEffdate;
	}
	public java.util.Date getSecEffdate() {
		return secEffdate;
	}
	public void setSecExpdate(java.util.Date secExpdate) {
		this.secExpdate = secExpdate;
	}
	public java.util.Date getSecExpdate() {
		return secExpdate;
	}
	public void setSecEndstEff(java.util.Date secEndstEff) {
		this.secEndstEff = secEndstEff;
	}
	public java.util.Date getSecEndstEff() {
		return secEndstEff;
	}
	public void setSecEndstExp(java.util.Date secEndstExp) {
		this.secEndstExp = secEndstExp;
	}
	public java.util.Date getSecEndstExp() {
		return secEndstExp;
	}
	public void setSecMaFr(java.util.Date secMaFr) {
		this.secMaFr = secMaFr;
	}
	public java.util.Date getSecMaFr() {
		return secMaFr;
	}
	public void setSecMaTo(java.util.Date secMaTo) {
		this.secMaTo = secMaTo;
	}
	public java.util.Date getSecMaTo() {
		return secMaTo;
	}
	public void setSecVehno(Object secVehno) {
		this.secVehno = secVehno;
	}
	public Object getSecVehno() {
		return secVehno;
	}
	public void setSecCcy(String secCcy) {
		this.secCcy = secCcy;
	}
	public String getSecCcy() {
		return secCcy;
	}
	public void setSecTsi(java.math.BigDecimal secTsi) {
		this.secTsi = secTsi;
	}
	public java.math.BigDecimal getSecTsi() {
		return secTsi;
	}
	public void setSecRate(java.math.BigDecimal secRate) {
		this.secRate = secRate;
	}
	public java.math.BigDecimal getSecRate() {
		return secRate;
	}
	public void setSecCDisc(java.math.BigDecimal secCDisc) {
		this.secCDisc = secCDisc;
	}
	public java.math.BigDecimal getSecCDisc() {
		return secCDisc;
	}
	public void setSecCCom(java.math.BigDecimal secCCom) {
		this.secCCom = secCCom;
	}
	public java.math.BigDecimal getSecCCom() {
		return secCCom;
	}
	public void setSecCTcom(java.math.BigDecimal secCTcom) {
		this.secCTcom = secCTcom;
	}
	public java.math.BigDecimal getSecCTcom() {
		return secCTcom;
	}
	public void setSecCBrok(java.math.BigDecimal secCBrok) {
		this.secCBrok = secCBrok;
	}
	public java.math.BigDecimal getSecCBrok() {
		return secCBrok;
	}
	public void setSecCMib(java.math.BigDecimal secCMib) {
		this.secCMib = secCMib;
	}
	public java.math.BigDecimal getSecCMib() {
		return secCMib;
	}
	public void setSecCLevy(java.math.BigDecimal secCLevy) {
		this.secCLevy = secCLevy;
	}
	public java.math.BigDecimal getSecCLevy() {
		return secCLevy;
	}
	public void setSecCNcb(java.math.BigDecimal secCNcb) {
		this.secCNcb = secCNcb;
	}
	public java.math.BigDecimal getSecCNcb() {
		return secCNcb;
	}
	public void setSecCSur(java.math.BigDecimal secCSur) {
		this.secCSur = secCSur;
	}
	public java.math.BigDecimal getSecCSur() {
		return secCSur;
	}
	public void setSecCFga(java.math.BigDecimal secCFga) {
		this.secCFga = secCFga;
	}
	public java.math.BigDecimal getSecCFga() {
		return secCFga;
	}
	public void setSecCTax(java.math.BigDecimal secCTax) {
		this.secCTax = secCTax;
	}
	public java.math.BigDecimal getSecCTax() {
		return secCTax;
	}
	public void setSecDrprt(String secDrprt) {
		this.secDrprt = secDrprt;
	}
	public String getSecDrprt() {
		return secDrprt;
	}
	public void setSecCdate(java.util.Date secCdate) {
		this.secCdate = secCdate;
	}
	public java.util.Date getSecCdate() {
		return secCdate;
	}
	public void setSecAdate(java.util.Date secAdate) {
		this.secAdate = secAdate;
	}
	public java.util.Date getSecAdate() {
		return secAdate;
	}
	public void setSecCuser(String secCuser) {
		this.secCuser = secCuser;
	}
	public String getSecCuser() {
		return secCuser;
	}
	public void setSecAuser(String secAuser) {
		this.secAuser = secAuser;
	}
	public String getSecAuser() {
		return secAuser;
	}
	public void setSecLock(Long secLock) {
		this.secLock = secLock;
	}
	public Long getSecLock() {
		return secLock;
	}
	public void setSecCLoad(java.math.BigDecimal secCLoad) {
		this.secCLoad = secCLoad;
	}
	public java.math.BigDecimal getSecCLoad() {
		return secCLoad;
	}
	public void setSecCSdisc(java.math.BigDecimal secCSdisc) {
		this.secCSdisc = secCSdisc;
	}
	public java.math.BigDecimal getSecCSdisc() {
		return secCSdisc;
	}
	public void setSecExRate(java.math.BigDecimal secExRate) {
		this.secExRate = secExRate;
	}
	public java.math.BigDecimal getSecExRate() {
		return secExRate;
	}
	public void setSecXref(Object secXref) {
		this.secXref = secXref;
	}
	public Object getSecXref() {
		return secXref;
	}
	public void setSecAgtRef(Object secAgtRef) {
		this.secAgtRef = secAgtRef;
	}
	public Object getSecAgtRef() {
		return secAgtRef;
	}
	public void setSecPremium(java.math.BigDecimal secPremium) {
		this.secPremium = secPremium;
	}
	public java.math.BigDecimal getSecPremium() {
		return secPremium;
	}
	public void setSecPrmBy(String secPrmBy) {
		this.secPrmBy = secPrmBy;
	}
	public String getSecPrmBy() {
		return secPrmBy;
	}
	public void setSecPrmFtr(java.math.BigDecimal secPrmFtr) {
		this.secPrmFtr = secPrmFtr;
	}
	public java.math.BigDecimal getSecPrmFtr() {
		return secPrmFtr;
	}
	public void setSecAddprm(java.math.BigDecimal secAddprm) {
		this.secAddprm = secAddprm;
	}
	public java.math.BigDecimal getSecAddprm() {
		return secAddprm;
	}
	public void setSecSurcharge(java.math.BigDecimal secSurcharge) {
		this.secSurcharge = secSurcharge;
	}
	public java.math.BigDecimal getSecSurcharge() {
		return secSurcharge;
	}
	public void setSecNetprm(java.math.BigDecimal secNetprm) {
		this.secNetprm = secNetprm;
	}
	public java.math.BigDecimal getSecNetprm() {
		return secNetprm;
	}
	public void setSecIsr(String secIsr) {
		this.secIsr = secIsr;
	}
	public String getSecIsr() {
		return secIsr;
	}
	public void setSecTestFr(java.util.Date secTestFr) {
		this.secTestFr = secTestFr;
	}
	public java.util.Date getSecTestFr() {
		return secTestFr;
	}
	public void setSecTestTo(java.util.Date secTestTo) {
		this.secTestTo = secTestTo;
	}
	public java.util.Date getSecTestTo() {
		return secTestTo;
	}
	public void setSecDepprm(java.math.BigDecimal secDepprm) {
		this.secDepprm = secDepprm;
	}
	public java.math.BigDecimal getSecDepprm() {
		return secDepprm;
	}
	public void setSecLoc(String secLoc) {
		this.secLoc = secLoc;
	}
	public String getSecLoc() {
		return secLoc;
	}
	public void setMotModeldes(Object motModeldes) {
		this.motModeldes = motModeldes;
	}
	public Object getMotModeldes() {
		return motModeldes;
	}
	public void setMotDoor(String motDoor) {
		this.motDoor = motDoor;
	}
	public String getMotDoor() {
		return motDoor;
	}
	public void setMotBody(Object motBody) {
		this.motBody = motBody;
	}
	public Object getMotBody() {
		return motBody;
	}
	public void setMotAddval(Object motAddval) {
		this.motAddval = motAddval;
	}
	public Object getMotAddval() {
		return motAddval;
	}
	public void setMotClauses(Object motClauses) {
		this.motClauses = motClauses;
	}
	public Object getMotClauses() {
		return motClauses;
	}
	public void setMotHpowner(String motHpowner) {
		this.motHpowner = motHpowner;
	}
	public String getMotHpowner() {
		return motHpowner;
	}
	public void setMotBlacklist(Object motBlacklist) {
		this.motBlacklist = motBlacklist;
	}
	public Object getMotBlacklist() {
		return motBlacklist;
	}
	public void setMotLdAge(java.math.BigDecimal motLdAge) {
		this.motLdAge = motLdAge;
	}
	public java.math.BigDecimal getMotLdAge() {
		return motLdAge;
	}
	public void setMotLdModel(java.math.BigDecimal motLdModel) {
		this.motLdModel = motLdModel;
	}
	public java.math.BigDecimal getMotLdModel() {
		return motLdModel;
	}
	public void setMotLdAdriver(java.math.BigDecimal motLdAdriver) {
		this.motLdAdriver = motLdAdriver;
	}
	public java.math.BigDecimal getMotLdAdriver() {
		return motLdAdriver;
	}
	public void setMotLdOthers(java.math.BigDecimal motLdOthers) {
		this.motLdOthers = motLdOthers;
	}
	public java.math.BigDecimal getMotLdOthers() {
		return motLdOthers;
	}
	public void setMotUse1(String motUse1) {
		this.motUse1 = motUse1;
	}
	public String getMotUse1() {
		return motUse1;
	}
	public void setEccAisr(Object eccAisr) {
		this.eccAisr = eccAisr;
	}
	public Object getEccAisr() {
		return eccAisr;
	}
	public void setEccIsrbus(String eccIsrbus) {
		this.eccIsrbus = eccIsrbus;
	}
	public String getEccIsrbus() {
		return eccIsrbus;
	}
	public void setEccCval(java.math.BigDecimal eccCval) {
		this.eccCval = eccCval;
	}
	public java.math.BigDecimal getEccCval() {
		return eccCval;
	}
	public void setEccIndem(java.math.BigDecimal eccIndem) {
		this.eccIndem = eccIndem;
	}
	public java.math.BigDecimal getEccIndem() {
		return eccIndem;
	}
	public void setEccSite(Object eccSite) {
		this.eccSite = eccSite;
	}
	public Object getEccSite() {
		return eccSite;
	}
	public void setEccPeriod(Object eccPeriod) {
		this.eccPeriod = eccPeriod;
	}
	public Object getEccPeriod() {
		return eccPeriod;
	}
	public void setMotBprm(java.math.BigDecimal motBprm) {
		this.motBprm = motBprm;
	}
	public java.math.BigDecimal getMotBprm() {
		return motBprm;
	}
	public void setMotGprm(java.math.BigDecimal motGprm) {
		this.motGprm = motGprm;
	}
	public java.math.BigDecimal getMotGprm() {
		return motGprm;
	}
	public void setMotOccup(Object motOccup) {
		this.motOccup = motOccup;
	}
	public Object getMotOccup() {
		return motOccup;
	}
	public void setMotMrhid1(String motMrhid1) {
		this.motMrhid1 = motMrhid1;
	}
	public String getMotMrhid1() {
		return motMrhid1;
	}
	public void setMotMrhver1(Long motMrhver1) {
		this.motMrhver1 = motMrhver1;
	}
	public Long getMotMrhver1() {
		return motMrhver1;
	}
	public void setMotMrhid2(String motMrhid2) {
		this.motMrhid2 = motMrhid2;
	}
	public String getMotMrhid2() {
		return motMrhid2;
	}
	public void setMotMrhver2(Long motMrhver2) {
		this.motMrhver2 = motMrhver2;
	}
	public Long getMotMrhver2() {
		return motMrhver2;
	}
	public void setSecRemark(Object secRemark) {
		this.secRemark = secRemark;
	}
	public Object getSecRemark() {
		return secRemark;
	}
	public void setSecEndtype(Object secEndtype) {
		this.secEndtype = secEndtype;
	}
	public Object getSecEndtype() {
		return secEndtype;
	}
	public void setSecSt(String secSt) {
		this.secSt = secSt;
	}
	public String getSecSt() {
		return secSt;
	}
	public void setSecStdate(java.util.Date secStdate) {
		this.secStdate = secStdate;
	}
	public java.util.Date getSecStdate() {
		return secStdate;
	}
	public void setSecIssdate(java.util.Date secIssdate) {
		this.secIssdate = secIssdate;
	}
	public java.util.Date getSecIssdate() {
		return secIssdate;
	}
	public void setSecCvnote(Object secCvnote) {
		this.secCvnote = secCvnote;
	}
	public Object getSecCvnote() {
		return secCvnote;
	}
	public void setSecCrnote(String secCrnote) {
		this.secCrnote = secCrnote;
	}
	public String getSecCrnote() {
		return secCrnote;
	}
	public void setSecEndprt(String secEndprt) {
		this.secEndprt = secEndprt;
	}
	public String getSecEndprt() {
		return secEndprt;
	}
	public void setSecChgsEff(java.util.Date secChgsEff) {
		this.secChgsEff = secChgsEff;
	}
	public java.util.Date getSecChgsEff() {
		return secChgsEff;
	}
	public void setSecDisc(java.math.BigDecimal secDisc) {
		this.secDisc = secDisc;
	}
	public java.math.BigDecimal getSecDisc() {
		return secDisc;
	}
	public void setSecCom(java.math.BigDecimal secCom) {
		this.secCom = secCom;
	}
	public java.math.BigDecimal getSecCom() {
		return secCom;
	}
	public void setSecMib(java.math.BigDecimal secMib) {
		this.secMib = secMib;
	}
	public java.math.BigDecimal getSecMib() {
		return secMib;
	}
	public void setSecBrok(java.math.BigDecimal secBrok) {
		this.secBrok = secBrok;
	}
	public java.math.BigDecimal getSecBrok() {
		return secBrok;
	}
	public void setSecTax(java.math.BigDecimal secTax) {
		this.secTax = secTax;
	}
	public java.math.BigDecimal getSecTax() {
		return secTax;
	}
	public void setSecFga(java.math.BigDecimal secFga) {
		this.secFga = secFga;
	}
	public java.math.BigDecimal getSecFga() {
		return secFga;
	}
	public void setSecLevy(java.math.BigDecimal secLevy) {
		this.secLevy = secLevy;
	}
	public java.math.BigDecimal getSecLevy() {
		return secLevy;
	}
	public void setSecAccum(java.math.BigDecimal secAccum) {
		this.secAccum = secAccum;
	}
	public java.math.BigDecimal getSecAccum() {
		return secAccum;
	}
	public void setSecSuragt(String secSuragt) {
		this.secSuragt = secSuragt;
	}
	public String getSecSuragt() {
		return secSuragt;
	}
	public void setSecSetagt(String secSetagt) {
		this.secSetagt = secSetagt;
	}
	public String getSecSetagt() {
		return secSetagt;
	}
	public void setSecVersion(Object secVersion) {
		this.secVersion = secVersion;
	}
	public Object getSecVersion() {
		return secVersion;
	}
	public void setSecSchby(String secSchby) {
		this.secSchby = secSchby;
	}
	public String getSecSchby() {
		return secSchby;
	}
	public void setSecDoc(Long secDoc) {
		this.secDoc = secDoc;
	}
	public Long getSecDoc() {
		return secDoc;
	}
	public void setSecDocid(String secDocid) {
		this.secDocid = secDocid;
	}
	public String getSecDocid() {
		return secDocid;
	}
	public void setSecVer(Long secVer) {
		this.secVer = secVer;
	}
	public Long getSecVer() {
		return secVer;
	}
	public void setSecBrn1(String secBrn1) {
		this.secBrn1 = secBrn1;
	}
	public String getSecBrn1() {
		return secBrn1;
	}
	public void setSecBrn2(String secBrn2) {
		this.secBrn2 = secBrn2;
	}
	public String getSecBrn2() {
		return secBrn2;
	}
	public void setSecBrn3(String secBrn3) {
		this.secBrn3 = secBrn3;
	}
	public String getSecBrn3() {
		return secBrn3;
	}
	public void setSecCoshare(Integer secCoshare) {
		this.secCoshare = secCoshare;
	}
	public Integer getSecCoshare() {
		return secCoshare;
	}
	public void setSecMedyear(Long secMedyear) {
		this.secMedyear = secMedyear;
	}
	public Long getSecMedyear() {
		return secMedyear;
	}
	public void setSecMedarea(Long secMedarea) {
		this.secMedarea = secMedarea;
	}
	public Long getSecMedarea() {
		return secMedarea;
	}
	public void setSecMedcard(Object secMedcard) {
		this.secMedcard = secMedcard;
	}
	public Object getSecMedcard() {
		return secMedcard;
	}
	public void setMohVehnochn1(String mohVehnochn1) {
		this.mohVehnochn1 = mohVehnochn1;
	}
	public String getMohVehnochn1() {
		return mohVehnochn1;
	}
	public void setSecMainttype(String secMainttype) {
		this.secMainttype = secMainttype;
	}
	public String getSecMainttype() {
		return secMainttype;
	}
	public void setSecMaintfr(java.util.Date secMaintfr) {
		this.secMaintfr = secMaintfr;
	}
	public java.util.Date getSecMaintfr() {
		return secMaintfr;
	}
	public void setSecMaintto(java.util.Date secMaintto) {
		this.secMaintto = secMaintto;
	}
	public java.util.Date getSecMaintto() {
		return secMaintto;
	}
	public void setSecMaintdays(Long secMaintdays) {
		this.secMaintdays = secMaintdays;
	}
	public Long getSecMaintdays() {
		return secMaintdays;
	}
	public void setSecSpaccpt(String secSpaccpt) {
		this.secSpaccpt = secSpaccpt;
	}
	public String getSecSpaccpt() {
		return secSpaccpt;
	}
	public void setSecSaleman(String secSaleman) {
		this.secSaleman = secSaleman;
	}
	public String getSecSaleman() {
		return secSaleman;
	}
	public void setSecWrpsts(String secWrpsts) {
		this.secWrpsts = secWrpsts;
	}
	public String getSecWrpsts() {
		return secWrpsts;
	}
	public void setSecPaymode(String secPaymode) {
		this.secPaymode = secPaymode;
	}
	public String getSecPaymode() {
		return secPaymode;
	}
	public void setSecCligrp(String secCligrp) {
		this.secCligrp = secCligrp;
	}
	public String getSecCligrp() {
		return secCligrp;
	}
	public void setSecCommplan(String secCommplan) {
		this.secCommplan = secCommplan;
	}
	public String getSecCommplan() {
		return secCommplan;
	}
	public void setSecSvcagt(String secSvcagt) {
		this.secSvcagt = secSvcagt;
	}
	public String getSecSvcagt() {
		return secSvcagt;
	}
	public void setSecCommto(String secCommto) {
		this.secCommto = secCommto;
	}
	public String getSecCommto() {
		return secCommto;
	}
	public void setSecComm4this(String secComm4this) {
		this.secComm4this = secComm4this;
	}
	public String getSecComm4this() {
		return secComm4this;
	}
	public void setSecPaymthd(String secPaymthd) {
		this.secPaymthd = secPaymthd;
	}
	public String getSecPaymthd() {
		return secPaymthd;
	}
	public void setSecCommchgd(String secCommchgd) {
		this.secCommchgd = secCommchgd;
	}
	public String getSecCommchgd() {
		return secCommchgd;
	}
	public void setSecDisc01(java.math.BigDecimal secDisc01) {
		this.secDisc01 = secDisc01;
	}
	public java.math.BigDecimal getSecDisc01() {
		return secDisc01;
	}
	public void setSecMprmrate1(java.math.BigDecimal secMprmrate1) {
		this.secMprmrate1 = secMprmrate1;
	}
	public java.math.BigDecimal getSecMprmrate1() {
		return secMprmrate1;
	}
	public void setSecMprmrate2(java.math.BigDecimal secMprmrate2) {
		this.secMprmrate2 = secMprmrate2;
	}
	public java.math.BigDecimal getSecMprmrate2() {
		return secMprmrate2;
	}
	public void setSecCommtable(String secCommtable) {
		this.secCommtable = secCommtable;
	}
	public String getSecCommtable() {
		return secCommtable;
	}
	public void setSecExtEndst(Long secExtEndst) {
		this.secExtEndst = secExtEndst;
	}
	public Long getSecExtEndst() {
		return secExtEndst;
	}
	public void setSecMinprm(java.math.BigDecimal secMinprm) {
		this.secMinprm = secMinprm;
	}
	public java.math.BigDecimal getSecMinprm() {
		return secMinprm;
	}
	public void setSecMinprmOr(String secMinprmOr) {
		this.secMinprmOr = secMinprmOr;
	}
	public String getSecMinprmOr() {
		return secMinprmOr;
	}
	public void setSecTraIpa(String secTraIpa) {
		this.secTraIpa = secTraIpa;
	}
	public String getSecTraIpa() {
		return secTraIpa;
	}
	public void setSecRategrp(String secRategrp) {
		this.secRategrp = secRategrp;
	}
	public String getSecRategrp() {
		return secRategrp;
	}
	public void setSecSaleteam(String secSaleteam) {
		this.secSaleteam = secSaleteam;
	}
	public String getSecSaleteam() {
		return secSaleteam;
	}
	public void setSecSalearea(String secSalearea) {
		this.secSalearea = secSalearea;
	}
	public String getSecSalearea() {
		return secSalearea;
	}
	public void setSecSaleleader(String secSaleleader) {
		this.secSaleleader = secSaleleader;
	}
	public String getSecSaleleader() {
		return secSaleleader;
	}
	public void setSecInternal(String secInternal) {
		this.secInternal = secInternal;
	}
	public String getSecInternal() {
		return secInternal;
	}
	public void setSecSaledept(String secSaledept) {
		this.secSaledept = secSaledept;
	}
	public String getSecSaledept() {
		return secSaledept;
	}
	public void setSecReinstate(String secReinstate) {
		this.secReinstate = secReinstate;
	}
	public String getSecReinstate() {
		return secReinstate;
	}
	public void setSecAgtdept(String secAgtdept) {
		this.secAgtdept = secAgtdept;
	}
	public String getSecAgtdept() {
		return secAgtdept;
	}
	public void setSecPayterm(Long secPayterm) {
		this.secPayterm = secPayterm;
	}
	public Long getSecPayterm() {
		return secPayterm;
	}
	public void setSecPrtonsoa(String secPrtonsoa) {
		this.secPrtonsoa = secPrtonsoa;
	}
	public String getSecPrtonsoa() {
		return secPrtonsoa;
	}
	public void setSecFeecount(Long secFeecount) {
		this.secFeecount = secFeecount;
	}
	public Long getSecFeecount() {
		return secFeecount;
	}
	public void setSecNumber1(java.math.BigDecimal secNumber1) {
		this.secNumber1 = secNumber1;
	}
	public java.math.BigDecimal getSecNumber1() {
		return secNumber1;
	}
	public void setSecString1(String secString1) {
		this.secString1 = secString1;
	}
	public String getSecString1() {
		return secString1;
	}
	public void setSecBankRef(String secBankRef) {
		this.secBankRef = secBankRef;
	}
	public String getSecBankRef() {
		return secBankRef;
	}
	public void setSecRicomgn(String secRicomgn) {
		this.secRicomgn = secRicomgn;
	}
	public String getSecRicomgn() {
		return secRicomgn;
	}
	public void setSecAutopixy(String secAutopixy) {
		this.secAutopixy = secAutopixy;
	}
	public String getSecAutopixy() {
		return secAutopixy;
	}
	public void setSecPreexist(String secPreexist) {
		this.secPreexist = secPreexist;
	}
	public String getSecPreexist() {
		return secPreexist;
	}
	public void setSecMaster(Double secMaster) {
		this.secMaster = secMaster;
	}
	public Double getSecMaster() {
		return secMaster;
	}
	public void setSecBillfreq(String secBillfreq) {
		this.secBillfreq = secBillfreq;
	}
	public String getSecBillfreq() {
		return secBillfreq;
	}
	public void setSecSchm(String secSchm) {
		this.secSchm = secSchm;
	}
	public String getSecSchm() {
		return secSchm;
	}
	public void setSecPrdid(String secPrdid) {
		this.secPrdid = secPrdid;
	}
	public String getSecPrdid() {
		return secPrdid;
	}
	public void setSecGrpendst1(Long secGrpendst1) {
		this.secGrpendst1 = secGrpendst1;
	}
	public Long getSecGrpendst1() {
		return secGrpendst1;
	}
	public void setSecBilling(String secBilling) {
		this.secBilling = secBilling;
	}
	public String getSecBilling() {
		return secBilling;
	}
	public void setSecMpremium(java.math.BigDecimal secMpremium) {
		this.secMpremium = secMpremium;
	}
	public java.math.BigDecimal getSecMpremium() {
		return secMpremium;
	}
	public void setSecNote1(Object secNote1) {
		this.secNote1 = secNote1;
	}
	public Object getSecNote1() {
		return secNote1;
	}
	public void setSecVarFr(java.util.Date secVarFr) {
		this.secVarFr = secVarFr;
	}
	public java.util.Date getSecVarFr() {
		return secVarFr;
	}
	public void setSecVarTo(java.util.Date secVarTo) {
		this.secVarTo = secVarTo;
	}
	public java.util.Date getSecVarTo() {
		return secVarTo;
	}
	public void setSecVarOpt(String secVarOpt) {
		this.secVarOpt = secVarOpt;
	}
	public String getSecVarOpt() {
		return secVarOpt;
	}
	public void setSecMaintOpt(String secMaintOpt) {
		this.secMaintOpt = secMaintOpt;
	}
	public String getSecMaintOpt() {
		return secMaintOpt;
	}
	public void setSecTestOpt(String secTestOpt) {
		this.secTestOpt = secTestOpt;
	}
	public String getSecTestOpt() {
		return secTestOpt;
	}
	public void setSecVarDm(String secVarDm) {
		this.secVarDm = secVarDm;
	}
	public String getSecVarDm() {
		return secVarDm;
	}
	public void setSecVarDmno(Integer secVarDmno) {
		this.secVarDmno = secVarDmno;
	}
	public Integer getSecVarDmno() {
		return secVarDmno;
	}
	public void setSecMaintDm(String secMaintDm) {
		this.secMaintDm = secMaintDm;
	}
	public String getSecMaintDm() {
		return secMaintDm;
	}
	public void setSecMaintDmno(Integer secMaintDmno) {
		this.secMaintDmno = secMaintDmno;
	}
	public Integer getSecMaintDmno() {
		return secMaintDmno;
	}
	public void setSecTestDm(String secTestDm) {
		this.secTestDm = secTestDm;
	}
	public String getSecTestDm() {
		return secTestDm;
	}
	public void setSecTestDmno(Integer secTestDmno) {
		this.secTestDmno = secTestDmno;
	}
	public Integer getSecTestDmno() {
		return secTestDmno;
	}
	public void setSecSusFr(java.util.Date secSusFr) {
		this.secSusFr = secSusFr;
	}
	public java.util.Date getSecSusFr() {
		return secSusFr;
	}
	public void setSecSusTo(java.util.Date secSusTo) {
		this.secSusTo = secSusTo;
	}
	public java.util.Date getSecSusTo() {
		return secSusTo;
	}
  
	private static final String Table = "secfl";
	private static final String Alias = "as_secfl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrSecOffice = Alias+".sec_office";
	public static final String DBStrSecDept = Alias+".sec_dept";
	public static final String DBStrSecCls = Alias+".sec_cls";
	public static final String DBStrSecAgt = Alias+".sec_agt";
	public static final String DBStrSecYear = Alias+".sec_year";
	public static final String DBStrSecId = Alias+".sec_id";
	public static final String DBStrSecSec = Alias+".sec_sec";
	public static final String DBStrSecEndst = Alias+".sec_endst";
	public static final String DBStrSecLast = Alias+".sec_last";
	public static final String DBStrSecCover = Alias+".sec_cover";
	public static final String DBStrSecClsdes = Alias+".sec_clsdes";
	public static final String DBStrSecScls = Alias+".sec_scls";
	public static final String DBStrSecEffdate = Alias+".sec_effdate";
	public static final String DBStrSecExpdate = Alias+".sec_expdate";
	public static final String DBStrSecEndstEff = Alias+".sec_endst_eff";
	public static final String DBStrSecEndstExp = Alias+".sec_endst_exp";
	public static final String DBStrSecMaFr = Alias+".sec_ma_fr";
	public static final String DBStrSecMaTo = Alias+".sec_ma_to";
	public static final String DBStrSecVehno = Alias+".sec_vehno";
	public static final String DBStrSecCcy = Alias+".sec_ccy";
	public static final String DBStrSecTsi = Alias+".sec_tsi";
	public static final String DBStrSecRate = Alias+".sec_rate";
	public static final String DBStrSecCDisc = Alias+".sec_c_disc";
	public static final String DBStrSecCCom = Alias+".sec_c_com";
	public static final String DBStrSecCTcom = Alias+".sec_c_tcom";
	public static final String DBStrSecCBrok = Alias+".sec_c_brok";
	public static final String DBStrSecCMib = Alias+".sec_c_mib";
	public static final String DBStrSecCLevy = Alias+".sec_c_levy";
	public static final String DBStrSecCNcb = Alias+".sec_c_ncb";
	public static final String DBStrSecCSur = Alias+".sec_c_sur";
	public static final String DBStrSecCFga = Alias+".sec_c_fga";
	public static final String DBStrSecCTax = Alias+".sec_c_tax";
	public static final String DBStrSecDrprt = Alias+".sec_drprt";
	public static final String DBStrSecCdate = Alias+".sec_cdate";
	public static final String DBStrSecAdate = Alias+".sec_adate";
	public static final String DBStrSecCuser = Alias+".sec_cuser";
	public static final String DBStrSecAuser = Alias+".sec_auser";
	public static final String DBStrSecLock = Alias+".sec_lock";
	public static final String DBStrSecCLoad = Alias+".sec_c_load";
	public static final String DBStrSecCSdisc = Alias+".sec_c_sdisc";
	public static final String DBStrSecExRate = Alias+".sec_ex_rate";
	public static final String DBStrSecXref = Alias+".sec_xref";
	public static final String DBStrSecAgtRef = Alias+".sec_agt_ref";
	public static final String DBStrSecPremium = Alias+".sec_premium";
	public static final String DBStrSecPrmBy = Alias+".sec_prm_by";
	public static final String DBStrSecPrmFtr = Alias+".sec_prm_ftr";
	public static final String DBStrSecAddprm = Alias+".sec_addprm";
	public static final String DBStrSecSurcharge = Alias+".sec_surcharge";
	public static final String DBStrSecNetprm = Alias+".sec_netprm";
	public static final String DBStrSecIsr = Alias+".sec_isr";
	public static final String DBStrSecTestFr = Alias+".sec_test_fr";
	public static final String DBStrSecTestTo = Alias+".sec_test_to";
	public static final String DBStrSecDepprm = Alias+".sec_depprm";
	public static final String DBStrSecLoc = Alias+".sec_loc";
	public static final String DBStrMotModeldes = Alias+".mot_modeldes";
	public static final String DBStrMotDoor = Alias+".mot_door";
	public static final String DBStrMotBody = Alias+".mot_body";
	public static final String DBStrMotAddval = Alias+".mot_addval";
	public static final String DBStrMotClauses = Alias+".mot_clauses";
	public static final String DBStrMotHpowner = Alias+".mot_hpowner";
	public static final String DBStrMotBlacklist = Alias+".mot_blacklist";
	public static final String DBStrMotLdAge = Alias+".mot_ld_age";
	public static final String DBStrMotLdModel = Alias+".mot_ld_model";
	public static final String DBStrMotLdAdriver = Alias+".mot_ld_adriver";
	public static final String DBStrMotLdOthers = Alias+".mot_ld_others";
	public static final String DBStrMotUse1 = Alias+".mot_use1";
	public static final String DBStrEccAisr = Alias+".ecc_aisr";
	public static final String DBStrEccIsrbus = Alias+".ecc_isrbus";
	public static final String DBStrEccCval = Alias+".ecc_cval";
	public static final String DBStrEccIndem = Alias+".ecc_indem";
	public static final String DBStrEccSite = Alias+".ecc_site";
	public static final String DBStrEccPeriod = Alias+".ecc_period";
	public static final String DBStrMotBprm = Alias+".mot_bprm";
	public static final String DBStrMotGprm = Alias+".mot_gprm";
	public static final String DBStrMotOccup = Alias+".mot_occup";
	public static final String DBStrMotMrhid1 = Alias+".mot_mrhid1";
	public static final String DBStrMotMrhver1 = Alias+".mot_mrhver1";
	public static final String DBStrMotMrhid2 = Alias+".mot_mrhid2";
	public static final String DBStrMotMrhver2 = Alias+".mot_mrhver2";
	public static final String DBStrSecRemark = Alias+".sec_remark";
	public static final String DBStrSecEndtype = Alias+".sec_endtype";
	public static final String DBStrSecSt = Alias+".sec_st";
	public static final String DBStrSecStdate = Alias+".sec_stdate";
	public static final String DBStrSecIssdate = Alias+".sec_issdate";
	public static final String DBStrSecCvnote = Alias+".sec_cvnote";
	public static final String DBStrSecCrnote = Alias+".sec_crnote";
	public static final String DBStrSecEndprt = Alias+".sec_endprt";
	public static final String DBStrSecChgsEff = Alias+".sec_chgs_eff";
	public static final String DBStrSecDisc = Alias+".sec_disc";
	public static final String DBStrSecCom = Alias+".sec_com";
	public static final String DBStrSecMib = Alias+".sec_mib";
	public static final String DBStrSecBrok = Alias+".sec_brok";
	public static final String DBStrSecTax = Alias+".sec_tax";
	public static final String DBStrSecFga = Alias+".sec_fga";
	public static final String DBStrSecLevy = Alias+".sec_levy";
	public static final String DBStrSecAccum = Alias+".sec_accum";
	public static final String DBStrSecSuragt = Alias+".sec_suragt";
	public static final String DBStrSecSetagt = Alias+".sec_setagt";
	public static final String DBStrSecVersion = Alias+".sec_version";
	public static final String DBStrSecSchby = Alias+".sec_schby";
	public static final String DBStrSecDoc = Alias+".sec_doc";
	public static final String DBStrSecDocid = Alias+".sec_docid";
	public static final String DBStrSecVer = Alias+".sec_ver";
	public static final String DBStrSecBrn1 = Alias+".sec_brn1";
	public static final String DBStrSecBrn2 = Alias+".sec_brn2";
	public static final String DBStrSecBrn3 = Alias+".sec_brn3";
	public static final String DBStrSecCoshare = Alias+".sec_coshare";
	public static final String DBStrSecMedyear = Alias+".sec_medyear";
	public static final String DBStrSecMedarea = Alias+".sec_medarea";
	public static final String DBStrSecMedcard = Alias+".sec_medcard";
	public static final String DBStrMohVehnochn1 = Alias+".moh_vehnochn1";
	public static final String DBStrSecMainttype = Alias+".sec_mainttype";
	public static final String DBStrSecMaintfr = Alias+".sec_maintfr";
	public static final String DBStrSecMaintto = Alias+".sec_maintto";
	public static final String DBStrSecMaintdays = Alias+".sec_maintdays";
	public static final String DBStrSecSpaccpt = Alias+".sec_spaccpt";
	public static final String DBStrSecSaleman = Alias+".sec_saleman";
	public static final String DBStrSecWrpsts = Alias+".sec_wrpsts";
	public static final String DBStrSecPaymode = Alias+".sec_paymode";
	public static final String DBStrSecCligrp = Alias+".sec_cligrp";
	public static final String DBStrSecCommplan = Alias+".sec_commplan";
	public static final String DBStrSecSvcagt = Alias+".sec_svcagt";
	public static final String DBStrSecCommto = Alias+".sec_commto";
	public static final String DBStrSecComm4this = Alias+".sec_comm4this";
	public static final String DBStrSecPaymthd = Alias+".sec_paymthd";
	public static final String DBStrSecCommchgd = Alias+".sec_commchgd";
	public static final String DBStrSecDisc01 = Alias+".sec_disc_01";
	public static final String DBStrSecMprmrate1 = Alias+".sec_mprmrate1";
	public static final String DBStrSecMprmrate2 = Alias+".sec_mprmrate2";
	public static final String DBStrSecCommtable = Alias+".sec_commtable";
	public static final String DBStrSecExtEndst = Alias+".sec_ext_endst";
	public static final String DBStrSecMinprm = Alias+".sec_minprm";
	public static final String DBStrSecMinprmOr = Alias+".sec_minprm_or";
	public static final String DBStrSecTraIpa = Alias+".sec_tra_ipa";
	public static final String DBStrSecRategrp = Alias+".sec_rategrp";
	public static final String DBStrSecSaleteam = Alias+".sec_saleteam";
	public static final String DBStrSecSalearea = Alias+".sec_salearea";
	public static final String DBStrSecSaleleader = Alias+".sec_saleleader";
	public static final String DBStrSecInternal = Alias+".sec_internal";
	public static final String DBStrSecSaledept = Alias+".sec_saledept";
	public static final String DBStrSecReinstate = Alias+".sec_reinstate";
	public static final String DBStrSecAgtdept = Alias+".sec_agtdept";
	public static final String DBStrSecPayterm = Alias+".sec_payterm";
	public static final String DBStrSecPrtonsoa = Alias+".sec_prtonsoa";
	public static final String DBStrSecFeecount = Alias+".sec_feecount";
	public static final String DBStrSecNumber1 = Alias+".sec_number1";
	public static final String DBStrSecString1 = Alias+".sec_string1";
	public static final String DBStrSecBankRef = Alias+".sec_bank_ref";
	public static final String DBStrSecRicomgn = Alias+".sec_ricomgn";
	public static final String DBStrSecAutopixy = Alias+".sec_autopixy";
	public static final String DBStrSecPreexist = Alias+".sec_preexist";
	public static final String DBStrSecMaster = Alias+".sec_master";
	public static final String DBStrSecBillfreq = Alias+".sec_billfreq";
	public static final String DBStrSecSchm = Alias+".sec_schm";
	public static final String DBStrSecPrdid = Alias+".sec_prdid";
	public static final String DBStrSecGrpendst1 = Alias+".sec_grpendst1";
	public static final String DBStrSecBilling = Alias+".sec_billing";
	public static final String DBStrSecMpremium = Alias+".sec_mpremium";
	public static final String DBStrSecNote1 = Alias+".sec_note1";
	public static final String DBStrSecVarFr = Alias+".sec_var_fr";
	public static final String DBStrSecVarTo = Alias+".sec_var_to";
	public static final String DBStrSecVarOpt = Alias+".sec_var_opt";
	public static final String DBStrSecMaintOpt = Alias+".sec_maint_opt";
	public static final String DBStrSecTestOpt = Alias+".sec_test_opt";
	public static final String DBStrSecVarDm = Alias+".sec_var_dm";
	public static final String DBStrSecVarDmno = Alias+".sec_var_dmno";
	public static final String DBStrSecMaintDm = Alias+".sec_maint_dm";
	public static final String DBStrSecMaintDmno = Alias+".sec_maint_dmno";
	public static final String DBStrSecTestDm = Alias+".sec_test_dm";
	public static final String DBStrSecTestDmno = Alias+".sec_test_dmno";
	public static final String DBStrSecSusFr = Alias+".sec_sus_fr";
	public static final String DBStrSecSusTo = Alias+".sec_sus_to";
	
	@Override
	public Secfl clone() {
		Secfl o = null;
		try{
			o = (Secfl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

