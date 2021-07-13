<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hi</h1>

<form:form methodAttribute="product" action="${pageContext.request.contextPath }/addpro">
	<tr>
	<td>Product Name : </td>
	<td><input type="text" path="${ product.name}">
	</tr>
	<tr>
	<td>Price :</td>
	<td><input type="number" path="${ product.price}">
	</tr>
	<input type="submit" value="add">
</form:form>

</body>
</html>