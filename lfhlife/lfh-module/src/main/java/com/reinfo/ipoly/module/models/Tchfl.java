package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Tchfl implements Serializable, Cloneable {
	private String tchId;
	private String tchCode;
	private Object tchDspval;
	private String tchParm1;
	private Object tchDspval1;
	private Object tchDspval2;
	private java.math.BigDecimal tchAmt1;
	private java.math.BigDecimal tchAmt2;
	private java.math.BigDecimal tchAmt3;
	private java.math.BigDecimal tchAmt4;
	private java.math.BigDecimal tchAmt5;
	private java.util.Date tchDt1;
	private java.util.Date tchDt2;
	private java.util.Date tchDt3;
	private java.util.Date tchDt4;
	private java.util.Date tchDt5;
	private java.math.BigDecimal tchChr1;
	private java.math.BigDecimal tchChr2;
	private java.math.BigDecimal tchChr3;
	private java.math.BigDecimal tchChr4;
	private java.math.BigDecimal tchChr5;

	public void setTchId(String tchId) {
		this.tchId = tchId;
	}
	public String getTchId() {
		return tchId;
	}
	public void setTchCode(String tchCode) {
		this.tchCode = tchCode;
	}
	public String getTchCode() {
		return tchCode;
	}
	public void setTchDspval(Object tchDspval) {
		this.tchDspval = tchDspval;
	}
	public Object getTchDspval() {
		return tchDspval;
	}
	public void setTchParm1(String tchParm1) {
		this.tchParm1 = tchParm1;
	}
	public String getTchParm1() {
		return tchParm1;
	}
	public void setTchDspval1(Object tchDspval1) {
		this.tchDspval1 = tchDspval1;
	}
	public Object getTchDspval1() {
		return tchDspval1;
	}
	public void setTchDspval2(Object tchDspval2) {
		this.tchDspval2 = tchDspval2;
	}
	public Object getTchDspval2() {
		return tchDspval2;
	}
	public void setTchAmt1(java.math.BigDecimal tchAmt1) {
		this.tchAmt1 = tchAmt1;
	}
	public java.math.BigDecimal getTchAmt1() {
		return tchAmt1;
	}
	public void setTchAmt2(java.math.BigDecimal tchAmt2) {
		this.tchAmt2 = tchAmt2;
	}
	public java.math.BigDecimal getTchAmt2() {
		return tchAmt2;
	}
	public void setTchAmt3(java.math.BigDecimal tchAmt3) {
		this.tchAmt3 = tchAmt3;
	}
	public java.math.BigDecimal getTchAmt3() {
		return tchAmt3;
	}
	public void setTchAmt4(java.math.BigDecimal tchAmt4) {
		this.tchAmt4 = tchAmt4;
	}
	public java.math.BigDecimal getTchAmt4() {
		return tchAmt4;
	}
	public void setTchAmt5(java.math.BigDecimal tchAmt5) {
		this.tchAmt5 = tchAmt5;
	}
	public java.math.BigDecimal getTchAmt5() {
		return tchAmt5;
	}
	public void setTchDt1(java.util.Date tchDt1) {
		this.tchDt1 = tchDt1;
	}
	public java.util.Date getTchDt1() {
		return tchDt1;
	}
	public void setTchDt2(java.util.Date tchDt2) {
		this.tchDt2 = tchDt2;
	}
	public java.util.Date getTchDt2() {
		return tchDt2;
	}
	public void setTchDt3(java.util.Date tchDt3) {
		this.tchDt3 = tchDt3;
	}
	public java.util.Date getTchDt3() {
		return tchDt3;
	}
	public void setTchDt4(java.util.Date tchDt4) {
		this.tchDt4 = tchDt4;
	}
	public java.util.Date getTchDt4() {
		return tchDt4;
	}
	public void setTchDt5(java.util.Date tchDt5) {
		this.tchDt5 = tchDt5;
	}
	public java.util.Date getTchDt5() {
		return tchDt5;
	}
	public void setTchChr1(java.math.BigDecimal tchChr1) {
		this.tchChr1 = tchChr1;
	}
	public java.math.BigDecimal getTchChr1() {
		return tchChr1;
	}
	public void setTchChr2(java.math.BigDecimal tchChr2) {
		this.tchChr2 = tchChr2;
	}
	public java.math.BigDecimal getTchChr2() {
		return tchChr2;
	}
	public void setTchChr3(java.math.BigDecimal tchChr3) {
		this.tchChr3 = tchChr3;
	}
	public java.math.BigDecimal getTchChr3() {
		return tchChr3;
	}
	public void setTchChr4(java.math.BigDecimal tchChr4) {
		this.tchChr4 = tchChr4;
	}
	public java.math.BigDecimal getTchChr4() {
		return tchChr4;
	}
	public void setTchChr5(java.math.BigDecimal tchChr5) {
		this.tchChr5 = tchChr5;
	}
	public java.math.BigDecimal getTchChr5() {
		return tchChr5;
	}
  
	private static final String Table = "tchfl";
	private static final String Alias = "as_tchfl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrTchId = Alias+".tch_id";
	public static final String DBStrTchCode = Alias+".tch_code";
	public static final String DBStrTchDspval = Alias+".tch_dspval";
	public static final String DBStrTchParm1 = Alias+".tch_parm1";
	public static final String DBStrTchDspval1 = Alias+".tch_dspval1";
	public static final String DBStrTchDspval2 = Alias+".tch_dspval2";
	public static final String DBStrTchAmt1 = Alias+".tch_amt1";
	public static final String DBStrTchAmt2 = Alias+".tch_amt2";
	public static final String DBStrTchAmt3 = Alias+".tch_amt3";
	public static final String DBStrTchAmt4 = Alias+".tch_amt4";
	public static final String DBStrTchAmt5 = Alias+".tch_amt5";
	public static final String DBStrTchDt1 = Alias+".tch_dt1";
	public static final String DBStrTchDt2 = Alias+".tch_dt2";
	public static final String DBStrTchDt3 = Alias+".tch_dt3";
	public static final String DBStrTchDt4 = Alias+".tch_dt4";
	public static final String DBStrTchDt5 = Alias+".tch_dt5";
	public static final String DBStrTchChr1 = Alias+".tch_chr1";
	public static final String DBStrTchChr2 = Alias+".tch_chr2";
	public static final String DBStrTchChr3 = Alias+".tch_chr3";
	public static final String DBStrTchChr4 = Alias+".tch_chr4";
	public static final String DBStrTchChr5 = Alias+".tch_chr5";
	
	@Override
	public Tchfl clone() {
		Tchfl o = null;
		try{
			o = (Tchfl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

