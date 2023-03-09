<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%! int cnt1 = 0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int cnt2 = 0;
		out.print("cnt1 : ");
		out.print(++cnt1);
		out.print("<br>");
		out.print("cnt2 : ");
		out.print(++cnt2);
		out.print("<br>");
	
	%>
</body>
</html>