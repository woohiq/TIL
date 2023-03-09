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

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private Movie[] mvList = new Movie[10];
	private int movieCount = 0;

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html; charset=UTF-8");
   		String action = request.getParameter("action");
		switch(action) {
		case "regist" :
			++id;
			int runningTime = Integer.parseInt(request.getParameter("runningTime"));
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			String director = request.getParameter("director");
			
			Movie cur = new Movie(id, title, director, genre, runningTime);
			mvList[movieCount++] = cur;
			
			HttpSession session = request.getSession();
			
			session.setAttribute("MovieList", mvList);
			session.setAttribute("count", movieCount);
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/regist_result.jsp");
//			dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath()+"/regist_result.jsp");
			
			break;
		case "view" : 
			break;
		}
   	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
