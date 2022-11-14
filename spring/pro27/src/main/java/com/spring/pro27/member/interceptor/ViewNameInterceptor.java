package com.spring.pro27.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception {
		String viewName = getViewName(request);
		
		if(viewName != null) {
			request.setAttribute("viewName", viewName);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object Handler, ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object Handler, Exception ex) throws Exception {
		
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
			System.out.println(uri);
		
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
			System.out.println(uri);
		}
		
		int begin = 0;
		if(!((contextPath==null) || ("".equals(contextPath)))) {
			begin = contextPath.length(); //전체 요청명의 길이를 구함 -> 프로젝트
			System.out.println(contextPath);
		}
		System.out.println("begin : "+ begin);
		
		int end = 0;
		if(uri.indexOf(";") != -1) { //요청 uri에 ;가 있을 경우
			end = uri.indexOf(";"); 
			System.out.println("end : "+ end);
		} else if(uri.indexOf("?") != -1) { //요쳥 uri에 ?가 있을 경우 -> 파라미터를 받을 때인가?
			end = uri.indexOf("?");
			System.out.println("end : "+ end);
		} else {
			end = uri.length();
			System.out.println("end : "+ end);
		}
		
		
		String viewName = uri.substring(begin, end);
			System.out.println("viewName : " + viewName );
			
		if(viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
			// 가장 마지막 .의 위치를 구한 후, .뒤 문자열을 제거
		}
		
		if(viewName.lastIndexOf("/") != -1) {
			System.out.println(viewName.lastIndexOf("/",1));
			viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
			// 가장 마지막 /의 위치를 구한 후, / 다음부터의 문자열을 구함
		}
		
		return viewName; //출력할 뷰의 이름을 반환
	}
}
