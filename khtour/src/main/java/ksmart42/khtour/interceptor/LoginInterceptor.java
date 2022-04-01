package ksmart42.khtour.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		
		String requestURI = request.getRequestURI();
		
		if(sessionId == null) {
			response.sendRedirect("/member/login");
			return false;
		}else {
			if("2".equals(sessionLevel)) {

				// 판매자인경우 회원관리 관련 주소요청 제어
				if( requestURI.indexOf("member/memberList") > -1 	||
				    requestURI.indexOf("member/memberInsert") > -1 	||
				    requestURI.indexOf("member/modifyMember") > -1 	||
				    requestURI.indexOf("member/removeMember") > -1 		) {
					
					response.sendRedirect("/");
					
					return false;
				}
			}else if ("3".equals(sessionLevel)) {
				if( requestURI.indexOf("member/memberList") > -1 	||
					requestURI.indexOf("member/addMember") > -1 	||
					requestURI.indexOf("member/modifyMember") > -1 	||
					requestURI.indexOf("member/removeMember") > -1 		) {
						
					response.sendRedirect("/");
						
					return false;
				}
			}
		}
		
		return true;
	}
}
