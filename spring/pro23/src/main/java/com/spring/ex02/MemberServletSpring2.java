package com.spring.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

/**
 * Servlet implementation class MemberServletSpring
 */
@WebServlet("/springmem2.do")
public class MemberServletSpring2 extends HttpServlet {
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("springmem2 init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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

	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MemberDAO dao = new MemberDAO();
		/*
		 * String name = dao.selectName(); int pwd = dao.selectPwd();
		 * 
		 * PrintWriter pw = response.getWriter(); pw.write("<script>");
		 * pw.write("alert('이름 : "+name+" 비밀번호 : "+pwd+"');"); pw.write("</script>");
		 */
			
		List<MemberVO> membersList = dao.selectAllMemberList();
		request.setAttribute("membersList", membersList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/test01/listMember.jsp");
		dispatch.forward(request, response);
		
	}
}
