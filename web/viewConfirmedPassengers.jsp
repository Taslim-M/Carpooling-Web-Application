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
        <title>Confirmed Rides</title>
    </head>
    <body>
        <h1 style = "font-family: avenir; color : #9B1B1B " align = "center" > Confirmed Passengers list </h1>
        
        <table align="center" cellpadding="5" cellspacing="0" border="1">
            <tr>

            
            </tr>
            <tr bgcolor="#E9E9E9">
                <td><b><font style = "font-family: avenir" >Passenger ID</font></b></td>
                <td><b><font style = "font-family: avenir" >First Name</font></b></td>
                <td><b><font style = "font-family: avenir" >Last Name</font></b></td>
                <td><b><font style = "font-family: avenir" >Gender</font></b></td>
                <td><b><font style = "font-family: avenir" >Mobile Number</font></b></td>

            </tr>  
            <c:forEach items="${Passengers}" var = "passenger" >
                <tr bgcolor="#FFFFFF">
                    <td><font style = "font-family: avenir" >${passenger.emailID}</font></td>
                    <td><font style = "font-family: avenir" >${passenger.firstName}</font></td>
                    <td><font style = "font-family: avenir" >${passenger.lastName}</font></td>
                    <td><font style = "font-family: avenir" >${passenger.gender}</font></td>
                    <td><font style = "font-family: avenir" >${passenger.mobileNumber}</font></td>
               
                </tr>
            </c:forEach>

        </table>




    </body>
</html>