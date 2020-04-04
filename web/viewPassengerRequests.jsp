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
        <h1 style = "font-family: avenir; color : #9B1B1B " align = "center" > Passengers for Selected Ride </h1>
        
        <table align="center" cellpadding="5" cellspacing="0" border="1">
            <tr>

            
            </tr>
            <tr bgcolor="#E9E9E9">
                <td align = "center"><b><font style = "font-family: avenir" >Ride_ID</font></b></td>
                <td align = "center"><b><font style = "font-family: avenir" >Passenger_ID</font></b></td>
                <td align = "center"><b><font style = "font-family: avenir" >Pickup Location</font></b></td>
                <td align = "center"><b><font style = "font-family: avenir" >Dropoff Location</font></b></td>
                <td align = "center"><b><font style = "font-family: avenir" >View Passenger Information</font></b></td>
                <td align = "center"><b><font style = "font-family: avenir" >Action</font></b></td>

                

            </tr>  
            <c:forEach items="${Requests}" var = "request" >
                <tr bgcolor="#FFFFFF">
                    <td align = "center"><font style = "font-family: avenir" >${request.requested_ride_id}</font></td>
                    <td align = "center"><font style = "font-family: avenir" >${request.passengerid}</font></td>
                    <td align = "center"><font style = "font-family: avenir" >${request.pickupLocation}</font></td>
                    <td align = "center"><font style = "font-family: avenir" >${request.dropoffLocation}</font></td>
                    <td align = "center"><form action="ViewPassengerInfoController" target="_blank"><input type = "hidden" name = "passengerid" value = ${request.passengerid} ><input type = "hidden" name = "rideid" value = ${request.requested_ride_id} ><input type="submit" value= "View" ></form></td>
                    <td align = "center"><form action="PassengerActionController"><input type = "hidden" name = "passengerid" value = ${request.passengerid} ><input type = "hidden" name = "passengerstatus" value = ${request.confirmationbutton} ><input type = "hidden" name = "rideid" value = ${request.requested_ride_id} ><input type="submit" value= ${request.confirmationbutton} ></form></td>
               

                </tr>
            </c:forEach>

           
        </table>


        <form action="ViewOfferedRidesController" align = "center"><input type="submit" value="Go Back to Ride List" class="btn btn-info"></form>

    </body>
</html>