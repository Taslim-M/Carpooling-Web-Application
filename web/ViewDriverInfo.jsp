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
         <title>Driver Information</title>
    </head>
    <body>
        <div class ="container h-100">
        <h1 style = "font-family: avenir; color : #9B1B1B" >Driver Information</h1>
        <font style = "font-family: avenir" >First Name: ${selected_driver.firstName}</font>
        <br/>
        <font style = "font-family: avenir" >Last Name: ${selected_driver.lastName}</font>
        <br/>
        <font style = "font-family: avenir" >Gender: ${selected_driver.gender}</font>
        <br/>
        <font style = "font-family: avenir" >Car Model: ${selected_driver.myCar.carModel}</font>
        <br/>
        </div>
    </body>
</html>
