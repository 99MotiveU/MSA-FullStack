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
  <li class="active">dept</li>
</ol>
<div class="page-header">
  <h1>list page <small>dept</small></h1>
</div>
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
		<tr>
			<td><a href="${bean.deptno }">${bean.deptno }</a></td>
			<td><a href="${bean.deptno }">${bean.dname }</a></td>
			<td><a href="${bean.deptno }">${bean.loc }</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<p><a href="add" class="btn btn-primary btn-block">입력</a></p>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>







