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
	<form:form method="GET" action="${ contextPage.request.contextPath }/user/order">
		<table>
			<tr> 
				<th>Product id </th>
				<th>Price</th>
			</tr>
			<c:forEach items="${cart.lineItem }" var="list">
				
					<c:if test="${list.status ==false}">
					<tr>
					<td>${list.lineProduct.name }</td>
					<td>${list.price} </td>
				</tr></c:if>
			</c:forEach>
			
				</table>
				<input type="submit" value ="Order">
	</form:form>
</body>
</html>