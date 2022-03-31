package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Room;

@Mapper
public interface RoomMapper {
	
	// 여행계획 목록조회
	public List<Room> getRoomList(Map<String, Object> paramMap);
	
	// 여행계획 등록
	public int addRoom(Room room);
	
	// 여행계획 조회(여행계획 코드)
	public Room getRoomByCode(String roomCode);
		
	// 여행계획 수정(여행계획코드)
	public int modifyRoom(Room room);
		
	// 여행계획 삭제
	public int removeRoom(String roomCode);
}
