package ksmart42.khtour.dto;

public class Exhib {
	//전시회코드 문화재 및 박물관 코드 카테고리 이름 시작일 종료일 내용 전시회 현황
	private String exhibCode;
	private String chMusCode;
	private String exhibCate;
	private String exhibName;
	private String exhibStart;
	private String exhibEnd;
	private String exhibCon;
	private String exhibCurrent;
	private String exhibPage;
	
	public String getExhibCode() {
		return exhibCode;
	}
	public void setExhibCode(String exhibCode) {
		this.exhibCode = exhibCode;
	}
	public String getChMusCode() {
		return chMusCode;
	}
	public void setChMusCode(String chMusCode) {
		this.chMusCode = chMusCode;
	}
	public String getExhibCate() {
		return exhibCate;
	}
	public void setExhibCate(String exhibCate) {
		this.exhibCate = exhibCate;
	}
	public String getExhibName() {
		return exhibName;
	}
	public void setExhibName(String exhibName) {
		this.exhibName = exhibName;
	}
	public String getExhibStart() {
		return exhibStart;
	}
	public void setExhibStart(String exhibStart) {
		this.exhibStart = exhibStart;
	}
	public String getExhibEnd() {
		return exhibEnd;
	}
	public void setExhibEnd(String exhibEnd) {
		this.exhibEnd = exhibEnd;
	}
	public String getExhibCon() {
		return exhibCon;
	}
	public void setExhibCon(String exhibCon) {
		this.exhibCon = exhibCon;
	}
	public String getExhibCurrent() {
		return exhibCurrent;
	}
	public void setExhibCurrent(String exhibCurrent) {
		this.exhibCurrent = exhibCurrent;
	}
	public String getExhibPage() {
		return exhibPage;
	}
	public void setExhibPage(String exhibPage) {
		this.exhibPage = exhibPage;
	}
	@Override
	public String toString() {
		return "Exhib [exhibCode=" + exhibCode + ", chMusCode=" + chMusCode + ", exhibCate=" + exhibCate
				+ ", exhibName=" + exhibName + ", exhibStart=" + exhibStart + ", exhibEnd=" + exhibEnd + ", exhibCon="
				+ exhibCon + ", exhibCurrent=" + exhibCurrent +", exhibPage=" + exhibPage+ "]";
	}
	
	
}
