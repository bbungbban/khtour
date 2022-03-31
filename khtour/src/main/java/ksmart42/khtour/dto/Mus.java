package ksmart42.khtour.dto;

public class Mus {
	private String musCode;
	private String musLargeCateCode;
	private String musName;
	private String musAddr;
	private String musDetail;
	private String musSite;
	private String musNum;
	private String musDisclose;
	private int musStart;
	private int musEnd;
	private String musClose;
	
	public String getMusCode() {
		return musCode;
	}
	public void setMusCode(String musCode) {
		this.musCode = musCode;
	}
	public String getMusLargeCateCode() {
		return musLargeCateCode;
	}
	public void setMusLargeCateCode(String musLargeCateCode) {
		this.musLargeCateCode = musLargeCateCode;
	}
	public String getMusName() {
		return musName;
	}
	public void setMusName(String musName) {
		this.musName = musName;
	}
	
	public String getMusAddr() {
		return musAddr;
	}
	public void setMusAddr(String musAddr) {
		this.musAddr = musAddr;
	}
	public String getMusDetail() {
		return musDetail;
	}
	public void setMusDetail(String musDetail) {
		this.musDetail = musDetail;
	}
	public String getMusSite() {
		return musSite;
	}
	public void setMusSite(String musSite) {
		this.musSite = musSite;
	}
	public String getMusNum() {
		return musNum;
	}
	public void setMusNum(String musNum) {
		this.musNum = musNum;
	}
	public String getMusDisclose() {
		return musDisclose;
	}
	public void setMusDisclose(String musDisclose) {
		this.musDisclose = musDisclose;
	}
	public int getMusStart() {
		return musStart;
	}
	public void setMusStart(int musStart) {
		this.musStart = musStart;
	}
	public int getMusEnd() {
		return musEnd;
	}
	public void setMusEnd(int musEnd) {
		this.musEnd = musEnd;
	}
	public String getMusClose() {
		return musClose;
	}
	public void setMusClose(String musClose) {
		this.musClose = musClose;
	}
	@Override
	public String toString() {
		return "Mus [musCode=" + musCode + ", musLargeCateCode=" + musLargeCateCode + ", musName=" + musName
				+ ", musAddr=" + musAddr + ", musDetail=" + musDetail + ", musSite=" + musSite + ", musNum=" + musNum
				+ ", musDisclose=" + musDisclose + ", musStart=" + musStart + ", musEnd=" + musEnd + ", musClose="
				+ musClose + "]";
	}
	
	
}
