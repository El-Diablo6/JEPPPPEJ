package com.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import com.controller.BookService;
import com.controller.RegistrationLogin;
import com.dao.DbOperations;
import com.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Random random = new Random();

	private String Elwinfunc(String name) {
		int ranint = random.nextInt(10000);
		String[] names = name.split(" ");
		return names[random.nextInt(names.length)].toLowerCase() + String.format("%04d", ranint);
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

		// doGet(request, response);

		RequestDispatcher rd = null;
		HttpSession sess = request.getSession();
		RegistrationLogin rl = new RegistrationLogin();
		BookService bookService=new BookService();
		String action = request.getParameter("action");
		
		if (action.equals("login")) {
			String id = request.getParameter("username");
			String pwd = request.getParameter("password");
			
			System.out.println("Admin login sucess1111");
			if (id.equalsIgnoreCase("admin") && pwd.equals("admin")) {

				System.out.println("Admin login sucess");
				User user_obj = new User();
				user_obj.setRole("admin");
				user_obj.setName("Admin");
                user_obj.setUserId("admin9504");
				sess.setAttribute("user", user_obj);
				rd = request.getRequestDispatcher("adminhomepage.jsp");
				rd.forward(request, response);
			} else {
				User currentUser;

				currentUser = rl.login(id, pwd);
				if (currentUser != null) {
					sess.setAttribute("user", currentUser);
					rd = request.getRequestDispatcher("customerhomepage.jsp");
					System.out.println("customer login sucess");
					
				}
				else {
					request.setAttribute("error", "login failure");
					rd = request.getRequestDispatcher("login.jsp");
					System.out.println("customer login failed");
					
				}
				rd.forward(request, response);

		}
		}
		if (action.equals("Registration")) {
			String name = request.getParameter("customerName");
			String email = request.getParameter("email");
			String Mobno = request.getParameter("mobileNumber");
			String Addr = request.getParameter("address");
			String userId = Elwinfunc(name);
			// need ot change controller
			// String userId= funcRandGen();
			String pwd = request.getParameter("password");

			System.out.println(name + email + Mobno + Addr + userId + pwd);
			System.out.println("before call");
			
			
			boolean flag =bookService.checkEmailPhn(email,Mobno);
			
			if(flag)
			{
				request.setAttribute("error", "Mail or phone alreday exist");
				rd = request.getRequestDispatcher("registration.jsp");
				
				rd.forward(request, response);
			}
				
			
			User user_obj = rl.registraion(userId, name, Addr, email, Mobno, pwd);
			System.out.println("after call ");

			if (user_obj != null) {
				sess.setAttribute("user", user_obj);
				rd = request.getRequestDispatcher("registrationsuccess.jsp");
				rd.forward(request, response);

			} else {
				rd = request.getRequestDispatcher("registration.jsp");
				request.setAttribute("error", "Registeration is not sucessfull");
				rd.forward(request, response);
			}
		}

		

	}

}
