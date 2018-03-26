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
public class Editorial {

    private int idEditorial;
    private String nombre;
    private String correoContacto;
    private String telefonoContacto;
    private String direccion;

    public Editorial(String nombre, String correoContacto, String telefonoContacto, String direccion) {
        this.nombre = nombre;
        this.correoContacto = correoContacto;
        this.telefonoContacto = telefonoContacto;
        this.direccion = direccion;
    }

    public Editorial(int idEditorial, String nombre, String correoContacto, String telefonoContacto, String direccion) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
        this.correoContacto = correoContacto;
        this.telefonoContacto = telefonoContacto;
        this.direccion = direccion;
    }

    public Editorial() {
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

}
