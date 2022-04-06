package ksmart42.khtour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.controller.CommunityController;
import ksmart42.khtour.dto.CommCategory;
import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.CommReply;
import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.dto.LikesDislikes;
import ksmart42.khtour.mapper.CommunityMapper;


@Service
@Transactional
public class CommunityService {
	private CommunityMapper communityMapper;
	private static final Logger log = LoggerFactory.getLogger(CommunityController.class);
	@Autowired
	public CommunityService(CommunityMapper communityMapper) {
		this.communityMapper = communityMapper;
	}

	/* 작성자 : 한경수
	*  입  력 : 
	*  출  력 : List<Community> (전체 커뮤니티 리스트)
	*  설  명  : 전체 커뮤니티 찾아서 맴버 숫자들을 모두 (100K,420,42M) 형식으로 수정후에 반환
	*/
	public List<Community> getCommunityList(){
		List<Community> communityList = communityMapper.getCommunityList();
		
		//커뮤니티 리스트안에든 맴버 숫자들을 모두 수정
		for(int i = 0;i<communityList.size();i++)
		{
			float memberCnt = Float.parseFloat(communityList.get(i).getMemberCnt());
			communityList.get(i).setMemberCnt(KhtourLibrary.cntConverter(memberCnt));;
		}
		return communityList;
	}

	/* 작성자 : 한경수
	*  입  력 : 
	*  출  력 : List<CommPost> (전체 커뮤니티 포스트)
	*  설  명  : 전체 커뮤니티 찾아서 맴버 숫자들을 모두 (100K,420,42M) 형식으로 수정후에 반환
	*/
	public List<CommPost> getDailyPostList(){
		List<CommPost> dailyPostList = communityMapper.getDailyPostList();
		
		return dailyPostList;
	}
	
	
	/* 작성자 : 한경수
	*  입  력 : 
	*  출  력 : List<CommPost> (전체 포스트 리스트)
	*  설  명  : 전체 포스트 리스트 찾아서 반환
	*/
	public List<CommPost> getPostList(){
		List<CommPost> postList = communityMapper.getPostList();		
		return postListMod(postList);
	}
	
	/* 작성자 : 한경수
	*  입  력 : String (커뮤니티 이름)
	*  출  력 : List<CommPost> (특정 커뮤니티의 포스트 리스트)
	*  설  명  : 특정 커뮤니티 에 맞는 포스트 리스트 반환
	*/
	public List<CommPost> getPostListByCommCode(String CommCode){
		List<CommPost> postList = communityMapper.getPostListByCommCode(CommCode);
		return postListMod(postList);
	}
	
	/* 작성자 : 한경수
	*  입  력 : List<CommPost> (포스트 리스트)
	*  출  력 : List<CommPost> (포스트 리스트)
	*  설  명  : 포스트 리스트에, 1) 테그리스트에 맞는 커뮤니티 테그클래스 를 찾아서 저장, 2) 포스트에 숫자를 K/M 형식으로 변환
	*/
	public List<CommPost> postListMod(List<CommPost> postList)
	{
		for(int i = 0;i<postList.size();i++)
		{
			CommPost commPost = postList.get(i);
			commPost.setCommTag(communityMapper.getCommTagByTagCode(commPost.getTagCode()));
			postList.get(i).setResultCnt(KhtourLibrary.cntConverter(Float.parseFloat(postList.get(i).getResultCnt())));		
		}	
		return postList;
	}
	
	/* 작성자 : 한경수
	*  입  력 : 
	*  출  력 : List<CommCategory> (카테고리 리스트)
	*  설  명  : 전체 카테고리 리스트 찾아서 반환
	*/
	public List<CommCategory> getCommCategoryList(){
				
		List<CommCategory> categoryList = communityMapper.getCommCategoryList();
		
		//카테고리 리스트를 수정후에 반환	
		return categoryListMod(categoryList);
	}
	
	/* 작성자 : 한경수
	*  입  력 : int (랜덤으로 뽑고싶은 카테고리 수)
	*  출  력 : List<CommCategory> (카테고리 리스트)
	*  설  명  : 전체 카테고리 리스트 중에 입력값 숫자만큼 랜덤으로 뽑아서 반환
	*/
	public List<CommCategory> getCommCategoryList(int randomCnt){
		
		
		List<CommCategory> categoryList = communityMapper.getCommCategoryList();
			
			//리스트에 든 카테고리 를 뽑고싶은 숫자가 될때까지 하나씩 제거한다.
			for(int i=categoryList.size() ; i>randomCnt;i--)
			{
				int number = (int)(Math.random() * i);
				categoryList.remove(number);
			}
		//카테고리 리스트를 수정후에 반환	
		return categoryListMod(categoryList);
		
	}
	
	/* 작성자 : 한경수
	*  입  력 : List<CommCategory> 카테고리 리스트
	*  출  력 : List<CommCategory> 카테고리 리스트
	*  설  명  : 카테고리 리스트에 속한 모든 커뮤니티 리스트의 좋아요 숫자를 모두 합친후에, K/M형식으로 수정후 반환
	*/
	public List<CommCategory> categoryListMod(List<CommCategory> categoryList)
	{
		for(int i = 0;i<categoryList.size();i++)
		{
			String result = "";
			float memberCnt=0;
			CommCategory category = categoryList.get(i);
			
			//커뮤니티 카테고리에 맞는 모든 커뮤니티 리스트 저장
			List<Community> communityList = communityMapper.getCommunityListByCategoryCode(category.getCategoryCode());
			
			//카테고리에 속한 모든 커뮤니티 좋아요 합쳐줌
			for (int j = 0;j<communityList.size();j++)
			{
				memberCnt += Float.parseFloat(communityList.get(j).getMemberCnt());
			}
			//K/M식으로 변환
			result = KhtourLibrary.cntConverter(memberCnt);
			//카테고리에 총 결과 저장
			category.setTotalMemberCnt(result);
		}
		return categoryList;
	}
	
	
	/* 작성자 : 한경수
	*  입  력 : int (랜덤 숫자)
	*  출  력 : Map<String,List<Community>> 
	*  설  명  : 전체 카테고리 리스트중에서 입력받은 숫자 만큼의 카테고리를 무작위로 뽑아서 맵으로 만든후 카테고리 이름을 키값으로 반환.
	*/
	public Map<String,List<Community>> getRandomCategoryMap(int randomCnt)
	{
		 //전체 카테고리 리스트중에서 입력받은 숫자 만큼의 카테고리를 무작위로 뽑아서 리스트로 만듬
		List<CommCategory> randomCategoryList = getCommCategoryList(randomCnt);
		
		//각각의 카테고리 이름을 키값으로 하고  카테고리에 맞는 커뮤니티 리스트를 value 값으로 맵을 만듬
		Map<String,List<Community>> randomCategoryMap = new HashMap<>();
		for(int i =0;i<randomCategoryList.size();i++)
		{		
			String rCategoryName = randomCategoryList.get(i).getCategoryName();
			String rCategoryCode = randomCategoryList.get(i).getCategoryCode();
			randomCategoryMap.put(rCategoryName, getCommunityListByCategoryCode(rCategoryCode));
		}
		return randomCategoryMap;
	}
	
	
	
	/* 작성자 : 한경수
	*  입  력 : String (카테고리 이름)
	*  출  력 : List<Community> 커뮤니티 리스트 
	*  설  명  : 카테고리에 따른 커뮤니티 리스트를 찾아서  각각에 맴버를 K/M 형식으로 고친후에  반환
	*/
	public List<Community> getCommunityListByCategoryCode(String categoryCode){
		
		List<Community> communityList = communityMapper.getCommunityListByCategoryCode(categoryCode);		
		for(int i = 0; i<communityList.size();i++)
		{
		 float memberCnt = 	Float.parseFloat(communityList.get(i).getMemberCnt());
		 communityList.get(i).setMemberCnt(KhtourLibrary.cntConverter(memberCnt));
		}
		return communityList;
	}
	
	
	
	
	/* 작성자 : 한경수
	*  입  력 : List<CommPost> (커뮤니티 포스트 리스트), String(테그코드)
	*  출  력 :  List<CommPost> (커뮤니티 포스트 리스트)
	*  설  명  : 커뮤니티 포스트중에서 입력받은 테그코드와 일치하는 포스트만 남기고 다 제거후 반환
	*/
	public List<CommPost> getPostByTagCode(List<CommPost> postList,String tagCode)
	{
		for(int i =0;i<postList.size();i++)
		{
			String postTagCode = postList.get(i).getTagCode();
			if(postTagCode==null||!postTagCode.equals(tagCode))
			{
				postList.remove(i);
				i--;
			}		
		}
		return postList;
	}
	
	public List<CommReply> getCommReplyListByPostCode(String postCode)
	{
		
		List<CommReply> replyList = communityMapper.getCommReplyListByPostCode(postCode);
		replyList = replyChildrenSetter(replyList);
		return replyList;
	}
	public List<CommReply> replyChildrenSetter(List<CommReply> replyList)
	{
		for(int i=0;i<replyList.size();i++)
		{
			CommReply reply = replyList.get(i);
			
			List<CommReply> childrenList = communityMapper.getChildrenReplyListByReplyCode(reply.getReplyCode());
			if(childrenList==null)
			{
				return childrenList;
			}
			childrenList = replyChildrenSetter(childrenList);
			reply.setChildrenReply(childrenList);
		}
		return replyList;
	}
	
	
	/* 작성자 : 한경수
	*  입  력 : String (커뮤니티 이름)
	*  출  력 : Community (특정 커뮤니티)
	*  설  명  :입력받은 커뮤니티 이름으로 커뮤니티를 찾아서 좋아요 숫자를 K/M식으로 변환후 반환
	*/
	public Community getCommunityByCommCode(String commCode) {
		
		Community community = communityMapper.getCommunityByCommCode(commCode);
		
		
		float cnt = Float.parseFloat(community.getMemberCnt());
		//K/M 형식으로 변환
		community.setMemberCnt(KhtourLibrary.cntConverter(cnt));	
		return community;
	}
	
	/* 작성자 : 한경수
	*  입  력 : String(포스트 코드)
	*  출  력 : CommPost(커뮤니티 포스트)
	*  설  명  : 입력받은 포스트로 맞는 포스트를 찾아서  좋아요 에서 싫어요 숫자를 뺀후 K/M 식으로 변환후에 반환
	*/
	public CommPost getPostByPostCode(String postCode) {
		//커뮤티니 코드에 맞는 커뮤니티 포스트를 찾아서 저장
		CommPost commPost = communityMapper.getPostByPostCode(postCode);
		
		//커뮤니티 포스트 안에든 포스트 코드를 사용하여 포스트 를 찾아서 커뮤니티 포스트에 저장
		commPost.setCommTag(communityMapper.getCommTagByTagCode(commPost.getTagCode()));
		//K/M식으로 변환
		commPost.setLikesCnt(KhtourLibrary.cntConverter(Float.valueOf(commPost.getResultCnt())));		
		return commPost;
	}
	
	/* 작성자 : 한경수
	*  입  력 : String(커뮤니티 이름)
	*  출  력 : List<Rule> (규칙 리스트)
	*  설  명  : 커뮤니티 이름을 받아서 맞는 규칙 리스트를 찾아서 반환
	*/
	public List<Rule> getRuleListByCommCode(String commCode){
		
		List<Rule> ruleList = communityMapper.getRuleListByCommCode(commCode);
		return ruleList;
	}
	
	/* 작성자 : 한경수
	*  입  력 : String(커뮤니티 이름)
	*  출  력 : List<CommTag> (태그 리스트)
	*  설  명  : 커뮤니티 이름을 받아서 맞는 테그리스트를 찾아서 반환S
	*/
	public List<CommTag> getTagListByCommCode(String commCode){
		
		List<CommTag> tagList = communityMapper.getTagListByCommCode(commCode);
		return tagList;
	}
	
	/* 작성자 : 한경수
	*  입  력 : Community(커뮤니티)
	*  출  력 : 
	*  설  명  : 커뮤니티 등록
	*/
	public void addCommunity(Community community) {
		
		communityMapper.addCommunity(community);
		
	}
	/* 작성자 : 한경수
	*  입  력 : CommPost(커뮤니티포스트)
	*  출  력 : 
	*  설  명  : 커뮤니티 포스트 등록
	*/
	public void addCommPost(CommPost commPost) {
		
		communityMapper.addCommPost(commPost);
	}
	
	/* 작성자 : 한경수
	*  입  력 : Rule(규칙)
	*  출  력 : 
	*  설  명  : 규칙등록
	*/
	public void addRule(Rule rule) {
		
		communityMapper.addRule(rule);
		
	}
	
	public void addlikesDislikes(LikesDislikes likesDislikes) {
		
		communityMapper.addlikesDislikes(likesDislikes);
		
		
		
	}
	
	public void addCommReply(CommReply commReply) {	
		
		communityMapper.addCommentCnt(commReply.getPostCode());
		
		if(commReply.getParentReplyCode()!=null)
		{
			addCommReplyMod(commReply.getParentReplyCode());
		}
		communityMapper.addCommReply(commReply);
		
	} 
	
	public void addCommReplyMod(String parentReplyCode)
	{	
			communityMapper.addCommentCntOfComments(parentReplyCode);	
			CommReply commReply = communityMapper.getCommReplyByParentReplyCode(parentReplyCode);
		if(commReply.getParentReplyCode()!=null)
		{
			addCommReplyMod(commReply.getParentReplyCode());	
		}
	}

	/* 작성자 : 한경수
	*  입  력 : CommTag(커뮤니티 테그)
	*  출  력 : 
	*  설  명  :
	*/
	public void addTag(CommTag commTag) {		
		communityMapper.addTag(commTag);		
	}
	
	public String addLikesDislikes(String postCode,String likeDislike,String replyCode)
	{
		LikesDislikes likesDislikes = new LikesDislikes();
		likesDislikes.setMemberId("id001");
		likesDislikes.setPostCode(postCode);
		likesDislikes.setReplyCode(replyCode);
		String result = "";
		if (likeDislike.equals("like"))
		{
			if(replyCode==null)
			{
				communityMapper.addPostLikesCnt(postCode);
			}
			else
			{
				communityMapper.addReplyLikesCnt(replyCode);
			}
			likesDislikes.setLikesDislikesCate("like");
			communityMapper.addlikesDislikes(likesDislikes);
		}
		else
		{
			if(replyCode==null)
			{
				communityMapper.addPostDislikesCnt(postCode);
			}
			else
			{
				communityMapper.addReplyDislikesCnt(replyCode);
			}
			likesDislikes.setLikesDislikesCate("dislike");		
			communityMapper.addlikesDislikes(likesDislikes);
		}
		
		if(replyCode==null)
		{
			result = KhtourLibrary.cntConverter((float)communityMapper.getPostResultCnt(postCode));
		}
		else
		{
			result = KhtourLibrary.cntConverter((float)communityMapper.getReplyResultCnt(replyCode));
		}
		
		log.info("결과 : " + result);
		return result;
	}
	
	
	
	
	
	
}
