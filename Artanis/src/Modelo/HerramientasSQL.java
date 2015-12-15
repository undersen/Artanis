/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


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
     DefaultTableModel tableModel = new DefaultTableModel() {

    @Override
    public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
    }
};
    
    public boolean insertHerramientas(Herramientas h ){
        try {
          String sql ="insert into herramientas values("+0+",'"+h.getNombre_herr()+"','"+h.getDescripcion_herr()+"',"+h.getValor_herr()+",'"+h.getMarca_herr()
                  +"','"+h.getFecha_ing_herr()+"','"+h.getFecha_mod_herr()+"',(select id_prov from proveedor where nombre_prov='"+h.getNombre_prov()+"'),'"+h.getEstado_herr()+"','enable')";
            System.out.println(sql);
            try (PreparedStatement pstm = this.getConexion().prepareStatement(sql)) {
                pstm.execute();
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        }      
    }
    
    public boolean updateHerramientas(Herramientas h){
        
        try {
          String sql ="update herramientas set nombre_herr='"+h.getNombre_herr()+"', descripcion_herr='"+h.getDescripcion_herr()+"',valor_herr="+h.getValor_herr()
                  +", marca_herr='"+h.getMarca_herr()+"',fecha_mod_herr='"+h.getFecha_mod_herr()+"' , id_prov=(select id_prov from proveedor where nombre_prov='"+h.getNombre_prov()+"'), estado_herr='"+h.getEstado_herr()+"' where id_herr="+h.getId_herr()+" ";
            System.out.println(sql);
            try (PreparedStatement pstm = this.getConexion().prepareStatement(sql)) {
                pstm.execute();
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;

        }      
    }
    
      public boolean deleteHerramientas(int id){
        
        try {
          String sql ="update herramientas set state_herr='disable' where id_herr="+id+" ";
          
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
                    + "FROM herramientas as h  LEFT JOIN proveedor as p ON h.id_prov=p.id_prov where h.state_herr='enable'\n"
                    + "GROUP BY h.id_herr , h.nombre_herr, h.descripcion_herr,h.valor_herr,h.fecha_ing_herr, h.fecha_mod_herr;");
            System.out.println(pstm);
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
            
            tableModel.setDataVector(data, columNames);
            tableModel.isCellEditable(i, i);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.tableModel;
    }
      
      
       public DefaultTableModel getTablaHerrByKey(String name) {

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
                    + "FROM herramientas as h  LEFT JOIN proveedor as p ON h.id_prov=p.id_prov where h.state_herr='enable' and name_herr\n"
                    + "GROUP BY h.id_herr , h.nombre_herr, h.descripcion_herr,h.valor_herr,h.fecha_ing_herr, h.fecha_mod_herr;");
            System.out.println(pstm);
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
            
            tableModel.setDataVector(data, columNames);
            tableModel.isCellEditable(i, i);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.tableModel;
    }
      
      
      
      
      
       public Herramientas getHerrById(int id) {
            Herramientas herr= new Herramientas();
       
        try {
            PreparedStatement pstm = this.getConexion().prepareStatement("SELECT h.id_herr , h.nombre_herr, marca_herr ,h.descripcion_herr,h.valor_herr,h.fecha_ing_herr, h.fecha_mod_herr,p.id_prov,p.nombre_prov, h.estado_herr ,h.state_herr \n"
                    + "FROM herramientas as h  LEFT JOIN proveedor as p ON h.id_prov=p.id_prov where h.state_herr='enable' and h.id_herr="+id+"\n"
                    + "GROUP BY h.id_herr , h.nombre_herr, h.descripcion_herr,h.valor_herr,h.fecha_ing_herr, h.fecha_mod_herr;");
            
            System.out.println(pstm);
            ResultSet res = pstm.executeQuery();
          
            while(res.next()){
                herr.setId_herr(res.getInt("h.id_herr"));
                herr.setNombre_herr(res.getString("nombre_herr"));
                herr.setMarca_herr(res.getString("marca_herr"));
                herr.setNombre_prov(res.getString("nombre_prov"));
                herr.setDescripcion_herr(res.getString("descripcion_herr"));
                herr.setEstado_herr(res.getString("estado_herr"));
                herr.setValor_herr(res.getInt("valor_herr"));
                herr.setFecha_mod_herr(res.getDate("fecha_mod_herr").toString());
            }
            res.close();
            
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return herr;
    }

       
       
       public void  VerificarTabla() throws SQLException 
       { 
           boolean a =false;
           String sql ="select * from herramientas";
       PreparedStatement pstm = (PreparedStatement) this.getConexion();
           System.out.println(sql);
         try (ResultSet res = pstm.executeQuery(sql)) {
             while (res.next()) {
                 
                 String asd;
                 asd = res.getString("nombre_herr");
                 a=true;
                 System.out.println(asd);
             }
         }
            
          
    
    }
       }
         
       



