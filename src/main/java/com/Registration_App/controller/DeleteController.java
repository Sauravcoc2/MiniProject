package com.Registration_App.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Registration_App.model.DAOService;
import com.Registration_App.model.DAOServicesImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		DAOService service = new DAOServicesImpl();
		service.connectDB();
		service.deleteByEmailId(email);
		
		ResultSet result = service.getAllReg();
		
		request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/list_registrations.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
