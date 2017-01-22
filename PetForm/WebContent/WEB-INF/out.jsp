<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB10830"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="white"> 
<%--
<h1>The Output JSP</h1> 
<br>获取客户端提交的所有参数：
<%   java.util.Enumeration eh = request.getHeaderNames(); 
     while (eh.hasMoreElements()) { 
         String h = (String) eh.nextElement(); 
%> 
         <br> header: <%=  h  %> 
               value: <%=  request.getHeader(h) %> 
<% 
     } 
%> 

<h5>Current time</h5>
<h5>
<%@include file="time.jsp" %>
</h5>
--%>
</body> 
</html>