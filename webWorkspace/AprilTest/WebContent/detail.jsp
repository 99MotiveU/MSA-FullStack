<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="com.mvc.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>📋 상세 게시판</title>
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
	background-color: #ffffff;
	box-shadow: 0 6px 16px rgba(0, 0, 0, 0.08);
	border-radius: 12px;
	padding: 40px 30px;
}

h2 {
	font-size: 26px;
	margin-bottom: 20px;
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

.content {
	font-size: 17px;
	line-height: 1.7;
	color: #333;
	background-color: #f9f9f9;
	border: 1px solid #e0e0e0;
	padding: 20px;
	border-radius: 8px;
	margin-bottom: 30px;
	white-space: pre-wrap;
}

.btn-group {
	display: flex;
	flex-wrap: wrap;
	justify-content: flex-end;
	gap: 10px;
}

.btn-group button,
.btn-group a {
	background-color: #4a90e2;
	color: white;
	padding: 10px 18px;
	border-radius: 6px;
	text-decoration: none;
	font-weight: 600;
	border: none;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.btn-group form {
	display: inline;
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
		<h2><%=bean.getTitle()%></h2>

		<div class="info">
			작성자: <strong><%=bean.getUserId()%></strong> &nbsp;|&nbsp; 날짜: <%=bean.getCreatedAt()%>
		</div>

		<div class="content">
			<%=bean.getContent()%>
		</div>

		<div class="btn-group">
			<a href="<%=request.getContextPath()%>/list">← 목록으로</a>
			<a href="<%=request.getContextPath()%>/edit?id=<%=bean.getId()%>">✏️ 수정</a>
			<form action="<%=request.getContextPath()%>/delete" method="POST">
				<input type="hidden" name="id" value="<%=bean.getId()%>">
				<button type="submit">🗑️ 삭제</button>
			</form>
			<a href="<%=request.getContextPath()%>/reply?groupId=<%=bean.getGroupId()%>&orderInGroup=<%=bean.getOrderInGroup()%>&depth=<%=bean.getDepth()%>">↪️ 답글 작성</a>
		</div>
	</div>
</body>
</html>
