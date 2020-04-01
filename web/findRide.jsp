<%-- 
    Document   : findRIde
    Created on : Apr 1, 2020, 7:35:50 PM
    Author     : Tasli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${empty sessionScope.username}" >
            <jsp:forward page="index.html" />
        </c:if>
        <h1>Hello ${sessionScope.username}! Find A Ride</h1>
    </body>
</html>
