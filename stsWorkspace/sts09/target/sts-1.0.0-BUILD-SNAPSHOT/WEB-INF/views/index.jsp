<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>동기네 업로드 페이지</h1>
<form action="./" method="post" enctype="multipart/form-data">
	<div>
		<label>msg</label><input type="text" name="msg"/>
	</div>
	<div>
		<label>file</label><input type="file" name="files"/>
	</div>
	<div>
		<label>file</label><input type="file" name="files"/>
	</div>
	<div>
		<label>file</label><input type="file" name="files"/>
	</div>
	<div>
		<button>전송</button>
	</div>
</form>
</body>
</html>