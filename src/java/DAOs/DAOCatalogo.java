/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import conexion.conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelos.Articulo;
import modelos.Catalogo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author camilo
 */
public class DAOCatalogo {

    private JdbcTemplate jdbcTemplate;

    public DAOCatalogo() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    /**
     * Este metodo captura todos los catalogos en forma descendente
     *
     * @return retorna una lista con todos los Catalogos
     */
    public List<Catalogo> seleccionarCatalogos() {
        String sql = "select * from catalogo order by idCatalogo desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    /**
     * este metodo guarda un autor en la base de datos
     *
     * @param a catalogo que se quiere guardar
     * @return
     */
    public int guardarCatalogo(Catalogo a) {
        return jdbcTemplate.update("insert into catalogo (nombre,fecha,archivo,editorial)"
                + "values (?,?,?,?);",
                a.getNombre(),
                a.getFecha(),
                a.getArchivo(),
                this.jdbcTemplate.queryForInt("(select idEditorial from editorial where nombre='" + a.getEditorial() + "')"));

    }

    /**
     * Este metodo captura todos(nombres, fechas, y archivos del del catalogo)los Autores en forma
     * ascendente
     *
     * @return retorna una lista con todos los Articulos
     */
    public List<Catalogo> seleccionarCatalogoVistaGeneral() {
        String sql = "select nombre,fecha,archivo from catalogo order by idCatalogo asc";
        List<Catalogo> ca = this.jdbcTemplate.query(sql, new RowMapper<Catalogo>() {
            @Override
            public Catalogo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Catalogo cat = new Catalogo();
                cat.setNombre(rs.getString(1));
                cat.setFecha(rs.getString(2));
                cat.setArchivo(rs.getString(3));
                return cat;
            }
        });
        return ca;
    }

    /**
     * elimina un autores de la base de datos
     *
     * @param id id del autor que se quiere eliminar
     * @return
     */
    public int eliminarCatalogo(int id) {
        return jdbcTemplate.update("delete from catalogo "
                + "where "
                + "idCatalogo=?;", id);
    }

    /**
     * edita los datos de un catalogo en la base de datos
     *
     * @param a catalogo a modificar con los datos que se quieren cambiar
     * @param id id del catalogo que se quiere cambiar
     * @return
     */
    public int editarCatalogo(Catalogo a, int id) {
        int rs = jdbcTemplate.update("update catalogo "
                + "set "
                + "nombre = ?,"
                + "fecha = ?,"
                + "archivo = ?,"
                + "editorial = ? "
                + "WHERE idCatalogo=?",
                a.getNombre(),
                a.getFecha(),
                a.getArchivo(),
                this.jdbcTemplate.queryForInt("(select idEditorial from editorial where nombre = ?)", a.getEditorial()),
                id);
        return rs;
    }

    /**
     * captura los datos de una catalogo de la base de datos
     *
     * @param id id del catalogo que es requerido
     * @return retorna un catalogo
     */
    public Catalogo seleccionarCatalogo(int id) {
        final Catalogo cata = new Catalogo();
        String quer = "SELECT * FROM catalogo WHERE idCatalogo=" + id;
        return (Catalogo) jdbcTemplate.query(quer, new ResultSetExtractor<Catalogo>() {
            public Catalogo extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    cata.setNombre(rs.getString("nombre"));
                    cata.setFecha(rs.getString("fecha"));
                    cata.setArchivo(rs.getString("archivo"));
                    cata.setEditorial(rs.getString("editorial"));
                }
                return cata;
            }

        }
        );
    }
}
