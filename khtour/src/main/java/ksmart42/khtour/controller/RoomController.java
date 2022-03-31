package ksmart42.khtour.controller;


import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.Room;
import ksmart42.khtour.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {

	private RoomService roomService; 
	
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	/*
	 * 여행 계획 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/roomListSt")
	public String getRoomListSt(Model model) {
		
		List<Room> roomList = roomService.getRoomList();
		
		model.addAttribute("title", "객실 계획 관리페이지");
		model.addAttribute("roomList", roomList);
		
		return "room/roomListSt";
	}
	
	/*
	 * 여행 계획 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyRoom")
	public String modifyRoom(Room room) {
		
		roomService.modifyRoom(room);
		System.out.println("정보 수정 포스트 전달" + roomService.modifyRoom(room));
		
		return "redirect:/room/roomListSt";
	}
	
	/*
	 * 여행 계획 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/roomModify")
	public String modifyRoom(
			@RequestParam(value="roomCode", required = false) String roomCode
			,Model model) {
		Room room = roomService.getRoomByCode(roomCode);
		
		model.addAttribute("title", "여행 계획 수정 페이지");
		model.addAttribute("room", room);
		System.out.println("정보 수정 겟방식 전달" + room);
		
		return "room/roomModify";
	}	
	
	/*
	 * 여행 계획 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/roomRemove")
	public String removeRoom(Room room) {
		String roomCode = room.getRoomCode();
		
		roomService.removeRoom(roomCode);
		System.out.println("정보 삭제 포스트 전달" + roomService.removeRoom(roomCode));
		
		return "redirect:/room/roomListSt";
		
	}
			
	/*
	 * 여행 계획 등록(Post 정보 전달)
	 */
	@PostMapping("/roomInsert")
	public String addRoom(Room room) {
		
		roomService.addRoom(room);
		
		return "redirect:/room/roomListSt";
	}
	/*
	 * 여행 계획 등록(Get 정보 전달)
	 */
	@GetMapping("/roomInsert")
	public String addRoom(Model model, 
			 @RequestParam(value = "ldgCode") String ldgCode
			,@RequestParam(value = "ldgName") String ldgName) {
		
		model.addAttribute("ldgCode", ldgCode);
		model.addAttribute("ldgName", ldgName);
		model.addAttribute("title", "여행 계획 등록");
		
		
		return "room/roomInsert";
	}
	
}
