

<%@include file="AdminMain.jsp"%>
<div class="main p-3" style="height: 90vh">
	<div class="row">
		<div class="col-lg-3 col-md-12 h-70 ms-3 me-3 mt-2" >
			
				<div
					class="col-lg-12 col-md-12 d-flex align-items-center justify-content-center">
					<img src="Imgs/JspmImage.jpg" class="img-fluid"
						alt="...">
				</div>
				<div class="row d-flex align-items-center justify-content-center mt-4 mb-4">
					<a href="#" class="btn btn-outline-primary w-50 ">Edit</a>
				</div>		
		</div>
		 <div class="col-lg-8 col-md-12 h-70 border border-2 rounded-3 shadow ms-3 me-3 mt-2" style="backdrop-filter:blur(10px); background-color:#CFF4FC;">
        <h3 class="heading p-3 fs-1 text-center">Profile</h3>
        <table class="table table-info mt-3 p-4 mb-5">
            <tr class="">
                <th scope="row" class="fs-4">Full Name</th>
                <td class="fs-5"><%=cModel.getCollegeName()%></td>
            </tr>
            <tr class="">
                <th scope="row" class="fs-4">Email</th>
                <td class="fs-5"><%=cModel.getCollegeEmail()%></td>
            </tr>
            <tr class="">
                <th scope="row" class="fs-4">Contact</th>
                <td class="fs-5"><%=cModel.getCollegeContact()%></td>
            </tr>
            <tr class="">
                <th scope="row" class="fs-4">Address</th>
                <td class="fs-5"><%=cModel.getCollegeAddress()%></td>
            </tr>
        </table>
    </div>

	</div>
	<div>
	<%
		OragnizerService oService = new OragnizerServiceImpl();
		int OragnizerCount = oService.getOragnizerCount();
		EventService eService = new EventServiceImpl();
		int EventCount = eService.getEventCount();
	
	%>
			<div class="container overflow-hidden text-center mt-5">
				<div class="row gx-5">
					<div class="col border border-2 shadow-sm	 m-3" style="backdrop-filter:blur(10px); background-color:#CFF4FC;">
						<div class="mt-3" style="color : green"><h1><%=OragnizerCount %></h1></div>
						<div class=" text-dark mb-3 mt-0 "><h6>Orgnizer</h6></div>
					</div>
					<div class="col border border-2 shadow-sm	 m-3" style="backdrop-filter:blur(10px); background-color:#CFF4FC;">
						<div class="mt-3" style="color : green"><h1>5+</h1></div>
						<div class=" text-dark mb-3"><h6>Event</h6></div>
					</div>
					<div class="col border border-2 shadow-sm	 m-3" style="backdrop-filter:blur(10px); background-color:#CFF4FC;">
						<div class="mt-3" style="color : green"><h1>5+</h1></div>
						<div class=" text-dark mb-3"><h6>Branch</h6></div>
					</div>
					<div class="col border border-2 shadow-sm	 m-3" style="backdrop-filter:blur(10px); background-color:#CFF4FC;">
						<div class="mt-3" style="color : green"><h1>5+</h1></div>
						<div class=" text-dark mb-3"><h6>Alumni</h6></div>
					</div>
				</div>
			</div>
		</div>
</div>
</div>
</body>
</html>