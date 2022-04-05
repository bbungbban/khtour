package ksmart42.khtour.dto;

public class Cos {
	private String cosCode;
	private String memberId; 
	private String themeCategoryCode;
	private String musCode;
	private String cosArea;
	private String tripName;
	private String cosRegist;
	private String cosOpen;
	private String cosShare;
	private String cosDestination01;
	private String cosDestination02;
	private String cosDestination03;
	private String cosDestination04;
	private String cosDestination05;
	
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
	public String getMusCode() {
		return musCode;
	}
	public void setMusCode(String musCode) {
		this.musCode = musCode;
	}
	
	public String getCosArea() {
		return cosArea;
	}
	public void setCosArea(String cosArea) {
		this.cosArea = cosArea;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
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
	
	public String getCosDestination01() {
		return cosDestination01;
	}
	public void setCosDestination01(String cosDestination01) {
		this.cosDestination01 = cosDestination01;
	}
	public String getCosDestination02() {
		return cosDestination02;
	}
	public void setCosDestination02(String cosDestination02) {
		this.cosDestination02 = cosDestination02;
	}
	public String getCosDestination03() {
		return cosDestination03;
	}
	public void setCosDestination03(String cosDestination03) {
		this.cosDestination03 = cosDestination03;
	}
	public String getCosDestination04() {
		return cosDestination04;
	}
	public void setCosDestination04(String cosDestination04) {
		this.cosDestination04 = cosDestination04;
	}
	public String getCosDestination05() {
		return cosDestination05;
	}
	public void setCosDestination05(String cosDestination05) {
		this.cosDestination05 = cosDestination05;
	}
	
	@Override
	public String toString() {
		return "Cos [cosCode=" + cosCode + ", memberId=" + memberId + ", themeCategoryCode=" + themeCategoryCode
				+ ", musCode=" + musCode + ", tripName=" + tripName + ", cosRegist=" + cosRegist + ", cosOpen="
				+ cosOpen + ", cosShare=" + cosShare + ", cosDestination01=" + cosDestination01 + ", cosDestination02="
				+ cosDestination02 + ", cosDestination03=" + cosDestination03 + ", cosDestination04=" + cosDestination04
				+ ", cosDestination05=" + cosDestination05 + ", cosArea=" + cosArea +"]";
	}
	
	
}
