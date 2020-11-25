<%-- 
    Document   : shopping_cart
    Created on : Nov 24, 2020, 1:10:20 AM
    Author     : Reo
--%>

<%@page import="model.ShoppingCartTable1"%>
<%@page import="model.ShoppingCart1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    
        <jsp:useBean id="cart" class="model.ShoppingCart1" scope="request"/>
    <%
        List<ShoppingCart1> cartList = ShoppingCartTable1.findAllShoppingCart1();
        Iterator<ShoppingCart1> itr = cartList.iterator();
    %>
    
    <body>
        <center>
        <h1>Shopping Cart</h1>
        <table border="1">
          <tr>
            <th>DVD Name</th>
            <th>Rate</th>
            <th>Year</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Remove</th>
          </tr>
          
          <%
              
               while(itr.hasNext()) {
                   out.println("<form name='addCart' action='RemoveController' method='POST'>");
                   cart = itr.next();
                   out.println("<tr>");
                   out.println("<td hidden><input type='number' name='id' value=" + cart.getId() + "></input></td>");
                   out.println("<td> " + cart.getDvdId().getName() + "</td>");
                   out.println("<td> " + cart.getDvdId().getRate() + "</td>");
                   out.println("<td> " + cart.getDvdId().getYears() + "</td>");
                   out.println("<td> " + cart.getDvdId().getPrice() + "</td>");
                   out.println("<td> " + cart.getQuantity() + "</td>");
                   out.println("<td> <input type='submit' value='Remove' name = 'Remove'/> </td>");
                   out.println("<tr>");
                   out.println("</form>");
               }
               // value คือชื่อที่แสดง
          %>
          
    </table>
          <input type="button" value="Back to DVD Catalog" onclick="window.location='dvd_catalog.jsp'" >
          <input type="button" value="Check out" onclick="window.location='CheckOutController'" >
 </center>
    </body>
</html>
