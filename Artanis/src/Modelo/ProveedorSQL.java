/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author UnderSen
 */
public class ProveedorSQL extends ConexionSQL{
    
    public ArrayList getProveedor()  {
     
       
        
     ArrayList<String> prov = new ArrayList<>();
     try {
            PreparedStatement pstm = this.getConexion().prepareStatement("select * from proveedor");

         try (ResultSet res = pstm.executeQuery()) {
             
             int i = 0;
             while (res.next()) {
                 prov.add(res.getString("nombre_prov"));
             }
         }  
            return prov;
    }catch(Exception ex){
        System.out.println(ex.getMessage());
        
         return prov;
    }
    }

    
}
