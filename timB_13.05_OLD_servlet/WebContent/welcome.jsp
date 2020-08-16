<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salut!!!</title>
</head>
<body>

	<%
	String messages[] = (String []) request.getAttribute("myWelcomeMessage");
	String welcomeMessage = "";
	for(String msg : messages){
		welcomeMessage += msg + " ";
	}
	out.print(welcomeMessage);
	%>

</body>
</html>