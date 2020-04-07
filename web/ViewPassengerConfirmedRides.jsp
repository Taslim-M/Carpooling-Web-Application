<%-- 
    Document   : ViewPassengerConfirmedRides
    Created on : Apr 7, 2020, 11:19:10 PM
    Author     : azada
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
    <c:if test="${empty sessionScope.driver}" >
        <jsp:include page="navbarPassenger.html"/>
    </c:if> 
    <c:if test="${! empty sessionScope.driver}" >
        <jsp:include page="navbar.html"/>
    </c:if> 
    <div class ="container h-100">
        <h1 style = "font-family: avenir; color : #9B1B1B "  align = "center" > Confirmed Rides of ${sessionScope.passenger.firstName} </h1>
        <div class="table-responsive">
            <h2 style = "font-family: avenir "  align = "center" > Single Rides </h2>

            <table class="table table-hover" align="center" cellpadding="5" cellspacing="0" border="1">
                <thead class="thead-dark">
                    <tr bgcolor="#E9E9E9">

                        <td align = "center"><b><font style = "font-family: avenir" >Ride ID </font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >To Uni?</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Arrival/Departure Time</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Start Location</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >End Location</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Current Seat Availability</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Date</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >More Info </font></b></td>
                    </tr>
                </thead>

                <tbody>

                <c:forEach items="${singleRides}" var = "ride" >
                    <tr bgcolor="#FFFFFF">
                        <td align = "center"><font style = "font-family: avenir" >${ride.rideId}</font></b></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.isToUni}</font></b></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.arrivalDepartureTime}</font></b></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.startingLocation}</font></b></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.endingLocation}</font></b></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.seatAvailability}</font></b></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.date}</font></b></td>
                        <td align = "center"><form action=""><input type = "hidden" name = "rideid" value = ${ride.rideId} ><input type="submit" value="More Info" class="btn btn-info"></form></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <div class="table-responsive">
            <h2 style = "font-family: avenir "  align = "center" > Weekly Rides </h2>

            <table class="table table-hover" align="center" cellpadding="5" cellspacing="0" border="1">
                <tr>


                </tr>
                <thead class="thead-dark">
                    <tr bgcolor="#E9E9E9">

                        <td align = "center"><b><font style = "font-family: avenir" >Ride ID </font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >To Uni?</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Arrival/Departure Time</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Start Location</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >End Location</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Current Seat Availability</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >Day</font></b></td>
                        <td align = "center"><b><font style = "font-family: avenir" >More Info</font></b></td>

                    </tr>
                </thead>


                <tbody>
                <c:forEach items="${weeklyRides}" var = "ride" >
                    <tr bgcolor="#FFFFFF">

                        <td align = "center"><font style = "font-family: avenir" >${ride.rideId}</font></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.isToUni}</font></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.arrivalDepartureTime}</font></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.startingLocation}</font></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.endingLocation}</font></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.seatAvailability}</font></td>
                        <td align = "center"><font style = "font-family: avenir" >${ride.day}</font></td>
                        <td align = "center"><form action=""><input type = "hidden" name = "rideid" value = ${ride.rideId} ><input type="submit" value="More Info" class="btn btn-info"></form></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>


    </div>
</body>
</html>
