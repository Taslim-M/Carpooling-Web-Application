<%-- 
    Document   : CancelRideForm
    Created on : Apr 4, 2020, 1:35:49 AM
    Author     : reem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Redirected: Display Message</title>
    </head>
    <body>
    <c:if test="${empty sessionScope.driver}" >
        <jsp:include page="navbarPassenger.html"/>
    </c:if> 
    <c:if test="${! empty sessionScope.driver}" >
        <jsp:include page="navbar.html"/>
    </c:if> 
    <h1 style = "font-family: avenir; color : #9B1B1B "  align = "center" > ${Message} </h1>
    <form action="ViewPassengerRequestsController"  align = "center"><input type = "hidden" name = "rideid" value = ${Ride_ID} ><input type="submit" value = "Go Back to Passenger List" class="btn btn-secondary"></form>

    </body>
</html>
