package ksmart42.khtour.dto;

public class Board {
	
	private String boardNum;
	private String memberId;
	private String boardTitle;
	private String boardType;
	private String boardContent;
	private String boardHit;
	private String boardDate;
	
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
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
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
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
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", memberId=" + memberId + ", boardTitle=" + boardTitle + ", boardType="
				+ boardType + ", boardContent=" + boardContent + ", boardHit=" + boardHit + ", boardDate=" + boardDate
				+ "]";
	}
	
	

}
