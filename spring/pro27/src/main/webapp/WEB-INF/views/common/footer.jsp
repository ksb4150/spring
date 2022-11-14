<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>하단 부분</title>
	<style>
		p {
			font-size: 20px;
			text-align: center;
		}
	</style>
</head>
<body>
	<p>e-mail: ksb4150@naver.com </p>
	<p>집 주소 : 대전 광역시 서구 </p>
	<p>찾아오는 길 : <a href="#">약도</a></p>
</body>
</html>