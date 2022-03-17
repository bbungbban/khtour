package ksmart42.khtour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	/*
	 * 로그인 화면
	 */
	@GetMapping("/user/loginMain.html")
	public String getLoginMain(Model model) {
		
		model.addAttribute("title", "로그인 페이지");
		
		return "/login/loginMain.html";
	}
	
	/*
	 * 회원가입 화면
	 */
	@GetMapping("/login/userInsert.html")
	public String getUserInsert(Model model) {
		
		model.addAttribute("title", "회원가입 페이지");
		
		return "/login/userInsert.html";
	}
	/*
	 * 회원 정보 검색 및 전체 리스트 화면
	 */
	@GetMapping("/login/userList.html")
	public String getUserList(Model model) {
		
		model.addAttribute("title", "회원 정보 검색 및 전체 리스트 페이지");
		
		return "/login/userList.html";
	}
	/*
	 * 회원 정보 수정 화면
	 */
	@GetMapping("/login/userModify.html")
	public String getUserModify(Model model) {
		
		model.addAttribute("title", "회원 정보 수정 페이지");
		
		return "/login/userModify.html";
	}
	/*
	 * 회원 세부 정보 화면
	 */
	@GetMapping("/login/userDetail.html")
	public String getUserDetail(Model model) {
		
		model.addAttribute("title", "회원 세부 정보 페이지");
		
		return "/login/userDetail.html";
	}
	/*
	 * 회원 정보 삭제 화면
	 */
	@GetMapping("/login/userDelete.html")
	public String getUserDelete(Model model) {
		
		model.addAttribute("title", "회원 정보 삭제 페이지");
		
		return "/login/userDelete.html";
	}
}