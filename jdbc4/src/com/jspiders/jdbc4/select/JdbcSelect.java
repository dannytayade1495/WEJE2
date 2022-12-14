package com.jspiders.jdbc4.select;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.jspiders.jdbc4.entity.Student;

public class JdbcSelect {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static Properties properties = 
			new Properties();
	private static FileReader fileReader;
	private static String filePath = 
			"D:\\WEJE2\\jdbc3\\resources"
			+ "\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			
			fileReader = new FileReader(filePath);
			
			properties.load(fileReader);
			
			Class.forName(properties
					.getProperty("driverPath"));
			
			connection = DriverManager.getConnection
					(properties.getProperty("dburl")
							, properties);
			
			query = "select * from student";
			
			preparedStatement = 
					connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Student student = new Student();
				
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				
				System.out.println(student);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
