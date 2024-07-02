<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="org.alumnievent.service.*, org.alumnievent.model.* , java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int BranchId = Integer.parseInt(request.getParameter("BranchId"));
	int CollegeId = Integer.parseInt(request.getParameter("CollegeId"));
	%>





	<%
	EventService eServ = new EventServiceImpl();
	List<EventModel> list = eServ.showEventsOfBranchCollege(BranchId, CollegeId);
	if (list.size() > 0) {
	%>
	<table class="table table-striped text-light table-fixed text-centre">
		<thead class="table-dark text-center" style="position: sticky; top: 0">
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Venue</th>
				<th scope="col">Date</th>
				<th scope="col">Description</th>
				<th scope="col">FeedBack</th>
				<th scope="col">Senior Alumni</th>
			</tr>
		</thead>
		<tbody class="text-center">
			<%
			int count = 0;
			for (EventModel model : list) {
			%>

			<td><%=++count%></td>
			<td><%=model.getEventName()%></td>
			<td><%=model.getVenue()%></td>
			<td><%=model.getDate()%></td>
			<td><%=model.getDescription()%></td>
			<td><a
				href="ShowCollegeFeedBack.jsp?EventId=<%=model.getEventId()%>">Show
					FeedBack </a></td>
					<td><a
						href="ViewMostSeniorAlumni.jsp?EventId=<%=model.getEventId()%>">Senior
							Alumni</a></td>
			</tr>
			<%
			}
			} else {
			%>
			<h3 class="text-center">No Event Found</h3>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>