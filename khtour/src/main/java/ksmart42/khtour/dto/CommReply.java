package ksmart42.khtour.dto;

import java.util.List;

public class CommReply {

	private String replyCode;
	private String memberId;
	private String postCode;
	private String parentReplyCode;
	private String likesCnt;
	private String dislikesCnt;
	private String reportCnt;
	private String mainText;
	private String regTime;
	
	private List<CommReply> childrenReply;
	
	public List<CommReply> getChildrenReply() {
		return childrenReply;
	}
	public void setChildrenReply(List<CommReply> childrenReply) {
		this.childrenReply = childrenReply;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getReplyCode() {
		return replyCode;
	}
	public void setReplyCode(String replyCode) {
		this.replyCode = replyCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getParentReplyCode() {
		return parentReplyCode;
	}
	public void setParentReplyCode(String parentReplyCode) {
		this.parentReplyCode = parentReplyCode;
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
	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegT(String regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "CommReply [replyCode=" + replyCode + ", memberId=" + memberId + ", postCode=" + postCode
				+ ", parentReplyCode=" + parentReplyCode + ", likesCnt=" + likesCnt + ", dislikesCnt=" + dislikesCnt
				+ ", reportCnt=" + reportCnt + ", mainText=" + mainText + ", regTime=" + regTime + ", childrenReply="
				+ childrenReply + "]";
	}
	
	
}