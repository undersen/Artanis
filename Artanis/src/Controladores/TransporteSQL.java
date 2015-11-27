/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ram.*;

/**
 *
 * @author Tomas
 */
public class TransporteSQL extends ConexionSQL{
    
    
    
    public  boolean ingreso(Transporte t)
    {
         String Sql = "insert into transporte values("+0+",'"+t.getNombreTransporte()+"','"+t.getDescripcionTransporte()+"',"+t.getValorTransporte()+")";
        System.out.println(Sql);
        try{
            
           
             PreparedStatement pstm = this.getConexion().prepareStatement(Sql);
            pstm.execute();
            pstm.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
            
        }
                    return true;
    }
}
