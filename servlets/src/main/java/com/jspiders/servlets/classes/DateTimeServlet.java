package com.jspiders.servlets.classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateTimeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws 
			ServletException, IOException {
		resp.setContentType("text/html");
		resp.setHeader("Refresh", "1");
		PrintWriter printWriter = resp.getWriter();
		Date date = new Date();
		printWriter.println("<h1>" + date + "</h1>");
	}

}
