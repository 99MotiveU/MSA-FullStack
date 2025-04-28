<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
background-image: url('http://www.kibwa.org/data/skin/default/images/da_image/hd_logo.png');
background-size: 100%;
width: 100px;
text-indent: -9999px;
display: inline-block;
}
h1+form,h1+p{
	display: inline-block;
	float: right;
}
</style>
<script type="text/javascript">
var form,xhr;
var callback02=function(e){
	if(xhr.status==200 && xhr.readyState==4){
		form.outerHTML=xhr.response;
	}
};
var callback01=function(e){
	e.preventDefault();
	//var fd=new FormData(form);
	//fd.enctype='application/x-www-form-urlencoded';
	//fd.method='post';
	//fd.action='login.jsp';
	//fd.append('id','ABCD');
	//fd.append('pw','1234');
	
	var id=form.id.value;
	var pw=form.pw.value;
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=callback02;
	xhr.open('post','login.jsp');
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send('id='+id+'&pw='+pw);
};
window.onload=function(){
	form=document.querySelector('h1+form');
	form.onsubmit=callback01;
};
</script>
</head>
<body>
<h1>한국IT여성기업인협회</h1>
<form action="login.jsp" method="post" enctype="application/x-www-form-urlencoded">
	<label>id</label><input name="id"/>
	<label>pw</label><input type="password" name="pw"/>
	<button>login</button>
</form>
<hr/>
</body>
</html>