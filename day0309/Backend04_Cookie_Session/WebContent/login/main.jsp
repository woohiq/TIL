<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h3>메인 페이지 입니다</h3>
	<%
		if(session.getAttribute("user") != null){
	%>
			<%=session.getAttribute("user")%>님 반갑습니다
	<%
		} else {
			response.sendRedirect("loginForm.jsp");
		}
	%>
	<!-- 로그아웃 기능 -->
	<form action="logout.jsp" method="POST">
		<button>로그아웃</button>
	
	</form> 


	
</body>
</html>