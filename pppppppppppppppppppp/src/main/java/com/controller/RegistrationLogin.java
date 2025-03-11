package com.controller; 

import com.dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.model.User;

public class RegistrationLogin {
	ArrayList<User> customers = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	DbOperations db=new DbOperations();
	
	private String adminUserId="admin";
	private String adminPassword="admin";
	
	
	
	
	public User registraion(String name,String email,String mob,String address,String userId, String pwd) {
		
		User user= new User(name, email, mob, address, userId, pwd, "customer");
		System.out.println("i am in controller");
		
		try {
			 
			User x=db.registration(user);
			return x;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public User login(String id, String pwd)  {

		//user login
		User u=null;
		try {
			u = db.login(id, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(u==null) {
			System.out.println("Invalid userId or password");
			return null;
		}	
			
		else 
			return u;
		
	}
		
}
