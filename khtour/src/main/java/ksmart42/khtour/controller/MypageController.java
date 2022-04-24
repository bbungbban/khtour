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

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.dto.Plan;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.dto.Reservation;
import ksmart42.khtour.service.AccomReviewService;
import ksmart42.khtour.service.PlanService;
import ksmart42.khtour.service.RecordBoardService;
import ksmart42.khtour.service.RoomService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private static final Logger log = LoggerFactory.getLogger(MypageController.class);
	
	
	private PlanService planService;
	private RecordBoardService recordBoardService;
	private RoomService roomService;
	
	public MypageController(PlanService planService, RecordBoardService recordBoardService, RoomService roomService) {
		this.planService = planService;
		this.recordBoardService = recordBoardService;
		this.roomService = roomService;

	}
	
////GET 방식   ////
	   
  /* 1. 리스트 조회 (권한별로 확인)
  *  작성자 : 김민석, 안창현
  *  입  력 : Model
  *  출  력 : String(주소)
  *  설  명 : 여행게시판, 여행일정 리스트, 예약정보리스트, 리뷰리스트 - get방식 전달
  */
	@GetMapping("/mypage")
	public String getMypageList(Model model) {

		Map<String, Object> paramMap = new HashMap<String, Object>();


		List<RecordBoard> recordBoardList = recordBoardService.getRecordBoardList(paramMap);
		List<Plan> planList = planService.getPlanList(paramMap);
		List<Reservation> reservationList = roomService.getReservationList(paramMap);

		model.addAttribute("title", "결제 정보 등록 페이지");
		model.addAttribute("recordBoardList", recordBoardList);
		model.addAttribute("planList", planList);
		model.addAttribute("reservationList", reservationList);
		
		return "/mypage/mypage";
	}
}
