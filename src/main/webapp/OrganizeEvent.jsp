<%@page import="java.util.*"%>

<%@include file="OrgnizerMain.jsp"%>
<div class="main bg-img">
	<main class="content px-3 py-4">
		<div class="container-fluid">
			<div class="mb-3">

				<%
				int collegeid = Integer.parseInt(request.getParameter("collegeid").toString());
				int organizerid = Integer.parseInt(session.getAttribute("organizerId").toString());
				%>
				<%
				CollegeService cService = new CollegeServiceImpl();
				String CollegeName = cService.getCollegeNameById(collegeid);
				%>
				<h1 class="fw-bold fs-3 mt-4 text-warning text-center">
					Update Event for
					<%=CollegeName%>
					College
				</h1>
				<div class="row">
					<div class="col-12 border border-2 mt-3 rounded-3 bg-light p-4">
						<form class="formarea row g-3" name="frm" action="organizeevent"
							method="post">
							<div class="form-group">

								<div class="row">
									<div class="col">
										<label class="fs-5 ms-3 mb-2">Event Name</label> <input
											type="text" class="form-control form-control-lg"
											name="eventName" required>
									</div>
									<div class="col">
										<label class="fs-5 ms-3 mb-2">Event Venue</label> <input
											type="text" class="form-control form-control-lg" name="venue"
											required>
									</div>
								</div>


								<div class="row mt-3">
									<div class="col-lg-6 col-md-12">
										<label for="branchId" class="fs-5 ms-3 mb-2">Branch
											Name:</label> <select id="exampleInputEmail1" name="branchId"
											class="form-select form-select-lg mb-3"
											aria-label=".form-select-lg example">
											<%
											BranchService bService = new BranchServiceImpl();
											List<BranchModel> list = bService.getCollegeWiseBranch(collegeid);
											for (BranchModel b : list) {
											%>
											<option value="<%=b.getBranchId()%>"><%=b.getBranchName()%></option>
											<%
											}
											%>
										</select>
									</div>

									<div class="col-lg-6 col-md-12 mb-3">
										<label for="eventDate" class="form-label fs-5 ms-3">Event
											Date:</label> <input type="date" id="eventDate" name="eventDate"
											class="form-control form-control-lg" required>
									</div>
								</div>

								<div class="mb-3">
									<label for="exampleFormControlTextarea1"
										class="form-label fs-5 ms-3 mb-2">Event Description</label>
									<textarea class="form-control" name="description"
										id="exampleFormControlTextarea1" rows="3" required></textarea>
								</div>
							</div>

							<div class="form-group">
								<input type="hidden" name="collegeid" value="<%=collegeid%>">
							</div>

							<div class="form-group">
								<input type="hidden" name="organizerid" value="<%=organizerid%>">
							</div>

							<div class="text-center mt-2 mb-4">
								<button type="submit" class="btn btn-primary">
									<i class="bi bi-calendar-event me-2"></i>Organize Event
								</button>
							</div>

						</form>
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