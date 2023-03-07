package com.ssafy.myservlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 해당 클래스를 서블릿으로 만들기 위해서는
//servlet이라는 것을 구현해야 함

public class MyServlet1 implements Servlet{

	@Override
	public void destroy() {
		// 서블릿이 파괴될 때 실행되는 메서드
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// 서블릿 설정을 건드리는 메서드
		return null;
	}

	@Override
	public String getServletInfo() {
		// 서블릿 정보를 보내는 메서드
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 초기화 할 때 쓰는 메서드
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 클라이언트로부터 요청이 들어왔따면 처리를 하는 메서드
		
	}
	
}
