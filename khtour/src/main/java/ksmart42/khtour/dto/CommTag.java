package ksmart42.khtour.dto;

public class CommTag {

	public String getTagCode() {
		return tagCode;
	}
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public String getMemberId() {
		return memberId;
	}
	@Override
	public String toString() {
		return "CommTag [tagCode=" + tagCode + ", commName=" + commName + ", memberId=" + memberId + ", tagName="
				+ tagName + ", tagColor=" + tagColor + ", regTime=" + regTime + "]";
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTagName() {
		return tagName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagColor() {
		return tagColor;
	}
	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}

	private String tagCode;
	private String commName;
	private String memberId;
	private String tagName;
	private String tagColor;
	private String regTime;
	
	
}