<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl</h1>
	<%
		//pageContext.setAttribute("obj", "XYZ");
	%>
	<p>
		set:
		<c:set var="msg" scope="page">abc</c:set>
	</p>
	<p>
		out:
		<c:out value="${requestScope.msg }" default="없음"></c:out>
	</p>
	<p>${requestScope.msg }</p>

	<c:set value="${false }" var="result"></c:set>
	<c:if test="${result }">
		<p>참입니다</p>
	</c:if>
	<c:if test="${!result }">
		<p>거짓입니다</p>
	</c:if>

	<c:set value="${-10 }" var="su"></c:set>
	<c:choose>
		<c:when test="${su>10 }">10보다 크다</c:when>
		<c:when test="${su>0 }">0보다 크다</c:when>
		<c:when test="${su eq 0 }">0이다</c:when>
		<c:otherwise>음수다</c:otherwise>
	</c:choose>
	<hr />
	<ol>
		<c:forEach begin="1" end="10" step="2" var="cnt" varStatus="status">
			<li>item-${cnt }-${status.index }-${status.count}-${status.first }-${status.last }</li>
		</c:forEach>
	</ol>
</body>
</html>












