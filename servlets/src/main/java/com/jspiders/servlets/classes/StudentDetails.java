package com.jspiders.servlets.classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetails
 */
@WebServlet("/student")
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/weje2?", "root", "root");
			String query = "insert into student_details "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement prepareStatement = 
					connection.prepareStatement(query);
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			prepareStatement.setString(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setString(3, email);
			prepareStatement.setString(4, mobile);
			prepareStatement.setString(5, username);
			prepareStatement.setString(6, password);
			int result = prepareStatement.executeUpdate();
			if (result != 0) {
				writer.println("<h3>" + name + "'s record inserted in database successfully</h3>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/weje2?", "root", "root");
			String query = "insert into student_details "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement prepareStatement = 
					connection.prepareStatement(query);
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			prepareStatement.setString(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setString(3, email);
			prepareStatement.setString(4, mobile);
			prepareStatement.setString(5, username);
			prepareStatement.setString(6, password);
			int result = prepareStatement.executeUpdate();
			if (result != 0) {
				writer.println("<h3>" + name + "'s record inserted in database successfully</h3>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
