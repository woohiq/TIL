<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키</title>
</head>
<body>
	<h2>쿠키 확인</h2>
	<hr>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			int i = cookies.length;
	%>
				<h3>size : <%=i %></h3>
	<%
			for (Cookie c : cookies){
				String key = c.getName();
				String value = c.getValue();
	%>
				<h3><%=key %> : <%=value %></h3>
	<%			
			}
		} else {
			out.print("쿠키가 없습니다");
		}
	%>

	<h2>쿠키 입력</h2>
	<form action="make" method="GET">
		키 : <input type="text" name="key" placeholder="키를 입력하세요"><br>
		값 : <input type="text" name="value" placeholder="값을 입력하세요"><br>
		
		<button>제출</button>
	</form>
	
</body>
</html>