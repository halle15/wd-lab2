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
	<h1>Products</h1>
	<c:if test="${error == '1'}">
	ERROR!
	</c:if>
<table>

	<tr>
		<th style="width:75px">Code</th>
		<th style="width:500px">Description</th>
		<th style="width:75px;text-align:right">Price</th>
       <th></th>
       <th></th>
	</tr>
  
  <c:forEach items="${entry}" var = "i">
  <tr>
  	 <td>${i.key}</td>
     <td>${i.value.description}</td>
     <td style="text-align:right">${i.value.getPriceCurrencyFormat()}</td>
     <td><a href="EditProduct?key=${i.key}&description=${i.value.description}&price=${i.value.price}">Edit</a></td>
     <td>
     <form action="removeProduct" method="post">
     	<button name="code" value="${i.key}">Delete</button>
     	<input type="hidden" id="delete" name="delete" value="1" />
     	<input type="hidden" id="code" name="code" value="${i.value.code}" />
     	<input type="hidden" id="description" name="description" value="${i.value.description}" />
     	<input type="hidden" id="price" name="price" value="${i.value.price}" />
     </form>
  </tr>
  </c:forEach>

      
</table>
	<form action="EditProduct">
		<input type="submit" value="Add Product" />
	</form>
	<form action="/msl">
		<input type="submit" value="Back" />
	</form>

</body>
</html>