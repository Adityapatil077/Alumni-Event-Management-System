<%@page
	import="org.alumnievent.service.*,org.alumnievent.model.*,java.util.*"%>
<%@include file="OrgnizerMain.jsp"%>
<div class="main bg-img">
	<div class="mt-4">
		<h3 class="fw-bold fs-4 mb-3 text-warning text-center">College
			For Event</h3>
	</div>

	<div class="mt-3 mx-4 border p-3 rounded bg-light"
		style="min-height: 90vh; overflow-y: auto; position: relative;">

		<table class="table table-striped table-fixed text-center">
			<thead class="table-dark text-center"
				style="position: sticky; top: 0">
				<tr class="highlight">
					<th scope="col">#</th>
					<th scope="col">College Name</th>
					<th scope="col">College Email</th>
					<th scope="col">College Contact</th>
					<th scope="col">College Address</th>
					<th scope="col">Show Events</th>
					<th scope="col">Organize </th>
				</tr>
			</thead>
			<tbody class="text-center">

				<%
				OragnizerService service = new OragnizerServiceImpl();
				List<CollegeModel> list = service.getAllCollege();

				int count = 0;

				for (CollegeModel model : list) {
				%>
				<td><%=++count%></td>
				<td><%=model.getCollegeName()%></td>
				<td><%=model.getCollegeEmail()%></td>
				<td><%=model.getCollegeAddress()%></td>
				<td><%=model.getCollegeContact()%></td>
				<td><a
					href="ViewCollegeEvent.jsp?collegeid=<%=model.getCollegeId()%>"><img alt="" src="Imgs/schedule.png"></a></td>
				<td><a
					href="OrganizeEvent.jsp?collegeid=<%=model.getCollegeId()%>"><img src="Imgs/organizer.png"></a></td>
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