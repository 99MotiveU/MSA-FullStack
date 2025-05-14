<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<nav>
	<a href="${pageContext.request.contextPath }/index.do">home</a>
	<a href="${pageContext.request.contextPath }/dept/list.do">dept</a>
</nav>
	<h1>dept page</h1>
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
			<c:url var="url" value="detail.do">
				<c:param name="deptno" value="${bean.deptno }"></c:param>
			</c:url>
			<tr>
				<td><a href="${url }">${bean.deptno }</a></td>
				<td><a href="${url }">${bean.dname }</a></td>
				<td><a href="${url }">${bean.loc }</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<p><a href="add.do" class="btn btn-primary" role="button">입력</a></p>
</body>
</html>






