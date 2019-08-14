<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Spring Web MVC project</title>
</head>

<body>
	<c:if test="${msg ne null}">
		<h3 style="color:green;font-style:italic;">${msg}</h3>
	</c:if>
	<c:if test="${msg2 ne null}">
		<h3 style="color:red;font-style:italic;">${msg2}</h3>
	</c:if>
    <h1>All Items</h1>
    <c:if test="${not empty lists}">
	    <c:forEach items="${lists}" var="lists">
	    <tr>
	     <br>
         <td>${lists.categoryId}</td>
         <td>${lists.categoryName}</td>
         <td>${lists.description}</td>
         <td><a href="${pageContext.request.contextPath}/updateCategory/${lists.categoryId}">Update</a></td>
		 <td><a href="${pageContext.request.contextPath}/deleteCategory/${lists.categoryId}">Delete</a></td>
     </tr>
</c:forEach>
</c:if>
</body>

	