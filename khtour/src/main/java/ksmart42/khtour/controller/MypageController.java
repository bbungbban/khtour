package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart42.khtour.service.RecordBoardService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private RecordBoardService recordBoardService;
	
	@GetMapping("/mypage")
	public String getPayInsert(Model model) {
		
		model.addAttribute("title", "결제 정보 등록 페이지");
		
		return "/mypage/mypage";
	}
}
