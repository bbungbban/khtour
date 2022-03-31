package ksmart42.khtour.dto;

public class CommPost {

	@Override
	public String toString() {
		return "CommPost [postCode=" + postCode + ", commCode=" + commCode + ", memberId=" + memberId + ", tagCode="
				+ tagCode + ", commTag=" + commTag + ", title=" + title + ", regTime=" + regTime + ", mainText="
				+ mainText + ", readerCnt=" + readerCnt + ", pictureLink=" + pictureLink + ", videoLink=" + videoLink
				+ ", likesCnt=" + likesCnt + ", dislikesCnt=" + dislikesCnt + ", reportCnt=" + reportCnt
				+ ", pointGain=" + pointGain + "]";
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCommCode() {
		return commCode;
	}
	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTagCode() {
		return tagCode;
	}
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}
	public String getReaderCnt() {
		return readerCnt;
	}
	public void setReaderCnt(String readerCnt) {
		this.readerCnt = readerCnt;
	}
	public String getPictureLink() {
		return pictureLink;
	}
	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public String getLikesCnt() {
		return likesCnt;
	}
	public void setLikesCnt(String likesCnt) {
		this.likesCnt = likesCnt;
	}
	public String getDislikesCnt() {
		return dislikesCnt;
	}
	public void setDislikesCnt(String dislikesCnt) {
		this.dislikesCnt = dislikesCnt;
	}
	public String getReportCnt() {
		return reportCnt;
	}
	public void setReportCnt(String reportCnt) {
		this.reportCnt = reportCnt;
	}
	public String getPointGain() {
		return pointGain;
	}
	public void setPointGain(String pointGain) {
		this.pointGain = pointGain;
	}
	public CommTag getCommTag() {
		return commTag;
	}
	public void setCommTag(CommTag commTag) {
		this.commTag = commTag;
	}
	
	private String postCode;
	private String commCode;
	private String memberId;
	private String tagCode;
	private String title;
	private String regTime;
	private String mainText;
	private String readerCnt;
	private String pictureLink;
	private String videoLink;
	private String likesCnt;
	private String dislikesCnt;
	private String reportCnt;
	private String pointGain;
	private CommTag commTag;
	
}
