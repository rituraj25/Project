<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<a href ="${pageContext.request.contextPath }/user/cart" >CArt</a>
<form:form method="Get"  >
	<table >
		<tr>
			<th>Name </th>
			<th>Price </th>
		</tr>
		<c:forEach items="${ product}" var="a">
			<tr>
			<td>${a.name }</td>
			<td>${a.price }</td>
			<td><a href="${pageContext.request.contextPath }/user/addToCart/${a.id}")>Add</a></td>
			<td></td>
			</tr>
		</c:forEach>
	</table>
</form:form>
</body>
</html>