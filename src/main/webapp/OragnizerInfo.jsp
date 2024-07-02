<%@include file="AdminMain.jsp"%>


<div class="col-12 d-flex align-item-centre justify-content-centre mt-5">
	<div class="ms-5">
		<button type="button" class="btn btn-primary">
			<a href="AddOragnizer.jsp" style="color: white">Add Oragnizer</a>
		</button>
	</div>
</div>
<%
			OragnizerService oragnizerService = new OragnizerServiceImpl();
			List<OragnizerModel> list = oragnizerService.getAllOragnizer();
			if(list!=null)
			{
			
			%>
<div class="mt-4 mx-5 border  p-3 rounded bg-light">
	<table class="table table-striped text-light table-fixed text-centre">
		<thead class="table-dark text-center" style="position: sticky; top: 0">
			<tr>
				<th scope="col">Sr.No</th>
				<th scope="col">Oragnizer NAME</th>
				<th scope="col">EMAIL</th>
				<th scope="col">CONTACT</th>
				<th scope="col">ADDRESS</th>
				<th scope="col">Delete</th>
				<th scope="col">Update</th>
			</tr>
		</thead>
		<tbody class="text-center">
			<%
			int count = 0;
			for (OragnizerModel oModel : list) {
			%>

			<tr>
				<th scope="row"><%=++count%></th>
				<td><%=oModel.getOrganizerName()%></td>
				<td><%=oModel.getOrganizerEmail()%></td>
				<td><%=oModel.getOrganizerContact()%></td>
				<td><%=oModel.getOrganizerAddress()%></td>
				<td><a href='del?OrganizerId=<%=oModel.getOrganizerId()%>'><img
						width="30" height="30"
						src="https://img.icons8.com/dusk/64/delete-forever.png"
						alt="delete-forever" /></a></td>
				<td><a
					href='updateoragnizer?OrganizerId=<%=oModel.getOrganizerId()%>'><img
						width="30" height="30"
						src="https://img.icons8.com/dusk/64/edit--v1.png" alt="edit--v1" /></a></td>

			</tr>
			<%
			}}else{
				%>
				<hr>
				<h3 class="mt-4 fw-bold text-center">No Organizer Found</h3>
				<%
			}
			%>

		</tbody>
	</table>

</div>
</div>
</div>

</body>
</html>