
<%@page
	import="org.alumnievent.service.*,org.alumnievent.model.*,java.util.*"%>
<%@include file="AdminMain.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int EventId = Integer.parseInt(request.getParameter("EventId"));
	%>
	<main class="content px-3 py-4">
		<div class="container">
			<div class="mb-3">
				<h3 class="fw-bold fs-4 mb-3 text-center text-warning">View Present Alumni</h3>

				<div class="mt-4 mx-5 border  p-3 rounded bg-light"
					style="max-height: 80vh; overflow-y: auto; position: relative;">
					<table
						class="table table-striped text-light table-fixed text-center">
						<thead class="table-dark text-center"
							style="position: sticky; top: 0">
							<tr class="highlight">
								<th scope="col">Sr. No</th>
								<th scope="col">Name</th>
								<th scope="col">Email</th>
								<th scope="col">Contact</th>
								<th scope="col">Passout Year</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<%
							AlumniService aServ = new AlumniServiceImpl();
							List<AlumniModel> list = aServ.getSortedAlumniByYear(EventId);
							int count = 0;
							for (AlumniModel am : list) {
							%>
							<td><%=++count%></td>
							<td><%=am.getAlumniName()%></td>
							<td><%=am.getAlumniEmail()%></td>
							<td><%=am.getAlumniContact()%></td>
							<td><%=am.getPassOutYear()%></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>
</html>