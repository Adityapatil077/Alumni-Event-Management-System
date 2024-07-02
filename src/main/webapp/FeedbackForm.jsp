<script type="text/javascript">
	function show()
	{
		let result = document.getElementById("d");
		result.innerHTML = "Thank you for Valueable Feedback";
		result.style.color = "green";
		result.style.fontSize = 16px;
	}
</script>
<%@page
	import="org.alumnievent.service.*, org.alumnievent.model.* , java.util.*"%>
<%@include file="AlumniMain.jsp"%>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f9fa;
}

.container {
	max-width: 600px;
	margin: 50px auto;
	background-color: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	font-weight: bold;
}
</style>

<div id="d"></div>
<div class="container">
	<h2 class="mb-4 fw-bold text-warning text-center">Feedback Form</h2>
	<form name='frm' action='getfeedback' method='POST'>
		<div class="form-group">
			<input type="hidden"
				class="form-control" id="email" name="email" value='<%=AlumniId%>'>
		</div>

		<div class="form-group">
			<label for="event">Select Event:</label> <select class="form-control"
				id="event" name="event" required>
				<%
				EventService eServ = new EventServiceImpl();
				List<EventModel> list = eServ.getEventsForFeedback(AlumniId);
				for (EventModel em : list) {
				%>
				<option value="<%=em.getEventId()%>"><%=em.getEventName()%></option>
				<%
				}
				%>
			</select>
		</div>

		<div class="form-group">
			<label for="rating">Event Rating:</label> <select
				class="form-control" id="rating" required>
				<option value="">Select rating</option>
				<option value="5">Excellent (5 Stars)</option>
				<option value="4">Very Good (4 Stars)</option>
				<option value="3">Good (3 Stars)</option>
				<option value="2">Fair (2 Stars)</option>
				<option value="1">Poor (1 Star)</option>
			</select>
		</div>

		<div class="form-group">
			<label for="feedback">Feedback:</label>
			<textarea class="form-control" id="feedback" name="feedback" rows="4"
				placeholder="Enter your feedback"></textarea>
		</div>

		<button type="submit" class="btn btn-primary" onclick="show()">Submit Feedback</button>
	</form>

</div>

</body>
</html>
