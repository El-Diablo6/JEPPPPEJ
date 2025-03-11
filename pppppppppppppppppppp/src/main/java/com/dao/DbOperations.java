package com.dao;

import com.model.Booking;

import com.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.helper.*;

public class DbOperations {

	public User registration(User u) throws ClassNotFoundException, SQLException {
		System.out.println("i am in dao");
		String sql = "insert into tbl_UserProfile values(?,?,?,?,?,?,?)";
		PreparedStatement stmt = Helper.getPreparedStatement(sql);
		stmt.setString(1, u.getUserId());
		stmt.setString(2, u.getName());
		stmt.setString(3, u.getAddress());
		stmt.setString(4, u.getEmail());
		stmt.setString(5, u.getMobile());
		stmt.setString(6, u.getPassword());
		stmt.setString(7, u.getRole());
		int n = stmt.executeUpdate();
		Helper.closeconnection();
		System.out.println("i am in dao");

		if (n > 0) {
			System.out.println("user returned");
			return u;

		}
		return null;

	}
	
	public boolean checkuser(String id) throws ClassNotFoundException, SQLException
	{
		String sql="select * from tbl_UserProfile where User_ID=?";
		
		PreparedStatement stmt = Helper.getPreparedStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
			return true;
		
		return false;
		
	}
	
	public boolean checkEmailPhn(String email, String phn) throws ClassNotFoundException, SQLException
	{
		String sql="select * from tbl_UserProfile where Email=? Or MobileNumber=?";
		
		PreparedStatement stmt = Helper.getPreparedStatement(sql);
		stmt.setString(1,email);
		stmt.setString(2,phn);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
			return true;
		
		return false;
		
	}
	

	public User login(String userId, String password) throws ClassNotFoundException, SQLException {
		String sql = "select * from tbl_UserProfile where User_ID=? and Password=?";

		PreparedStatement stmt = Helper.getPreparedStatement(sql);
		stmt.setString(1, userId);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();

		if (rs == null) {
			System.out.println("no rows");
			rs.close();
			Helper.closeconnection();
			return null;
		} else {
			System.out.println("found rows");
			rs.next();
			User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7));
			rs.close();
			Helper.closeconnection();
			return u;
		}

	}

	public boolean book(Booking b) throws ClassNotFoundException, SQLException {
		String sql = "insert into tbl_Booking values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = Helper.getPreparedStatement(sql);
		stmt.setString(1, b.getBookingID());
		stmt.setString(2, b.getUserId());
		stmt.setString(3, b.getRecipientName());
		stmt.setString(4, b.getRecipienAddress());
		stmt.setString(5, b.getRecipientPin());
		stmt.setString(6, b.getRecipientMobile());
		stmt.setString(7, b.getParcelWeight());
		stmt.setString(8, b.getParcelContentsDescription());
		stmt.setString(9, b.getParcelDeliveryType());
		stmt.setString(10, b.getParcelPackingPreference());
		stmt.setString(11, b.getParcelPickupTime());
		stmt.setString(12, b.getParcelDropoffTime());
		stmt.setString(13, b.getServiceCost());
		stmt.setString(14, b.getPaymentTime());
		stmt.setString(15, b.getParcelStatus());

		int n = stmt.executeUpdate();
		Helper.closeconnection();

		if (n > 0)
			return true;
		else
			return false;
	}

	public Booking getBookingById(String id) throws ClassNotFoundException, SQLException {

		String sql = "select * from tbl_Booking where Booking_ID=?";
		PreparedStatement stmt1 = Helper.getPreparedStatement(sql);
		stmt1.setString(1, id);
		
		ResultSet rs1 = stmt1.executeQuery();

		if (rs1.next()) {

			String Rec_Name = rs1.getString("Rec_Name");
			String Rec_Address = rs1.getString("Rec_Address");
			String Rec_Pin = rs1.getString("Rec_Pin");
			String Rec_Mobile = rs1.getString("Rec_Mobile");
			String Par_Weight_Gram = rs1.getString("Par_Weight_Gram");
			String Par_Contents_Description = rs1.getString("Par_Contents_Description");
			String Par_Delivery_Type = rs1.getString("Par_Delivery_Type");
			String Par_Packing_Preference = rs1.getString("Par_Packing_Preference");
			String Par_PickupTime = rs1.getString("Par_PickupTime");
			String Par_DropoffTime = rs1.getString("Par_DropoffTime");
			String Par_Status = rs1.getString("Par_Status");
			String Par_ServiceCost = rs1.getString("Par_ServiceCost");
			String Par_PaymentTime = rs1.getString("Par_PaymentTime");
			String Booking_ID = rs1.getString("Booking_ID");

			String userid = rs1.getString(2);
			String sql2 = "select * from tbl_UserProfile where User_ID=?";

			rs1.close();
			Helper.closeconnection();

			PreparedStatement stmt2 = Helper.getPreparedStatement(sql2);
			stmt2.setString(1, userid);
			ResultSet rs2 = stmt2.executeQuery();

			rs2.next();

			Booking b = new Booking(Rec_Name, Rec_Address, Rec_Pin, Rec_Mobile, Par_Weight_Gram,
					Par_Contents_Description, Par_Delivery_Type, Par_Packing_Preference, Par_PickupTime,
					Par_DropoffTime, Par_Status, Par_ServiceCost, Par_PaymentTime, Booking_ID,
					rs2.getString("FullName"), rs2.getString("Rec_Address"), rs2.getString("User_ID"),
					rs2.getString("MobileNumber"), rs2.getString("Role"));

			rs2.close();
			Helper.closeconnection();

			return b;
		}

		return null;
	}
	
	
	
	public Booking getBookingById(String id,String uid) throws ClassNotFoundException, SQLException {

		String sql = "select * from tbl_Booking where Booking_ID=? AND User_ID=?";
		PreparedStatement stmt1 = Helper.getPreparedStatement(sql);
		stmt1.setString(1, id);
		stmt1.setString(2, uid);
		
		ResultSet rs1 = stmt1.executeQuery();

		if (rs1.next()) {

			String Rec_Name = rs1.getString("Rec_Name");
			String Rec_Address = rs1.getString("Rec_Address");
			String Rec_Pin = rs1.getString("Rec_Pin");
			String Rec_Mobile = rs1.getString("Rec_Mobile");
			String Par_Weight_Gram = rs1.getString("Par_Weight_Gram");
			String Par_Contents_Description = rs1.getString("Par_Contents_Description");
			String Par_Delivery_Type = rs1.getString("Par_Delivery_Type");
			String Par_Packing_Preference = rs1.getString("Par_Packing_Preference");
			String Par_PickupTime = rs1.getString("Par_PickupTime");
			String Par_DropoffTime = rs1.getString("Par_DropoffTime");
			String Par_Status = rs1.getString("Par_Status");
			String Par_ServiceCost = rs1.getString("Par_ServiceCost");
			String Par_PaymentTime = rs1.getString("Par_PaymentTime");
			String Booking_ID = rs1.getString("Booking_ID");

			String userid = rs1.getString(2);
			String sql2 = "select * from tbl_UserProfile where User_ID=?";

			rs1.close();
			Helper.closeconnection();

			PreparedStatement stmt2 = Helper.getPreparedStatement(sql2);
			stmt2.setString(1, userid);
			ResultSet rs2 = stmt2.executeQuery();

			rs2.next();

			Booking b = new Booking(Rec_Name, Rec_Address, Rec_Pin, Rec_Mobile, Par_Weight_Gram,
					Par_Contents_Description, Par_Delivery_Type, Par_Packing_Preference, Par_PickupTime,
					Par_DropoffTime, Par_Status, Par_ServiceCost, Par_PaymentTime, Booking_ID,
					rs2.getString("FullName"), rs2.getString("Rec_Address"), rs2.getString("User_ID"),
					rs2.getString("MobileNumber"), rs2.getString("Role"));

			rs2.close();
			Helper.closeconnection();

			return b;
		}

		return null;
	}
	
	
	
	
	
	
	

	public ArrayList<Booking> getBookingHistory(String id) throws ClassNotFoundException, SQLException {

		ArrayList<Booking> bookings = new ArrayList<>();

		String sql2 = "select * from tbl_UserProfile where User_ID=?";
		PreparedStatement stmt2 = Helper.getPreparedStatement(sql2);
		stmt2.setString(1, id);
		ResultSet rs2 = stmt2.executeQuery();

		if (rs2.next()) {
			String fullname = rs2.getString("FullName");
			String rec_adr = rs2.getString("Rec_Address");
			String mobilenum = rs2.getString("MobileNumber");
			String role = rs2.getString("Role");

			rs2.close();

			String sql = "select * from tbl_Booking where User_ID=?";
			PreparedStatement stmt1 = Helper.getPreparedStatement(sql);
			stmt1.setString(1, id);
			ResultSet rs1 = stmt1.executeQuery();

			while (rs1.next()) {

				String Rec_Name = rs1.getString("Rec_Name");
				String Rec_Address = rs1.getString("Rec_Address");
				String Rec_Pin = rs1.getString("Rec_Pin");
				String Rec_Mobile = rs1.getString("Rec_Mobile");
				String Par_Weight_Gram = rs1.getString("Par_Weight_Gram");
				String Par_Contents_Description = rs1.getString("Par_Contents_Description");
				String Par_Delivery_Type = rs1.getString("Par_Delivery_Type");
				String Par_Packing_Preference = rs1.getString("Par_Packing_Preference");
				String Par_PickupTime = rs1.getString("Par_PickupTime");
				String Par_DropoffTime = rs1.getString("Par_DropoffTime");
				String Par_Status = rs1.getString("Par_Status");
				String Par_ServiceCost = rs1.getString("Par_ServiceCost");
				String Par_PaymentTime = rs1.getString("Par_PaymentTime");
				String Booking_ID = rs1.getString("Booking_ID");

				Booking b = new Booking(Rec_Name, Rec_Address, Rec_Pin, Rec_Mobile, Par_Weight_Gram,
						Par_Contents_Description, Par_Delivery_Type, Par_Packing_Preference, Par_PickupTime,
						Par_DropoffTime, Par_Status, Par_ServiceCost, Par_PaymentTime, Booking_ID, fullname, rec_adr,
						id, mobilenum, role);

				bookings.add(b);

			}
			rs1.close();
		}

		Helper.closeconnection();

		return bookings;

	}

	public boolean updateStatus(String id, String s) throws ClassNotFoundException, SQLException {

		String sql = "update tbl_Booking set Par_Status=?  where  Booking_ID=?";
		PreparedStatement stmt = Helper.getPreparedStatement(sql);
		stmt.setString(1, s);
		stmt.setString(2, id);
		int n = stmt.executeUpdate();
		Helper.closeconnection();
		if (n > 0) {
			System.out.println("========== Delivary Status is sucessfully updated  ==========");
			return true;

		} else {
			System.out.println("========== Delivary Status is not sucessfully updated  ==========");
			return false;
		}

	}

	public boolean updateTime(String p, String d, String id) throws ClassNotFoundException, SQLException {
		String sql = "update tbl_Booking set Par_PickupTime=?,Par_DropoffTime=?  where  Booking_ID=?";
		PreparedStatement stmt = Helper.getPreparedStatement(sql);
		stmt.setString(1, p);
		stmt.setString(2, d);
		stmt.setString(3, id);
		
		System.out.println(p+"  "+d+"  "+id);
		
		
		
		
		int n = stmt.executeUpdate();
		Helper.closeconnection();
		System.out.print(n);
		if (n > 0) {
			System.out.println("========== Time Status is sucessfully updated  ==========");
			return true;
		} else {
			System.out.println("========== Time Status is not sucessfully updated  ==========");
			return false;
		}
	}

}
