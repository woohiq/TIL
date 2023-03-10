package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    
	private static int movieCount = 0;
	
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
		
		HttpSession session = request.getSession();
		session.setAttribute("movieCount", ++movieCount);
		
		request.setAttribute("title", name);
		request.setAttribute("director", director);
		request.setAttribute("genre", genre);
		request.setAttribute("runningTime", runningTime);
		
		RequestDispatcher disp = request.getRequestDispatcher("/regist_result.jsp");
		disp.forward(request, response);
	}
}
