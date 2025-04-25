<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css">
<style type="text/css">
#carousel{
	width: 550px;
	height: 550px;
	overflow: hidden;
	position: relative;
	margin: 0px auto;
}
#carousel>ul{
	list-style: none;
	width: 3300px;
}
#carousel>ul>li{
	float: left;
}
#carousel>ul>li>img{
}
#carousel>a{
	position: absolute;
	display: block;
	background-color: rgba(0,0,0,0.3);
	width: 50px;
	height: 550px;
	font-size: 50pt;
	font-weight:bold;
	text-align: center;
	text-decoration: none;
	line-height: 500px;
	color: white;
}
#carousel>a:last-child{
	left: 500px;
}

#carousel>img{}
</style>
<script type="text/javascript">
var carousel,ul;
window.onload=function(){
	carousel=document.querySelector('#carousel');
	ul=carousel.querySelector('ul');
	ul.style.marginLeft='0px';
	setInterval(func01,100);
};
function func01(){
	if(parseInt(ul.style.marginLeft)-10<-2750+550)
		ul.style.marginLeft='0px';
	else
		ul.style.marginLeft=parseInt(ul.style.marginLeft)-10+'px';
}
</script>
</head>
<body>
	<div>
		<div id="header">
			<h1>한국it여성기업인협회</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="#">home</a></li>
				<li><a href="#">intro</a></li>
				<li><a href="#">bbs</a></li>
				<li><a href="#">login</a></li>
			</ul>
		</div>
		<div id="content">
		<!-- content begin -->
		<div id="carousel">
			<ul>
				<li><img src="imgs/b1.avif"/></li>
				<li><img src="imgs/b2.avif"/></li>
				<li><img src="imgs/b3.avif"/></li>
				<li><img src="imgs/b4.avif"/></li>
				<li><img src="imgs/b5.avif"/></li>
				<li><img src="imgs/b6.avif"/></li>
			</ul>
		</div>
		<!-- content end -->
		</div>
		<div id="footer">
			<address>(06130) 서울 강남구 테헤란로 7길 22, 한국과학기술회관 1관 303호</address>
			<p>&copy;한국IT여성기업인협회 Inc. All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>






