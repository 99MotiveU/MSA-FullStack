<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/base.css">
<style type="text/css">
#content{}
#content>form{
	width: 500px;
	margin: 10px auto 50px auto;
}
#content>form>div{
	margin-bottom: 10px;
}
#content>form>div>label{
	width: 100px;
	box-sizing: border-box;
	display: inline-block;
}
#content>form>div>input{
	width: 390px;
	box-sizing: border-box;
	padding: 5px;	
}
#content>form>div>textarea{
	box-sizing: border-box;
	width: 500px;
	height: 200px;
	padding: 10px;	
}
#content>form>div>button{
	box-sizing: border-box;
	width: 33%;
	height: 25px;
	float: left;
}

</style>
<script type="text/javascript">
var btns,input,textarea,h2;
window.onload=function(){
	h2=document.querySelector('#content h2');
	btns=document.querySelectorAll('form button');
	input=document.querySelector('form>div>input');
	textarea=document.querySelector('form>div>textarea');
	btns[1].style.display='none';
	btns[0].onclick=function(e){
		h2.innerText="수정 페이지";
		btns[1].style.display='inline-block';
		btns[0].style.display='none';
		input.readOnly=false;
		textarea.readOnly=false;
		btns[3].onclick=function(){
			h2.innerText="상세 페이지";
			btns[1].style.display='none';
			btns[0].style.display='inline-block';
			input.readOnly=true;
			textarea.readOnly=true;
		};
	};
	btns[3].onclick=function(){
		history.back();
	};
};

</script>
</head>
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
<%@ page import="java.sql.*,com.web12.model.*,com.web12.util.*" %>
<%
String sql="select * from bbs05 where num="+request.getParameter("num");
Bbs05Dto bean=null;
try{
	Statement stmt=MyDataBase.getConnection().createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	if(rs.next())
		bean=new Bbs05Dto(
				rs.getInt("num"),rs.getString("sub"),rs.getString("content")
				,rs.getInt("cnt"),rs.getDate("nalja")
				);
}finally{
	if(MyDataBase.getConnection()!=null)MyDataBase.getConnection().close();
}
%>
		<h2>상세 페이지</h2>
		<form action="update.jsp" method="post">
				<input type="hidden" name="num" value="<%=bean.getNum()%>"/>
			<div>
				<label>subject</label>
				<input name="sub" value="<%=bean.getSub()%>" readonly="readonly"/>
			</div>
			<div>
				<label>cnt</label>
				<input name="cnt" value="<%=bean.getCnt()%>" readonly/>
			</div>
			<div>
				<label>nalja</label>
				<input type="date" name="nalja" value="<%=bean.getNalja()%>" readonly/>
			</div>
			<div>
				<textarea name="content" readonly><%=bean.getContent() %></textarea>
			</div>
			<div>
				<button type="button">수정</button>
				<button type="submit">submit</button>
				<button type="reset">취소</button>
				<button type="button">뒤로</button>
			</div>
		</form>
		<!-- content end -->
		</div>
		<div id="footer">
			<address>(06130) 서울 강남구 테헤란로 7길 22, 한국과학기술회관 1관 303호</address>
			<p>&copy;한국IT여성기업인협회 Inc. All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>






