<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Franklin Music - Search Results</title>
<link rel="stylesheet" href="styles/main.css">

</head>


<body>
	<h1>Search Results</h1>
	
	
<table>
	<tr>
        <th style="width:75px">Code</th>
        <th style="width:500px">Description</th>
        <th style="width:75px;text-align:right">Price</th>
        <th></th>
    </tr>
    
    
    <c:forEach items="${entry}" var = "i">
    <tr>
        <th style="width:75px">${i.value.code}</th>
        <th style="width:500px">${i.value.description}</th>
        <th style="width:75px;text-align:right">${i.value.getPriceCurrencyFormat()}</th>
        <th>
        	<form action="getCart" method="post">
        		<input type="submit" value="Add To Cart">
        		<input type="hidden" value="a" id="mode" name="mode">
        		<input type="hidden" value="${i.value.code}" id="code" name="code">
        		<input type="hidden" value="${i.value.description}" id="description" name="description">
        		<input type="hidden" value="${i.value.price}" id="price" name="price">
        	</form>
        </th>
    </tr>
    </c:forEach>
    <tr>
      <td colspan="2"></td>
      <td>
      <form action="getCart" method="get">
           <input type="submit" value="View Cart"></input> <!-- I moved this and the back button around, looked nicer, needed back button in testing and works better anyways-->
      </form>
	</td>
       <td>
         <form action="/msl">
			<input type="submit" value="Back"/>
		</form>
      </td>
    </tr>
    
</table>








</body>
</html>