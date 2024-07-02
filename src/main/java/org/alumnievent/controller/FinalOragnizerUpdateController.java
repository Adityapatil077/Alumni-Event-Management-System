package org.alumnievent.controller;

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


@WebServlet("/finaloragnizer")
public class FinalOragnizerUpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		int Id = Integer.parseInt(request.getParameter("oId"));
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		OragnizerModel model = new OragnizerModel();
		model.setOrganizerEmail(email);
		model.setOrganizerId(Id);
		model.setOrganizerContact(contact);
		model.setOrganizerAddress(address);
		
		OragnizerService oService = new OragnizerServiceImpl();
		boolean b = oService.isUpdateOragnizerById(model);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
