<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  --%>
<%@page import= "org.alumnievent.service.*, org.alumnievent.model.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type='text/javascript'>
    function searchMyCollege(str){
    	let xhttp= new XMLHttpRequest();
    	var s=document.getElementById('searchcollege').value;
    
    	xhttp.onreadystatechange = function(){
    		if(this.readyState == 4 && this.status == 200)
    			{
    			
    			document.getElementById('searchmycollege').innerHTML =this.responseText;
    			}
    	};
    	xhttp.open("GET","ShowOrganizerFeedbackSearch.jsp?s="+s,true);
    	xhttp.send();
    } 
</script> -->
</head>
<body>
  
 <%@include file="OrgnizerMain.jsp"%>
	
	 <main class="content px-3 py-4">
                <div class="container-fluid">
                    <div class="mb-3">
                        <h3 class="fw-bold fs-4 mb-3">See FeedBacks Of College Event</h3>
            <!--             <div style="text-align: right;">
				<input type="search" id="searchcollege" placeholder="Search College..."
					style="display: inline-block; width: 250px; height: 40px;"
					onkeyup="searchMyCollege()"value=''>
				
				<button type="button"
					style="display: inline-block; font-size: 20px;">&#128269;</button>
			</div> -->
		        <br>
		        <div id="searchmycollege">
		       
                        <div class="row">
                            <div class="col-12 border border-2 rounded bg-light p-3">
                                <table class="table table-striped">
                                    <thead>
                                        <tr class="highlight">
                                            <th scope="col">Sr no</th>
                                            <th scope="col">College Name</th>
                                            <th scope="col">College Email</th>
                                            <th scope="col">College Contact</th>
                                             <th scope="col">College Address</th>
                                             <th scope="col">Show Event Feedbacks</th>
                                       </tr>
                                    </thead>
                                    <tbody>

          <%
         
          
          int OrganizerId = Integer.parseInt(session.getAttribute("organizerId").toString());
          OragnizerService service=new  OragnizerServiceImpl();
          List <CollegeModel> list=service.getcoleveOrganizedByOrganizer(OrganizerId);
		
		int count=0;
		
		for(CollegeModel model:list)
		{
	    %>	
	      <td><%=++count%></td>
	     <td><%=model.getCollegeName() %></td>
	     <td><%=model.getCollegeEmail() %></td>
	     <td><%=model.getCollegeContact() %></td>
	     <td><%=model.getCollegeAddress() %></td>
	    <% 
	    int collegeid= model.getCollegeId();
	    %>
     <td><a href="ShowFeedBackToOrganizer.jsp?collegeid=<%=collegeid%>">Show Event FeedBacks</a></td>
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
