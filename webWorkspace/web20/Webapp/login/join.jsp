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
var arr=[false,false,false,false];
$(function(){
	$('form').submit(function(e){
		$('input').map(function(idx,ele){
			if($(ele).val()=='')arr[idx]=false;
			else arr[idx]=true;
		});
		if($('input').eq(0).val()!=''){
			$.ajax({
				url:'${root}checkid.do?id='+$('input').eq(0).val()
				,method:'get'
				,success:function(data){
					if(!data.result[0].id)
						document.querySelector('form').submit();
					else
						alert('사용할 수 없는 아이디 입니다');
				}
				,error:function(xhr,msg,err){console.log(xhr,msg,err);}
				
			});
		}
		return false;
	});
});
</script>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<form class="form-signin" action="join.do" method="post">
  <h2 class="form-signin-heading">회원가입 페이지</h2>
  <label for="id" class="sr-only">Id</label>
  <input type="text" name="id" id="id" class="form-control" placeholder="Id" required autofocus>
  <label for="pw" class="sr-only">Pw</label>
  <input type="password" name="pw" id="pw" class="form-control" placeholder="Pw" required>
  <label for="re" class="sr-only">Pw</label>
  <input type="password" id="re" class="form-control" placeholder="한번 더" required>
  <label for="pw" class="sr-only">Name</label>
  <input type="text" name="name" id="name" class="form-control" placeholder="name" required>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Join</button>
</form>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>









