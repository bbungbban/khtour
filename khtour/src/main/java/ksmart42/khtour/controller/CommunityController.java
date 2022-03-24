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

import ksmart42.khtour.dto.CommPost;
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
		List<CommPost> postList = communityService.getPostList();
		List<CommPost> dailyPostList = communityService.getDailyPostList();

		model.addAttribute("title","커뮤니티 대시보드");
		model.addAttribute("communityList", communityList);
		model.addAttribute("postList", postList);
		model.addAttribute("dailyPostList",dailyPostList);
	
		return "community/commDashboard";
	}

	
	@GetMapping("/createPost")
	public String createPost(Model model,@RequestParam(name="commName",required=false) String commName) {
		
		model.addAttribute("title", "포스트 생성");
		if(commName==null||commName=="")
		{
			model.addAttribute("commList",communityService.getCommunityList());
		}
		else
		{
			model.addAttribute("community", communityService.getCommunityByName(commName));
		}
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

		commTag.setMemberId("id001");	
		communityService.addTag(commTag);
		reAttr.addAttribute("commName",commTag.getCommName());
		return "redirect:/commPage";
		
	}
	@PostMapping("/addCommPost")
	public String addCommPost(RedirectAttributes reAttr,CommPost commPost) {

		commPost.setMemberId("id001");	
		int number = (int)(Math.random() * 4);
		commPost.setPictureLink("img00"+number);
				
		commPost.setPostCode(communityMapper.getNexPostCode());
		
		communityService.addCommPost(commPost);
		
		reAttr.addAttribute("postCode",commPost.getPostCode());
		
		return "redirect:/post";
		
	}
	
	
	
	@GetMapping("/post")
	public String post(Model model,@RequestParam(value = "postCode") String postCode) {
		
		
		CommPost commPost =communityService.getPostByPostCode(postCode);
		String commName = commPost.getCommName();
		
		Community community = communityService.getCommunityByName(commName);
		List<Rule> ruleList = communityService.getRuleListByCommName(commName);
		
		model.addAttribute("ruleList", ruleList);
		model.addAttribute("community", community);
		model.addAttribute("commPost", commPost);
		
		
		
		
		
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
		List<CommPost> postList = communityService.getPostListByCommunityName(commName);
		
		model.addAttribute("community",community);
		model.addAttribute("tagList", tagList);
		model.addAttribute("title", "커뮤니티페이지");
		model.addAttribute("ruleList", ruleList);
		model.addAttribute("postList", postList);
		
		return "community/commPage";
	}
	
	
}
