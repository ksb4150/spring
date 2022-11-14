<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" isELIgnored="false" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
 <%
 	request.setCharacterEncoding("utf-8");
 %>
<!DOCTYPE html>
<html>
<head>
	<c:choose>
		<c:when test ='${msg == "addMember" }'>
			<script>
				window.onload = function() {
					alert("회원을 등록했습니다.");
				}
			</script>
		</c:when>
		<c:when test = '${msg == "modified" }'>
			<script>
				window.onload = function () {
					alert("회원 정보를 수정했습니다.");
				}
			</script>
		</c:when>
		<c:when test = '${msg == "deleted" }'>
			<script>
				window.onload = function() {
					alert("회원 정보를 삭제했습니다.");
				}
			</script>
		</c:when>
	</c:choose>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="8%">이름</td>
			<td width="7%">이메일</td>
			<td width="10%">가입일</td>
			<td width="7%">수정</td>
			<td width="7%">삭제</td>
		</tr>
		<c:choose>
			<c:when test="${membersList == null }">
				<tr border="1">
					<td clospan="7">
						<b>등록된 회원이 없습니다.</b>
					</td>
				</tr>
			</c:when>
			<c:when test="${membersList != null }">
				<c:forEach var="mem" items="${membersList }">
					<tr align="center">
						<td>${mem.id }</td>
						<td>${mem.pwd }</td>
						<td>${mem.name }</td>
						<td>${mem.email }</td>
						<td>${mem.joinDate }</td>
						<td><a href="${contextPath}/member3/modMemberForm.do?id=${mem.id}">수정</a></td>
						<td><a href="${contextPath}/member3/delMember.do?id=${mem.id}">삭제</a></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="${contextPath}/member3/memberForm.do">
		<p class="cls2">회원 가입하기 </p>
	</a>
</body>
</html>