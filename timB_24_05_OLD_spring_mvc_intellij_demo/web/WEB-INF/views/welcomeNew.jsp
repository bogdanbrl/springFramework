<%--
  Created by IntelliJ IDEA.
  User: tim
  Date: 9/05/2017
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Welcome!</title>
  </head>
  <body>
    <c:forEach var="messageitem" items="${myWelcomeMessage}">
        <c:out value="${messageItem}"></c:out>
    </c:forEach>
  </body>
</html>
