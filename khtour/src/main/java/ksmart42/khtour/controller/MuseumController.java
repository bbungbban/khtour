package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MuseumController {
		
		@GetMapping("/museum/musInsert")
		public String getMusInsert(Model model) {
			model.addAttribute("title", "박물관 등록");
			
			return "/museum/musInsert";
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
