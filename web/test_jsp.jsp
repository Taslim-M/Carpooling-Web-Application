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
        <script
        src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
        <script>
            var map;
            function initialize() {
                var mapOptions = {
                    zoom: 8,
                    center: new google.maps.LatLng(25.2826466,55.4076209)
                };
                map = new google.maps.Map(document.getElementById('map-canvas'),
                        mapOptions);
            }

            google.maps.event.addDomListener(window, 'load', initialize);
        </script>
    </head>
    <body>
        <jsp:include page="navbar.html"/>
        <h2>This is a test jsp file</h2>
        <div id="map-canvas" style="height:300px; width:500px"></div>
    </body>
</html>

