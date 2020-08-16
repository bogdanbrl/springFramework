<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List organizations using a Service</title>
</head>
<body>

	<h1>List organizations using a Service</h1>
	<c:forEach var="row" items="${orgList}">
		Name: ${row.companyName} <br />
		Year: ${row.yearOfIncorporation} <br />
		Zip: ${row.postalCode} <br />
		Emp Count: ${row.employeeCount} <br />
		Slogan: ${row.slogan} <br />
		<br />
	</c:forEach>

</body>
</html>