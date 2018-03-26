/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.File;
import javax.print.DocFlavor;

/**
 *
 * @author team  Script
 */
public class Catalogo {

    private int idCatalogo;
    private String nombre;
    private String fecha;
    private String archivo;
    private String editorial;

    public Catalogo() {
    }

    public Catalogo(int idCatalogo, String nombre, String fecha, String archivo, String Editorial) {
        this.idCatalogo = idCatalogo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.archivo = archivo;
        this.editorial = Editorial;
    }

    public Catalogo(String nombre, String fecha, String archivo, String Editorial) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.archivo = archivo;
        this.editorial = Editorial;
    }

    
    public int getIdCatalogo() {
        return idCatalogo;
    }

    
    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

   
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getFecha() {
        return fecha;
    }

    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    public String getArchivo() {
        return archivo;
    }

   
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String Editorial) {
        this.editorial = Editorial;
    }

}
