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
<body align="center">
<h1>This is Login page </h1>
<form:form method="POST" modelAttribute="user" action="${ pageContext.request.contextPath }/validate">
	<table>
		<tr>
			<th>UserName :</th>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<th>Password :</th>
			<td><form:input path="password"/></td>
		</tr>
	</table>
	<input type="submit" value="login">
</form:form>
</body>
</html>


