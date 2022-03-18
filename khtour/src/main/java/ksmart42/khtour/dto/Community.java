package ksmart42.khtour.dto;

public class Community {

	private String commCode;
	private String memberId;
	private String regDate;
	private String commName;
	private String shortName;
	private String banner;
	private String avatar;
	private String memberCnt;
	private String onlineMemberCnt;
	
	
	@Override
	public String toString() {
		return "Community [commCode=" + commCode + ", memberId=" + memberId + ", regDate=" + regDate + ", commName="
				+ commName + ", shortName=" + shortName + ", banner=" + banner + ", avatar=" + avatar + ", memberCnt="
				+ memberCnt + ", onlineMemberCnt=" + onlineMemberCnt + "]";
	}


	public String getCommCode() {
		return commCode;
	}


	public void setCommCode(String commCode) {
		System.out.println(commCode + "<- commCode setCommCode Community.java");
		this.commCode = commCode;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		System.out.println(memberId + "<- memberId setMemberId Community.java");
		this.memberId = memberId;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		System.out.println(regDate + "<- regDate setRegDate Community.java");
		this.regDate = regDate;
	}


	public String getCommName() {
		return commName;
	}


	public void setCommName(String commName) {
		this.commName = commName;
	}


	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getBanner() {
		return banner;
	}


	public void setBanner(String banner) {
		this.banner = banner;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getMemberCnt() {
		return memberCnt;
	}


	public void setMemberCnt(String memberCnt) {
		this.memberCnt = memberCnt;
	}


	public String getOnlineMemberCnt() {
		return onlineMemberCnt;
	}


	public void setOnlineMemberCnt(String onlineMemberCnt) {
		this.onlineMemberCnt = onlineMemberCnt;
	}


}
