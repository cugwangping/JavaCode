<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button>
		<a href="">查询我的新闻</a>
	</button>
	<button>
		<a href="">查询个人信息</a>
	</button>

	<form method="post" action="lg">

		<label for="title">新闻条目</label> <input type="input" name="name" /><br />
		<input type="text" name="content" /><br /> <input type="submit"
			name="submit" value="创建" />

	</form>
</body>
</html>