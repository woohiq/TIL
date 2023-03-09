<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그아웃 시키는 방법 2가지 -->
	<!-- 세션이 갖고 있는 속성을 remove -->
	<%
		session.removeAttribute("loginUser");
	%>
	
	<!--  세션을 지워버리기 -->
	<%
		session.invalidate();
	%>
	
	<script type="text/javascript">
		alert("로그아웃");
		location.href="loginForm.jsp";
	</script>
</body>
</html>