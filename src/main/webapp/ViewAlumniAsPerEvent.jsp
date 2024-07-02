
<%@include file="AdminMain.jsp"%>
<style>
.mb-3 {
	margin-top: 50px;
}
</style>
<script type="text/javascript">
	function viewEvents() {
		var BranchId = document.getElementById("branch").value;
		var CollegeId = document.getElementById("cId").value;
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("event").innerHTML = this.responseText;
			}

		};
		xhttp.open("GET", "ViewAlumniAsPerEvant2.jsp?BranchId=" + BranchId
				+ "&CollegeId=" + CollegeId, true);
		xhttp.send();

	}
</script>

<main class="content px-3 py-4">

	<!-- comment  -->
	<div class=" col-lg-5 col-md-12 p-3 ms-3">
		<input type="hidden" id='cId' value='<%=CollegeId%>'>
		<div class="form-group d-flex">
			<label for="branch" class="form-label fs-6 fw-bold text-info">Branch
				Name:</label> <select id="branch" name="branch" class="form-select"
				onchange="viewEvents()">
				<%
				BranchService bServ = new BranchServiceImpl();
				List<BranchModel> b = bServ.getCollegeWiseBranch(CollegeId);
				for (BranchModel bm : b) {
				%>
				<option value="<%=bm.getBranchId()%>"><%=bm.getBranchName()%></option>
				<%
				}
				%>
			</select>
		</div>

	</div>

	<!-- comment -->
	<div class="container-fluid">
	
		<%
		
		EventService eServ = new EventServiceImpl();
		List<EventModel> list = eServ.ShowEventsAsPerCollege(CollegeId);
		if(list==null)
		{
			
		%>
		<div id="event" class="mt-4 mx-5 border  p-3 rounded bg-light" style="max-height: 80vh;overflow-y: auto;position: relative;">
			<table class="table table-striped text-light table-fixed text-centre">
				<thead class="table-dark text-center" style="position: sticky;top: 0">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Name</th>
						<th scope="col">Venue</th>
						<th scope="col">Date</th>
						<th scope="col">Description</th>
						<th scope="col">Sort Alumni</th>
						<th scope="col">Present Alumni</th>
						<th scope="col">Absent Alumni</th>
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
						href="SortAlumniByYear.jsp?EventId=<%=model.getEventId()%>">Sorted</a></td>
					<td><a
						href="ViewPresentAlumni.jsp?EventId=<%=model.getEventId()%>">Present</a></td>
					<td><a
						href="ViewAbsentAlumni.jsp?EventId=<%=model.getEventId()%>">Absent</a></td>

					</tr>
					<%
					}}else{
						%>
						<hr>
						<h3 class="text-center fw-bold">Empty</h3>
						<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</main>

</div>
</div>
</div>
</body>
</html>