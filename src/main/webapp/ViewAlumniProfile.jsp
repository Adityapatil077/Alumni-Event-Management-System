<%@include file="AlumniMain.jsp"%>
<div class="main bg-img">
	<main class="content px-3 py-4">
		<div class="container-fluid">
			<div class="mb-3">
				<h3 class="fw-bold fs-4 mb-3 text-warning"><%=aModel.getAlumniName()%></h3> 
				<div class="row">
					<div class="col-12 border border-2 text-light rounded bg-light p-4">
						<table class="table table-striped">
							<thead>
								<tr class="highlight">
									<th scope="col">#</th>
									<th scope="col">Alumni Name</th>
									<th scope="col">Alumni Email</th>
									<th scope="col">Alumni Contact</th>
									<th scope="col">Alumni Address</th>
									<th scope="col">Alumni PassoutYear</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">1</th>
									<td><%=aModel.getAlumniName()%></td>
									<td><%=aModel.getAlumniEmail()%></td>
									<td><%=aModel.getAlumniContact()%></td>
									<td><%=aModel.getAlumniAddress()%></td>
									<td><%=aModel.getPassOutYear()%></td>
								</tr>

							</tbody>
						</table>
						<div class="text-end mb-4">
							<button type="submit" class="btn btn-info ">
								<a href="UpdateAlumniProfile.jsp" style="text-decoration: none;">Update
									Profile</a>
							</button>
						</div>

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