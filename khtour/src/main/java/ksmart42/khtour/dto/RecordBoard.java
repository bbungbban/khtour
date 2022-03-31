package ksmart42.khtour.dto;

public class RecordBoard {
			//record_board_code, member_id, record_board_name, content, status, image, start_date, end_date, reg_date, like_count, views
	private String recordBoardCode;
	private String memberId;
	private String recordBoardName;
	private String content;
	private String status;
	private String image;
	private String startDate;
	private String endDate;
	private String regDate;
	private String likeCount;
	private String views;
	public String getRecordBoardCode() {
		return recordBoardCode;
	}
	public void setRecordBoardCode(String recordBoardCode) {
		this.recordBoardCode = recordBoardCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRecordBoardName() {
		return recordBoardName;
	}
	public void setRecordBoardName(String recordBoardName) {
		this.recordBoardName = recordBoardName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "RecordBoard [recordBoardCode=" + recordBoardCode + ", memberId=" + memberId + ", recordBoardName="
				+ recordBoardName + ", content=" + content + ", status=" + status + ", image=" + image + ", startDate="
				+ startDate + ", endDate=" + endDate + ", regDate=" + regDate + ", likeCount=" + likeCount + ", views="
				+ views + "]";
	}
	

}
