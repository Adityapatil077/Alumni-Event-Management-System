package org.alumnievent.config;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/markAttendance")
public class MarkAttendanceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String alumniId = request.getParameter("alumniId");
	        String attendanceStatus = request.getParameter("attendanceStatus");

	        // Update database with attendance status for the selected alumni
	        // Code for updating database

	        // Send response back to the client
	        response.getWriter().write("Attendance marked successfully for alumni ID: " + alumniId);
	}

}
