<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type='text/javascript'>
	function searchByName(str) {
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("d").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "searchbyname.jsp?n=" + str, true)
		xhttp.send();
	}
</script>
</head>
<body>
	<%!Connection conn;
	PreparedStatement stmt;
	ResultSet rs;%>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnieventmanagement", "root", "Aditya@2001");
	if (conn != null) {
		stmt = conn.prepareStatement("select *from colleges");
		rs = stmt.executeQuery();
	%>
	<center>
		<input type='text' name='name' value=''
			style='width: 90%; height: 50px;' onkeyup="searchByName(this.value)" />
	</center>
	<br>
	<br>

	<div id="d">
		<table border='5' align='center' width='60%'>
			<tr>
				<th>Employee id</th>
				<th>NAME</th>
				<th>Contact</th>
				<th>Salary</th>
			</tr>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getInt(4)%></td>

			</tr>
			<%
			}
			%>
		</table>
		<%
		} else {
		out.println("<h1>Database is not connected</h1>");
		}
		%>
	</div>

</body>
</html>