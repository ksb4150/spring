<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<form action="result2.jsp" method="post">
			아이디 : <input type="text" size=20 name="userID"/><br>
			비밀번호 : <input type="password" size=20 name="userPw" /><br>
			<input type="submit" value="로그인" /> <input type="reset" value="다시입력" />
		</form>
		<br><br>
		<%--
			<a href="${pageContext.request.contextPath}/memberForm.jsp">회원가입하기</a>
		 --%>
		 <a href="${contextPath}/memberForm2.jsp">회원가입하기</a>
<%--		 
		<form action="result2.jsp" method="post">
			아이디 : <input type="text" size=20 name="userID"/><br>
			비밀번호 : <input type="password" size=20 name="userPw" /><br>
			<input type="submit" value="로그인" /> <input type="reset" value="다시입력" />
		</form>
		<br><br>
		<a href="${pageContext.request.contextPath}/contextPath}memberForm2.jsp">회원가입</a>
 --%>
</body>
</html>