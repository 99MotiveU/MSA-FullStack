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
<c:url value="/" var="root"></c:url>
<a href="${pageContext.request.contextPath }/index">home</a>
<a href="${pageContext.request.contextPath }/intro">intro</a>
<a href="${root }bbs/list">bbs</a>

<c:if test="${sessionScope.login eq null }">
<a href="${pageContext.request.contextPath }/login/login">login</a>
</c:if>

<c:if test="${sessionScope.login ne null }">
<a href="${pageContext.request.contextPath }/logout">logout</a>
<span>${sessionScope.login }님 로그인 중...</span>
</c:if>

<hr/>
<h1>index page</h1>
</body>
</html>






