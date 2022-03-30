package ksmart42.khtour.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.khtour.dto.LoginHistory;
import ksmart42.khtour.dto.Member;
import ksmart42.khtour.dto.MemberLevel;
import ksmart42.khtour.mapper.MemberMapper;
import ksmart42.khtour.service.MemberService;
import ksmart42.khtour.controller.MemberController;

@Controller

public class MemberController {
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	//DI 의존성 주입 생성자 메소드 주입방식
	private MemberService memberService;
	private MemberMapper memberMapper;
		
	public MemberController(MemberService memberService, MemberMapper memberMapper) {
		this.memberService = memberService;
		this.memberMapper = memberMapper;
	}
	/*
	 * 로그인 화면
	 */
	@GetMapping("/loginMain")
	public String loginMain(Model model, @RequestParam(value="result", required = false) String result) {
		System.out.println("회원 로그인 화면 GetMapping");
		model.addAttribute("title", "회원 로그인");
		
		if(result != null) model.addAttribute("result", result);
		
		 return "member/loginMain"; 
	}
	
	@PostMapping("/member/loginMain")
	public String loginMain(Member member, HttpSession session, RedirectAttributes reAttr) {
		System.out.println("회원 로그인 처 PostMapping");
		String memberId = member.getMemberId();
		String memberPw = member.getMemberPw();
		
		Member checkMember = MemberMapper.getMemberInfoById(memberId);
		
		if(checkMember != null && checkMember.getMemberPw() != null && memberPw.equals(checkMember.getMemberPw())) {
			String sessionName = checkMember.getMemberName();
			String sessionLevel = checkMember.getMemberLevel();
			
			session.setAttribute("SID", memberId);
			session.setAttribute("SNAME", sessionName);
			session.setAttribute("SLEVEL", sessionLevel);
			
			log.info("로그인 성공");
			
			return "redirect:/";
		}
		
		reAttr.addAttribute("result", "등록된 회원이 없습니다.");
		
		return "redirect:/";
	}
	
	/*
	 * 로그인 정보 화면
	 */
	@GetMapping("/loginHistory")
	public String getLoginHistory(Model model) {
		
		model.addAttribute("title", "로그인 정보 페이지");
		
		return "/member/loginHistory";
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
	 */
	
	  @PostMapping("/idCheck")
	  @ResponseBody 
	  public boolean isIdCheck(@RequestParam(value = "memberId") String memberId) { 
		  boolean idCheck = false;
		  log.info("아이디 중복 체크 클릭시 요청 받는 memberId 값 : {}", memberId);
	  
		  boolean result = MemberMapper.isIdCheck(memberId);
		  if(result) idCheck = true;
		  
		  log.info("아이디 중복 체크 여부 : {}", result);
		  return idCheck;
	  }
	 
	
	/*
	 * 회원 정보 검색 및 전체 리스트 화면
	 * 회원정보 삭제 기능
	 */
	@GetMapping("/memberList")
	public String getMemberList(Model model, @RequestParam(name="memberId", required = false) String memberId) {
		
		model.addAttribute("title", "회원 정보 검색 및 전체 리스트 페이지");
		List<Member> memberList = memberService.getMemberList(null, null);
		model.addAttribute("memberList", memberList);
		model.addAttribute("memberId", memberId);
		
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