<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/frame.css">
<style type="text/css">
table{
	width: 80%;
	border-collapse: collapse;
	margin: 10px auto 10px auto;
}
table, tr>th, tr>td{
	border: 1px solid gray;
}
table tr>td{
	height: 35px;
}
table~p{
	margin: 0px 20px;
	text-align: center;
}
#content p>a{
	margin: 10px auto;
	
}
table td>a{
	display: block;
	height: 35px;
	text-decoration: none;
	color:gray;
	line-height: 30px;
	text-indent: 15px;
}
</style>
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$('tbody>tr').map(function(idx,ele){
		var alink=$(ele).find('td').children().first().clone();
		alink.html('');
		$(ele).first().children().not(':eq(0)').wrapInner(alink);		
	});
	
});
</script>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp">
	<jsp:param value=".." name="path"/>
</jsp:include>
<h2>게시판</h2>
<table>
	<thead>
		<tr>
			<th>no</th>
			<th>subject</th>
			<th>id</th>
			<th>nalja</th>
		</tr>
	</thead>
	<tbody>
		<%@ page import="java.util.*,com.mvc.model.*" %>
		<% 
		List<BbsDto> list=(List<BbsDto>)request.getAttribute("alist");
		for(BbsDto bean:list){
		%>
		<tr>
			<td><a href="detail.do?num=<%=bean.getNum() %>"><%=bean.getNum() %></a></td>
			<td><%=bean.getSub() %></td>
			<td><%=bean.getId() %></td>
			<td><%=bean.getNalja() %></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<p>
<%
int begin=(Integer)request.getAttribute("pageBegin");
int end=(Integer)request.getAttribute("pageEnd");
for(int i=begin; i<=end; i++){ 
%>
<a>[<%=i %>]</a>
<%} %>
</p>
<p>
	<a href="add.do">입력</a>
</p>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>





