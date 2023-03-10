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
	<!-- ${param.fruit }가 선택됨 <br> -->
	<c:if test="${param.fruit == 1 }">
		<div style="color:orange">귤</div>
	</c:if>
	<c:if test="${param.fruit == 2 }">
		<div style="color:yellow">망고</div>
	</c:if>
	<c:if test="${param.fruit == 3 }">
		<div style="color:red">딸기</div>
	</c:if>
	<c:if test="${param.fruit == 4 }">
		<div style="color:red">수</div>
		<div style="color:green">박</div>
	</c:if>
	<hr>
	<c:choose>
		<c:when test="${param.fruit == 1 }">
			<div style="color:orange">귤</div>
		</c:when>
		<c:otherwise>
			<div style="color:black">그 외</div>
		</c:otherwise>
	</c:choose>
</body>
</html>