package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ExhibitionController {
	
	@GetMapping("/exhibition/exhibInsert")
	public String getExhibInsert(Model model) {
		model.addAttribute("title", "문화재 종목별 검색 페이지");
		
		return "/exhibition/exhibInsert";
		
	}
	
}
