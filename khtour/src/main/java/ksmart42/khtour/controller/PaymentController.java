package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart42.khtour.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	private PaymentService paymentService;
	/*
	 * 결제 정보 등록 화면
	 */
	@GetMapping("/payment/payInsert.html")
	public String getPayInsert(Model model) {
		
		model.addAttribute("title", "결제 정보 등록 페이지");
		
		return "/payment/payInsert.html";
	}
	
	/*
	 * 결제 세부 정보 화면
	 */
	@GetMapping("/payment/payDetail.html")
	public String getPayDetail(Model model) {
		
		model.addAttribute("title", "결제 세부 정보 페이지");
		
		return "/payment/payDetail.html";
	}
}