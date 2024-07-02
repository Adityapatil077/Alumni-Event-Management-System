<%@include file="AdminMain.jsp"%>
<style>
.mb-3 {
	margin-top: 50px;
}
</style>
<script type="text/javascript">
	function viewEvent() {
		var BranchId = document.getElementById("branch").value;
		var CollegeId = document.getElementById("cId").value;
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("event").innerHTML = this.responseText;
			}

		};
		xhttp.open("GET", "SearchCollegeEvent.jsp?BranchId=" + BranchId
				+ "&CollegeId=" + CollegeId, true);
		xhttp.send();

	}
</script>

<main class="content px-3 py-4">
	<div id="view" class="container">
    <input type="hidden" id="cId" value="<%=CollegeId%>">
    <div class="form-group d-flex">
        <label for="branch" class="fw-bold">Branch Name:</label>
        <select id="branch" name="branch" class="form-control ms-4 mb-5" style="width: 100%; max-width: 300px;" onchange="viewEvent()">
 
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

<%
EventService eServ = new EventServiceImpl();
List<EventModel> list = eServ.ShowEventsAsPerCollege(CollegeId);
if(list!=null)
{
%>
	<div class="container-fluid" id="event">

		<div class="mt-4 mx-5 border  p-3 rounded bg-light"
			style="max-height: 80vh; overflow-y: auto; position: relative;">

			<table class="table table-striped text-light table-fixed text-center">
				<thead class="table-dark text-center"
					style="position: sticky; top: 0">
					<tr class="highlight">
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
					}}else{
					%>
					<h3 class="text-center">No Feedback Found</h3>
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
</body>
</html>