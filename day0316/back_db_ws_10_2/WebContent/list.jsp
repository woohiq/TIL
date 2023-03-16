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
    	<c:when test="${count == null }">
    		<h2>등록된 영화 정보가 존재하지 않습니다</h2>
    	</c:when>
    	<c:otherwise>
    		<h2>여태까지 등록된 영화 정보는 ${count }개 입니다</h2>
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
      		<c:when test="${MovieList == null}">
      			<tr>
      				<td>추가했던 영화가</td>
      				<td>존재하지 않습니다</td>
      			</tr>
      		</c:when>
      		<c:otherwise>
      			<c:forEach var="mv" items="${MovieList }" end="${count-1 }" varStatus="status"> 
      				<tr>
			          <td>ID</td>
			          <td>${mv.getId() }</td>
			        </tr>
      				<tr>
			          <td>제목</td>
			          <td>${mv.getTitle() }</td>
			        </tr>
			        <tr>
			          <td>장르</td>
			          <td>${mv.getGenre() }</td>
			        </tr>
			        <tr>
			          <td>감독</td>
			          <td>${mv.getDirector() }</td>
			        </tr>
			        <tr>
			          <td>상영시간</td>
			          <td>${mv.getRunningTime() }</td>
			        </tr>
			        <c:if test="${status.index < (count-1) }">
			        	<tr>
				          <td class="blankLine"></td>
				          <td class="blankLine"></td>
				        </tr>
			        </c:if>
      			</c:forEach>
      		</c:otherwise>
      	</c:choose>
      </tbody>
    </table>
    <a href="regist.jsp">추가등록</a>
  </body>
</html>
