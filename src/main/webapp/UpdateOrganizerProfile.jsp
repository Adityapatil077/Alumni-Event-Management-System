<%@include file="OrgnizerMain.jsp"%>
	
<div class="main bg-img">
	<main class="content px-3 py-4">
	
	 <main class="content px-3 py-4">
                <div class="container-fluid">
                    <div class="mb-3 text-center">
                        <h3 class="fw-bold fs-4 mb-3 text-light">Hey <%=oModel.getOrganizerName()%> You Can Update Your Profile Here</h3>
                        
                     <%int oraId = Integer.parseInt(session.getAttribute("organizerId").toString());%>
                                    
                        <div class="row">
                            <div class="col-12 border border-2 mt-1 bg-light p-4">
                                <div class="text-center">
                                 <form action="uodateorg" method="Post">
                                   <br/><br/>
                                   <div class="form-group">
                                   <label for="exampleInputEmail1">Enter Contact</label>
                                  <input type="text"name="contact"value="" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                                  </div>
                                  <br/><br/>
                                  <div class="form-group">
                                  <label for="exampleInputEmail1">Enter Address</label>
                                   <input type="text"name="Address"value="" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                                   </div>
                                   <br/>
                                   <div class="form-group">
                                   <input type="hidden"name="oraId"value="<%=oraId%>"id="exampleInputEmail1" aria-describedby="emailHelp" required>
                                   </div>
                                   <div class="form-group">
                                   <button type="submit" class="btn btn-info ">Update Profile</button> 
                                    </div>
                                    </form>
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