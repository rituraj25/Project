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

<form:form >
	<table >
		<tr>
			<th>Name </th>
			<th>Price </th>
		</tr>
		<c:forEach items="${ product}" var="a">
			<tr>
			<td>${a.name }</td>
			<td>${a.price }</td>
			<td></td>
			</tr>
		</c:forEach>
	</table>
</form:form>
<form:form>
	<table >
		<tr>
			<th>Name </th>
		</tr>
		<c:forEach items="${ product}" var="a">
			<tr>
			<td>${a.subCategory.category.name }</td>
			<td></td>
			</tr>
		</c:forEach>
	</table>
</form:form>
</body>
</html>