
<%@page
	import="org.alumnievent.service.*,org.alumnievent.model.*,java.util.*"%>
<%@include file="OrgnizerMain.jsp"%>
<div class="main bg-img">
	<main class="content px-3 py-4">
		<div class="container-fluid">
			<div class="mb-3">
				<h3 class="fw-bold fs-4 mb-3 text-warning text-center">Colleges You Have Event</h3>
				
					<div class="mt-4 mx-5 border  p-3 rounded bg-light"
					style="max-height: 80vh; overflow-y: auto; position: relative;">

					<table
						class="table table-striped table-fixed text-center">
						<thead class="table-dark text-center"
							style="position: sticky; top: 0">
							<tr class="highlight">
									<th scope="col">#</th>
									<th scope="col">College Name</th>
									<th scope="col">College Email</th>
									<th scope="col">College Contact</th>
									<th scope="col">College Address</th>
									<th scope="col"></th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody class="text-center">

								<%
								int OrganizerId = Integer.parseInt(session.getAttribute("organizerId").toString());
								OragnizerService service = new OragnizerServiceImpl();
								List<CollegeModel> list = service.getcoleveOrganizedByOrganizer(OrganizerId);

								int count = 0;

								for (CollegeModel model : list) {
								%>
								<td><%=++count%></td>
								<td><%=model.getCollegeName()%></td>
								<td><%=model.getCollegeEmail()%></td>
								<td><%=model.getCollegeContact()%></td>
								<td><%=model.getCollegeAddress()%></td>
								<%
								int collegeid = model.getCollegeId();
								%>

								<td><a
									href="ManegeEventsOfCollege.jsp?collegeid=<%=collegeid%>">Manage
										Events</a></td>


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