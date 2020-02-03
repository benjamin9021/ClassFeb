<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<br>

<a>&laquo;</a>

<c:if test="${to.curPage > 1}">
	<a href="list.do?curPage=${to.curPage-1}"><&nbsp;&nbsp;</a></a>
</c:if>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:forEach var = "i" begin= "${to.beginPageNum}" end = "${to.stopPageNum}"> 
	<a style="font-size: 20px; ${i == to.curPage? 'color:red;':''}" href="list.do?curPage=${i}">${i}</a>&nbsp;&nbsp;&nbsp;&nbsp;



</c:forEach>

<c:if test="${to.curPage < to.totalPage}">
<a href="list.do?curPage=${to.curPage+1}">></a>
</c:if>

<a href="list.do?curPage">&raquo;</a>