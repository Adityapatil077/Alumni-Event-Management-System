
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
		
				<h3 class="fw-bold fs-4 mb-3 text-center text-warning">FeedBack</h3>
				
					<div class="mt-4 mx-5 border  p-3 rounded bg-light"
						style="max-height: 80vh; overflow-y: auto; position: relative;">

						<table
							class="table table-striped text-light table-fixed text-center">
							<thead class="table-dark text-center"
								style="position: sticky; top: 0">
								<tr class="highlight">
									<th scope="col">#</th>
									<th scope="col">Alumni Name</th>
									<th scope="col">FeedBack</th>

								</tr>
							</thead>
							<tbody>
								<%
								EventService eService = new EventServiceImpl();
								List<Object[]> list = eService.showCollegeEventFeedBack(EventId);
								int count = 0;
								for (Object Obj[] : list) {
								%>
								<td><%=++count%></td>
								<td><%=Obj[0]%></td>
								<td><%=Obj[1]%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				
	</main>
</body>
</html>