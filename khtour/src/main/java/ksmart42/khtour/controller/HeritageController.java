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

import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.service.HeritageService;

@Controller
@RequestMapping("/heritage")
public class HeritageController {

	private HeritageService heritageService;
	
	public HeritageController(HeritageService heritageService) {
		this.heritageService = heritageService;

	}
	

	/*
	 * 문화재 종목별 검색(Post 정보 전달)
	 */
	@PostMapping("/heritageListByItem")
	public String addHeritage(Heritage heritage) {
		
		heritageService.addHeritage(heritage);
		
		return "redirect:/heritage/heritageListByItem";
	}
	
	/*
	 * 문화재 종목별 검색(Get 정보 전달)
	 */
	@GetMapping("/heritageListByItem")
	public String getHeritageListByItem(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();

		List<Heritage> heritageList = heritageService.getHeritageList(paramMap);
		
		model.addAttribute("title", "문화재 종목별 검색 페이지");
		model.addAttribute("heritageList", heritageList);
		
		return "heritage/heritageListByItem";
	}
	
	/*
	 * 문화재 지도별 검색 
	 */
	@GetMapping("/heritageListByRegion")
	public String getHeritageSearchListByRegion(Model model) {
		
		model.addAttribute("title", "문화재 지도별 검색 페이지");
		
		return "/heritage/heritageListByRegion";
	}
	
	/*
	 * 문화재 지역 지도 
	 */
	@GetMapping("/heritageMap")
	public String getHeritageSearchMap(Model model) {
		
		model.addAttribute("title", "문화재 지역 지도 페이지");
		
		return "/heritage/heritageMap";
	}
	
	
	
	/*
	 * 문화재 정보 수정(Post 정보 전달)
	 */
	@PostMapping("/modifyHeritage")
	public String modifyHeritage(Heritage heritage) {
		
		heritageService.modifyHeritage(heritage);
		System.out.println("정보 수정 포스트 전달" + heritageService.modifyHeritage(heritage));
		
		return "redirect:/heritage/heritageListByItem";
	}
	
	/*
	 * 문화재 정보 수정(Get 정보 전달)
	 */
	@GetMapping("/modifyHeritage")
	public String modifyHeritage(
			@RequestParam(value="heritageCode", required = false) String heritageCode
			,Model model) {
		Heritage heritage = heritageService.getHeritageByCode(heritageCode);
		
		model.addAttribute("title", "문화재 수정 페이지");
		model.addAttribute("heritage", heritage);
		System.out.println("정보 수정 겟방식 전달" + heritage);
		
		return "heritage/modifyHeritage";
	}	
	
	/*
	 * 문화재 상세페이지(코드 번호에 따른) 조회
	 */
	@GetMapping("/heritageDetail")
	public String getHeritaDetail(
			@RequestParam(value="heritageCode", required = false) String heritageCode,
			Model model) {
		
		
		Heritage heritage = heritageService.getHeritageByCode(heritageCode);
		
		model.addAttribute("title", "문화재 상세 페이지");
		model.addAttribute("heritage", heritage);
		System.out.println("정보 수정 겟방식 전달" + heritage);
		return "/heritage/heritageDetail";
	}
	
}
