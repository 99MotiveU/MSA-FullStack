<%@ page contentType="text/html; charset=utf-8"
pageEncoding="utf-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<c:forEach items="${list }" var="bean">
<div>${bean }</div>
</c:forEach>
<form action="upload.do" method="post" enctype="multipart/form-data">
<div>
	<label>msg</label><input name="msg"/>
</div>
<div>
	<label>file</label><input type="file" name="file1"/>
</div>
<div>
	<button>전송</button>
</div>
</form>

</body>
</html>
