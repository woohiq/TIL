<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>에러페이지</title>
</head>
<body>
	에러가 발생했대
	<%= exception.getMessage() %>
</body>
</html>