<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Error</title>
 
</head>
<body>
 
 
   <div class="page-title">Access Denied!</div>
  
   <h3 style="color:red;">Cant delete.</h3>
   
   	<a href="${pageContext.request.contextPath}/deleteCategoryAndUpdateProduct/${catId}">Continue to Delete</a>
</body>
</html>