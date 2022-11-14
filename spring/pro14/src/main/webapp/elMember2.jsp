<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%
	request.setCharacterEncoding("utf-8");
/*
	String id = (String) request.getAttribute("id");
	String pwd = (String) request.getAttribute("pwd");
	String name = (String) request.getAttribute("name");
	String email = (String) request.getAttribute("email");
*/
	request.getAttribute("member");	
	String str = request.getParameter("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border=1>
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
		</tr>
		<%-- 
		<tr align="center">
				<td>${id}</td>
				<td>${pwd}</td>
				<td>${name}</td>
				<td>${email}</td>
			</tr>
--%>
		<tr align="center">
				<td>${member.id}</td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${test}</td>
			</tr>
		<tr align="center">
				<td><%=str%></td>
				<td>${member.pwd}</td>
				<td>${member.name}</td>
				<td>${test}</td>
			</tr>
	</table>
</body>
</html>