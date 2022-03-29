package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Plan;
import ksmart42.khtour.mapper.PlanMapper;

@Service
@Transactional
public class PlanService {
	//DI 의존성 주입
	private PlanMapper planMapper;
	
	public PlanService(PlanMapper planMapper) {
		this.planMapper = planMapper;
	}
	
	/**
	 * 코드에 따른 여행 계획 조회
	 */
	public Plan getPlanByCode(String planCode) {
		return planMapper.getPlanByCode(planCode);
	}
	/**
	 * 여행 계획 등록
	 */
	public void addPlan(Plan plan) {
		planMapper.addPlan(plan);
	}
	
	/**
	 * 여행 계획 목록 조회
	 */
	public List<Plan> getPlanList(Map<String, Object> paramMap){
		List<Plan> planList = planMapper.getPlanList(paramMap);
		
		return planList;
	}

	/**
	 * 여행 계획 정보 수정
	 */
	public int modifyPlan(Plan plan) {
		return planMapper.modifyPlan(plan);
	}
	
	/**
	 * 여행 계획 정보 삭제
	 */
	public int removePlan(String planCode) {
		int result = planMapper.removePlan(planCode);
		
		result += planMapper.removePlan(planCode);
		
		return result;
	}
}
