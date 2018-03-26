/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author team Script
 */
public class ArticuloCarrito {

    private int idArticulo;
    private int cantidad;

    public ArticuloCarrito(int idArticulo, int cantidad) {
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

   
    public int getIdArticulo() {
        return idArticulo;
    }

    
    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

   
    public int getCantidad() {
        return cantidad;
    }

   
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
