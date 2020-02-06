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
.body {
	text-align: center;


}
.div.relative {
  position: relative;
  left: 30px;
  border: 3px solid #000000;
}
</style>
</head>
<body>
	<div>
		<h1 class="center" style="text-align: center; background-color: #F5F5DC; width:200px;height:10px;">로그인</h1>
	</div>
	
	<form class="center" action="mlogin.do" method="post">
		<div class="form-group">
		<input name="id" placeholder="ID" required maxlength="20px"><br></div>
		<div class="form-group">
		<input name="pw" type="password" placeholder="PW" required maxlength="20px"><br></div>
		<input type="submit" class="btn btn-primary" value="로그인" style="width:200px;height:20px;"> <br>
		<button type="button" class="btn black" onclick="location.href='minsertui.do'" style="width:120px;height:80px;">회원가입</button>
	</form>
</body>
</html>