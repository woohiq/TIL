<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	if (id.equals("qwe") && pw.equals("asd")){
		// 로그인 성공했다면, 세션에 데이터를 넣기
		
		session.setAttribute("user", id);
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("loginForm.jsp");
	}
%>