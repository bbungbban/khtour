package ksmart42.khtour.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.CommCategory;
import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.CommReply;
import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.mapper.CommunityMapper;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.service.CommunityService;
import ksmart42.khtour.service.FileService;


@Controller
public class CommunityController {
	private static final Logger log = LoggerFactory.getLogger(CommunityController.class);
	private CommunityService communityService;
	private CommunityMapper communityMapper;
	private FileService fileService;
	private FileMapper fileMapper;

	public CommunityController(FileService fileService,CommunityService communityService,CommunityMapper communityMapper,FileMapper fileMapper) 
	{
		this.communityService = communityService;
		this.communityMapper = communityMapper;
		this.fileService = fileService;
		this.fileMapper = fileMapper;
	}
	/* 작성자 : 한경수
	*  입  력 : String 커뮤니티 이름
	*  출  력 : boolean
	*  설  명  : 커뮤니티 이름 중복 체크
	*/
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
	
	@PostMapping("/addLikes")
	@ResponseBody
	public String addLikes(@RequestParam(value = "postCode",required=false) String postCode,@RequestParam(value = "replyCode",required=false) String replyCode)
	{
		if(replyCode==null)
		{
			return communityService.addLikesDislikes(postCode,"like",null);
		}
		else
		{
			return communityService.addLikesDislikes(null,"like",replyCode);
		}
	}	
	@PostMapping("/addDislikes")
	@ResponseBody
	public String addDislikes(@RequestParam(value = "postCode",required=false) String postCode, @RequestParam(value = "replyCode",required=false) String replyCode)
	{
		if(replyCode==null)
		{
		return communityService.addLikesDislikes(postCode,"dislike",null);
		}
		else
		{
			return communityService.addLikesDislikes(null,"dislike",replyCode);
		}
	}	
	
	
	
	/* 작성자 : 한경수
	*  입  력 : String 커뮤니티 이름
	*  출  력 : List<CommTag>
	*  설  명  : 특정 커뮤니티에 전체 테그 리스트 반환
	*/
	@PostMapping("/getTagList")
	@ResponseBody
	public List<CommTag> getTagList(@RequestParam(value = "commCode") String commCode)
	{
		return communityService.getTagListByCommCode(commCode);
	}
	
	/* 작성자 : 한경수
	*  입  력 : Model
	*  출  력 : String (주소)
	*  설  명  : 커뮤니티 데쉬보드 로 접속
	*/
	@GetMapping("/commDashboard")
	public String commDashboard(Model model,HttpServletRequest request) {
		//전체 커뮤니티 리스트
		List<Community> communityList = communityService.getCommunityList();
		//전체 포스트 리스트
		List<CommPost> postList = communityService.getPostList();
		//오늘뜨고있는 상위 포스트 4개 리스트
		List<CommPost> dailyPostList = communityService.getDailyPostList();
		model.addAttribute("title","커뮤니티 대시보드");
		model.addAttribute("communityList", communityList);
		model.addAttribute("postList", postList);
		model.addAttribute("dailyPostList",dailyPostList);
		
		return "community/commDashboard";
	}

	/* 작성자 : 한경수
	*  입  력 : Model, String(커뮤니티이름)
	*  출  력 : String (주소)
	*  설  명  : 포스트 생성 페이지 GET 메서드로 접속
	*/
	@GetMapping("/createPost")
	public String createPost(Model model,@RequestParam(name="commCode",required=false) String commCode) {
		
		model.addAttribute("title", "포스트 생성");
		
		if(commCode==null||commCode=="")
		{
			//전체 커뮤니티 리스트  모델에 저장
			model.addAttribute("commList",communityService.getCommunityList());
		}
		else
		{
			//특정 커뮤니티 하나만 모델에 저장
			model.addAttribute("community", communityService.getCommunityByCommCode(commCode));	
			//특정 커뮤니티에 따른 테그리스트 모델에 저장
			model.addAttribute("tagList", communityService.getTagListByCommCode(commCode));
		}
		return "community/createPost";
	}
	
	/* 작성자 : 한경수
	*  입  력 : Model
	*  출  력 : String (주소)
	*  설  명  : 커뮤니티 생성 페이지 GET메서드로 접속
	*/
	@GetMapping("/addCommunity")
	public String createCommunity(Model model) {
		
		model.addAttribute("title", "커뮤니티 생성");
		//전체 카테고리 리스트 모델에 저장
		List<CommCategory> categoryList = communityService.getCommCategoryList();
		model.addAttribute("categoryList",categoryList);
		
		return "community/addCommunity";
	}
	
	
	/* 작성자 : 한경수
	*  입  력 : RedirectAttributes, Community(커뮤니티 클래스) 
	*  출  력 : String (주소)
	*  설  명  : 새로운 커뮤니티 생성 후에 커뮤니티 페이지로 리다이렉트
	*/
	@PostMapping("/addCommunity")
	public String addCommunity(RedirectAttributes reAttr,Community community) {
		
		//임시 더미데이터 저장
		community.setMemberCnt("1");
		community.setOnlineMemberCnt("0");
		community.setMemberId("id001");
		
		community.setCommCode(communityMapper.getNextCommCode());
		//커뮤니티 데이터 베이스에 저장
		communityService.addCommunity(community);

		//커뮤니티 이름 리다이렉트 정보에 저장
		reAttr.addAttribute("commCode",community.getCommCode());
		
		return "redirect:/commPage";
		
	}
	
	/* 작성자 : 한경수
	*  입  력 : RedirectAttributes, Rule(큐칙 클래스) 
	*  출  력 : String (주소)
	*  설  명  : 새로운 규칙 생성 후에 커뮤니티 페이지로 리다이렉트
	*/
	@PostMapping("/addRule")
	public String addRule(RedirectAttributes reAttr,Rule rule) {
		
		//새로운 규칙 데이타 베이스에 저장
		communityService.addRule(rule);
		
		//커뮤니티 이름 리다이렉트 정보에 저장
		reAttr.addAttribute("commCode",rule.getCommCode());
		
		return "redirect:/commPage";	
	}
	
	/* 작성자 : 한경수
	*  입  력 : RedirectAttributes, CommTag(커뮤니티 테그) 
	*  출  력 : String (주소)
	*  설  명  : 새로운 태그 저장후에 커뮤니티 페이지로 리다이렉트
	*/
	@PostMapping("/addTag")
	public String addTag(RedirectAttributes reAttr,CommTag commTag) {

		//임시 더미데이터 저장
		commTag.setMemberId("id001");	
		
		//커뮤니티 테그 저장
		communityService.addTag(commTag);
		
		//커뮤니티 이름 리다이렉트 정보에 저장
		reAttr.addAttribute("commCode",commTag.getCommCode());
		return "redirect:/commPage";
		
	}
	
	/* 작성자 : 한경수
	*  입  력 : RedirectAttributes, CommPost(커뮤니티 포스트) 
	*  출  력 : String (주소)
	*  설  명  : 새로운 커뮤니티 포스트 등록 후에 포스트 페이지로 리다이렉트
	*/
	@PostMapping("/addCommPost")
	public String addCommPost(HttpServletRequest request,@RequestParam MultipartFile[] uploadfile,RedirectAttributes reAttr,CommPost commPost) {
		
		//임시 더미데이터 저장
		commPost.setMemberId("id001");	
		String serverName = request.getServerName();
		String fileRealPath = "";	
		List<String> indexList =null;
		if(!uploadfile[0].isEmpty())
		{
			if("localhost".equals(serverName)) 
			{				
				fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
				//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
			}
			else 
			{
				fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
			}
		
			indexList = fileService.fileUpload(uploadfile, fileRealPath);
			commPost.setPictureLink("\\" + indexList.get(0));	
		}
		//포스트 데이타 베이스에 저장
		//포스트 코드 생성후 저장
			commPost.setPostCode(communityMapper.getNextPostCode());	
			communityService.addCommPost(commPost);
			List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();	
			Map<String , String> addMap = null;	
			if(uploadfile != null&&uploadfile.length>1) {
				for(int i=1;i<uploadfile.length;i++) {
					addMap = new HashMap<String , String>();
					addMap.put("referenceCode", commPost.getPostCode());
					addMap.put("filePath", "\\" + indexList.get(i));
					addFileControlList.add(addMap);
				}
			}		
			fileMapper.addFileControl(addFileControlList);	
		
		
		//포스트코드 리다이렉트 정보에 저장
		reAttr.addAttribute("postCode",commPost.getPostCode());
		return "redirect:/post";	
	}
	@PostMapping("/addCommReply")
	public String addCommReply(RedirectAttributes reAttr,CommReply commReply) {
		
		commReply.setMemberId("id001");	
		reAttr.addAttribute("postCode",commReply.getPostCode());
		
		log.info("답글 메인 글 : " + commReply.getMainText());
		
		
		communityService.addCommReply(commReply);
		return "redirect:/post";	
	}
	
	
	/* 작성자 : 한경수
	*  입  력 : Model, String(포스트 코드) 
	*  출  력 : String (주소)
	*  설  명  : 포스트 페이지 GET 방식으로 접속
	*/
	@GetMapping("/post")
	public String post(Model model,@RequestParam(value = "postCode") String postCode) {
		
		//포스트 코드로 커뮤니티 포스트를 찾아서 저장
		CommPost commPost =communityService.getPostByPostCode(postCode);
		List<CommReply> replyList = communityService.getCommReplyListByPostCode(postCode);
		log.info("답글리스트 : " + replyList);
		//커뮤니티포스트에 들어있는 커뮤니티 이름 저장
		String commCode = commPost.getCommCode();
		
		// 커뮤니티 이름으로 특정 커뮤니티 찾아서 저장
		Community community = communityService.getCommunityByCommCode(commCode);
		// 커뮤니티 이름으로 특정 커뮤니티의 규칙 리스트 찾아서 저장
		List<Rule> ruleList = communityService.getRuleListByCommCode(commCode);
		
		List<String> filePathList= communityMapper.getFileControllerByPostCode(postCode);
		
		log.info("파일 주소 리스트: "+ filePathList);
		
		//모델에 정보들 저장
		model.addAttribute("filePathList",filePathList);
		model.addAttribute("replyList",replyList);
		model.addAttribute("ruleList", ruleList);
		model.addAttribute("community", community);
		model.addAttribute("commPost", commPost);
		model.addAttribute("title", "포스트");
		
		return "community/post";
	}
	
	/* 작성자 : 한경수
	*  입  력 : Model, String(카테고리 이름) 
	*  출  력 : String (주소)
	*  설  명  : 커뮤니티 랭킹으로 접속 하는데.. 카테고리 이름을 받을때랑, 않받을때랑 구별해서 맞는 커뮤니티 리스트를 보내줌
	*/
	@GetMapping("/commRanking")
	public String commRanking(Model model, @RequestParam(name="categoryCode",required=false) String categoryCode, @RequestParam(name="categoryName",required=false) String categoryName) {
		List<Community> communityList = null;
		//커뮤니티 전체 카테고리 리스트 저장
		List<CommCategory> categoryList = communityService.getCommCategoryList();
		//전체 카테고리 리스트중 3 개를 랜덤으로 뽑아서 맵에 저장후에 반환. String 키값에는 카테고리 이름이 들어가고, Value값에는 카테고리 에 따른 커뮤니티 리스트가 들어간다. 
		Map<String,List<Community>> randomCategoryMap = communityService.getRandomCategoryMap(3);
		if(categoryCode!=null)
		{
			//카테고리 이름을 받았을때는 카테고리 이름에 따른 커뮤니티 리스트만 저장
			model.addAttribute("categoryCode",categoryCode);
			model.addAttribute("categoryName",categoryName);
			communityList = communityService.getCommunityListByCategoryCode(categoryCode);
		}
		else
		{
			//전체 카테고리 리스트 저장
			communityList = communityService.getCommunityList();
		}
		model.addAttribute("title", "전체 커뮤니티");
		model.addAttribute("communityList", communityList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("randomCategoryMap", randomCategoryMap);
		return "community/commRanking";
	}
	
	/* 작성자 : 한경수
	*  입  력 : Model, String(커뮤니티 이름), String(테그 이름) 
	*  출  력 : String (주소)
	*  설  명  : 특정 커뮤니티 페이지로 커뮤니티 이름을 사용해서 접속,        * 테그 이름을 받았을 경우 테그에 맞는 포스트만 띄워준다.
	*/
	@GetMapping("/commPage")
	public String commPage(Model model,@RequestParam(value = "commCode") String commCode, @RequestParam(name="tagCode",required=false) String tagCode) {

		//커뮤니티 이름에 맞는 커뮤니티 리스트,규칙 리스트,테그 리스트, 포스트 리스트 를 저장
		Community community = communityService.getCommunityByCommCode(commCode);
		List<Rule> ruleList = communityService.getRuleListByCommCode(commCode);
		List<CommTag> tagList = communityService.getTagListByCommCode(commCode);
		List<CommPost> postList = communityService.getPostListByCommCode(commCode);
		
		//테그코드를 받았을경우 포스트 리스트를 수정하여, 테그코드가 동일한 포스트만 추려서 다시 저장.
		if(tagCode!=null && tagCode!= "")
		{
			postList = communityService.getPostByTagCode(postList, tagCode);	
		}

		model.addAttribute("community",community);
		model.addAttribute("tagList", tagList);
		model.addAttribute("title", "커뮤니티페이지");
		model.addAttribute("ruleList", ruleList);
		model.addAttribute("postList", postList);
		
		return "community/commPage";
	}
	
	
}
