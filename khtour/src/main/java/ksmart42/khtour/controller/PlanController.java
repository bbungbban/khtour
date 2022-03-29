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

import ksmart42.khtour.dto.Plan;
import ksmart42.khtour.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	private PlanService planService; 
	
	public PlanController(PlanService planService) {
		this.planService = planService;
	}
	
	/*
	 * 여행 계획 조회 (관리자)(Get 정보 전달)
	 */
	@GetMapping("/planListSt")
	public String getPlanListSt(Model model) {
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		List<Plan> planList = planService.getPlanList(paramMap);
		
		model.addAttribute("title", "여행 계획 관리페이지");
		model.addAttribute("planList", planList);
		
		return "plan/planListSt";
	}
	
	/*
	 * 여행 계획 정보 수정 (관리자) (Post 정보 전달)
	 */
	@PostMapping("/modifyPlan")
	public String modifyPlan(Plan plan) {
		
		planService.modifyPlan(plan);
		System.out.println("정보 수정 포스트 전달" + planService.modifyPlan(plan));
		
		return "redirect:/plan/planListSt";
	}
	
	/*
	 * 여행 계획 정보 수정 (관리자) (Get 정보 전달)
	 */
	@GetMapping("/planModify")
	public String modifyPlan(
			@RequestParam(value="planCode", required = false) String planCode
			,Model model) {
		Plan plan = planService.getPlanByCode(planCode);
		
		model.addAttribute("title", "여행 계획 수정 페이지");
		model.addAttribute("plan", plan);
		System.out.println("정보 수정 겟방식 전달" + plan);
		
		return "plan/planModify";
	}	
	
	/*
	 * 여행 계획 정보 삭제(post 정보 전달)
	 */
	@GetMapping("/planRemove")
	public String removePlan(Plan plan) {
		String planCode = plan.getPlanCode();
		
		planService.removePlan(planCode);
		System.out.println("정보 삭제 포스트 전달" + planService.removePlan(planCode));
		
		return "redirect:/plan/planListSt";
		
	}
			
	/*
	 * 여행 계획 등록(Post 정보 전달)
	 */
	@PostMapping("/planInsert")
	public String addPlan(Plan plan) {
		
		plan.setMemberId("id001");
		planService.addPlan(plan);
		
		return "redirect:/plan/planListSt";
	}
	/*
	 * 여행 계획 등록(Get 정보 전달)
	 */
	@GetMapping("/planInsert")
	public String addPlan(Model model) {
		
		model.addAttribute("title", "여행 계획 등록");
		
		return "plan/planInsert";
	}
	
}
