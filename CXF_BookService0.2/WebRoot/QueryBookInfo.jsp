<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍查询</title>
<style type="text/css">
    <!--
    body{margin:0px;font-size:12px;font-family:"Verdana","Arial","Helvetica","sans-serif";letter-spacing:1px}
    #header{background-color:#6495ED;color:#F0F8FF;padding-left:8px;padding-top:7px;padding-bottom:5px;font-size:16pt;font-family:Verdana;font-weight:bold;}
    -->
    </style>
</head>
<body>
<div id="header"><strong>书籍查询服务</strong></div><br>
<div>
<form action="QueryBookServlet" method="post">
<table align="center">
<tr>
<td><a href="http://192.168.1.135:8080/CXF_BookService/ListAllBookServlet"><input type="button" name="listAllBook" value="显示所有书籍"></a></td>
<td width="25"></td>
<td>输入书籍名：<input type="text" name="bookName"/></td>
<td><input type="submit" name="queryBook" value="查询"></td>
</tr>
</table>
</form>
</div>
<br>
<div>
<table border="2" align="center" width="80%">
<tr>
<td width="8%">编号</td>
<td width="16%">书名</td>
<td width="14%">作者</td>
<td width="12%">价格(￥)</td>
<td width="30%">查看地址</td>
<td width="20%">备注</td>
</tr>
<c:forEach items="${books}" var="book" varStatus="index">
<tr>
<td>${book.bookId}</td>
<td>${book.bookName}</td>
<td>${book.author}</td>
<td>${book.price}</td>
<td>${book.bookUrl}</td>
<td>${book.remark}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>