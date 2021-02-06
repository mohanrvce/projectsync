package com.projectsync.testDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String user = "springstudent";
		String pass = "springstudent";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!!!");
			System.out.println("Connection Name: " + myConn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}