package ksmart42.khtour.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.service.CommunityService;


@Controller
public class CommunityController {
	
	private CommunityService communityService;

	public CommunityController(CommunityService communityService) {
		this.communityService = communityService;
		
	}

	@GetMapping("/commDashboard")
	public String commDashboard(Model model) {
		System.out.println("01 commDashboard CommunityController.java");
		List<Community> communityList = communityService.getCommunityList();
		System.out.println("로그1.." + communityList.toString());
		model.addAttribute("title","커뮤니티 대시보드");
		model.addAttribute("communityList", communityList);
		
		return "/community/commDashboard";
	}

	
	@GetMapping("/createPost")
	public String createPost(Model model) {
		
		model.addAttribute("title", "포스트 생성");
		
		return "/community/createPost";
	}
	@GetMapping("/post")
	public String post(Model model) {
		
		model.addAttribute("title", "포스트");
		
		return "/community/post";
	}
	@GetMapping("/commRanking")
	public String commRanking(Model model) {
		
		model.addAttribute("title", "전체커뮤니티");
		List<Community> communityList = communityService.getCommunityList();
		model.addAttribute("communityList", communityList);
		
		return "/community/commRanking";
	}
	@GetMapping("/commPage")
	public String commPage(Model model,@RequestParam(value = "commCode") String commCode) {
		
		Community community = communityService.getCommunityByCode(commCode);
		List<Rule> ruleList = communityService.getRuleListByCommCode(commCode);
		System.out.println("규칙 리스트 :  " + ruleList);
		model.addAttribute("community",community);
		model.addAttribute("title", "커뮤니티페이지");
		model.addAttribute("ruleList", ruleList);
		return "/community/commPage";
	}
}
