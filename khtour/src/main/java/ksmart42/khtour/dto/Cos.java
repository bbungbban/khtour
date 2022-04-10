package ksmart42.khtour.dto;

public class Cos {
	private String cosCode;
	private String memberId; 
	private String themeCategoryCode;
	private String themeCategory;
	private String musCode;
	private String cosArea1;
	private String cosArea2;
	private String cosName;
	private String cosRegist;
	private String cosOpen;
	private String cosShare;
	
	public String getCosCode() {
		return cosCode;
	}
	public void setCosCode(String cosCode) {
		this.cosCode = cosCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getThemeCategoryCode() {
		return themeCategoryCode;
	}
	public void setThemeCategoryCode(String themeCategoryCode) {
		this.themeCategoryCode = themeCategoryCode;
	}
	
	public String getThemeCategory() {
		return themeCategory;
	}
	public void setThemeCategory(String themeCategory) {
		this.themeCategory = themeCategory;
	}
	public String getMusCode() {
		return musCode;
	}
	public void setMusCode(String musCode) {
		this.musCode = musCode;
	}
	
	public String getCosArea1() {
		return cosArea1;
	}
	public void setCosArea1(String cosArea1) {
		this.cosArea1 = cosArea1;
	}
	public String getCosArea2() {
		return cosArea2;
	}
	public void setCosArea2(String cosArea2) {
		this.cosArea2 = cosArea2;
	}
	public String getCosName() {
		return cosName;
	}
	public void setCosName(String cosName) {
		this.cosName = cosName;
	}
	public String getCosRegist() {
		return cosRegist;
	}
	public void setCosRegist(String cosRegist) {
		this.cosRegist = cosRegist;
	}
	public String getCosOpen() {
		return cosOpen;
	}
	public void setCosOpen(String cosOpen) {
		this.cosOpen = cosOpen;
	}
	public String getCosShare() {
		return cosShare;
	}
	public void setCosShare(String cosShare) {
		this.cosShare = cosShare;
	}
	@Override
	public String toString() {
		return "Cos [cosCode=" + cosCode + ", memberId=" + memberId + ", themeCategoryCode=" + themeCategoryCode
				+ ", themeCategory=" + themeCategory + ", musCode=" + musCode + ", cosArea1=" + cosArea1 + ", cosArea2="
				+ cosArea2 + ", cosName=" + cosName + ", cosRegist=" + cosRegist + ", cosOpen=" + cosOpen
				+ ", cosShare=" + cosShare + "]";
	}
	
	
	
}
