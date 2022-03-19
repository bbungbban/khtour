package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {
	@GetMapping("/point/pointInsert")
	public String getInsert(Model model) {
		model.addAttribute("title","포인트 규정 등록");

		return "/point/pointInsert";
	}

	@GetMapping("/point/pointList")
	public String getPointbList(Model model) {
		model.addAttribute("title", "회원 포인트 검색 및 조회");

		return "/point/pointList"; 
	}
	
	@GetMapping("/point/pointAlram")
	public String getPointAlram(Model model) {
		model.addAttribute("title", "포인트 알림주기 설정");

		return "/point/pointAlram";
	}
}
