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
public class Autor {

    private int id;
    private String nombre;
    private String descripcion;
    private String recomendado;

    public Autor(int id, String nombre, String descripcion, String recomendado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.recomendado = recomendado;

    }

    public Autor(String nombre, String descripcion, String recomnedodo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.recomendado = recomnedodo;
    }

    public Autor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(String recomendado) {
        this.recomendado = recomendado;
    }

}
