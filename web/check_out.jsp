<%-- 
    Document   : check_out
    Created on : Nov 24, 2020, 12:18:26 PM
    Author     : Reo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.ShoppingCartTable1"%>
<%@page import="model.ShoppingCart1"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body>
        <h1>Your Order is confirmed!</h1>
        <h1><%= "The total amount is $" + request.getAttribute("amount") %></h1>
    
    </body>
</html>
