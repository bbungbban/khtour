package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(AccommodationController.class);

	public CosController(CosService cosService) {
		this.cosService = cosService;
	}
	/* 
	 * 2. 코스 조회 (유저 권한)
	*/
	@GetMapping("/cosBoardList")
	public String getRecordBoardList(Model model) {
		//Map<String, Object> paramMap = new HashMap<String, Object>();

		//List<CosBoard> cosBoardService = cosBoardService.getCosBoardList(paramMap);

		model.addAttribute("title", "코스 조회 페이지");
		//model.addAttribute("cosBoardService", cosBoardService);

		return "cos/cosBoardList";
	}
	/*
	 * 코스  조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/cosList")
	public String getCosList(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Cos> cosList = cosService.getCosList(paramMap);
		
		model.addAttribute("title", "코스 관리페이지");
		model.addAttribute("cosList", cosList);
		
		return "cos/cosList";
	}
	
	@GetMapping("/cosCate")
	public String getCosCate(Model model) {
		model.addAttribute("title", "코스 관리페이지");
		return "cos/cosCate";
	}
	
	/*
	 * 코스 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyCos")
	public String modifyCos(Cos cos) {
		
		cosService.modifyCos(cos);
		System.out.println("정보 수정 포스트 전달" + cosService.modifyCos(cos));
		
		return "redirect:/cos/cosList";
	}
	
	/*
	 * 코스 정보 수정 (관리자) (Get 정보 전달)
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
	 * 코스 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/cosRemove")
	public String removeCos(Cos cos) {
		String cosCode = cos.getCosCode();
		
		cosService.removeCos(cosCode);
		System.out.println("정보 삭제 포스트 전달" + cosService.removeCos(cosCode));
		
		return "redirect:/cos/cosList";
		
	}
			
	/*
	 * 코스 등록(Post 정보 전달)
	 */
	@PostMapping("/cosInsert")
	public String addCos(Cos cos) {
		
		if (cos.getThemeCategory().equals("선사시대")){cos.setThemeCategoryCode("theme_cate_code001");} 
		else if (cos.getThemeCategory().equals("석기시대")){cos.setThemeCategoryCode("theme_cate_code002");} 
		else if (cos.getThemeCategory().equals("청동기시대")){cos.setThemeCategoryCode("theme_cate_code003");} 
		else if (cos.getThemeCategory().equals("철기시대")){cos.setThemeCategoryCode("theme_cate_code004");} 
		else if (cos.getThemeCategory().equals("삼한시대")){cos.setThemeCategoryCode("theme_cate_code005");} 
		else if (cos.getThemeCategory().equals("삼국시대")){cos.setThemeCategoryCode("theme_cate_code006");} 
		else if (cos.getThemeCategory().equals("발해")){cos.setThemeCategoryCode("theme_cate_code007");} 
		else if (cos.getThemeCategory().equals("통일신라")){cos.setThemeCategoryCode("theme_cate_code008");} 
		else if (cos.getThemeCategory().equals("고려시대")){cos.setThemeCategoryCode("theme_cate_code009");}
		else if (cos.getThemeCategory().equals("조선시대")){cos.setThemeCategoryCode("theme_cate_code010");}
		else if (cos.getThemeCategory().equals("대한제국시대")){cos.setThemeCategoryCode("theme_cate_code011");}
		else if (cos.getThemeCategory().equals("일제강점기")){cos.setThemeCategoryCode("theme_cate_code012");} 
		else if (cos.getThemeCategory().equals("시대미상")){cos.setThemeCategoryCode("theme_cate_code013");} 
		cosService.addCos(cos);
		
		return "redirect:/cos/cosList";
	}
	/*
	 * 코스 등록(Get 정보 전달)
	 */
	@GetMapping("/cosInsert")
	public String addCos(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		List<Cos> cosInsert = cosService.categoryList(paramMap);

		model.addAttribute("title", "코스등록");
		model.addAttribute("cosInsert", cosInsert);
		
		return "cos/cosInsert";
	}
}
