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
        <c:choose>
            <c:when test = "${empty sessionScope.driver}" > 
                <jsp:include page="navbarPassenger.html"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="navbar.html"/>
            </c:otherwise>
        </c:choose>

        <div class="container">
            <h1 style = "font-family: avenir; color : #9B1B1B" align = "center">Hello ${sessionScope.passenger.firstName}! Find A Ride!</h1>
        </div>

        <form action="SearchRidesController" onsubmit ="return checkCheckboxes();" align = "center" name="search_rides_form"><font  style = "font-family: avenir">
            <div class="form-group">
                <h3> Select Ride Frequency </h3>
                <input type="radio" name="single_or_weekly" id = "single" value="single" onclick="manageSingleWeekly(this)" checked required/> Single
                <input type="radio" name="single_or_weekly" id ="weekly" value="weekly" onclick="manageSingleWeekly(this)" required /> Weekly
            </div>
            
            <div class="form-group">
                <h3> Select Ride Mode </h3>
                <input type="radio" name="to_from_uni" value="to" onclick="manageArrivalDeparture(this)" required/> To University
                <input type="radio" name="to_from_uni" value="from" onclick="manageArrivalDeparture(this)" required/> From University

            </div>
            <div class="form-group">
                <div id="ride_date_box" style="display:box">
                    <label for="ride_date">Ride date:</label>
                    <input type="date" id="ride_date" name="ride_date" >
                    <br/>
                </div>
            </div>
            <div class="form-group">
                <div id="ride_days_box" style="display:none">
                    <h3> Select Days </h3>
                    U <input type="checkbox" name="ride_days" id="Sunday" value="Sunday"/>
                    M <input type="checkbox" name="ride_days" id="Monday" value="Monday" />
                    T <input type="checkbox" name="ride_days" id="Tuesday" value="Tuesday" />
                    W <input type="checkbox" name="ride_days" id="Wednesday" value="Wednesday" />
                    R <input type="checkbox" name="ride_days" id="Thursday" value="Thursday" />
                </div>
            </div>
            
            <div class="form-group">
                <h3>Home Area</h3>
                <label for="home_location_latitude">Latitude:</label>
                <input type="number" step="any" name="home_location_latitude" value="" required />
                <label for="home_location_longitude">Longitude:</label>
                <input type="number" step="any" name="home_location_longitude" value="" required /><br/>
            </div>
            
            <div class="form-group">
                <h3>University Area</h3>
                <label for="uni_location_latitude">Latitude:</label>
                <input type="number" step="any" name="uni_location_latitude" value="25.311530" required />
                <label for="uni_location_longitude">Longitude:</label>
                <input type="number" step="any" name="uni_location_longitude" value="55.492179" required /><br/>
            </div>
            
            <div class="form-group">
                <h3 id="deparrtime">Time </h3>
                <input type="time" id="ride_time" name="ride_time" step="900" required>
            </div>
            
            <br>
            <input type="submit" value="Search Rides" class="btn btn-success btn-lg" />
            </font></form>
        
        <script type="text/javascript">
            function manageSingleWeekly(button) {
                if (button.value == "single") {
                    document.getElementById("ride_date_box").style.display = "block";
                    document.getElementById("ride_days_box").style.display = "none";

                } else {
                    document.getElementById("ride_date_box").style.display = "none";
                    document.getElementById("ride_days_box").style.display = "block";
                }
            }
            function manageArrivalDeparture(button){
                if (button.value == "to") {
                    deparrtime.innerText = "Arrival to University time";
                }else{
                    deparrtime.innerText = "Departure from University time";
                }
            }
            function checkCheckboxes() {

                if (document.getElementById("weekly").checked)
                {
                    if (!document.getElementById("Sunday").checked && !document.getElementById("Monday").checked && !document.getElementById("Tuesday").checked &&
                            !document.getElementById("Wednesday").checked && !document.getElementById("Thursday").checked) {
                        alert("Select at least one day.");
                        return false;
                    } else
                    {
                        return true;
                    }
                } else {
                    if (!document.getElementById("ride_date").value) {
                        alert("Please enter a date");
                        return false;
                    }
                }
                return true;
            }


        </script>


    </body>
</html>
