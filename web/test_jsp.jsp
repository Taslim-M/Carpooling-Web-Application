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
    </head>
    <body>
        <h2>This is a test jsp file</h2>
        1+1 = <%= (2+2) %> </br>
        <ol>
        <%
        CarpoolDatabase.DbRepo repo = new CarpoolDatabase.DbRepo();
        ResultSet rs = repo.executeSelectionQuery("select * from employee");
        while (rs.next()){
        %>
        <li><%=rs.getString("fname")%></li>  
        <%
        }
        %>
        </ol>
    </body>
</html>

