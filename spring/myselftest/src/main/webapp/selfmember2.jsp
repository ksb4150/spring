<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" pageEncoding="utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="m" class=sec01.ex01.MemberBean" scope="page" />
	
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("username");
	String email = request.getParameter("email");
	
	m.setId(id);
	m.setPwd(pw);
	m.setName(name);
	m.setEmail(email);
	
	MemberDAO dao = new MemberDAO();
	dao.addMember(m);
	List memberList = dao.listMembers();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>