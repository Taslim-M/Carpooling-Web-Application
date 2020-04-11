<%-- 
    Document   : ViewDriverApplications
    Created on : Apr 5, 2020, 9:29:46 PM
    Author     : Ayah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Driver Details</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <jsp:include page="navbaradmin.html"/>

    <div class ="container h-100">
        <h1 style = "font-family: avenir; color : #9B1B1B " align = "center" > Driver Application Details</h1>
        <div class="table-responsive">
            <table class="table table-striped table-dark"  align="center">
                <thead>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row"><font style = "font-family: avenir" >Email Address</font></th>
                        <td><font style = "font-family: avenir" >${selected_driver.emailID}</font></td>
                    </tr>
                    <tr>
                        <th scope="row"><font style = "font-family: avenir" >Car Model</font></th>
                        <td><font style = "font-family: avenir" >${selected_driver.myCar.carModel}</font></td>
                    </tr>
                    <tr>
                        <th scope="row"><font style = "font-family: avenir" >Car Capacity</font></th>
                        <td><font style = "font-family: avenir" >${selected_driver.myCar.carCapacity}</font></td>
                    </tr>
                    <tr>
                        <th scope="row"><font style = "font-family: avenir" >License Image</font></th>
                        <td></td>
                    </tr>
                    <tr>
                        <th scope="row"><font style = "font-family: avenir" >Car Registration Image</font></th>
                        <td></td>
                    </tr>
                    <tr>
                        <th scope="row"><font style = "font-family: avenir" >Emirates ID Image</font></th>
                        <td></td>
                    </tr>
                    <tr>
                        <td align = "center">
                            <form action="AcceptRejectDriverApplicationController">
                                <input type = "hidden" name = "action" value ="cancel" >
                                <input type = "hidden" name = "driverID" value ="${selected_driver.emailID}" >
                                <input type="submit" value= "Ignore Request" class="btn btn-danger">
                            </form>
                        </td>
                        <td align = "center">
                            <form action="AcceptRejectDriverApplicationController">
                                <input type = "hidden" name = "action" value ="accept" >
                                <input type = "hidden" name = "driverID" value ="${selected_driver.emailID}" >
                                <input type="submit" value= "Accept Request" class="btn btn-success">
                            </form>
                        </td>
                    </tr>
                </tbody>

            </table>
        </div>
        <form action="ViewDriverRequestsController" align = "center"><input type="submit" value="Go Back to List of Requests" class="btn btn-secondary"></form>
    </div>
</html>
