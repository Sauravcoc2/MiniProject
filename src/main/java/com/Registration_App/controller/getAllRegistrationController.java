package com.Registration_App.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Registration_App.model.DAOService;
import com.Registration_App.model.DAOServicesImpl;

@WebServlet("/listAll")
public class getAllRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getAllRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession(false);
		if(session.getAttribute("email")!=null) 
		{
		DAOService service = new DAOServicesImpl();
		service.connectDB();
		
		ResultSet result = service.getAllReg();
		
		request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_registrations.jsp");
		rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
