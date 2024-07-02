<%@include file="AlumniMain.jsp"%>
<div class="main bg-img">
	<h3 class="fw-bold fs-4 mb-3 mt-4 text-warning text-center">My Events</h3>

	<div class="mt-4 mx-5 border  p-3 rounded bg-light"
		style="max-height: 80vh; overflow-y: auto; position: relative;">

		<table class="table table-striped table-fixed text-center">
			<thead class="table-dark text-center"
				style="position: sticky; top: 0">
				<tr class="highlight">
					<th scope="col">#</th>
					<th scope="col">Event Name</th>
					<th scope="col">Event Venue</th>
					<th scope="col">Event Description</th>
					<th scope="col">Event Date</th>
				</tr>
			</thead>
			<tbody class="text-center">
				<%
				AlumniService aServ = new AlumniServiceImpl();
				int collegeid = aServ.getCollegeIdOfAlumni(AlumniId);
				EventService eServ = new EventServiceImpl();
				List<EventModel> list = eServ.ShowEventsAsPerAlumni(collegeid, AlumniId);
				int count = 0;
				for (EventModel model : list) {
				%>
				<td><%=++count%></td>
				<td><%=model.getEventName()%></td>
				<td><%=model.getVenue()%></td>
				<td><%=model.getDescription()%></td>
				<td><%=model.getDate()%></td>

				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</div>
</div>
</div>
</body>
</html>