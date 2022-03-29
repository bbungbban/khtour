package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/accommodation")
public class AccommodationController {
	
	/*
	 * 숙박업소 등록	
	 * */
	@GetMapping("/accommodationInsert")
	public String addaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소등록");
		
		return "/accommodation/accommodationInsert";
	}
	
	/*
	 * 숙박업소 리스트 검색 페이지
	 * */
	@GetMapping("/accommodationList")
	public String getaccommodation(Model model) {
		
		
		model.addAttribute("title", "숙박업소검색");
		
		return "/accommodation/accommodationList";
	}
	
	/*
	 * 숙박업소정보 수정
	 * */
	@GetMapping("/accommodationModify")
	public String modifyaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소정보 수정");
		
		return "/accommodation/accommodationModify";
	}
	
	/*
	 * 숙박업소 삭제
	 * */
	@GetMapping("/accommodationDelete")
	public String deleteaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소 삭제");
		
		return "/accommodation/accommodationDelete";
	}
	
	/*
	 *숙박업소 정보
	 * */
	@GetMapping("/acoommodationInfo")
	public String Infoaccommodation(Model model) {
		
		model.addAttribute("title", "숙박업소 정보");
		
		return "/accommodation/acoommodationInfo";
	}
}
