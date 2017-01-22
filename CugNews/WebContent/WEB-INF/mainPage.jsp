<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <title>�й����ʴ�ѧ������</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js"></script>
    <style type="text/css">
    	*{
    		margin:0 auto;
    	}
    	body{
    		color:#7EB1DC;
    	}
    	.nav >li{
    		width:234px;
    		background-color: #666877;
    	}
    	.nav{
    		width:1170px;
    	}
    	button{
    		float: right;
    		margin-top: 20px;
    		margin-left: 10px;
    		color:#7EB1DC;
    	}
    	.first-board{
    		min-height:200px;
    	}
    	.second-board{
    		min-height:200px;
    	}
    	h1{
    		float: left;
    		color:#7EB1DC;
    	}
    	a{
    		color:#7EB1DC;
    	}
    	.content{
    		background-image: url("img/background.png");
    		min-height:450px;
    		background-repeat:no-repeat;
    		border-image-repeat: space;
    		width: 1170px;
    	}
    	.footer{

    	}
    	.container>.content{
    		box-shadow:  10px 10px 10px #666877;
    	}
    </style>
</head>
<body>
	
	<div class="container">
		<div class="bignav">
					<h1>�й����ʴ�ѧ������</h1>
					<button><a href="login.html">��¼</a></button>
					<button>ע��</button>
				<ul class="nav navbar-nav">
				 <li class="active"><label href="#" id="main">��ҳ</label></li>
	         	 <li><label id="inter">��������</label></li>
	         	 <li><label  id="entertain">��������</label></li>
	         	 <li><label  id="science">�Ƽ�����</label></li>
	         	 <li><label  id="sports">��������</label></li>
	         	</ul>
			</div>
		</div>

	<div class="wrap" id="wrap">
		<div class="container" id="inter-b" style="display:none;">
			
			<ul>
				<h1>��������</h1>
				<li></li>
				<li></li>
			</ul>	
		</div>
		<div class="container" id="science-b" style="display:none;">
			
			<ul>
				<h1>�Ƽ�����</h1>
				<li></li>
				<li></li>
			</ul>	
		</div>
		<div class="container" id="entertain-b" style="display:none;">
			
			<ul>
				<h1>��������</h1>
				<li></li>
				<li></li>
			</ul>	
		</div>
		<div class="container" id="sports-b" style="display:none;">
			
			<ul>
				<h1>��������</h1>
				<li></li>
				<li></li>
			</ul>	
		</div>
	
		<div class="container" id="main-b">	
			<div class="content">
				<div class="first-board">
					<div class="col-xs-6"><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do 
		            eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut 
		            enim ad minim veniam, quis nostrud exercitation ullamco laboris 
		            nisi ut aliquip ex ea commodo consequat.
		         </p></div>
					<div class="col-xs-6">
						<div>�����ȵ�</div>
						<ul>
							<li></li>
							<li></li>
						</ul>	
					</div>
				</div>
				<div class="second-board"><!--���������-->
					<div class="col-xs-4">
						<div>��������</div>
						<ul>
							<li></li>
							<li></li>
						</ul>	
					</div>
					<div class="col-xs-4">
						<div>��������</div>
						<ul>
							<li></li>
							<li></li>
						</ul>	
					</div>
		         <div class="col-xs-4">
		         	<div>�Ƽ�����</div>
						<ul>
							<li></li>
							<li></li>
						</ul>	
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
	var i = 0;
	$(document).ready(function(){
		$("#inter").click(function(){
			$("#inter-b").show("slow");
			
			if(i == 0)
				$("#main-b").hide("slow");
			else if(i == 1)
				$("#inter-b").hide("slow");
			else if(i == 2)
				$("#science-b").hide("slow");
			else if(i == 3)
				$("#sports-b").hide("slow");
			else if(i == 4)
				$("#entertain-b").hide("slow");
			i = 1;
			

		});
		$("#main").click(function(){
			$("#main-b").show("slow");
			
			if(i == 0)
				$("#main-b").hide("slow");
			else if(i == 1)
				$("#inter-b").hide("slow");
			else if(i == 2)
				$("#science-b").hide("slow");
			else if(i == 3)
				$("#sports-b").hide("slow");
			else if(i == 4)
				$("#entertain-b").hide("slow");
			i = 0;
		
		});
		$("#science").click(function(){
			$("#science-b").show("slow");
			
			if(i == 0)
				$("#main-b").hide("slow");
			else if(i == 1)
				$("#inter-b").hide("slow");
			else if(i == 2)
				$("#science-b").hide("slow");
			else if(i == 3)
				$("#sports-b").hide("slow");
			else if(i == 4)
				$("#entertain-b").hide("slow");
			i = 2;
			
		});
		$("#sports").click(function(){
			$("#sports-b").show("slow");
			
			if(i == 0)
				$("#main-b").hide("slow");
			else if(i == 1)
				$("#inter-b").hide("slow");
			else if(i == 2)
				$("#science-b").hide("slow");
			else if(i == 3)
				$("#sports-b").hide("slow");
			else if(i == 4)
				$("#entertain-b").hide("slow");
			i = 3;
			
		});
		$("#entertain").click(function(){
			$("#entertain-b").show("slow");
			
			if(i == 0)
				$("#main-b").hide("slow");
			else if(i == 1)
				$("#inter-b").hide("slow");
			else if(i == 2)
				$("#science-b").hide("slow");
			else if(i == 3)
				$("#sports-b").hide("slow");
			else if(i == 4)
				$("#entertain-b").hide("slow");
			i = 4;
			
		});
	});
	</script>
</body>

</html>