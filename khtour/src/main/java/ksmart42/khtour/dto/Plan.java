package ksmart42.khtour.dto;

public class Plan {
		// plan_code, plan_name, start_time, end_time, solo_party, plan_materials, plan_expenses , plan_location
	
	private String planCode;
	private String planName;
	private String startDate;
	private String endDate;
	private String soloParty;
	private String planMaterials;
	private String planExpenses;
	private String planLocation;
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
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
	public String getSoloParty() {
		return soloParty;
	}
	public void setSoloParty(String soloParty) {
		this.soloParty = soloParty;
	}
	public String getPlanMaterials() {
		return planMaterials;
	}
	public void setPlanMaterials(String planMaterials) {
		this.planMaterials = planMaterials;
	}
	public String getPlanExpenses() {
		return planExpenses;
	}
	public void setPlanExpenses(String planExpenses) {
		this.planExpenses = planExpenses;
	}
	public String getPlanLocation() {
		return planLocation;
	}
	public void setPlanLocation(String planLocation) {
		this.planLocation = planLocation;
	}
	@Override
	public String toString() {
		return "Plan [planCode=" + planCode + ", planName=" + planName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", soloParty=" + soloParty + ", planMaterials=" + planMaterials + ", planExpenses="
				+ planExpenses + ", planLocation=" + planLocation + "]";
	}
	

	
}
