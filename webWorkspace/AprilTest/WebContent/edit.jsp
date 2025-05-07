<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="com.mvc.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 게시판</title>
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
	margin: 50px auto;
	background-color: #ffffff;
	box-shadow: 0 6px 18px rgba(0, 0, 0, 0.08);
	border-radius: 12px;
	padding: 40px 30px;
}

h2 {
	font-size: 26px;
	margin-bottom: 25px;
	color: #2c3e50;
	border-left: 5px solid #4a90e2;
	padding-left: 15px;
}

.info {
	color: #666;
	font-size: 14px;
	margin-bottom: 25px;
	border-bottom: 1px solid #ddd;
	padding-bottom: 10px;
}

label {
	display: block;
	margin-top: 20px;
	font-weight: bold;
	color: #333;
}

input[type="text"],
textarea {
	width: 100%;
	padding: 12px 14px;
	margin-top: 8px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 15px;
	background-color: #fafafa;
	transition: border-color 0.3s ease;
}

input[type="text"]:focus,
textarea:focus {
	outline: none;
	border-color: #4a90e2;
	background-color: #fff;
}

textarea {
	min-height: 180px;
	resize: vertical;
}

.btn-group {
	text-align: right;
	margin-top: 30px;
}

.btn-group button,
.btn-group a {
	display: inline-block;
	background-color: #4a90e2;
	color: white;
	padding: 10px 20px;
	border-radius: 6px;
	text-decoration: none;
	font-weight: 600;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-group a {
	line-height: 36px;
}

.btn-group button:hover,
.btn-group a:hover {
	background-color: #357ab7;
}
</style>
</head>
<body>
	<%
		BoardDto bean = (BoardDto) request.getAttribute("bean");
	%>
	<div class="container">
		<h2>게시글 수정</h2>

		<div class="info">
			작성자: <strong><%=bean.getUserId()%></strong> &nbsp;|&nbsp; 날짜:
			<%=bean.getCreatedAt()%>
		</div>

		<form action="<%=request.getContextPath()%>/edit" method="POST">
			<input type="hidden" name="id" value="<%=bean.getId()%>">

			<label for="title">제목</label>
			<input type="text" name="title" id="title" value="<%=bean.getTitle()%>" required>

			<label for="content">내용</label>
			<textarea name="content" id="content" required><%=bean.getContent()%></textarea>

			<div class="btn-group">
				<button type="submit">✏️ 수정 완료</button>
				<a href="<%=request.getContextPath()%>/detail?id=<%=bean.getId()%>">← 취소</a>
			</div>
		</form>
	</div>
</body>
</html>
