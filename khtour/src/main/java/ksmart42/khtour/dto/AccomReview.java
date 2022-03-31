package ksmart42.khtour.dto;

public class AccomReview {
	
	private String ldgReviewCode;
	private String memberId;
	private String ldgCode;
	private int ldgCleanliness;
	private int ldgKindness;
	private int ldgConvenience;
	private int ldgLocation;
	private int ldgPriceSta;
	private String reviewContents;
	private String reviewTime;
	public String getLdgReviewCode() {
		return ldgReviewCode;
	}
	public void setLdgReviewCode(String ldgReviewCode) {
		this.ldgReviewCode = ldgReviewCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLdgCode() {
		return ldgCode;
	}
	public void setLdgCode(String ldgCode) {
		this.ldgCode = ldgCode;
	}
	public int getLdgCleanliness() {
		return ldgCleanliness;
	}
	public void setLdgCleanliness(int ldgCleanliness) {
		this.ldgCleanliness = ldgCleanliness;
	}
	public int getLdgKindness() {
		return ldgKindness;
	}
	public void setLdgKindness(int ldgKindness) {
		this.ldgKindness = ldgKindness;
	}
	public int getLdgConvenience() {
		return ldgConvenience;
	}
	public void setLdgConvenience(int ldgConvenience) {
		this.ldgConvenience = ldgConvenience;
	}
	public int getLdgLocation() {
		return ldgLocation;
	}
	public void setLdgLocation(int ldgLocation) {
		this.ldgLocation = ldgLocation;
	}
	public int getLdgPriceSta() {
		return ldgPriceSta;
	}
	public void setLdgPriceSta(int ldgPriceSta) {
		this.ldgPriceSta = ldgPriceSta;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Override
	public String toString() {
		return "AccomReview [ldgReviewCode=" + ldgReviewCode + ", memberId=" + memberId + ", ldgCode=" + ldgCode
				+ ", ldgCleanliness=" + ldgCleanliness + ", ldgKindness=" + ldgKindness + ", ldgConvenience="
				+ ldgConvenience + ", ldgLocation=" + ldgLocation + ", ldgPriceSta=" + ldgPriceSta + ", reviewContents="
				+ reviewContents + ", reviewTime=" + reviewTime + "]";
	}

}
