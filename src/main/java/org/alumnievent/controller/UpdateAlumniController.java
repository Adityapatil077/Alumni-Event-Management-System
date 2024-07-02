package org.alumnievent.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.alumnievent.model.AlumniModel;
import org.alumnievent.service.AlumniServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatealumni")
public class UpdateAlumniController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int aId = Integer.parseInt(request.getParameter("AlumniId"));
        RequestDispatcher r = request.getRequestDispatcher("AdminMain.jsp");
        r.include(request, response);
        AlumniServiceImpl alumniService = new AlumniServiceImpl();
        AlumniModel model = alumniService.getAlumniProfile(aId);
        out.println("<div class='container mt-5'>");
        out.println("<div class='row justify-content-center'>");
        out.println("<div class='col-md-6'>");
        out.println("<div class='card border shadow p-4'>");
        out.println("<div class='card-body'>");
        out.println("<h3 class='card-title fw-bold text-warning text-center'>Update Alumni</h3>");
        out.println("<form name='frm' action='finalupdatealumni' method='post'>");
        
        out.println("<input type='hidden' name='oId' value='" + aId + "' class='form-control'/>");
        out.println("<div class='mb-3'>");
        out.println("<label for='email' class='form-label'>Email</label>");
        out.println("<input type='email' name='email' value='' class='form-control' required/>");
        out.println("</div>");
        
        out.println("<div class='mb-3'>");
        out.println("<label for='contact' class='form-label'>Contact</label>");
        out.println("<input type='text' name='contact' value='' class='form-control' required/>");
        out.println("</div>");
        
        out.println("<div class='mb-3'>");
        out.println("<label for='address' class='form-label'>Address</label>");
        out.println("<input type='text' name='address' value='' class='form-control' required/>");
        out.println("</div>");
        
        out.println("<div class='text-center'>");
        out.println("<input type='submit' name='s' value='Update' class='btn btn-primary'/>");
        out.println("</div>");
        
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
    }
    
}
