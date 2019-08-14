<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
	<c:if test="${msg ne null}">
		<h3 style="color:green;font-style:italic;">${msg}</h3>
	</c:if>
	<h2 align="center"><a href="new">Add New Item</a></h2>
	<h2 align="center"><a href="viewall">View All Items</a></h2>
	<h2 align="center"><a href="addProduct">Add Product</a></h2>
	<h2 align="center"><a href="viewProducts">View All Products</a></h2>
</body>
</html>