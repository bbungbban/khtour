package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.Room;
import ksmart42.khtour.service.AccommodationService;
import ksmart42.khtour.service.RoomService;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController {

	
	private static final Logger log = LoggerFactory.getLogger(AccommodationController.class);

	private AccommodationService accommodationService; 
	
	private RoomService roomService;
	
	public AccommodationController(AccommodationService accommodationService, RoomService roomService) {
		this.accommodationService = accommodationService;
		this.roomService = roomService;
	
	
	}
	/*
	 * 숙박업소 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/accommodationList")
	public String getAccommodationList(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Accommodation> accommodationList = accommodationService.getAccommodationList(paramMap);
		
		model.addAttribute("title", "숙박업소 관리페이지");
		model.addAttribute("accommodationList", accommodationList);
		
		return "accommodation/accommodationList";
	}
	
	/*
	 * 숙박업소 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/accommodationListSt")
	public String getAccommodationListSt(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Accommodation> accommodationList = accommodationService.getAccommodationList(paramMap);
		
		model.addAttribute("title", "숙박업소 관리페이지");
		model.addAttribute("accommodationList", accommodationList);
		
		return "accommodation/accommodationListSt";
	}
	
	/*
	 * 숙박업소 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyAccommodation")
	public String modifyAccommodation(Accommodation accommodation) {
		
		accommodationService.modifyAccommodation(accommodation);
		System.out.println("정보 수정 포스트 전달" + accommodationService.modifyAccommodation(accommodation));
		
		return "redirect:/accommodation/accommodationListSt";
	}
	
	/*
	 * 숙박업소 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/accommodationModify")
	public String modifyAccommodation(
			@RequestParam(value="ldgCode", required = false) String ldgCode
			,Model model) {
		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);
		
		model.addAttribute("title", "숙박업소 수정 페이지");
		model.addAttribute("accommodation", accommodation);
		System.out.println("정보 수정 겟방식 전달" + accommodation);
		
		return "accommodation/accommodationModify";
	}
	
	/*
	 * 숙박업소 정보 페이지(코드 번호에 따른) 조회
	 */
	@GetMapping("/acoommodationInfo")
	public String getAcoommodationInfo(
			@RequestParam(value="ldgCode", required = false) String ldgCode,
			Model model) {
		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);
		
		log.info("roomList");
		List<Room> roomList = roomService.getRoomListByldgCode(ldgCode);
		
		model.addAttribute("roomList", roomList);
		model.addAttribute("title", "숙박업소 상세 페이지");
		model.addAttribute("accommodation", accommodation);
		System.out.println("숙박업소 정보 get 전달" + accommodation);
		return "/accommodation/acoommodationInfo";
	}
	
	/*
	 * 숙박업소 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/accommodationRemove")
	public String removeAccommodation(Accommodation accommodation) {
		String ldgCode = accommodation.getLdgCode();
		
		accommodationService.removeAccommodation(ldgCode);
		System.out.println("정보 삭제 포스트 전달" + accommodationService.removeAccommodation(ldgCode));
		
		return "redirect:/accommodation/accommodationListSt";
		
	}
			
	/*
	 * 숙박업소 등록(Post 정보 전달)
	 */
	@PostMapping("/accommodationInsert")
	public String addAccommodation(Accommodation accommodation) {
		
		accommodationService.addAccommodation(accommodation);
		
		return "redirect:/accommodation/accommodationListSt";
	}
	/*
	 * 숙박업소 등록(Get 정보 전달)
	 */
	@GetMapping("/accommodationInsert")
	public String addAccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소 등록");
		
		return "accommodation/accommodationInsert";
	}
	
}