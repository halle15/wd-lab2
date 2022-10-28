<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/main.css">
</head>
<body>
	<h1>Are you sure you want to delete this product?</h1>

	<table>
		<tr><td><b>Code:</b></td><td>${product.code}</td></tr>
		<tr><td><b>Description:</b></td><td>${product.description}</td></tr>
	    <tr><td><b>Price:</b></td><td>${product.price}</td></tr>
	</table>
	
	
	
	<form action="GetProducts" method="post">
        <input type="submit" value="Yes" />
        <input type="hidden" id="delete" name="delete" value="1" />
     	<input type="hidden" id="code" name="code" value="${product.code}" />
     	<input type="hidden" id="description" name="description" value="${product.description}" />
     	<input type="hidden" id="price" name="price" value="${product.price}" />
    </form>
    <form action="GetProducts" method="get">
        <input type="submit" value="No" />
    </form>
</body>
</html>