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
	
	@Override
	public String toString() {
		return "Cos [cosCode=" + cosCode + ", memberId=" + memberId + ", themeCategoryCode=" + themeCategoryCode
				+ ", musCode=" + musCode + ", tripName=" + tripName + ", cosRegist=" + cosRegist + ", cosOpen="
				+ cosOpen + ", cosShare=" + cosShare + ", cosArea=" + cosArea +"]";
	}
	
	
}
