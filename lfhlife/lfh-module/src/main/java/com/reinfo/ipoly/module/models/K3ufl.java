package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class K3ufl implements Serializable, Cloneable {
	private String k3uCliCode;
	private Long k3uSeq;
	private String k3uStatType;
	private String k3uCuser;
	private java.util.Date k3uCdate;
	private String k3uAuser;
	private java.util.Date k3uAdate;
	private Long k3uLock;
	private Long k3uSeqUser;
	private String k3uInternal;

	public void setK3uCliCode(String k3uCliCode) {
		this.k3uCliCode = k3uCliCode;
	}
	public String getK3uCliCode() {
		return k3uCliCode;
	}
	public void setK3uSeq(Long k3uSeq) {
		this.k3uSeq = k3uSeq;
	}
	public Long getK3uSeq() {
		return k3uSeq;
	}
	public void setK3uStatType(String k3uStatType) {
		this.k3uStatType = k3uStatType;
	}
	public String getK3uStatType() {
		return k3uStatType;
	}
	public void setK3uCuser(String k3uCuser) {
		this.k3uCuser = k3uCuser;
	}
	public String getK3uCuser() {
		return k3uCuser;
	}
	public void setK3uCdate(java.util.Date k3uCdate) {
		this.k3uCdate = k3uCdate;
	}
	public java.util.Date getK3uCdate() {
		return k3uCdate;
	}
	public void setK3uAuser(String k3uAuser) {
		this.k3uAuser = k3uAuser;
	}
	public String getK3uAuser() {
		return k3uAuser;
	}
	public void setK3uAdate(java.util.Date k3uAdate) {
		this.k3uAdate = k3uAdate;
	}
	public java.util.Date getK3uAdate() {
		return k3uAdate;
	}
	public void setK3uLock(Long k3uLock) {
		this.k3uLock = k3uLock;
	}
	public Long getK3uLock() {
		return k3uLock;
	}
	public void setK3uSeqUser(Long k3uSeqUser) {
		this.k3uSeqUser = k3uSeqUser;
	}
	public Long getK3uSeqUser() {
		return k3uSeqUser;
	}
	public void setK3uInternal(String k3uInternal) {
		this.k3uInternal = k3uInternal;
	}
	public String getK3uInternal() {
		return k3uInternal;
	}
  
	private static final String Table = "k3ufl";
	private static final String Alias = "as_k3ufl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrK3uCliCode = Alias+".k3u_cli_code";
	public static final String DBStrK3uSeq = Alias+".k3u_seq";
	public static final String DBStrK3uStatType = Alias+".k3u_stat_type";
	public static final String DBStrK3uCuser = Alias+".k3u_cuser";
	public static final String DBStrK3uCdate = Alias+".k3u_cdate";
	public static final String DBStrK3uAuser = Alias+".k3u_auser";
	public static final String DBStrK3uAdate = Alias+".k3u_adate";
	public static final String DBStrK3uLock = Alias+".k3u_lock";
	public static final String DBStrK3uSeqUser = Alias+".k3u_seq_user";
	public static final String DBStrK3uInternal = Alias+".k3u_internal";
	
	@Override
	public K3ufl clone() {
		K3ufl o = null;
		try{
			o = (K3ufl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

