<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:redirect url="member1.jsp">
		<c:param name="id" value="${'ksb4150'}" />
		<c:param name="pwd" value="${'1234'}" />
		<c:param name="name" value="${'김수빈'}" />
		<c:param name="age" value="${24}" />
		<c:param name="email" value="${'ksb4150@naver.com'}" />
		<c:param name="height" value="${158}" />
	</c:redirect>
</body>
</html>