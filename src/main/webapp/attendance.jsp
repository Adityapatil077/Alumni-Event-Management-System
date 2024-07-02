<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
        $(document).ready(function(){
            $("input[type='radio']").change(function(){
                var alumniId = $(this).val();
                var attendanceStatus = $(this).attr("data-status");
                $.ajax({
                    url: "markAttendance",
                    method: "POST",
                    data: {alumniId: alumniId, attendanceStatus: attendanceStatus},
                    success: function(response){
                        console.log(response);
                    },
                    error: function(xhr, status, error){
                        console.error(error);
                    }
                });
            });
        });
    </script>
</head>
<body>
	<h2>Mark Attendance</h2>
    <form>
        <c:forEach items="${alumniList}" var="alumni">
            <input type="radio" name="alumniId" value="${alumni.id}" data-status="Present"> Present
            <input type="radio" name="alumniId" value="${alumni.id}" data-status="Absent"> Absent
            ${alumni.name}<br>
        </c:forEach>
    </form>
</body>
</html>