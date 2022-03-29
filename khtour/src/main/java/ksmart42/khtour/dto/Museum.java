package ksmart42.khtour.dto;

public class Museum {
	private String chMusCode;
	private String largeChmusCateCode;
	private String largeCategory;
	private String chMusName;
	private String chMusAddr;
	private String chMusDetail;
	private String chMusSite;
	private String chMusNum;
	private String chMusDisclose;
	private int chMusStart;
	private int chMusEnd;
	private String chMusClose;
	public String getChMusCode() {
		return chMusCode;
	}
	public void setChMusCode(String chMusCode) {
		this.chMusCode = chMusCode;
	}
	public String getLargeChmusCateCode() {
		return largeChmusCateCode;
	}
	public void setLargeChmusCateCode(String largeChmusCateCode) {
		this.largeChmusCateCode = largeChmusCateCode;
	}
	public String getLargeCategory() {
		return largeCategory;
	}
	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}
	public String getChMusName() {
		return chMusName;
	}
	public void setChMusName(String chMusName) {
		this.chMusName = chMusName;
	}
	public String getChMusAddr() {
		return chMusAddr;
	}
	public void setChMusAddr(String chMusAddr) {
		this.chMusAddr = chMusAddr;
	}
	public String getChMusDetail() {
		return chMusDetail;
	}
	public void setChMusDetail(String chMusDetail) {
		this.chMusDetail = chMusDetail;
	}
	public String getChMusSite() {
		return chMusSite;
	}
	public void setChMusSite(String chMusSite) {
		this.chMusSite = chMusSite;
	}
	public String getChMusNum() {
		return chMusNum;
	}
	public void setChMusNum(String chMusNum) {
		this.chMusNum = chMusNum;
	}
	public String getChMusDisclose() {
		return chMusDisclose;
	}
	public void setChMusDisclose(String chMusDisclose) {
		this.chMusDisclose = chMusDisclose;
	}
	public int getChMusStart() {
		return chMusStart;
	}
	public void setChMusStart(int chMusStart) {
		this.chMusStart = chMusStart;
	}
	public int getChMusEnd() {
		return chMusEnd;
	}
	public void setChMusEnd(int chMusEnd) {
		this.chMusEnd = chMusEnd;
	}
	public String getChMusClose() {
		return chMusClose;
	}
	public void setChMusClose(String chMusClose) {
		this.chMusClose = chMusClose;
	}
	@Override
	public String toString() {
		return "Museum [chMusCode=" + chMusCode + ", largeChmusCateCode=" + largeChmusCateCode + ", largeCategory="
				+ largeCategory + ", chMusName=" + chMusName + ", chMusAddr=" + chMusAddr + ", chMusDetail="
				+ chMusDetail + ", chMusSite=" + chMusSite + ", chMusNum=" + chMusNum + ", chMusDisclose="
				+ chMusDisclose + ", chMusStart=" + chMusStart + ", chMusEnd=" + chMusEnd + ", chMusClose=" + chMusClose
				+ "]";
	}
	
}
