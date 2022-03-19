package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ExhibitionController {
	
	@GetMapping("/exhibition/exhibInsert")
	public String getExhibInsert(Model model) {
		model.addAttribute("title", "특별전 등록");
		
		return "/exhibition/exhibInsert";
	}
	@GetMapping("/exhibition/exhibList")
	public String getExhibList(Model model) {
		model.addAttribute("title", "특별전 검색 및 조회");
		
		return "/exhibition/exhibList";
	}
}
