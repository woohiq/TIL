<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 선택</title>
</head>
<body>
<!-- 메서드 생략 시 GET으로 날라감 -->
	<form action="09_fruitResult.jsp">
		<select name="fruit">
			<option value="1">귤</option>>
			<option value="2">망고</option>>
			<option value="3">딸기</option>>
			<option value="4">수박</option>>
		</select>
		<input type="submit">
	</form>
	
	
</body>
</html>