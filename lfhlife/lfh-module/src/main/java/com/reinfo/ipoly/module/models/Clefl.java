package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Clefl implements Serializable, Cloneable {
	private String cleCode;
	private Object cleName;
	private String cleNat;
	private String cleBeused;

	public void setCleCode(String cleCode) {
		this.cleCode = cleCode;
	}
	public String getCleCode() {
		return cleCode;
	}
	public void setCleName(Object cleName) {
		this.cleName = cleName;
	}
	public Object getCleName() {
		return cleName;
	}
	public void setCleNat(String cleNat) {
		this.cleNat = cleNat;
	}
	public String getCleNat() {
		return cleNat;
	}
	public void setCleBeused(String cleBeused) {
		this.cleBeused = cleBeused;
	}
	public String getCleBeused() {
		return cleBeused;
	}
  
	private static final String Table = "clefl";
	private static final String Alias = "as_clefl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrCleCode = Alias+".cle_code";
	public static final String DBStrCleName = Alias+".cle_name";
	public static final String DBStrCleNat = Alias+".cle_nat";
	public static final String DBStrCleBeused = Alias+".cle_beused";
	
	@Override
	public Clefl clone() {
		Clefl o = null;
		try{
			o = (Clefl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

