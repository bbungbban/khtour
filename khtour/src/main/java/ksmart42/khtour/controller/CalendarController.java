package ksmart42.khtour.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ksmart42.khtour.service.CalenService;


@Controller
public class CalendarController {
	
	 /* 캘린더 테스트 겟 매핑
	 */
	@GetMapping("/traPlans/trafullcalendar")
	public String getTraShareList(Model model) {
		
		model.addAttribute("title", "여행 기록 공유 게시판 리스트");
		
		return "/traPlans/trafullcalendar";
	}
	
	@Autowired(required = false) 
	private CalenService service;
	
	
	@GetMapping(params="method=list") 
	public String list() { 
		return "trafullcalendar"; 
		
	}
	@GetMapping(params = "method=data") 
	public String data(Model d) { 
		d.addAttribute("list", service.calenList()); 
		return "pageJsonReport";
		}
}

