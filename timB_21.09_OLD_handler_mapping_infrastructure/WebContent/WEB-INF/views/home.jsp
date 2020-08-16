<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Organization home page</title>
</head>
<body>

	<h1>Organization home page</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	<ul>
		<li><a href="${contextPath}/jstlsql">List organization using JSTL sql tags</a><br/></li>
		<li><a href="${contextPath}/jstlsql">Listing organization using Service</a></li>
	</ul>
	
</body>
</html>