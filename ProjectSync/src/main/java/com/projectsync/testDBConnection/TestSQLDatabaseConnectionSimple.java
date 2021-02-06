package com.projectsync.testDBConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSQLDatabaseConnectionSimple {

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
-- create db: test
-- create user with username and password: springstudent  

USE [test]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Persons](
	[ID] [int] NOT NULL,
	[LastName] [varchar](255) NOT NULL,
	[FirstName] [varchar](255) NULL,
	[Age] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

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