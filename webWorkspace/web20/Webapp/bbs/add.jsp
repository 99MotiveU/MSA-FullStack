<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url value="/" var="root"></c:url>
<%@ include file="../layout/header.jspf" %>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<form class="form-signin" action="add.do" method="post">
  <h2 class="form-signin-heading">입력 페이지</h2>
  <label for="sub" class="sr-only">subject</label>
  <input type="text" name="sub" id="sub" class="form-control" placeholder="제목" required autofocus>
  <textarea rows="6" name="content" id="content" class="form-control" placeholder="내용"></textarea>
  <button class="btn btn-lg btn-primary btn-block" type="submit">입력</button>
</form>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>









