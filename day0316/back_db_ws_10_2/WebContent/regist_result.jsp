<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ssafy.ws.step2.dto.Movie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <c:choose>
    	<c:when test="${Movie == null }">
    		<h2>등록된 영화 정보가 존재하지 않습니다</h2>
    	</c:when>
    	<c:otherwise>
    		<h2>방금 등록된 영화는 다음과 같습니다</h2>
    	</c:otherwise>
    </c:choose>
    <table>
      <thead>
        <tr>
          <th>항목</th>
          <th>내용</th>
        </tr>
      </thead>
      <tbody>
      	<c:choose>
      		<c:when test="${Movie == null}">
      			<tr>
      				<td>추가했던 영화가</td>
      				<td>존재하지 않습니다</td>
      			</tr>
      		</c:when>
      		<c:otherwise>
      			<tr>
		          <td>Id</td>
		          <td>${Movie.getId() }</td>
		        </tr>
     			<tr>
		          <td>제목</td>
		          <td>${Movie.getTitle() }</td>
		        </tr>
		        <tr>
		          <td>장르</td>
		          <td>${Movie.getGenre() }</td>
		        </tr>
		        <tr>
		          <td>감독</td>
		          <td>${Movie.getDirector() }</td>
		        </tr>
		        <tr>
		          <td>상영시간</td>
		          <td>${Movie.getRunningTime() }</td>
		        </tr>
      		</c:otherwise>
      	</c:choose>
      </tbody>
    </table>
    <a href="regist.jsp">추가등록</a>
    <a href="list.jsp">전체 목록 조회</a>
  </body>
</html>
