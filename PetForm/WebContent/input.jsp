<%@ page language="java" contentType="text/html; charset=GB10830"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<form	action=servlet/PetServlet method=post>
	姓名<input type="text" name="UserName">
	<br>选出你想要的宠物:
	
	<br>选择宠物重量:
	<input type="text" name="重量">
	<br>选择大腿的数量
	<input type="radio" name="leg" value=0>
	<input type="radio" name="legs" value=4 checked>
	4 legs<br>
	<input type="radio" name="legs" value=notsure checked>
	other number<br>
<input type="submit" value="提交">
</form>>

<%--
	name=request.getParameter("UserName");
	<%--String--%> 
--%>

<h5>Current time</h5>
<h5>
<%@include file="time.jsp" %>
</h5>
</body>
</html>