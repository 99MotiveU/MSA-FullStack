<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.err{
background-color: red;
color:white;
text-align: center;
font-style: italic;
}
</style>
<script type="text/javascript">
window.onload=function(){
	
};
setTimeout(() => {
	document.querySelector('.err').style.display='none';
	
}, 5000);
</script>
</head>
<body>
<div class="err">${errMsg}</div>
<a href="${pageConext.request.ContextPath }/index">home</a>
<a href="<%=request.getContextPath() %>/intro">intro</a>
<a href="<%=request.getContextPath() %>/bbs/list">bbs</a>
<a href="<%=request.getContextPath() %>/login/login">login</a>
<hr/>
<h1>add page</h1>
<form action="add" method="post">
	<div>
		<label>subject</label><input name="sub" value="${sub }"/>
	</div>
	<div>
		<label>id</label><input name="id" value="${id }"/>
	</div>
	<div>
		<textarea name="content">${content }</textarea>
	</div>
	<button>전달</button>
</form>
</body>
</html>












