<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./layout/header.jspf" %>
</head>
<body>
<%@ include file="./layout/menu.jspf" %>

<div class="jumbotron">
  <h1>Hello, world!</h1>
  <p>환영합니다</p>
  <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath }/dept/" role="button">dept list</a></p>
</div>

<%@ include file="./layout/footer.jspf" %>
</body>
</html>









