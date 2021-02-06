package com.projectsync.testDBConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * 
 * @author www.codejava.net
 *
 */
public class TestSQLDatabaseConnection2 {

	public static void main(String[] args) {

		String dbURL = "jdbc:sqlserver://localhost:1433";
		String user = "springstudent";
		String pass = "springstudent";

		try (Connection conn = DriverManager.getConnection(dbURL, user, pass)) {
			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Driver version: " + dm.getDriverVersion());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			System.out.println("Product version: " + dm.getDatabaseProductVersion());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}


/*
package com.projectsync.testDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// https://docs.microsoft.com/en-us/sql/connect/jdbc/retrieving-result-set-data-sample?view=sql-server-ver15
// refer https://docs.microsoft.com/en-us/sql/connect/jdbc/step-3-proof-of-concept-connecting-to-sql-using-java?view=sql-server-ver15
public class TestSQLDatabaseConnection {
	// Connect to your database.
	// Replace server name, username, and password with your credentials
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=test;user=springstudent;password=springstudent";

		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
			String SQL = "SELECT * FROM Persons;";
			ResultSet rs = stmt.executeQuery(SQL);
			displayRow("PERSONS", rs);
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void displayRow(String title, ResultSet rs) throws SQLException {
		System.out.println(title);
		while (rs.next()) {
			System.out.println(rs.getString("FirstName") + " : " + rs.getString("LastName"));
		}
	}
}
 */