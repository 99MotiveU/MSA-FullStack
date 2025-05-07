<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/index">home</a>
<a href="<%=request.getContextPath() %>/intro">intro</a>
<a href="<%=request.getContextPath() %>/bbs/list">bbs</a>
<a href="<%=request.getContextPath() %>/login/login">login</a>
<hr/>
<h1>login page</h1>
<form action="./login" method="post">
	<div>
		<label>id</label><input name="id"/>
	</div>
	<div>
		<label>pw</label><input name="pw"/>
	</div>
	<div>
		<button>로그인</button>
	</div>
</form>
</body>
</html>












