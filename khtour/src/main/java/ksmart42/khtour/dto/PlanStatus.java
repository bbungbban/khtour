package ksmart42.khtour.dto;

public class PlanStatus {
			//plan_status_code, plan_status_name, reg_date, plan_status_cnt
	private String planStatusCode;
	private String planStatusName;
	private String regDate;
	private String planStatusCnt;
	
	
	public String getPlanStatusCode() {
		return planStatusCode;
	}
	public void setPlanStatusCode(String planStatusCode) {
		this.planStatusCode = planStatusCode;
	}
	public String getPlanStatusName() {
		return planStatusName;
	}
	public void setPlanStatusName(String planStatusName) {
		this.planStatusName = planStatusName;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getPlanStatusCnt() {
		return planStatusCnt;
	}
	public void setPlanStatusCnt(String planStatusCnt) {
		this.planStatusCnt = planStatusCnt;
	}
	@Override
	public String toString() {
		return "PlanStatus [planStatusCode=" + planStatusCode + ", planStatusName=" + planStatusName + ", regDate="
				+ regDate + ", planStatusCnt=" + planStatusCnt + "]";
	}
	
}
