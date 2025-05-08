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
<script type="text/javascript">
$(function(){
	$('form').one('submit',function(e){
		$('form input').eq(0).add($('form textarea')).removeProp('readonly');
		$('form h2').html('수정 페이지');
		return false;
	});
});
</script>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<form class="form-signin" action="edit.do" method="post">
  <h2 class="form-signin-heading">상세 페이지</h2>
  <label for="sub" class="sr-only">subject</label>
  <input type="text" name="sub" id="sub" class="form-control" value="${bean.num }" readonly>
  <label for="id" class="sr-only">id</label>
  <input type="text" name="id" id="id" class="form-control" value="${bean.id }" readonly>
  <label for="nalja" class="sr-only">nalja</label>
  <input type="datetime-local" name="nalja" id="nalja" class="form-control" value="${bean.nalja }" disabled>
  <textarea rows="6" name="content" id="content" class="form-control" readonly>${bean.content }</textarea>
  <button class="btn btn-lg btn-primary btn-block" type="submit">수 정</button>
</form>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>









