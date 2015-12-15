/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel Saavedra.
 */
public class ConexionSQL {

    /* DATOS PARA LA CONEXION */
    private String db = "artanis";
    private String user = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3307/" + db;
    private Connection conn = null;

    public  ConexionSQL() {

        this.url = "jdbc:mysql://localhost:3307/" + this.db;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            if (conn != null) {
                //System.out.println("[database] OK base de datos " + this.db + " listo");
                
            } else {
                System.out.println("[database] Problemas con la conexión  " + this.db);
                
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }

    boolean ConexionSQL(boolean a) {
    return a;
    }

    public Connection getConexion() {
        return this.conn;
    }
}
