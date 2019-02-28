package org.capgemini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "system";
	private static final String password = "kvidhani";
	
	public static Connection getConnection() {  
			
		Connection connection = null;
		
		try {				
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			connection = DriverManager.getConnection(DB_URL,username,password);  		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}