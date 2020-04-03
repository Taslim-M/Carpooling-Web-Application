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
        <h1> Confirmed Passengers list </h1>
        
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            
            </tr>
            <tr bgcolor="#0EB39C">
                <td><b>Passenger ID</b></td>
                <td><b>First Name</b></td>
                <td><b>Last Name</b></td>
                <td><b>Gender</b></td>
                <td><b>Mobile Number</b></td>

            </tr>
            


                
            <c:forEach items="${Passengers}" var = "passenger" >
                <tr bgcolor="#E2FFFB">
                    <td>${passenger.emailID}</td>
                    <td>${passenger.firstName}</td>
                    <td>${passenger.lastName}</td>
                    <td>${passenger.gender}</td>
                    <td>${passenger.mobileNumber}</td>
               
                </tr>
            </c:forEach>

        </table>




    </body>
</html>