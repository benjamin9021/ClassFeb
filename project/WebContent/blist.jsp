<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
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
body{
background-color: #f2f2f2
}

.container{
width:50%
}
</style>


</head>
<body>
	
	<% DecimalFormat df = new DecimalFormat("00");
   Calendar nowdate = Calendar.getInstance();
   
   String nowYear = Integer.toString(nowdate.get(Calendar.YEAR));
   String nowMonth = df.format(nowdate.get(Calendar.MONTH)+1);
   String nowDay = df.format(nowdate.get(Calendar.DATE));
   String nowdateff = nowYear +"/" + nowMonth+"/" + nowDay;

%>

	<div class="jumbotron text-center" style="background-color: #3C4023;">
		<h1>
			<a style="color: white;" href="blist.do">PROJECT</a>
		</h1>
	</div>
	<nav class="navbar navbar-dark" style="background-color: #3C4023;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="blist.do" style="color: white;">Home</a>
			</div>
			<ul class="nav navbar-nav">
				
				<c:if test="${login.nKey >=100}">
					<li><a href="mlist.do" style="color: white;">Member</a></li>
				</c:if>
			</ul>
		<ul class="nav navbar-nav navbar-right">
           <li>
           <c:if test="${not empty login }">
           <h4><span class="label label-default">${login.name } 님 환영합니다.</span></h4>
           </c:if>
           
           
                      
           </li>
            <li><c:choose>
                  <c:when test="${not empty login }">
                  
                     <a href="mread.do?id=${login.id }" style="color: white;"><span
                        class="glyphicon glyphicon-user"></span> 회원정보</a> <!-- 정보쪽으로 이동 -->
                  </c:when>
                  <c:otherwise>
                     <a href="minsertui.do" style="color: white;"><span
                        class="glyphicon glyphicon-user"></span> 회원가입</a>
                  </c:otherwise>

               </c:choose></li>

            <li><c:choose>

                  <c:when test="${not empty login }">
              
               <a href="mlogout.do" style="color: white;"><span class="glyphicon glyphicon-log-out" ></span> 로그아웃</a>
                  </c:when>

                  <c:otherwise>

                     <form action="mlogin.do" method="post">
                        <span style="color: white;"> ID: <input name="id"
                           required
                           style="margin-top: 12px; background-color: #f2f2f2; color: black;">
                           PW: <input name="pw" type="password" required
                           style="margin-top: 12px; background-color: #f2f2f2; color: black;">

                           <input style="background-color: #6C7336; color: white;"
                           type="submit" value="로그인" class="btn btn-default">
                        </span>
                     </form>
                  </c:otherwise>
               </c:choose></li>

         </ul>
      </div>
   </nav>
	

	<h1 style="text-align: center; color: #6C7336;">게시판</h1>
	<div class="container">
		<table class="table table-striped table-hover " style="">
			<thead>
				<tr style="background-color: #6C7336">
					<th style="width: 5%;">NO.</th>
					<th>&nbsp;제목</th>
					<th>작성자</th>
					<th style="text-align: center;">작성일</th>
					<th style="text-align: center;">조회수</th>
					<c:if test="${login.nKey >=100 }">
						<th style="text-align: center;">삭제</th>
					</c:if>
				</tr>
			</thead>
  			<c:set var="nowdate" value='<%=nowdateff %>'/>
			<tbody>
				<c:forEach items="${list }" var="dto">
					<tr class="active">
						<td style="background-color: #8C7F77; color: white">${dto.num }</td>
						<td><c:forEach begin="1" end="${dto.repIndent }">
				&nbsp; </c:forEach>
				<c:if test="${dto.repStep >= 1}">ㄴ[답글]</c:if>
				<c:if test="${dto.repStep == dto.repIndent+1 && dto.repStep > 0 }">[원본글이 삭제 됨]</c:if>
				<a href="bread.do?num=${dto.num }">
				${dto.title }</a>
				<c:if test="${dto.writeday == nowdate}">
				<img src='https://t1.daumcdn.net/cfile/tistory/1203574F5101207C0D'>
				</c:if></td>
						<td>${dto.id }</td>
						<td style="text-align: center;">${dto.writeday }</td>
						<td style="text-align: center;">${dto.readcnt }</td>
						<c:if test="${login.nKey >=100 }">
							<td style="text-align: center;">
							<a onclick="return confirm('삭제하시겠습니까?')" href="bdelete.do?num=${dto.num}">삭제</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="text-right">
			<button type="button" onclick="location.href='binsertui.do'"
				class="btn btn-default"
				style="background-color: black; color: white;">글쓰기</button>
		</div>
	</div>

	<jsp:include page="search.jsp" />
	<jsp:include page="page.jsp" />
</body>
</html>