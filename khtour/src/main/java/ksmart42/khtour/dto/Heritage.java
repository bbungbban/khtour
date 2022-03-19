package ksmart42.khtour.dto;

public class Heritage {
	//heritage_code, heritage_name, heritage_Sub_name, heritage_location, heritage_era, heritage_designation, 
	//heritage_classification, heritage_image, heritage_detail, member_id 
	private String  heritageCode;
	private String  memberId;
	private String  heritageName;
	private String  heritageSubName;
	private String  heritageLocation;
	private String  heritageEra;
	private String  heritageDesignation;
	private String  heritageClassification;
	private String  heritageImage;
	private String  heritageDetail;
	public String getHeritageCode() {
		return heritageCode;
	}
	public void setHeritageCode(String heritageCode) {
		this.heritageCode = heritageCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getHeritageName() {
		return heritageName;
	}
	public void setHeritageName(String heritageName) {
		this.heritageName = heritageName;
	}
	public String getHeritageSubName() {
		return heritageSubName;
	}
	public void setHeritageSubName(String heritageSubName) {
		this.heritageSubName = heritageSubName;
	}
	public String getHeritageLocation() {
		return heritageLocation;
	}
	public void setHeritageLocation(String heritageLocation) {
		this.heritageLocation = heritageLocation;
	}
	public String getHeritageEra() {
		return heritageEra;
	}
	public void setHeritageEra(String heritageEra) {
		this.heritageEra = heritageEra;
	}
	public String getHeritageDesignation() {
		return heritageDesignation;
	}
	public void setHeritageDesignation(String heritageDesignation) {
		this.heritageDesignation = heritageDesignation;
	}
	public String getHeritageClassification() {
		return heritageClassification;
	}
	public void setHeritageClassification(String heritageClassification) {
		this.heritageClassification = heritageClassification;
	}
	public String getHeritageImage() {
		return heritageImage;
	}
	public void setHeritageImage(String heritageImage) {
		this.heritageImage = heritageImage;
	}
	public String getHeritageDetail() {
		return heritageDetail;
	}
	public void setHeritageDetail(String heritageDetail) {
		this.heritageDetail = heritageDetail;
	}
	@Override
	public String toString() {
		return "Heritage [heritageCode=" + heritageCode + ", memberId=" + memberId + ", heritageName=" + heritageName
				+ ", heritageSubName=" + heritageSubName + ", heritageLocation=" + heritageLocation + ", heritageEra="
				+ heritageEra + ", heritageDesignation=" + heritageDesignation + ", heritageClassification="
				+ heritageClassification + ", heritageImage=" + heritageImage + ", heritageDetail=" + heritageDetail
				+ "]";
	}
	

}
