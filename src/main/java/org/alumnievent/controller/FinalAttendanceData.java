package org.alumnievent.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.alumnievent.service.EventService;
import org.alumnievent.service.EventServiceImpl;

@WebServlet("/fattendance")
public class FinalAttendanceData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("search"));
		int Alumniid = Integer.parseInt(request.getParameter("alumniid"));
		int eventId = Integer.parseInt(request.getParameter("eventId"));
		int Id = Integer.parseInt(request.getParameter("cid"));

		EventService eventServcice = new EventServiceImpl();
		int ecoId = eventServcice.takeEcoIdByEventid(eventId);
		int result = eventServcice.alumniAttendance(Alumniid, ecoId);

		if (result == 1) {
			System.out.println("Attendance Marked");
		} else {
			System.out.println("Attendance Not Marked");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
