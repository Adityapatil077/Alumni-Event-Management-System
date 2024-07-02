package org.alumnievent.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.alumnievent.service.OragnizerService;
import org.alumnievent.service.OragnizerServiceImpl;

@WebServlet("/del")
public class DeleteOrg extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int oId = Integer.parseInt(request.getParameter("OrganizerId"));
		
		OragnizerService oService = new OragnizerServiceImpl();
		boolean b=oService.isDeleteOragnizerById(oId);
		if(b)
		{
			
			RequestDispatcher r =request.getRequestDispatcher("OragnizerInfo.jsp");
			r.forward(request, response);
			out.print("Deleted");
		}else {
			RequestDispatcher r =request.getRequestDispatcher("OragnizerInfo.jsp");
			r.forward(request, response);
			out.println("<h1>Some Problem is There</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
