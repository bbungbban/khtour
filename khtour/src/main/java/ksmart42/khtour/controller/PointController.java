package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/point")
public class PointController {

	@GetMapping("/adPointInsert")
	public String getAdPointInsert(Model model) {
		model.addAttribute("title", "포인트 규정 등록");

		return "/point/adPointInsert"; 
	}
	
	@GetMapping("/pointList")
	public String getPointList(Model model) {
		model.addAttribute("title", "포인트 조회");

		return "/point/pointList"; 
	}
	
	@GetMapping("/adPointList")
	public String getAdPointList(Model model) {
		model.addAttribute("title", "포인트 현황 조회");

		return "/point/adPointList";
	}
	
	@GetMapping("/adPointCList")
	public String getAdPointCList(Model model) {
		model.addAttribute("title", "포인트 적립 및 사용 내역");
		
		return "/point/adPointCList";
	}
}
