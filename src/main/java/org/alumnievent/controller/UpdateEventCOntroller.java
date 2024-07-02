package org.alumnievent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alumnievent.model.EventModel;
import org.alumnievent.service.EventService;
import org.alumnievent.service.EventServiceImpl;

@WebServlet("/UpdateEventCOntroller")
public class UpdateEventCOntroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String cid = request.getParameter("collegeId");
		int collegeId = Integer.parseInt(cid);
		int eventId = Integer.parseInt(request.getParameter("eventid").toString());

		int branchId = Integer.parseInt(request.getParameter("branchId"));
		String eventName = request.getParameter("eventName");
		String venue = request.getParameter("venue");
		String description = request.getParameter("description");
		String date = request.getParameter("eventDate");
		Date eventDate = Date.valueOf(date);

		EventModel model = new EventModel();
		model.setBranchId(branchId);
		model.setEventName(eventName);
		model.setDescription(description);
		model.setVenue(venue);
		model.setDate(eventDate);
		EventService eService = new EventServiceImpl();
		int value = eService.isUpdateEvent(eventId, model);
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
