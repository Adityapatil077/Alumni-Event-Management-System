<%@include file="AdminMain.jsp"%>

<main class="content">
	<div class="container-fluid">
		<div class="mb-3 col-12 mt-5">

			<div class="">
				<h2 class="text-center text-warning fw-bold">All Event Details</h2>
			</div>
				<%
				int collegeid = cModel.getCollegeId();

				EventService eServ = new EventServiceImpl();
				List<EventModel> list = eServ.ShowEventsAsPerCollege(collegeid);
				
				if(list!=null)
				{
				%>
				<div class="mt-4 mx-5 border  p-3 rounded bg-light"
					style="max-height: 80vh; overflow-y: auto; position: relative;">
					<table
						class="table table-striped text-light table-fixed text-center">
						<thead class="table-dark text-center"
							style="position: sticky; top: 0">
							<tr class="highlight">	
								<th scope="col">#</th>
								<th scope="col">Name</th>
								<th scope="col">Branch</th>
								<th scope="col">Venue</th>
								<th scope="col">Date</th>
								<th scope="col">Description</th>
							</tr>
						</thead>
						<tbody class="text-center">

							<%
							
							int count = 0;
							for (EventModel model : list) {
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
							<td><%=model.getDate()%></td>
							<td><%=model.getDescription()%></td>
							</tr>
							<%
							}}else{
							%>
							<hr>
							<h3 class="text-center mt-5 fw-bold">No Event Found</h3>
							<% 
							}
							%>
						</tbody>
					</table>
				</div>
			
		</div>
	</div>
</main>
</div>
</div>
</div>
</body>
</html>