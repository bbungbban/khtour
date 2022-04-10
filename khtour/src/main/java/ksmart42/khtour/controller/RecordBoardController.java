package ksmart42.khtour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.Feed;
import ksmart42.khtour.dto.PlanStatus;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.dto.RecordBoardComment;
import ksmart42.khtour.service.RecordBoardService;

@Controller
@RequestMapping("/recordBoard")
public class RecordBoardController {

	private RecordBoardService recordBoardService;

	public RecordBoardController(RecordBoardService recordBoardService) {
		this.recordBoardService = recordBoardService;

	}
	
	
/////POST 방식////	조회 -> 등록 -> 수정 -> 삭제 순
	
	/* 1. 등록 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : RecordBoard(여행게시글 리스트)
	*  출  력 : String (주소)
	*  설  명 : 여행게시글 정보 등록(관리자페이지) - post방식 전달
	*/
	@PostMapping("/recordBoardInsert")
	public String addRecordBoard(RecordBoard recordBoard
									, @RequestParam MultipartFile[] recordBoardImageFiles
									, HttpServletRequest request) {
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		recordBoard.setMemberId("id001");
		recordBoardService.addRecordBoard(recordBoard, recordBoardImageFiles, fileRealPath);

		return "redirect:/recordBoard/recordBoardList";
	}
	
	/* 2. 수정 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : RecordBoard(여행게시글 리스트)
	*  출  력 : String (주소)
	*  설  명 : 여행게시글 정보 수정(관리자페이지) - post방식 전달
	*/
	@PostMapping("recordBoardModify")
	public String modifyRecordBoard(RecordBoard recordBoard) {

		recordBoardService.modifyRecordBoard(recordBoard);
		System.out.println("정보 수정 포스트 전달" + recordBoardService.modifyRecordBoard(recordBoard));

		return "redirect:/recordBoard/recordBoardListSt";
	}
	
	/* 3. 등록 (유저 권한)
	*  작성자 : 김민석
	*  입  력 : Feed(피드 리스트), RedirectAttributes
	*  출  력 : String (주소)
	*  설  명 : 피드 정보 등록(유저페이지) - post방식 전달
	*/
	@PostMapping("/feedList")
	public String addFeed(Feed feed, RedirectAttributes attr
								, @RequestParam MultipartFile[] feedImageFiles
								, HttpServletRequest request) {
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		attr.addAttribute("recordBoardCode", feed.getRecordBoardCode());
		recordBoardService.addFeed(feed, feedImageFiles, fileRealPath);
		System.out.println("-----------------------" + feed.getRecordBoardCode());
		return "redirect:/recordBoard/feedList";
	}
	
	
	
	
	
	
	
	
	
	
	
////GET 방식	////	
	
	/* 1. 리스트 조회 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : Model, searchKey 검색키워드 종류, searchValue 검색키워드 값
	*  출  력 : String(주소)
	*  설  명 : 여행 게시글 조회 (관리자페이지) - get방식 전달
	*/
	@GetMapping("/recordBoardListSt")
	public String getRecordBoardListSt(Model model) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		List<RecordBoard> recordBoardList = recordBoardService.getRecordBoardList(paramMap);

		model.addAttribute("title", "문화재 종목별 검색 페이지");
		model.addAttribute("recordBoardList", recordBoardList);

		return "recordBoard/recordBoardListSt";
	}
	
	/* 2. 리스트 조회 (유저 권한)
	*  작성자 : 김민석
	*  입  력 : Model, searchKey 검색키워드 종류, searchValue 검색키워드 값
	*  출  력 : String(주소)
	*  설  명 : 여행 게시글 조회 (유저페이지) - get방식 전달
	*/
	@GetMapping("/recordBoardList")
	public String getRecordBoardList(Model model
			,@RequestParam(name="searchKey", required=false) String searchKey
			,@RequestParam(name="searchValue", required=false) String searchValue) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();

		if(searchKey != null) {
			if("memberId".equals(searchKey)) {
				searchKey = "member_id";
			}else if("recordBoardName".equals(searchKey)) {
				searchKey = "record_board_name";
			}else if("recordBoardSubName".equals(searchKey)) {
				searchKey = "record_board_sub_name";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<RecordBoard> recordBoardList = recordBoardService.getRecordBoardList(paramMap);
		for(int i=0; i<recordBoardList.size(); i++) {
		String feedCount =	recordBoardService.getrecordBoardByfeedCount(recordBoardList.get(i).getRecordBoardCode());
		recordBoardList.get(i).setLikeCount(feedCount);
		}
		
		paramMap = null;
		
		model.addAttribute("title", "여행기록 게시판");
		model.addAttribute("recordBoardList", recordBoardList);

		return "recordBoard/recordBoardList";
	}
	
	/* 3. 리스트 조회 (유저 권한)
	*  작성자 : 김민석
	*  입  력 : @RequestParam, Model
	*  출  력 : String(주소)
	*  설  명 : 피드 조회 (유저 페이지) - get방식 전달
	*/
	@GetMapping("/feedList")
	public String getFeedList(@RequestParam(value = "recordBoardCode") String recordBoardCode, Model model) {

		System.out.println(recordBoardCode + "recoardBoardCode 연결 확인 콘솔");

		recordBoardService.updateViewsByCode(recordBoardCode);
		List<Feed> feedList = recordBoardService.getFeedListByRecordBoardCode(recordBoardCode);
		List<PlanStatus> planStatusList = recordBoardService.getPlanStatusList();
		List<RecordBoardComment> recordBoardCommentList = recordBoardService.getCommentListByrCode(recordBoardCode);
		RecordBoard recordBoard = recordBoardService.getRecordBoardByCode(recordBoardCode);

		model.addAttribute("title", "피드 목록");
		model.addAttribute("recordBoard", recordBoard);
		model.addAttribute("planStatusList", planStatusList);
		model.addAttribute("feedList", feedList);
		model.addAttribute("recordBoardCommentList", recordBoardCommentList);

		System.out.println("정보 수정 겟방식 전달123" + recordBoard);

		return "/recordBoard/feedList";
	}

	/* 4. 정보 등록 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : Model
	*  출  력 : String (주소)
	*  설  명 : 여행 게시글 정보 수정(관리자페이지) - Get방식 전달
	*/
	@GetMapping("/recordBoardInsert")
	public String addRecordBoard(Model model) {

		List<PlanStatus> planStatusList = recordBoardService.getPlanStatusList();

		model.addAttribute("title", "여행 계획 등록");
		model.addAttribute("planStatusList", planStatusList);

		return "recordBoard/recordBoardInsert";
	}
	
	/* 5. 정보 수정 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : @RequestParam, Model
	*  출  력 : String (주소)
	*  설  명 : 여행 게시글 정보 수정(관리자페이지) - Get방식 전달
	*/
	@GetMapping("/recordBoardModify")
	public String modifyRecordBoard(@RequestParam(value = "recordBoardCode", required = false) String recordBoardCode,
			Model model) {
		RecordBoard recordBoard = recordBoardService.getRecordBoardByCode(recordBoardCode);

		model.addAttribute("title", "문화재 수정 페이지");
		model.addAttribute("recordBoard", recordBoard);
		System.out.println("정보 수정 겟방식 전달" + recordBoard);

		return "recordBoard/recordBoardModify";
	}

	/* 5. 정보 삭제 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : RecordBoard(여행 게시글 리스트)
	*  출  력 : String (주소)
	*  설  명 : 여행 게시글 정보 삭제(관리자페이지) - Get방식 전달
	*/
	@GetMapping("/recordBoardRemove")
	public String removeRecordBoard(RecordBoard recordBoard) {
		String recordBoardCode = recordBoard.getRecordBoardCode();

		recordBoardService.removeRecordBoard(recordBoardCode);
		System.out.println("정보 삭제 포스트 전달" + recordBoardService.removeRecordBoard(recordBoardCode));

		return "redirect:/recordBoard/recordBoardListSt";

	}
	
	/* 4. 정보 삭제 (관리자 권한)
	*  작성자 : 김민석
	*  입  력 : Plan(여행 계획 리스트)
	*  출  력 : String (주소)
	*  설  명 : 여행 계획 정보 삭제(관리자페이지) - Get방식 전달
	*/
	@GetMapping("/feedRemove")
	public String removeFeed(Feed feed,  Model model ) {
		String feedCode = feed.getFeedCode();
		String recordBoardCode = feed.getRecordBoardCode();
		System.out.println("feedCode <-----------------" + feedCode);
		System.out.println("recordBoardCode <-----------------" + recordBoardCode);
		System.out.println("feed <-----------------" + feed);
		
		recordBoardService.removeFeed(feedCode);
		
		
		model.addAttribute("recordBoardCode", recordBoardCode);
		System.out.println("정보 삭제 포스트 전달" + recordBoardService.removeFeed(feedCode));
		
		return "redirect:/recordBoard/feedList";
	}

	
	
	
/////댓글 관련
    
	//리뷰 등록(post 정보 전달) request명은 하나의 경로 -> form action 경로와 같아 주면 된다.
	@RequestMapping("/commentInsert")
	public String addComment(RecordBoardComment recordBoardComment, RedirectAttributes reAttr) {

		reAttr.addAttribute("recordBoardCode", recordBoardComment.getRecordBoardCode());
		recordBoardService.addComment(recordBoardComment);

		return "redirect:/recordBoard/feedList";
	} 
	
	
	
	
}
