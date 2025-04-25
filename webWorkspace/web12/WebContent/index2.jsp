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
var su=1;
var img,carousel,before,after;
function nextLoop(e){
	e.preventDefault();
	su++;
	if(su>6)su=1;
	img.src="imgs/b"+su+".avif";	
}
function prevLoop(e){
	e.preventDefault();
	su--;
	if(su<1)su=6;
	img.src="imgs/b"+su+".avif";	
}
window.onload=function(){
	carousel=document.querySelector("#carousel");
	img=document.querySelector("#carousel>img");
	//window.setTimeout(nextLoop,3000);
	before=document.createElement('a');
	after=document.createElement('a');
	before.appendChild(document.createTextNode("<"));
	after.appendChild(document.createTextNode(">"));
	before.href='#';
	after.href='#';
	carousel.prepend(before);
	carousel.appendChild(after);
	before.onclick=prevLoop;
	after.onclick=nextLoop;
	
	setInterval(function(){
		after.click();
	},3000);
};

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
			<img alt="" src="imgs/b1.avif">
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






