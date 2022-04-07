package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.service.AccomReviewService;

@Controller
@RequestMapping("/accomreview")
public class AccomreviewController {

	private static final Logger log = LoggerFactory.getLogger(AccomreviewController.class);

	private AccomReviewService accomReviewService;

	public AccomreviewController(AccomReviewService accomReviewService) {
		this.accomReviewService = accomReviewService;
	}

	@GetMapping("/accomreviewList")
	public String getaccomReviewList(@RequestParam(value="ldgCode", required = false)String ldgCode,Model model ) {
		
		AccomReview accomoReviewList = accomReviewService.getAccomReviewList(ldgCode);
		model.addAttribute("title", "리뷰 페이지 이동");
		model.addAttribute("accomoReviewList", accomoReviewList);
		
		return "accomreview/accomreviewList";
	}
}
