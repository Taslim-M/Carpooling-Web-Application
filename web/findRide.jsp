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

    </head>
    <body>
        <%-- 
 <c:if test="${empty sessionScope.username}" >
     <jsp:forward page="index.jsp" />
 </c:if> 
        --%>
        <c:if test="${empty sessionScope.driver}" >
            <jsp:include page="navbarPassenger.html"/>
        </c:if> 
        <c:if test="${! empty sessionScope.driver}" >
            <jsp:include page="navbar.html"/>
        </c:if> 

        <div class="container">
            <h1 style = "font-family: avenir; color : #9B1B1B" align = "center">Hello ${sessionScope.passenger.firstName}! Find A Ride!</h1>
        </div>

        <form action="SearchRidesController" align = "center"><font  style = "font-family: avenir">
            Select Ride Frequency: <br/>
            <input type="radio" name="single_or_weekly" value="single" onclick="manageSingleWeekly(this)" checked required/> Single
            <input type="radio" name="single_or_weekly" value="weekly" onclick="manageSingleWeekly(this)" required /> Weekly

            <br/>
            <input type="radio" name="to_from_uni" value="to" required/> To University
            <input type="radio" name="to_from_uni" value="from" required/> From University
            <br/>

            <div id="ride_date_box" style="display:box">
                <label for="ride_date">Ride date:</label>
                <input type="date" id="ride_date" name="ride_date" required >
                <br/>
            </div>
            <div id="ride_days_box" style="display:none">
                Select Days <br/>
                U <input type="checkbox" name="ride_days" value="Sunday" checked required/>
                M <input type="checkbox" name="ride_days" value="Monday" />
                T <input type="checkbox" name="ride_days" value="Tuesday" />
                W <input type="checkbox" name="ride_days" value="Wednesday" />
                R <input type="checkbox" name="ride_days" value="Thursday" />

                <br/>
            </div>

            Home Area: <br/>
            <label for="home_location_latitude">Latitude:</label>
            <input type="number" step="any" name="home_location_latitude" value="" required />
            <label for="home_location_longitude">Longitude:</label>
            <input type="number" step="any" name="home_location_longitude" value="" required /><br/>

            <br/>
            University Area: <br/>
            <label for="uni_location_latitude">Latitude:</label>
            <input type="number" step="any" name="uni_location_latitude" value="25.311530" required />
            <label for="uni_location_longitude">Longitude:</label>
            <input type="number" step="any" name="uni_location_longitude" value="55.492179" required /><br/>

            <br/>
            <label for="ride_time">Departure Time:</label>
            <input type="time" id="ride_time" name="ride_time" required>
            <br/>
            <br/>
            <input type="submit" value="Search Rides" class="btn btn-success btn-lg" />
            </font></form>
        <script>
            function manageSingleWeekly(button) {
                if (button.value == "single") {
                    document.getElementById("ride_date_box").style.display = "block";
                    document.getElementById("ride_days_box").style.display = "none";

                } else {
                    document.getElementById("ride_date_box").style.display = "none";
                    document.getElementById("ride_days_box").style.display = "block";
                }
            }
            
            
        </script>


    </body>
</html>
