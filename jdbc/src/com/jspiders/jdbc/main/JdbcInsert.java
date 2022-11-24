package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {
	
	public static void main(String[] args) {

		try {
			//Step 1: Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step 2: Open the connection
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://"
							+ "localhost:3306/weje2?"
							+ "user=root&password=root");
			
			//Step 3: Create/Prepare the statement
			Statement statement = 
					connection.createStatement();
			int result = statement.executeUpdate
					("insert into student "
					+ "values (2, 'Baburao',"
					+ "'babu90@theka.com')");
			
			//Step 4: Process the result
			System.out.println
			(result + " row(s) affected");
			
			//Step 5: Close the connections
			connection.close();
			statement.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

}