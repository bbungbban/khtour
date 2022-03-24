package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ksmart42.khtour.service.ExhibService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/exhibition")
public class ExhibController {
	
	@GetMapping("/exhibInsert")
	public String getExhibInsert(Model model) {
		model.addAttribute("title", "특별전 등록");
		
		return "/exhibition/exhibInsert";
	}
	
	@GetMapping("/exhibList")
	public String getExhibList(Model model) {
		model.addAttribute("title", "특별전 검색 및 조회");
		
		return "/exhibition/exhibList";
	}

	@GetMapping("/exhibModify")
	public String getExhibModify(Model model) {
		model.addAttribute("title", "특별전 수정");
		
		return "/exhibition/exhibModify";
	}
}
