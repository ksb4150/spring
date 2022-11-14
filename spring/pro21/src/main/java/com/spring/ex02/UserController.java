package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userID = "";
//		String passwd = "";
//		ModelAndView mav = new ModelAndView();
//		
//			   request.setCharacterEncoding("utf-8");
//			   userID = request.getParameter("userID");
//			   passwd = request.getParameter("passwd");
//			   mav.addObject("userID", userID);
//			   mav.addObject("passwd", passwd);
//			   mav.setViewName("result");
//			   return mav;
//	}
	
	public UserController() {
		System.out.println("UserController 생성자 호출");
	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		
		request.setCharacterEncoding("utf-8");
			userID = request.getParameter("userID");
			passwd = request.getParameter("passwd");
		String viewName = getViewName(request);
		
			mav.addObject("userID", userID);	
			mav.addObject("passwd", passwd);
			//mav.setViewName("result");
			mav.setViewName(viewName);
			System.out.println("ViewName : "+viewName);
			
		return mav;
	}
	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
			   mav.addObject("id", id);
			   mav.addObject("pwd", pwd);
			   mav.addObject("name", name);
			   mav.addObject("email", email);
			   mav.setViewName("memberInfo");
	
		return mav;
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
		
		String fileName = uri.substring(begin, end);
			System.out.println("fileName : " + fileName );
			
		if(fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			// 가장 마지막 .의 위치를 구한 후, .뒤 문자열을 제거
		}
		
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
			// 가장 마지막 /의 위치를 구한 후, / 다음부터의 문자열을 구함
		}
		
		return fileName; //출력할 뷰의 이름을 반환
	}
}
