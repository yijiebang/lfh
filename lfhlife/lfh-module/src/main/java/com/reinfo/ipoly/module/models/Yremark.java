package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Yremark implements Serializable, Cloneable {
	private Long rmkkey;
	private String rmk;
	private String tbl;
	private String col;
	private String tblkey;
	private String obj;
	private java.util.Date crtdat;
	private java.util.Date chgdat;
	private String crtusr;
	private String chgusr;
	private Long updcnt;
	private String dltcode;

	public void setRmkkey(Long rmkkey) {
		this.rmkkey = rmkkey;
	}
	public Long getRmkkey() {
		return rmkkey;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public String getRmk() {
		return rmk;
	}
	public void setTbl(String tbl) {
		this.tbl = tbl;
	}
	public String getTbl() {
		return tbl;
	}
	public void setCol(String col) {
		this.col = col;
	}
	public String getCol() {
		return col;
	}
	public void setTblkey(String tblkey) {
		this.tblkey = tblkey;
	}
	public String getTblkey() {
		return tblkey;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public String getObj() {
		return obj;
	}
	public void setCrtdat(java.util.Date crtdat) {
		this.crtdat = crtdat;
	}
	public java.util.Date getCrtdat() {
		return crtdat;
	}
	public void setChgdat(java.util.Date chgdat) {
		this.chgdat = chgdat;
	}
	public java.util.Date getChgdat() {
		return chgdat;
	}
	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr;
	}
	public String getCrtusr() {
		return crtusr;
	}
	public void setChgusr(String chgusr) {
		this.chgusr = chgusr;
	}
	public String getChgusr() {
		return chgusr;
	}
	public void setUpdcnt(Long updcnt) {
		this.updcnt = updcnt;
	}
	public Long getUpdcnt() {
		return updcnt;
	}
	public void setDltcode(String dltcode) {
		this.dltcode = dltcode;
	}
	public String getDltcode() {
		return dltcode;
	}
  
	private static final String Table = "yremark";
	private static final String Alias = "as_yremark";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrRmkkey = Alias+".rmkkey";
	public static final String DBStrRmk = Alias+".rmk";
	public static final String DBStrTbl = Alias+".tbl";
	public static final String DBStrCol = Alias+".col";
	public static final String DBStrTblkey = Alias+".tblkey";
	public static final String DBStrObj = Alias+".obj";
	public static final String DBStrCrtdat = Alias+".crtdat";
	public static final String DBStrChgdat = Alias+".chgdat";
	public static final String DBStrCrtusr = Alias+".crtusr";
	public static final String DBStrChgusr = Alias+".chgusr";
	public static final String DBStrUpdcnt = Alias+".updcnt";
	public static final String DBStrDltcode = Alias+".dltcode";
	
	@Override
	public Yremark clone() {
		Yremark o = null;
		try{
			o = (Yremark)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

