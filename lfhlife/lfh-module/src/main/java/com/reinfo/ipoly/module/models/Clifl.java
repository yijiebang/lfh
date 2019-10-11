package com.reinfo.ipoly.module.models;
import java.io.Serializable;

import com.reinfo.ipoly.module.base.models.Page;

public class Clifl implements Serializable, Cloneable {
	private String cliCode;
	private Object cliLname;
	private Object cliSname;
	private Object cliAddr1;
	private Object cliAddr2;
	private Object cliAddr3;
	private Object cliAddr4;
	private String cliCty;
	private Object cliZip;
	private String cliType;
	private String cliGroup;
	private String cliTelidd;
	private Object cliTel;
	private String cliFaxidd;
	private Object cliFax;
	private String cliTlxidd;
	private Object cliTlx;
	private Object cliEmail;
	private Object cliBank;
	private String cliAtnac;
	private String cliAtnclm;
	private String cliAtnuw;
	private String cliAtnfac;
	private String cliAtntty;
	private String cliCapccy;
	private Long cliCapamt;
	private Object cliNote;
	private String cliSt;
	private String cliOffice;
	private String cliStaff;
	private java.util.Date cliCdate;
	private java.util.Date cliAdate;
	private String cliCuser;
	private String cliAuser;
	private Long cliLock;
	private String cliAr;
	private Long cliCrdays;
	private String cliJoinsts;
	private java.util.Date cliJoindate;
	private String cliRplcby;
	private java.util.Date cliStdate;
	private Object cliPIdcard;
	private java.util.Date cliPBirth;
	private String cliPSex;
	private Object cliNote1;
	private String cliAgent;
	private String cliUnit;
	private String cliCli;
	private String cliNat;
	private Object cliTaxfile;
	private Object cliRegno;
	private Integer cliNum;
	private String cliArea;
	private String cliBnk;
	private String cliBrn;
	private String cliBankac;
	private String cliLic;
	private String cliMar;
	private Object cliDbtnm;
	private String cliResidd;
	private Object cliRestel;
	private String cliMobidd;
	private Object cliMobtel;
	private Object cliCname;
	private String cliMlock;
	private java.util.Date cliMlockdt;
	private Object cliMlockrmk;
	private java.util.Date cliOsysdt;
	private Long cliOday;
	private java.util.Date cliOuptot;
	private String cliOby;
	private Object cliOrmk;
	private String cliDismgr;
	private String cliSuper;
	private java.util.Date cliCtdt;
	private String cliCtby;
	private java.util.Date cliCtgrcdt;
	private Object cliCtgrcrmk;
	private String cliSoamp;
	private String cliSoaskip;
	private String cliSkiplock;
	private java.util.Date cliRenappdt;
	private String cliAchandle;
	private Object cliPager;
	private Object cliStrmk;
	private Long cliGuar;
	private String cliAddr9;
	private Object cliSaddr1;
	private Object cliSaddr2;
	private Object cliSaddr3;
	private String cliSaddr9;
	private String cliRsr1;
	private String cliRsr2;
	private String cliLicense;
	private Object cliLictxt;
	private Object cliIntroby;
	private String cliAlwteam;
	private String cliLocksts;
	private String cliForagt;
	private Long cliRmkkey;
	private String cliSrc;
	private String cliOccup;
	private String cliComm2main;
	private String cliMainagt;
	private String cliPIdtype;
	private String cliDiv;
	private java.util.Date cliTermdt;
	private String cliLoc1;
	private String cliLoc2;
	private Object cliBirthplace;
	private Object cliStdname;
	private Object cliNicknm;
	private Object cliOthnm;
	private Object cliFirstnm;
	private Object cliSurnm;
	private String cliNeedizufee;
	private String cliDept;
	private java.math.BigDecimal cliOpolcnt;
	private String cliXref;
	private String cliAppno;
	private String cliAdjno;
	private String cliPaymthd;
	private String cliCommgrp;
	private String cliStdcommgrp;
	private String cliIsspol;
	private String cliIsscomm;
	private String cliAlwagt;
	private String cliCommgrp01;
	private String cliRelation;
	private String cliMustizufee;
	private String cliForres;
	private java.math.BigDecimal cliDeductrate;
	private String cliPc01;
	private String cliPc02;
	private String cliPc03;
	private String cliPc04;
	private String cliPc05;
	private String cliPc06;
	private String cliPrtrcp;
	private String cliStmntby;
	private String cliStmntfmt;
	private String cliShownet;
	private String cliMbrof;
	private String cliSameas;
	private String cliOpolisr;
	private String cliOpolcls;
	private Object cliNote9;
	private String cliSkiprcp;
	private java.util.Date cliEndreg;
	private String xRenew;
	private Long cliRmkkey1;
	private String cliAgtlock;
	private String cliSrcgrp;
	private String cliMlock2;
	private java.util.Date cliMlockdt2;
	private Object cliMlockrmk2;
	private String cliIsspol2;
	private java.util.Date cliCodfr;
	private java.util.Date cliCodto;
	private java.util.Date cliCodfr2;
	private java.util.Date cliCodto2;
	private java.util.Date cliEndreg02;
	private String cliQli;
	private String cliRegno01;
	private String cliRegno02;
	private String cliRegtype;
	private String cliSrcregno;
	private String cliSrctype;
	private java.util.Date cliStartreg;
	private java.util.Date cliStartreg02;
	private String cliGroup1;
	private String cliGroup2;
	private String cliGroup3;
	private String cliBankagt;
	private String cliRndgDn;
	private String cliLoginid;
	private java.util.Date cliSyncprofiledate;
	private String cliIagstatus;
	private String cliResyncflag;
		
	private String cliLnameFrom;
	private String cliLnameTo;
	private Page page;
	
	public String getCliLnameFrom() {
        return cliLnameFrom;
    }
    public void setCliLnameFrom(String cliLnameFrom) {
        this.cliLnameFrom = cliLnameFrom;
    }
    public String getCliLnameTo() {
        return cliLnameTo;
    }
    public void setCliLnameTo(String cliLnameTo) {
        this.cliLnameTo = cliLnameTo;
    }
    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }

	public void setCliCode(String cliCode) {
		this.cliCode = cliCode;
	}
	public String getCliCode() {
		return cliCode;
	}
	public void setCliLname(Object cliLname) {
		this.cliLname = cliLname;
	}
	public Object getCliLname() {
		return cliLname;
	}
	public void setCliSname(Object cliSname) {
		this.cliSname = cliSname;
	}
	public Object getCliSname() {
		return cliSname;
	}
	public void setCliAddr1(Object cliAddr1) {
		this.cliAddr1 = cliAddr1;
	}
	public Object getCliAddr1() {
		return cliAddr1;
	}
	public void setCliAddr2(Object cliAddr2) {
		this.cliAddr2 = cliAddr2;
	}
	public Object getCliAddr2() {
		return cliAddr2;
	}
	public void setCliAddr3(Object cliAddr3) {
		this.cliAddr3 = cliAddr3;
	}
	public Object getCliAddr3() {
		return cliAddr3;
	}
	public void setCliAddr4(Object cliAddr4) {
		this.cliAddr4 = cliAddr4;
	}
	public Object getCliAddr4() {
		return cliAddr4;
	}
	public void setCliCty(String cliCty) {
		this.cliCty = cliCty;
	}
	public String getCliCty() {
		return cliCty;
	}
	public void setCliZip(Object cliZip) {
		this.cliZip = cliZip;
	}
	public Object getCliZip() {
		return cliZip;
	}
	public void setCliType(String cliType) {
		this.cliType = cliType;
	}
	public String getCliType() {
		return cliType;
	}
	public void setCliGroup(String cliGroup) {
		this.cliGroup = cliGroup;
	}
	public String getCliGroup() {
		return cliGroup;
	}
	public void setCliTelidd(String cliTelidd) {
		this.cliTelidd = cliTelidd;
	}
	public String getCliTelidd() {
		return cliTelidd;
	}
	public void setCliTel(Object cliTel) {
		this.cliTel = cliTel;
	}
	public Object getCliTel() {
		return cliTel;
	}
	public void setCliFaxidd(String cliFaxidd) {
		this.cliFaxidd = cliFaxidd;
	}
	public String getCliFaxidd() {
		return cliFaxidd;
	}
	public void setCliFax(Object cliFax) {
		this.cliFax = cliFax;
	}
	public Object getCliFax() {
		return cliFax;
	}
	public void setCliTlxidd(String cliTlxidd) {
		this.cliTlxidd = cliTlxidd;
	}
	public String getCliTlxidd() {
		return cliTlxidd;
	}
	public void setCliTlx(Object cliTlx) {
		this.cliTlx = cliTlx;
	}
	public Object getCliTlx() {
		return cliTlx;
	}
	public void setCliEmail(Object cliEmail) {
		this.cliEmail = cliEmail;
	}
	public Object getCliEmail() {
		return cliEmail;
	}
	public void setCliBank(Object cliBank) {
		this.cliBank = cliBank;
	}
	public Object getCliBank() {
		return cliBank;
	}
	public void setCliAtnac(String cliAtnac) {
		this.cliAtnac = cliAtnac;
	}
	public String getCliAtnac() {
		return cliAtnac;
	}
	public void setCliAtnclm(String cliAtnclm) {
		this.cliAtnclm = cliAtnclm;
	}
	public String getCliAtnclm() {
		return cliAtnclm;
	}
	public void setCliAtnuw(String cliAtnuw) {
		this.cliAtnuw = cliAtnuw;
	}
	public String getCliAtnuw() {
		return cliAtnuw;
	}
	public void setCliAtnfac(String cliAtnfac) {
		this.cliAtnfac = cliAtnfac;
	}
	public String getCliAtnfac() {
		return cliAtnfac;
	}
	public void setCliAtntty(String cliAtntty) {
		this.cliAtntty = cliAtntty;
	}
	public String getCliAtntty() {
		return cliAtntty;
	}
	public void setCliCapccy(String cliCapccy) {
		this.cliCapccy = cliCapccy;
	}
	public String getCliCapccy() {
		return cliCapccy;
	}
	public void setCliCapamt(Long cliCapamt) {
		this.cliCapamt = cliCapamt;
	}
	public Long getCliCapamt() {
		return cliCapamt;
	}
	public void setCliNote(Object cliNote) {
		this.cliNote = cliNote;
	}
	public Object getCliNote() {
		return cliNote;
	}
	public void setCliSt(String cliSt) {
		this.cliSt = cliSt;
	}
	public String getCliSt() {
		return cliSt;
	}
	public void setCliOffice(String cliOffice) {
		this.cliOffice = cliOffice;
	}
	public String getCliOffice() {
		return cliOffice;
	}
	public void setCliStaff(String cliStaff) {
		this.cliStaff = cliStaff;
	}
	public String getCliStaff() {
		return cliStaff;
	}
	public void setCliCdate(java.util.Date cliCdate) {
		this.cliCdate = cliCdate;
	}
	public java.util.Date getCliCdate() {
		return cliCdate;
	}
	public void setCliAdate(java.util.Date cliAdate) {
		this.cliAdate = cliAdate;
	}
	public java.util.Date getCliAdate() {
		return cliAdate;
	}
	public void setCliCuser(String cliCuser) {
		this.cliCuser = cliCuser;
	}
	public String getCliCuser() {
		return cliCuser;
	}
	public void setCliAuser(String cliAuser) {
		this.cliAuser = cliAuser;
	}
	public String getCliAuser() {
		return cliAuser;
	}
	public void setCliLock(Long cliLock) {
		this.cliLock = cliLock;
	}
	public Long getCliLock() {
		return cliLock;
	}
	public void setCliAr(String cliAr) {
		this.cliAr = cliAr;
	}
	public String getCliAr() {
		return cliAr;
	}
	public void setCliCrdays(Long cliCrdays) {
		this.cliCrdays = cliCrdays;
	}
	public Long getCliCrdays() {
		return cliCrdays;
	}
	public void setCliJoinsts(String cliJoinsts) {
		this.cliJoinsts = cliJoinsts;
	}
	public String getCliJoinsts() {
		return cliJoinsts;
	}
	public void setCliJoindate(java.util.Date cliJoindate) {
		this.cliJoindate = cliJoindate;
	}
	public java.util.Date getCliJoindate() {
		return cliJoindate;
	}
	public void setCliRplcby(String cliRplcby) {
		this.cliRplcby = cliRplcby;
	}
	public String getCliRplcby() {
		return cliRplcby;
	}
	public void setCliStdate(java.util.Date cliStdate) {
		this.cliStdate = cliStdate;
	}
	public java.util.Date getCliStdate() {
		return cliStdate;
	}
	public void setCliPIdcard(Object cliPIdcard) {
		this.cliPIdcard = cliPIdcard;
	}
	public Object getCliPIdcard() {
		return cliPIdcard;
	}
	public void setCliPBirth(java.util.Date cliPBirth) {
		this.cliPBirth = cliPBirth;
	}
	public java.util.Date getCliPBirth() {
		return cliPBirth;
	}
	public void setCliPSex(String cliPSex) {
		this.cliPSex = cliPSex;
	}
	public String getCliPSex() {
		return cliPSex;
	}
	public void setCliNote1(Object cliNote1) {
		this.cliNote1 = cliNote1;
	}
	public Object getCliNote1() {
		return cliNote1;
	}
	public void setCliAgent(String cliAgent) {
		this.cliAgent = cliAgent;
	}
	public String getCliAgent() {
		return cliAgent;
	}
	public void setCliUnit(String cliUnit) {
		this.cliUnit = cliUnit;
	}
	public String getCliUnit() {
		return cliUnit;
	}
	public void setCliCli(String cliCli) {
		this.cliCli = cliCli;
	}
	public String getCliCli() {
		return cliCli;
	}
	public void setCliNat(String cliNat) {
		this.cliNat = cliNat;
	}
	public String getCliNat() {
		return cliNat;
	}
	public void setCliTaxfile(Object cliTaxfile) {
		this.cliTaxfile = cliTaxfile;
	}
	public Object getCliTaxfile() {
		return cliTaxfile;
	}
	public void setCliRegno(Object cliRegno) {
		this.cliRegno = cliRegno;
	}
	public Object getCliRegno() {
		return cliRegno;
	}
	public void setCliNum(Integer cliNum) {
		this.cliNum = cliNum;
	}
	public Integer getCliNum() {
		return cliNum;
	}
	public void setCliArea(String cliArea) {
		this.cliArea = cliArea;
	}
	public String getCliArea() {
		return cliArea;
	}
	public void setCliBnk(String cliBnk) {
		this.cliBnk = cliBnk;
	}
	public String getCliBnk() {
		return cliBnk;
	}
	public void setCliBrn(String cliBrn) {
		this.cliBrn = cliBrn;
	}
	public String getCliBrn() {
		return cliBrn;
	}
	public void setCliBankac(String cliBankac) {
		this.cliBankac = cliBankac;
	}
	public String getCliBankac() {
		return cliBankac;
	}
	public void setCliLic(String cliLic) {
		this.cliLic = cliLic;
	}
	public String getCliLic() {
		return cliLic;
	}
	public void setCliMar(String cliMar) {
		this.cliMar = cliMar;
	}
	public String getCliMar() {
		return cliMar;
	}
	public void setCliDbtnm(Object cliDbtnm) {
		this.cliDbtnm = cliDbtnm;
	}
	public Object getCliDbtnm() {
		return cliDbtnm;
	}
	public void setCliResidd(String cliResidd) {
		this.cliResidd = cliResidd;
	}
	public String getCliResidd() {
		return cliResidd;
	}
	public void setCliRestel(Object cliRestel) {
		this.cliRestel = cliRestel;
	}
	public Object getCliRestel() {
		return cliRestel;
	}
	public void setCliMobidd(String cliMobidd) {
		this.cliMobidd = cliMobidd;
	}
	public String getCliMobidd() {
		return cliMobidd;
	}
	public void setCliMobtel(Object cliMobtel) {
		this.cliMobtel = cliMobtel;
	}
	public Object getCliMobtel() {
		return cliMobtel;
	}
	public void setCliCname(Object cliCname) {
		this.cliCname = cliCname;
	}
	public Object getCliCname() {
		return cliCname;
	}
	public void setCliMlock(String cliMlock) {
		this.cliMlock = cliMlock;
	}
	public String getCliMlock() {
		return cliMlock;
	}
	public void setCliMlockdt(java.util.Date cliMlockdt) {
		this.cliMlockdt = cliMlockdt;
	}
	public java.util.Date getCliMlockdt() {
		return cliMlockdt;
	}
	public void setCliMlockrmk(Object cliMlockrmk) {
		this.cliMlockrmk = cliMlockrmk;
	}
	public Object getCliMlockrmk() {
		return cliMlockrmk;
	}
	public void setCliOsysdt(java.util.Date cliOsysdt) {
		this.cliOsysdt = cliOsysdt;
	}
	public java.util.Date getCliOsysdt() {
		return cliOsysdt;
	}
	public void setCliOday(Long cliOday) {
		this.cliOday = cliOday;
	}
	public Long getCliOday() {
		return cliOday;
	}
	public void setCliOuptot(java.util.Date cliOuptot) {
		this.cliOuptot = cliOuptot;
	}
	public java.util.Date getCliOuptot() {
		return cliOuptot;
	}
	public void setCliOby(String cliOby) {
		this.cliOby = cliOby;
	}
	public String getCliOby() {
		return cliOby;
	}
	public void setCliOrmk(Object cliOrmk) {
		this.cliOrmk = cliOrmk;
	}
	public Object getCliOrmk() {
		return cliOrmk;
	}
	public void setCliDismgr(String cliDismgr) {
		this.cliDismgr = cliDismgr;
	}
	public String getCliDismgr() {
		return cliDismgr;
	}
	public void setCliSuper(String cliSuper) {
		this.cliSuper = cliSuper;
	}
	public String getCliSuper() {
		return cliSuper;
	}
	public void setCliCtdt(java.util.Date cliCtdt) {
		this.cliCtdt = cliCtdt;
	}
	public java.util.Date getCliCtdt() {
		return cliCtdt;
	}
	public void setCliCtby(String cliCtby) {
		this.cliCtby = cliCtby;
	}
	public String getCliCtby() {
		return cliCtby;
	}
	public void setCliCtgrcdt(java.util.Date cliCtgrcdt) {
		this.cliCtgrcdt = cliCtgrcdt;
	}
	public java.util.Date getCliCtgrcdt() {
		return cliCtgrcdt;
	}
	public void setCliCtgrcrmk(Object cliCtgrcrmk) {
		this.cliCtgrcrmk = cliCtgrcrmk;
	}
	public Object getCliCtgrcrmk() {
		return cliCtgrcrmk;
	}
	public void setCliSoamp(String cliSoamp) {
		this.cliSoamp = cliSoamp;
	}
	public String getCliSoamp() {
		return cliSoamp;
	}
	public void setCliSoaskip(String cliSoaskip) {
		this.cliSoaskip = cliSoaskip;
	}
	public String getCliSoaskip() {
		return cliSoaskip;
	}
	public void setCliSkiplock(String cliSkiplock) {
		this.cliSkiplock = cliSkiplock;
	}
	public String getCliSkiplock() {
		return cliSkiplock;
	}
	public void setCliRenappdt(java.util.Date cliRenappdt) {
		this.cliRenappdt = cliRenappdt;
	}
	public java.util.Date getCliRenappdt() {
		return cliRenappdt;
	}
	public void setCliAchandle(String cliAchandle) {
		this.cliAchandle = cliAchandle;
	}
	public String getCliAchandle() {
		return cliAchandle;
	}
	public void setCliPager(Object cliPager) {
		this.cliPager = cliPager;
	}
	public Object getCliPager() {
		return cliPager;
	}
	public void setCliStrmk(Object cliStrmk) {
		this.cliStrmk = cliStrmk;
	}
	public Object getCliStrmk() {
		return cliStrmk;
	}
	public void setCliGuar(Long cliGuar) {
		this.cliGuar = cliGuar;
	}
	public Long getCliGuar() {
		return cliGuar;
	}
	public void setCliAddr9(String cliAddr9) {
		this.cliAddr9 = cliAddr9;
	}
	public String getCliAddr9() {
		return cliAddr9;
	}
	public void setCliSaddr1(Object cliSaddr1) {
		this.cliSaddr1 = cliSaddr1;
	}
	public Object getCliSaddr1() {
		return cliSaddr1;
	}
	public void setCliSaddr2(Object cliSaddr2) {
		this.cliSaddr2 = cliSaddr2;
	}
	public Object getCliSaddr2() {
		return cliSaddr2;
	}
	public void setCliSaddr3(Object cliSaddr3) {
		this.cliSaddr3 = cliSaddr3;
	}
	public Object getCliSaddr3() {
		return cliSaddr3;
	}
	public void setCliSaddr9(String cliSaddr9) {
		this.cliSaddr9 = cliSaddr9;
	}
	public String getCliSaddr9() {
		return cliSaddr9;
	}
	public void setCliRsr1(String cliRsr1) {
		this.cliRsr1 = cliRsr1;
	}
	public String getCliRsr1() {
		return cliRsr1;
	}
	public void setCliRsr2(String cliRsr2) {
		this.cliRsr2 = cliRsr2;
	}
	public String getCliRsr2() {
		return cliRsr2;
	}
	public void setCliLicense(String cliLicense) {
		this.cliLicense = cliLicense;
	}
	public String getCliLicense() {
		return cliLicense;
	}
	public void setCliLictxt(Object cliLictxt) {
		this.cliLictxt = cliLictxt;
	}
	public Object getCliLictxt() {
		return cliLictxt;
	}
	public void setCliIntroby(Object cliIntroby) {
		this.cliIntroby = cliIntroby;
	}
	public Object getCliIntroby() {
		return cliIntroby;
	}
	public void setCliAlwteam(String cliAlwteam) {
		this.cliAlwteam = cliAlwteam;
	}
	public String getCliAlwteam() {
		return cliAlwteam;
	}
	public void setCliLocksts(String cliLocksts) {
		this.cliLocksts = cliLocksts;
	}
	public String getCliLocksts() {
		return cliLocksts;
	}
	public void setCliForagt(String cliForagt) {
		this.cliForagt = cliForagt;
	}
	public String getCliForagt() {
		return cliForagt;
	}
	public void setCliRmkkey(Long cliRmkkey) {
		this.cliRmkkey = cliRmkkey;
	}
	public Long getCliRmkkey() {
		return cliRmkkey;
	}
	public void setCliSrc(String cliSrc) {
		this.cliSrc = cliSrc;
	}
	public String getCliSrc() {
		return cliSrc;
	}
	public void setCliOccup(String cliOccup) {
		this.cliOccup = cliOccup;
	}
	public String getCliOccup() {
		return cliOccup;
	}
	public void setCliComm2main(String cliComm2main) {
		this.cliComm2main = cliComm2main;
	}
	public String getCliComm2main() {
		return cliComm2main;
	}
	public void setCliMainagt(String cliMainagt) {
		this.cliMainagt = cliMainagt;
	}
	public String getCliMainagt() {
		return cliMainagt;
	}
	public void setCliPIdtype(String cliPIdtype) {
		this.cliPIdtype = cliPIdtype;
	}
	public String getCliPIdtype() {
		return cliPIdtype;
	}
	public void setCliDiv(String cliDiv) {
		this.cliDiv = cliDiv;
	}
	public String getCliDiv() {
		return cliDiv;
	}
	public void setCliTermdt(java.util.Date cliTermdt) {
		this.cliTermdt = cliTermdt;
	}
	public java.util.Date getCliTermdt() {
		return cliTermdt;
	}
	public void setCliLoc1(String cliLoc1) {
		this.cliLoc1 = cliLoc1;
	}
	public String getCliLoc1() {
		return cliLoc1;
	}
	public void setCliLoc2(String cliLoc2) {
		this.cliLoc2 = cliLoc2;
	}
	public String getCliLoc2() {
		return cliLoc2;
	}
	public void setCliBirthplace(Object cliBirthplace) {
		this.cliBirthplace = cliBirthplace;
	}
	public Object getCliBirthplace() {
		return cliBirthplace;
	}
	public void setCliStdname(Object cliStdname) {
		this.cliStdname = cliStdname;
	}
	public Object getCliStdname() {
		return cliStdname;
	}
	public void setCliNicknm(Object cliNicknm) {
		this.cliNicknm = cliNicknm;
	}
	public Object getCliNicknm() {
		return cliNicknm;
	}
	public void setCliOthnm(Object cliOthnm) {
		this.cliOthnm = cliOthnm;
	}
	public Object getCliOthnm() {
		return cliOthnm;
	}
	public void setCliFirstnm(Object cliFirstnm) {
		this.cliFirstnm = cliFirstnm;
	}
	public Object getCliFirstnm() {
		return cliFirstnm;
	}
	public void setCliSurnm(Object cliSurnm) {
		this.cliSurnm = cliSurnm;
	}
	public Object getCliSurnm() {
		return cliSurnm;
	}
	public void setCliNeedizufee(String cliNeedizufee) {
		this.cliNeedizufee = cliNeedizufee;
	}
	public String getCliNeedizufee() {
		return cliNeedizufee;
	}
	public void setCliDept(String cliDept) {
		this.cliDept = cliDept;
	}
	public String getCliDept() {
		return cliDept;
	}
	public void setCliOpolcnt(java.math.BigDecimal cliOpolcnt) {
		this.cliOpolcnt = cliOpolcnt;
	}
	public java.math.BigDecimal getCliOpolcnt() {
		return cliOpolcnt;
	}
	public void setCliXref(String cliXref) {
		this.cliXref = cliXref;
	}
	public String getCliXref() {
		return cliXref;
	}
	public void setCliAppno(String cliAppno) {
		this.cliAppno = cliAppno;
	}
	public String getCliAppno() {
		return cliAppno;
	}
	public void setCliAdjno(String cliAdjno) {
		this.cliAdjno = cliAdjno;
	}
	public String getCliAdjno() {
		return cliAdjno;
	}
	public void setCliPaymthd(String cliPaymthd) {
		this.cliPaymthd = cliPaymthd;
	}
	public String getCliPaymthd() {
		return cliPaymthd;
	}
	public void setCliCommgrp(String cliCommgrp) {
		this.cliCommgrp = cliCommgrp;
	}
	public String getCliCommgrp() {
		return cliCommgrp;
	}
	public void setCliStdcommgrp(String cliStdcommgrp) {
		this.cliStdcommgrp = cliStdcommgrp;
	}
	public String getCliStdcommgrp() {
		return cliStdcommgrp;
	}
	public void setCliIsspol(String cliIsspol) {
		this.cliIsspol = cliIsspol;
	}
	public String getCliIsspol() {
		return cliIsspol;
	}
	public void setCliIsscomm(String cliIsscomm) {
		this.cliIsscomm = cliIsscomm;
	}
	public String getCliIsscomm() {
		return cliIsscomm;
	}
	public void setCliAlwagt(String cliAlwagt) {
		this.cliAlwagt = cliAlwagt;
	}
	public String getCliAlwagt() {
		return cliAlwagt;
	}
	public void setCliCommgrp01(String cliCommgrp01) {
		this.cliCommgrp01 = cliCommgrp01;
	}
	public String getCliCommgrp01() {
		return cliCommgrp01;
	}
	public void setCliRelation(String cliRelation) {
		this.cliRelation = cliRelation;
	}
	public String getCliRelation() {
		return cliRelation;
	}
	public void setCliMustizufee(String cliMustizufee) {
		this.cliMustizufee = cliMustizufee;
	}
	public String getCliMustizufee() {
		return cliMustizufee;
	}
	public void setCliForres(String cliForres) {
		this.cliForres = cliForres;
	}
	public String getCliForres() {
		return cliForres;
	}
	public void setCliDeductrate(java.math.BigDecimal cliDeductrate) {
		this.cliDeductrate = cliDeductrate;
	}
	public java.math.BigDecimal getCliDeductrate() {
		return cliDeductrate;
	}
	public void setCliPc01(String cliPc01) {
		this.cliPc01 = cliPc01;
	}
	public String getCliPc01() {
		return cliPc01;
	}
	public void setCliPc02(String cliPc02) {
		this.cliPc02 = cliPc02;
	}
	public String getCliPc02() {
		return cliPc02;
	}
	public void setCliPc03(String cliPc03) {
		this.cliPc03 = cliPc03;
	}
	public String getCliPc03() {
		return cliPc03;
	}
	public void setCliPc04(String cliPc04) {
		this.cliPc04 = cliPc04;
	}
	public String getCliPc04() {
		return cliPc04;
	}
	public void setCliPc05(String cliPc05) {
		this.cliPc05 = cliPc05;
	}
	public String getCliPc05() {
		return cliPc05;
	}
	public void setCliPc06(String cliPc06) {
		this.cliPc06 = cliPc06;
	}
	public String getCliPc06() {
		return cliPc06;
	}
	public void setCliPrtrcp(String cliPrtrcp) {
		this.cliPrtrcp = cliPrtrcp;
	}
	public String getCliPrtrcp() {
		return cliPrtrcp;
	}
	public void setCliStmntby(String cliStmntby) {
		this.cliStmntby = cliStmntby;
	}
	public String getCliStmntby() {
		return cliStmntby;
	}
	public void setCliStmntfmt(String cliStmntfmt) {
		this.cliStmntfmt = cliStmntfmt;
	}
	public String getCliStmntfmt() {
		return cliStmntfmt;
	}
	public void setCliShownet(String cliShownet) {
		this.cliShownet = cliShownet;
	}
	public String getCliShownet() {
		return cliShownet;
	}
	public void setCliMbrof(String cliMbrof) {
		this.cliMbrof = cliMbrof;
	}
	public String getCliMbrof() {
		return cliMbrof;
	}
	public void setCliSameas(String cliSameas) {
		this.cliSameas = cliSameas;
	}
	public String getCliSameas() {
		return cliSameas;
	}
	public void setCliOpolisr(String cliOpolisr) {
		this.cliOpolisr = cliOpolisr;
	}
	public String getCliOpolisr() {
		return cliOpolisr;
	}
	public void setCliOpolcls(String cliOpolcls) {
		this.cliOpolcls = cliOpolcls;
	}
	public String getCliOpolcls() {
		return cliOpolcls;
	}
	public void setCliNote9(Object cliNote9) {
		this.cliNote9 = cliNote9;
	}
	public Object getCliNote9() {
		return cliNote9;
	}
	public void setCliSkiprcp(String cliSkiprcp) {
		this.cliSkiprcp = cliSkiprcp;
	}
	public String getCliSkiprcp() {
		return cliSkiprcp;
	}
	public void setCliEndreg(java.util.Date cliEndreg) {
		this.cliEndreg = cliEndreg;
	}
	public java.util.Date getCliEndreg() {
		return cliEndreg;
	}
	public void setXRenew(String xRenew) {
		this.xRenew = xRenew;
	}
	public String getXRenew() {
		return xRenew;
	}
	public void setCliRmkkey1(Long cliRmkkey1) {
		this.cliRmkkey1 = cliRmkkey1;
	}
	public Long getCliRmkkey1() {
		return cliRmkkey1;
	}
	public void setCliAgtlock(String cliAgtlock) {
		this.cliAgtlock = cliAgtlock;
	}
	public String getCliAgtlock() {
		return cliAgtlock;
	}
	public void setCliSrcgrp(String cliSrcgrp) {
		this.cliSrcgrp = cliSrcgrp;
	}
	public String getCliSrcgrp() {
		return cliSrcgrp;
	}
	public void setCliMlock2(String cliMlock2) {
		this.cliMlock2 = cliMlock2;
	}
	public String getCliMlock2() {
		return cliMlock2;
	}
	public void setCliMlockdt2(java.util.Date cliMlockdt2) {
		this.cliMlockdt2 = cliMlockdt2;
	}
	public java.util.Date getCliMlockdt2() {
		return cliMlockdt2;
	}
	public void setCliMlockrmk2(Object cliMlockrmk2) {
		this.cliMlockrmk2 = cliMlockrmk2;
	}
	public Object getCliMlockrmk2() {
		return cliMlockrmk2;
	}
	public void setCliIsspol2(String cliIsspol2) {
		this.cliIsspol2 = cliIsspol2;
	}
	public String getCliIsspol2() {
		return cliIsspol2;
	}
	public void setCliCodfr(java.util.Date cliCodfr) {
		this.cliCodfr = cliCodfr;
	}
	public java.util.Date getCliCodfr() {
		return cliCodfr;
	}
	public void setCliCodto(java.util.Date cliCodto) {
		this.cliCodto = cliCodto;
	}
	public java.util.Date getCliCodto() {
		return cliCodto;
	}
	public void setCliCodfr2(java.util.Date cliCodfr2) {
		this.cliCodfr2 = cliCodfr2;
	}
	public java.util.Date getCliCodfr2() {
		return cliCodfr2;
	}
	public void setCliCodto2(java.util.Date cliCodto2) {
		this.cliCodto2 = cliCodto2;
	}
	public java.util.Date getCliCodto2() {
		return cliCodto2;
	}
	public void setCliEndreg02(java.util.Date cliEndreg02) {
		this.cliEndreg02 = cliEndreg02;
	}
	public java.util.Date getCliEndreg02() {
		return cliEndreg02;
	}
	public void setCliQli(String cliQli) {
		this.cliQli = cliQli;
	}
	public String getCliQli() {
		return cliQli;
	}
	public void setCliRegno01(String cliRegno01) {
		this.cliRegno01 = cliRegno01;
	}
	public String getCliRegno01() {
		return cliRegno01;
	}
	public void setCliRegno02(String cliRegno02) {
		this.cliRegno02 = cliRegno02;
	}
	public String getCliRegno02() {
		return cliRegno02;
	}
	public void setCliRegtype(String cliRegtype) {
		this.cliRegtype = cliRegtype;
	}
	public String getCliRegtype() {
		return cliRegtype;
	}
	public void setCliSrcregno(String cliSrcregno) {
		this.cliSrcregno = cliSrcregno;
	}
	public String getCliSrcregno() {
		return cliSrcregno;
	}
	public void setCliSrctype(String cliSrctype) {
		this.cliSrctype = cliSrctype;
	}
	public String getCliSrctype() {
		return cliSrctype;
	}
	public void setCliStartreg(java.util.Date cliStartreg) {
		this.cliStartreg = cliStartreg;
	}
	public java.util.Date getCliStartreg() {
		return cliStartreg;
	}
	public void setCliStartreg02(java.util.Date cliStartreg02) {
		this.cliStartreg02 = cliStartreg02;
	}
	public java.util.Date getCliStartreg02() {
		return cliStartreg02;
	}
	public void setCliGroup1(String cliGroup1) {
		this.cliGroup1 = cliGroup1;
	}
	public String getCliGroup1() {
		return cliGroup1;
	}
	public void setCliGroup2(String cliGroup2) {
		this.cliGroup2 = cliGroup2;
	}
	public String getCliGroup2() {
		return cliGroup2;
	}
	public void setCliGroup3(String cliGroup3) {
		this.cliGroup3 = cliGroup3;
	}
	public String getCliGroup3() {
		return cliGroup3;
	}
	public void setCliBankagt(String cliBankagt) {
		this.cliBankagt = cliBankagt;
	}
	public String getCliBankagt() {
		return cliBankagt;
	}
	public void setCliRndgDn(String cliRndgDn) {
		this.cliRndgDn = cliRndgDn;
	}
	public String getCliRndgDn() {
		return cliRndgDn;
	}
	public void setCliLoginid(String cliLoginid) {
		this.cliLoginid = cliLoginid;
	}
	public String getCliLoginid() {
		return cliLoginid;
	}
	public void setCliSyncprofiledate(java.util.Date cliSyncprofiledate) {
		this.cliSyncprofiledate = cliSyncprofiledate;
	}
	public java.util.Date getCliSyncprofiledate() {
		return cliSyncprofiledate;
	}
	public void setCliIagstatus(String cliIagstatus) {
		this.cliIagstatus = cliIagstatus;
	}
	public String getCliIagstatus() {
		return cliIagstatus;
	}
	public void setCliResyncflag(String cliResyncflag) {
		this.cliResyncflag = cliResyncflag;
	}
	public String getCliResyncflag() {
		return cliResyncflag;
	}
  
	private static final String Table = "clifl";
	private static final String Alias = "as_clifl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCliCode = Alias+".cli_code";
	public static final String DBStrCliLname = Alias+".cli_lname";
	public static final String DBStrCliSname = Alias+".cli_sname";
	public static final String DBStrCliAddr1 = Alias+".cli_addr1";
	public static final String DBStrCliAddr2 = Alias+".cli_addr2";
	public static final String DBStrCliAddr3 = Alias+".cli_addr3";
	public static final String DBStrCliAddr4 = Alias+".cli_addr4";
	public static final String DBStrCliCty = Alias+".cli_cty";
	public static final String DBStrCliZip = Alias+".cli_zip";
	public static final String DBStrCliType = Alias+".cli_type";
	public static final String DBStrCliGroup = Alias+".cli_group";
	public static final String DBStrCliTelidd = Alias+".cli_telidd";
	public static final String DBStrCliTel = Alias+".cli_tel";
	public static final String DBStrCliFaxidd = Alias+".cli_faxidd";
	public static final String DBStrCliFax = Alias+".cli_fax";
	public static final String DBStrCliTlxidd = Alias+".cli_tlxidd";
	public static final String DBStrCliTlx = Alias+".cli_tlx";
	public static final String DBStrCliEmail = Alias+".cli_email";
	public static final String DBStrCliBank = Alias+".cli_bank";
	public static final String DBStrCliAtnac = Alias+".cli_atnac";
	public static final String DBStrCliAtnclm = Alias+".cli_atnclm";
	public static final String DBStrCliAtnuw = Alias+".cli_atnuw";
	public static final String DBStrCliAtnfac = Alias+".cli_atnfac";
	public static final String DBStrCliAtntty = Alias+".cli_atntty";
	public static final String DBStrCliCapccy = Alias+".cli_capccy";
	public static final String DBStrCliCapamt = Alias+".cli_capamt";
	public static final String DBStrCliNote = Alias+".cli_note";
	public static final String DBStrCliSt = Alias+".cli_st";
	public static final String DBStrCliOffice = Alias+".cli_office";
	public static final String DBStrCliStaff = Alias+".cli_staff";
	public static final String DBStrCliCdate = Alias+".cli_cdate";
	public static final String DBStrCliAdate = Alias+".cli_adate";
	public static final String DBStrCliCuser = Alias+".cli_cuser";
	public static final String DBStrCliAuser = Alias+".cli_auser";
	public static final String DBStrCliLock = Alias+".cli_lock";
	public static final String DBStrCliAr = Alias+".cli_ar";
	public static final String DBStrCliCrdays = Alias+".cli_crdays";
	public static final String DBStrCliJoinsts = Alias+".cli_joinsts";
	public static final String DBStrCliJoindate = Alias+".cli_joindate";
	public static final String DBStrCliRplcby = Alias+".cli_rplcby";
	public static final String DBStrCliStdate = Alias+".cli_stdate";
	public static final String DBStrCliPIdcard = Alias+".cli_p_idcard";
	public static final String DBStrCliPBirth = Alias+".cli_p_birth";
	public static final String DBStrCliPSex = Alias+".cli_p_sex";
	public static final String DBStrCliNote1 = Alias+".cli_note1";
	public static final String DBStrCliAgent = Alias+".cli_agent";
	public static final String DBStrCliUnit = Alias+".cli_unit";
	public static final String DBStrCliCli = Alias+".cli_cli";
	public static final String DBStrCliNat = Alias+".cli_nat";
	public static final String DBStrCliTaxfile = Alias+".cli_taxfile";
	public static final String DBStrCliRegno = Alias+".cli_regno";
	public static final String DBStrCliNum = Alias+".cli_num";
	public static final String DBStrCliArea = Alias+".cli_area";
	public static final String DBStrCliBnk = Alias+".cli_bnk";
	public static final String DBStrCliBrn = Alias+".cli_brn";
	public static final String DBStrCliBankac = Alias+".cli_bankac";
	public static final String DBStrCliLic = Alias+".cli_lic";
	public static final String DBStrCliMar = Alias+".cli_mar";
	public static final String DBStrCliDbtnm = Alias+".cli_dbtnm";
	public static final String DBStrCliResidd = Alias+".cli_residd";
	public static final String DBStrCliRestel = Alias+".cli_restel";
	public static final String DBStrCliMobidd = Alias+".cli_mobidd";
	public static final String DBStrCliMobtel = Alias+".cli_mobtel";
	public static final String DBStrCliCname = Alias+".cli_cname";
	public static final String DBStrCliMlock = Alias+".cli_mlock";
	public static final String DBStrCliMlockdt = Alias+".cli_mlockdt";
	public static final String DBStrCliMlockrmk = Alias+".cli_mlockrmk";
	public static final String DBStrCliOsysdt = Alias+".cli_osysdt";
	public static final String DBStrCliOday = Alias+".cli_oday";
	public static final String DBStrCliOuptot = Alias+".cli_ouptot";
	public static final String DBStrCliOby = Alias+".cli_oby";
	public static final String DBStrCliOrmk = Alias+".cli_ormk";
	public static final String DBStrCliDismgr = Alias+".cli_dismgr";
	public static final String DBStrCliSuper = Alias+".cli_super";
	public static final String DBStrCliCtdt = Alias+".cli_ctdt";
	public static final String DBStrCliCtby = Alias+".cli_ctby";
	public static final String DBStrCliCtgrcdt = Alias+".cli_ctgrcdt";
	public static final String DBStrCliCtgrcrmk = Alias+".cli_ctgrcrmk";
	public static final String DBStrCliSoamp = Alias+".cli_soamp";
	public static final String DBStrCliSoaskip = Alias+".cli_soaskip";
	public static final String DBStrCliSkiplock = Alias+".cli_skiplock";
	public static final String DBStrCliRenappdt = Alias+".cli_renappdt";
	public static final String DBStrCliAchandle = Alias+".cli_achandle";
	public static final String DBStrCliPager = Alias+".cli_pager";
	public static final String DBStrCliStrmk = Alias+".cli_strmk";
	public static final String DBStrCliGuar = Alias+".cli_guar";
	public static final String DBStrCliAddr9 = Alias+".cli_addr9";
	public static final String DBStrCliSaddr1 = Alias+".cli_saddr1";
	public static final String DBStrCliSaddr2 = Alias+".cli_saddr2";
	public static final String DBStrCliSaddr3 = Alias+".cli_saddr3";
	public static final String DBStrCliSaddr9 = Alias+".cli_saddr9";
	public static final String DBStrCliRsr1 = Alias+".cli_rsr1";
	public static final String DBStrCliRsr2 = Alias+".cli_rsr2";
	public static final String DBStrCliLicense = Alias+".cli_license";
	public static final String DBStrCliLictxt = Alias+".cli_lictxt";
	public static final String DBStrCliIntroby = Alias+".cli_introby";
	public static final String DBStrCliAlwteam = Alias+".cli_alwteam";
	public static final String DBStrCliLocksts = Alias+".cli_locksts";
	public static final String DBStrCliForagt = Alias+".cli_foragt";
	public static final String DBStrCliRmkkey = Alias+".cli_rmkkey";
	public static final String DBStrCliSrc = Alias+".cli_src";
	public static final String DBStrCliOccup = Alias+".cli_occup";
	public static final String DBStrCliComm2main = Alias+".cli_comm2main";
	public static final String DBStrCliMainagt = Alias+".cli_mainagt";
	public static final String DBStrCliPIdtype = Alias+".cli_p_idtype";
	public static final String DBStrCliDiv = Alias+".cli_div";
	public static final String DBStrCliTermdt = Alias+".cli_termdt";
	public static final String DBStrCliLoc1 = Alias+".cli_loc1";
	public static final String DBStrCliLoc2 = Alias+".cli_loc2";
	public static final String DBStrCliBirthplace = Alias+".cli_birthplace";
	public static final String DBStrCliStdname = Alias+".cli_stdname";
	public static final String DBStrCliNicknm = Alias+".cli_nicknm";
	public static final String DBStrCliOthnm = Alias+".cli_othnm";
	public static final String DBStrCliFirstnm = Alias+".cli_firstnm";
	public static final String DBStrCliSurnm = Alias+".cli_surnm";
	public static final String DBStrCliNeedizufee = Alias+".cli_needizufee";
	public static final String DBStrCliDept = Alias+".cli_dept";
	public static final String DBStrCliOpolcnt = Alias+".cli_opolcnt";
	public static final String DBStrCliXref = Alias+".cli_xref";
	public static final String DBStrCliAppno = Alias+".cli_appno";
	public static final String DBStrCliAdjno = Alias+".cli_adjno";
	public static final String DBStrCliPaymthd = Alias+".cli_paymthd";
	public static final String DBStrCliCommgrp = Alias+".cli_commgrp";
	public static final String DBStrCliStdcommgrp = Alias+".cli_stdcommgrp";
	public static final String DBStrCliIsspol = Alias+".cli_isspol";
	public static final String DBStrCliIsscomm = Alias+".cli_isscomm";
	public static final String DBStrCliAlwagt = Alias+".cli_alwagt";
	public static final String DBStrCliCommgrp01 = Alias+".cli_commgrp01";
	public static final String DBStrCliRelation = Alias+".cli_relation";
	public static final String DBStrCliMustizufee = Alias+".cli_mustizufee";
	public static final String DBStrCliForres = Alias+".cli_forres";
	public static final String DBStrCliDeductrate = Alias+".cli_deductrate";
	public static final String DBStrCliPc01 = Alias+".cli_pc01";
	public static final String DBStrCliPc02 = Alias+".cli_pc02";
	public static final String DBStrCliPc03 = Alias+".cli_pc03";
	public static final String DBStrCliPc04 = Alias+".cli_pc04";
	public static final String DBStrCliPc05 = Alias+".cli_pc05";
	public static final String DBStrCliPc06 = Alias+".cli_pc06";
	public static final String DBStrCliPrtrcp = Alias+".cli_prtrcp";
	public static final String DBStrCliStmntby = Alias+".cli_stmntby";
	public static final String DBStrCliStmntfmt = Alias+".cli_stmntfmt";
	public static final String DBStrCliShownet = Alias+".cli_shownet";
	public static final String DBStrCliMbrof = Alias+".cli_mbrof";
	public static final String DBStrCliSameas = Alias+".cli_sameas";
	public static final String DBStrCliOpolisr = Alias+".cli_opolisr";
	public static final String DBStrCliOpolcls = Alias+".cli_opolcls";
	public static final String DBStrCliNote9 = Alias+".cli_note9";
	public static final String DBStrCliSkiprcp = Alias+".cli_skiprcp";
	public static final String DBStrCliEndreg = Alias+".cli_endreg";
	public static final String DBStrXRenew = Alias+".x_renew";
	public static final String DBStrCliRmkkey1 = Alias+".cli_rmkkey1";
	public static final String DBStrCliAgtlock = Alias+".cli_agtlock";
	public static final String DBStrCliSrcgrp = Alias+".cli_srcgrp";
	public static final String DBStrCliMlock2 = Alias+".cli_mlock_2";
	public static final String DBStrCliMlockdt2 = Alias+".cli_mlockdt_2";
	public static final String DBStrCliMlockrmk2 = Alias+".cli_mlockrmk_2";
	public static final String DBStrCliIsspol2 = Alias+".cli_isspol_2";
	public static final String DBStrCliCodfr = Alias+".cli_codfr";
	public static final String DBStrCliCodto = Alias+".cli_codto";
	public static final String DBStrCliCodfr2 = Alias+".cli_codfr_2";
	public static final String DBStrCliCodto2 = Alias+".cli_codto_2";
	public static final String DBStrCliEndreg02 = Alias+".cli_endreg02";
	public static final String DBStrCliQli = Alias+".cli_qli";
	public static final String DBStrCliRegno01 = Alias+".cli_regno01";
	public static final String DBStrCliRegno02 = Alias+".cli_regno02";
	public static final String DBStrCliRegtype = Alias+".cli_regtype";
	public static final String DBStrCliSrcregno = Alias+".cli_srcregno";
	public static final String DBStrCliSrctype = Alias+".cli_srctype";
	public static final String DBStrCliStartreg = Alias+".cli_startreg";
	public static final String DBStrCliStartreg02 = Alias+".cli_startreg02";
	public static final String DBStrCliGroup1 = Alias+".cli_group1";
	public static final String DBStrCliGroup2 = Alias+".cli_group2";
	public static final String DBStrCliGroup3 = Alias+".cli_group3";
	public static final String DBStrCliBankagt = Alias+".cli_bankagt";
	public static final String DBStrCliRndgDn = Alias+".cli_rndg_dn";
	public static final String DBStrCliLoginid = Alias+".cli_loginid";
	public static final String DBStrCliSyncprofiledate = Alias+".cli_syncprofiledate";
	public static final String DBStrCliIagstatus = Alias+".cli_iagstatus";
	public static final String DBStrCliResyncflag = Alias+".cli_resyncflag";
	
	@Override
	public Clifl clone() {
		Clifl o = null;
		try{
			o = (Clifl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

