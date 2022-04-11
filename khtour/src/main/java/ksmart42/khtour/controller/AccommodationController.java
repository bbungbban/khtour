package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.Room;
import ksmart42.khtour.service.AccomReviewService;
import ksmart42.khtour.service.AccommodationService;
import ksmart42.khtour.service.RoomService;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController {

	
	private static final Logger log = LoggerFactory.getLogger(AccommodationController.class);
	

	private AccommodationService accommodationService; 
	private AccomReviewService accomReviewService;
	
	private RoomService roomService;
	
	public AccommodationController(AccommodationService accommodationService, RoomService roomService, AccomReviewService accomReviewService) {
		this.accommodationService = accommodationService;
		this.roomService = roomService;
		this.accomReviewService = accomReviewService;
	
	
	}
	/*
	 * 숙박업소 조회 페이지이동(Get 정보 전달)
	 */
	@GetMapping("/accommodationList")
	public String getAccommodationList(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(searchKey != null) {
			if("ldgName".equals(searchKey)) {
				searchKey = "ldg_name";
			}else if("ldgType".equals(searchKey)) {
				searchKey = "ldg_type";
			}else if("ldgAddr".equals(searchKey)) {
			searchKey = "ldg_addr";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		log.info("입력 데이터 값 : {}",paramMap);
		
		
		List<Accommodation> accommodationList = accommodationService.getAccommodationList(paramMap);
		
		paramMap = null;
		
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
			@RequestParam(value="ldgCode", required = false) String ldgCode
			,Model model) {
		log.info(ldgCode + "숙박업소코드");
		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);
		
		List<Room> roomList = roomService.getRoomListByldgCode(ldgCode);
		log.info(roomList + "객실리스트");
				
		List<AccomReview> reviewBydate = accomReviewService.getReviewByDate(ldgCode);
		List<AccomReview> accomoReviewList = accomReviewService.getAccomReviewList(ldgCode);
		log.info(accomoReviewList + "리뷰리스트");
		accommodationService.updateGrade(ldgCode);
		System.out.println(	accommodationService.updateGrade(ldgCode) + "update 04 011");		
		
		model.addAttribute("title", "리뷰 페이지 이동");
		model.addAttribute("accomoReviewList", accomoReviewList);
		System.out.println("리뷰 정보 get 전달" + accomoReviewList);
		
		model.addAttribute("reviewBydate", reviewBydate);
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
	public String addAccommodation(Accommodation accommodation
								   ,@RequestParam MultipartFile[] accommodationImageFiles
								   ,HttpServletRequest request) {
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		accommodationService.addAccommodation(accommodation, accommodationImageFiles, fileRealPath);
		
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
	
	@GetMapping("/accomreviewList")
	public String getaccomReviewList(
			@RequestParam(value="ldgCode", required = false)String ldgCode
			,Model model ) {
		
		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);
		
		List<AccomReview> accomoReviewList = accomReviewService.getAccomReviewList(ldgCode);
		log.info(accomoReviewList + "리뷰리스트");
		
		model.addAttribute("title", "리뷰 페이지 이동");
		model.addAttribute("accomoReviewList", accomoReviewList);
		model.addAttribute("accommodation", accommodation);
		
		return "/accomreview/accomreviewList";
	}
	
}