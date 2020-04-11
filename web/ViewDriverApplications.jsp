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
        <title>Driver Application Requests</title>
    </head>
    <body>
        <jsp:include page="navbaradmin.html"/>
        <div class ="container h-100">
            <h1 style = "font-family: avenir; color : #9B1B1B " align = "center" > Driver Application Requests </h1>
            <div class="table-responsive">
                <table class="table table-hover" align="center" cellpadding="5" cellspacing="0" border="1">
                    <thead class="thead-dark">

                        <tr bgcolor="#E9E9E9">
                            <th align = "center"><b><font style = "font-family: avenir" >Email</font></b></td>
                            <th align = "center"><b><font style = "font-family: avenir" >View Details</font></b></td>
                        </tr> 
                    </thead>
                    <tbody>
                        <c:forEach items="${DriverList}" var = "driver" >
                            <tr bgcolor="#FFFFFF">
                                <td align = "center"><font style = "font-family: avenir" >${driver.emailID}</font></b></td>
                                <td align = "center">
                                    <form action="ViewDriverApplicationDetailsController" >
                                        <input type="hidden" name = "driverID" value = ${driver.emailID} >
                                        <input type="submit" value= "View" class="btn btn-info">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>

    </body>

</html>
