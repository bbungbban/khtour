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
	 * 문화재 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/heritageListSt")
	public String getHeritageListSt(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(searchKey != null) {
				if("memberId".equals(searchKey)) {
					searchKey = "member_id";
				}else if("heritageName".equals(searchKey)) {
					searchKey = "heritage_name";
			}
		}
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
	
		
		
		List<Heritage> heritageList = heritageService.getHeritageList(paramMap);
		
		paramMap = null;
		
		model.addAttribute("title", "문화재 종목별 검색 페이지");
		model.addAttribute("heritageList", heritageList);
		
		return "heritage/heritageListSt";
	}
	
	
	
	/*
	 * 문화재 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyHeritage")
	public String modifyHeritage(Heritage heritage) {
		
		heritageService.modifyHeritage(heritage);
		System.out.println("정보 수정 포스트 전달" + heritageService.modifyHeritage(heritage));
		
		return "redirect:/heritage/heritageListSt";
	}
	
	/*
	 * 문화재 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/heritageModify")
	public String modifyHeritage(
			@RequestParam(value="heritageCode", required = false) String heritageCode
			,Model model) {
		Heritage heritage = heritageService.getHeritageByCode(heritageCode);
		
		model.addAttribute("title", "문화재 수정 페이지");
		model.addAttribute("heritage", heritage);
		System.out.println("정보 수정 겟방식 전달" + heritage);
		
		return "heritage/heritageModify";
	}	
	
	/*
	 * 문화재 정보 삭제(post 정보 전달) (관리자)
	 */
	@GetMapping("/heritageRemove")
	public String removeHeritage(Heritage heritage) {
		String heritageCode = heritage.getHeritageCode();
		
		heritageService.removeHeritage(heritageCode);
		System.out.println("정보 삭제 포스트 전달" + heritageService.removeHeritage(heritageCode));
		
		return "redirect:/heritage/heritageListSt";
		
	}
	
	
	
	
	
	
	
	
	
	
/////////////////////////////////////////////////////	
	
	
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
	 * 문화재 종목별 정보 등록(Post 정보 전달)
	 */
	@PostMapping("/heritageListByItem")
	public String addHeritage(Heritage heritage) {
		
		heritageService.addHeritage(heritage);
		
		return "redirect:/heritage/heritageListByItem";
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
