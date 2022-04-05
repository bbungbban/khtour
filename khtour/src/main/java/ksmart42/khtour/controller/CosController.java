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

import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.service.CosService;

@Controller
@RequestMapping("/cos")
public class CosController {

	private CosService cosService; 
	
	public CosController(CosService cosService) {
		this.cosService = cosService;
	}
	
	/*
	 * 코스 계획 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/cosList")
	public String getCosList(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Cos> cosList = cosService.getCosList(paramMap);
		
		model.addAttribute("title", "코스 계획 관리페이지");
		model.addAttribute("cosList", cosList);
		
		return "cos/cosList";
	}
	
	/*
	 * 코스 계획 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyCos")
	public String modifyCos(Cos cos) {
		
		cosService.modifyCos(cos);
		System.out.println("정보 수정 포스트 전달" + cosService.modifyCos(cos));
		
		return "redirect:/cos/cosList";
	}
	
	/*
	 * 코스 계획 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/cosModify")
	public String modifyCos(
			@RequestParam(value="cosCode", required = false) String cosCode
			,Model model) {
		Cos cos = cosService.getCosByCode(cosCode);
		
		model.addAttribute("title", "코스 계획 수정 페이지");
		model.addAttribute("cos", cos);
		System.out.println("정보 수정 겟방식 전달" + cos);
		
		return "cos/cosModify";
	}	
	
	/*
	 * 코스 계획 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/cosRemove")
	public String removeCos(Cos cos) {
		String cosCode = cos.getCosCode();
		
		cosService.removeCos(cosCode);
		System.out.println("정보 삭제 포스트 전달" + cosService.removeCos(cosCode));
		
		return "redirect:/cos/cosList";
		
	}
			
	/*
	 * 코스 계획 등록(Post 정보 전달)
	 */
	@PostMapping("/cosInsert")
	public String addCos(Cos cos) {
		
		cosService.addCos(cos);
		
		return "redirect:/cos/cosList";
	}
	/*
	 * 코스 계획 등록(Get 정보 전달)
	 */
	@GetMapping("/cosInsert")
	public String addCos(Model model) {
		
		model.addAttribute("title", "코스 계획 등록");
		
		return "cos/cosInsert";
	}
	
}
