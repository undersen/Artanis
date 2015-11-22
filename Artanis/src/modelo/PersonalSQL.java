/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
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
}
