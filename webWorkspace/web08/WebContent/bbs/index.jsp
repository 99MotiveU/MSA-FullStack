<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="../">[home]</a>
<a href="../bbs/">[bbs]</a>
<a href="../login/">[login]</a>
<hr>
<h1>list page</h1>
<dl>
<%@page import="java.util.*,java.sql.*,com.web08.model.*" %>
<% 
List<Bbs07Bean> list=new ArrayList<>();
String sql="select * from bbs07";
try(
		Connection conn=MyDb.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		){
	while(rs.next()){
		Bbs07Bean bean=new Bbs07Bean();
		bean.setNum(rs.getInt("num"));
		bean.setSub(rs.getString("sub"));
		bean.setId(rs.getString("id"));
		list.add(bean);
	}
}
for(int i=0; i<list.size(); i++){
	Bbs07Bean bean=list.get(i);
%>
	<dt><%=bean.getNum() %> - <%=bean.getId() %></dt>
	<dd><a href="detail.jsp?num=<%=bean.getNum() %>"><%=bean.getSub() %></a></dd>
<% 
}
%>
</dl>
<p><a href="add.html">[입 력]</a></p>
</body>
</html>















