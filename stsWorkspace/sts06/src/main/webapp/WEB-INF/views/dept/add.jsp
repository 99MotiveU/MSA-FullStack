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
<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath }/">Home</a></li>
  <li><a href="${pageContext.request.contextPath }/dept/">dept</a></li>
  <li class="active">add</a></li>
</ol>
<div class="page-header">
  <h1>add page <small>dept</small></h1>
</div>
<form action="add" method="post">
	<div class="form-group">
		<label class="sr-only"></label><input name="deptno" class="form-control" placeholder="deptno">
	</div>
	<div class="form-group">
		<label class="sr-only"></label><input name="dname" class="form-control" placeholder="dname">
	</div>
	<div class="form-group">
		<label class="sr-only"></label><input name="loc" class="form-control" placeholder="location">
	</div>
	<div class="form-group">
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
		<button class="btn btn-primary" type="submit">입력</button>
		<button class="btn btn-default" type="reset">취소</button>
		<button class="btn btn-default" type="button" onclick="history.back();">뒤로</button>
		</div>
	</div>
</form>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>







