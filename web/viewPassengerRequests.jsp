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
        <title>Passenger Requests</title>
    </head>
    <body>
        <c:if test="${empty sessionScope.driver}" >
            <jsp:include page="navbarPassenger.html"/>
        </c:if> 
        <c:if test="${! empty sessionScope.driver}" >
            <jsp:include page="navbar.html"/>
        </c:if> 
        <div class ="container h-100">
        <h1 style = "font-family: avenir; color : #9B1B1B " align = "center" > Passengers for Selected Ride </h1>
        <div class="table-responsive">
        <table class="table table-hover" align="center" cellpadding="5" cellspacing="0" border="1">
            <thead class="thead-dark">
            
            <tr bgcolor="#E9E9E9">
                <th align = "center"><b><font style = "font-family: avenir" >Ride_ID</font></b></td>
                <th align = "center"><b><font style = "font-family: avenir" >Passenger_ID</font></b></td>
                <th align = "center"><b><font style = "font-family: avenir" >Pickup Location</font></b></td>
                <th align = "center"><b><font style = "font-family: avenir" >Dropoff Location</font></b></td>
                <th align = "center"><b><font style = "font-family: avenir" >View Passenger Information</font></b></td>
                <th align = "center"><b><font style = "font-family: avenir" >Action</font></b></td>

            </tr> 
            </thead>
            <tbody>
            <c:forEach items="${Requests}" var = "request" >
                <tr bgcolor="#FFFFFF">
                    <td align = "center"><font style = "font-family: avenir" >${request.requested_ride_id}</font></td>
                    <td align = "center"><font style = "font-family: avenir" >${request.passengerid}</font></td>
                    <td align = "center"><font style = "font-family: avenir" >${request.pickupLocation}</font></td>
                    <td align = "center"><font style = "font-family: avenir" >${request.dropoffLocation}</font></td>
                    <td align = "center"><form action="ViewPassengerInfoController" target="_blank"><input type = "hidden" name = "passengerid" value = ${request.passengerid} ><input type="submit" value= "View" class="btn btn-info"></form></td>
                    <td align = "center"><form action="PassengerActionController"><input type = "hidden" name = "passengerid" value = ${request.passengerid} ><input type = "hidden" name = "passengerstatus" value = ${request.confirmationbutton} ><input type = "hidden" name = "rideid" value = ${request.requested_ride_id} ><input type="submit" class= "btn btn-primary" value= ${request.confirmationbutton} ></form></td>
               

                </tr>
            </c:forEach>
            </tbody>
           
        </table>
        </div>


        <form action="ViewOfferedRidesController" align = "center"><input type="submit" value="Go Back to Ride List" class="btn btn-secondary"></form>
        
        </div>

    </body>
</html>