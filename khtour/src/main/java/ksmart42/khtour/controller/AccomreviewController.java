package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccomreviewController {
		
	@GetMapping("/accomreview/accomreviewList")
	public String getaccomreview(Model model) {
		
		model.addAttribute("title", "리뷰리스트");
		
		return "/accomreview/accomreviewList";
	}

}
