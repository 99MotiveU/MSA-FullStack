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
	margin:0px auto;
}
#carousel>ul{
	list-style: none;
	width: 3300px;
	animation-name: ani1;
	animation-duration: 24s;
	animation-timing-function: linear;
	animation-direction: alternate;
	animation-iteration-count: infinite;
	animation-play-state: paused;
}
#carousel>ul>li{
	float:left;
	width: 550px;
	
}
#carousel>ul>li>img{
	width: 550px;	
}

@keyframes ani1{
	from{
		margin-left: 0px;
	}
	to{
		margin-left: -2750px;
	}
}

</style>
<script type="text/javascript">
window.onload=function(){
};
function stop(){
	document.styleSheets[1].rules[1].style.animationPlayState='paused';
}
function nextLoop(){
	document.styleSheets[1].rules[1].style.animationPlayState='running';
	setTimeout(stop,4800);
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






