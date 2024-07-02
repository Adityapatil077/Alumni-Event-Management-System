package org.alumnievent.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.alumnievent.service.AlumniService;
import org.alumnievent.service.AlumniServiceImpl;
import org.alumnievent.service.EventService;
import org.alumnievent.service.EventServiceImpl;


@WebServlet("/getfeedback")
public class GetFeedbackController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int AlumniId = Integer.parseInt(request.getParameter("email").trim());
		String AfeedBack = request.getParameter("feedback").trim();
		int EventId = Integer.parseInt(request.getParameter("event").trim());
		AlumniService aServ = new AlumniServiceImpl();
		EventService eServ = new EventServiceImpl();
		int Ecoid = eServ.takeEcoIdByEventid(EventId);
		int result = eServ.giveFeedBack(AlumniId, Ecoid, AfeedBack);
		if (result == 1) {
			RequestDispatcher r = request.getRequestDispatcher("FeedbackForm.jsp");
			r.include(request, response);
		} else {
			RequestDispatcher r = request.getRequestDispatcher("FeedbackForm.jsp");
			r.include(request, response);
		}
	}

}
