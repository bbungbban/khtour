package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.service.HeritageService;

@Controller
@RequestMapping("/heritage")
public class HeritageController {

	private HeritageService heritageService;
	
	public HeritageController(HeritageService heritageService) {
		this.heritageService = heritageService;

	}
	

	
	@PostMapping("/heritageListByItem")
	public String addHeritage(Heritage heritage) {
		
		heritageService.addHeritage(heritage);
		
		return "redirect:/heritage/heritageListByItem";
	}
	
	/*
	 * 문화재 종목별 검색 
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
	 * 문화재 상세 페이지 이동
	 */
	@GetMapping("/heritageDetail")
	public String getHeritageDetail(Model model) {
		
		model.addAttribute("title", "문화재 상세 페이지");
		
		return "/heritage/heritageDetail";
	}	
}
