<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container">

      <form class="form-signin" action="delete.do" method="post">
        <h1 class="form-signin-heading">delete page</h1>
        <input type="hidden" name="deptno" value="${deptno }">
        <button class="btn btn-lg btn-danger btn-block" type="submit">삭제</button>
        <button class="btn btn-lg btn-default btn-block" type="button" onclick="history.back();">취소</button>
      </form>

    </div> <!-- /container -->
</body>
</html>







