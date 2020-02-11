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
textarea {
   width: 100%;
   padding: 12px 20px;
   margin: 8px 0;
   display: inline-block;
   border: 1px solid #ccc;
   border-radius: 4px;
   box-sizing: border-box;
}

input[type=text], select {
   width: 100%;
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

input[name=id] {
   width: 10%;
   padding: 14px 20px;
   margin: 8px 0;
   border: none;
   border-radius: 4px;
   cursor: pointer;
}

button[type=button] {
	width: 10%;
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
   <div class="jumbotron text-center" style="background-color: #3C4023;">
      <h1><a style="color: white;" href="blist.do">PROJECT</a></h1>
   </div>


   <div class="container">

      <form action="binsert.do" method="post">

         <h2> 자세히 보기</h2>


         <hr>
         <div class="row">
            <div class="col-sm-1">
               <div class="text-left">
                  <span style="margin-left: 20px;" class="label label-info">NO.${dto.num }</span>
               </div>
               
            </div>
            <div class="col-sm-8">
            <div class="text-left">
               <h3 style=" margin-top: 0px; margin-bottom: 0px;">제목 : ${dto.title }</h3>   
            </div>
            </div>
            <div class="col-sm-3">
               <div class="text-right">
                  작성자: ${dto.id}
                  <span class="label label-warning">${dto.writeday}</span>
               </div>
            </div>
         </div>



         <hr>

         <p style="font-size: 150%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${dto.content}</p>

         <hr>


         <div class="text-right">
            <c:if test="${not empty login.id }">
               <a href="breplyui.do?num=${dto.num}"><button type="button">답글</button></a>
            </c:if>
            <a href="blist.do"><button type="button">목록</button> </a>
            <c:if test="${dto.id == login.id }">
               <a href="bupdateui.do?num=${dto.num}"> 
                  <button type="button">수정</button>
               </a>
            </c:if>
            <c:if test="${dto.id == login.id || login.nKey >= 100 }">
               <a href="bdelete.do?num=${dto.num}">
                  <button type="button">삭제</button>
               </a>
            </c:if>
         </div>
      </form>
   </div>
</body>

</html>