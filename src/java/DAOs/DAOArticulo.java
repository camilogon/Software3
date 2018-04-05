/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import conexion.conexion;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelos.Articulo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Team Scrip
 */
public class DAOArticulo {

    private JdbcTemplate jdbcTemplate;

    public DAOArticulo() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    /**
     * Este metodo captura todos los articulos en forma descendente
     *
     * @return retorna una lista con todos los Articulos
     */
    public List<Articulo> seleccionarArticulo() {
        String sql = "select * from articulo order by idArticulo desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    /**
     * Este metodo selecciona de los articulos el titulo, el precio, la foto, el
     * IdArticulo y el ISBN de la base de datos
     * 
     * @param recomendado esta variable me difine si retorna todos los articulos o
     * los articulos recomendados
     * 
     * @return retorna la lista de todos los articulos o de los articulos recomendados
     * con los datos mencionados anteriormente
     */
    public List<Articulo> seleccionarArticulosVistaDetallada(boolean recomendado) {
        String sql="";
        if (!recomendado) {
           sql = "select titulo,precio,foto,idArticulo,ISBN from articulo order by idArticulo asc";
        } else {
           sql = "select DISTINCT a.titulo,a.precio,a.foto,a.idArticulo,ISBN \n" +
                          "from articulo a inner join ventaproducto vp \n" +
                          "on vp.idProducto=a.idArticulo \n" +
                          "GROUP by vp.cantidad \n" +
                          "order by idArticulo asc";
        }
        //select DISTINCT a.titulo,a.precio,a.foto,a.idArticulo,a.ISBN from articulo a inner join ventaproducto vp on vp.idProducto=a.idArticulo GROUP by a.titulo order by count(a.titulo) DESC
        List<Articulo> a = this.jdbcTemplate.query(sql, new RowMapper<Articulo>() {
            @Override
            public Articulo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Articulo ar = new Articulo();
                ar.setTitulo(rs.getString(1));
                ar.setPrecio(rs.getInt(2));
                ar.setFoto(rs.getBytes(3));
                ar.setIdArticulo(rs.getInt(4));
                ar.setISBN(rs.getString(5));
                return ar;
            }
        });
//     

        return a;
    }

    /**
     * este metodo guarda un Articulo en la base de datos
     *
     * @param a Articulo que se quiere guardar en la base de datos
     * @return
     */
    public int guardarArticulo(Articulo a) {
        return jdbcTemplate.update("insert into articulo (editorial,autor,categoria,titulo,precio,cantidad,calificacion,"
                + "oferta,porcentajeOferta,idioma,fechaEdicion,formato,ISBN,foto) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);",
                this.jdbcTemplate.queryForInt("(select idEditorial from editorial where nombre='" + a.getEditorial() + "')"),
                this.jdbcTemplate.queryForInt("(select idAutor from autor where nombre='" + a.getAutor() + "')"),
                this.jdbcTemplate.queryForInt("(select idCategoria from categoria where nombre='" + a.getCategoria() + "')"),
                a.getTitulo(),
                a.getPrecio(),
                a.getCantidad(),
                a.getCalificacion(),
                a.getOferta(),
                a.getPorcentajeoferta(),
                a.getIdioma(),
                a.getFecha(),
                a.getFormato(),
                a.getISBN(),
                a.getFoto()
        );

    }

    /**
     * Elimina un articulo de la base de datos
     *
     * @param id captura el id del articulo
     * @return
     */
    public int eliminaArticulo(int id) {
        return jdbcTemplate.update("delete from Articulo "
                + "where "
                + "idArticulo=?;", id);
    }

    /**
     * Modifica la informacion del articulo
     *
     * @param a Informacion del articulo
     * @param id id del articulo que se quiere modificar
     * @return
     */
    public int editarArticulo(Articulo a, int id) {
        return jdbcTemplate.update("update Articulo "
                + "set "
                + "editorial = ?,"
                + "autor = ?,"
                + "categoria = ?,"
                + "titulo = ?,"
                + "precio = ?,"
                + "cantidad = ?,"
                + "calificacion = ?,"
                + "oferta = ?,"
                + "porcentajeOferta = ?,"
                + "idioma = ?,"
                + "fechaEdicion = ?,"
                + "formato = ?,"
                + "ISBN = ?,"
                + "foto = ? "
                + "where idArticulo = ?",
                this.jdbcTemplate.queryForInt("(select idEditorial from editorial where nombre= ?)", a.getEditorial()),
                this.jdbcTemplate.queryForInt("(select idAutor from autor where nombre= ?)", a.getAutor()),
                this.jdbcTemplate.queryForInt("(select idCategoria from categoria where nombre= ?)", a.getCategoria()),
                a.getTitulo(),
                a.getPrecio(),
                a.getCantidad(),
                a.getCalificacion(),
                a.getOferta(),
                a.getPorcentajeoferta(),
                a.getIdioma(),
                a.getFecha(),
                a.getFormato(),
                a.getISBN(),
                a.getFoto(),
                id);
    }

    /**
     * Este metodo captura un articulo de la base de datos
     *
     * @param id id del articulo que se desea capturar la informacion
     * @return articulo que se ha consultado en la base de datos
     */
    public Articulo seleccionarArticulo(int id) {
        final Articulo artic = new Articulo();
        String quer = "SELECT * FROM articulo WHERE idArticulo=" + id;
        return (Articulo) jdbcTemplate.query(quer, new ResultSetExtractor<Articulo>() {
            public Articulo extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    artic.setEditorial(rs.getString("editorial"));
                    artic.setAutor(rs.getString("autor"));
                    artic.setCategoria(rs.getString("categoria"));
                    artic.setTitulo(rs.getString("titulo"));
                    artic.setPrecio(rs.getInt("precio"));
                    artic.setCantidad(rs.getInt("cantidad"));
                    artic.setCalificacion(rs.getInt("calificacion"));
                    artic.setOferta(rs.getInt("oferta"));
                    artic.setPorcentajeoferta(rs.getInt("porcentajeOferta"));
                    artic.setIdioma(rs.getString("idioma"));
                    artic.setFecha(rs.getString("fechaEdicion"));
                    artic.setFormato(rs.getString("formato"));
                    artic.setISBN(rs.getString("ISBN"));
                    artic.setFoto(rs.getBytes("foto"));
                }
                return artic;
            }

        }
        );
    }
}
