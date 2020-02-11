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

input[type=password], select {
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

button[type=submit] {
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

   <div class="container">
      <h2>회원 가입</h2>
      <hr>

      <form action="minsert.do" method="post">
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
                  <td><input type="text" id="id" required placeholder="아이디"
                     name="id">
                     <button type="button"
                        style="border-left-width: 5px; margin-left: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px; padding-bottom: 10px; border-top-width: 10px; border-right-width: 10px; border-bottom-width: 10px;">

                        중복 확인</button>
                     <p></p></td>
               </tr>
               <c:if test="${dto.nkey != 1000 }">
                  <tr class="active">
                     <td style="background-color: #8C7F77; color: white">비밀번호</td>
                     <td><input type="password" id="pw" required
                        placeholder="비밀번호" name="pw"></td>
                  </tr>
               </c:if>
               <tr class="active">
                  <td style="background-color: #8C7F77; color: white">성함</td>
                  <td><input type="text" id="name" required placeholder="name"
                     name="name"></td>
               </tr>
               <tr class="active">
                  <td style="background-color: #8C7F77; color: white">생년월일</td>
                  <td><input id="birth" required placeholder="생년월일" type="date"
                     name="birthday"></td>
               </tr>
            </tbody>
         </table>
         <hr>
         <input name="nkey" type="hidden" value="10"> 
         <div class="text-right">

            <button id="submit" type="submit" class="btn btn-danger" onclick="button_event();" value="등록">등록</button>
         <a href="blist.do"><button type="button">취소</button></a>
         </div>
            

      </form>
   </div>


   <script type="text/javascript">
      $(document).ready(function() {

         $("button").click(function() {
            var id = $("input[name='id']").val();

            $.ajax({
               type : 'get',
               url : 'mCheckId.do',
               data : {
                  id : id
               },
               dataType : 'text',
               success : function(result) {
                  $("p").text(result);
               }
            });
         });

      });
      $("#submit").click(function() {
         if (confirm("등록을 완료하셨으면, 로그인해주세요.") == false) {
            return false;
         }
      });
 /*   function button_event() {

      if (confirm("회원등록하셨으면, 로그인해주세요.") == true) { //확인

         document.form.submit();

      } else { //취소

        return;

      }

   } */
   
   
   
</script>
      
      
</body>
</html>