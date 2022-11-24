package com.jspiders.jdbc3.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcInsert {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
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

			Class.forName(properties.
					getProperty("driverPath"));

			connection = DriverManager.getConnection
					(properties.getProperty("dburl")
							, properties);

			query = "insert into student values (?,?,?)";

			preparedStatement = 
					connection.prepareStatement(query);

			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, "Babita");
			preparedStatement.
			setString(3, "babita@iyer.com");

			result = preparedStatement.executeUpdate();

			System.out.println(result 
					+ " row(s) affected.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
