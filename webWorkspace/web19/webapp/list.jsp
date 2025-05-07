<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/index">home</a>
<a href="${pageContext.request.contextPath }/intro">intro</a>
<a href="${pageContext.request.contextPath }/bbs/list">bbs</a>
<a href="${pageContext.request.contextPath }/login/login">login</a>
<hr/>
<h1>bbs page</h1>

<table>
	<thead>
		<tr>
			<th>num</th>
			<th>subject</th>
			<th>id</th>
			<th>nalja</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.num }</td>
				<td>${bean.sub }</td>
				<td>${bean.id }</td>
				<td><fmt:formatDate value="${bean.nalja }" pattern="yyyy/MM/dd"/> </td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="add">add</a>
</body>
</html>














