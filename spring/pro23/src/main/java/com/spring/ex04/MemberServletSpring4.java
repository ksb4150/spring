package com.spring.ex04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/springmem4.do")
public class MemberServletSpring4 extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("springmem4 init 메서드 호출");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		String action = request.getParameter("action");
			System.out.println("action : " + action);
		String nextPage = "";
		
		if(action==null || action.equals("listMembers")) {
			List<MemberVO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		} else if(action.equals("selectMemberById")) {
			String id = request.getParameter("value");
			memberVO = dao.selectMemberById(id);
			request.setAttribute("member", memberVO);
			nextPage = "/test03/memberInfo.jsp";
		} else if(action.equals("selectMeberByPwd")) {
			int pwd = Integer.parseInt(request.getParameter("value"));
			List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		} else if(action.equals("insertMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				dao.insertMember(memberVO);
				nextPage = "/springmem4.do?action=listMembers";
		} else if(action.equals("insertMember2")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			Map<String, String> memberMap = new HashMap<String, String>();
				memberMap.put("id", id);
				memberMap.put("pwd", pwd);
				memberMap.put("name", name);
				memberMap.put("email", email);
				dao.insertMember2(memberMap);
				nextPage = "/springmem4.do?action=listMembers";
		} else if(action.equals("updateMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				dao.updateMember(memberVO);
				
				nextPage = "/springmem4.do?action=listMembers";
		} else if(action.equals("deleteMember")) {
			String id = request.getParameter("id");
				dao.deleteMember(id);
				
				nextPage = "/springmem4.do?action=listMembers";
		} else if(action.equals("searchMember")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
				memberVO.setName(name);
				memberVO.setEmail(email);
			List<MemberVO> membersList = dao.searchMember(memberVO);
				request.setAttribute("membersList", membersList);
				nextPage= "/test03/listMembers.jsp";
		} else if(action.equals("foreachSelect")) {
			List<String> nameList = new ArrayList();
				nameList.add("김수빈");
				nameList.add("성채은");
				nameList.add("홍수빈");
			List<MemberVO> membersList = dao.foreachSelect(nameList);
				request.setAttribute("membersList", membersList);
				
				nextPage = "test03/listMembers.jsp";
		} else if(action.equals("foreachInsert")) {
			List<MemberVO> memList = new ArrayList();
				memList.add(new MemberVO("kim1", "1234", "박길동", "m1@test.com"));
				memList.add(new MemberVO("kim2", "1234", "이길동", "m1@test.com"));
				memList.add(new MemberVO("kim3", "1234", "김길동", "m1@test.com"));
			int result = dao.foreachInsert(memList);
				nextPage = "springmem4.do?action=listMembers";
		} else if(action.equals("selectLike")) {
			String name = request.getParameter("name");
			List<MemberVO> membersList = dao.selectLike(name);
			request.setAttribute("membersList", membersList);
			
			nextPage = "test03/listMembers.jsp";
		}else {
			List<MemberVO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
	}
}
