package com.projectsync.testDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// https://docs.microsoft.com/en-us/sql/connect/jdbc/retrieving-result-set-data-sample?view=sql-server-ver15
public class TestSQLDatabaseConnection {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=test;user=springstudent;password=springstudent";

		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
			createTable(stmt);
			String SQL = "SELECT * FROM Products;";
			ResultSet resultSet = stmt.executeQuery(SQL);
			displayRow(resultSet);
		} catch (SQLException e) {
			System.out.println("Exception occurred while testing SQL Server connection: " + e.getMessage());
		}
	}

	private static void displayRow(ResultSet resultSet) throws SQLException {
		System.out.println("DB Results:");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("ProductNumber") + " : " + resultSet.getString("Name"));
		}
	}

	private static void createTable(Statement stmt) throws SQLException {
		stmt.execute("if exists (select * from sys.objects where name = 'Products')" + "drop table Products");

		String sql = "CREATE TABLE [Products](" + "[ProductID] [int] IDENTITY(1,1) NOT NULL,"
				+ "[Name] [varchar](30) NOT NULL," + "[ProductNumber] [nvarchar](25) NOT NULL,"
				+ "[MakeFlag] [bit] NOT NULL," + "[FinishedGoodsFlag] [bit] NOT NULL," + "[Color] [nvarchar](15) NULL,"
				+ "[SafetyStockLevel] [smallint] NOT NULL," + "[ReorderPoint] [smallint] NOT NULL,"
				+ "[StandardCost] [money] NOT NULL," + "[ListPrice] [money] NOT NULL," + "[Size] [nvarchar](5) NULL,"
				+ "[SizeUnitMeasureCode] [nchar](3) NULL," + "[WeightUnitMeasureCode] [nchar](3) NULL,"
				+ "[Weight] [decimal](8, 2) NULL," + "[DaysToManufacture] [int] NOT NULL,"
				+ "[ProductLine] [nchar](2) NULL," + "[Class] [nchar](2) NULL," + "[Style] [nchar](2) NULL,"
				+ "[ProductSubcategoryID] [int] NULL," + "[ProductModelID] [int] NULL,"
				+ "[SellStartDate] [datetime] NOT NULL," + "[SellEndDate] [datetime] NULL,"
				+ "[DiscontinuedDate] [datetime] NULL," + "[rowguid] [uniqueidentifier] ROWGUIDCOL  NOT NULL,"
				+ "[ModifiedDate] [datetime] NOT NULL,)";

		stmt.execute(sql);

		sql = "INSERT Products VALUES ('Adjustable Time','AR-5381','0','0',NULL,'1000','750','0.00','0.00',NULL,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'2008-04-30 00:00:00.000',NULL,NULL,'694215B7-08F7-4C0D-ACB1-D734BA44C0C8','2014-02-08 10:01:36.827') ";
		stmt.execute(sql);

		sql = "INSERT Products VALUES ('ML Bottom Bracket','BB-8107','0','0',NULL,'1000','750','0.00','0.00',NULL,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'2008-04-30 00:00:00.000',NULL,NULL,'694215B7-08F7-4C0D-ACB1-D734BA44C0C8','2014-02-08 10:01:36.827') ";
		stmt.execute(sql);

		sql = "INSERT Products VALUES ('Mountain-500 Black, 44','BK-M18B-44','0','0',NULL,'1000','750','0.00','0.00',NULL,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,'2008-04-30 00:00:00.000',NULL,NULL,'694215B7-08F7-4C0D-ACB1-D734BA44C0C8','2014-02-08 10:01:36.827') ";
		stmt.execute(sql);
	}

}