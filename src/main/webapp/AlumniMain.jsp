
<%@page import="org.alumnievent.service.*"%>
<%@page import="org.alumnievent.model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alumni Dashboard</title>
<link href="https://cdn.lineicons.com/4.0/lineicons.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet" href="CSS/Dashboardstyle.css">

</head>

<body>

	<%!AlumniModel aModel;%>
	<%
	int AlumniId = Integer.parseInt(session.getAttribute("AlumniId").toString());

	AlumniService aService = new AlumniServiceImpl();
	aModel = aService.getAlumniProfile(AlumniId);
	%>
	<div class="wrapper">
		<aside id="sidebar" class="expand">
			<div class="d-flex">
				<button class="toggle-btn" type="button">
					<i class="lni lni-grid-alt"></i>
				</button>
				<div class="sidebar-logo">
					<a href="Dashboard.jsp">Alumni</a>
				</div>
			</div>
			<ul class="sidebar-nav">
				<li class="sidebar-item"><a href="ViewAlumniProfile.jsp"
					class="sidebar-link"> <img width="30" height="30"
						src="https://img.icons8.com/color/48/student-female.png"
						alt="student-female" /> <span class="ms-3">Profile</span>
				</a></li>
				<li class="sidebar-item"><a
					href="ViewAlumniAsPerBranchEvents.jsp" class="sidebar-link"> <img
						width="30" height="30"
						src="https://img.icons8.com/cute-clipart/64/today.png" alt="today" />
						<span class="ms-3">Show My Event</span>
				</a></li>
				<li class="sidebar-item"><a href="ViewAlumniAllEvent.jsp"
					class="sidebar-link"> <img width="30" height="30"
						src="https://img.icons8.com/cute-clipart/64/today.png" alt="today" />
						<span class="ms-3">College Event</span>
				</a></li>
				<li class="sidebar-item"><a href="FeedbackForm.jsp"
					class="sidebar-link"> <img width="32" height="32"
						src="https://img.icons8.com/external-anggara-filled-outline-anggara-putra/32/external-feedback-bubble-chat-anggara-filled-outline-anggara-putra.png"
						alt="external-feedback-bubble-chat-anggara-filled-outline-anggara-putra" />

						<span class="ms-3">Feedbacks</span>
				</a></li>
				<li class="sidebar-item"><a href="#" class="sidebar-link">
						<img width="30" height="30" src="https://img.icons8.com/3d-fluency/94/gear--v2.png" alt="gear--v2"/> <span class="ms-3">Setting</span>
				</a></li>
			</ul>
			<div class="sidebar-footer">
				<a href="adminlogout" class="sidebar-link"> 
				<img width="30" height="30" src="https://img.icons8.com/cute-clipart/64/open-pane.png" alt="open-pane"/>
				<span class="ms-3">Logout</span>
				</a>
			</div>
		</aside>
		<div class="main bg-img">
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
				crossorigin="anonymous"></script>
			<script src="JS/script.js"></script>
</body>