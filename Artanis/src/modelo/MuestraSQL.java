package modelo;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import ram.herramientas;
import ram.provedorees;

/**
 *
 * @author msaavedra
 */
public class MuestraSQL extends ConexionSQL {

    private herramientas h = new herramientas();
    private DefaultTableModel tablemodel = new DefaultTableModel();

    private int registrosHerr = 0;
    private int id_prov = 0;

    public int getRegistrosHerr() {
        return registrosHerr;
    }

    public int getId_prov() {
        return id_prov;
    }

    public MuestraSQL() {
    }

    public DefaultTableModel getTablaHerr() {

        String[] columNames = {"ID", "Nombre", "Valor", "Fecha Modificacion", "Proveedor"};

        try {
            PreparedStatement pstm = this.getConexion().prepareStatement("SELECT count(*) as total FROM herramientas");
            ResultSet res = pstm.executeQuery();
            res.next();
            registrosHerr = res.getInt("total");

            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Object[][] data = new String[registrosHerr][5];
        try {
            PreparedStatement pstm = this.getConexion().prepareStatement("SELECT h.id_herr , h.nombre_herr, h.descripcion_herr,h.valor_herr,h.fecha_ing_herr, h.fecha_mod_herr,p.id_prov,p.nombre_prov\n"
                    + "FROM herramientas as h  LEFT JOIN proveedor as p ON h.id_prov=p.id_prov\n"
                    + "GROUP BY h.id_herr , h.nombre_herr, h.descripcion_herr,h.valor_herr,h.fecha_ing_herr, h.fecha_mod_herr;");

            ResultSet res = pstm.executeQuery();

            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("h.id_herr");
                data[i][1] = res.getString("h.nombre_herr");
                data[i][2] = res.getString("h.valor_herr");
                data[i][3] = res.getString("h.fecha_mod_herr");
                data[i][4] = res.getString("p.nombre_prov");
                i++;
            }
            res.close();
            this.tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.tablemodel;
    }

    public DefaultComboBoxModel getProveedores() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            PreparedStatement pstm = this.getConexion().prepareStatement("SELECT nombre_prov,id_prov FROM proveedor");
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                
                model.addElement(new provedorees(res.getString("nombre_prov"),res.getInt("id_prov")));
              
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return model;
    }

    public herramientas getHerramientas(int id) {

        String q = "SELECT * FROM herramientas,proveedor WHERE id_herr = " + id + "";
        try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                h.setId_herr(res.getInt("id_herr"));
                h.setNombre_herr(res.getString("nombre_herr"));
                h.setDescripcion_herr(res.getString("descripcion_herr"));
                h.setValor_herr(res.getInt("valor_herr"));
                h.setFecha_ing_herr(res.getString("fecha_ing_herr"));
                h.setFecha_mod_herr(res.getString("fecha_mod_herr"));
                h.setNombre_prov(res.getString("nombre_prov"));
            }
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return h;
    }

    public boolean validar_formularo_herramientas(String nombre_herr, String valor_herr) {

        if (nombre_herr.length() > 0 && valor_herr.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ModificaHerramientas(
            int id_herr,
            String nombre_herr,
            String descripcion_herr,
            int valor_herr,
            String fecha_ing_herr,
            String fecha_mod_herr,
            int id_prov
    ) {

        String q = "UPDATE herramientas SET "
                + "nombre_herr = '" + nombre_herr + "',"
                + "descripcion_herr   = '" + descripcion_herr + "',"
                + "valor_herr  = " + valor_herr + ","
                + "fecha_ing_herr  = '" + fecha_ing_herr + "',"
                + "fecha_mod_herr  = '" + fecha_mod_herr + "'"
                + "fecha_mod_herr  = " + id_prov + ""
                + " WHERE id_cli =" + id_herr + "";

        try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;

    }

}
