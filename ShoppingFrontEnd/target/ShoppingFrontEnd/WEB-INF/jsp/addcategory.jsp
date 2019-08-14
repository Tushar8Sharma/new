<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<fieldset>
	<legend>${frmLabel}</legend>
	<form:form action="${pageContext.request.contextPath}/add" method="post" modelAttribute="category">
		<table>	
			<c:if test="${category.categoryId ne 0}">
				<tr>	
					<td>id</td>
					<td><form:input path="categoryId"/>
				</tr>
			</c:if>
			<tr>	
				<td>category</td>
				<td><form:input path="categoryName"/>
			</tr>
			<tr>	
				<td>description</td>
				<td><form:input path="description"/>
			</tr>
			<tr>
			<td><input type ="submit" value="${btnLabel}"/></td>
			</tr>
		</table>
	</form:form>
</fieldset>
</body>
</html>