<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Franklin Music - Your Cart</title>
    <link href="styles/main.css" rel="stylesheet" />
</head>
<body>
    <h1>Your Cart</h1>
    <table>
        <tr>
            <th style="width:200px">Description</th>
            <th style="width:50px">Price</th>
            <th>Qty</th>
            <th></th>
        </tr>
    <c:forEach items="${entries}" var = "i">
    	<tr>
            <td style="width:200px">${i.value.product.description}</td>
            <td style="width:50px">${i.value.product.getPriceCurrencyFormat()}</td>
            <form action="getCart" method="post">
            	<td>
            		<input type="text" id="qty" name="qty" size="3" value="${i.value.qty}"></input>
            	</td>
            	<td>
            		<input type="submit" value="Update"></input>
            		<input type="hidden" name="code" id="code" value="${i.value.product.code}">
            		<input type="hidden" name="price" id="price" value="${i.value.product.price}">
            		<input type="hidden" name="description" id="description" value="${i.value.product.description}">
            		<input type="hidden" name="mode" id="mode" value="e">
            	</td>
            </form>
        </tr>
    </c:forEach>
		<tr class="no-border">
            <td>Total:</td>
            <td>${total}</td>
            <td colspan="2"></td>
        </tr>
        <tr class="no-border">
            <td align="right" colspan="3"><form action="GetProducts?st=1" method="get"><input type="submit" value="Continue Shopping"></input><input type="hidden" id="st" name="st" value="1"></form></td>
            <td><form><input type="submit" value="Checkout"></input></form></td>
        </tr>
        
   </table>
</body>
</html>