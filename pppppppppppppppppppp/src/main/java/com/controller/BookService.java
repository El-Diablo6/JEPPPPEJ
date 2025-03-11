package com.controller;
import com.dao.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.derby.iapi.types.StringDataValue;

import com.model.Booking;
import com.model.User;

public class BookService {

	Scanner sc = new Scanner(System.in);
	
	ArrayList<Booking> bookings=new ArrayList<Booking>();
	
	
	DbOperations db=new DbOperations();
	private Random random = new Random();
	
	public String book(Booking b,String userid) {
		
		String bid="null";
		
		
		LocalDateTime paymentTime = LocalDateTime.now();
		String s=paymentTime.toString();
		s=s.substring(0,16);
		s=s.replace("T", "  ");
		
		int ranint = random.nextInt(100000001);
		String bookingID = "BKG"+String.format("%09d",ranint);
		
		b.setUserId(userid);
		b.setPaymentTime(s);
		b.setBookingID(bookingID);
		b.setParcelStatus("Booked");
	
		boolean n=false;
		try {
			n = db.book(b);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(n) {
			System.out.println("Booking ID is: "+bookingID);
			System.out.println("Booking Sucessful");
			bid=b.getBookingID();
			
		}
		else {
			System.out.println("Booking not Sucessful");
		}
		return bid;
		
		
		
		
		
		
		
	}
	
	
	public boolean checkuser(String id)
	{
		
		try {
			return db.checkuser(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public boolean checkEmailPhn(String email, String phn)
	{
		
		try {
			return db.checkEmailPhn(email,phn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	public  Booking generateInvoice(String id) {
		
		Booking b=null;
		try {
			 b= db.getBookingById(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
		
	}
	
	public Booking trackingStatus(String bookingId)  {
	
		Booking b=null;
		
		 try {
			b=db.getBookingById(bookingId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return b;
		
		
		
		
	}
	
	
	
	public Booking bookById(String bookingId)  {
		
		Booking b=null;
		
		 try {
			b=db.getBookingById(bookingId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return b;
		
		
		
		
	}
	
	
	
public Booking trackingStatus(String bookingId,String uid)  {
		
		Booking b=null;
		
		 try {
			b=db.getBookingById(bookingId,uid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return b;
		
		
		
		
	}
	
	public boolean pickUpandDropUpdate(String newPickupTime,String newDropoffTime, String bookingId) {
	
		boolean flag=false;
		
		
		try {
			flag=  db.updateTime(newPickupTime, newDropoffTime, bookingId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
//	
	public boolean delivaryStatusUpdate(String id, String value)  {
		
		boolean falg=false;
		
		 try {
			falg=db.updateStatus(id,value);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 return falg;
		
		
	}
	
	
	public ArrayList<Booking> bookingHistory(String userId)  {
		
		//i am here
		
		System.out.println("========== Booking History ==========");
		ArrayList<Booking> bookings=null;
		try {
			bookings = db.getBookingHistory(userId);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookings;
		
            
        
	}
	

}
