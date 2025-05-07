<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>✏️ 답글 작성</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<style>
body {
	font-family: 'Noto Sans KR', sans-serif;
	background: linear-gradient(to right, #eef2f3, #ffffff);
	margin: 0;
	padding: 0;
}

.container {
	width: 90%;
	max-width: 800px;
	margin: 60px auto;
	background-color: #fff;
	box-shadow: 0 6px 16px rgba(0, 0, 0, 0.08);
	border-radius: 12px;
	padding: 40px 30px;
}

h2 {
	text-align: center;
	font-size: 24px;
	color: #2c3e50;
	margin-bottom: 25px;
}

form {
	display: flex;
	flex-direction: column;
	gap: 20px;
}

label {
	font-weight: bold;
	color: #333;
	margin-bottom: 6px;
}

input[type="text"],
textarea {
	width: 100%;
	padding: 12px 14px;
	font-size: 15px;
	border: 1px solid #ccc;
	border-radius: 6px;
	box-sizing: border-box;
}

textarea {
	min-height: 180px;
	resize: vertical;
}

.btns {
	display: flex;
	justify-content: flex-end;
	gap: 10px;
	margin-top: 25px;
}

.btns input[type="submit"],
.btns a {
	padding: 10px 18px;
	border-radius: 6px;
	font-weight: bold;
	text-decoration: none;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btns input[type="submit"] {
	background-color: #4a90e2;
	color: white;
}

.btns input[type="submit"]:hover {
	background-color: #357ab7;
}

.btns a {
	background-color: #ccc;
	color: #333;
}

.btns a:hover {
	background-color: #b3b3b3;
}
</style>
</head>
<body>
	<%
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		int orderInGroup = Integer.parseInt(request.getParameter("orderInGroup"));
		int depth = Integer.parseInt(request.getParameter("depth"));
	%>

	<div class="container">
		<h2>✏️ 답글 작성</h2>
		<form method="post" action="<%=request.getContextPath()%>/reply">
			<input type="hidden" name="groupId" value="<%=groupId%>">
			<input type="hidden" name="orderInGroup" value="<%=orderInGroup%>">
			<input type="hidden" name="depth" value="<%=depth%>">

			<div>
				<label for="userId">작성자</label>
				<input type="text" name="userId" id="userId" required>
			</div>

			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" required>
			</div>

			<div>
				<label for="content">내용</label>
				<textarea name="content" id="content" required></textarea>
			</div>

			<div class="btns">
				<input type="submit" value="답글 등록">
				<a href="<%=request.getContextPath()%>/list">취소</a>
			</div>
		</form>
	</div>
</body>
</html>
