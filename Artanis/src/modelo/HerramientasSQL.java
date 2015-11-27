/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import ram.Herramientas;

/**
 *
 * @author UnderSen
 */
public class HerramientasSQL extends ConexionSQL{
        private DefaultTableModel tablemodel = new DefaultTableModel();
    
    public boolean insertHerramientas(Herramientas h ){
        
        try {
          String sql ="insert into herramientas values("+0+",'"+h.getNombre_herr()+"','"+h.getDescripcion_herr()+"',"+h.getValor_herr()+",'"+h.getMarca_herr()
                  +"','"+h.getFecha_ing_herr()+"','"+h.getFecha_mod_herr()+","+h.getId_prov()+"')";
            try (PreparedStatement pstm = this.getConexion().prepareStatement(sql)) {
                pstm.execute();
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        }      
    }
    
    public boolean updateHerramientas(Herramientas h ){
        
        try {
          String sql ="update herramientas set nombre_herr='"+h.getNombre_herr()+"', descripcion_herr='"+h.getDescripcion_herr()+"',valor_herr="+h.getValor_herr()
                  +", marca_herr='"+h.getMarca_herr()+"',fecha_mod_herr='"+h.getFecha_mod_herr()+"' , id_prov="+h.getId_prov()+" where id_herr="+h.getId_herr()+" ";
          
            try (PreparedStatement pstm = this.getConexion().prepareStatement(sql)) {
                pstm.execute();
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        }      
    }
    
      public DefaultTableModel getTablaHerr() {
          
          

        String[] columNames = {"ID", "Nombre", "Valor", "Fecha Modificacion", "Proveedor"};
    int registrosHerr = 0;
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
            
            tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.tablemodel;
    }

    

    
}
