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
public class Articulo {

    private int idArticulo;
    private String editorial;
    private String Autor;
    private String categoria;
    private String titulo;
    private int precio;
    private int cantidad;
    private int calificacion;
    private int oferta;
    private int porcentajeoferta;
    private String fecha;
    private String formato;
    private String ISBN;
    private String idioma;
    private byte[] foto;

    public Articulo(int idArticulo, String editorial, String Autor, String categoria, String titulo, int precio, int cantidad, int calificacion, int oferta, int porcentajeoferta, String fecha, String formato, String isbn, String idioma, byte[] foto) {
        this.idArticulo = idArticulo;
        this.editorial = editorial;
        this.Autor = Autor;
        this.categoria = categoria;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.calificacion = calificacion;
        this.oferta = oferta;
        this.porcentajeoferta = porcentajeoferta;
        this.fecha = fecha;
        this.formato = formato;
        this.ISBN = isbn;
        this.idioma = idioma;
        this.foto = foto;
    }

    public Articulo() {
    }

    public Articulo(String editorial, String Autor, String categoria, String titulo, int precio, int cantidad, int calificacion, int oferta, int porcentajeoferta, String fecha, String formato, String isbn, String idioma, byte[] foto) {
        this.editorial = editorial;
        this.Autor = Autor;
        this.categoria = categoria;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.calificacion = calificacion;
        this.oferta = oferta;
        this.porcentajeoferta = porcentajeoferta;
        this.fecha = fecha;
        this.formato = formato;
        this.ISBN = isbn;
        this.idioma = idioma;
        this.foto = foto;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    
    public int getIdArticulo() {
        return idArticulo;
    }

    
    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

   
    public String getEditorial() {
        return editorial;
    }

    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
   
    public String getAutor() {
        return Autor;
    }

  
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    
    public String getCategoria() {
        return categoria;
    }

    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public int getPrecio() {
        return precio;
    }

    
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
    public int getCalificacion() {
        return calificacion;
    }

    
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

   
    public int getOferta() {
        return oferta;
    }

    
    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    
    public int getPorcentajeoferta() {
        return porcentajeoferta;
    }

    
    public void setPorcentajeoferta(int porcentajeoferta) {
        this.porcentajeoferta = porcentajeoferta;
    }

   
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
