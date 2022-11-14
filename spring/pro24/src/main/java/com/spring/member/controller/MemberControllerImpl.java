package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.service.MemberServiceImpl;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController {
	private MemberService memberService;
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("membersList", membersList);
			return mav;
	}
	
	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();

		/*
		 * String id = request.getParameter("id"); String pwd =
		 * request.getParameter("pwd"); String name = request.getParameter("name");
		 * String email = request.getParameter("email"); memberVO.setId(id);
		 * memberVO.setPwd(pwd); memberVO.setName(name); memberVO.setEmail(email);
		 */
		bind(request, memberVO);
		int result = 0;
			result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		
		return mav;
	}
	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
			memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		
		return mav;
	}
	
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
			
		return mav;
	}
	
	public ModelAndView modForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
		
		return mav;
	}
	
	public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		
		bind(request, memberVO);
		int result = 0;
			result = memberService.modMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		
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