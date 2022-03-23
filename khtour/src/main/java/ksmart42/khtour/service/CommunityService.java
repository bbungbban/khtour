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
	
	public List<Community> getCommunityList(){
		List<Community> communityList = communityMapper.getCommunityList();
		return communityList;
	}
	public List<CommPost> getDailyPostList(){
		List<CommPost> dailyPostList = communityMapper.getDailyPostList();
		
		return dailyPostList;
	}
	
	public List<CommPost> getPostList(){
		List<CommPost> postList = communityMapper.getPostList();
			
		for(int i = 0;i<postList.size();i++)
		{
			float likes = Float.parseFloat(postList.get(i).getLikesCnt());
			float dislikes= Float.parseFloat(postList.get(i).getDislikesCnt());
			float floatResult = 0;
			likes = likes-dislikes;
			String result = "";
	
			
			if (likes>1000000)
			{
				if(Math.round(likes/100000)%10 ==0)
				{
					result = String.valueOf(Math.round(likes/1000000))+"M";
				}
				else
				{
					floatResult = Math.round(likes/100000);
					floatResult = floatResult/10;
					result = String.valueOf(floatResult)+"M";
				}
			}
			else if (likes>1000)
			{
				if(Math.round(likes/100)%10 ==0)
				{
					result = String.valueOf(Math.round(likes/1000))+"K";
				}
				else
				{
					floatResult = Math.round(likes/100);
					floatResult = floatResult/10;
					result = String.valueOf(floatResult)+"K";
				}
			}
			else
			{	
				result = String.valueOf(Math.round(likes));		
			}


			postList.get(i).setLikesCnt(result);		
		}
		
		return postList;
	}
	public Community getCommunityByName(String commName) {
		
		Community community = communityMapper.getCommunityByName(commName);
		return community;
	}
	
	public List<Rule> getRuleListByCommName(String commName){
		
		List<Rule> ruleList = communityMapper.getRuleListByCommName(commName);
		return ruleList;
	}
	public List<CommTag> getTagListByCommName(String commName){
		
		List<CommTag> tagList = communityMapper.getTagListByCommName(commName);
		return tagList;
	}
	
	public void addCommunity(Community community) {
		
		communityMapper.addCommunity(community);
		
	}
	public void addCommPost(CommPost commPost) {
		
		communityMapper.addCommPost(commPost);
	}
	public void addRule(Rule rule) {
		
		communityMapper.addRule(rule);
		
	}
	
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
