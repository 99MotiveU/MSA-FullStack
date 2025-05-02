<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/frame.css">
<link rel="stylesheet" type="text/css" href="../css/form.css">
<style type="text/css">

</style>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$('form').submit(function(e){
		$('form .err').eq(0).html($(this).find('input').eq(0).val()?'':'제목없음');
		return $(this).find('input').eq(0).val()?true:false;
	});
});
</script>
</head>
<body>
<jsp:include page="../layout/header.jsp">
	<jsp:param value=".." name="path"/>
</jsp:include>
<jsp:include page="../layout/menu.jsp">
	<jsp:param value=".." name="path"/>
</jsp:include>
<h2>입력 페이지</h2>
<%
Object sub=request.getAttribute("sub");
Object content=request.getAttribute("content");
Object errId=request.getAttribute("errId");

if(errId==null)errId="";
sub=sub==null?"":sub;
// 조건?true:false
%>
<form action="add.do" method="post">
	<div>
		<label>subject<span class="err"></span></label><input name="sub" value="<%=sub%>"/>
	</div>
	<div>
		
		<label>id<span class="err"><%=errId %></span></label><input name="id"/>
	</div>
	<div>
		<textarea name="content"><%=content==null?"":content %></textarea>
	</div>
	<div>
		<button type="submit">입력</button>
		<button type="reset">취소</button>
		<button type="button">뒤로</button>
	</div>
</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>


