<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Maintenance</title>
<link rel="stylesheet" href="styles/main.css">
</head>

<body>


<h1>Edit Product</h1>

<form action="GetProducts?st=0" method="post">
    <label for="code">Code:</label><input type="text" name="code" size="10" value="${product.code}"/> <br />
    <label for="description">Description:</label><input type="text" name="description" size="50" value="${product.description}"/> <br />
    <label for="price">Price:</label><input type="text" name="price" size="10" value="${product.price}"/> <br />
    <input type="hidden" id="delete" name="delete" value="0" />
    <input type="submit" value="Update Product" />
</form>

<form action="GetProducts">
    <input type="submit" value="View Products"/>
    <input type="hidden" id="st" name="st" value="0">
</form>



</body>
</html>