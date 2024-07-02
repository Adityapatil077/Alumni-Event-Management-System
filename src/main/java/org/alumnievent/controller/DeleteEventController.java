package org.alumnievent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.alumnievent.service.EventService;
import org.alumnievent.service.EventServiceImpl;

@WebServlet("/deleteevent")
public class DeleteEventController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String eventId = request.getParameter("eventid");
		String cid = request.getParameter("collegeId");
		int collegeId = Integer.parseInt(cid);
		System.out.println(collegeId);
		int Eventid = Integer.parseInt(eventId);
		EventService eService = new EventServiceImpl();
		int value = eService.isDeleteEvent(Eventid);
		if (value == 1) {
			out.println("Event Deleted Sucessfully");
			int collegeid = collegeId;
			String valueToSend = String.valueOf(collegeid);
			String url = "ManegeEventsOfCollege.jsp?collegeid=" + URLEncoder.encode(valueToSend, "UTF-8");
			response.sendRedirect(url);
		} else {
			out.println("<h1>Some Problem is there</h1>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
