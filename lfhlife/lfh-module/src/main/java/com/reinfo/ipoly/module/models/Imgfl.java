package com.reinfo.ipoly.module.models;
import java.io.Serializable;

public class Imgfl implements Serializable, Cloneable {
	private Long imgSeqno;
	private String imgType;
	private String imgClicode;
	private Object imgDesc;
	private String imgOffice;
	private String imgDept;
	private String imgCls;
	private String imgAgt;
	private Long imgYear;
	private String imgId;
	private String imgSec;
	private Long imgEndst;
	private String imgClaim;
	private String imgVoucher;
	private String imgTtyId;
	private Long imgTtyUwyr;
	private String imgTtySec;
	private String imgPolicyno;
	private String imgEndstno;
	private String imgClaimno;
	private Object imgFileName;
	private Object imgFilePath;
	private byte[] imgFile;
	private String imgFileExt;
	private String imgSt;
	private java.util.Date imgCdate;
	private String imgCuser;
	private java.util.Date imgFileAdate;
	private Long imgFileSize;
	private String imgCat;
	private String imgSync;
	private Long imgClmseq;
	private byte[] imgFileBlob;
	private String imgCopy;
	
	private String imgFileBase64;
	private String tmpImgFileName;
	
	public String getTmpImgFileName() {
		return tmpImgFileName;
	}
	public void setTmpImgFileName(String tmpImgFileName) {
		this.tmpImgFileName = tmpImgFileName;
	}
	public String getImgFileBase64() {
        return imgFileBase64;
    }
    public void setImgFileBase64(String imgFileBase64) {
        this.imgFileBase64 = imgFileBase64;
    }
    public void setImgSeqno(Long imgSeqno) {
		this.imgSeqno = imgSeqno;
	}
	public Long getImgSeqno() {
		return imgSeqno;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgClicode(String imgClicode) {
		this.imgClicode = imgClicode;
	}
	public String getImgClicode() {
		return imgClicode;
	}
	public void setImgDesc(Object imgDesc) {
		this.imgDesc = imgDesc;
	}
	public Object getImgDesc() {
		return imgDesc;
	}
	public void setImgOffice(String imgOffice) {
		this.imgOffice = imgOffice;
	}
	public String getImgOffice() {
		return imgOffice;
	}
	public void setImgDept(String imgDept) {
		this.imgDept = imgDept;
	}
	public String getImgDept() {
		return imgDept;
	}
	public void setImgCls(String imgCls) {
		this.imgCls = imgCls;
	}
	public String getImgCls() {
		return imgCls;
	}
	public void setImgAgt(String imgAgt) {
		this.imgAgt = imgAgt;
	}
	public String getImgAgt() {
		return imgAgt;
	}
	public void setImgYear(Long imgYear) {
		this.imgYear = imgYear;
	}
	public Long getImgYear() {
		return imgYear;
	}
	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	public String getImgId() {
		return imgId;
	}
	public void setImgSec(String imgSec) {
		this.imgSec = imgSec;
	}
	public String getImgSec() {
		return imgSec;
	}
	public void setImgEndst(Long imgEndst) {
		this.imgEndst = imgEndst;
	}
	public Long getImgEndst() {
		return imgEndst;
	}
	public void setImgClaim(String imgClaim) {
		this.imgClaim = imgClaim;
	}
	public String getImgClaim() {
		return imgClaim;
	}
	public void setImgVoucher(String imgVoucher) {
		this.imgVoucher = imgVoucher;
	}
	public String getImgVoucher() {
		return imgVoucher;
	}
	public void setImgTtyId(String imgTtyId) {
		this.imgTtyId = imgTtyId;
	}
	public String getImgTtyId() {
		return imgTtyId;
	}
	public void setImgTtyUwyr(Long imgTtyUwyr) {
		this.imgTtyUwyr = imgTtyUwyr;
	}
	public Long getImgTtyUwyr() {
		return imgTtyUwyr;
	}
	public void setImgTtySec(String imgTtySec) {
		this.imgTtySec = imgTtySec;
	}
	public String getImgTtySec() {
		return imgTtySec;
	}
	public void setImgPolicyno(String imgPolicyno) {
		this.imgPolicyno = imgPolicyno;
	}
	public String getImgPolicyno() {
		return imgPolicyno;
	}
	public void setImgEndstno(String imgEndstno) {
		this.imgEndstno = imgEndstno;
	}
	public String getImgEndstno() {
		return imgEndstno;
	}
	public void setImgClaimno(String imgClaimno) {
		this.imgClaimno = imgClaimno;
	}
	public String getImgClaimno() {
		return imgClaimno;
	}
	public void setImgFileName(Object imgFileName) {
		this.imgFileName = imgFileName;
	}
	public Object getImgFileName() {
		return imgFileName;
	}
	public void setImgFilePath(Object imgFilePath) {
		this.imgFilePath = imgFilePath;
	}
	public Object getImgFilePath() {
		return imgFilePath;
	}
	public void setImgFile(byte[] imgFile) {
		this.imgFile = imgFile;
	}
	public byte[] getImgFile() {
		return imgFile;
	}
	public void setImgFileExt(String imgFileExt) {
		this.imgFileExt = imgFileExt;
	}
	public String getImgFileExt() {
		return imgFileExt;
	}
	public void setImgSt(String imgSt) {
		this.imgSt = imgSt;
	}
	public String getImgSt() {
		return imgSt;
	}
	public void setImgCdate(java.util.Date imgCdate) {
		this.imgCdate = imgCdate;
	}
	public java.util.Date getImgCdate() {
		return imgCdate;
	}
	public void setImgCuser(String imgCuser) {
		this.imgCuser = imgCuser;
	}
	public String getImgCuser() {
		return imgCuser;
	}
	public void setImgFileAdate(java.util.Date imgFileAdate) {
		this.imgFileAdate = imgFileAdate;
	}
	public java.util.Date getImgFileAdate() {
		return imgFileAdate;
	}
	public void setImgFileSize(Long imgFileSize) {
		this.imgFileSize = imgFileSize;
	}
	public Long getImgFileSize() {
		return imgFileSize;
	}
	public void setImgCat(String imgCat) {
		this.imgCat = imgCat;
	}
	public String getImgCat() {
		return imgCat;
	}
	public void setImgSync(String imgSync) {
		this.imgSync = imgSync;
	}
	public String getImgSync() {
		return imgSync;
	}
	public void setImgClmseq(Long imgClmseq) {
		this.imgClmseq = imgClmseq;
	}
	public Long getImgClmseq() {
		return imgClmseq;
	}
	public void setImgFileBlob(byte[] imgFileBlob) {
		this.imgFileBlob = imgFileBlob;
	}
	public byte[] getImgFileBlob() {
		return imgFileBlob;
	}
	public void setImgCopy(String imgCopy) {
		this.imgCopy = imgCopy;
	}
	public String getImgCopy() {
		return imgCopy;
	}
  
	private static final String Table = "imgfl";
	private static final String Alias = "as_imgfl";
	private static final long serialVersionUID = 16454654984465L;
 
	public static final String DBStrImgSeqno = Alias+".img_seqno";
	public static final String DBStrImgType = Alias+".img_type";
	public static final String DBStrImgClicode = Alias+".img_clicode";
	public static final String DBStrImgDesc = Alias+".img_desc";
	public static final String DBStrImgOffice = Alias+".img_office";
	public static final String DBStrImgDept = Alias+".img_dept";
	public static final String DBStrImgCls = Alias+".img_cls";
	public static final String DBStrImgAgt = Alias+".img_agt";
	public static final String DBStrImgYear = Alias+".img_year";
	public static final String DBStrImgId = Alias+".img_id";
	public static final String DBStrImgSec = Alias+".img_sec";
	public static final String DBStrImgEndst = Alias+".img_endst";
	public static final String DBStrImgClaim = Alias+".img_claim";
	public static final String DBStrImgVoucher = Alias+".img_voucher";
	public static final String DBStrImgTtyId = Alias+".img_tty_id";
	public static final String DBStrImgTtyUwyr = Alias+".img_tty_uwyr";
	public static final String DBStrImgTtySec = Alias+".img_tty_sec";
	public static final String DBStrImgPolicyno = Alias+".img_policyno";
	public static final String DBStrImgEndstno = Alias+".img_endstno";
	public static final String DBStrImgClaimno = Alias+".img_claimno";
	public static final String DBStrImgFileName = Alias+".img_file_name";
	public static final String DBStrImgFilePath = Alias+".img_file_path";
	public static final String DBStrImgFile = Alias+".img_file";
	public static final String DBStrImgFileExt = Alias+".img_file_ext";
	public static final String DBStrImgSt = Alias+".img_st";
	public static final String DBStrImgCdate = Alias+".img_cdate";
	public static final String DBStrImgCuser = Alias+".img_cuser";
	public static final String DBStrImgFileAdate = Alias+".img_file_adate";
	public static final String DBStrImgFileSize = Alias+".img_file_size";
	public static final String DBStrImgCat = Alias+".img_cat";
	public static final String DBStrImgSync = Alias+".img_sync";
	public static final String DBStrImgClmseq = Alias+".img_clmseq";
	public static final String DBStrImgFileBlob = Alias+".img_file_blob";
	public static final String DBStrImgCopy = Alias+".img_copy";
	
	@Override
	public Imgfl clone() {
		Imgfl o = null;
		try{
			o = (Imgfl)super.clone();
		}catch(CloneNotSupportedException ex){
			ex.printStackTrace();
		}
		return o;
	}
}

