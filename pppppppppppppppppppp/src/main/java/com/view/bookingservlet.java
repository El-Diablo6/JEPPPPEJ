package com.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.BookService;
import com.model.Booking;
import com.model.User;

/**
 * Servlet implementation class bookingservlet
 */
@WebServlet("/bookingservlet")
public class bookingservlet extends HttpServlet {
	RequestDispatcher rd = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	BookService bookservice = new BookService();

	public bookingservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		HttpSession sess = request.getSession();

		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("booking")) {
			String name = request.getParameter("senderName");
			String address = request.getParameter("senderAddress");
			String mobile = request.getParameter("senderContact");
			String recipientName = request.getParameter("receiverName");
			String recipienAddress = request.getParameter("receiverAddress");
			String recipientPin = request.getParameter("receiverPincode");
			String recipientMobile = request.getParameter("receiverContact");
			String parcelWeight = request.getParameter("parcelWeight");
			String parcelContentsDescription = request.getParameter("parcelContents");
			String parcelPackingPreference = request.getParameter("preference");
			String parcelDeliveryType = request.getParameter("deliverySpeed");
			String parcelPickupTime = request.getParameter("pickupTime");
			String parcelDropoffTime = request.getParameter("dropTime");
			String serviceCost = request.getParameter("parcelCost");

			parcelPickupTime=parcelPickupTime.substring(0, 16);
			parcelDropoffTime=parcelDropoffTime.substring(0, 16);
			parcelPickupTime=parcelPickupTime.replace('T',' ');
			parcelDropoffTime=parcelDropoffTime.replace('T',' ');
			
			User u = (User) sess.getAttribute("user");
			
			String userid = u.getUserId();

			System.out.println(userid);

			Booking b = new Booking(recipientName, recipienAddress, recipientPin, recipientMobile, parcelWeight,
					parcelContentsDescription, parcelDeliveryType, parcelPackingPreference, parcelPickupTime,
					parcelDropoffTime, serviceCost, name, address, mobile);

			String bid = bookservice.book(b, userid);

			if (bid != null) {
				Booking booking = bookservice.generateInvoice(bid);

				System.out.println(bid);
				System.out.println("parcel booked ");
				if (booking == null)
					System.out.println("fail");
				else {
					System.out.println("pass");
				}

				sess.setAttribute("booked", booking);
				rd = request.getRequestDispatcher("paymentpage.jsp");
			} else {
				System.out.println("not booked");
				request.setAttribute("error", "failed");
				rd = request.getRequestDispatcher("booking(modified).jsp");
			}

			rd.forward(request, response);

		}
		
		
		
		
		if (action.equalsIgnoreCase("adminbooking")) {
			String userid = request.getParameter("userid");
			String address = request.getParameter("senderAddress");
			String mobile = request.getParameter("senderContact");
			String recipientName = request.getParameter("receiverName");
			String recipienAddress = request.getParameter("receiverAddress");
			String recipientPin = request.getParameter("receiverPincode");
			String recipientMobile = request.getParameter("receiverContact");
			String parcelWeight = request.getParameter("parcelWeight");
			String parcelContentsDescription = request.getParameter("parcelContents");
			String parcelPackingPreference = request.getParameter("preference");
			String parcelDeliveryType = request.getParameter("deliverySpeed");
			String parcelPickupTime = request.getParameter("pickupTime");
			String parcelDropoffTime = request.getParameter("dropTime");
			String serviceCost = request.getParameter("parcelCost");

			parcelPickupTime=parcelPickupTime.substring(0, 16);
			parcelDropoffTime=parcelDropoffTime.substring(0, 16);
			parcelPickupTime=parcelPickupTime.replace('T',' ');
			parcelDropoffTime=parcelDropoffTime.replace('T',' ');
			
			User u = (User) sess.getAttribute("user");
			
		

			System.out.println(userid);

			Booking b = new Booking(recipientName, recipienAddress, recipientPin, recipientMobile, parcelWeight,
					parcelContentsDescription, parcelDeliveryType, parcelPackingPreference, parcelPickupTime,
					parcelDropoffTime, serviceCost, userid, address, mobile);
			
			boolean flag=bookservice.checkuser(userid);
			
			String bid=null;
			if(flag)
			{
				 bid = bookservice.book(b, userid);
			}
			else {
				request.setAttribute("error", "user not found");
				rd = request.getRequestDispatcher("bookingadmin.jsp");
			}
			
			
			
			

			if (bid != null) {
				Booking booking = bookservice.generateInvoice(bid);

				System.out.println(bid);
				System.out.println("parcel booked ");
				if (booking == null)
					System.out.println("fail");
				else {
					System.out.println("pass");
				}

				sess.setAttribute("booked", booking);
				rd = request.getRequestDispatcher("paymentpage.jsp");
			} else {
				System.out.println("not booked");
				request.setAttribute("error", "failed");
				rd = request.getRequestDispatcher("bookingadmin.jsp");
			}

			rd.forward(request, response);

		}

		
		
		
		
		

		if (action.equalsIgnoreCase("pay")) {

			rd = request.getRequestDispatcher("invoice.jsp");

			rd.forward(request, response);
		}

		if (action.equalsIgnoreCase("cancel")) {

			request.setAttribute("error", " payment failed");
			rd = request.getRequestDispatcher("booking(modified).jsp");

			rd.forward(request, response);
		}

		if (action.equalsIgnoreCase("generateinvoice")) {
			RequestDispatcher rd = null;
			String bookingid = request.getParameter("bookingId");
			Booking booking = bookservice.generateInvoice(bookingid);
			if (booking == null) {
				request.setAttribute("error", "failure");
				rd = request.getRequestDispatcher("generateinvoice.jsp");
				System.out.println("booking not found");
			} else {
				request.setAttribute("booked", booking);
				rd = request.getRequestDispatcher("invoice.jsp");
				System.out.println("booking  found");
			}
			rd.forward(request, response);

		}

	}

}
