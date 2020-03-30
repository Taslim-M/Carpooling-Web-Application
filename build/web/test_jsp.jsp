<%-- 
    Document   : test_jsp
    Created on : Mar 30, 2020, 11:14:21 AM
    Author     : azada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>This is a test jsp file</h2>
        1+1 = <%= (1+1) %> </br>
        
        <jsp:useBean id="testUser" class="Beans.User" />
        <jsp:setProperty name="testUser" property="firstName" value="John" />
        
        Hi, my name is ${testUser.firstName}
    </body>
</html>

