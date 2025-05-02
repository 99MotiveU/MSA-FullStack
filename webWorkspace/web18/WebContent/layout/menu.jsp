<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div id="menu">
			<ul><% String path=request.getParameter("path"); %>
				<li><a href="<%=path %>/index.do">home</a></li>
				<li><a href="<%=path %>/intro.do">intro</a></li>
				<li><a href="<%=path %>/bbs/list.do">bbs</a></li>
				<li><a href="<%=path %>/login/login.do">login</a></li>
			</ul>
		</div>
		<div id="content">
			<!-- content begin -->