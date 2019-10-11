package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Yprompt implements Serializable, Cloneable {
	private String window;
	private String usr;
	private String type;
	private String dMgr;
	private Long rtvOnChg;
	private String dPrompt;
	private Object byValue;
	private Object s1;
	private Object s2;
	private Object s3;
	private Object s4;
	private Object s5;
	private Long i1;
	private Long i2;
	private java.math.BigDecimal dc1;
	private java.math.BigDecimal dc2;
	private java.util.Date dt1;
	private java.util.Date dt2;
	private java.math.BigDecimal ver;
	private Object s6;
	private Object s7;
	private Object s8;
	private Object s9;
	private Long i3;
	private Long i4;
	private Long i5;
	private Long i6;
	private Long i7;
	private Long i8;
	private Long i9;

	public void setWindow(String window) {
		this.window = window;
	}
	public String getWindow() {
		return window;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getUsr() {
		return usr;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setDMgr(String dMgr) {
		this.dMgr = dMgr;
	}
	public String getDMgr() {
		return dMgr;
	}
	public void setRtvOnChg(Long rtvOnChg) {
		this.rtvOnChg = rtvOnChg;
	}
	public Long getRtvOnChg() {
		return rtvOnChg;
	}
	public void setDPrompt(String dPrompt) {
		this.dPrompt = dPrompt;
	}
	public String getDPrompt() {
		return dPrompt;
	}
	public void setByValue(Object byValue) {
		this.byValue = byValue;
	}
	public Object getByValue() {
		return byValue;
	}
	public void setS1(Object s1) {
		this.s1 = s1;
	}
	public Object getS1() {
		return s1;
	}
	public void setS2(Object s2) {
		this.s2 = s2;
	}
	public Object getS2() {
		return s2;
	}
	public void setS3(Object s3) {
		this.s3 = s3;
	}
	public Object getS3() {
		return s3;
	}
	public void setS4(Object s4) {
		this.s4 = s4;
	}
	public Object getS4() {
		return s4;
	}
	public void setS5(Object s5) {
		this.s5 = s5;
	}
	public Object getS5() {
		return s5;
	}
	public void setI1(Long i1) {
		this.i1 = i1;
	}
	public Long getI1() {
		return i1;
	}
	public void setI2(Long i2) {
		this.i2 = i2;
	}
	public Long getI2() {
		return i2;
	}
	public void setDc1(java.math.BigDecimal dc1) {
		this.dc1 = dc1;
	}
	public java.math.BigDecimal getDc1() {
		return dc1;
	}
	public void setDc2(java.math.BigDecimal dc2) {
		this.dc2 = dc2;
	}
	public java.math.BigDecimal getDc2() {
		return dc2;
	}
	public void setDt1(java.util.Date dt1) {
		this.dt1 = dt1;
	}
	public java.util.Date getDt1() {
		return dt1;
	}
	public void setDt2(java.util.Date dt2) {
		this.dt2 = dt2;
	}
	public java.util.Date getDt2() {
		return dt2;
	}
	public void setVer(java.math.BigDecimal ver) {
		this.ver = ver;
	}
	public java.math.BigDecimal getVer() {
		return ver;
	}
	public void setS6(Object s6) {
		this.s6 = s6;
	}
	public Object getS6() {
		return s6;
	}
	public void setS7(Object s7) {
		this.s7 = s7;
	}
	public Object getS7() {
		return s7;
	}
	public void setS8(Object s8) {
		this.s8 = s8;
	}
	public Object getS8() {
		return s8;
	}
	public void setS9(Object s9) {
		this.s9 = s9;
	}
	public Object getS9() {
		return s9;
	}
	public void setI3(Long i3) {
		this.i3 = i3;
	}
	public Long getI3() {
		return i3;
	}
	public void setI4(Long i4) {
		this.i4 = i4;
	}
	public Long getI4() {
		return i4;
	}
	public void setI5(Long i5) {
		this.i5 = i5;
	}
	public Long getI5() {
		return i5;
	}
	public void setI6(Long i6) {
		this.i6 = i6;
	}
	public Long getI6() {
		return i6;
	}
	public void setI7(Long i7) {
		this.i7 = i7;
	}
	public Long getI7() {
		return i7;
	}
	public void setI8(Long i8) {
		this.i8 = i8;
	}
	public Long getI8() {
		return i8;
	}
	public void setI9(Long i9) {
		this.i9 = i9;
	}
	public Long getI9() {
		return i9;
	}
  
	private static final String Table = "yprompt";
	private static final String Alias = "as_yprompt";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrWindow = Alias+".window";
	public static final String DBStrUsr = Alias+".usr";
	public static final String DBStrType = Alias+".type_";
	public static final String DBStrDMgr = Alias+".d_mgr";
	public static final String DBStrRtvOnChg = Alias+".rtv_on_chg";
	public static final String DBStrDPrompt = Alias+".d_prompt";
	public static final String DBStrByValue = Alias+".by_value";
	public static final String DBStrS1 = Alias+".s_1";
	public static final String DBStrS2 = Alias+".s_2";
	public static final String DBStrS3 = Alias+".s_3";
	public static final String DBStrS4 = Alias+".s_4";
	public static final String DBStrS5 = Alias+".s_5";
	public static final String DBStrI1 = Alias+".i_1";
	public static final String DBStrI2 = Alias+".i_2";
	public static final String DBStrDc1 = Alias+".dc_1";
	public static final String DBStrDc2 = Alias+".dc_2";
	public static final String DBStrDt1 = Alias+".dt_1";
	public static final String DBStrDt2 = Alias+".dt_2";
	public static final String DBStrVer = Alias+".ver";
	public static final String DBStrS6 = Alias+".s_6";
	public static final String DBStrS7 = Alias+".s_7";
	public static final String DBStrS8 = Alias+".s_8";
	public static final String DBStrS9 = Alias+".s_9";
	public static final String DBStrI3 = Alias+".i_3";
	public static final String DBStrI4 = Alias+".i_4";
	public static final String DBStrI5 = Alias+".i_5";
	public static final String DBStrI6 = Alias+".i_6";
	public static final String DBStrI7 = Alias+".i_7";
	public static final String DBStrI8 = Alias+".i_8";
	public static final String DBStrI9 = Alias+".i_9";
	
	@Override
	public Yprompt clone() {
		Yprompt o = null;
		try{
			o = (Yprompt)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

