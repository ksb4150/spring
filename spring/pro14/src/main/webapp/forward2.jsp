<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="sec01.ex01.*" pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@test.com");
	request.setAttribute("member", member);
	request.setAttribute("test", "test");
	request.setAttribute("t2", "t2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward2</title>
</head>
<body>
	<jsp:forward page="elMember2.jsp"></jsp:forward>
</body>
</html>