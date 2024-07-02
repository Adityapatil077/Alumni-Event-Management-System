package org.alumnievent.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.alumnievent.model.CollegeModel;
import org.alumnievent.service.CollegeService;
import org.alumnievent.service.CollegeServiceImpl;

@WebServlet("/adminregistration")
public class AdminRegistrationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = (request.getParameter("contact"));
		String address = request.getParameter("address");
		String pass = request.getParameter("pass");
		CollegeModel cModel = new CollegeModel();
		cModel.setCollegeName(name);
		cModel.setCollegeEmail(email);
		cModel.setCollegeContact(contact);
		cModel.setCollegeAddress(address);
		cModel.setCollegePassword(pass);
		CollegeService cService = new CollegeServiceImpl();
		boolean b = cService.isRegistredNewCollege(cModel);
		if(b)
		{
			RequestDispatcher r = request.getRequestDispatcher("AdminLogin.jsp");
			r.include(request, response);
			out.print("<h1>Employee Added Sucessfully..</h1>");
		}else {
			RequestDispatcher r = request.getRequestDispatcher("AdminLogin.jsp");
			r.include(request, response);
			out.print("<h1>Employee Not Added Sucessfully..</h1>");
		}
	}

}
