<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details Form</title>
</head>
<body>
	<h1>Welcome To SPring Web MVC Book Store</h1>
	<form action="/springwebmvcannotationexample-0.0.1-SNAPSHOT/bookapp/createbook"
		method="post">
		<label for="bookName">Book Name:</label> <input type="text"
			id="bookName" name="bookName"><br> <label
			for="publisher">Publisher:</label> <input type="text" id="publisher"
			name="publisher"><br> <label for="price">Price:</label>
		<input type="text" id="price" name="price"><br> <input
			type="submit" value="Submit">
	</form>


</body>
</html>