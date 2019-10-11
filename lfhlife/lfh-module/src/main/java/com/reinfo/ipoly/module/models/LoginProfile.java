package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class LoginProfile implements Serializable, Cloneable {
	private String loginId;
	private String loginPwd;
	private String loginUsername;
	private java.util.Date loginCdate;
	private java.util.Date loginAdate;
	private String loginIp;
	private String loginEmail;
	private java.math.BigDecimal amount;
	private String xxx;
	private Integer eee;
	private String loginNewPswd;

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginCdate(java.util.Date loginCdate) {
		this.loginCdate = loginCdate;
	}
	public java.util.Date getLoginCdate() {
		return loginCdate;
	}
	public void setLoginAdate(java.util.Date loginAdate) {
		this.loginAdate = loginAdate;
	}
	public java.util.Date getLoginAdate() {
		return loginAdate;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	public java.math.BigDecimal getAmount() {
		return amount;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	public String getXxx() {
		return xxx;
	}
	public void setEee(Integer eee) {
		this.eee = eee;
	}
	public Integer getEee() {
		return eee;
	}
  
	private static final String Table = "login_profile";
	private static final String Alias = "as_login_profile";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrLoginId = Alias+".login_id";
	public static final String DBStrLoginPwd = Alias+".login_pwd";
	public static final String DBStrLoginUsername = Alias+".login_username";
	public static final String DBStrLoginCdate = Alias+".login_cdate";
	public static final String DBStrLoginAdate = Alias+".login_adate";
	public static final String DBStrLoginIp = Alias+".login_ip";
	public static final String DBStrLoginEmail = Alias+".login_email";
	public static final String DBStrAmount = Alias+".amount";
	public static final String DBStrXxx = Alias+".xxx";
	public static final String DBStrEee = Alias+".eee";
	
	@Override
	public LoginProfile clone() {
		LoginProfile o = null;
		try{
			o = (LoginProfile)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
	public String getLoginNewPswd() {
		return loginNewPswd;
	}
	public void setLoginNewPswd(String loginNewPswd) {
		this.loginNewPswd = loginNewPswd;
	}
}

