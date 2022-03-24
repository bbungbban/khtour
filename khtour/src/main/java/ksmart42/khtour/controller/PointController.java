package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {

	@GetMapping("/point/pointList")
	public String getPointbList(Model model) {
		model.addAttribute("title", "포인트 조회");

		return "/point/pointList"; 
	}
	
	@GetMapping("/point/adPointList")
	public String getAdPointList(Model model) {
		model.addAttribute("title", "포인트 현황 조회");

		return "/point/adPointList";
	}
	
	@GetMapping("/point/adPointCList")
	public String getAdPointCList(Model model) {
		model.addAttribute("title", "포인트 적립 및 사용 내역");
		
		return "/point/adPointCList";
	}
}
