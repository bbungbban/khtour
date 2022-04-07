package ksmart42.khtour.dto;

public class Board {
	
	private String boardCode;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private String boardHit;
	private String boardDate;
	
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
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
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	@Override
	public String toString() {
		return "Board [boardCode=" + boardCode + ", memberId=" + memberId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardHit=" + boardHit + ", boardDate=" + boardDate + "]";
	}
	

}
