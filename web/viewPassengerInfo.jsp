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
        <title>Passenger Information</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    </head>

    <body>

        <div class ="container h-100">
            <c:forEach items="${Passengers}" var = "passenger" >
                <h1 style = "font-family: avenir; color : #9B1B1B" align="center" >Passenger Information</h1>
                <br>
                <div class="table-responsive">
                    <table class="table table-striped table-dark"  align="center">
                        <thead>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">Passenger ID</th>
                                <td>${passenger.emailID}</td>
                            </tr>
                            <tr>
                                <th scope="row">First Name</th>
                                <td> ${passenger.firstName}</td>
                            </tr>
                            <tr>
                                <th scope="row">Last Name</th>
                                <td>${passenger.lastName}</td>
                            </tr>
                            <tr>
                                <th scope="row">Gender</th>
                                <td>${passenger.gender}</td>
                            </tr>
                            <tr>
                                <th scope="row">Mobile Number</th>
                                <td>${passenger.mobileNumber}</td>
                            </tr>
                        </tbody>
                    </table>


                </div>
            </c:forEach>
        </div>
    </div>
</body>

</html>