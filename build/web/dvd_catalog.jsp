<%-- 
    Document   : dvd_catalog
    Created on : Nov 24, 2020, 12:33:33 AM
    Author     : Reo
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.DvdCatalog"%>
<%@page import="model.DvdCatalogTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="dvd" class="model.DvdCatalog" scope="request"/>
     <%
                       
            List<DvdCatalog> catalogList = DvdCatalogTable.findAllDvdCatalog();
            Iterator<DvdCatalog> itr = catalogList.iterator();
            
     %>
    <body>
        <center>
        <h1>DVD Catalog</h1>
        <table border="1">
          <tr>
            <th>DVD Name</th>
            <th>Rate</th>
            <th>Year</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>AddCart</th>
          </tr>
          <%
              
               while(itr.hasNext()) {
                   out.println("<form name='addCart' action='AddToCartController' method='POST'>");
                   dvd = itr.next();
                   out.println("<tr>");
                   out.println("<td hidden><input type='number' name='dvdId' value=" + dvd.getId() + "></input></td>");
                   out.println("<td> "+ dvd.getName() + "</td>");
                   out.println("<td> "+ dvd.getRate() + "</td>");
                   out.println("<td> "+ dvd.getYears() + "</td>");
                   out.println("<td> "+ dvd.getPrice() + "</td>");
                   
                   out.println("<td> <input type='number'  id ='quantity' name='quantity'/> </td>");
                   out.println("<td> <input type='submit' value='Add to Cart' name = 'addCart'/> </td>");
                   out.println("<tr>");
                   out.println("</form>");
               }
          %>
    </table>
    <input type="button" value="Back to Menu" onclick="window.location='index.html'" >
    <input type="button" value="Shopping Cart" onclick="window.location='shopping_cart.jsp'" >
 </center>
    </body>
</html>
