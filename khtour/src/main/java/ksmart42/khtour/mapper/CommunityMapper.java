package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;

@Mapper
public interface CommunityMapper {

	// 1  : 커뮤니티 전체리스트 반환
	public List<Community> getCommunityList();
	// 2  : 커뮤니티 포스트 전체리스트 반환
	public List<CommPost> getPostList();
	// 3 : 커뮤니티 포스트 전체 리스트 반환
	public List<CommPost> getDailyPostList();
	
	public List<CommPost> getPostListByCommunityName(String commName);
	
	
	
	// 4 : 커뮤니티 이름으로 커뮤니티  찾아서 반환 
	public Community getCommunityByName(String commName);
	
	// 5 : 포스트코드로 포스트 찾아서 반환 
	public CommPost getPostByPostCode(String postCode);
	
	// 6 : 커뮤니티 이름으로 규칙 리스트 찾아서 반환 
	public List<Rule> getRuleListByCommName(String commName);
	// 7 : 커뮤니티 이름으로 커뮤니티 테그 찾아서 반환 
	public List<CommTag> getTagListByCommName(String commName);
	
	
	// 8 : 커뮤니티 추가
	public void addCommunity(Community community);
	// 9 : 커뮤니티 포스트 추가
	public void addCommPost(CommPost commpost);
	// 10 : 커뮤니티 규칙 추가
	public void addRule(Rule rule);
	// 11 : 커뮤니티 테그 추가
	public void addTag(CommTag commTag);
	
	// 12 : 커뮤니티 이름 중복 체크
	public boolean commNameCheck(String commName);
	
	public String getNexPostCode();
	
	
	
	
}
