<%-- 
    Document   : CancelRideForm
    Created on : Apr 4, 2020, 1:35:49 AM
    Author     : reem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ride Successfully Canceled.</title>
    </head>
    <body>
    <h1 style = "font-family: avenir; color : #9B1B1B "  align = "center" > ${Message} </h1>
    <form action="ViewOfferedRidesController"  align = "center"><input type="submit" value = "View Updated Offered Rides" ></form>
    </body>
</html>
