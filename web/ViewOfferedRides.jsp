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
        <h1 style = "font-family: avenir; color : #9B1B1B "  align = "center" > Upcoming Rides of ${sessionScope.passenger.firstName} </h1>

                <h2 style = "font-family: avenir "  align = "center" > Single Rides </h2>

        <table align="center" cellpadding="5" cellspacing="0" border="1">
            <tr>

            
            </tr>
            <tr bgcolor="#E9E9E9">
                <td><b><font style = "font-family: avenir" >Ride ID </font></b></td>
                <td><b><font style = "font-family: avenir" >Is to Uni</font></b></td>
                <td><b><font style = "font-family: avenir" >Arrival/Departure Time</font></b></td>
                <td><b><font style = "font-family: avenir" >Start Location</font></b></td>
                <td><b><font style = "font-family: avenir" >End Location</font></b></td>
                <td><b><font style = "font-family: avenir" >Current Seat Availability</font></b></td>
                <td><b><font style = "font-family: avenir" >Date</font></b></td>
                <td><b><font style = "font-family: avenir" >View Confirmed Passengers</font></b></td>

            </tr>
            


                
            <c:forEach items="${singleRides}" var = "ride" >
                <tr bgcolor="#FFFFFF">
                    <td><font style = "font-family: avenir" >${ride.rideId}</font></td>
                    <td><font style = "font-family: avenir" >${ride.isToUni}</font></td>
                    <td><font style = "font-family: avenir" >${ride.arrivalDepartureTime}</font></td>
                    <td><font style = "font-family: avenir" >${ride.startingLocation}</font></td>
                    <td><font style = "font-family: avenir" >${ride.endingLocation}</font></td>
                    <td><font style = "font-family: avenir" >${ride.seatAvailability}</font></td>
                    <td><font style = "font-family: avenir" >${ride.date}</font></td>
                    <td><button style = "height : 50px; width : 180px" ><a href="ViewConfirmedPassengersController"> <font size = 3  >Select</font></a></button></td>
                        
                </tr>
            </c:forEach>

  
        </table>
        
                <h2 style = "font-family: avenir "  align = "center" > Weekly Rides </h2>

        <table align="center" cellpadding="5" cellspacing="0" border="1">
            <tr>

            
            </tr>
            <tr bgcolor="#E9E9E9">
                <td><b><font style = "font-family: avenir" >Ride ID </font></b></td>
                <td><b><font style = "font-family: avenir" >Is to Uni</font></b></td>
                <td><b><font style = "font-family: avenir" >Arrival/Departure Time</font></b></td>
                <td><b><font style = "font-family: avenir" >Start Location</font></b></td>
                <td><b><font style = "font-family: avenir" >End Location</font></b></td>
                <td><b><font style = "font-family: avenir" >Current Seat Availability</font></b></td>
                <td><b><font style = "font-family: avenir" >Day</font></b></td>
                <td><b><font style = "font-family: avenir" >View Confirmed Passengers</font></b></td>

            </tr>
            


                
            <c:forEach items="${weeklyRides}" var = "ride" >
                <tr bgcolor="#FFFFFF">
                    <td><font style = "font-family: avenir" >${ride.rideId}</font></td>
                    <td><font style = "font-family: avenir" >${ride.isToUni}</font></td>
                    <td><font style = "font-family: avenir" >${ride.arrivalDepartureTime}</font></td>
                    <td><font style = "font-family: avenir" >${ride.startingLocation}</font></td>
                    <td><font style = "font-family: avenir" >${ride.endingLocation}</font></td>
                    <td><font style = "font-family: avenir" >${ride.seatAvailability}</font></td>
                    <td><font style = "font-family: avenir" >${ride.day}</font></td>
                    <td><button style = "height : 50px; width : 180px" ><a href="ViewConfirmedPassengersController"> <font size = 3  >Select</font></a></button></td>
                        
                </tr>
            </c:forEach>

  
        </table>




    </body>
</html>
