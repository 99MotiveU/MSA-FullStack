<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/base.css"> 
<style type="text/css">
table{
	border-collapse: collapse;
	width: 80%;
	margin: 10px auto;
}

table, table tr>th, table tr>td {
  border: 1px solid gray;
}

table tr{}
table tr>th:nth-child(1){
	width: 50px;
}
table tr>th:nth-child(3){
	width: 120px;
}
table tr>th:nth-child(4){
	width: 50px;
}
table tr>th{
	background-color: gray;
	color:white;
}
table tr>td{
	height: 45px;
}
table tr>td:nth-child(1),
table tr>td:nth-child(3),
table tr>td:nth-child(4)
{
	text-align: center;
}
table tr>td:nth-child(2){
	padding: 0px 20px;
}
table tr>td>a{
	display: block;
	height: 45px;
	text-decoration: none;
	color:gray;
	line-height: 45px;
}
table tr:hover>td{
	background-color: yellow;
}
table+p{
	text-align: center;
}
table+p>a{
	display:block;
	width: 80%;
	height: 35px;
	border-right: 3px solid #333333;
	border-bottom: 3px solid #333333;
	border-radius: 15px;
	margin: 0px auto;
	background-color: gray;
	color: white;
	text-decoration: none;
	line-height: 30px;
}
</style>
</head>
<%@ page import="java.sql.*,java.util.*,com.web12.util.MyDataBase" %>
<%@ page import="com.web12.model.Bbs05Dto" %>
<%
String sql="select * from bbs05 order by num desc";
List<Bbs05Dto> list=new ArrayList<>();
Statement stmt=null;
ResultSet rs=null;
try{
	stmt=MyDataBase.getConnection().createStatement();
	rs=stmt.executeQuery(sql);
	while(rs.next()){
		list.add(new Bbs05Dto(
				rs.getInt("num"),rs.getString("sub"),rs.getString("content")
				,rs.getInt("cnt"),rs.getDate("nalja")
				));
	}
}finally{
	if(MyDataBase.getConnection()!=null)MyDataBase.getConnection().close();
}
%>
<body>
	<div>
		<div id="header">
			<h1>한국it여성기업인협회</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="../">home</a></li>
				<li><a href="../intro.jsp">intro</a></li>
				<li><a href="./">bbs</a></li>
				<li><a href="../login/">login</a></li>
			</ul>
		</div>
		<div id="content">
		<!-- content begin -->
		<h2>리스트 페이지</h2>
		<table>
			<thead>
				<tr>
					<th>no</th>
					<th>subject</th>
					<th>nalja</th>
					<th>cnt</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(Bbs05Dto bean : list){
				%>
				<tr>
					<td><a href="detail.jsp?num=<%=bean.getNum() %>"><%=bean.getNum() %></a></td>
					<td><a href="detail.jsp?num=<%=bean.getNum() %>"><%=bean.getSub() %></a></td>
					<td><a href="detail.jsp?num=<%=bean.getNum() %>"><%=bean.getNalja() %></a></td>
					<td><a href="detail.jsp?num=<%=bean.getNum() %>"><%=bean.getCnt() %></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<p><a href="add.jsp">입력</a></p>
		<!-- content end -->
		</div>
		<div id="footer">
			<address>(06130) 서울 강남구 테헤란로 7길 22, 한국과학기술회관 1관 303호</address>
			<p>&copy;한국IT여성기업인협회 Inc. All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>






