<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
button[type=button] {
  width: 10%;
  background-color: #808080;
  color: white;
  padding: 10px 2px;
  margin: 0px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
body{
background-color: #f2f2f2
}

.container{
width:50%
}
</style>
</head>
<body>
 <div class="jumbotron text-center" style="background-color: #3C4023;">
     <h1>
     <a style="color: white;" href="blist.do">PROJECT</a>
     </h1>
   </div>

<nav class="navbar navbar-dark" style="background-color:#3C4023;">
  <div class="container-fluid">
    <div class="navbar-header" >
      <a class="navbar-brand" href="blist.do" style="color: white;">Main</a>
    </div>
    </div>
  </nav>



<h2 style="text-align: center; color: #6C7336;">회원 관리</h2>
<div class="container">

  <table class="table table-striped">
    <thead>
      <tr style="background-color: #6C7336;">
        <th>아이디</th>
        <th>이름</th>
        <th>게시글보기</th>
        <th style="text-align:center;">가입일</th>
      </tr>
    </thead>
    <tbody>
       <c:forEach items="${list }" var="var">
      <tr class="active">
	<td style="background-color: #8C7F77; color: white">
	<a href="mread.do?id=${var.id}" style="color: white;">${var.id}</a></td>  
	<td> ${var.name }</td>

<%--        <c:if test="${var.nKey !=1000}"> --%>
<%--    <td><a href="mdelete.do?id=${var.id }">관리</a></td> --%>
<%--    </c:if> --%>
<%--    <c:if test="${var.nKey ==1000}"> --%>
<!--    <td>본인</td> -->
<%--    </c:if> --%>
   <c:if test="${var.nKey !=1001}">
   <td> <a href="blist.do?option=id&searchtext=${var.id }&curPage=1">게시글보기</a></td>
   </c:if>
   <c:if test="${var.nKey !=1001}" >
    <td style="text-align: center;">${var.signupday}</td>
   </c:if>
</c:forEach>
      
    </tbody>
  </table>
<div class="text-right">
<button type="button" style="text-align: center;" class="btn btn-default" onclick="location.href='mlist.do'">회원목록</button>
<jsp:include page="footer.jsp"/>
</div>
</div>
</body>
</html>