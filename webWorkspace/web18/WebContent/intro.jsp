<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/frame.css">
</head>
<body>
<jsp:include page="layout/header.jsp"></jsp:include>
<jsp:include page="layout/menu.jsp">
	<jsp:param value="." name="path"/>
</jsp:include>
<h2>인사말</h2>
<p>
안녕하십니까. 한국IT여성기업인협회 회장 김덕재입니다.
한국IT여성기업인협회는 과학기술정보통신부 산하 유일한 여성기업인 단체로서
국내 IT 산업의 발전을 위해 여성기업인들의 경쟁력 강화, ICT 여성 인재 양성,
경력단절 여성의 경제활동 참여 확대 등 다양한 노력을 기울이고 있습니다.
</p>
<p>
저희 협회는 IT여성기업의 Re-Start, Re-Challenge, Re-Innovation이라는 비전과
다음과 같은 네 가지 추진 전략을 세우고, 이를 실천해 나갈 것입니다.
</p>
<p>
첫째, 새로운 출발을 위해 회원사들의 성장동력을 모색하고,
IT기업인의 성공 노하우 공유 네트워크를 확대하여 비즈니스 활성화를 도모하겠습니다.
</p>
<p>
둘째, 새로운 도전을 통해 특화사업을 발굴하고 공동 협력을 추진하여 전국 협업 인프라 구축을
통해 스케일업, IT여성기업의 지속성장을 지원하고, 나아가 글로벌 진출을 모색할 것입니다.
</p>
<p>
셋째, 새로운 혁신을 추구하여 IT업계의 변화에 빠르게 대응하는 역량을 강화하고,
유관기관과의 협력을 통해 성장을 이끌어낼 것입니다.
</p>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>