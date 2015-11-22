/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Miguel Saavedra.
 */
public class ConexionSQL {

    /* DATOS PARA LA CONEXION */
    private String db = "artanis";
    private String user = "root";
    private String pass = "123456";
    private String url = "jdbc:mysql://localhost/" + db;
    private Connection conn = null;

    public ConexionSQL() {

        this.url = "jdbc:mysql://localhost/" + this.db;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            if (conn != null) {
                System.out.println("[database] OK base de datos " + this.db + " listo");
            } else {
                System.out.println("[database] Problemas con la conexión  " + this.db + " ");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    boolean ConexionSQL(boolean a) {
    return a;
    }

    public Connection getConexion() {
        return this.conn;
    }
}
