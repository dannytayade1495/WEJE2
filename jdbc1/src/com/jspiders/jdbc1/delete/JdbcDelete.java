package com.jspiders.jdbc1.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDelete {

	private static Connection connection;
	private static Statement statement;
	private static int result;

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/weje2?"
							+ "user=root&password=root");

			statement = connection.createStatement();

			result = statement.executeUpdate
					("delete from student where id = 1");

			System.out
				.println(result + " row(s) affected");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
