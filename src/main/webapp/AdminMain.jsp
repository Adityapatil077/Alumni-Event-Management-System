
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "org.alumnievent.service.*, org.alumnievent.model.* , java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
 <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/Dashboardstyle.css">
    <style type="text/css">
   
</style>
</head>

<body>
<%! CollegeModel cModel;%>
<%! int CollegeId; %>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("email")==null)
		{
			response.sendRedirect("AdminLogin.jsp");
		}else{
			CollegeId = Integer.parseInt(session.getAttribute("AdminId").toString());
			CollegeService collService = new CollegeServiceImpl();
			cModel = collService.getAdminProfile(CollegeId); 	
		}
	%>
    
     <div class="wrapper" >
        <aside id="sidebar" class="expand">
            <div class="d-flex">
                <button class="toggle-btn" type="button">
                    <i class="lni lni-grid-alt"></i>
                </button>
                <div class="sidebar-logo">
<%--                     <a href="Dashboard.jsp"><%=cModel.getCollegeName()%></a> --%>
                </div>
            </div>
            <ul class="sidebar-nav">
                <li class="sidebar-item">
                    <a href="AdminProfile.jsp" class="sidebar-link">
                    <img width="30" height="30" src="https://img.icons8.com/dusk/64/gender-neutral-user--v1.png" alt="gender-neutral-user--v1"/>
                        <span>Profile</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a href="AlumniInfo.jsp" class="sidebar-link">
                    <img width="30" height="30" src="https://img.icons8.com/color/48/student-female.png" alt="student-female"/>
                        <span>Alumni</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a href="OragnizerInfo.jsp" class="sidebar-link">
                        <img width="30" height="30" src="https://img.icons8.com/dusk/64/planner.png" alt="planner"/>
                        <span>Organizer</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a href="AllEvent.jsp" class="sidebar-link">
                        <img width="30" height="30" src="https://img.icons8.com/color/48/dancing-party--v1.png" alt="dancing-party--v1"/>
                        <span>Events</span>
                    </a>

                </li>

 				<li class="sidebar-item">
                    <a href="#" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
                        data-bs-target="#auth" aria-expanded="false" aria-controls="auth">
                       <img width="30" height="30" src="https://img.icons8.com/arcade/64/checked-user-male.png" alt="checked-user-male"/>
                        <span>Attendance</span>
                    </a>
                    <ul id="auth" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
                        <li class="sidebar-item">
                            <a href="MarkAttendance.jsp" class="sidebar-link">Mark Attendance</a>
                        </li>
                        <li class="sidebar-item">
                            <a href="ViewAlumniAsPerEvent.jsp" class="sidebar-link">View Alumni as Per Event</a>
                        </li>
                    </ul>
                </li>
<!-- 		comment -->
                <li class="sidebar-item">
                    <a href="ViewCollegeEventFeedback.jsp" class="sidebar-link">
                        <img width="32" height="32"
						src="https://img.icons8.com/external-anggara-filled-outline-anggara-putra/32/external-feedback-bubble-chat-anggara-filled-outline-anggara-putra.png"
						alt="external-feedback-bubble-chat-anggara-filled-outline-anggara-putra" />
                        <span>Feedbacks</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a href="#" class="sidebar-link">
                        <img width="30" height="30" src="https://img.icons8.com/3d-fluency/94/gear--v2.png" alt="gear--v2"/>
                        <span>Setting</span>
                    </a>
                </li>
            </ul>
            <div class="sidebar-footer">
                <a href="adminlogout" class="sidebar-link">
                    <img width="30" height="30" src="https://img.icons8.com/cute-clipart/64/open-pane.png" alt="open-pane"/>
                    <span class="ms-1">Logout</span>
                </a>
            </div>
        </aside>
    	<div class="main bg-img" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
    <script src="JS/script.js"></script>
    
    </body>

</html>