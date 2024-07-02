	<%@include file="AdminMain.jsp"%>
	
	<div class="col-12 d-flex align-items-center justify-content-center">
		<div class="row border rounded-3 shadow-sm ms-4 mt-5" style="min-height : 20vh;">
		<div class="row">
			<div class="col-12 d-flex align-items-center justify-content-center mt-4">
			<h3 class="text-warning">Branch</h3>
			</div>
		</div>
		<div>
			<form name="frm" action="addnewbranch" method="post">
					
					<div data-mdb-input-init class="form-outline mx-5 mt-4">
						<label class="form-label" for="firstName">New Branch Name</label> 
						<input type="text" name="branchName" value="" class="form-control" />
					</div>
					<div class="row form-check mt-2">
						<div class="d-flex  justify-content-center ">
							<input type='hidden' name='cId' value='<%=CollegeId %>'/>
						</div>
					</div>
				<div class="mt-4 d-flex align-items-center justify-content-center mb-5">
                    <button type="submit" class="btn btn-outline-primary ms-4">Submit</button>
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