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
<%-- <script type="text/javascript">
  function searchMyEvents()
  {
	  let xhttp =new XMLHttpRequest();
	  
	  var k=document.getElementById("searchevent").value;
	  
	  var collegeId = "<%= request.getParameter("collegeid") %>";
	 
	  xhttp.onreadystatechange=function()
	  { 
		  if(this.readyState=== 4 && this.status === 200)
			  {
			  
			  document.getElementById("eventresult").innerHTML=this.responseText;
			  }
		  
	  };
	  xhttp.open("GET","SearchEvents.jsp?collegeid=" + collegeId + "&k=" + k,true);
	  xhttp.send();
  }
</script> --%>
<%@include file="OrgnizerMain.jsp"%>
	
	 <main class="content px-3 py-4">
                <div class="container-fluid">
                    <div class="mb-3">
                        <h3 class="fw-bold fs-4 mb-3">Show FeedBack as per Event</h3> 
               <!--          <div style="text-align: right;">
				<input type="search" id="searchevent" placeholder="Search College..."
					style="display: inline-block; width: 250px; height: 40px;"
					onkeyup="searchMyEvents()"value=''>
				<button type="button"
					style="display: inline-block; font-size: 20px;">&#128269;</button>
			</div> -->
			<br/>
                        <div id="eventresult">
                        <div class="row">
                            <div class="col-12 border border-2 rounded bg-light p-3">
                                <table class="table table-striped">
                                    <thead>
                                        <tr class="highlight">
                                            <th scope="col">Sr no</th>
                                            <th scope="col">Event Name</th>
                                            <th scope="col">Branch Name</th>
                                            <th scope="col">Event Venue</th>
                                            <th scope="col">Event Description</th>
                                             <th scope="col">Event Date</th>
                                               <th scope="col">Show Feedback</th>
                                       </tr>
                                    </thead>
                                    <tbody>

          <%
          int collegeId = Integer.parseInt(request.getParameter("collegeid").toString()); 
          int OrganizerId = Integer.parseInt(session.getAttribute("organizerId").toString());
          EventService eServ=new  EventServiceImpl();
          List <EventModel> list=eServ.ShowOrganizerEvents(collegeId, oragnizerId);
		int count=0;
		for(EventModel model:list)
		{
	    %>	
	      <td><%=++count%></td>
	     <td><%=model.getEventName() %></td>
	          <%
	          BranchService bService=new BranchServiceImpl();
	          int branchId=model.getBranchId();
	          String BranchName=bService.getBranchNameById(branchId, collegeId);
	          %>
	     <td><%=BranchName%></td>  
	     <td><%=model.getVenue() %></td>
	     <td><%=model.getDescription() %></td>
	     <td><%=model.getDate() %></td>
	     <td><a href="ShowEventFeedBack.jsp?EventId=<%=model.getEventId()%>">Show FeedBack</a></td>
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
                </div>
            </main>

            </div>
            </div>
            </div>
</body>
</html>