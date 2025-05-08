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
<c:url var="root" value="/"></c:url>
<div class="container">
	<div id="header">
		<h1>logo</h1>
	</div>
	<div id="menu">
		<ul>
			<li><a href="${root }index.do">home</a></li>
			<li><a href="${root }intro.do">intro</a></li>
			<li><a href="${root }bbs/list.do">bbs</a></li>
			<li><a href="${root }login/login.do">login</a></li>
		</ul>
	</div>
	<div id="content">
	<!-- begin -->
	<!-- end -->
	</div>
	<div id="footer">
		<address></address>
	</div>
</div>
</body>
</html>