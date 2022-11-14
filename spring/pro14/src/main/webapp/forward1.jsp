<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sec01.ex01.*"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("id", "hone");
	request.setAttribute("pwd", "1234");
	request.setAttribute("name", "홍길동");
	request.setAttribute("email", "hong@test.com");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>
	<jsp:forward page="elMember2.jsp" />
</body>
</html>