package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dto.Person;
import com.ssafy.manager.PersonManager;


// Front Controller 패턴을 이용해서 모두 처리를 해 주었으면 좋겠다
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charSet=UTF-8"); 
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "regist" :
			doRegist(request, response);
			break;
		case "list" :
			doList(request, response);
			break;
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonManager pm = PersonManager.getInstance();
		request.setAttribute("list", pm.getAll());
		
		request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name  = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender  = request.getParameter("gender");
		String[] hobbies  = request.getParameterValues("hobby");
		
		Person p = new Person(name, age, gender, hobbies);
		
		PersonManager pm = PersonManager.getInstance();
		
		pm.regist(p);
		
		request.setAttribute("person", p);
		request.setAttribute("size", pm.getAll().size());
		
//		RequestDispatcher disp = request.getRequestDispatcher("/result.jsp");
//		disp.forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/result.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
