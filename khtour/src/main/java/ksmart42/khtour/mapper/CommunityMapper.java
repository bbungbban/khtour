package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.CommCategory;
import ksmart42.khtour.dto.CommMemberReg;
import ksmart42.khtour.dto.CommPost;
import ksmart42.khtour.dto.CommReply;
import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.dto.LikesDislikes;

@Mapper
public interface CommunityMapper {

	// 1  : 커뮤니티 전체리스트 반환
	public List<Community> getCommunityList();
	public List<Community> getCommunityListByCommCodeList(List<String> commCodeList);
	// 2  : 커뮤니티 포스트 전체리스트 반환
	public List<CommPost> getPostList();
	public List<CommPost> getPostListHot();
	public List<CommPost> getPostListNew();
	// 3 : 커뮤니티 포스트 전체 리스트 반환
	public List<CommPost> getDailyPostList();
	
	public List<CommCategory> getCommCategoryList();
	
	public List<CommPost> getPostListByCommCode(String commCode);
	public List<CommPost> getPostListByCommCodeHot(String commCode);
	public List<CommPost> getPostListByCommCodeNew(String commCode);
	
	public List<Community> getCommunityListByCategoryCode(String categoryCode);
	
	public List<CommReply> getCommReplyListByPostCode(String postCode);
	
	public List<CommReply> getChildrenReplyListByReplyCode(String replyCode);

	public void addCommMemberReg(CommMemberReg commMemberReg);
	public List<String> getCommCodeListByMemberId(String memberId);

	// 4 : 커뮤니티 이름으로 커뮤니티  찾아서 반환 
	public Community getCommunityByCommCode(String commCode);
	
	// 5 : 포스트코드로 포스트 찾아서 반환 
	public CommPost getPostByPostCode(String postCode);
	
	public void addCommentCnt(String postCode);
	public void addCommentCntOfComments(String replyCode);
	
	public void addCommunityMemberCnt(String commCode);
	public void addCategoryMemberCnt(String categoryCode);
	
	public void addPostLikesCnt(String postCode);
	public void addPostDislikesCnt(String postCode);
	
	public void addReplyLikesCnt(String replyCode);
	public void addReplyDislikesCnt(String replyCode);
	
	public int getPostResultCnt(String postCode);
	public int getReplyResultCnt(String replyCode);
	
	
	public CommReply getCommReplyByParentReplyCode(String parentReplyCode);
	
	// 6 : 커뮤니티 이름으로 규칙 리스트 찾아서 반환 
	public List<Rule> getRuleListByCommCode(String commCode);
	// 7 : 커뮤니티 이름으로 커뮤니티 테그 찾아서 반환 
	public List<CommTag> getTagListByCommCode(String commCode);
	
	public CommTag getCommTagByTagCode(String tagCode);
	
	// 8 : 커뮤니티 추가
	public void addCommunity(Community community);
	// 9 : 커뮤니티 포스트 추가
	public void addCommPost(CommPost commpost);
	// 10 : 커뮤니티 규칙 추가
	public void addRule(Rule rule);
	// 11 : 커뮤니티 테그 추가
	public void addTag(CommTag commTag);
	
	public void addCommReply(CommReply commReply);
	
	public void addlikesDislikes(LikesDislikes likesDislikes);
	
	// 12 : 커뮤니티 이름 중복 체크
	public boolean commNameCheck(String commName);
	
	public String getNextPostCode();
	public String getNextCommCode();
	
	public List<String> getFileControllerByPostCode(String postCode);
	
	
	
	
}
