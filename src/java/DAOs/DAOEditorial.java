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
import modelos.Editorial;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author camilo
 */
public class DAOEditorial {

    private JdbcTemplate jdbcTemplate;

    public DAOEditorial() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    /**
     * 
     * @return 
     */
    public List<Editorial> seleccionarEditorial() {
        String sql = "select * from editorial order by idEditorial desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    /**
     * Este metodo captura todos nombres y id de las editoriales
     * en forma ascendente
     * @return retorna una lista con todos las Editoriales
     */
    public List<Editorial> seleccionarNombreEditorial() {
        String sql = "select idEditorial, nombre from editorial order by idEditorial asc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    
    public int guardarEditorial(Editorial e) {
        return jdbcTemplate.update("insert into editorial(nombre,correoContacto,telefonoContacto,direccion)values(?,?,?,?)",
                e.getNombre(),
                e.getCorreoContacto(),
                e.getTelefonoContacto(),
                e.getDireccion());
    }
   /**
    * elimina una editorial de la base de datos
    * @param id id de la editoria que se desea elimnar
    * @return 
    */

    public int eliminarEditorial(int id) {
        String sql = "delete from editorial "
                + "where "
                + "idEditorial=" + id + ";";
        return jdbcTemplate.update(sql);
    }
    /**
     * metodo edita los datos de una editorial en la base de datos
     * @param e 
     * @param id
     * @return 
     */
    public int editarEditorial(Editorial e, int id) {
        String sql = "update editorial "
                + "set nombre='" + e.getNombre() + "',"
                + "correoContacto='" + e.getCorreoContacto() + "',"
                + "telefonoContacto='" + e.getTelefonoContacto() + "',"
                + "direccion='" + e.getDireccion() + "'"
                + "where "
                + "idEditorial=" + id + ";";
        return jdbcTemplate.update(sql);
    }

    public Editorial seleccionarEditorial(int id) {
        final Editorial user = new Editorial();
        String quer = "SELECT * FROM editorial WHERE idEditorial=" + id;
        return (Editorial) jdbcTemplate.query(
                quer, new ResultSetExtractor<Editorial>() {
            public Editorial extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setNombre(rs.getString("nombre"));
                    user.setCorreoContacto(rs.getString("correoContacto"));
                    user.setTelefonoContacto(rs.getString("telefonoContacto"));
                    user.setDireccion(rs.getString("direccion"));
                }
                return user;
            }

        }
        );
    }

}
