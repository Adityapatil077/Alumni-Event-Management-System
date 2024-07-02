<%-- <%@include file="AdminMain.jsp"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="org.alumnievent.service.*, org.alumnievent.model.* , java.util.*"%>
<%
int bid = Integer.parseInt(request.getParameter("search"));
int Id = Integer.parseInt(request.getParameter("cid"));
%>



	
		<div style="overflow-y: auto; height: 80vh;">
            <table class="table table-striped text-light text-center">
                <thead class="table-dark text-center" style="position: sticky; top: 0; z-index: 1;">
			<tr class="highlight">
				<th scope="col">Sr.No</th>
				<th scope="col">NAME</th>
				<th scope="col">Id No</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody class="text-center">
			<%
			AlumniService alumniService = new AlumniServiceImpl();
			List<AlumniModel> l = alumniService.getAlumniByEvent(Id, bid);
			int count = 0;
			if (l.size() > 0) {
				for (AlumniModel aModel : l) {
			%>
			<tr>
				<th scope="row"><%=++count%></th>
				<td><%=aModel.getAlumniName()%></td>
				<td><%=aModel.getAlumniId()%></td>

				<td><button class="btn btn-danger"
						onclick="takeAttendance('<%=aModel.getAlumniId()%>')">Attendance</button></td>

			</tr>
			<%

			}
			} else {
			%>
				<h2>No Alumni Present</h2>
			<%
			}
			%>
		</tbody>
	</table>
</div>

