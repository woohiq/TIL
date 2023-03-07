package com.ssafy.parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletParameter
 */
@WebServlet("/ServletParameter")
public class ServletParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		if (text == null) text = "널값이래요";
		System.out.println(text);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>Hello</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h1>");
		writer.append(text);
		writer.append("</h1>");
		writer.append("</body>");
		writer.append("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}


}
