<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:choose>

	<c:when test="${not empty login}">

		${login.name} 님, 환영합니다.

		<a href="mlogout.do">로그아웃</a>

	</c:when>

	<c:otherwise>

		<a href="mloginui.do">로그인</a>

	</c:otherwise>

</c:choose>
