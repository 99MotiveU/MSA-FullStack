<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
	<a href="${pageContext.request.contextPath }/">home</a>
	<a href="${pageContext.request.contextPath }/bbs/list">list</a>
</nav>
	<h1>add page</h1>
	<form action="insert" method="post">
		<div>
			<label>deptno</label><input name="deptno"/>
		</div>
		<div>
			<label>dname</label><input name="dname"/>
		</div>
		<div>
			<label>loc</label><input name="loc"/>
		</div>
		<div>
			<button>입력</button>
		</div>
	</form>
</body>
</html>












