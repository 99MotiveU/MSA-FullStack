<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url var="root" value="/"></c:url>
<%@ include file="../layout/header.jspf" %>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<form class="form-signin" action="signin.do" method="post">
  <h2 class="form-signin-heading">로그인 페이지</h2>
  <label for="id" class="sr-only">Id</label>
  <input type="text" name="id" id="id" class="form-control" placeholder="Id" required autofocus>
  <label for="pw" class="sr-only">Pw</label>
  <input type="password" name="pw" id="pw" class="form-control" placeholder="Pw" required>
  <div class="checkbox">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
</form>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>