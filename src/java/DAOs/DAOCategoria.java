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
import modelos.Categoria;
import modelos.Editorial;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author camilo
 */
public class DAOCategoria {

    private JdbcTemplate jdbcTemplate;

    public DAOCategoria() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    /**
     * Este metodo captura todos los categorias en forma descendente
     *
     * @return retorna una lista con todos los categorias
     */
    public List<Categoria> seleccionarCategorias() {
        String sql = "select * from categoria order by idCategoria desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    /**
     * Este metodo captura todos(nombres, fechas, y archivos del del
     * catalogo)los Autores en forma ascendente
     *
     * @return retorna una lista con todos los Articulos
     */
    public List<Categoria> seleccionarNombresCategorias() {
        String sql = "select idCategoria,nombre from categoria order by idCategoria asc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    /**
     * Este metodo guarda genera un registstro de una categoria en la BD
     *
     * @return
     */
    public int guardarCategoria(Categoria cate) {
        return jdbcTemplate.update("insert into categoria (nombre,descripcion,influencia)values(?,?,?)",
                cate.getNombre(),
                cate.getDescripcion(),
                cate.getInfluencia());
    }

    /**
     * elimina un registro de una categoria de la BD
     *
     * @param id id de la categoria que se quiere eliminar
     * @return
     */
    public int eliminarCategoria(int id) {
        return jdbcTemplate.update("delete from categoria "
                + "where "
                + "idCategoria=?", id);
    }

    /**
     * edita una categoria en la base de datos
     *
     * @param cate categoria que se va amoficiacar
     * @param id id de la categoria que se quiere modificar
     * @return
     */
    public int editarCategoria(Categoria cate, int id) {
        return jdbcTemplate.update("update categoria "
                + "set nombre=?,"
                + "descripcion=?,"
                + "influencia=? "
                + "where "
                + "idCategoria=?", cate.getNombre(), cate.getDescripcion(), cate.getInfluencia(), id);
    }

    public Categoria SeleccionarCategoria(int id) {
        final Categoria categoria = new Categoria();
        String quer = "SELECT * FROM categoria WHERE idCategoria=" + id;
        return (Categoria) jdbcTemplate.query(
                quer, new ResultSetExtractor<Categoria>() {
            public Categoria extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    categoria.setNombre(rs.getString("nombre"));
                    categoria.setDescripcion(rs.getString("descripcion"));
                    categoria.setInfluencia(rs.getString("influencia"));
                }
                return categoria;
            }

        }
        );
    }
}
