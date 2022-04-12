package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Feed;
import ksmart42.khtour.dto.PlanStatus;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.dto.RecordBoardComment;

@Mapper
public interface RecordBoardMapper {
/*
 * 여행 게시글 관련
 */
	// 여행게시글 목록조회
	public List<RecordBoard> getRecordBoardList(Map<String, Object> paramMap);
	
	// 게시글 코드에 따른 여행게시글 정보 조회
	public RecordBoard getRecordBoardByCode(String recordBoardCode);

	// 여행 상태 목록조회
	public List<PlanStatus> getPlanStatusList();
	
	// 여행 계획 코드에 따른 여행상태 목록 조회 
	public PlanStatus getPlanStatusByCode(String planStatusCode);
	
	// 여행게시글 정보 등록
	public int addRecordBoard(RecordBoard recordBoard);
	
	// 여행게시글 정보 수정(여행계획코드)
	public int modifyRecordBoard(RecordBoard recordBoard);
	
	// 여행게시글 정보 삭제
	public int removeRecordBoard(String recordBoardCode);
	
	// 조회수 순 top4개의 포스트 조회
	public List<RecordBoard> getTopRecordBoardList();
	
	// 여행게시글 조회수 업데이트
	public int updateViewsByCode(String recordBoardCode);
	
	public String getrecordBoardByfeedCount(String recordBoardCode);
	
/*
 * 피드 관련
 */
	// 피드 목록조회(게시글 코드)
	public List<Feed> getFeedListByRecordBoardCode(String recordBoardCode);
	
	// 피드 등록
	public int addFeed(Feed feed);
	
	// 피드 수정
	public int modifyFeed(Feed feed);
	
	// 피드 삭제
	public int removeFeed(String feedCode);
	
	// 여행게시글 코드에 따른 피드 삭제
	public int removeFeedByrCode(String recordBoardCode);
	
/*
 * 댓글 관련	
 */

	// 댓글 목록조회(게시글 코드)
	public List<RecordBoardComment> getCommentListByrCode(String recordBoardCode);

	// 댓글 등록
	public int addComment(RecordBoardComment recordBoardComment);
	
	// 댓글 삭제
	public int removeRecordBoardComment(String commentNum);
	
	// 여행 게시글 코드에 따른 댓글 삭제
	public int removeCommentByrCode(String recordBoardCode);

}
