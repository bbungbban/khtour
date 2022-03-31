package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Room;
import ksmart42.khtour.mapper.RoomMapper;

@Service
@Transactional
public class RoomService {
	//DI 의존성 주입
		private RoomMapper roomMapper;
		
		public RoomService(RoomMapper roomMapper) {
			this.roomMapper = roomMapper;
		}
		
		/**
		 * 코드에 따른 여행 계획 조회
		 */
		public Room getRoomByCode(String roomCode) {
			return roomMapper.getRoomByCode(roomCode);
		}
		/**
		 * 여행 계획 등록
		 */
		public void addRoom(Room room) {
			roomMapper.addRoom(room);
		}
		
		/**
		 * 여행 계획 목록 조회
		 */
		public List<Room> getRoomList(Map<String, Object> paramMap){
			List<Room> roomList = roomMapper.getRoomList(paramMap);
			
			return roomList;
		}

		/**
		 * 여행 계획 정보 수정
		 */
		public int modifyRoom(Room room) {
			return roomMapper.modifyRoom(room);
		}
		
		/**
		 * 여행 계획 정보 삭제
		 */
		public int removeRoom(String roomCode) {
			int result = roomMapper.removeRoom(roomCode);
			
			result += roomMapper.removeRoom(roomCode);
			
			return result;
		}
	}

