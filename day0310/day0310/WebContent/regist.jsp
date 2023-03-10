<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
      <h1>SSAFY 영화 관리</h1>
      <h2>지금까지 등록한 영화 수 : <%=session.getAttribute("movieCount") %></h2>
      <form method = "POST" action = "main">
        <fieldset>
          <legend>영화 정보 입력</legend>
          <!--front controller pattern을 사용하기 위한 parameter설정-->
          <input type="hidden" name = "action" value = "regist">
          <label for="title"> 제목
            <input type="text" id="title" name="title"> 
          </label><br>
          <label for="director"> 감독
            <input type="text" id = "director" name="director">
          </label><br>
          <label for="genre"> 장르
            <input type="text" id="genre" name="genre">
          </label><br>
          <label for="runningTime"> 상영시간
            <input type="number" id="runningTime" name="runningTime">
          </label><br>
          <input class="btn btn-primary" type="submit" value="등록">
          <input class="btn btn-danger" type="reset" value="초기화">
        </fieldset>
      </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </body>
</html>