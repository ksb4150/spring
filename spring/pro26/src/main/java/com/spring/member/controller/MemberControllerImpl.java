package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	public MemberControllerImpl() {
		System.out.println("controller 생성자");
	}
	
	@Override
	@RequestMapping(value="/member/listMembers.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do", method=RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		
			int result = 0;
			result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		
		return mav;
	}

	@Override
	@RequestMapping(value="/member/removeMember.do", method=RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
			
			memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		
		return mav;
	}

	@RequestMapping(value="/member12/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
			
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
