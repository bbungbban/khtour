package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	/* 작성자 : 안창현
	*  출  력 : boardList
	*  설  명  : 1:1문의게시판 리스트
	*/
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<Board> boardList = boardService.getBoardList(paramMap);
		
		log.info("1:1문의게시판", boardList);
		model.addAttribute("title", "1:1문의페이지");
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}

}
