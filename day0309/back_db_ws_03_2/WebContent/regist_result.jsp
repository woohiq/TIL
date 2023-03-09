<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>영화정보사이트</title>
    <style>
      table {
        border: 3px solid orange;
        color: grey;
        border-spacing : 0px;
        text-align: center;
        background-color: cornsilk;
      }
      th {
        font: bold;
        color: black;
        font-size: bigger;
        border: 1px solid gray;
        background-color:linen;
      }
      td {
      	margin: 0px;
      	border: 1px solid gray;
      	width: 150px;
      }
      td:last-child {
      	width: 300px;
      }
      .blankLine {
        background-color: orange;
        border: none;
        height: 5px;
      }
    </style>
  </head>
  <body>
    <h1>영화 등록 결과</h1>
    <%
      int cnt = 0;
      if (session.getAttribute("count") == null){
    %>
      <h2>등록된 영화 정보가 존재하지 않습니다</h2>
    <%
      } else {
      cnt = (int)session.getAttribute("count");
    %>
      <h2>여태까지 등록된 영화 정보는 <%=cnt %>개입니다</h2>
    <%
      }
    %>
    <table>
      <thead>
        <tr>
          <th>항목</th>
          <th>내용</th>
        </tr>
      </thead>
      <tbody>
        <%
            Movie[] mvList = (Movie[])(session.getAttribute("MovieList"));
          if(mvList != null) {
            for (int i = 0; i < cnt; i++){
              Movie mv = mvList[i];
        %>
        <tr>
          <td>제목</td>
          <td><%=mv.getTitle() %></td>
        </tr>
        <tr>
          <td>장르</td>
          <td><%=mv.getGenre() %></td>
        </tr>
        <tr>
          <td>감독</td>
          <td><%=mv.getDirector() %></td>
        </tr>
        <tr>
          <td>상영시간</td>
          <td><%=mv.getRunningTime() %></td>
        </tr>
        <tr>
          <td class="blankLine"></td>
          <td class="blankLine"></td>
        </tr>
        <%
            } 
          } else {
        %>
        <tr>
          <td>추가했던 영화가</td>
          <td>존재하지 않습니다</td>
        </tr>
        <%
            
          }
        %>
      </tbody>
    </table>
    <a href="/back_ws_03_2/regist.jsp">추가등록</a>
  </body>
</html>