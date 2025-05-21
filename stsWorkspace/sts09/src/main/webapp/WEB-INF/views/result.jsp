<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>down</h1>
	<c:forEach items="${arr }" var="map">
	<p><a href="download?newName=${map.name }&origin=${map.origin }">${map.origin }</a><p>
	<p><a href="${map.origin }?newName=${map.name }">${map.origin }</a><p>
	<hr/>
	</c:forEach>
</body>
</html>