<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../">[HOME]</a>
<a href="./">[BBS]</a>
<hr>
<h1>list page</h1>
<dl>
<%
String driver="com.mysql.cj.jdbc.Driver";
//https://dev.mysql.com/doc/connector-j/en/connector-j-reference-jdbc-url-format.html
//protocol//[hosts][/database][?properties]
//jdbc:mysql://host1:33060/sakila
String url="jdbc:mysql://localhost:3306/xe";
String user="scott";
String password="tiger";
String key=request.getParameter("key");
String word=request.getParameter("word");
if(key==null)key="subject";
if(word==null)word="";
String sql="select * from bbs02 WHERE "+key
			+" LIKE '%"+word+"%' order by num DESC";

Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
try{
	Class.forName(driver);
	conn=DriverManager.getConnection(url,user,password);
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	while(rs.next()){
%>
	<dt><%=rs.getInt("num") %> - <%=rs.getString("id") %></dt>
	<dd><%=rs.getString("subject") %></dd>
<%
	}
}finally{
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(conn!=null)conn.close();
}
%>
</dl>
<form action="./">
<select name="key">
	<option value="subject">제목</option>
	<option value="id">아이디</option>
	<option value="content">내용</option>
</select>
<input type="text" name="word"><input type="submit" value="조회">
</form>
<a href="./add.jsp">ADD</a>
</body>
</html>














