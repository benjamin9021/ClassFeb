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
input[type=text], select {
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	padding: 12px 20px
}

input[type=date], select {
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 20%;
	background-color: #808080;
	color: white;
	padding: 10px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button[type=button] {
	width: 20%;
	background-color: #808080;
	color: white;
	padding: 10px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

td {
	width: 100px;
	height: 50px;
	border: 1px solid;
}

body {
	background-color: #f2f2f2
}

.container {
	width: 50%
}
</style>


</head>
<body>
	<div class="jumbotron text-center" style="background-color: #3C4023;">
		<h1>
			<a style="color: white;" href="blist.do">PROJECT</a>
		</h1>
	</div>
	<div class="container text-left">
		<h2>회원정보 수정</h2>
		<hr>

		<form action="mupdate.do" method="post">
			<table class="table table-striped">
				<thead>
					<tr style="background-color: #6C7336;">
						<th>구분</th>
						<th>정보</th>
					</tr>
				</thead>
				<tbody>
					<tr class="active">
						<td style="background-color: #8C7F77; color: white">아이디</td>
						<td><input type="text" readonly name="id" id="id"
							value="${dto.id}">
					</tr>

					<tr class="active">
						<td style="background-color: #8C7F77; color: white">비밀번호</td>

						<td><c:if test="${dto.id != login.id }">
								<input type="password" id="pw" required readonly
									placeholder="비밀번호" name="pw">
								<input type="hidden" value="${dto.pw }">
							</c:if> <c:if test="${dto.id == login.id }">
								<input type="password" id="pw" required placeholder="비밀번호"
									name="pw">
							</c:if></td>
					</tr>
					<tr class="active">
						<td style="background-color: #8C7F77; color: white">성함</td>
						<td><input type="text" id="name" required placeholder="name"
							name="name" value="${dto.name }"></td>
					</tr>
					<tr class="active">
						<td style="background-color: #8C7F77; color: white">생년월일</td>
						<td><input id="birth" required placeholder="생년월일" type="date"
							name="birthday" value="${dto.birthday }"></td>


					<c:if test="${login.nKey == 1000 }">
                     <input type="hidden" value="${dto.nKey }" name="nkey">
                     <label for="nkey">등급변경</label>
                     <br>
                     <select name="nKey">
                     	<option value="1000">경영자</option>
                        <option value="100">관리자</option>
                        <option value="10">회원</option>
                     </select>
                  </c:if>

					</tr>
				</tbody>
			</table>
			<hr>
			<div class="text-right">
				<input type="submit" value="수정"> <a href="blist.do"><button
						type="button">취소</button></a><br> <br>
			</div>
		</form>
	</div>
</body>
</html>