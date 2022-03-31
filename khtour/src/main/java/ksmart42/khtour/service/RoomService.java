package ksmart42.khtour.service;

import java.text.NumberFormat;
import java.util.List;


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
		 * 이것은 바로 세자리 콤마와 원과 %를 붙여주는 메서드
		 * */
		public List<Room> getRoomListByldgCode(String ldgCode){
			List<Room> roomList = roomMapper.getRoomListByldgCode(ldgCode);
			NumberFormat numberFormat = NumberFormat.getInstance();
			for(int i=0; i<roomList.size(); i++) {
				int disc = Integer.parseInt(roomList.get(i).getRoomDiscount());
				int price = Integer.parseInt(roomList.get(i).getRoomPrice());
				int finalPrice = price-price*disc/100;

			
				String result = numberFormat.format(finalPrice);
				roomList.get(i).setRoomFinalPrice(result+"원");
				roomList.get(i).setRoomDiscount(disc+"%");
				
			}
			return roomList;
		}
	
		/**
		 * 코드에 따른 객실 계획 조회
		 */
		public Room getRoomByCode(String roomCode) {
			return roomMapper.getRoomByCode(roomCode);
		}
		/**
		 * 객실 계획 등록
		 */
		public void addRoom(Room room) {
			roomMapper.addRoom(room);
		}
		
		/**
		 * 객실 계획 목록 조회
		 */
		public List<Room> getRoomList(){
			List<Room> roomList = roomMapper.getRoomList();
			
			return roomList;
		}

		/**
		 * 객실 계획 정보 수정
		 */
		public int modifyRoom(Room room) {
			return roomMapper.modifyRoom(room);
		}
		
		/**
		 * 객실 계획 정보 삭제
		 */
		public int removeRoom(String roomCode) {
			int result = roomMapper.removeRoom(roomCode);
			
			result += roomMapper.removeRoom(roomCode);
			
			return result;
		}
	}

