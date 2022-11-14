<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(function () {
			$("#checkJson").click(function() {
				alert("함수 호출");
				var jsonStr = '{"name" : "박지성", "age":25, "gender":"남자","nickname":"날센돌이"}';
				var jsonObj = JSON.parse(jsonStr);
				var output = "회원 정보<br>";
				output += "=======<br>";
				output += "이름: "+jsonObj.name+"<br>";
				output += "나이: "+jsonObj.age+"<br>";
				output += "성별: "+jsonObj.gender+"<br>";
				output += "별명: "+jsonObj.nickname+"<br>";
				$("#output").html(output);
			});
		});
	</script>
</head>
<body>
	<input id="checkJson" type="button" value="출력" />
	<br>
	<div id="output"></div>
</body>
</html>