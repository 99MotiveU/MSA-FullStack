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
	margin: 0px auto;
	position: relative;
}
#carousel>a{
	display: block;
	background-color: black;
	width: 50px;
	height: 550px;
	position: absolute;
	left: 0px;
	top: 0px;
	opacity: 0.3;
	font-size: 60pt;
	color: white;
	text-decoration: none;
	line-height: 550px;
}
#carousel>a:last-child{
	left:500px;
}

#carousel>img{}
</style>
<script type="text/javascript">
var imgs=[
	'<a href="#">&lt;</a><img src="imgs/b1.avif"><a href="#">&gt;</a>',
	'<a href="#">&lt;</a><img src="imgs/b2.avif"><a href="#">&gt;</a>',
	'<a href="#">&lt;</a><img src="imgs/b3.avif"><a href="#">&gt;</a>',
	'<a href="#">&lt;</a><img src="imgs/b4.avif"><a href="#">&gt;</a>',
	'<a href="#">&lt;</a><img src="imgs/b5.avif"><a href="#">&gt;</a>',
	'<a href="#">&lt;</a><img src="imgs/b6.avif"><a href="#">&gt;</a>'
];
var carousel,before,after;
window.onload=function(){
	carousel=document.querySelector('#carousel');
	carousel.innerHTML=imgs[0];
	before=carousel.querySelector('a');
	after=carousel.querySelector('a~a');
	before.onclick=prevLoop;
	after.onclick=nextLoop;
};
function nextLoop(e){
	e.preventDefault();
	var msg=imgs.shift();
	imgs.push(msg);
	carousel.innerHTML=imgs[0];
	before=carousel.querySelector('a');
	after=carousel.querySelector('a~a');
	before.onclick=prevLoop;
	after.onclick=nextLoop;
}
function prevLoop(e){
	e.preventDefault();
	var msg=imgs.pop();
	imgs.unshift(msg);
	carousel.innerHTML=imgs[0];
	before=carousel.querySelector('a');
	after=carousel.querySelector('a~a');
	before.onclick=prevLoop;
	after.onclick=nextLoop;
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






