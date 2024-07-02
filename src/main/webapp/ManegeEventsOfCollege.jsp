
<%@include file="OrgnizerMain.jsp"%>
<div class="main bg-img">
	<main class="content px-3 py-4">
		<div class="container-fluid">
			<div class="mb-3">
				<h3 class="fw-bold mb-3 text-warning text-center mt-4">Manage
					Events of College</h3>
				<div class="row ">
					<div class="col-12 border border-1 mt-3 p-4 rounded-3">
						<table class="table table-striped mb-4 me-5">
							<thead>
								<tr class=" fw-bold">
									<th scope="col">#</th>
									<th scope="col" class="fs-5">Event Name</th>
									<th scope="col" class="fs-5">Branch Name</th>
									<th scope="col" class="fs-5">Event Venue</th>
									<th scope="col" class="fs-5">Event Description</th>
									<th scope="col" class="fs-5">Event Date</th>
									<th scope="col" class="fs-5">Delete</th>
									<th scope="col" class="fs-5">Update</th>
								</tr>
							</thead>
							<tbody>
								<%
								int collegeId = Integer.parseInt(request.getParameter("collegeid").toString());
								int organizerId = Integer.parseInt(session.getAttribute("organizerId").toString());
								EventService eServ = new EventServiceImpl();
								List<EventModel> list = eServ.ShowOrganizerEvents(collegeId, organizerId);
								int count = 0;
								for (EventModel model : list) {
								%>
								<tr>
									<td ><%=++count%></td>
									<td ><%=model.getEventName()%></td>
									<%
									BranchService bService = new BranchServiceImpl();
									int branchId = model.getBranchId();
									String branchName = bService.getBranchNameById(branchId, collegeId);
									%>
									<td ><%=branchName%></td>
									<td ><%=model.getVenue()%></td>
									<td ><%=model.getDescription()%></td>
									<td ><%=model.getDate()%></td>
									<td ><a
										href="deleteevent?eventid=<%=model.getEventId()%>&collegeId=<%=collegeId%>">
											<img width="35" height="35"
											src="https://img.icons8.com/dusk/64/delete-forever.png"
											alt="Delete" />
									</a></td>
									<td ><a
										href="UpdateCollegeEvents.jsp?eventid=<%=model.getEventId()%>&collegeid=<%=collegeId%>">
											<img width="32" height="32"
											src="https://img.icons8.com/cute-clipart/64/restart.png"
											alt="Update" />
									</a></td>
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
	</main>
</div>
</div>
</div>
</body>
</html>