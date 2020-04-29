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
        <title>Passenger Requests</title>
        <meta name="viewport" content="initial-scale=1.0">
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 100%;
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
        </style>
        <script>
            var map;
            function initMap() {
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: 25.233, lng: 55.39},
                    zoom: 11.5,
                    streetViewControl: false
                });
                var i = 1;
                var markers = [
            <c:forEach items="${Requests}" var = "request">
                        [<c:out value="${request.pickupLocation.latitude}"/>,<c:out value="${request.pickupLocation.longitude}"/>,<c:out value= "i++" />],
            </c:forEach>];
                //dropMarker(25.2777035, 55.4090725, "Taslim");

                for (i = 0; i < markers.length; i++) {
                    dropMarker(markers[i][0], markers[i][1], markers[i][2]);
                }
            }

            function dropMarker(lat, long, username) {
                var location = {lat: lat, lng: long};
                var contentString = "<h4>" + username + "<h4>";
                //this is what pops up on click
                var infowindow = new google.maps.InfoWindow({
                    content: contentString
                });
                var marker = new google.maps.Marker({position: location, map: map, title: username});
                marker.addListener('click', function () {
                    infowindow.open(map, marker);
                });
            }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBecfmKbsd_B0ZuJNoR665hgZ5-lZb0baA&callback=initMap"
        async defer></script>
    </head>
    <body>
        <c:if test="${empty sessionScope.username}" >
            <jsp:forward page="findRide.jsp" />
        </c:if> 

        <jsp:include page="navbar.html"/>

        <div class ="container h-100">
            <h1 style = "font-family: avenir; color : #9B1B1B " align = "center" > Passengers for Selected Ride </h1>
            <div class="table-responsive">
                <table class="table table-hover" align="center" cellpadding="5" cellspacing="0" border="1">
                    <thead class="thead-dark">

                        <tr bgcolor="#E9E9E9">
                            <th align = "center"><b><font style = "font-family: avenir" >Passenger No.</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Ride_ID</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Passenger_ID</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Pickup Location</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Dropoff Location</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >View Passenger Information</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >Action</font></b></td>

                        </tr> 
                    </thead>
                    <tbody>
                        <% int i=1;%>
                        <c:forEach items="${Requests}" var = "request" >
                            <tr bgcolor="#FFFFFF">
                                
                                <td align = "center"><font style = "font-family: avenir" ><%out.println(i);%></font></td>
                                <td align = "center"><font style = "font-family: avenir" >${request.requested_ride_id}</font></td>
                                <td align = "center"><font style = "font-family: avenir" >${request.passengerid}</font></td>
                                <td align = "center"><font style = "font-family: avenir" >${request.pickupLocation}</font></td>
                                <td align = "center"><font style = "font-family: avenir" >${request.dropoffLocation}</font></td>
                                <td align = "center"><form action="ViewPassengerInfoController" target="_blank"><input type = "hidden" name = "passengerid" value = ${request.passengerid} ><input type="submit" value= "View" class="btn btn-info"></form></td>
                                <td align = "center"><form action="PassengerActionController"><input type = "hidden" name = "passengerid" value = ${request.passengerid} ><input type = "hidden" name = "passengerstatus" value = ${request.confirmationbutton} ><input type = "hidden" name = "rideid" value = ${request.requested_ride_id} ><input type="submit" class= "btn btn-primary" value= ${request.confirmationbutton} ></form></td>

                        <% i++;%>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>


            <form action="ViewOfferedRidesController" align = "center"><input type="submit" value="Go Back to Ride List" class="btn btn-secondary"></form>

        </div>
        <div id="map"></div>
    </body>
</html>