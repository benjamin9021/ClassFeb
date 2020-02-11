<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%
   Integer count = (Integer)application.getAttribute("counter"); 

   if(count == null)
   {
      application.setAttribute("counter",1);   
   }
   else
   {
      count = count + 1;
      application.setAttribute("counter", count);   
   }
%>
   방문자수 : <%= application.getAttribute("counter") %>
