package com.Registration_App.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Registration_App.model.DAOService;
import com.Registration_App.model.DAOServicesImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService service = new DAOServicesImpl();
		service.connectDB();
		boolean status = service.verifyCredentials(email, password);
		
		if(status == true) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/newRegistration.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Invalid Username/ Password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}
