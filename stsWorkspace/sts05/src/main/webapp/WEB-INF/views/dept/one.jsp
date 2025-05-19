<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/header.jspf" %>
<style type="text/css">
.modal form{
	display: inline;
}
</style>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<h1>${title } 페이지</h1>
<form class="form" action="edit" method="post">
	<div class="form-group">
		<label>deptno</label><input value="${bean.deptno }" name="deptno" class="form-control" readonly/>
	</div>
	<div class="form-group">
		<label>dname</label><input value="${bean.dname }" name="dname" class="form-control" ${title eq '상세'?'readonly':'' }/>
	</div>
	<div class="form-group">
		<label>location</label><input value="${bean.loc }" name="loc" class="form-control" ${title eq '상세'?'readonly':'' }/>
	</div>
	<div class="form-group">
		<c:if test="${title eq '상세' }">
		<a href="edit?deptno=${bean.deptno }" class="btn btn-primary" role="button">수정</a>
		<Button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">삭제</button>
		</c:if>
		<c:if test="${title eq '수정' }">
		<button type="submit" class="btn btn-primary">수정</button>
		<button type="reset" class="btn btn-default">취소</button>
		</c:if>
		<button type="button" class="btn btn-default"onclick="history.back();">뒤로</button>
	</div>
</form>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <form action="delete" method="post">
        <input type="hidden" name="deptno" value="${bean.deptno }">
        <button type="submit" class="btn btn-danger">삭제</button>
        </form>
      </div>
    </div>
  </div>
</div>
<%@ include file="../layout/footer.jspf" %>
</body>
</html>






