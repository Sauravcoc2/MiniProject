package com.Registration_App.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service = new DAOServicesImpl();
		service.connectDB();
		service.saveRegistration(name, city, email, mobile);
	}
}
