package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart42.khtour.dto.Exhibition;
import ksmart42.khtour.service.ExhibService;
import org.springframework.ui.Model;

@Controller
public class ExhibController {
	private ExhibService exhibService;

	public ExhibController(ExhibService exhibService) {
		this.exhibService = exhibService;
	}

	@GetMapping("/exhibition/exhibInsert")
	public String addExhibition(Model model) {
		model.addAttribute("title","특별전 등록");
		
		return "/exhibition/exhibInsert";
	}
	
	@PostMapping("/exhibition/exhibInsert")
	public String addExhibition(Exhibition exhibition) {
		
		exhibService.addExhibition(exhibition);
		return "redirect:/exhibition/exhibList";
	}

	@GetMapping("/exhibition/exhibList")
	public String getExhibList(Model model) {
		model.addAttribute("title", "특별전 검색 및 조회");

		return "/exhibition/exhibList";
	}

	@GetMapping("/exhibition/exhibModify")
	public String getExhibModify(Model model) {
		model.addAttribute("title", "특별전 수정");

		return "/exhibition/exhibModify";
	}
}
