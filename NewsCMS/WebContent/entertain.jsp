<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>

<%@page import="java.util.*,news.dbSetting.MysqlDB,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>中国地质大学新闻网</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.2.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }








</script>
<!--Google Fonts-->
<link
	href='http://fonts.useso.com/css?family=Noto+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.useso.com/css?family=Open+Sans:600italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<!--<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>-->
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
</head>
<body>
	<!-- //end-smoth-scrolling -->
	<!--header start here-->
	<div class="header">
		<div class="container">
			<div class="header-main">
				<div class="logo">
					<a href="index.jsp"><img src="images/nam.png" alt=""></a>
				</div>
				<div class="head-right">
					<div class="top-nav">
						<span class="menu"> <img src="images/icon.png" alt="" /></span>
						<ul class="res">
							<li><a class="active" href="index.jsp">首页</a></li>
							<li><a href="inter.jsp">国际新闻</a></li>
							<li><a href="science.jsp">科技新闻</a></li>
							<li><a href="sports.jsp">体育新闻</a></li>
							<li><a href="entertain.jsp">娱乐新闻</a></li>
							<div class="clearfix"></div>
						</ul>
						<!-- script-for-menu -->
						<script>
							$("span.menu").click(function() {
								$("ul.res").slideToggle(300, function() {
									// Animation complete.
								});
							});
						</script>
						<!-- /script-for-menu -->
					</div>
					<div class="search-box">
						<div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input" placeholder="Search"
									type="search" name="search" id="search"> <input
									class="sb-search-submit" type="submit" value=""> <span
									class="sb-icon-search"> </span>
							</form>
						</div>
					</div>
					<div class="clearfix"></div>
					<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
					<script>
						new UISearch(document.getElementById('sb-search'));
					</script>
					<!-- //search-scripts -->
				</div>

				<div class="clearfix"></div>
			</div>


			<div class="footer">
				<div class="container">
					<div class="footer-main">
						<ul>
							<br>
							<%
								String Article_kind = "entertain";
								String sql = "select Article_name from article where Article_kind='" + Article_kind + "' ";
								Connection conn = MysqlDB.getConn();
								Statement stmt = MysqlDB.getStmt(conn);
								ResultSet rs1 = MysqlDB.executeQuery(stmt, sql);
								String aName = null;
								while (rs1.next()) {
									aName = rs1.getString("Article_name");
							%>
							<li><a href="#"><%=aName%></a></li>
							<%
								}
							%>
							<br>
						</ul>
					</div>
					<div class="clearfix"></div>

				</div>
			</div>
			<div class="copyright">
				<div class="container">
					<div class="copy-main">
						<div class="copy-left">
							<ul>
								<li><a class="active" href="index.jsp">Home</a></li>
								<li><a href="inter.jsp">International news&nbsp</a></li>
								<li><a href="science.jsp">science news&nbsp</a></li>
								<li><a href="sports.jsp">sports news&nbsp</a></li>
								<li><a href="entertain.jsp">entertain news&nbsp</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--footer end her-->

	</div>
	</div>



</body>
</html>