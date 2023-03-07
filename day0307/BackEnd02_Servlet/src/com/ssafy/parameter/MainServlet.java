package com.ssafy.parameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		switch(action) {
		case "regist":
			writer.append("<html>");
			writer.append("<body>");
			writer.append("<span> 이름은 : ");
			String name = request.getParameter("name");
			writer.append(name);
			writer.append(" 입니다 </span>");
			writer.append("</body>");
			writer.append("</html>");
			break;
		case "gugu" :
			writer.append("<html>");
			writer.append("<body>");
			writer.append("<h1>구구단 실행</h1>");
			writer.append("<h2> 정답은 : </h2>");
			String number = request.getParameter("dan");
			for (int i = 1; i<=9; i++) {
				writer.append("<p>"+number+" X "+i+" = "+(i*Integer.parseInt(number)+"</p>"));
			}
			writer.append("</body>");
			writer.append("</html>");
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		doGet(request, response);
	}

}
