<script type=text/javascript>
	function markAttendance() {
		let xhttp = new XMLHttpRequest();
		//var bid=document.getElementById("branchId").value;
		var result = document.getElementById("branchId").value;
		var values = result.split('-');
		var bid = values[0];
		var eventId = values[1];

		var cid = document.getElementById("cId").value;

		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("searcharea").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "FinalAlumniAttendance.jsp?search=" + bid + "&cid="
				+ cid, true);
		xhttp.send();
	}

	function takeAttendance(alumniid, button) {
		//alert(alumniid);
		let xhttp = new XMLHttpRequest();
		var result = document.getElementById("branchId").value;
		var values = result.split('-');
		var bid = values[0];
		var eventId = values[1];

		var cid = document.getElementById("cId").value;

		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				// var button =document.getElementById("b");
				button.innerHTML = "Present";
				button.style.backgroundColor = "#28a745"; // Green background color
				button.style.color = "white";
			}
		};
		xhttp.open("GET", "fattendance?alumniid=" + alumniid + "&search=" + bid
				+ "&eventId=" + eventId + "&cid=" + cid, true);
		xhttp.send();

	}
	function searchEvent() {
		var BranchId = document.getElementById("branch").value;
		var CollegeId = document.getElementById("cId").value;
		let xhttp = new XMLHttpRequest();
      
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				
				document.getElementById("searchbranch").innerHTML = this.responseText;
			}

		};
		xhttp.open("GET", "GetEvents.jsp?BranchId=" + BranchId + "&CollegeId="
				+ CollegeId, true);
		xhttp.send();

	}
	function searchAlumni() {
		var name = document.getElementById("Searchstudent").value;

		var BranchId = document.getElementById("branch").value;
		var CollegeId = document.getElementById("cId").value;
		let xhttp = new XMLHttpRequest();

		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("searcharea").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "SearchAlumni.jsp?BranchId=" + BranchId
				+ "&CollegeId=" + CollegeId + "&name=" + name, true);
		xhttp.send();

	}
</script>


<%@include file="AdminMain.jsp"%>
<%
int Id = cModel.getCollegeId();
%>



<!-- comment #F8F9FA-->

<div class="border border-1 shadow-sm p-3 h-100">

	<div class=" justify-content-center mt-3 ms-4 me-4">
		<h3 class="text-center fw-bold text-warning fst-italic"">Mark
			Attendance</h3>


		<div class="container-fluid">
			<div class="d-flex justify-content-end">
				<form class="d-flex">
					<input class="form-control me-2" id="Searchstudent"
						onkeyup="searchAlumni()" value='' type="search"
						placeholder="Search" aria-label="Search" style="width: 200px;">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>

		<!-- comment -->

		<div class="row">
			<div class=" col-lg-5 col-md-12 p-3 ms-3">
				<input type="hidden" id='cId' value='<%=Id%>'>
				<div class="form-group d-flex">
					<label for="branch" class="form-label fs-6 fw-bold text-info">Branch
						Name :</label> <select id="branch" name="branch" class="form-select"
						onchange="searchEvent()">
						<%
						BranchService bServ = new BranchServiceImpl();
						List<BranchModel> b = bServ.getCollegeWiseBranch(Id);
						for (BranchModel bm : b) {
						%>
						<option value="<%=bm.getBranchId()%>"><%=bm.getBranchName()%></option>
						<%
						}
						%>
					</select>
				</div>
			</div>
          
          
			<div class="col-lg-5 col-md-12 p-3 ms-3">
			<div id="searchbranch">
				<div class="form-group d-flex">
					<label for="branchId" class="form-label fs-6 fw-bold text-info">Event
						Name:</label> <select id="branchId" name="branchId" class="form-select"
						onchange="markAttendance()">
						<%
						EventService eventService = new EventServiceImpl();
						List<EventModel> list = eventService.ShowEventsAsPerCollege(Id);
						for (EventModel e : list) {
						%>
						<option value="<%=e.getBranchId()%>-<%=e.getEventId()%>"><%=e.getEventName()%></option>
						<%
						}
						%>
					</select>
				</div>
			</div>
		</div>
        </div>
		<!-- comment -->

		
	
	<div class="mt-4 mx-5 border  p-3 rounded bg-light" id="searcharea">
	
		<div style="overflow-y: auto; height: 57vh;">
            <table class="table table-striped text-light text-center">
                <thead class="table-dark text-center" style="position: sticky; top: 0; z-index: 1;">
                   <tr class="highlight">
                    <th scope="col">Sr.No</th>
                    <th scope="col">NAME</th>
                    <th scope="col">Id No</th>
<!--                     <th scope="col">Action</th> -->
                </tr>
                </thead>
                <tbody class="text-center">
                     <%
                AlumniService alumniService = new AlumniServiceImpl();
                List<AlumniModel> li = alumniService.getAllAlumni(Id);
                int count = 0;
                for (AlumniModel aModel : li) {
                %>
                <tr>
                    <th scope="row"><%= ++count %></th>
                    <td><%= aModel.getAlumniName() %></td>
                    <td><%= aModel.getAlumniId() %></td>
<!--                     <td> -->
<!--                         <button class="btn btn-danger" id="b" -->
<%--                                 onclick="takeAttendance('<%= aModel.getAlumniId() %>', this)" --%>
<!--                                 type="button">Attendance</button> -->
<!--                     </td> -->
                </tr>
                <%
                }
                %>
                </tbody>
            </table>
        </div>
	</div>
	


		<!-- </form> -->






	</div>
</div>
</div>
</div>

</body>
</html>