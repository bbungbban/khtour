package ksmart42.khtour.interceptor;

import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import groovy.transform.builder.InitializerStrategy.SET;

@Component
public class CommonInterceptor implements HandlerInterceptor{
	
	
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
	
	/**
	 * controller( == handle) 진입 전 실행되는 메소드
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				
		HandlerMethod method = (HandlerMethod) handler;
		
		//ex:) memberId memberPw memberLevel
		Set<String> keySet = request.getParameterMap().keySet();
		
		//문자열마다 구분자를 넣는 클래스
		StringJoiner param = new StringJoiner(", ");
		
		//memberId: id001, memberPw: pw001
		for(String key : keySet) {
			param.add(key + ": " + request.getParameter(key));
		}
		
		log.info("CommonInterceptor =====================================START");
		log.info("ACCESS INFO =====================================START");
		log.info("PORT 			::::::		{}", request.getLocalPort());
		log.info("SERVER NAME 	::::::		{}", request.getServerName());
		log.info("HTTP METHOD 	::::::		{}", request.getMethod());
		log.info("URI 			::::::		{}", request.getRequestURI());
		log.info("Controller 	::::::		{}", method.getBean().getClass().getSimpleName());
		log.info("PARAMETER 	::::::		{}", param);
		log.info("ACCESS INFO =====================================END");
		log.info("CommonInterceptor =====================================END");
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	/**
	 * handler adapter 실행 후 view 랜더링 전 ( 매개변수 ModelAndView) 실행되는 메소드
	 */
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("CommonInterceptor =====================================postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * view 랜더링 후 실행되는 메소드
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("CommonInterceptor =====================================afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
