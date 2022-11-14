<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="m" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table align="center" border=1>
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>나이</b></td>
		</tr>
<%--		<tr align="center">
			<td><%=m.getId() %> </td>
			<td><%=m.getPwd() %> </td>
			<td><%=m.getName() %> </td>
			<td><%=m.getEmail() %> </td>
		</tr>
		<tr align="center">
			<td>${m.id}</td>
			<td>${m.pwd}</td>
			<td>${m.name}</td>
			<td>${m.email}</td>
		</tr>
 --%>
 		<tr align="center">
 			<td>${membersList[0].id}</td>
 			<td>${membersList[0].pwd}</td>
 			<td>${membersList[0].name}</td>
 			<td>${membersList[0].email}</td>
 		</tr>
 		<tr align="center">
 			<td>${membersList[1].id}</td>
 			<td>${membersList[1].pwd}</td>
 			<td>${membersList[1].name}</td>
 			<td>${membersList[1].email}</td>
 		</tr>
	</table>
</body>
</html>