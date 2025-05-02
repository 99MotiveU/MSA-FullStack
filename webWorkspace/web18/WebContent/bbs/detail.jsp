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
.edit{
	border-color: white;
	border-width: 0px;
	background-color: white;
}
</style>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$('form button').eq(0).click(function(e){
		location.href='edit.do?num='+$('form input:eq(0)').val();
	});
	$('form button').eq(3).click(function(e){
		history.back();
	});
	if(<%=request.getAttribute("edit")%>) {
		//수정
		$('.edit').removeClass('edit');
		$('form input').eq(1).removeProp('readonly');
		$('form textarea').removeProp('readonly');
		$('form button').eq(0).remove();
		$('form button[type="submit"]').next().attr('type','reset').html('취소');
	}else{
		//상세
		$('form button[type="submit"]').next().click(function(e){
			if(confirm('삭제하시겠습니까?')){
				$.post(
						'delete.do'
						,'num='+$('form input:eq(0)').val()
						,function(){
							location.replace('list.do');	
						}
				);
			}
		});
		$('form button[type="submit"]').remove();
	}
});
</script>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp">
	<jsp:param value=".." name="path"/>
</jsp:include>
<h2><%=request.getAttribute("edit")==null?"상세":"수정" %> 페이지</h2>
<%@ page import="com.mvc.model.*" %>
<%
BbsDto bean=(BbsDto)request.getAttribute("bean");
%>
<form action="edit.do" method="post">
	<input type="hidden" name="num" value="<%=bean.getNum()%>">
	<div>
		<label>subject</label><input class="edit" name="sub" value="<%=bean.getSub() %>" readonly/>
	</div>
	<div>
		<label>id</label><input class="edit" name="id" value="<%=bean.getId() %>" readonly/>
	</div>
	<div>
		<label>nalja</label><input class="edit" type="date" value="<%=bean.getNalja() %>" disabled/>
	</div>
	<div>
		<textarea class="edit" name="content"><%=bean.getContent() %></textarea>
	</div>
	<div>
		<button type="button">수정</button>
		<button type="submit">수정</button>
		<button type="button">삭제</button>
		<button type="button">뒤로</button>
	</div>
</form>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>








