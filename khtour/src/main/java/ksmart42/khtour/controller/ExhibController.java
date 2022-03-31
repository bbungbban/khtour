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

import ksmart42.khtour.dto.Exhib;
import ksmart42.khtour.service.ExhibService;

@Controller
@RequestMapping("/exhib")
public class ExhibController {

	private ExhibService exhibService; 
	
	public ExhibController(ExhibService exhibService) {
		this.exhibService = exhibService;
	}
	
	/*
	 * 전시회 계획 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/exhibList")
	public String getExhibList(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Exhib> exhibList = exhibService.getExhibList(paramMap);
		
		model.addAttribute("title", "전시회 계획 관리페이지");
		model.addAttribute("exhibList", exhibList);
		
		return "exhib/exhibList";
	}
	
	/*
	 * 전시회 계획 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyExhib")
	public String modifyExhib(Exhib exhib) {
		
		exhibService.modifyExhib(exhib);
		System.out.println("정보 수정 포스트 전달" + exhibService.modifyExhib(exhib));
		
		return "redirect:/exhib/exhibList";
	}
	
	/*
	 * 전시회 계획 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/exhibModify")
	public String modifyExhib(
			@RequestParam(value="exhibCode", required = false) String exhibCode
			,Model model) {
		Exhib exhib = exhibService.getExhibByCode(exhibCode);
		
		model.addAttribute("title", "전시회 계획 수정 페이지");
		model.addAttribute("exhib", exhib);
		System.out.println("정보 수정 겟방식 전달" + exhib);
		
		return "exhib/exhibModify";
	}	
	
	/*
	 * 전시회 계획 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/exhibRemove")
	public String removeExhib(Exhib exhib) {
		String exhibCode = exhib.getExhibCode();
		
		exhibService.removeExhib(exhibCode);
		System.out.println("정보 삭제 포스트 전달" + exhibService.removeExhib(exhibCode));
		
		return "redirect:/exhib/exhibList";
		
	}
			
	/*
	 * 전시회 계획 등록(Post 정보 전달)
	 */
	@PostMapping("/exhibInsert")
	public String addExhib(Exhib exhib) {
		
		exhibService.addExhib(exhib);
		
		return "redirect:/exhib/exhibList";
	}
	/*
	 * 전시회 계획 등록(Get 정보 전달)
	 */
	@GetMapping("/exhibInsert")
	public String addExhib(Model model) {
		
		model.addAttribute("title", "전시회 계획 등록");
		
		return "exhib/exhibInsert";
	}
	
}
