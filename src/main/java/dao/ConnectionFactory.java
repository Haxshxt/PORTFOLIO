package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static Connection conn;
	@SuppressWarnings("finally")
	public static Connection getConnection() {
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306";
			String userName="root";
			String password="Harshit@08";
			
			 conn =DriverManager.getConnection(url, userName, password);
	//		System.out.println("Connection Establish " + conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
        finally {
			return conn;
		}
	}
	
	/*
	public static void main(String[] args) {
		Connection  connection = ConnectionFactory.getConnection();
		
		System.out.println(connection);
	}
	*/
}
