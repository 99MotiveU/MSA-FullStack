<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/header.jspf" %>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<h1>입력 페이지</h1>
<form class="form" action="add" method="post">
	<div class="form-group">
		<label>deptno</label><input name="deptno" class="form-control"/>
	</div>
	<div class="form-group">
		<label>dname</label><input name="dname" class="form-control"/>
	</div>
	<div class="form-group">
		<label>location</label><input name="loc" class="form-control"/>
	</div>
	<div class="form-group">
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="reset" class="btn btn-default">취소</button>
		<button type="button" class="btn btn-default"onclick="history.back();">뒤로</button>
	</div>
</form>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>






