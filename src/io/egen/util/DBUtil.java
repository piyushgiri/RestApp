package io.egen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/emp_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	static {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("MySQL JDBC Driver loaded");
	}catch (ClassNotFoundException e){
		System.out.println("Error loading JDBC Driver");
		e.printStackTrace();
	}
	}
	
	public static Connection connect(){
		Connection con=null;
		
		try {
			con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error getting connection");
			e.printStackTrace();
		}
		return con;
	}
}
