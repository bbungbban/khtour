package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Board;

@Mapper
public interface BoardMapper {
	
	// 1:1문의게시판 목록조회
	public List<Board> getBoardList(Map<String, Object> paramMap);
		
	// 1:1문의게시판 등록
	public int addBoard(Board board);

	// 1:1문의게시판 조회(1:1문의게시판 코드)
	public Board getBoardByNum(String boardNum);
		
	// 1:1문의게시판 수정(1:1문의게시판코드)
	public int modifyBoard(Board board);
		
	// 1:1문의게시판 삭제
	public int removeBoard(String boardNum);
	
	// 1:1문의 조회수 업데이트
	public int boardHitUpdate(String boardNum);
	
	// 1:1문의 답변등록 
	public int addReBoard(Board board);

	public List<Board> getReBoardByNum(String boardNum);

}
