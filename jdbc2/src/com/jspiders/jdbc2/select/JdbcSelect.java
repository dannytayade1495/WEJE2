package com.jspiders.jdbc2.select;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcSelect {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static Properties properties = 
			new Properties();
	private static FileReader fileReader;
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			fileReader = new FileReader("D:\\WEJE2\\"
					+ "jdbc2\\resources\\"
					+ "db_info.properties");
			
			properties.load(fileReader);
			
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/weje2"
							, properties);
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery
					("select * from student");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)
						+ " | " + resultSet.getString(2)
						+ " | "+ resultSet.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}