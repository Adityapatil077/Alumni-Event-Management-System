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
	<div class="form-group" style="display: inline-block;">
		<label for="branchId">Event Name:</label> <select id="branchId"
			name="branchId" style="width: 300px; height: 40px;"
			onchange="markAttendance()">
			<%
			EventService eventService = new EventServiceImpl();
			List<EventModel> list = eventService.showEventsOfBranchCollege(BranchId, CollegeId);
			for (EventModel e : list) {
			%>
			<option value="<%=e.getBranchId()%>-<%=e.getEventId()%>"><%=e.getEventName()%>
			</option>
			<%
			}
			%>
		</select> <br>
		<br>
	</div>

</body>
</html>