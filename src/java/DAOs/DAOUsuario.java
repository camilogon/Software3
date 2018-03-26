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
import modelos.Usuarios;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author camilo
 */
public class DAOUsuario {

    private JdbcTemplate jdbcTemplate;

    public DAOUsuario() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    public List<Usuarios> select() {
        String sql = "select * from usuario order by idUsuario desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    public int save(Usuarios u) {

        return jdbcTemplate.update("insert into usuario (nombre,apellido,correo,contrasena,nomUsuario,telefono,tipo) values (?,?,?,?,?,?,?)",
                u.getNombre(), u.getApellido(), u.getCorreo(), u.getContrasena(), u.getNomUsuario(), u.getTelefono(), u.getTipo());
    }

    public int detelte(int id) {
        String sql = "delete from usuario "
                + "where "
                + "idUsuario=" + id + ";";
        return jdbcTemplate.update(sql);
    }

    public int editUsuarios(Usuarios u, int id) {
        return jdbcTemplate.update("update usuario "
                + "set nombre=?,"
                + "apellido=?,"
                + "correo=?,"
                + "contrasena=?,"
                + "nomUsuario=?,"
                + "telefono=?,"
                + "tipo=?"
                + "where "
                + "idUsuario=? ",
                u.getNombre(), u.getApellido(), u.getCorreo(), u.getContrasena(), u.getNomUsuario(), u.getTelefono(), u.getTipo(), id);
    }

    public Usuarios selectUsuario(int id) {
        final Usuarios user = new Usuarios();
        String quer = "SELECT * FROM usuario WHERE idUsuario=" + id;
        return (Usuarios) jdbcTemplate.query(
                quer, new ResultSetExtractor<Usuarios>() {
            public Usuarios extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    user.setNombre(rs.getString("nombre"));
                    user.setApellido(rs.getString("apellido"));
                    user.setCorreo(rs.getString("correo"));
                    user.setContrasena(rs.getString("contrasena"));
                    user.setNomUsuario(rs.getString("nomUsuario"));
                    user.setTelefono(rs.getString("telefono"));
                    user.setTipo(rs.getString("tipo"));
                }
                return user;
            }

        }
        );
    }
}
