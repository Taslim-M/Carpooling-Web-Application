<%-- 
    Document   : MakeRideRequest
    Created on : Apr 4, 2020, 2:42:22 PM
    Author     : azada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Rides</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class ="container h-100">
            <h1 style = "font-family: avenir; color : #9B1B1B "  align = "center" > Found Rides </h1>
            <div class="table-responsive">
                <table class="table table-hover" align="center" cellpadding="5" cellspacing="0" border="1">
                    <thead class="thead-dark">
                        <tr bgcolor="#E9E9E9">

                            <th align = "center"><b><font style = "font-family: avenir" >Ride ID </font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >To Uni?</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Arrival/Departure Time</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Start Location</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >End Location</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Current Seat Availability</font></b></td>
                            <c:choose>
                                <c:when test="${param.single_or_weekly == 'single'}">
                            <th align = "center"><b><font style = "font-family: avenir" >Date</font></b></td>
                                </c:when>
                                <c:when test="${param.single_or_weekly == 'weekly'}">
                            <th align = "center"><b><font style = "font-family: avenir" >Day</font></b></td>
                                </c:when>
                            </c:choose>    
                            <th align = "center"><b><font style = "font-family: avenir" >Request Ride</font></b></td>

                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach items="${found_rides}" var = "ride" >
                            <tr bgcolor="#FFFFFF">
                                <td align = "center"><font style = "font-family: avenir" >${ride.rideId}</font></b></td>
                                <td align = "center"><font style = "font-family: avenir" >${ride.isToUni}</font></b></td>
                                <td align = "center"><font style = "font-family: avenir" >${ride.arrivalDepartureTime}</font></b></td>
                                <td align = "center"><font style = "font-family: avenir" >${ride.startingLocation}</font></b></td>
                                <td align = "center"><font style = "font-family: avenir" >${ride.endingLocation}</font></b></td>
                                <td align = "center"><font style = "font-family: avenir" >${ride.seatAvailability}</font></b></td>
                                <c:choose>
                                    <c:when test="${param.single_or_weekly == 'single'}">
                                    <td align = "center"><font style = "font-family: avenir" >${ride.date}</font></b></td>
                                    </c:when>
                                        <c:when test="${param.single_or_weekly == 'weekly'}">
                                    <td align = "center"><font style = "font-family: avenir" >${ride.day}</font></b></td>
                                    </c:when>
                                </c:choose>   
                               
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
    </body>
</html>
