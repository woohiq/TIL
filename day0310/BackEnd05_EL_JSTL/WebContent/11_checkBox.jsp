<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반찬 선택</title>
</head>
<body>
	<h2>반찬 고르기</h2>
	<form action="12_checkBoxResult.jsp">
		<input type="checkbox" name="dish" value="맥주">맥주
		<input type="checkbox" name="dish" value="진미채">진미채
		<input type="checkbox" name="dish" value="미나리">미나리
		<input type="checkbox" name="dish" value="장조림">장조림
		<input type="checkbox" name="dish" value="삼겹살">삼겹살
		<button>구매</button>
	</form>
</body>
</html>