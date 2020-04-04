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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    </head>
    <body>

    <div class ="container h-100">
        <div class="table-responsive">
            <h1 style = "font-family: avenir; color : #9B1B1B" align="center" >Driver Information</h1>
            <br>
            <table class="table table-striped table-dark"  align="center">
                <thead>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">First Name</th>
                        <td>${selected_driver.firstName}</td>
                    </tr>
                    <tr>
                        <th scope="row">Last Name</th>
                        <td>${selected_driver.lastName}</td>
                    </tr>
                    <tr>
                        <th scope="row">Gender</th>
                        <td>${selected_driver.gender}</td>
                    </tr>
                    <tr>
                        <th scope="row">Car Model</th>
                        <td>${selected_driver.myCar.carModel}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
