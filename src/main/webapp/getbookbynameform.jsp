<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details Form</title>
</head>
<body>
	<h1>Get Book Using Form</h1>
	<form method="post"
		action="/springwebmvcannotationexample-0.0.1-SNAPSHOT/bookapp/getbookbyname">
		<label for="bookName">Book Name:</label> <input type="text" name="bookName"
			id="bookName" required /> <br /> <input type="submit" value="Submit" />
	</form>
</body>


</body>
</html>