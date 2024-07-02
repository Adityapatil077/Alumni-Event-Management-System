<%-- <%@include file="AdminMain.jsp"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import= "org.alumnievent.service.*, org.alumnievent.model.* , java.util.*" %>
<%
  // int aid=Integer.parseInt(request.getParameter("aid"));
   int bid=Integer.parseInt(request.getParameter("search"));
   int Alumniid=Integer.parseInt(request.getParameter("alumniid").toString());
   int eventId=Integer.parseInt(request.getParameter("eventId"));
   int Id=Integer.parseInt(request.getParameter("cid"));
%>

             	
					<div class="mt-4"
						style="border: 2px solid black; border-radius: 20px;">
						<table class="table mt-4 my-3 text-light text-centre">
							<thead>
								<tr>
									<th scope="col">Sr.No</th>
									<th scope="col">NAME</th>

								</tr>
							</thead>
							<tbody>
								<%
								AlumniService alumniService = new AlumniServiceImpl();
								EventService eventServcice=new EventServiceImpl();
								int ecoId = eventServcice.takeEcoIdByEventid(eventId);
								System.out.println("ecoid is"+ecoId);
								List<AlumniModel> am =alumniService.getAlumniByEvent(Id,bid);
								int count = 0;
								if(am.size()>0)
								{
								for (AlumniModel aModel : am) {
									System.out.println("hii");
									int result=eventServcice.finalAttendance(aModel, ecoId);
									System.out.println("result is: "+result);
									System.out.println("Alumni Name : "+aModel.getAlumniName());
								%>
								<tr>
									<th scope="row"><%=++count%></th>
									<td><%=aModel.getAlumniName()%></td>
									<td><%=aModel.getAlumniId() %></td>
									
									<td><button class="btn btn-danger" onclick="takeAttendance('<%=aModel.getAlumniId()%>')">Attendance</button></td>
								</tr>
								<%
								}}
								else{
									out.println("<h1>Alumni is Not Present</h1>");
								}
								%>
							</tbody>
						</table>
					</div>
                      
