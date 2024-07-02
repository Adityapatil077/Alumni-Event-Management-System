package org.alumnievent.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.alumnievent.service.CollegeService;
import org.alumnievent.service.CollegeServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		CollegeService collService = new CollegeServiceImpl();
		int result = collService.verifyCollege(email, pass);
		
		if (result != 0) {
			if (result <= 100) {
				HttpSession session = request.getSession(true);
				session.setAttribute("organizerId", result);
				session.setAttribute("email", email);
				RequestDispatcher r = request.getRequestDispatcher("ViewOrganizerProfile.jsp");
				r.include(request, response);
			} else if (result <= 1000) {
				HttpSession session = request.getSession(true);
				session.setAttribute("AdminId", result);
				session.setAttribute("email", email);
				RequestDispatcher r = request.getRequestDispatcher("AdminProfile.jsp");
				r.include(request, response);
			} else if(result>1000) {
				HttpSession session = request.getSession(true);
				session.setAttribute("AlumniId", result);
				session.setAttribute("email", email);
				RequestDispatcher r = request.getRequestDispatcher("ViewAlumniProfile.jsp");
				r.include(request, response);
			}
		}else {
			HttpSession session = request.getSession(true);
			session.setAttribute("result", result);
			RequestDispatcher r = request.getRequestDispatcher("AdminLogin.jsp");
			r.include(request, response);
		}
	}

}
