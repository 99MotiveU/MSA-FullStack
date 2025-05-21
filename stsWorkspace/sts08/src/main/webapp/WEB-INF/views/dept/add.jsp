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
<h2 class="page-header">입력 페이지</h2>
<form action="./" method="post" class="form-horizontal">
	<div class="form-group">
		<label class="sr-only">deptno</label><input name="deptno" class="form-control" placeholder="deptno"/>
	</div>
	<div class="form-group">
		<label class="sr-only">dname</label><input name="dname" class="form-control" placeholder="dname"/>
	</div>
	<div class="form-group">
		<label class="sr-only">location</label><input name="loc" class="form-control" placeholder="location"/>
	</div>
	<div class="form-group">
		<div class="btn-group btn-group-justified" role="group">
			<button type="submit" class="btn btn-primary">입력</button>
			<button type="reset" class="btn btn-default">취소</button>
			<button type="button" class="btn btn-default">뒤로</button>
		</div>
	</div>
</form>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>









