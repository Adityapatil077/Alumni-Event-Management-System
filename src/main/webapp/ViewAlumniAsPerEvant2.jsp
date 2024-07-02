<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@include file="AdminMain.jsp"%> --%>
 <%@page import= "org.alumnievent.service.*, org.alumnievent.model.* , java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  int BranchId=Integer.parseInt(request.getParameter("BranchId"));
  int CollegeId=Integer.parseInt(request.getParameter("CollegeId"));
 
%>
<%
 System.out.println("Branchid is"+BranchId);
System.out.println("collegeId is"+CollegeId);
%>
<div class="">
	<%
	EventService eServ=new  EventServiceImpl();
	List <EventModel> list=eServ.showEventsOfBranchCollege(BranchId,CollegeId);
	if(list==null)
	{
	%>
			<div class="row">
				<div class="col-12">
					<table class="table table-striped text-light table-fixed text-centre">
				<thead class="table-dark text-center" style="position: sticky;top: 0">
							<tr>
								<th scope="col">Sr no</th>
								<th scope="col">Name</th>
								<th scope="col">Venue</th>
								<th scope="col">Date</th>
								<th scope="col">Description</th>
								<th scope="col">Sort Alumni</th>
							    <th scope="col">Present Alumni</th>
							    <th scope="col">Absent Alumni</th>
							</tr>
						</thead>
						<tbody>
						
						 <%	 	
          				
						int count=0;
						for(EventModel model:list)
						{
	    				%>	
	     				 <td><%=++count%></td>
	     				<td><%=model.getEventName() %></td>
	     				<td><%=model.getVenue() %></td>
	     				<td><%=model.getDate() %></td>
	     				<td><%=model.getDescription() %></td>
	                    <td><a href="SortAlumniByYear.jsp?EventId=<%=model.getEventId()%>">Sorted</a></td>
	     				<td><a href="ViewPresentAlumni.jsp?EventId=<%=model.getEventId()%>">Present</a></td>
	     				<td><a href="ViewAbsentAlumni.jsp?EventId=<%=model.getEventId()%>">Absent</a></td>	
	     	            </tr>
	    <% 
		}}else{
			
		%>
			<h3 class="text-center fw-bold">Empty</h3>
		<% 
		}
		%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
</body>
</html>