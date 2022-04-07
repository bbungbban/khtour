package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ksmart42.khtour.dto.Board;
import ksmart42.khtour.mapper.BoardMapper;

@Service
public class BoardService {
	//DI 의존성 주입
	private BoardMapper boardMapper;
	
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
		
	}
		/**
		 * 코드에 따른 1:1 문의게시판 조회
		 */
		public Board getBoardByCode(String boardCode) {
			return boardMapper.getBoardByCode(boardCode);
		}
		/**
		 * 1:1 문의게시판 등록
		 */
		public void addBoard(Board board) {
			boardMapper.addBoard(board);
		}
		
		/**
		 * 1:1 문의게시판 목록 조회
		 */
		public List<Board> getBoardList(Map<String, Object> paramMap){
			List<Board> boardList = boardMapper.getBoardList(paramMap);
			
			return boardList;
		}

		/**
		 * 1:1 문의게시판 정보 수정
		 */
		public int modifyBoard(Board board) {
			return boardMapper.modifyBoard(board);
		}
		
		/**
		 * 1:1 문의게시판 정보 삭제
		 */
		public int removeBoard(String boardCode) {
			int result = boardMapper.removeBoard(boardCode);
			
			result += boardMapper.removeBoard(boardCode);
			
			return result;
		}
	}
