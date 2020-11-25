/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DvdCatalog;
import model.DvdCatalogTable;
import model.ShoppingCart1;
import model.ShoppingCartTable1;

/**
 *
 * @author Reo
 */
public class AddToCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShoppingCart1 cart = new ShoppingCart1();
        
        int dvd_id = Integer.parseInt(request.getParameter("dvdId"));
        DvdCatalog catalog = DvdCatalogTable.findDvdCatalogById(dvd_id);
        
        
        List<ShoppingCart1> in_cart = ShoppingCartTable1.findCartByIdCatalog(catalog);
        
        //check if incart null -> insert , not null update
        if (in_cart == null) {
            cart.setDvdId(catalog);
            cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            ShoppingCartTable1.insertShoppingCart1(cart);
        } else {
            cart.setId(in_cart.get(0).getId());
            cart.setDvdId(catalog);
            cart.setQuantity(in_cart.get(0).getQuantity()+Integer.parseInt(request.getParameter("quantity")));
            ShoppingCartTable1.updateShoppingCart1(cart);
        }
        request.getRequestDispatcher("shopping_cart.jsp").forward(request, response);
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
