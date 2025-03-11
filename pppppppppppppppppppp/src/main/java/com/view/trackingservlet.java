package com.view;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class tracking
 */
@WebServlet("/trackingservlet")
public class trackingservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public trackingservlet() {
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

		HttpSession sess = request.getSession();
		BookService bookservice = new BookService();

		String action = request.getParameter("action");
		RequestDispatcher rd = null;

		if (action.equalsIgnoreCase("history")) {
			User u = (User) sess.getAttribute("user");
			String id = null;
			if (u.getRole().equalsIgnoreCase("customer")) {
				id = u.getUserId();
			} else {
				id = request.getParameter("UserId");
			}

			ArrayList<Booking> bookings = bookservice.bookingHistory(id);
//			
//			for(Booking b:bookings)
//			{
//				b.setName(u.getName());
//				b.setAddress(u.getAddress());
//			}

			System.out.println("i am in histry");
			System.out.println(bookings.size());

			if (bookings.size() == 0) {
				request.setAttribute("error", "failure");
				request.setAttribute("bookings", null);
				rd = request.getRequestDispatcher("historydata.jsp");
			} else {
				request.setAttribute("bookings", bookings);
				rd = request.getRequestDispatcher("historydata.jsp");

			}

			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

//		trackingservlet

//		searchparcel

		HttpSession sess = request.getSession();
		BookService bookservice = new BookService();

		String action = request.getParameter("action");
		RequestDispatcher rd = null;

		if (action.equalsIgnoreCase("searchparcel")) {

			String bookingId = request.getParameter("bookingId");

			Booking b = null;

			b = bookservice.trackingStatus(bookingId);

			if (b != null) {
				System.out.println(" book found ");
				request.setAttribute("booked", b);
				rd = request.getRequestDispatcher("invoice.jsp");
			} else {
				System.out.println(" book not found ");
				request.setAttribute("error", "book not found");
				rd = request.getRequestDispatcher("invoice.jsp");
			}

		}

		if (action.equalsIgnoreCase("tracking")) {

			String bookingId = request.getParameter("bookingId");
			
			HttpSession sess1 = request.getSession();
			User u = (User) sess1.getAttribute("user");
			Booking b = null;

			
			if(u.getRole().equalsIgnoreCase("customer")) {
				b = bookservice.trackingStatus(bookingId,u.getUserId());
			}
			else {
				b = bookservice.trackingStatus(bookingId);
			}
			
		

			
			

			if (b != null) {
				System.out.println(" book found for tracking");
				request.setAttribute("booked", b);
				rd = request.getRequestDispatcher("trackeddata.jsp");
			} else {
				System.out.println(" book not found tracking");
				request.setAttribute("error", "book not found");
				sess.setAttribute("booked", null);
				rd = request.getRequestDispatcher("custtracking.jsp");
			}

		}

		if (action.equalsIgnoreCase("invoice")) {

			String bookingId = request.getParameter("bookingId");

			HttpSession sess1 = request.getSession();
			User u = (User) sess1.getAttribute("user");
			Booking b = null;

			
			if(u.getRole().equalsIgnoreCase("customer")) {
				b = bookservice.trackingStatus(bookingId,u.getUserId());
			}
			else {
				b = bookservice.trackingStatus(bookingId);
			}

			if (b != null) {
				System.out.println(" book found for invoice ");
				HttpSession session = request.getSession();
				session.setAttribute("booked", b);
				rd = request.getRequestDispatcher("invoice.jsp");
			} else {
				System.out.println(" book not found  for invoice");
				sess.removeAttribute("booked");
				request.setAttribute("error", "failure");
				rd = request.getRequestDispatcher("invoice1.jsp");
			}

		}

		if (action.equalsIgnoreCase("history")) {

			String id = request.getParameter("UserId");

			ArrayList<Booking> bookings = bookservice.bookingHistory(id);

			for (Booking b : bookings)
				System.out.print(b.getAddress());

			System.out.println("i am in histry admin" + bookings.size());
			System.out.println(bookings.size());

			if (bookings.size() == 0)
				request.setAttribute("error", "failure");

			request.setAttribute("bookings", bookings);
			rd = request.getRequestDispatcher("historydata.jsp");

			rd.forward(request, response);
		}

		rd.forward(request, response);

	}

}
