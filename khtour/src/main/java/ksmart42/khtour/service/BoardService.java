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
		 * 번호에 따른 1:1 문의게시판 조회
		 */
		public Board getBoardByNum(String boardNum) {
			return boardMapper.getBoardByNum(boardNum);
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
		public int removeBoard(String boardNum) {
			int result = boardMapper.removeBoard(boardNum);
			
			result += boardMapper.removeBoard(boardNum);
			
			return result;
		}
		
		/**
		 * 1:1문의 게시판 조회수 증가
		 * */
		public int boardHitUpdate(String boardNum) {
			return boardMapper.boardHitUpdate(boardNum);
		}
		
		/**
		 * 번호에 따른 1:1문의 답변
		 */
		public List<Board> getReBoardByNum(String boardNum) {
			List<Board> boardList = boardMapper.getReBoardByNum(boardNum);
			
			return boardList;
		}
		
		public void addReBoard(Board board) {
			boardMapper.addReBoard(board);
		}
	
	}
