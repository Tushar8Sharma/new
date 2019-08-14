<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Form</title>
<script type="text/javascript">
function ConfirmDelete() {
	  return confirm("Are you sure you want to delete?");
	}
</script>
</head>
<body>

<div align="center">

	<c:if test="${msg ne null}">
		<h3 style="color:green;font-style:italic;">${msg}</h3>
	</c:if>

	<h1>View Products</h1>
	<table border="1">
		<tr>
			<th>Product Name</th>
			<th>Product Desc</th>
			<th colspan="2">Admin Operations</th>
		</tr>
		<c:forEach items="${products}" var="p">	
			<tr>
				<td>${p.productName}</td>
				<td>${p.prodesc}</td>
				<td><a href="${pageContext.request.contextPath}/deleteProduct/${p.productId}">Delete</a></td>
				<td><a href="${pageContext.request.contextPath}/updateProduct/${p.productId}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
	
</body>
</html>