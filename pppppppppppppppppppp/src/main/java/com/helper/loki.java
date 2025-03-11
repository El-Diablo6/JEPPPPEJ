package com.helper;

import java.sql.SQLException;

public class loki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Helper.getPreparedStatement("select * from student");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
