package ksmart42.khtour.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.Member;
import ksmart42.khtour.mapper.MemberMapper;
import ksmart42.khtour.service.MemberService;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	/*
	 * 로그인 화면
	 */
	@PostMapping("/loginMain")
	public String loginMain(Member member, HttpSession session, RedirectAttributes reAttr) {
		
		String memberId = member.getMemberId();
		String memberPw = member.getMemberPw();
		
		Member checkMember = MemberMapper.getMemberInfoById(memberId);
		
		if()
		model.addAttribute("title", "로그인 페이지");
		
		return "/member/loginMain";
	}
	
	/*
	 * 회원가입 화면
	 */
	@GetMapping("/memberInsert")
	public String getMemberInsert(Model model) {
		
		model.addAttribute("title", "회원가입 페이지");
		
		return "/member/memberInsert";
	}
	
	/*
	 * 아이디 중복 체크
	 * 수정 중
	 */
	/*
	 * @PostMapping("/idCheck")
	 * 
	 * @ResponseBody public boolean isIdCheck(@RequestParam(value = "memberId")
	 * String memberId) { boolean idCheck = false;
	 * log.info("아이디 중복 체크 클릭시 요청 받는 memberId 값", memberId);
	 * 
	 * boolean result = MemberMapper.isIdCheck(memberId); }
	 */
	
	/*
	 * 회원 정보 검색 및 전체 리스트 화면
	 */
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		
		model.addAttribute("title", "회원 정보 검색 및 전체 리스트 페이지");
		List<Member> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		
		return "/member/memberList";
	}
	/*
	 * 회원 정보 화면
	 */
	@GetMapping("/memberInfo")
	public String getMemberInfo(Model model) {
		
		model.addAttribute("title", "회원 정보 페이지");
		
		return "/member/memberInfo";
	}
	/*
	 * 회원 정보 삭제 화면
	 */
	@GetMapping("/memberDelete")
	public String getMemberDelete(Model model) {
		
		model.addAttribute("title", "회원 정보 삭제 페이지");
		
		return "/member/memberDelete";
	}
	/*
	 * 회원 이메일 찾기 화면
	 */
	@GetMapping("/memberId")
	public String getMemberId(Model model) {
		
		model.addAttribute("title", "회원 이메일 찾기 페이지");
		
		return "/member/memberId";
	}
	/*
	 * 회원 비밀번호 찾기 화면
	 */
	@GetMapping("/memberPw")
	public String getMemberPw(Model model) {
		
		model.addAttribute("title", "회원 비밀번호 찾기 페이지");
		
		return "/member/memberPw";
	}
}