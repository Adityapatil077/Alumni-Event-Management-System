package org.alumnievent.login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alumnievent.model.AlumniModel;
import org.alumnievent.service.AlumniService;
import org.alumnievent.service.AlumniServiceImpl;


@WebServlet("/addnewalumni")
public class AddNewAlumniController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		int passoutyear = Integer.parseInt(request.getParameter("passoutyear"));
		int CollegeId = Integer.parseInt(request.getParameter("cId"));
		int branchId=Integer.parseInt(request.getParameter("branchId")) ;
		AlumniModel aModel = new AlumniModel();
		aModel.setAlumniName(name);
		aModel.setAlumniEmail(email);
		aModel.setAlumniContact(contact);
		aModel.setAlumniAddress(address);
		aModel.setAlumniGender(gender);
		aModel.setPassOutYear(passoutyear);
		aModel.setBranchId(branchId);
		aModel.setCollegeId(CollegeId);
		AlumniService alumniService = new AlumniServiceImpl();
		boolean b = alumniService.isRegisteredNewAlumni(aModel);
		if(b)
		{
			RequestDispatcher r = request.getRequestDispatcher("AlumniInfo.jsp?msg=valid");
			r.include(request, response);
		}else {
			RequestDispatcher r = request.getRequestDispatcher("AlumniInfo.jsp?msg=valid");
			r.include(request, response);
		}
		
	}

}
