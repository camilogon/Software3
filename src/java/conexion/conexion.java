/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author camilo
 */
public class conexion {

    public DriverManagerDataSource conectar() {
        DriverManagerDataSource datos = new DriverManagerDataSource();
        datos.setDriverClassName("com.mysql.jdbc.Driver");
        datos.setUrl("jdbc:mysql://localhost/mercadoLibro");
        datos.setUsername("root");
        datos.setPassword("");
        return datos;
    }
}
