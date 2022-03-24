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
	 * 지역별 날씨 리스트 
	 */
	@GetMapping("/traWhether/test")
	public String gettestt(Model model) {
		
		model.addAttribute("title", "지역별 날씨 정보 페이지");
		
		return "/traWhether/test";
	}
}
