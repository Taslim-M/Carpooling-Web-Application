<%-- 
    Document   : ViewDriverInfo
    Created on : Apr 4, 2020, 6:15:00 PM
    Author     : azada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Driver Info:</h1>
        First Name: ${selected_driver.firstName}
        <br/>
        Last Name: ${selected_driver.lastName}
        <br/>
        Gender: ${selected_driver.gender}
        <br/>
        Car Model: ${selected_driver.myCar.carModel}
        <br/>

    </body>
</html>
