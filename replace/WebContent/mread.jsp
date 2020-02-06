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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>

<body>

	<h1> 회원 정보 보기</h1>
	
	아 이 디  : ${dto.id}<br>
	비밀번호 : ${dto.pw}<br>
	이      름 : ${dto.name}<br>
	생년월일 : ${dto.birthday}<br>
	등급정보 : ${dto.nkey}<br>
	
	<a href="updateui.do?id=${dto.id}">수정</a>
	<a href="delete.do?id=${dto.id}">삭제</a>
	<a href="list.do">목록</a>
	
</body>

</html>