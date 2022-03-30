package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

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
}
