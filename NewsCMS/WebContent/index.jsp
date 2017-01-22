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

		function changebackground(i) {

			while (i < 3) {
				switch (i) {
				case 0:
					$(".banner").css('background', 'blue');
					break;
				case 1:
					$(".banner").css('background', 'red');
					break;
				case 2:
					$(".banner").css('background', 'white');
					break;
				case 3:
					$(".banner").css('background', 'green');
					break;
				}
			}
		}

		//主背景切换

		$("#s1").mouseover(function() {

		})

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
						//还需要搜索的代码
					</script>
					<!-- //search-scripts -->
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--banner start here-->
	<div class="banner">
		<div class="container">
			<div class="banner-main">
				<div class="banner-text">
					<h2>中国地质大学新闻网</h2>
					<%
						String username = (String) session.getAttribute("userinfo");
						if (username == null) {
					%>
					<p>给你想看到的新闻，从这里，看向广阔的 世界</p>
					<div class="bann-btn">
						<a href="login.jsp">登录</a> <a href="registe.jsp">注册</a>
					</div>
					<%
						} else {
					%>
					<p><%="Welcome!" + username%></p>
					<div class="bann-btn">
						<a href="logout.jsp">注销</a> <a href="edit.html">管理</a>
					</div>
					<%
						}
					%>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--banner end here-->
	<!--services start here-->
	<div class="container">
		<div class="services">
			<div class="services-main">
				<div class="ser-row1">
					<div class="col-md-4 service-grid ser-gd1" id="s1">
						<img src="images/icon1.png" alt="">
						<h3>热点新闻1</h3>
						<p>热点新闻的热点内容</p>
						<div class="ser-btn" id="r1">
							<a href="#">Read more</a>
						</div>
					</div>
					<div class="col-md-4 service-grid ser-gd2" id="s2">
						<img src="images/icon2.png" alt="">
						<h3>热点新闻2</h3>
						<p>热点新闻的热点内容</p>
						<div class="ser-btn1" id="r2">
							<a href="#">Read more</a>
						</div>
					</div>
					<div class="col-md-4 service-grid ser-gd3" id="s3">
						<img src="images/icon3.png" alt="">
						<h3>热点新闻3</h3>
						<p>热点新闻的热点内容</p>
						<div class="ser-btn" id="r3">
							<a href="#">Read more</a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="ser-row2">
					<div class="col-md-4 service-grid ser-gd4" id="s4">
						<img src="images/icon4.png" alt="">
						<h3>热点新闻4</h3>
						<p>热点新闻的热点内容</p>
						<div class="ser-btn2" id="r4">
							<a href="#">Read more</a>
						</div>
					</div>
					<div class="col-md-4 service-grid ser-gd5" id="s5">
						<img src="images/icon5.png" alt="">
						<h3>热点新闻5</h3>
						<p>热点新闻的热点内容</p>
						<div class="ser-btn3" id="r5">
							<a href="#">Read more</a>
						</div>
					</div>
					<div class="col-md-4 service-grid ser-gd6" id="s6">
						<img src="images/icon6.png" alt="">
						<h3>热点新闻6</h3>
						<p>热点新闻的热点内容</p>
						<div class="ser-btn2" id="r6">
							<a href="#">Read more</a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--services end here-->
	<!--welcome strip here-->
	<div class="welcome">
		<div class="container">
			<div class="welcome-main">
				<div class="welcome-grid">
					<div class="welcome-left">
						<h4>欢迎来到中国地质大学新闻网</h4>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--welcome strip end here-->
	<!--footer start here-->
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
	<!--footer end here-->
</body>
</html>