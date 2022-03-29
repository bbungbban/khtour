package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.dto.Museum;
import ksmart42.khtour.service.HeritageService;
import ksmart42.khtour.service.MusService;

@Controller
public class MusController {

	private MusService musService;

	public MusController(MusService musService) {
		this.musService = musService;
	}
	
	 @GetMapping("/musInsert")
	 public String getMusInsert(Model model) {
	 model.addAttribute("title", "박물관 등록");
	 
	 return "/museum/musInsert"; }
	 

	@GetMapping("/musList")
	public String getMusList(Model model) {
		model.addAttribute("title", "박물관 검색 및 조회");

		return "/museum/musList";
	}

	@GetMapping("/musModify")
	public String getMusModify(Model model) {
		model.addAttribute("title", "박물관 수정");

		return "/museum/musModify";
	}
}
