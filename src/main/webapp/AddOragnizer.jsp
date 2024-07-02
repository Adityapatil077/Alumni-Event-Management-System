 	<%@include file="AdminMain.jsp"%>
	
	<div class="col-12 d-flex align-items-center justify-content-center">
		<div class="row border rounded-3 shadow-sm ms-4 mt-5 me-5 p-4" style="min-height : 40vh;">
		<div class="row">
			<div class="col-12 d-flex justify-content-center mt-0 ">
			<h3 class="text-warning">Fill Organizer Details</h3>
			</div>
		</div>
		<div class=" col-12 mt-4">
			<form name='frm' action="addneworagnizer" method="post">

              <div class="row">
                <div class="col-lg-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
                  <label class="form-label fs-5" for="firstName">Enter Name</label>
                    <input type="text" name="name" class="form-control"  required/>
                  </div>

                </div>
                <div class="col-lg-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
                  <label class="form-label fs-5" for="lastName">Enter Email</label>
                    <input type="email" name="email"  class="form-control" required/> 
                  </div>

                </div>
                <div class="col-lg-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
                  <label class="form-label fs-5" for="lastName">Enter Contact</label>
                    <input type="text" name="contact" class="form-control" required/> 
                  </div>

                </div>
                <div class="col-lg-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
                  <label class="form-label fs-5" for="lastName">Enter Address</label>
                    <input type="text" name="address" class="form-control" required/> 
                  </div>

                </div>
                <div class="col-lg-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
                  <label class="form-label fs-5" for="lastName">Enter Password</label>
                    <input type="text" name="password" class="form-control" required/> 
                  </div>

                </div>
                <div class="col-lg-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
					<div class="col-md-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
           
                    <input type="hidden" name="cId" value= '<%=CollegeId %>' /> 
                  </div>
                </div>
                </div>
              </div>
				<br>
              <div class="mt-2 text-center">
                <input data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg" type="submit" value="Submit" />
              </div>

            </form>
		</div>
		</div>
	</div>
	
	



	
</div>
</div>
</div>	
</body>
</html>