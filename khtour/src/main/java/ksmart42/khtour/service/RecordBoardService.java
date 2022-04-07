package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Feed;
import ksmart42.khtour.dto.PlanStatus;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.dto.RecordBoardComment;
import ksmart42.khtour.mapper.RecordBoardMapper;

@Service
@Transactional
public class RecordBoardService {
	//DI 의존성 주입
	private RecordBoardMapper recordBoardMapper;
	
	public RecordBoardService(RecordBoardMapper recordBoardMapper) {
		this.recordBoardMapper = recordBoardMapper;
	}
// 기본적인 조회-> 등록 -> 수정-> 삭제	
	
	/**
	 * 여행게시글 목록 조회
	 * @author 김민석
	 * @param paramMap
	 */
	public List<RecordBoard> getRecordBoardList(Map<String, Object> paramMap){
		List<RecordBoard> recordBoardList = recordBoardMapper.getRecordBoardList(paramMap);
		
		for(int i=0; i<recordBoardList.size(); i++) {
				
			PlanStatus planStatus = recordBoardMapper.getPlanStatusByCode(recordBoardList.get(i).getPlanStatusCode());
			recordBoardList.get(i).setPlanStatus(planStatus);
		};
		return recordBoardList;
	}
	
	/**
	 * 코드에 따른 여행게시글 조회
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public RecordBoard getRecordBoardByCode(String recordBoardCode) {
		return recordBoardMapper.getRecordBoardByCode(recordBoardCode);
	}
	
	/**
	 * 여행상태 목록 조회
	 * @author 김민석
	 * @param 
	 */
	public List<PlanStatus> getPlanStatusList(){
		return recordBoardMapper.getPlanStatusList();
		
	}
	
	/**
	 * 여행게시글 등록, 이미지 파일 삽입
	 * @author 김민석
	 * @param recordBoard, heritageImageFiles, fileRealPath
	 */
	public void addRecordBoard(RecordBoard recordBoard) {
		recordBoardMapper.addRecordBoard(recordBoard);
	}

	/**
	 * 여행게시글 정보 수정
	 * @author 김민석
	 * @param recordBoard
	 */
	public int modifyRecordBoard(RecordBoard recordBoard) {
		return recordBoardMapper.modifyRecordBoard(recordBoard);
	}
	
	/**
	 * 코드에 따른 여행게시글 정보 삭제
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int removeRecordBoard(String recordBoardCode) {
		int result = recordBoardMapper.removeFeedByrCode(recordBoardCode);
		
		result += recordBoardMapper.removeRecordBoard(recordBoardCode);
		
		return result;
	}
	
////////////피드
	
	/**
	 * 여행게시글코드에 따른 피드 조회
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public List<Feed> getFeedListByRecordBoardCode(String recordBoardCode) {
		return recordBoardMapper.getFeedListByRecordBoardCode(recordBoardCode);
	}
	
	/**
	 * 피드 등록, 이미지 파일 삽입
	 * @author 김민석
	 * @param feed, heritageImageFiles, fileRealPath
	 */
	public void addFeed(Feed feed) {
		recordBoardMapper.addFeed(feed);
	}

	/**
	 * 피드 정보 수정
	 * @author 김민석
	 * @param feed
	 */
	public int modifyFeed(Feed feed) {
		return recordBoardMapper.modifyFeed(feed);
	}
	
	/**
	 * 코드에 따른 피드 정보 삭제
	 * @author 김민석
	 * @param feedCode
	 */
	public int removeFeed(String feedCode) {
		int result = recordBoardMapper.removeRecordBoard(feedCode);
		
		result += recordBoardMapper.removeRecordBoard(feedCode);
		
		return result;
	}
//////////게시글 댓글 관련
	
	public List<RecordBoardComment> getCommentListByrCode(String recordBoardCode){
		return recordBoardMapper.getCommentListByrCode(recordBoardCode);
	}	
	
	public void addComment(RecordBoardComment recordBoardComment) {
		recordBoardMapper.addComment(recordBoardComment);
		
	}	
	

/////////그 외
	
	/**
	 * 코드에 따른 여행게시글 조회수 정보 추가
	 * @author 김민석
	 * @param recordBoardCode
	 */
	public int updateViewsByCode(String recordBoardCode) {
		return recordBoardMapper.updateViewsByCode(recordBoardCode);
	}
	

	

	
}
