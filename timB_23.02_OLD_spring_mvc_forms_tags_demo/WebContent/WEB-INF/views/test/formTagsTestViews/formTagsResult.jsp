<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/test-main.css" var="testMainCSS"/>
<link href="${testMainCSS}" rel="stylesheet"/>

<title>Form Tags Test Result</title>
</head>
<body>

	<h1>Congratulations! You have registered your organization</h1>
	<h2>Details below...</h2>
	<hr/>
	<div style="margin-left:600px;width:auto">
		<h3>Organization Name: <b>${orgreg.orgName}</b></h3>
	</div>
	
</body>
</html>