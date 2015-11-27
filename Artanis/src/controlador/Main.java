/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JFrame;
import vista.frmPrincipal;


public class Main {

 
    public static void main(String[] args) {
      
      frmPrincipal p = new frmPrincipal();
      p.setExtendedState(JFrame.MAXIMIZED_BOTH);
      p.setVisible(true);
        
    }
    
}
