package ksmart42.khtour.dto;

public class Rule {

	private String ruleCode;
	private String commName;
	private String title;
	private String detail;
	private String regTime;
	@Override
	public String toString() {
		return "Rule [ruleCode=" + ruleCode + ", commName=" + commName + ", title=" + title + ", detail=" + detail
				+ ", regTime=" + regTime + ", reg_time=" + reg_time + "]";
	}
	public String getRuleCode() {
		return ruleCode;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getReg_time() {
		return reg_time;
	}
	public void setReg_time(String reg_time) {
		this.reg_time = reg_time;
	}
	private String reg_time;

	
}
