package ksmart42.khtour.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ksmart42.khtour.dto.Museum;
import ksmart42.khtour.service.MusService;

@Controller
public class MusController {
	private MusService musService;

	public MusController(MusService musService) {
		this.musService = musService;
	}

	@GetMapping("/museum/musInsert")
	public String addMuseum(Model model) {
		model.addAttribute("title","박물관 등록");
		
		return "/museum/musInsert";
	}
	
	@PostMapping("/museum/musInsert")
	public String addMuseum(Museum museum) {
		
		musService.addMuseum(museum);
		System.out.println(museum);
		return "redirect:/museum/musList";
	}

	@GetMapping("/museum/musList")
	public String getMusList(Model model) {
		model.addAttribute("title", "박물관 검색 및 조회");

		return "/museum/musList";
	}

	@GetMapping("/museum/musModify")
	public String getMusModify(Model model) {
		model.addAttribute("title", "박물관 수정");

		return "/museum/musModify";
	}
}
