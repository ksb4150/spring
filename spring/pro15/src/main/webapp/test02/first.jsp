<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="result.jsp">
		<input type=hidden name="param1" value="dog.jpg">
		<input type=hidden name="param2" value="cute.jpg">
		<input type="submit" value="이미지 다운로드">
	</form>
</body>
</html>