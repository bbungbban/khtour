package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.service.MusService;

@Controller
@RequestMapping("/mus")
public class MusController {

	private MusService musService; 
	
	public MusController(MusService musService) {
		this.musService = musService;
	}
	
	/*
	 * 박물관 조회 및 수정
	 */
	@GetMapping("/musList")
	public String getMusList(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Mus> musList = musService.getMusList(paramMap);
		
		model.addAttribute("title", "박물관 조회 및 수정");
		model.addAttribute("musList", musList);
		
		return "mus/musList";
	}
	
	/*
	 * 박물관 계획 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyMus")
	public String modifyMus(Mus mus) {
		
		musService.modifyMus(mus);
		System.out.println("정보 수정 포스트 전달" + musService.modifyMus(mus));
		
		return "redirect:/mus/musList";
	}
	
	/*
	 * 박물관 계획 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/musModify")
	public String modifyMus(
			@RequestParam(value="musCode", required = false) String musCode
			,Model model) {
		Mus mus = musService.getMusByCode(musCode);
		
		model.addAttribute("title", "박물관 계획 수정 페이지");
		model.addAttribute("mus", mus);
		System.out.println("정보 수정 겟방식 전달" + mus);
		
		return "mus/musModify";
	}	
	
	/*
	 * 박물관 계획 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/musRemove")
	public String removeMus(Mus mus) {
		String musCode = mus.getMusCode();
		
		musService.removeMus(musCode);
		System.out.println("정보 삭제 포스트 전달" + musService.removeMus(musCode));
		
		return "redirect:/mus/musList";
		
	}
			
	/*
	 * 박물관 계획 등록(Post 정보 전달)
	 */
	@PostMapping("/musInsert")
	public String addMus(Mus mus) {
		
		musService.addMus(mus);
		
		return "redirect:/mus/musList";
	}
	/*
	 * 박물관 계획 등록(Get 정보 전달)
	 */
	@GetMapping("/musInsert")
	public String addMus(Model model) {
		
		model.addAttribute("title", "박물관 계획 등록");
		
		return "mus/musInsert";
	}
	
}
