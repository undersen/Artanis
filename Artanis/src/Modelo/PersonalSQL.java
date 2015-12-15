/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ram.Personal;





/**
 *
 * @author Tomas
 */
public class PersonalSQL extends ConexionSQL{
    
      public  boolean ingreso(Personal p)
    {
        /* String Sql = ;
        System.out.println(Sql);
        try{
            
           
             PreparedStatement pstm = this.getConexion().prepareStatement(Sql);
            pstm.execute();
            pstm.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
            
        }
                    */return true;
    }
      
      public boolean insertPersonal(Personal p ){
          try{
          
          String sql="insert into personal values ("+
                  0+","+p.getRut_per()+","+p.getDv_per()+",'"+
                  p.getPri_nombre_per()+"','"+p.getSeg_nombre_per()+"','"+
                  p.getApellidoP_per()+"','"+p.getApellidoM_per()+"','"+p.getDireccion_per()+"','"+p.getFecha_nac_per()+"',"
                  +p.getId_prev()+","+p.getId_afp()+",'"+p.getTelefono_per()+"','"+p.getCelular_per()+"','"+p.getFecha_ingreso_per()+"',"
                  +p.getId_car()+","+p.getValor_hh_per()+","+p.getSueldo_per()+",'"+p.getTipo_jornada_per()+"')";
          
              System.out.println(sql);
          
          PreparedStatement pstm = this.getConexion().prepareStatement(sql);
            pstm.execute();
            pstm.close();
          }catch(Exception ex)
          {
              return false;
          }
          return true;
      }
      
      
      
      
    public String[] getAFP() throws SQLException
    {
        String Sql ="select * from afp" ;
        String [] afp = null;
        int i = 0;
         try{
             PreparedStatement pstm = this.getConexion().prepareStatement(Sql);
             ResultSet res = pstm.executeQuery();
            
            while (res.next()) {
                afp[i] = res.getString("nombre_afp");
             i++;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         return afp;
    }
         
    public void getPrevision()
    {
       String Sql ="select * from prevision" ;
        try{
            
           
             PreparedStatement pstm = this.getConexion().prepareStatement(Sql);
            pstm.execute();
            pstm.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            
            
        }
       
    }
             
        public void getCargo()
    {
       String Sql ="select * from cargo" ;
        try{
            
           
             PreparedStatement pstm = this.getConexion().prepareStatement(Sql);
            pstm.execute();
            pstm.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            
            
        }
       
    }
}
