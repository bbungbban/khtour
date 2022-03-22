package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TraWhetherController {
	
	/*
	 * 지역별 날씨 리스트 
	 */
	@GetMapping("/traWhether/traWhetherList")
	public String getWhetherList(Model model) {
		
		model.addAttribute("title", "지역별 날씨 정보 페이지");
		
		return "/traWhether/traWhetherList";
	}
	
	/*
	 * 지역별 날씨 정보 등록
	 */
	@GetMapping("/traWhether/traWhetherInsert")
	public String addWhether(Model model) {
		
		model.addAttribute("title", "날씨 정보 등록 페이지");
		
		return "/traWhether/traWhetherInsert";
	}
	
	/*
	 * 지역별 날씨 정보 수정
	 */
	@GetMapping("/traWhether/traWhetherModify")
	public String modifyWhether(Model model) {
		
		model.addAttribute("title", "날씨 정보 수정 페이지");
		
		return "/traWhether/traWhetherModify";
	}
}
