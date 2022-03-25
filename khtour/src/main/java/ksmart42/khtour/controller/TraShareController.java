package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraShareController {
	/*
	 * 여행기록 공유 게시판 등록
	 */
	@GetMapping("/traShare/traShareInsert")
	public String addRecruitment(Model model) {
		
		model.addAttribute("title", "여행 기록 공유 게시판 등록 페이지");
		
		return "/traShare/traShareInsert";
	}
	/*
	 * 여행기록 공유 게시판 수정
	 */
	@GetMapping("/traShare/traShareModify")
	public String modifyRecruitment(Model model) {
		
		model.addAttribute("title", "여행 기록 공유 게시판 등록 페이지");
		
		return "/traShare/traShareModify";
	}
	
	/*
	 * 여행기록 공유 게시판 리스트
	 */
	@GetMapping("/traShare/traShareList")
	public String getTraShareList(Model model) {
		
		model.addAttribute("title", "여행 기록 공유 게시판 리스트");
		
		return "/traShare/traShareList";
	}

	/*
	 * 여행기록 상세  페이지 이동
	 */
	@GetMapping("/traShare/traDetail")
	public String getTraDetail(Model model) {
		
		model.addAttribute("title", "여행 기록 공유 게시판 리스트");
		
		return "/traShare/traDetail";
	}
	
	/*
	 * 여행기록 상세  페이지 이동(관리자)
	 */
	@GetMapping("/traShare/traShareListSt")
	public String getTraShareListSt(Model model) {
		
		model.addAttribute("title", "여행 기록 공유 게시판 리스트(관리자)");
		
		return "/traShare/traShareListSt";
	}
	
}
