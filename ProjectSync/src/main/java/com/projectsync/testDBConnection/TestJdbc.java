package com.projectsync.testDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		// String jdbcUrl = 
		// "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String jdbcUrl = "jdbc:mysql://localhost:3306";
		String user = "springstudent";
		String pass = "springstudent";
		// you could also try for user <root> with password <password>

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!!");
			System.out.println("Connection Name: " + connection);
		} catch (Exception e) {
			System.out.println("Exception occurred while testing JDBC connection: " + 
					e.getStackTrace());
		}
	}
}