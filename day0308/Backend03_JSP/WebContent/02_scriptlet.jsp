<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>스크립트릿</title>
</head>
<body>
	<h2>스크립트릿 연습</h2>
	<%
		int A = 10;
		int B = 20;
		
		int sum = A+B;
		
		out.print(A+" + "+B+" = "+sum);
	
	%>
</body>
</html>