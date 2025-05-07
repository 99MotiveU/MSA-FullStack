<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 - 게시판</title>
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
	font-size: 26px;
	color: #2c3e50;
	margin-bottom: 30px;
	position: relative;
}

form {
	display: flex;
	flex-direction: column;
	gap: 20px;
}

label {
	font-weight: 600;
	margin-bottom: 6px;
	color: #333;
}

input[type="text"],
textarea {
	padding: 12px 14px;
	font-size: 15px;
	border: 1px solid #ccc;
	border-radius: 6px;
	width: 100%;
	box-sizing: border-box;
}

textarea {
	min-height: 180px;
	resize: vertical;
}

.buttons {
	display: flex;
	justify-content: flex-end;
	gap: 10px;
	margin-top: 25px;
}

.buttons input,
.buttons a {
	padding: 10px 20px;
	border: none;
	border-radius: 6px;
	font-weight: bold;
	cursor: pointer;
	text-decoration: none;
	transition: background-color 0.3s ease;
}

.submit-btn {
	background-color: #4a90e2;
	color: white;
}

.submit-btn:hover {
	background-color: #357ab7;
}

.cancel-btn {
	background-color: #ccc;
	color: #333;
}

.cancel-btn:hover {
	background-color: #b3b3b3;
}
</style>
</head>
<body>
	<div class="container">
		<h2>✏️ 새 글 작성</h2>

		<form action="add" method="post">
			<div>
				<label for="userId">작성자</label>
				<input type="text" id="userId" name="userId" required>
			</div>

			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" required>
			</div>

			<div>
				<label for="content">내용</label>
				<textarea id="content" name="content" required></textarea>
			</div>

			<div class="buttons">
				<input type="submit" class="submit-btn" value="등록">
				<a href="<%=request.getContextPath()%>/list" class="cancel-btn">취소</a>
			</div>
		</form>
	</div>
</body>
</html>
