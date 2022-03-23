package ksmart42.khtour.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.mapper.CommunityMapper;
import ksmart42.khtour.service.CommunityService;


@Controller
public class CommunityController {
	private static final Logger log = LoggerFactory.getLogger(CommunityController.class);
	private CommunityService communityService;
	private CommunityMapper communityMapper;

	public CommunityController(CommunityService communityService,CommunityMapper communityMapper) {
		this.communityService = communityService;
		this.communityMapper = communityMapper;
	}
	
	@PostMapping("/commNameCheck")
	@ResponseBody
	public boolean commNameCheck(@RequestParam(value = "commName") String commName)
	{
		boolean nameCheck = false;
		boolean result = communityMapper.commNameCheck(commName);
		nameCheck= result;
		log.info("커뮤니티 이름중복체크 여부: {}",result);
		return nameCheck;
	}	

	@GetMapping("/commDashboard")
	public String commDashboard(Model model) {
		System.out.println("01 commDashboard CommunityController.java");
		List<Community> communityList = communityService.getCommunityList();
		System.out.println("로그1.." + communityList.toString());
		model.addAttribute("title","커뮤니티 대시보드");
		model.addAttribute("communityList", communityList);
		
		return "community/commDashboard";
	}

	
	@GetMapping("/createPost")
	public String createPost(Model model) {
		
		model.addAttribute("title", "포스트 생성");
		
		return "community/createPost";
		
	}
	@GetMapping("/addCommunity")
	public String createCommunity(Model model) {
		
		model.addAttribute("title", "커뮤니티 생성");
		
		return "community/addCommunity";
	}
	
	@PostMapping("/addCommunity")
	public String addCommunity(RedirectAttributes reAttr,Community community) {
		
		community.setMemberCnt("1");
		community.setOnlineMemberCnt("0");
		community.setMemberId("id001");
		
		communityService.addCommunity(community);

		
		reAttr.addAttribute("commName",community.getCommName());
		return "redirect:/commPage";
		
	}
	
	@PostMapping("/addRule")
	public String addRule(RedirectAttributes reAttr,Rule rule) {
		
		communityService.addRule(rule);
		
		reAttr.addAttribute("commName",rule.getCommName());
		
		return "redirect:/commPage";
		
	}
	
	@PostMapping("/addTag")
	public String addTag(RedirectAttributes reAttr,CommTag commTag) {
		
		String color = commTag.getTagColor();
		if(color.equals("파랑색"))
		{
			commTag.setTagColor("primary");
		}
		else if(color.equals("빨강색"))
		{
			commTag.setTagColor("danger");
		}
		else if(color.equals("노랑색"))
		{
			commTag.setTagColor("warning");
		}
		else if(color.equals("하늘색"))
		{
			commTag.setTagColor("info");
		}
		else if(color.equals("초록색"))
		{
			commTag.setTagColor("success");
		}
		else if(color.equals("검은색"))
		{
			commTag.setTagColor("dark");
		}
		else if(color.equals("회색"))
		{
			commTag.setTagColor("light");
		}
		
		commTag.setMemberId("id001");
		
		communityService.addTag(commTag);
		

		
		
		
		
		
		
		
		reAttr.addAttribute("commName",commTag.getCommName());
		
		return "redirect:/commPage";
		
	}
	
	
	
	@GetMapping("/post")
	public String post(Model model) {
		
		model.addAttribute("title", "포스트");
		
		return "community/post";
	}
	@GetMapping("/commRanking")
	public String commRanking(Model model) {
		
		model.addAttribute("title", "전체커뮤니티");
		List<Community> communityList = communityService.getCommunityList();
		model.addAttribute("communityList", communityList);
		
		return "community/commRanking";
	}
	@GetMapping("/commPage")
	public String commPage(Model model,@RequestParam(value = "commName") String commName) {

		Community community = communityService.getCommunityByName(commName);
		List<Rule> ruleList = communityService.getRuleListByCommName(commName);
		List<CommTag> tagList = communityService.getTagListByCommName(commName);
		model.addAttribute("community",community);
		model.addAttribute("tagList", tagList);
		model.addAttribute("title", "커뮤니티페이지");
		model.addAttribute("ruleList", ruleList);
		return "community/commPage";
	}
	
	
}
