package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.ws.step2.dto.Movie;

//<servlet>
//	<servlet-name>mainServlet</servlet-name>
//</servlet>
//<servlet-mapping>
//	<servlet-name>mainServlet</servlet-name>
//	<url-pattern>"/main"<url-pattern>
//</servlet-mapping>
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int id;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
			case "regist" :
				doRegist(request, response);
				break;
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));
		
		Movie movie = new Movie(id++, name, director, genre, runningTime);
		
		// 출력을 위해서 stringbuilder를 사용하자
		StringBuilder output = new StringBuilder();
		
		// html 태그가 적용될 수 있도록 response를 encoding 입히기
		response.setContentType("text/html; charset=UTF-8");
		output.append("<html><body>")
				.append("<h1>영화 정보</h1>")
				.append(movie.toString())
				.append("</body></html>");
		
		// response 객체를 통해 생성된 htm 코드를 출력
		response.getWriter().write(output.toString());
	}

}
