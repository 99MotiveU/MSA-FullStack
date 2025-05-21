<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/header.jspf" %>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<h2 class="page-header">상세 페이지</h2>
<form action="${bean.deptno}" method="post" class="form-horizontal">
	<input type="hidden" name="_method" value="put">
	<div class="form-group">
		<label class="sr-only">deptno</label><input name="deptno" class="form-control" value="${bean.deptno}" readonly/>
	</div>
	<div class="form-group">
		<label class="sr-only">dname</label><input name="dname" class="form-control" value="${bean.dname}" readonly/>
	</div>
	<div class="form-group">
		<label class="sr-only">location</label><input name="loc" class="form-control" value="${bean.loc}" readonly/>
	</div>
	<div class="form-group" id="detail">
		<div class="btn-group btn-group-justified" role="group">
			<div class="btn-group" role="group" aria-label="...">
			<a href="#" class="btn btn-default" role="button">수정</a>
			</div>
			<div class="btn-group" role="group" aria-label="...">
			<a href="#" class="btn btn-danger" role="button">삭제</a>
			</div>
			<div class="btn-group" role="group" aria-label="...">
			<button type="button" class="btn btn-default">뒤로</button>
			</div>
		</div>
	</div>
	<div class="form-group" id="edit">
		<div class="btn-group btn-group-justified" role="group">
			<div class="btn-group" role="group" aria-label="...">
			<button type="submit" class="btn btn-primary">수정</button>
			</div>
			<div class="btn-group" role="group" aria-label="...">
			<button type="reset" class="btn btn-default">취소</button>
			</div>
			<div class="btn-group" role="group" aria-label="...">
			<button type="button" class="btn btn-default">뒤로</button>
			</div>
		</div>
	</div>
</form>
<%@ include file="../layout/footer.jspf" %>
<script type="text/javascript">
$(function(){
	$('#edit').hide();
	$('#detail a').eq(0).click(function(e){
		e.preventDefault();
		$('#detail').hide();
		$('#edit').show();
		$('form input').eq(2).removeProp('readonly');
		$('form input').eq(3).removeProp('readonly');
		return false;
	});
	$('#detail a').eq(1).click(function(e){
		e.preventDefault();
		if(window.confirm('삭제하시겠습니까?')){
			$.ajax({
				url:'${bean.deptno}'
				,method: 'delete'
				,success: function(e){
					location.href='./';
				}
				,error:function(xhr,msg,err){
					alert(msg);
					console.log(err);
				}
			});
		}
		return false;
	});
});
</script>
</body>
</html>









