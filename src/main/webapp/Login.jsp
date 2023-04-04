<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login Here..</h2>
	<div>
		<%
			if(request.getAttribute("error") != null)
				out.println(request.getAttribute("error"));
		%>
	</div>
	<form action = "verifyLogin" method = "post">
		Username <input type = "text" name="email"/><br><br>
		Password <input type = "text" name="password"/><br><br>
		<input type = "submit" value = "login"/>
	</form>
</body>
</html>