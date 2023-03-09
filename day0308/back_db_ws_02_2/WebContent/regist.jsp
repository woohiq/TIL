<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>영화정보 조회</title>
    <style>
    form {
      margin : 0px 20px 0px;
    }
    fieldset label{
    	width: 80px;
    }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body>
	  <h2>영화 정보 입력</h2>
	  <form action="main" method="POST">
		  <fieldset>
			  <legend>영화 정보를 입력해주세요</legend>
        <input type = "hidden" name = "action" value="regist">
        <div>
        <label>제목</label>
        <input type="text" name="title">
        </div>
        <div>
        <label>장르</label>
        <input type="text" name="genre">
        </div>
        <div>
        <label>감독</label>
        <input type="text" name="director">
        </div>
        <div>
        <label>상영시간</label>
        <input type="number" min="1" value="1" name="runningTime">
        </div>
        <input class="btn btn-primary" type="submit" value="등록">
        <input class="btn btn-danger" type="reset" value="초기화">
	    </fieldset>
	  </form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </body>
</html>
