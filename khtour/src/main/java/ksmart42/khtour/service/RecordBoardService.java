package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Feed;
import ksmart42.khtour.dto.PlanStatus;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.mapper.RecordBoardMapper;

@Service
@Transactional
public class RecordBoardService {
	//DI 의존성 주입
	private RecordBoardMapper recordBoardMapper;
	
	public RecordBoardService(RecordBoardMapper recordBoardMapper) {
		this.recordBoardMapper = recordBoardMapper;
	}
	
	/**
	 * 코드에 따른 게시글 조회수 조회
	 */
	public int updateViewsByCode(String recordBoardCode) {
		return recordBoardMapper.updateViewsByCode(recordBoardCode);
	}
	
	/**
	 * 코드에 따른 여행 계획 조회
	 */
	public RecordBoard getRecordBoardByCode(String recordBoardCode) {
		return recordBoardMapper.getRecordBoardByCode(recordBoardCode);
	}
	/**
	 * 여행 계획 등록
	 */
	public void addRecordBoard(RecordBoard recordBoard) {
		recordBoardMapper.addRecordBoard(recordBoard);
	}
	
	/**
	 * 여행 계획 목록 조회
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
	 * 여행 계획 정보 수정
	 */
	public int modifyRecordBoard(RecordBoard recordBoard) {
		return recordBoardMapper.modifyRecordBoard(recordBoard);
	}
	
	/**
	 * 여행 계획 정보 삭제
	 */
	public int removeRecordBoard(String recordBoardCode) {
		int result = recordBoardMapper.removeRecordBoard(recordBoardCode);
		
		result += recordBoardMapper.removeRecordBoard(recordBoardCode);
		
		return result;
	}
	
	public List<PlanStatus> getPlanStatusList(){
		return recordBoardMapper.getPlanStatusList();
		
	}
	
	
	/**
	 * 게시글코드에 따른 피드 조회
	 */
	public List<Feed> getFeedListByRecordBoardCode(String recordBoardCode) {
		return recordBoardMapper.getFeedListByRecordBoardCode(recordBoardCode);
	}
}
