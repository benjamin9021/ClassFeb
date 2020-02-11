<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <br>
<div class="container" align="center">

	<ul class="pagination" style="background-color: black; color: white;">

		<li class="previous"><c:if test="${to.stopPageNum -10 > 1}">
				<a
					href="blist.do?curPage=${to.beginPageNum-10 <1 ? 1 : to.beginPageNum-10}">&laquo;</a>
			</c:if></li>



		<li class="previous"><c:if test="${to.curPage - 1 > 0}">
				<a href="blist.do?option=${option }&searchtext=${searchtext }&curPage=${to.curPage-1}">Previous</a>
			</c:if></li>

		<c:forEach var="i" begin="${to.beginPageNum}" end="${to.stopPageNum}">
			<c:choose>
				<c:when test="${to.curPage == i}">
					<li class="active"><a href="blist.do?option=${option }&searchtext=${searchtext }&curPage=${i}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="blist.do?option=${option }&searchtext=${searchtext }&curPage=${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>


		<li class="next"><c:if test="${to.curPage < to.totalPage}">
				<a href="blist.do?option=${option }&searchtext=${searchtext }&curPage=${to.curPage+1}">next</a>
			</c:if></li>






		<li class="next"><c:if test="${to.stopPageNum != to.totalPage}">
				 <a href="blist.do?option=${option }&searchtext=${searchtext }&curPage=${to.stopPageNum+1}">&raquo;</a>
			</c:if></li>


	</ul>

</div>