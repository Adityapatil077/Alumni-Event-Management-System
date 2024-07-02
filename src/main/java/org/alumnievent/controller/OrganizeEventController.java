package org.alumnievent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.alumnievent.model.AlumniModel;
import org.alumnievent.model.EventModel;
import org.alumnievent.service.AlumniService;
import org.alumnievent.service.AlumniServiceImpl;
import org.alumnievent.service.EventService;
import org.alumnievent.service.EventServiceImpl;

@WebServlet("/organizeevent")
public class OrganizeEventController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			int collegeId = Integer.parseInt(request.getParameter("collegeid"));
			int organizerId = Integer.parseInt(request.getParameter("organizerid"));
			int branchId = Integer.parseInt(request.getParameter("branchId"));
			String eventName = request.getParameter("eventName");
			String venue = request.getParameter("venue");
			String description = request.getParameter("description");
			Date eventDate = Date.valueOf(request.getParameter("eventDate"));

			EventModel eventModel = new EventModel();
			eventModel.setBranchId(branchId);
			eventModel.setEventName(eventName);
			eventModel.setDescription(description);
			eventModel.setVenue(venue);
			eventModel.setDate(eventDate);

			EventService eventService = new EventServiceImpl();
			boolean isEventAdded = eventService.addEvent(eventModel, collegeId, organizerId, branchId);
			
			if (isEventAdded) {
				AlumniService alumniService = new AlumniServiceImpl();
				List<AlumniModel> alumniList = alumniService.getAllAlumniOfCollegeBranchWise(branchId, collegeId);
				
				for (AlumniModel alumni : alumniList) {
					String email = alumni.getAlumniEmail();
					EmailService.sendEmail(eventName, description, email);
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCollegeForEvent.jsp");
				dispatcher.include(request, response);
				out.println("<h2>Event Organized Successfully</h2>");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCollegeForEvent.jsp");
				dispatcher.include(request, response);
				out.println("<h2>There was a problem organizing the event.</h2>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<h2>Invalid input. Please check your data.</h2>");
		} finally {
			out.close();
		}
	}
}
