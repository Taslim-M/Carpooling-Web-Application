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
        <title>Pending Passenger Form</title>
    </head>
    <body>
    <h1 style = "font-family: avenir; color : #9B1B1B "  align = "center" > ${Message} </h1>
    <form action="ConfirmRemovePassengerController"  align = "center"><input type = "hidden" name = "passenger_id" value = ${Passenger_ID}><input type = "hidden" name = "rideid" value = ${Ride_ID}><input type = "hidden" name = "choice" value = "Confirm"><input type="submit" value = "Confirm Passenger Request" ></form>
    <form action="ConfirmRemovePassengerController"  align = "center"><input type = "hidden" name = "passenger_id" value = ${Passenger_ID}><input type = "hidden" name = "rideid" value = ${Ride_ID}><input type = "hidden" name = "choice" value = "RemoveNew"><input type="submit" value = "Remove Passenger Request" ></form>
    <form action="ViewPassengerRequestsController"  align = "center"><input type = "hidden" name = "rideid" value = ${Ride_ID} ><input type="submit" value = "Go Back to Passenger List" ></form>

    </body>
</html>
