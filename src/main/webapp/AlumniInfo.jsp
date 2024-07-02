
<%@include file="AdminMain.jsp"%>
<%
int Id = cModel.getCollegeId();
%>
<div class="main bg-img">
	<div class="d-flex">
		<div class="mt-5 ms-5">
			<button type="button" class="btn btn-primary">
				<a href="AddAlumni.jsp" style="color: white">Add Alumni</a>
			</button>

		</div>
		<div class="mt-5 ms-4">
			<button type="button" class="btn btn-primary">
				<a href="AddBranch.jsp" style="color: white">Add Branch</a>
			</button>

		</div>
		<div class="mt-5 ms-5">
			<%
			String msg = request.getParameter("msg");
			if("invalid".equals(msg))
			{
			%>
				<h3 class="text-center fw-bold text-danger">Alumni Not Added</h3>
			<%
			}
			if("valid".equals(msg))
			{
			%>
				<h3 class="text-center fw-bold text-success">Alumni Added Successfully</h3>
			<%
			}
			%>
		</div>
	</div>
	 <%
                    AlumniService alumniService = new AlumniServiceImpl();
                    List<AlumniModel> list = alumniService.getAllAlumni(Id);
                    if(list!=null)
                    {
                   
        %>
	
	
	<div class="mt-4 mx-5 border  p-3 rounded bg-light">
	
		<div style="overflow-y: auto; height: 77vh;">
            <table class="table table-striped text-light text-center">
                <thead class="table-dark text-center" style="position: sticky; top: 0; z-index: 1;">
                    <tr class="highlight">
                        <th scope="col">Sr.No</th>
                        <th scope="col">NAME</th>
                        <th scope="col">EMAIL</th>
                        <th scope="col">CONTACT</th>
                        <th scope="col">ADDRESS</th>
                        <th scope="col">PASS OUT</th>
                        <th scope="col">GENDER</th>
                        <th scope="col">Delete</th>
                        <th scope="col">Update</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                   <%
                   int count = 0;
                   for (AlumniModel aModel : list) {
                   
                   %>
                    <tr>
                        <th scope="row"><%= ++count %></th>
                        <td><%= aModel.getAlumniName() %></td>
                        <td><%= aModel.getAlumniEmail() %></td>
                        <td><%= aModel.getAlumniContact() %></td>
                        <td><%= aModel.getAlumniAddress() %></td>
                        <td><%= aModel.getPassOutYear() %></td>
                        <td><%= aModel.getAlumniGender() %></td>
                        <td>
                            <a href='deletealumni?AlumniId=<%= aModel.getAlumniId() %>'>
                                <img width="30" height="30" src="https://img.icons8.com/dusk/64/delete-forever.png" alt="delete-forever" />
                            </a>
                        </td>
                        <td>
                            <a href='updatealumni?AlumniId=<%= aModel.getAlumniId() %>'>
                                <img width="30" height="30" src="https://img.icons8.com/dusk/64/edit--v1.png" alt="edit--v1" />
                            </a>
                        </td>
                    </tr>
                    <%
                    }}
                    else{
                    	%>
                    	<h3 class="text-center">No Alumni Found</h3>
                    	<%
                    }
                    %>
                </tbody>
            </table>
        </div>
	</div>
	
	
	
</div>
</div>
</div>
</body>
</html>