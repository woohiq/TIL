<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	${param.id }<br>
	== : <%= request.getParameter("id") == "ssafy" %> <br>
	equals() : <%= request.getParameter("id").equals("ssafy") %> <br>
	
	== (EL) : ${param.id == "ssafy" } <br>
	equals (EL) : ${param.id eq "ssafy" } <br>
</body>
</html>