package ksmart42.khtour.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunityController {

	@GetMapping("/commDashboard")
	public String commDashboard(Model model) {
		
		model.addAttribute("title", "커뮤니티 대시보드");
		
		return "/community/commDashboard";
	}
	
	@GetMapping("/createPost")
	public String createPost(Model model) {
		
		model.addAttribute("title", "커뮤니티 대시보드");
		
		return "/community/createPost";
	}
}
