<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有信息</title>
</head>
<body>
	<s:iterator var="each" value="personList">
		<s:property value="#each.id"/>
		<s:property value="#each.name" />
	</s:iterator>
	
	<s:debug></s:debug>
</body>
</html>