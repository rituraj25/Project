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
<h1>Admin Orders View </h1>
<form:form>
	<table>
		<tr>
		<th>Id</th>
		<th>Status</th>
		<th>Picker</th>
		<th>Driver</th>
		</tr>
		<c:forEach items="${order }" var="order">
			<tr>
				<td><c:out value="${order.id }"></c:out></td>
				<td><c:out value="${order.status }"></c:out></td>
				<td><c:out value="${order.orderPicker }"></c:out></td>
				<td><c:out value="${order.orderDriver }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</form:form>
</body>
</html>