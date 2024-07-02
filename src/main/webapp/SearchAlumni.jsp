<%-- <%@include file="AdminMain.jsp"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="org.alumnievent.service.*, org.alumnievent.model.* , java.util.*"%>
<%
int BranchId = Integer.parseInt(request.getParameter("BranchId"));
int CollegeId = Integer.parseInt(request.getParameter("CollegeId"));
String Search = request.getParameter("name");
%>
<div class="mt-4" style="border: 2px solid black; border-radius: 20px;">
	<table class="table mt-4 my-3 text-light text-centre">
		<thead>
			<tr>
				<th scope="col">Sr.No</th>
				<th scope="col">NAME</th>
			</tr>
		</thead>
		<tbody>
			<%
			AlumniService alumniService = new AlumniServiceImpl();
			List<AlumniModel> list = alumniService.getAlumniBySearch(CollegeId, BranchId, Search);
			int count = 0;
			if (list.size() > 0) {
				for (AlumniModel aModel : list) {
			%>
			<tr>
				<th scope="row"><%=++count%></th>
				<td><%=aModel.getAlumniName()%></td>
				<td><button class="btn btn-danger" id="b"
						onclick="takeAttendance('<%=aModel.getAlumniId()%>',this)">Attendance</button></td>
			</tr>
			<%
			}
			} else {
			out.println("<h1>Alumni is Not Present</h1>");
			}
			%>
		</tbody>
	</table>
</div>