package ksmart42.khtour.dto;

public class Board {
	
	private String boardCode;
	private String boardReNum;
	private String boardReLev;
	private String boardReSeq;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private String boardHit;
	private String delYn;
	private String insMemberId;
	private String insDate;
	private String updMemberId;
	private String updDate;
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardReNum() {
		return boardReNum;
	}
	public void setBoardReNum(String boardReNum) {
		this.boardReNum = boardReNum;
	}
	public String getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(String boardReLev) {
		this.boardReLev = boardReLev;
	}
	public String getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(String boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(String boardHit) {
		this.boardHit = boardHit;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getInsMemberId() {
		return insMemberId;
	}
	public void setInsMemberId(String insMemberId) {
		this.insMemberId = insMemberId;
	}
	public String getInsDate() {
		return insDate;
	}
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}
	public String getUpdMemberId() {
		return updMemberId;
	}
	public void setUpdMemberId(String updMemberId) {
		this.updMemberId = updMemberId;
	}
	public String getUpdDate() {
		return updDate;
	}
	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}
	@Override
	public String toString() {
		return "Board [boardCode=" + boardCode + ", boardReNum=" + boardReNum + ", boardReLev=" + boardReLev
				+ ", boardReSeq=" + boardReSeq + ", memberId=" + memberId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardHit=" + boardHit + ", delYn=" + delYn + ", insMemberId="
				+ insMemberId + ", insDate=" + insDate + ", updMemberId=" + updMemberId + ", updDate=" + updDate + "]";
	}
	

}
