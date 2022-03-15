package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraPlansController {

	/*
	 * 총 여행 계획 등록
	 */
	@GetMapping("/traPlans/traPlansInsert")
	public String addRecruitment(Model model) {
		
		model.addAttribute("title", "동행자 신청 등록페이지");
		
		return "/traPlans/traPlansInsert";
	}
	
	/*
	 * 총 여행 계획 리스트 조회
	 */
	@GetMapping("/traPlans/traPlansList")
	public String addRecruitmentNotice(Model model) {
		
		model.addAttribute("title", "총 여행 계획 검색 및 리스트");
		
		return "/traPlans/traPlansList";
	}
}
