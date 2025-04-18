<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="http://www.kibwa.org/data/skin/default/images/da_image/hd_logo.png">
<a href="../">[HOME]</a>
<a href="../bbs/">[BBS]</a>
<a href="../login/">[login]</a>
<hr>
<%@ page import="java.util.List,com.bbs07.model.*" %>
<%
	Bbs07Dao dao=new Bbs07Dao();
	List<com.bbs07.model.JavaBean> list=dao.selectAll();
%>
<h1>list page</h1>
<table border="1" width="800" cellspacing="0">
<tr>
	<th width="50">번호</th>
	<th>제목</th>
	<th width="100">글쓴이</th>
	<th width="100">날짜</th>
</tr>
<%
for(int i=0; i<list.size(); i++){
	JavaBean bean=list.get(i);
%>
<tr>
	<td><a href="detail.jsp?idx=<%=bean.getNum() %>"><%=bean.getNum() %></a></td>
	<td>
	<%
	for(int j=0; j<bean.getLvl(); j++){
		out.print("&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	if(bean.getLvl()!=0)out.print("┖");
	%>
		<a href="detail.jsp?idx=<%=bean.getNum() %>"><%=bean.getSub() %></a>
	</td>
	<td><a href="detail.jsp?idx=<%=bean.getNum() %>"><%=bean.getId() %></a></td>
	<td><a href="detail.jsp?idx=<%=bean.getNum() %>"><%=bean.getNalja() %></a></td>
</tr>
<%
}
%>
</table>
<p><a href="add.jsp">[입 력]</a></p>
</body>
</html>













