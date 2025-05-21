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
<h2 class="page-header">list page</h2>
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>location</th>
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
<p><a href="add" class="btn btn-primary btn-block" role="button">입력</a></p>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>









