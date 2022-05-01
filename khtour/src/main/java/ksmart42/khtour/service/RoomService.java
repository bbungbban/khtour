package ksmart42.khtour.service;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.dto.Reservation;
import ksmart42.khtour.dto.Room;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.mapper.RoomMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class RoomService {
	// DI 의존성 주입
	private RoomMapper roomMapper;

	// 파일 업로드 테이블
	private FileUtil fileUtil;

	private FileMapper fileMapper;

	public RoomService(RoomMapper roomMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.roomMapper = roomMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}
	
	/**
	 * 예약정보 관리자 페이지 삭제
	 */
	public int deletReservationSt(String roomReservationCode) {
		
		int result = roomMapper.deletReservationSt(roomReservationCode);
		
		result += roomMapper.deletReservationSt(roomReservationCode);
		
		return result;
	}
	
	/**
	 * 마이페이지 예약 취소 
	 */
	public int deletReservation(String roomReservationCode) {

		int result = roomMapper.deletReservation(roomReservationCode);

		result += roomMapper.deletReservation(roomReservationCode);

		return result;
	}
	
	/**
	 * 예약자 정보 조회
	 */
	public List<Reservation> getReservationList(Map<String, Object> paramMap) {
		List<Reservation> reservationList = roomMapper.getReservationList(paramMap);

		return reservationList;
	}
	
	/**
	 * 예약정보 등록
	 */
	public void addReservation(Reservation reservation) {
		roomMapper.addReservation(reservation);
	}

	/**
	 * 이것은 바로 세자리 콤마와 원과 %를 붙여주는 메서드
	 */
	public List<Room> getRoomListByldgCode(String ldgCode) {
		List<Room> roomList = roomMapper.getRoomListByldgCode(ldgCode);
		NumberFormat numberFormat = NumberFormat.getInstance();
		for (int i = 0; i < roomList.size(); i++) {
			int disc = Integer.parseInt(roomList.get(i).getRoomDiscount());
			int price = Integer.parseInt(roomList.get(i).getRoomPrice());
			int finalPrice = price - price * disc / 100;

			String result = numberFormat.format(finalPrice);
			roomList.get(i).setRoomFinalPrice(result + "원");
			roomList.get(i).setRoomDiscount(disc + "%");

		}
		return roomList;
	}

	/**
	 * 객실 목록 조회
	 */
	public List<Room> getRoomList(Map<String, Object> paramMap) {
		List<Room> roomList = roomMapper.getRoomList(paramMap);

		return roomList;
	}

	/**
	 * 코드에 따른 객실 조회
	 */
	public Room getRoomByCode(String roomCode) {
		Room room = roomMapper.getRoomByCode(roomCode);
		NumberFormat numberFormat = NumberFormat.getInstance();

		int disc = Integer.parseInt(room.getRoomDiscount());
		int price = Integer.parseInt(room.getRoomPrice());
		int finalPrice = price - price * disc / 100;

		String result = numberFormat.format(finalPrice);
		room.setRoomFinalPrice(result + "원");
		room.setRoomDiscount(disc + "%");

		return roomMapper.getRoomByCode(roomCode);
	}

	/**
	 * 객실 등록
	 */
	public void addRoom(Room room, MultipartFile[] roomImageFiles, String fileRealPath) {
		List<FileDto> fileList = fileUtil.parseFileInfo(roomImageFiles, fileRealPath);
		fileMapper.addFile(fileList);
		roomMapper.addRoom(room);

		List<Map<String, String>> addFileControlList = new ArrayList<Map<String, String>>();

		Map<String, String> addMap = null;

		if (fileList != null) {
			for (FileDto fileDto : fileList) {
				addMap = new HashMap<String, String>();
				addMap.put("referenceCode", room.getRoomCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}

		fileMapper.addFileControl(addFileControlList);
	}

	/**
	 * 객실 목록 조회
	 */
	public List<Room> getRoomList() {
		List<Room> roomList = roomMapper.getRoomList();

		return roomList;
	}

	/**
	 * 객실 정보 수정
	 */
	public int modifyRoom(Room room) {
		return roomMapper.modifyRoom(room);
	}

	/**
	 * 객실 정보 삭제
	 */
	public int removeRoom(String roomCode, String fileRootPath) throws IOException {
		
		FileDto fileDto = roomMapper.fileInfoByFileIdx(roomCode);
		
		 int result = 0;
			
	     if(fileDto != null) {
	         
	         String fileIdx = fileDto.getFileIdx();
	         String filePath = fileDto.getFilePath();
	   
	         if(fileIdx != null) {
	            
	            fileMapper.removeFileControl(fileIdx);
	            
	            fileMapper.removeFile(fileIdx);
	            
	            result += roomMapper.removeRoom(roomCode);
	            
	            if(result > 0) fileUtil.fileDelete(fileRootPath, filePath);
	         }
	      }else {
	         
	         result += roomMapper.removeRoom(roomCode);
	         
	      }
	      return result;
	}

	

}
