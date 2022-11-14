<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습 3-2</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap05.0.0-beta2/dist/css/bootstrap.mincss"
	rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>
	<div class="container bg-warning shadow mx-auto mt-5 p-5 w-75">
		<h2>My ToDo App</h2>
		<hr>
		<div class="input-group">
			<input id="item" class="form-control" type="text" placeholder="할일을 입력하세요..">
			<button type="button" class="btn btn-primary" onclick="addItem()">할일 추가</button>
		</div>
	</div>
</body>
</html>