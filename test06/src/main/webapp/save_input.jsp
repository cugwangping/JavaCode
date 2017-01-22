<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<s:form action="save" namespace="/person" method="post">
		<s:textfield name="person.id" label="用户ID"></s:textfield>
		<s:textfield name="person.name" label="用户名"></s:textfield>
		
		<s:submit value="保存"></s:submit>
	</s:form>
</body>
</html>