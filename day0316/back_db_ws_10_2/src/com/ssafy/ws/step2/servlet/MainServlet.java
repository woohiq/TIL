package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.ws.step2.dao.MovieDaoImpl;
import com.ssafy.ws.step2.dto.Movie;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private List<Movie> mvList = MovieDaoImpl.getInstance().selectAll();
	private int movieCount = mvList.size();

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html; charset=UTF-8");
   		String action = request.getParameter("action");
   		HttpSession session = request.getSession();
		switch(action) {
		case "regist" :
			++id;
			int runningTime = Integer.parseInt(request.getParameter("runningTime"));
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			String director = request.getParameter("director");
			
			Movie cur = new Movie(id, title, director, genre, runningTime);
			mvList.add(cur);
			movieCount++;
			
			session.setAttribute("Movie", cur);
			session.setAttribute("MovieList", mvList);
			session.setAttribute("count", movieCount);
			
			response.sendRedirect(request.getContextPath()+"/regist_result.jsp");
			
			break;
			
		case "list" : 
			
			session.setAttribute("MovieList", mvList);
			session.setAttribute("count", movieCount);
			response.sendRedirect(request.getContextPath()+"/list.jsp");
			break;
		}
   	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
