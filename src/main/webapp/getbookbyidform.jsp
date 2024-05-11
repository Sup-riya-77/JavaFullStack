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
		action="/springwebmvcannotationexample-0.0.1-SNAPSHOT/bookapp/getbookbyid">
		<label for="bookId">Book Id:</label> <input type="text" name="bookId"
			id="bookId" required /> <br /> <input type="submit" value="Get Book" />
	</form>
	<h2>Book details:</h2>
	<p>Book ID: ${book.bookId}</p>
	<p>Title: ${book.bookName}</p>
	<p>Publisher: ${book.publisher}</p>
	<p>Price: ${book.price}</p>
</body>


</body>
</html>