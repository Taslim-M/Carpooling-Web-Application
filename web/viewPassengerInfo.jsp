<%-- 
    Document   : ViewConfirmedRides
    Created on : Apr 2, 2020, 9:34:20 PM
    Author     : reem
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passenger Information</title>
    </head>
    
    <body>
        <c:forEach items="${Passengers}" var = "passenger" >
        <h1 style = "font-family: avenir; color : #9B1B1B" >Passenger Information</h1>
        <font style = "font-family: avenir" >Passenger ID: ${passenger.emailID}</font>
        <br/>
        <font style = "font-family: avenir" >First Name: ${passenger.firstName}</font>
        <br/>
        <font style = "font-family: avenir" >Last Name: ${passenger.lastName}</font>
        <br/>
        <font style = "font-family: avenir" >Gender: ${passenger.gender}</font>
        <br/>
        <font style = "font-family: avenir" >Mobile Number: ${passenger.mobileNumber}</font>
        <br/>
        </c:forEach>
    </body>
    
</html>