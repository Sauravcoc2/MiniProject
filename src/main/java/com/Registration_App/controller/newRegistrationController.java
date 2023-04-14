package com.Registration_App.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Registration_App.model.DAOService;
import com.Registration_App.model.DAOServicesImpl;

@WebServlet("/saveReg")
public class newRegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public newRegistrationController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session  = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) 
			{
				String name = request.getParameter("name");
				String city = request.getParameter("city");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
			
				DAOService service = new DAOServicesImpl();
				service.connectDB();
				service.saveRegistration(name, city, email, mobile);
			
				request.setAttribute("msg", "Record is saved!!");
			
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
				rd.forward(request, response);
				
			} 
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
	}
}
