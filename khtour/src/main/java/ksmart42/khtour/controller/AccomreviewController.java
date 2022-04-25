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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.service.AccomReviewService;
import ksmart42.khtour.service.AccommodationService;

@Controller
@RequestMapping("/accomreview")
public class AccomreviewController {

	private static final Logger log = LoggerFactory.getLogger(AccomreviewController.class);

	private AccommodationService accommodationService;
	private AccomReviewService accomReviewService;

	public AccomreviewController(AccomReviewService accomReviewService, AccommodationService accommodationService) {
		this.accomReviewService = accomReviewService;
		this.accommodationService = accommodationService;

	}
	/* 1. 숙박업소코드에 따른 리뷰 상세 페이지(일반회원)
	*  작성자 : 안창현
	*  입  력 : @RequestParam, Model
	*  출  력 : String (주소)
	*  설  명 : 숙박업소코드에 따른 리뷰 페이지 조회 - Get방식 전달
	*/
	@GetMapping("/accomreviewList")
	public String getaccomReviewList(Model model,
			@RequestParam(value = "ldgCode", required = false) String ldgCode) {

		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);

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
		model.addAttribute("accommodation", accommodation);
		model.addAttribute("ldgCode", ldgCode);
		model.addAttribute("avgGrade", avgGrade);
		model.addAttribute("avgCleanliness", avgCleanliness);
		model.addAttribute("avgKindness", avgKindness);
		model.addAttribute("avgConvenience", avgConvenience);
		model.addAttribute("avgLocation", avgLocation);
		model.addAttribute("avgPriceSta", avgPriceSta);


		return "/accomreview/accomreviewList";
	}

	/* 2. 숙박업소 리뷰 등록 
	*  작성자 : 안창현
	*  입  력 : Accommodation(여행게시글 리스트), RedirectAttributes
	*  출  력 : String (주소)
	*  설  명 : 숙박업소 리뷰 등록 (관리자페이지) - post방식 전달
	*/
	@PostMapping("/accomreviewList")
	public String addAccomReview(AccomReview accomReview, RedirectAttributes attr) {

		accomReviewService.addAccomReview(accomReview);
		log.info(accomReview + "리뷰 등록");

		attr.addAttribute("ldgCode", accomReview.getLdgCode());
		
		accommodationService.addReviewCnt(accomReview.getLdgCode());
		return "redirect:/accomreview/accomreviewList";
	}
	

	/* 3. 숙박업소 리뷰 삭제
	*  작성자 : 안창현
	*  입  력 : Model, @RequestParam
	*  출  력 : String (주소)
	*  설  명 : 숙박업소 리뷰 삭제 - Post방식 전달
	*/
	@PostMapping("/deleteReview")
	@ResponseBody
	public String deleteReview(@RequestParam(value="ldgReviewCode", required = false) String ldgReviewCode
	                           ,@RequestParam(value="ldgCode", required = false) String ldgCode
	                           ,Model model) 
	{
	//삭제하기
	if(ldgReviewCode != null)   accomReviewService.deleteReview(ldgReviewCode);
	      
	//select로 불러오기
	List<AccomReview> accomoReviewList = accomReviewService.getAccomReviewList(ldgCode);
	model.addAttribute("accomoReviewList", accomoReviewList);
	      
	accommodationService.subtractReviewCnt(ldgCode);
	      
	return "/accomreview/accomreviewList?ldgCode="+ldgCode;
	      
	   }
	
	/*
	 * 예약자 정보 조회(관리자)(Get 정보 전달)
	 */
	@GetMapping("/accomReviewListMy")
	public String getaccomReviewListMy(Model model) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<AccomReview> accomoReviewListMy = accomReviewService.getaccomReviewListMy(paramMap);
		log.info(accomoReviewListMy + "{}" + "예약자 정보 리스트 조회");
		model.addAttribute("accomoReviewListMy", accomoReviewListMy);
		
		return "accomreview/accomReviewListMy";
	}
}

