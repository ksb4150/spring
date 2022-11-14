<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
	String height = request.getParameter("height");
%>
<c:set var="id" value="<%=id %>" scope="page"/>
<c:set var="name" value="<%=name %>" scope="page"/>
<c:set var="age" value="<%=age %>" scope="page"/>
<c:set var="email" value="<%=email %>" scope="page"/>
<c:set var="height" value="<%=height %>" scope="page"/>

<c:set var="hid" value="hong" scope="page" />
<c:set var="hpwd" value="1234" scope="page" />
<c:set var="hname" value="홍길동" scope="page" />
<c:set var="hage" value="22" scope="page" />
<c:set var="hheight" value="177" scope="page" />
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
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>키</b></td>
		</tr>
		<tr align="center">
			<td>${id}</td>
			<td><c:out value="${param.pwd}" /></td> <!-- request.getPrameter.pwd와 같음  -->
			<td>${name}</td>
			<td>${age}</td>
			<td>${email}</td>
			<td>${height}</td>
		</tr>
		<tr align="center">
			<td>${hid}</td>
			<td>${hpwd}</td>
			<td>${hname}</td>
			<td>${hage}</td>
			<td>${hemail}</td>
			<td>${hheight}</td>
		</tr>
	</table>
</body>
</html>