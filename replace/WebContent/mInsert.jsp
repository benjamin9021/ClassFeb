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
body {
	
}

input[type=text], select {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=date], select {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 10%;
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

	<div class="jumbotron text-center" style="">
		<h1>회원 가입</h1>
	</div>

	<hr>
	<div class="container">
	<form action="minsertui.do" method="post">
		<label for="id">아이디</label><br> <input type="text" id="id"
			required placeholder="아이디" name="id">
		<button type="button">중복 확인</button>
		<hr>
		<label for="pw">비밀번호</label><br> <input type="text" id="pw"
			required name="pw" placeholder="비밀번호" type="password">
		<hr>
		<label for="name">성함</label><br> <input type="text" id="name"
			required name="name" placeholder="성함">
		<hr>
		<br> <label for="birth">생년월일</label><br>
		<br> <input id="birth" required name="birthday"
			placeholder="생년월일 " type="date">
		<hr>
		<input type="submit" value="등록" class="btn btn-dark">

	</form>
	</div>


	<script type="text/javascript">
      $(document).ready(function() {
         
         $("button").click(function() {
             var id = $("input[name='id']").val();
             
             $.ajax({
                type: 'get',
                url : 'mCheckId.do',
                data: {
                   id : id
                },
                dataType: 'text',
                success : function(result) {
                   $("p").text(result);
                }
             });
      });
         
   
   });
</script>
</body>
</html>