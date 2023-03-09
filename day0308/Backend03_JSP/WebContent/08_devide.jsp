<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>강제로 0으로 나누는 오류를 발생시킨다
</title>
</head>
<body>
	0으로 나누는 것은 불가능
	<%= 2/0 %>
</body>
</html>