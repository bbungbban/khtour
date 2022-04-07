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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.Room;
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

	@GetMapping("/accomreviewList")
	public String getaccomReviewList(
			@RequestParam( value="ldgCode", required = false)String ldgCode
			,Model model ) {
		
		Accommodation accommodation = accommodationService.getLdgByCode(ldgCode);
		
		List<AccomReview> accomoReviewList = accomReviewService.getAccomReviewList(ldgCode);
		log.info(accomoReviewList + "리뷰리스트");
		
		model.addAttribute("title", "리뷰 페이지 이동");
		model.addAttribute("accomoReviewList", accomoReviewList);
		model.addAttribute("accommodation", accommodation);
		model.addAttribute("ldgCode", ldgCode);
		
		return "/accomreview/accomreviewList";
	}
	//리뷰 등록(post 정보 전달)
	@PostMapping("/accomreviewList")
	public String addAccomReview(AccomReview accomReview,RedirectAttributes attr) {
		
		accomReviewService.addAccomReview(accomReview);
		log.info(accomReview + "리뷰 등록");
		
		attr.addAttribute("ldgCode", accomReview.getLdgCode());
		return "redirect:/accomreview/accomreviewList";
	}
}
