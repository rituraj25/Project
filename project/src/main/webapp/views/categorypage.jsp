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
<a href="${ pageContext.request.contextPath}/addCategory">
<input type="submit" value="Add category" >
</a>

<form action="get"  modelAttribute="ctg">
	<table>
	<tr>
		<td>Id</td>
		<td>Category</td>
		
		</tr>
		<c:forEach var="a" items="${cat }">
	<tr>
	<td><c:out value="${a.id }"></c:out></td>
	<td><a href="${ pageContext.request.contextPath}/category/${a.id }"><c:out value="${a.name }"></c:out></a></td>
	<td><a href="${pageContext.request.contextPath }/deleteCategory/${a.id}")>Delete</a>
	</tr>
	</c:forEach>
	</table>
	

</form>
</body>
</html>