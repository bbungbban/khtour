package ksmart42.khtour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.mapper.CommunityMapper;


@Service
@Transactional
public class CommunityService {
	private CommunityMapper communityMapper;
	@Autowired
	public CommunityService(CommunityMapper communityMapper) {
		this.communityMapper = communityMapper;
	}

	// 커뮤니티 서비스 1  : 커뮤니티 전체리스트 반환
	public List<Community> getCommunityList(){
		List<Community> communityList = communityMapper.getCommunityList();
		return communityList;
	}
	// 커뮤니티 서비스 2  : 커뮤니티 포스트중에 하루동안 가장 인기 있는(미구현) 포스트 4개 리스트 반환
	public List<CommPost> getDailyPostList(){
		List<CommPost> dailyPostList = communityMapper.getDailyPostList();
		
		return dailyPostList;
	}
	
	// 커뮤니티 서비스 3 : 커뮤니티 포스트 전체 리스트 반환
	public List<CommPost> getPostList(){
		List<CommPost> postList = communityMapper.getPostList();
			
		for(int i = 0;i<postList.size();i++)
		{
			float likes = Float.parseFloat(postList.get(i).getLikesCnt());
			float dislikes= Float.parseFloat(postList.get(i).getDislikesCnt());
			float cnt = likes -dislikes;
			postList.get(i).setLikesCnt(KhtourLibrary.cntConverter(cnt));		
		}
		
		return postList;
	}
	// 커뮤니티 서비스 4 : 커뮤니티 이름으로 커뮤니티  찾아서 반환 
	public Community getCommunityByName(String commName) {
		
		Community community = communityMapper.getCommunityByName(commName);
		float cnt = Float.parseFloat(community.getMemberCnt());
		community.setMemberCnt(KhtourLibrary.cntConverter(cnt));	
		
		
		return community;
	}
	// 커뮤니티 서비스 5 : 포스트코드로 포스트 찾아서 반환 
	public CommPost getPostByPostCode(String postCode) {
		
		CommPost commPost = communityMapper.getPostByPostCode(postCode);
		float likes = Float.parseFloat(commPost.getLikesCnt());
		float dislikes= Float.parseFloat(commPost.getDislikesCnt());
		float cnt = likes -dislikes;
		commPost.setLikesCnt(KhtourLibrary.cntConverter(cnt));		
		return commPost;
	}
	// 커뮤니티 서비스 6 : 커뮤니티 이름으로 규칙 리스트 찾아서 반환 
	public List<Rule> getRuleListByCommName(String commName){
		
		List<Rule> ruleList = communityMapper.getRuleListByCommName(commName);
		return ruleList;
	}
	// 커뮤니티 서비스 7 : 커뮤니티 이름으로 커뮤니티 테그 찾아서 반환 
	public List<CommTag> getTagListByCommName(String commName){
		
		List<CommTag> tagList = communityMapper.getTagListByCommName(commName);
		return tagList;
	}
	// 커뮤니티 서비스 8 : 커뮤니티 추가
	public void addCommunity(Community community) {
		
		communityMapper.addCommunity(community);
		
	}
	// 커뮤니티 서비스 9 : 커뮤니티 포스트 추가
	public void addCommPost(CommPost commPost) {
		
		communityMapper.addCommPost(commPost);
	}
	// 커뮤니티 서비스 10 : 커뮤니티 규칙 추가
	public void addRule(Rule rule) {
		
		communityMapper.addRule(rule);
		
	}
	// 커뮤니티 서비스 11 : 커뮤니티 테그 추가
	public void addTag(CommTag commTag) {		
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
		communityMapper.addTag(commTag);
		
	}
	
	
	
	
	
	
	
}
