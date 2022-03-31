package ksmart42.khtour.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Room;

@Mapper
public interface RoomMapper {
	
	//ldg_code에 맞는 객실 조회
	public List<Room> getRoomListByldgCode(String ldgCode);
	
	// 객실계획 목록조회
	public List<Room> getRoomList();
	
	// 객실계획 등록
	public int addRoom(Room room);
	
	// 객실계획 조회(객실계획 코드)
	public Room getRoomByCode(String roomCode);
		
	// 객실계획 수정(객실계획코드)
	public int modifyRoom(Room room);
		
	// 객실계획 삭제
	public int removeRoom(String roomCode);
}
