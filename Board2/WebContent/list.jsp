<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

	<a href="insertui.do">글쓰기</a>

	<h1>게시판</h1>
	<c:forEach items="${list}" var="dto">
		${dto.num} : <a href="read.do?num=${dto.num}"> ${dto.title}</a> : ${dto.author} :${dto.writeday} : ${dto.readcnt} : ${dto.repRoot} : ${dto.repStep} : ${dto.repIndent}
		<br>
	
	</c:forEach>
	



</body>
</html>