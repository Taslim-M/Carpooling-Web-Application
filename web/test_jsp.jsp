<%-- 
    Document   : test_jsp
    Created on : Mar 30, 2020, 11:14:21 AM
    Author     : azada
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                dropMarker(25.2777035, 55.4090725, "Taslim");
//                var arrayList = ${singleRides};
//                for (var x = 0; x < arrayList.length; x++) {
//                    let username = arrayList[x].something;
//                    let latitude = arrayList[x].something;
//                    let longitude = arrayList[x].something;
//                    dropMarker(latitude, longtude, username);
//                }
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
        <jsp:include page="navbar.html"/>
        <h2>This is a test jsp file</h2>

        <div class="container">

        </div>
        <div id="map"></div>





    </body>
</html>

