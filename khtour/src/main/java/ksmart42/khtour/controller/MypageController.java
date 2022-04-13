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

import ksmart42.khtour.dto.Plan;
import ksmart42.khtour.dto.RecordBoard;
import ksmart42.khtour.service.PlanService;
import ksmart42.khtour.service.RecordBoardService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	private static final Logger log = LoggerFactory.getLogger(MypageController.class);
	
	
	private PlanService planService;
	private RecordBoardService recordBoardService;
	
	public MypageController(PlanService planService, RecordBoardService recordBoardService) {
		this.planService = planService;
		this.recordBoardService = recordBoardService;

	}
	
	@GetMapping("/mypage")
	public String getPayInsert(Model model
			) {

		Map<String, Object> paramMap = new HashMap<String, Object>();


		List<RecordBoard> recordBoardList = recordBoardService.getRecordBoardList(paramMap);
		List<Plan> planList = planService.getPlanList(paramMap);
		
		
		model.addAttribute("title", "결제 정보 등록 페이지");
		model.addAttribute("recordBoardList", recordBoardList);
		model.addAttribute("planList", planList);
		
		return "/mypage/mypage";
	}
}
