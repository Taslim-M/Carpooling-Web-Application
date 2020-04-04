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
                                <th scope="row" ><font style = "font-family: avenir" >Passenger ID</font></th>
                                <td><font style = "font-family: avenir" >${passenger.emailID}</font></td>
                            </tr>
                            <tr>
                                <th scope="row"><font style = "font-family: avenir" >First Name</font></th>
                                <td><font style = "font-family: avenir" > ${passenger.firstName}</font></td>
                            </tr>
                            <tr>
                                <th scope="row"><font style = "font-family: avenir" >Last Name</font></th>
                                <td><font style = "font-family: avenir" >${passenger.lastName}</font></td>
                            </tr>
                            <tr>
                                <th scope="row"><font style = "font-family: avenir" >Gender</font></th>
                                <td><font style = "font-family: avenir" >${passenger.gender}</font></td>
                            </tr>
                            <tr>
                                <th scope="row"><font style = "font-family: avenir" >Mobile Number</font></th>
                                <td><font style = "font-family: avenir" >${passenger.mobileNumber}</font></td>
                            </tr>
                        </tbody>
                    </table>


                </div>
            </c:forEach>
        </div>
    </div>
</body>

</html>