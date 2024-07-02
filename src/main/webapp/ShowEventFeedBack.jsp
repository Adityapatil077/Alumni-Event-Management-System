<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<!-- </body> -->
<!-- </html> -->
 <%@page import="org.alumnievent.service.*,org.alumnievent.model.*,java.util.*"%>

<%@include file="OrgnizerMain.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int EventId=Integer.parseInt(request.getParameter("EventId"));%>
 <main class="content px-3 py-4">
                <div class="container">
                    <div class="mb-3">
                        <h3 class="fw-bold fs-4 mb-3">FeedBack</h3>
                        <div class="row">
                            <div class="col-12">
                                <table class="table table-striped">
                                    <thead>
                                        <tr class="highlight">
                                            <th scope="col">Sr no</th>
                                            <th scope="col">Alumni Name</th>
                                            <th scope="col">FeedBack</th>
                                            
                                       </tr>
                                    </thead>
                                    <tbody>

         
     <%EventService eService=new EventServiceImpl();
     List<Object[]> list=eService.showCollegeEventFeedBack(EventId);
          int count=0;
		for(Object Obj[]:list)
		{
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
                        </div>
                    </div>
                </div>
            </main>
</body>
</html>