<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<div class="row">
			<button class="btn btn-danger">rest3</button>
		</div>
	</div>
	<script type="text/javascript">
			var test1 = "hello";
			var test2 = "good";
			var test3 = "world";
			var test4 = [
				{name: 'john', age : 10 , addr : 'seoul'},
				{name: 'joe', age : 20 , addr : 'jeju'},
				{name: 'jane', age : 30 , addr : 'busan'}
			];
	
			$(document).ready(function () {
			$("button").click(function () {
				$.ajax({
					type : 'post',
					url : '/rest3',
					headers:{
						'Content-Type' : 'application/json',
						'X-HTTP-Method-Override' : 'POST'
					},
					data : JSON.stringify({
						test1 : test1,
						test2 : test2,
						test3 : test3,
						test4 : test4
					}),
					dataType : 'text',
					success : function(result) {
						console.log(result);
					}
				});	
			});
			});
		</script>

</body>
</html>