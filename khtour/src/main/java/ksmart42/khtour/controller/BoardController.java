package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ksmart42.khtour.dto.Board;

import ksmart42.khtour.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	private BoardService boardService;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	/*
	 * 1:1문의 상세페이지 (Get 정보 전달)
	 */
	@GetMapping("/boardDetail")
	public String getBoardDetail(@RequestParam(value = "boardNum") String boardNum, Model model) {
		
		Board board = boardService.getBoardByNum(boardNum);
		
		boardService.boardHitUpdate(boardNum);
		
		model.addAttribute("title", "1:1문의 상세페이지");
		model.addAttribute("board", board);
	
		return "board/boardDetail";
	}
	
	/*
	 * 1:1문의 조회 (Get 정보 전달)
	 */
	@GetMapping("/boardList")
	public String getboardList(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Board> boardList = boardService.getBoardList(paramMap);
		
		model.addAttribute("title", "1:1문의 조회페이지");
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	/*
	 * 1:1문의  수정(Post 정보 전달)
	 */
	@PostMapping("/modifyBoard")
	public String modifyBoard(Board board) {
		
		boardService.modifyBoard(board);
		System.out.println("정보 수정 포스트 전달" + boardService.modifyBoard(board));
		
		return "redirect:/board/boardList";
	}
	
	/*
	 * 1:1문의  수정(Get 정보 전달)
	 */
	@GetMapping("/boardModify")
	public String modifyBoard(
			@RequestParam(value="boardNum", required = false) String boardNum
			,Model model) {
		Board board = boardService.getBoardByNum(boardNum);
		
		model.addAttribute("title", "1:1문의 수정 페이지");
		model.addAttribute("board", board);
		System.out.println("정보 수정 겟방식 전달" + board);
		
		return "board/boardModify";
	}	
	
	/*
	 * 1:1문의 삭제(post 정보 전달)
	 */
	@GetMapping("/boardRemove")
	public String removePlan(Board board) {
		String boardNum = board.getBoardNum();
		
		boardService.removeBoard(boardNum);
		System.out.println("정보 삭제 포스트 전달" + boardService.removeBoard(boardNum));
		
		return "redirect:/board/boardList";
		
	}
			
	/*
	 * 1:1문의 등록(Post 정보 전달)
	 */
	@PostMapping("/boardPost")
	public String addPlan(Board board) {
		
		boardService.addBoard(board);
		
		return "redirect:/board/boardList";
	}
	/*
	 * 1:1문의 등록(Get 정보 전달)
	 */
	@GetMapping("/boardPost")
	public String addBoard(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Board> boardList = boardService.getBoardList(paramMap);
		
		model.addAttribute("title", "1:1문의 등록");
		model.addAttribute("boardList", boardList);
		
		return "board/boardPost";
	}
	
	/*
	 * 객실 등록(Post 정보 전달)
	 */
	@PostMapping("/boardRePost")
	public String addReBoard(Board board) {
		
		boardService.addReBoard(board);
		
		return "redirect:/board/boardList";
	}
	
	/*
	 * 1:1문의 답글 등록(Get 정보 전달)
	 */
	@GetMapping("/boardRePost")
	public String addReBoard(Model model
							,@RequestParam(value = "boardNum") String boardNum) {

		
		log.info(boardNum + "게시글 번호");
		model.addAttribute("title", "1:1문의 답변 등록");
		model.addAttribute("boardNum", boardNum);
		
		return "board/boardRePost";
	}
	
}
