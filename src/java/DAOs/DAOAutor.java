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
import modelos.Autor;
import modelos.ValidacionesAutor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author camilo
 */
public class DAOAutor {

    private JdbcTemplate jdbcTemplate;

    public DAOAutor() {

        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    /**
     * Este metodo captura todos los Autores en forma descendente
     *
     * @return retorna una lista con todos los Articulos
     */
    public List<Autor> seleccionarAutor() {
        String sql = "select * from autor order by idAutor desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    
    /**
     * Este metodo captura todos(nombre y id del autor)los Autores en forma ascendente
     * @return retorna una lista con todos los Articulos
     */
    public List<Autor> seleccionarNombreAutores() {
        String sql = "select idAutor, nombre from autor order by idAutor asc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    /**
     * este metodo guarda un autor en la base de datos
     * @param a autor que se quiere guardar
     * @return 
     */
    public int guardarAutor(Autor a) {
        return jdbcTemplate.update("insert into autor (nombre,descripcion,recomendado) values (?,?,?);",
                a.getNombre(),
                a.getDescripcion(),
                a.getRecomendado());
    }
    /**
     * elimina un autore de la base de datos
     * @param id id del autor que se quiere eliminar
     * @return 
     */
    public int eliminarAutor(int id) {
        return jdbcTemplate.update("delete from autor "
                + "where "
                + "idAutor=?;", id);
    }
    /**
     * edita los datos de un atuor en la base de datos
     * @param a autor a modificar con los datos que se quieren cambiar
     * @param id id del autor que se quiere cambiar
     * @return 
     */
    public int editarAutor(Autor a, int id) {
        return jdbcTemplate.update("update autor"
                + "nombre =?,"
                + "descripcion=?,"
                + "recomendado=?,"
                + "where idAutor=?", a.getNombre(), a.getDescripcion(), a.getRecomendado(), a.getId());
    }
    /**
     * captura los datos de una autor de la base de datos
     * @param id id del autor que es requerido
     * @return retorna un autor
     */
    public Autor seleccionarAutor(int id) {
        final Autor user = new Autor();
        String quer = "SELECT * FROM autor WHERE idAutor=" + id;
        return (Autor) jdbcTemplate.query(
                quer, new ResultSetExtractor<Autor>() {
            public Autor extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setNombre(rs.getString("nombre"));
                    user.setDescripcion(rs.getString("descripcion"));
                    user.setRecomendado(rs.getString("recomendado"));
                }
                return user;
            }

        }
        );
    }

}
