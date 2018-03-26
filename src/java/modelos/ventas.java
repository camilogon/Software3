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
public class ventas {

    private int idVentas, idUsuario, precioVenta;
    private String fechaCompara;

    public ventas(int idVentas, int idUsuario, int precioVenta, String fechaCompara) {
        this.idVentas = idVentas;
        this.idUsuario = idUsuario;
        this.precioVenta = precioVenta;
        this.fechaCompara = fechaCompara;
    }

    public ventas() {
    }

   
    public ventas(int idUsuario, int precioVenta, String fechaCompara) {
        this.idVentas = idVentas;
        this.idUsuario = idUsuario;
        this.precioVenta = precioVenta;
        this.fechaCompara = fechaCompara;
    }

    
    public int getIdVentas() {
        return idVentas;
    }

   
    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

   
    public int getIdUsuario() {
        return idUsuario;
    }

   
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

   
    public int getPrecioVenta() {
        return precioVenta;
    }

   
    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaCompara() {
        return fechaCompara;
    }

    
    public void setFechaCompara(String fechaCompara) {
        this.fechaCompara = fechaCompara;
    }

}
