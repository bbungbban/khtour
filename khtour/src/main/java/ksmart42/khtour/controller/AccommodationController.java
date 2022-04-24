package ksmart42.khtour.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.Room;
import ksmart42.khtour.mapper.AccommodationMapper;
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
	private AccommodationMapper accommodationMapper;

	
	public AccommodationController(AccommodationService accommodationService, RoomService roomService, AccomReviewService accomReviewService, AccommodationMapper accommodationMapper) {
		this.accommodationService = accommodationService;
		this.roomService = roomService;
		this.accomReviewService = accomReviewService;
		this.accommodationMapper = accommodationMapper;
	
	}
	/* 1. 숙박업소 리스트 페이지(일반회원)
	*  작성자 : 안창현
	*  입  력 : Model, searchKey 검색키워드 종류, searchValue 검색키워드 값
	*  출  력 : String(주소)
	*  설  명 : 숙박업소 리스트 조회, 키워드별 검색 기능  - get방식 전달
	*/
	@GetMapping("/accommodationList")
	public String getAccommodationList(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue
			,@RequestParam(value="ldgCode", required = false) String ldgCode) {
		
		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);
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
		String avgGrade = accommodationService.avgGrade(ldgCode);
		
		
		List<Accommodation> accommodationList = accommodationService.getAccommodationList(paramMap);
		
		paramMap = null;
		
		model.addAttribute("title", "숙박업소 관리페이지");
		model.addAttribute("accommodation", accommodation);
		model.addAttribute("accommodationList", accommodationList);
		model.addAttribute("avgGrade", avgGrade);
		
		return "accommodation/accommodationList";
	}
	
	/* 2. 숙박업소 리스트 페이지 (관리자)
	*  작성자 : 안창현
	*  입  력 : Model, searchKey 검색키워드 종류, searchValue 검색키워드 값
	*  출  력 : String(주소)
	*  설  명 : 숙박업소 리스트 조회, 키워드별 검색 기능  - get방식 전달
	*/
	@GetMapping("/accommodationListSt")
	public String getAccommodationListSt(Model model
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
		
		model.addAttribute("title", "숙박업소 관리페이지");
		model.addAttribute("accommodationList", accommodationList);
		
		return "accommodation/accommodationListSt";
	}
	

	/* 3. 숙박업소 정보 수정 (관리자 권한)
	*  작성자 : 안창현
	*  입  력 : Accommodation(숙박업소 리스트)
	*  출  력 : String (주소)
	*  설  명 : 숙박업소 정보 수정(관리자페이지) - Post방식
	*/
	@PostMapping("/modifyAccommodation")
	public String modifyAccommodation(Accommodation accommodation) {
		
		accommodationService.modifyAccommodation(accommodation);
		System.out.println("정보 수정 포스트 전달" + accommodationService.modifyAccommodation(accommodation));
		
		return "redirect:/accommodation/accommodationListSt";
	}
	
	/* 4. 숙박업소 정보 수정 (관리자 권한)
	*  작성자 : 안창현
	*  입  력 : @RequestParam, Model
	*  출  력 : String (주소)
	*  설  명 : 숙박업소 코드에 따른 게시글 정보 수정(관리자페이지) - Get방식 전달
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
	
	/* 4. 숙박업소 상세 페이지(일반회원)
	*  작성자 : 안창현
	*  입  력 : @RequestParam, Model
	*  출  력 : String (주소)
	*  설  명 : 숙박업소 코드에 따른 상세페이지 조회 - Get방식 전달
	*/
	@GetMapping("/acoommodationInfo")
	public String getAcoommodationInfo(
			@RequestParam(value="ldgCode", required = false) String ldgCode
			,Model model) {
		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);
		log.info(ldgCode + "숙박업소코드");
		
		List<Room> roomList = roomService.getRoomListByldgCode(ldgCode);
		log.info(roomList + "객실리스트");
				
		List<AccomReview> reviewBydate = accomReviewService.getReviewByDate(ldgCode);
		List<AccomReview> accomoReviewList = accomReviewService.getAccomReviewList(ldgCode);
		log.info(accomoReviewList + "리뷰리스트");	
		
		String avgGrade = accommodationService.avgGrade(ldgCode);
		String avgCleanliness = accommodationService.avgCleanliness(ldgCode);
		String avgKindness = accommodationService.avgKindness(ldgCode);
		String avgConvenience = accommodationService.avgConvenience(ldgCode);
		String avgLocation = accommodationService.avgLocation(ldgCode);
		String avgPriceSta = accommodationService.avgPriceSta(ldgCode);
		
		model.addAttribute("title", "리뷰 페이지 이동");
		model.addAttribute("accomoReviewList", accomoReviewList);
		System.out.println("리뷰 정보 get 전달" + accomoReviewList);
		
		model.addAttribute("reviewBydate", reviewBydate);
		model.addAttribute("roomList", roomList);
		model.addAttribute("title", "숙박업소 상세 페이지");
		model.addAttribute("accommodation", accommodation);
		System.out.println("숙박업소 정보 get 전달" + accommodation);
		model.addAttribute("avgGrade", avgGrade);
		log.info(avgGrade + "평균");
		model.addAttribute("avgCleanliness", avgCleanliness);
		log.info(avgCleanliness + "평균");
		model.addAttribute("avgKindness", avgKindness);
		log.info(avgKindness + "평균");
		model.addAttribute("avgConvenience", avgConvenience);
		log.info(avgConvenience + "평균");
		model.addAttribute("avgLocation", avgLocation);
		log.info(avgLocation + "평균");
		model.addAttribute("avgPriceSta", avgPriceSta);
		log.info(avgPriceSta + "평균");
		
		return "/accommodation/acoommodationInfo";
	}
	
	/* 5. 숙박업소 정보 삭제 (관리자 권한)
	*  작성자 : 안창현
	*  입  력 : Accommodation(숙박업소리스트), HttpServletRequest
	*  출  력 : String (주소)
	*  설  명 : 숙박업소코드에 따른  정보삭제, 사진 파일 삭제(관리자페이지) - Get방식 전달
	*/
	@GetMapping("/accommodationRemove")
	public String removeAccommodation(Accommodation accommodation, HttpServletRequest request) throws IOException {
		String ldgCode = accommodation.getLdgCode();
		
		String serverName = request.getServerName();
	    String fileRealPath = "";
	      if("localhost".equals(serverName)) {            
	         fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
	         //fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }else {
	         fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
	      }
	    int result = accommodationService.removeRoomByrCode(ldgCode);
	    result += accommodationService.removeReviewByrCode(ldgCode);
	    result += accommodationService.removeReservationByrCode(ldgCode);
	    result += accommodationService.removeAccommodation(ldgCode, fileRealPath);
		
		
		System.out.println("정보 삭제 포스트 전달" + result);
		
		return "redirect:/accommodation/accommodationListSt";
		
	}
			
	/* 6. 숙박업소 등록 (관리자 권한)
	*  작성자 : 안창현
	*  입  력 : Accommodation(여행게시글 리스트), @RequestParam, HttpServletRequest
	*  출  력 : String (주소)
	*  설  명 : 숙박업소 정보 등록(관리자페이지), 사진 파일 등록 - post방식 전달
	*/
	@PostMapping("/accommodationInsert")
	public String addAccommodation(Accommodation accommodation
								   ,@RequestParam MultipartFile[] accommodationImageFiles
								   ,HttpServletRequest request) {
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		accommodationService.addAccommodation(accommodation, accommodationImageFiles, fileRealPath);
		
		return "redirect:/accommodation/accommodationListSt";
	}

	/* 7. 숙박업소명 중복체크 (관리자 권한)
	*  작성자 : 안창현
	*  입  력 : @RequestParam, ldgName
	*  출  력 : boolean(중복 체크 후 true 또는  false)
	*  설  명 : 숙박업소 명 중복체크- post방식 전달
	*/
	  @PostMapping("/isNameCheck")
	  @ResponseBody 
	  public boolean isNameCheck(@RequestParam(value = "ldgName") String ldgName) { 
		  boolean isNameCheck = false;
		  log.info("숙박업소 체크 클릭시 요청 받는 ldgName 값 : {}", ldgName);
	  
		  boolean result = accommodationMapper.isNameCheck(ldgName);
		  if(result) isNameCheck = true;
		  
		  log.info("숙박업소  중복 체크 여부 : {}", result);
		  return isNameCheck;
	  }
	
	  /* 8. 숙박업소 등록 페이지 (관리자 권한)
		*  작성자 : 안창현
		*  입  력 : Model
		*  출  력 : String
		*  설  명 : 숙박업소 등록페이지 - Get방식 전달
		*/
	@GetMapping("/accommodationInsert")
	public String addAccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소 등록");
		
		return "accommodation/accommodationInsert";
	}
	
	/* 9. 숙박업소 코드에 따른 리뷰살세페이지
	*  작성자 : 안창현
	*  입  력 : Model, @RequestParam
	*  출  력 : String
	*  설  명 : 숙박업소 코드에 따른 리뷰 상세페이지 이동 - Get방식 전달
	*/
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