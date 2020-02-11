<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="searchForm" align="center">
        <form action="search.do" method="get" >
            <select name="option">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="id">글쓴이</option>
            </select>
            <input type="text" size="20" name="searchtext"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>    
    </div>