package org.alumnievent.login;

import java.io.IOException;
import java.io.PrintWriter;

import org.alumnievent.model.OragnizerModel;
import org.alumnievent.service.OragnizerService;
import org.alumnievent.service.OragnizerServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateoragnizer")
public class UpdateOragnizeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    int oId = Integer.parseInt(request.getParameter("OrganizerId"));
	    RequestDispatcher r = request.getRequestDispatcher("AdminMain.jsp");
	    r.include(request, response);
	    OragnizerService oService = new OragnizerServiceImpl();
	    OragnizerModel model = oService.getOrganizerProfile(oId);
	    out.println("<div class='container py-3 mt-3 d-flex justify-content-center'>");
	    out.println("<div class='border border-3 p-4 shadow-lg' style='min-width:50vw; background-color:#F2F2F2;'>");
	    out.println("<form class='formarea' name='frm' action='finaloragnizer' method='POST'>");
	    out.println("<h3 class='text-center fw-bold text-warning'>Update Organizer</h3>");

	    out.println("<input type='hidden' name='oId' value='" + oId + "'>");

	    out.println("<div class='mb-3'>");
	    out.println("<label for='email' class='form-label'>Email</label>");
	    out.println("<input type='email' class='form-control' value='"+model.getOrganizerEmail()+"' id='email' name='email'>");
	    out.println("</div>");

	    out.println("<div class='mb-3'>");
	    out.println("<label for='contact' class='form-label'>Contact</label>");
	    out.println("<input type='text' class='form-control' id='contact' value='"+model.getOrganizerContact()+"' name='contact'>");
	    out.println("</div>");

	    out.println("<div class='mb-3'>");
	    out.println("<label for='address' class='form-label'>Address</label>");
	    out.println("<input type='text' class='form-control' id='address' value='"+model.getOrganizerAddress()+"' name='address' >");
	    out.println("</div>");

	    out.println("<div class='text-center'>");
	    out.println("<input type='submit' name='s' value='Update' class='btn btn-outline-primary'>");
	    out.println("</div>");

	    out.println("</form>");
	    out.println("</div>");
	    out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
