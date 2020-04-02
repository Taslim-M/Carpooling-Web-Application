<%-- 
    Document   : findRIde
    Created on : Apr 1, 2020, 7:35:50 PM
    Author     : Tasli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find A Ride</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.username}" >
            <jsp:forward page="index.html" />
        </c:if>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                   <p class="navbar-text">USCP - Logged in as ${sessionScope.username}</p>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">Passenger<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="findRide.jsp">Find A Ride</a></li>
                            <li><a href="#">View Confirmed Rides</a></li>
                            <li><a href="#">Register As Driver</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Driver<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Offer A Ride</a></li>
                            <li><a href="#">View Offered Rides</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="LogoutController"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <h1>Hello ${sessionScope.username}! Find A Ride</h1>
        </div>
    </body>
</html>
