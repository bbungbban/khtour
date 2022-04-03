package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ksmart42.khtour.dto.Board;
import ksmart42.khtour.mapper.BoardMapper;

@Service
public class BoardService {
	//DI 의존성 주입
	private BoardMapper boradMapper;
	
	public BoardService(BoardMapper boradMapper) {
		this.boradMapper = boradMapper;
		
	}
	/**
	 * 1:1문의게시판 리스트 조회 
	 **/
	public List<Board> getBoardList(Map<String, Object> paramMap) {
		List<Board> boardList = boradMapper.getBoardList(paramMap);
		
		return boardList;
	}

}
