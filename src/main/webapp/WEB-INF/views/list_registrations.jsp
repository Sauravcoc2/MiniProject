<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registrations</title>
</head>
<body>
	<h2>All Registrations</h2>
	<table border = "1">
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>E-mail</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
			ResultSet result = (ResultSet)request.getAttribute("result");
			while(result.next()){ %>
				<tr>
					<th><%=result.getString(1) %></th>
					<th><%=result.getString(2) %></th>
					<th><%=result.getString(3) %></th>
					<th><%=result.getString(4) %></th>
					<td><a href = "delete?email=<%=result.getString(3)%>">Delete</a></td>
					<td><a href = "update?email=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">Update</a></td>
				</tr>
			<% } %>
	</table>
</body>
</html>