package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Clgfl implements Serializable, Cloneable {
	private String clgCode;
	private Long clgSeq;
	private String clgAgt;

	public void setClgCode(String clgCode) {
		this.clgCode = clgCode;
	}
	public String getClgCode() {
		return clgCode;
	}
	public void setClgSeq(Long clgSeq) {
		this.clgSeq = clgSeq;
	}
	public Long getClgSeq() {
		return clgSeq;
	}
	public void setClgAgt(String clgAgt) {
		this.clgAgt = clgAgt;
	}
	public String getClgAgt() {
		return clgAgt;
	}
  
	private static final String Table = "clgfl";
	private static final String Alias = "as_clgfl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrClgCode = Alias+".clg_code";
	public static final String DBStrClgSeq = Alias+".clg_seq";
	public static final String DBStrClgAgt = Alias+".clg_agt";
	
	@Override
	public Clgfl clone() {
		Clgfl o = null;
		try{
			o = (Clgfl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

