package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart42.khtour.dto.PlanStatus;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.service.RecordBoardService;

@Controller
@RequestMapping("/recordBoard")
public class RecordBoardController {

	private RecordBoardService recordBoardService;
	
	public RecordBoardController(RecordBoardService recordBoardService) {
		this.recordBoardService = recordBoardService;

	}
	
	/*
	 * 문화재 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/recordBoardListSt")
	public String getRecordBoardListSt(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<RecordBoard> recordBoardList = recordBoardService.getRecordBoardList(paramMap);
		
		model.addAttribute("title", "문화재 종목별 검색 페이지");
		model.addAttribute("recordBoardList", recordBoardList);
		
		return "recordBoard/recordBoardListSt";
	}
	
	
	
	/*
	 * 문화재 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyRecordBoard")
	public String modifyRecordBoard(RecordBoard recordBoard) {
		
		recordBoardService.modifyRecordBoard(recordBoard);
		System.out.println("정보 수정 포스트 전달" + recordBoardService.modifyRecordBoard(recordBoard));
		
		return "redirect:/recordBoard/recordBoardListSt";
	}
	
	/*
	 * 문화재 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/recordBoardModify")
	public String modifyRecordBoard(
			@RequestParam(value="recordBoardCode", required = false) String recordBoardCode
			,Model model) {
		RecordBoard recordBoard = recordBoardService.getRecordBoardByCode(recordBoardCode);
		
		model.addAttribute("title", "문화재 수정 페이지");
		model.addAttribute("recordBoard", recordBoard);
		System.out.println("정보 수정 겟방식 전달" + recordBoard);
		
		return "recordBoard/recordBoardModify";
	}	
	
	/*
	 * 문화재 정보 삭제(post 정보 전달) (관리자)
	 */
	@GetMapping("/recordBoardRemove")
	public String removeRecordBoard(RecordBoard recordBoard) {
		String recordBoardCode = recordBoard.getRecordBoardCode();
		
		recordBoardService.removeRecordBoard(recordBoardCode);
		System.out.println("정보 삭제 포스트 전달" + recordBoardService.removeRecordBoard(recordBoardCode));
		
		return "redirect:/recordBoard/recordBoardListSt";
		
	}
	
	
	
	
	
	
	
	
	
	
/////////////////////////////////////////////////////	
	
	
	/*
	 * 문화재 종목별 검색(Get 정보 전달)
	 */
	@GetMapping("/recordBoardList")
	public String getRecordBoardListByItem(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();

		List<RecordBoard> recordBoardList = recordBoardService.getRecordBoardList(paramMap);
		
		model.addAttribute("title", "문화재 종목별 검색 페이지");
		model.addAttribute("recordBoardList", recordBoardList);
		
		return "recordBoard/recordBoardList";
	}
			
	/*
	 * 여행 계획 등록(Post 정보 전달)
	 */
	@PostMapping("/recordBoardInsert")
	public String addRecordBoard(RecordBoard recordBoard) {
		
		recordBoard.setMemberId("id001");
		recordBoardService.addRecordBoard(recordBoard);
		
		return "redirect:/recordBoard/recordBoardListSt";
	}
	/*
	 * 여행 계획 등록(Get 정보 전달)
	 */
	@GetMapping("/recordBoardInsert")
	public String addRecordBoard(Model model) {
		
		List<PlanStatus> planStatusList = recordBoardService.getPlanStatusList();
		
		model.addAttribute("title", "여행 계획 등록");
		model.addAttribute("planStatusList", planStatusList);
		
		return "recordBoard/recordBoardInsert";
	}
	
	/*
	 * 문화재 상세페이지(코드 번호에 따른) 조회
	 */
	@GetMapping("/recordBoardDetail")
	public String getHeritaDetail(
			@RequestParam(value="recordBoardCode", required = false) String recordBoardCode,
			Model model) {
		
		List<PlanStatus> planStatusList = recordBoardService.getPlanStatusList();
		RecordBoard recordBoard = recordBoardService.getRecordBoardByCode(recordBoardCode);
		
		model.addAttribute("title", "문화재 상세 페이지");
		model.addAttribute("recordBoard", recordBoard);
		model.addAttribute("planStatusList", planStatusList);
		System.out.println("정보 수정 겟방식 전달" + recordBoard);
		return "/recordBoard/recordBoardDetail";
	}
	
	
}
