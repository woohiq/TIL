
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 선택</title>
</head>
<body>
	<%
		String[] movieList = {"인셉션", "아이언맨", "해리포터", "타짜"};
		pageContext.setAttribute("movieList", movieList);
	%>
	
	<table border="1">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>title</th>
		</tr>
		<c:forEach var="movie" items="${movieList }" varStatus="status" begin="0" end="10" step="2">
			<tr>
				<td>${status.index }</td>
				<td>${status.count }</td>
				<td>${movie }</td>
			</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>