<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SubCategory</title>
</head>
<body>
<h1>SubCategory</h1>

<form:form action ="productlist" >
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Link</th>
			
		</tr>
		<c:forEach items="${ subCat}" var="sub">
			<tr>
				<td>"${sub.id}"</td>				
				<td>"${sub.name }"</td>
				<td>"${sub.category.name }"</td>
				<td><a href="${pageContext.request.contextPath }/productlist/${sub.id}">Link</a></td>
			</tr>
		
		</c:forEach>
	</table>


</form:form>
<a href="${pageContext.request.contextPath }/addSubcategory/${ cat_id}">
<input type="submit" value ="add Subcategory"></a>
</body>
</html>