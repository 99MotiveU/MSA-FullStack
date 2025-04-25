<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css">
<style type="text/css">
#carousel{}
#carousel>div{
	animation-name: ani1;
	animation-duration: 1s;
	animation-timing-function: linear;
	animation-iteration-count: 1;
	animation-play-state: paused;
}
@keyframes ani1{
	from{width:100px;}
	to{width:0px;}
}
#carousel>ul{
	list-style: none;
	display: inline-block;
}
#carousel>ul>li{
	float: left;
}
#carousel>ul>li>img{
	width: 100px;
}
</style>
<script type="text/javascript">
var div,carousel,ul;
window.onload=function(){
	carousel=document.querySelector('#carousel');
	ul=carousel.querySelector('ul');
	div=document.createElement('div');
	div.style.width='100px';
	div.style.height='100px';
	div.style.display='inline-block';
	carousel.prepend(div);
};
function nextLoop(){
	document.styleSheets[1].rules[1].style.animationPlayState='running';
	setTimeout(function(){
		ul.appendChild(ul.firstElementChild);
	},1000);
		
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
				<li><a href="./">home</a></li>
				<li><a href="./intro.jsp">intro</a></li>
				<li><a href="./bbs/">bbs</a></li>
				<li><a href="./login/">login</a></li>
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






