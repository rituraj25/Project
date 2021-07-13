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
<h1>product</h1>
<form:form>
<table>
	<tr>
		<th>Id</th>
		<th>Name </th>
		<th>Price</th>
	</tr>
	<c:forEach items="${ product}" var="p">
		<tr>
			<td>"${p.id }"</td>
			<td>"${p.name }"</td>
			<td>"${p.price }"</td>
		</tr>
	</c:forEach>

</table>


</form:form>
<a href="${pageContext.request.contextPath }/addproduct">
<input type ="button" value="add">
</body>
</html>