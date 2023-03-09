<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>영화정보사이트</title>
    <style>
      table {
        border: 3px solid orange;
        border-spacing : 0px;
        text-align: center;
        background-color: cornsilk;
      }
      td {
      	margin: 0px;
      	border-spacing: 0;
      	border: 1px solid black;
      	width: 150px;
      }
      td:last-child {
      	width: 300px;
      }
      tr:first-child {
      	font-size: larger;
      	font: bold;
      	color: orange;
      }
    </style>
  </head>
  <body>
    <h1>영화 등록 결과</h1>
    <h2>등록된 영화 정보</h2>
    <table>
    	<tr>
    		<td>항목</td>
    		<td>내용</td>
    	</tr>
    <%
      Movie[] mvList = (Movie[])request.getAttribute("MovieList");
      int cnt = (int)request.getAttribute("count");
      for (int i = 0; i < cnt; i++){
        Movie mv = mvList[i];
        out.print("<tr>");
        out.print("<td>제목</td>");
        out.print("<td>"+mv.getTitle()+"</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>장르</td>");
        out.print("<td>"+mv.getGenre()+"</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>감독</td>");
        out.print("<td>"+mv.getDirector()+"</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>상영시간</td>");
        out.print("<td>"+mv.getRunningTime()+"</td>");
        out.print("</tr>");
      }
    %>
    </table>
    
    <a href="/back_ws_02_2/regist.jsp">추가등록</a>
  </body>
</html>