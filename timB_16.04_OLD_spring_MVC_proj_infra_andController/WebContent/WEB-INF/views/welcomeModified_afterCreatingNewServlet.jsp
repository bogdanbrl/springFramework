<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salut new servlet!!!</title>
</head>
<body>

	<c:forEach var="messageItems" items="${myWelcomeMessage}">
		<c:out value="${messageItems}"></c:out>
	</c:forEach>

</body>
</html>