<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"
	isELIgnored="false"    
%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="m1" property="*" />
<jsp:useBean id="membersList" class="java.util.ArrayList" />
<jsp:useBean id="membersMap" class="java.util.HashMap" />
<%
	membersMap.put("id","na");
	membersMap.put("pwd", "6487");
	membersMap.put("name", "나지원");
	membersMap.put("email", "na@test.com");
	
	MemberBean m2 = new MemberBean("jo", "0137", "조슬기", "jo@test.com");
	membersList.add(m1);
	membersList.add(m2);
	membersMap.put("membersList", membersList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr align=center bgcolor=lightgreen>
			<td width="20%">아이디</td>
			<td width="20%">비밀번호</td>
			<td width="20%">이름</td>
			<td width="20%">이메일</td>	
		</tr>
		<tr align=center>
			<td>${membersMap.id}</td>
			<td>${membersMap.pwd}</td>
			<td>${membersMap.name}</td>
			<td>${membersMap.email}</td>
		</tr>
		<tr align=center>
			<td>${membersMap.membersList[0].id}</td>
			<td>${membersMap.membersList[0].pwd}</td>
			<td>${membersMap.membersList[0].name}</td>
			<td>${membersMap.membersList[0].email}</td>
		</tr>
		<tr align=center>
			<td>${membersMap.membersList[1].id}</td>
			<td>${membersMap.membersList[1].pwd}</td>
			<td>${membersMap.membersList[1].name}</td>
			<td>${membersMap.membersList[1].email}</td>
		</tr>
	</table>
</body>
</html>