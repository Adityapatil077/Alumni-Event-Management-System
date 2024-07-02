package org.alumnievent.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.alumnievent.model.OragnizerModel;
import org.alumnievent.service.OragnizerService;
import org.alumnievent.service.OragnizerServiceImpl;

@WebServlet("/addneworagnizer")
public class AddNewOragnizerController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String Pass = request.getParameter("password");
		OragnizerModel oModel = new OragnizerModel();
		oModel.setOrganizerName(name);
		oModel.setOrganizerEmail(email);
		oModel.setOrganizerContact(contact);
		oModel.setOrganizerAddress(address);
		oModel.setOrganizerPassword(Pass);
		
		OragnizerService oService = new OragnizerServiceImpl();
		boolean b = oService.isRegisteredNewOragnizer(oModel);
		if(b)
		{
			RequestDispatcher r = request.getRequestDispatcher("OragnizerInfo.jsp");
			r.include(request, response);
			out.print("<h1>Oragnizer Added Sucessfully..</h1>");
		}else {
			RequestDispatcher r = request.getRequestDispatcher("OragnizerInfo.jsp");
			r.include(request, response);
			out.print("<h1>Oragnizer Added Sucessfully..</h1>");
		}
	}

}
