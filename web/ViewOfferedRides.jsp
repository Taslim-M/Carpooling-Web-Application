<%-- 
    Document   : ViewConfirmedRides
    Created on : Apr 2, 2020, 9:34:20 PM
    Author     : reem
--%>

<%@page import="javax.sql.rowset.CachedRowSet"%>
<%@page import="CarpoolDatabase.DbRepo"%>
<%@page import="java.sql.SQLException"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed Rides</title>
    </head>
    <body>
        <h1>Confirmed Rides of User ${sessionScope.username} </h1>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="#0EB39C">
                <td><b>Ride ID</b></td>
                <td><b>Is to Uni</b></td>
                <td><b>Arrival/Departure Time</b></td>
                <td><b>Start Location</b></td>
                <td><b>End Location</b></td>
                <td><b>Current Seat Availability</b></td>

            </tr>

            <%
                String username = (String) session.getAttribute("username");
                CachedRowSet crs = CarpoolDatabase.DbRepo.getConfiguredConnection();
                crs.setCommand("Select * from offered_rides where driver_id = '" + username + "' AND ride_id in (select ride_id from confirmed_rides)");

                crs.execute();
                while (crs.next()) {
            %>



            <tr bgcolor="#E2FFFB">
                <td><%=crs.getString("ride_id")%></td>
                <td><%=crs.getString("is_to_uni")%></td>
                <td><%=crs.getString("arrival_dep_time")%></td>
                <td><%=crs.getString("start_location")%></td>
                <td><%=crs.getString("end_location")%></td>
                <td><%=crs.getString("current_seat_avail")%></td>


            </tr>


            <%

                }


            %>
        </table>




    </body>
</html>
