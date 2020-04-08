<%-- 
    Document   : RideRequestConfirmation
    Created on : Apr 4, 2020, 5:39:23 PM
    Author     : azada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ride Request</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class ="container h-100">
            <h1 style = "font-family: avenir; color : #9B1B1B "  align = "center" >${outcome_message}</h1>
     
        <form align="center" action="findRide.jsp">
            <input type="submit" value="Go Back Home" class="btn btn-secondary"/>
        </form>
        </div>
    </body>
</html>
