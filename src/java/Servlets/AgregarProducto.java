/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ArticuloCarrito;

/**
 *
 * @author Team Script
 */
public class AgregarProducto extends HttpServlet {

    /**
     * Procesa peticiones de metodos HTTP <code>GET</code> y <code>POST</code>
     *
     *
     * @param request peticion del servlet
     * @param response respuesta del servlet
     * @throws ServletException si ocurre un error con el servlet
     * @throws IOException si ocurre un error de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int idArticulo = Integer.parseInt(request.getParameter("idArticulo"));
        HttpSession sesion = request.getSession(true);
        LinkedList<ArticuloCarrito> articulosCarrito = sesion.getAttribute("carrito") == null ? new LinkedList<ArticuloCarrito>() : (LinkedList<ArticuloCarrito>) sesion.getAttribute("carrito");
        boolean bandera = false;
        if (articulosCarrito.size() > 0) {
            for (ArticuloCarrito articuloC : articulosCarrito) {
                if (idArticulo == articuloC.getIdArticulo()) {
                    articuloC.setCantidad(articuloC.getCantidad() + cantidad);
                    bandera = true;
                    break;
                }
            }
        }

        if (!bandera) {
            articulosCarrito.add(new ArticuloCarrito(idArticulo, cantidad));
        }
        sesion.setAttribute("carrito", articulosCarrito);
        response.sendRedirect("Carrito.htm");

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
