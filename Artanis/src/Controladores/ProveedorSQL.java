/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ram.Proveedor;

/**
 *
 * @author UnderSen
 */
public class ProveedorSQL extends ConexionSQL{
    
    public ArrayList getProveedor() throws SQLException {
     
     ArrayList<String> prov = new ArrayList<>();
     try {
            PreparedStatement pstm = this.getConexion().prepareStatement("select * from proveedor");

            ResultSet res = pstm.executeQuery();

            int i = 0;
            while (res.next()) {
               prov.add(res.getString("nombre_prov"));
               
            }
            res.close();
            
            return prov;
    }catch(Exception ex){System.out.println(ex.getMessage());
        
         return prov;
    }
    }

    
}
