/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ArticuloCarrito;

/**
 *
 * @author Usuario
 */
public class BorrarProducto extends HttpServlet {

    /**
     * Procesa peticiones de metodos HTTP <code>GET</code> y <code>POST</code>
     *
     * @param request peticion del servlet
     * @param response respuesta del servlet
     * @throws ServletException si ocurre un error con el servlet
     * @throws IOException si ocurre un error de I/O
     */
    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final String idEntrante = request.getParameter("idArticulo");
        final int idArticulo = Integer.parseInt(idEntrante);
        final HttpSession sesion = request.getSession(true);
        final LinkedList<ArticuloCarrito> articulosCarrito = sesion.getAttribute("carrito") == null ? null
                : (LinkedList<ArticuloCarrito>) sesion.getAttribute("carrito");
        borrarProducto(articulosCarrito, idArticulo);
    }
     /**
     * borra un articulo al carrito 
     * @param articulosCarrito articulos en el carrito
     * @param idArticulo articulo para borrar
     */
    public void borrarProducto(LinkedList<ArticuloCarrito> articulosCarrito, int idArticulo) {
        if (articulosCarrito != null) {
            for (final ArticuloCarrito i : articulosCarrito) {
                if (i.getIdArticulo() == idArticulo) {
                    articulosCarrito.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
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
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
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
