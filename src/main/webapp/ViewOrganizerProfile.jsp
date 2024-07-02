
<%@include file="OrgnizerMain.jsp"%>
<div class="main">
	<h3 class="ms-5 mt-3 f-bold text-warning">
		Welcome
		<%=oModel.getOrganizerName()%></h3>
	<p class=""></p>
	<div class="content container" style="min-height: 70vh">
		<div class="row mb-4">

			<div class="col-lg-5 col-md-10 shadow ms-4  rounded-3 mt-4"
				style="min-height: 60vh; background-color: white">
				<div class="row text-center">
					<div class="col-12">
						<img src="Imgs/HKstrategies-846-removebg-preview.png"
						class="img-fluid profile-img mt-0 text-center"
						style="width: 30vw; height: 30vh" alt="Profile Image">
					</div>
					<div class="col-12 text-center mt-3">
						<a href="#" class="btn btn-outline-primary btn-edit w-45">Edit
							Profile</a>
					</div>
				</div>
				<div class="row mt-2">
					<h6 class="fw-bold ms-3">My Profile</h6>
					<h4 class=" text-center fw-bold text-center"><%=oModel.getOrganizerName()%></h4>
				</div>


				<div class="row mt-2 ms-4">
					<div class="table-responsive">
						<table class="table">
							<tr>
								<td class="align-middle"><img width="26" height="26"
									src="https://img.icons8.com/dusk/64/secured-letter--v1.png"
									alt="secured-letter--v1" /></td>
								<td class="align-middle"><%=oModel.getOrganizerEmail()%></td>
							</tr>
							<tr class="mt-3">
								<td class="align-middle"><img width="26" height="26"
									src="https://img.icons8.com/metro/26/phone-disconnected.png"
									alt="phone-disconnected" /></td>
								<td class="align-middle"><%=oModel.getOrganizerContact()%></td>
							</tr>
							<tr class="mt-3">
								<td class="align-middle"><img width="26" height="26"
									src="https://img.icons8.com/dusk/64/order-delivered.png"
									alt="order-delivered" /></td>
								<td class="align-middle"><%=oModel.getOrganizerAddress()%></td>
							</tr>
						</table>
					</div>
				</div>
			</div>

			<div class="col-lg-6 col-md-10 ms-5 mt-4" style="min-height: 60vh">
				<div class="row">
					<div class="col-12 shadow rounded-3" style="min-height: 35vh"></div>
				</div>

				<div class="row mt-5">
					<div class="col-12 shadow rounded-3" style="min-height: 35vh"></div>
				</div>
			</div>

		</div>

	</div>

</div>
</div>
</div>
<script type="module"
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</body>
</html>