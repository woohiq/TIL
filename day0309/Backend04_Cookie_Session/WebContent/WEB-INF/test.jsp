<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>세션확인</title>
</head>
<body>
	<%=session.getAttribute("name") %>
</body>
</html>