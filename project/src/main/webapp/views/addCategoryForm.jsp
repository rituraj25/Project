<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
<h1>Add Category</h1>
<form:form method="POST" modelAttribute="category" action="${ pageContext.request.contextPath }/addCat">
	<table>
		<tr>
		<th>Category Name</th>
		<td><form:input path="name"/></td>
		<td><form:errors path="name"></form:errors></td>
		</tr>
	</table>
	<input type="submit" value="add">
</form:form>


</body>
</html>