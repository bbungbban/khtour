package ksmart42.khtour.dto;

public class Accommodation {
	
	private String ldgCode;
	private String ldgName;
	private String ldgType;
	private String ldgImg;
	private String businessNumber;
	private String ldgAddr;
	private String ldgDetailAddr;
	private String ldgExplain;
	private String ldgTel;
	private String ldgPhone;
	private String ldgEmail;
	
	public String getLdgCode() {
		return ldgCode;
	}
	public void setLdgCode(String ldgCode) {
		this.ldgCode = ldgCode;
	}
	public String getLdgName() {
		return ldgName;
	}
	public void setLdgName(String ldgName) {
		this.ldgName = ldgName;
	}
	public String getLdgType() {
		return ldgType;
	}
	public void setLdgType(String ldgType) {
		this.ldgType = ldgType;
	}
	public String getLdgImg() {
		return ldgImg;
	}
	public void setLdgImg(String ldgImg) {
		this.ldgImg = ldgImg;
	}
	public String getBusinessNumber() {
		return businessNumber;
	}
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}
	public String getLdgAddr() {
		return ldgAddr;
	}
	public void setLdgAddr(String ldgAddr) {
		this.ldgAddr = ldgAddr;
	}
	public String getLdgDetailAddr() {
		return ldgDetailAddr;
	}
	public void setLdgDetailAddr(String ldgDetailAddr) {
		this.ldgDetailAddr = ldgDetailAddr;
	}
	public String getLdgExplain() {
		return ldgExplain;
	}
	public void setLdgExplain(String ldgExplain) {
		this.ldgExplain = ldgExplain;
	}
	public String getLdgTel() {
		return ldgTel;
	}
	public void setLdgTel(String ldgTel) {
		this.ldgTel = ldgTel;
	}
	public String getLdgPhone() {
		return ldgPhone;
	}
	public void setLdgPhone(String ldgPhone) {
		this.ldgPhone = ldgPhone;
	}
	public String getLdgEmail() {
		return ldgEmail;
	}
	public void setLdgEmail(String ldgEmail) {
		this.ldgEmail = ldgEmail;
	}
	@Override
	public String toString() {
		return "Accommodation [ldgCode=" + ldgCode + ", ldgName=" + ldgName + ", ldgType=" + ldgType + ", ldgImg="
				+ ldgImg + ", businessNumber=" + businessNumber + ", ldgAddr=" + ldgAddr + ", ldgDetailAddr="
				+ ldgDetailAddr + ", ldgExplain=" + ldgExplain + ", ldgTel=" + ldgTel + ", ldgPhone=" + ldgPhone
				+ ", ldgEmail=" + ldgEmail + "]";
	}
	
}
