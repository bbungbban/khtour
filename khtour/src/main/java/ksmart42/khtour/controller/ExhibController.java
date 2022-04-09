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
import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.service.ExhibService;

@Controller
@RequestMapping("/exhib")
public class ExhibController {

	private ExhibService exhibService; 
	
	public ExhibController(ExhibService exhibService) {
		this.exhibService = exhibService;
	}
	
	/*
	 * 전시회 수정 및 조회 페이지 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/exhibList")
	public String getExhibList(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(searchKey != null) {
			if("exhibCode".equals(searchKey)) {
				searchKey = "exhib_code";
			}else if("exhibCateName".equals(searchKey)) {
				searchKey = "exhib_cate_name";
			}else if("exhibName".equals(searchKey)) {
				searchKey = "exhib_name";
			}else if("exhibCon".equals(searchKey)) {
			searchKey = "exhib_con";
			}else if("musCode".equals(searchKey)) {
				searchKey = "mus_code";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		List<Exhib> exhibList = exhibService.getExhibList(paramMap);
		
		paramMap = null;
		
		model.addAttribute("title", "전시회 수정 및 조회 페이지");
		model.addAttribute("exhibList", exhibList);
		return "exhib/exhibList";
	}	
	/*
	 * 전시회 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyExhib")
	public String modifyExhib(Exhib exhib) {
		
		if (exhib.getExhibCateName().equals("테마전시")) {
			exhib.setExhibCate("exhib_theme");
		} else if (exhib.getExhibCateName().equals("특별전시")) {
			exhib.setExhibCate("exhib_special");
		}
		exhibService.modifyExhib(exhib);
		System.out.println("정보 수정 포스트 전달" + exhibService.modifyExhib(exhib));
		return "redirect:/exhib/exhibList";
	}
	
	/*
	 * 전시회 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/exhibModify")
	public String modifyExhib(
			@RequestParam(value="exhibCode", required = false) String exhibCode
			,Model model) {
		Exhib exhib = exhibService.getExhibByCode(exhibCode);
		
		model.addAttribute("title", "전시회 수정 페이지");
		model.addAttribute("exhib", exhib);
		System.out.println("정보 수정 겟방식 전달" + exhib);
		
		return "exhib/exhibModify";
	}	
	
	/*
	 * 전시회 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/exhibRemove")
	public String removeExhib(Exhib exhib) {
		String exhibCode = exhib.getExhibCode();
		
		exhibService.removeExhib(exhibCode);
		System.out.println("정보 삭제 포스트 전달" + exhibService.removeExhib(exhibCode));
		
		return "redirect:/exhib/exhibList";
		
	}
			
	/*
	 * 전시회 등록(Post 정보 전달)
	 */
	@PostMapping("/exhibInsert")
	public String addExhib(Exhib exhib) {
		if(exhib.getExhibCate().equals("exhib_theme")) {
			exhib.setExhibCateName("테마전시");
		} else if(exhib.getExhibCate().equals("exhib_special")) {
			exhib.setExhibCateName("특별전시");
		}
		exhibService.addExhib(exhib);
		
		return "redirect:/exhib/exhibList";
	}
	/*
	 * 전시회 등록(Get 정보 전달)
	 */
	@GetMapping("/exhibInsert")
	public String addExhib(Model model) {
		
		model.addAttribute("title", "전시회  등록");
		
		return "exhib/exhibInsert";
	}
	
}
