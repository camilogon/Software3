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
import modelos.ventas;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author camilo
 */
public class DAOVentas {

    private JdbcTemplate jdbcTemplate;

    public DAOVentas() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    public List<ventas> seleccionarVentas() {
        String sql = "select * from venta order by idVenta desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    public int selectMaxIdVentas() {
        final ventas user = new ventas();
        String quer = "SELECT max(idVenta) FROM venta";
        return jdbcTemplate.queryForInt(quer);
    }

    /**
     * se ingresa un registro en las ventas
     *
     * @param usuario id del usuario que realiza la compra
     * @param fechaCompra fecha en que se realiza la compra
     * @param PrecioVenta precio de la compra
     * @return
     */
    public int guardarVenta(int usuario, int PrecioVenta) {
        return jdbcTemplate.update("insert into venta(usuario,precioVenta)values(?,?);",
                usuario,
                PrecioVenta);
    }

    /**
     * ingresa un reporte a la tabla ventaProducto
     *
     * @param idVenta id de la venta
     * @param idProducto id del producto
     * @param cantidad cantidad de producto actual
     * @return
     */
    public int guardarVentaCantidad(int idVenta, int idProducto, int cantidad) {
        return jdbcTemplate.update("insert into ventaProducto(idVenta,idProducto,cantidad)values(?,?,?);",
                idVenta,
                idProducto,
                cantidad);
    }

}
