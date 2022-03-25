package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RefundController {
	
	/*
	 * 환불 정보 등록 화면
	 */
	@GetMapping("/refund/refundInsert.html")
	public String getRefundInsert(Model model) {
		
		model.addAttribute("title", "환불 정보 등록 페이지");
		
		return "/refund/refundInsert.html";
	}
	
	/*
	 * 환불 신청 내역 화면
	 */
	@GetMapping("/refund/refundList.html")
	public String getRefundList(Model model) {
		
		model.addAttribute("title", "환불 신청 내역 페이지");
		
		return "/refund/refundList.html";
	}
	
	/*
	 * 환불 세부 정보 화면
	 */
	@GetMapping("/refund/refundDetail.html")
	public String getRefundDetail(Model model) {
		
		model.addAttribute("title", "환불 세부 정보 페이지");
		
		return "/refund/refundDetail.html";
	}
}