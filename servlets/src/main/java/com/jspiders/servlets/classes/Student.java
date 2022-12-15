package com.jspiders.servlets.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Student extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws 
			ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String fullName = request.getParameter("fullName");
		writer.println("<h1>Hello " + fullName + "</h1>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws 
			ServletException, IOException {
		
//		response.setContentType("text/html");
//		PrintWriter writer = response.getWriter();
//		String fullName = request.getParameter("fullName");
//		writer.println("<h1>Hello " + fullName + "</h1>");
	}

}
