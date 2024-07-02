<%@include file="OrgnizerMain.jsp"%>

<div class="main bg-img">

	<div class="mb-3">
		<h3 class="fw-bold fs-4 mt-4 text-warning text-center">Ongoing
			Events of College</h3>
	</div>

	<div class="mt-4 mx-5 border  p-3 rounded bg-light"
		style="max-height: 80vh; overflow-y: auto; position: relative;">

		<table class="table table-striped table-fixed text-center">
			<thead class="table-dark text-center"
				style="position: sticky; top: 0">
				<tr class="highlight">
					<th scope="col">#</th>
					<th scope="col">Event Name</th>
					<th scope="col">Branch Name</th>
					<th scope="col">Event Venue</th>
					<th scope="col">Event Description</th>
					<th scope="col">Event Date</th>
				</tr>
			</thead>
			<tbody class="text-center">

				<%
				int collegeid = Integer.parseInt(request.getParameter("collegeid").toString());
				EventService eServ = new EventServiceImpl();
				List<EventModel> li = eServ.ShowEventsAsPerCollege(collegeid);
				int count = 0;
				for (EventModel model : li) {
				%>
				<td><%=++count%></td>
				<td><%=model.getEventName()%></td>
				<%
				BranchService bService = new BranchServiceImpl();
				int branchId = model.getBranchId();
				String BranchName = bService.getBranchNameById(branchId, collegeid);
				%>
				<td><%=BranchName%></td>
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