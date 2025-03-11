package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Helper {
	
	static Connection connect;
	static PreparedStatement preparedStatement;
	

	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		System.out.println("i am in helper");
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); 
		Helper.connect=DriverManager.getConnection("jdbc:derby:D:\\Users\\2826130\\MyDB5;create=true");
		System.out.println("Connection established");
		Helper.preparedStatement=connect.prepareStatement(sql);
		
		return preparedStatement;
		

	}
	
	public static void closeconnection() throws SQLException {
		Helper.preparedStatement.close();
		
		Helper.connect.close();
		System.out.println("Connection established");
		
	}

}
