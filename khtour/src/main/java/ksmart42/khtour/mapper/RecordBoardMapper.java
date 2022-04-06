package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Feed;
import ksmart42.khtour.dto.PlanStatus;
import ksmart42.khtour.dto.RecordBoard;

@Mapper
public interface RecordBoardMapper {

	// 여행계획 목록조회
	public List<RecordBoard> getRecordBoardList(Map<String, Object> paramMap);
	
	// 여행계획 등록
	public int addRecordBoard(RecordBoard recordBoard);

	// 여행계획 조회(여행계획 코드)
	public RecordBoard getRecordBoardByCode(String recordBoardCode);
	
	// 여행계획 수정(여행계획코드)
	public int modifyRecordBoard(RecordBoard recordBoard);
	
	// 여행계획 삭제
	public int removeRecordBoard(String recordBoardCode);
	
	// 여행상태 목록조회
	public List<PlanStatus> getPlanStatusList();
	
	// 여행상태 목록조회(여행계획 코드)
	public PlanStatus getPlanStatusByCode(String planStatusCode);
	
	// 피드 목록조회(게시글 코드)
	public List<Feed> getFeedListByRecordBoardCode(String recordBoardCode);

	//조회수 업데이트
	public int updateViewsByCode(String recordBoardCode);
	
}
