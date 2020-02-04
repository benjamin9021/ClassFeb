<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<br>
<c:if test="${to.stopPageNum -10 > 1}">
   <a href="blist.do?curPage=${to.beginPageNum-10 <1 ? 1 : to.beginPageNum-10}">&laquo;</a>
</c:if>


<c:if test="${to.curPage > 1}">
	<a href="blist.do?curPage=${to.curPage-1}"><&nbsp;&nbsp;</a>
</c:if>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:forEach var = "i" begin= "${to.beginPageNum}" end = "${to.stopPageNum}"> 
	<a style="font-size: 20px; ${i == to.curPage? 'color:red;':''}" href="blist.do?curPage=${i}">${i}</a>&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>

<c:if test="${to.curPage < to.totalPage}">
<a href="blist.do?curPage=${to.curPage+1}">></a>
</c:if>

<c:if test="${to.stopPageNum != to.totalPage}">
   <a href="blist.do?curPage=${to.stopPageNum+1}">&raquo;</a>
</c:if>