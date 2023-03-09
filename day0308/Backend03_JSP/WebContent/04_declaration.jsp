<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	String name = "ssafy";

	public int add (int A, int B){
		return A + B;
	}
	
	public int abs (int A){
		return A > 0 ? A : -A;
	}
	
	int a = 10;
	int b = -20;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>선언</title>
</head>
<body>
	<%
		out.print(add(a,b));
	%> <br>
	<%
		out.print(abs(a));
	%> <br>
	<%
		out.print(abs(b));
	%> <br>
	
</body>
</html>