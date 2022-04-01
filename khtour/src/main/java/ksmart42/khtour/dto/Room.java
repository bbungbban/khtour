package ksmart42.khtour.dto;

public class Room {

	private String roomCode;
	private String ldgCode;
	private String roomImg;
	private String roomName;
	private String roomExplain;
	private String roomPersonnel;
	private String roomType;
	private String roomCheckin;
	private String roomPrice;
	private String roomDiscount;
	private String roomFinalPrice;
	
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public String getLdgCode() {
		return ldgCode;
	}
	public void setLdgCode(String ldgCode) {
		this.ldgCode = ldgCode;
	}
	public String getRoomImg() {
		return roomImg;
	}
	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomExplain() {
		return roomExplain;
	}
	public void setRoomExplain(String roomExplain) {
		this.roomExplain = roomExplain;
	}
	public String getRoomPersonnel() {
		return roomPersonnel;
	}
	public void setRoomPersonnel(String roomPersonnel) {
		this.roomPersonnel = roomPersonnel;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomCheckin() {
		return roomCheckin;
	}
	public void setRoomCheckin(String roomCheckin) {
		this.roomCheckin = roomCheckin;
	}
	public String getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomDiscount() {
		return roomDiscount;
	}
	public void setRoomDiscount(String roomDiscount) {
		this.roomDiscount = roomDiscount;
	}
	public String getRoomFinalPrice() {
		return roomFinalPrice;
	}
	public void setRoomFinalPrice(String roomFinalPrice) {
		this.roomFinalPrice = roomFinalPrice;
	}
	@Override
	public String toString() {
		return "Room [roomCode=" + roomCode + ", ldgCode=" + ldgCode + ", roomImg=" + roomImg + ", roomName=" + roomName
				+ ", roomExplain=" + roomExplain + ", roomPersonnel=" + roomPersonnel + ", roomType=" + roomType
				+ ", roomCheckin=" + roomCheckin + ", roomPrice=" + roomPrice + ", roomDiscount=" + roomDiscount
				+ ", roomFinalPrice=" + roomFinalPrice + "]";
	}

	
}