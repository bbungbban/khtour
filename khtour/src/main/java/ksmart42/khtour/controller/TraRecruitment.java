package ksmart42.khtour.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class TraRecruitment {

	/*
	 * 동행자 신청 정보등록 
	 */
	@GetMapping("/traRecruitment/applicationInsert")
	public String addHeritage(Model model) {
		
		model.addAttribute("title", "동행자 신청 등록페이지");
		
		return "/traRecruitment/applicationInsert";
	}
	
	/*
	 * 동행자 신청자 리스트 조회
	 */
	@GetMapping("/traRecruitment/applicationList")
	public String getHeritageSearchListByItem(Model model) {
		
		model.addAttribute("title", "동행자 신청자 리스트");
		
		return "/traRecruitment/applicationList";
	}
	
	/*
	 * 동행자 모집 공고 등록
	 */
	@GetMapping("/traRecruitment/noticeInsert")
	public String getHeritageSearchListByRegion(Model model) {
		
		model.addAttribute("title", "동행자 모집 공고 등록페이지");
		
		return "/traRecruitment/noticeInsert";
	}
	
	/*
	 * 동행자 모집 공고 리스트
	 */
	@GetMapping("/traRecruitment/noticeList")
	public String getHeritageSearchMap(Model model) {
		
		model.addAttribute("title", "동행자 모집 공고 리스트");
		
		return "/traRecruitment/noticeList";
	}
}
