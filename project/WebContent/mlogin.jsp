<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
input[type=submit] {
	width: 20%;
	background-color: #808080;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
button[type=button] {
	width: 14%;
	background-color: #808080;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>
<body>

	<div class="jumbotron text-center" style="background-color:#ffe5cc;">
		<h1>게시판프로젝트</h1>
	</div>
	<div class=text-center">
	<h2>로그인</h2>
	</div>
	<div class="contatiner">
	<form action="mlogin.do" method="post">
		<div class="form-group">
		<input name="id" placeholder="ID" required maxlength="20px"><br></div>
		<div class="form-group">
		<input name="pw" type="password" placeholder="PW" required maxlength="20px"><br></div>
		<input type="submit" class="btn btn-dark" value="로그인" "> <br>
		<button type="button" class="btn btn-dark" onclick="location.href='minsertui.do'">회원가입</button>
	</form>
		</div>
	
</body>
</html>