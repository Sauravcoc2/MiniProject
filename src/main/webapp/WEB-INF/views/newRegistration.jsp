<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h2>New Registration</h2>
	<form action = "saveReg" method = "post">
	<pre>
		Name <input type = "text" name = "name"/>
		City <input type = "text" name = "city"/>
		E-mail <input type = "text" name = "email"/>
		Mobile <input type = "text" name = "mobile"/>
		<input type = "submit" value = "save"/>
	</pre>
	</form>
</body>
</html>