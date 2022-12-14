<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입창</title>
	<style>
		.text_center{ 
			text-align: center;
		}
	</style>
</head>
<body>
	<form action="${contextPath}/testmem/insertMember.do">
		<h1 class="text_center">회원 가입창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">사용자 아이디</p></td>
				<td width="400"><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">사용자 비밀번호</p></td>
				<td width="400"><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">사용자 이름</p></td>
				<td width="400"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td width="200"><p align="right">사용자 이메일</p></td>
				<td width="400"><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="입력완료">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>