package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Clcfl implements Serializable, Cloneable {
	private String clcCode;
	private Long clcSeq;
	private String clcCls;
	private java.math.BigDecimal clcOcom;
	private java.util.Date clcEff;
	private java.util.Date clcExp;
	private java.util.Date clcCdate;
	private java.util.Date clcAdate;
	private String clcCuser;
	private String clcAuser;
	private Long clcLock;
	private Integer clcAgtcom;
	private java.math.BigDecimal clcClidisc;
	private String clcCcy;
	private java.math.BigDecimal clcMinprm;
	private String clcIntro;
	private java.math.BigDecimal clcIntrocom;

	public void setClcCode(String clcCode) {
		this.clcCode = clcCode;
	}
	public String getClcCode() {
		return clcCode;
	}
	public void setClcSeq(Long clcSeq) {
		this.clcSeq = clcSeq;
	}
	public Long getClcSeq() {
		return clcSeq;
	}
	public void setClcCls(String clcCls) {
		this.clcCls = clcCls;
	}
	public String getClcCls() {
		return clcCls;
	}
	public void setClcOcom(java.math.BigDecimal clcOcom) {
		this.clcOcom = clcOcom;
	}
	public java.math.BigDecimal getClcOcom() {
		return clcOcom;
	}
	public void setClcEff(java.util.Date clcEff) {
		this.clcEff = clcEff;
	}
	public java.util.Date getClcEff() {
		return clcEff;
	}
	public void setClcExp(java.util.Date clcExp) {
		this.clcExp = clcExp;
	}
	public java.util.Date getClcExp() {
		return clcExp;
	}
	public void setClcCdate(java.util.Date clcCdate) {
		this.clcCdate = clcCdate;
	}
	public java.util.Date getClcCdate() {
		return clcCdate;
	}
	public void setClcAdate(java.util.Date clcAdate) {
		this.clcAdate = clcAdate;
	}
	public java.util.Date getClcAdate() {
		return clcAdate;
	}
	public void setClcCuser(String clcCuser) {
		this.clcCuser = clcCuser;
	}
	public String getClcCuser() {
		return clcCuser;
	}
	public void setClcAuser(String clcAuser) {
		this.clcAuser = clcAuser;
	}
	public String getClcAuser() {
		return clcAuser;
	}
	public void setClcLock(Long clcLock) {
		this.clcLock = clcLock;
	}
	public Long getClcLock() {
		return clcLock;
	}
	public void setClcAgtcom(Integer clcAgtcom) {
		this.clcAgtcom = clcAgtcom;
	}
	public Integer getClcAgtcom() {
		return clcAgtcom;
	}
	public void setClcClidisc(java.math.BigDecimal clcClidisc) {
		this.clcClidisc = clcClidisc;
	}
	public java.math.BigDecimal getClcClidisc() {
		return clcClidisc;
	}
	public void setClcCcy(String clcCcy) {
		this.clcCcy = clcCcy;
	}
	public String getClcCcy() {
		return clcCcy;
	}
	public void setClcMinprm(java.math.BigDecimal clcMinprm) {
		this.clcMinprm = clcMinprm;
	}
	public java.math.BigDecimal getClcMinprm() {
		return clcMinprm;
	}
	public void setClcIntro(String clcIntro) {
		this.clcIntro = clcIntro;
	}
	public String getClcIntro() {
		return clcIntro;
	}
	public void setClcIntrocom(java.math.BigDecimal clcIntrocom) {
		this.clcIntrocom = clcIntrocom;
	}
	public java.math.BigDecimal getClcIntrocom() {
		return clcIntrocom;
	}
  
	private static final String Table = "clcfl";
	private static final String Alias = "as_clcfl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrClcCode = Alias+".clc_code";
	public static final String DBStrClcSeq = Alias+".clc_seq";
	public static final String DBStrClcCls = Alias+".clc_cls";
	public static final String DBStrClcOcom = Alias+".clc_ocom";
	public static final String DBStrClcEff = Alias+".clc_eff";
	public static final String DBStrClcExp = Alias+".clc_exp";
	public static final String DBStrClcCdate = Alias+".clc_cdate";
	public static final String DBStrClcAdate = Alias+".clc_adate";
	public static final String DBStrClcCuser = Alias+".clc_cuser";
	public static final String DBStrClcAuser = Alias+".clc_auser";
	public static final String DBStrClcLock = Alias+".clc_lock";
	public static final String DBStrClcAgtcom = Alias+".clc_agtcom";
	public static final String DBStrClcClidisc = Alias+".clc_clidisc";
	public static final String DBStrClcCcy = Alias+".clc_ccy";
	public static final String DBStrClcMinprm = Alias+".clc_minprm";
	public static final String DBStrClcIntro = Alias+".clc_intro";
	public static final String DBStrClcIntrocom = Alias+".clc_introcom";
	
	@Override
	public Clcfl clone() {
		Clcfl o = null;
		try{
			o = (Clcfl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

