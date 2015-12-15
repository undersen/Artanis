/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Aqui se agregan los modelos de datos con respecto a sus Consultas SQL 
import Modelo.HerramientasSQL;
import Modelo.PersonalSQL;
import Modelo.ProveedorSQL;
import Modelo.TransporteSQL;
import Modelo.ConexionSQL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


//Aqui se agregan las vistas
import vista.frmPrincipal;
import vista.frmHerrMan;
import vista.frmHerramientas;
import vista.frmPerMan;
import vista.frmProvMan;
import vista.frmTransMan;
import vista.frmTransporte;


//Aqui se agrega las entidades
import ram.Afp;
import ram.Cargo;
import ram.Herramientas;
import ram.Personal;
import ram.Prevision;
import ram.Proveedor;
import ram.Transporte;


public class Controlador implements ActionListener, MouseListener {

    private frmLoader loader ; 
    private frmPrincipal frmprincipal;
    private frmHerrMan frmherrman;
    private frmHerramientas frmherramientas;
    private frmPerMan frmPerMan;
    private frmProvMan frmProvMan;
    private frmTransMan frmTransMan;
    private frmTransporte frmTransporte;
    
    private Afp afp;
    private Cargo cargo;
    private Herramientas herramientas;
    private Personal personal;
    private Prevision prevision;
    private Proveedor proveedor;
    private Transporte transporte;
    
    private ConexionSQL conexionSQL;
    
    private PersonalSQL personalSQL;
    private HerramientasSQL herramientasSQL;
    private ProveedorSQL proveedorSQL;
    private TransporteSQL transporteSQL;   
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();

    //*** Variable globales ***
    private static int MENSAJE = 0;
    private static String IDtablaCot = null;
    private static String IDtablaherr = null;

    private void cargarInstanciasVista() {
       
        loader.setLabel("Cargando Instancias de las vistas");
        frmprincipal = new frmPrincipal();
        frmherrman = new frmHerrMan();
        frmherramientas = new frmHerramientas();
        frmPerMan = new frmPerMan();
        frmProvMan = new frmProvMan();
        frmTransMan = new frmTransMan();
        frmTransporte = new frmTransporte();
    }
    
     private void cargarInstanciasEntidades() {
       
        loader.setLabel("Cargando Instancias de las entidades");
       
    }
     
        private void cargarInstanciasSQL() throws InterruptedException {
       
        loader.setLabel("Cargando Instancias de Servidor"); 
        
        conexionSQL = new ConexionSQL();
        loader.setLabel("Verificando Conexion a base de datos");
        herramientasSQL = new HerramientasSQL();
        loader.setLabel("Verificando la tabla herramientas");
        personalSQL = new PersonalSQL();
        loader.setLabel("Verificando la tabla personal");
        proveedorSQL = new ProveedorSQL();
        loader.setLabel("Verificando la tabla Proveedor");
        transporteSQL = new TransporteSQL();
        loader.setLabel("Verificando transporte");

        
    }


    
    public enum Accion {

        __VER_HERRAMIENTAS,
        __VER_PERSONAL,
        __VER_HERRMAN,
        __GUARDAR_HERRMAN,
        __MODIFICAR_HERRMAN,
    }

    public Controlador() {
       
        
       // frmPerMan= new frmPerMan();
        
        //this.frmprincipal = (frmPrincipal) padre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
           switch (Accion.valueOf(e.getActionCommand())) {

            case __VER_HERRAMIENTAS:

                this.frmherramientas.setVisible(true);
                this.frmherramientas.tablaHerr.setModel(herramientasSQL.getTablaHerr());
                break;

            case __VER_HERRMAN:

                this.frmherrman.setTitle("Ingresar Herramienta");
                
                this.frmherrman.setVisible(true);
                break;
                
                
            case __MODIFICAR_HERRMAN:
                
                herramientas = herramientasSQL.getHerrById(this.frmherramientas.IDHerramienta);
                this.frmherrman.setVisible(true);
                this.frmherrman.cargarValores(herramientas);
                
                break;

            case __GUARDAR_HERRMAN:

                if (this.frmherrman.getTitle().equalsIgnoreCase("Ingresar Herramienta")) {
                    
                    
                    herramientas.setDescripcion_herr(this.frmherrman.txtDescripcion.getText());
                    herramientas.setNombre_herr(this.frmherrman.txtNombre.getText());
                    herramientas.setEstado_herr(this.frmherrman.cmbEstado.getSelectedItem().toString());
                    herramientas.setFecha_ing_herr(dateFormat.format(date));
                    herramientas.setFecha_mod_herr(dateFormat.format(date));
                    herramientas.setNombre_prov(this.frmherrman.cmbProv.getSelectedItem().toString());
                    herramientas.setNombre_prov(this.frmherrman.cmbProv.getSelectedItem().toString());
                    herramientas.setMarca_herr(this.frmherrman.txtMarca.getText());
                    herramientas.setValor_herr(Integer.parseInt(this.frmherrman.txtValor.getText()));
                    
                    herramientasSQL.insertHerramientas(herramientas);

                

                } else if (this.frmherrman.getTitle().equalsIgnoreCase("Modificar Herramienta")) {
                    
                     
                    
                    
                    

                }

                break;

                /*
            case __MODIFICAR_HERRMAN:

                LLenaFrmHerr();
                this.frmherrman.setTitle("Modificar Herramienta");
                this.frmherrman.setVisible(true);

                break;
                */

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == 1)//boton izquierdo
        {
            int filaherr = this.frmherramientas.tablaHerr.rowAtPoint(e.getPoint());
            if (filaherr > -1) {
                IDtablaherr = (String.valueOf(this.frmherramientas.tablaHerr.getValueAt(filaherr, 0)));
            }
        }

        System.out.println(IDtablaherr);

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void iniciar() throws InterruptedException {
        try {
            
        loader = new frmLoader();
        loader.setResizable(false);
        loader.setLocationRelativeTo(null);
        loader.setVisible(true);
        
        cargarInstanciasVista();
        cargarInstanciasSQL();
        cargarInstanciasEntidades();
        
        loader.dispose();
                 
            this.frmprincipal.setLocationRelativeTo(null);
            this.frmprincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.frmprincipal.setVisible(true);

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frmprincipal);
            this.frmprincipal.getContentPane().setBackground(new java.awt.Color(255, 255, 255));

            //this.frmprincipal.tabla.setModel(this.modelo.getTablaCotizaciones());
            this.frmprincipal.setTitle("Artanis");
            

            
            this.frmherramientas.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
            this.frmherramientas.setLocationRelativeTo(null);
            this.frmherramientas.setResizable(false);
            this.frmherramientas.setIconImage(new ImageIcon(getClass().getResource("/imagen/16herr.png")).getImage());
           // this.frmherramientas.tablaHerr.setModel(this.modelo.getTablaHerr());
            this.frmherramientas.setTitle("Herramientas");

            this.frmherrman.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
            this.frmherrman.setResizable(false);
            this.frmherrman.setLocationRelativeTo(null);
            this.frmherrman.setIconImage(new ImageIcon(getClass().getResource("/imagen/16herr.png")).getImage());

        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }

        //Listener Tablas
        this.frmprincipal.tabla.addMouseListener(this);
        this.frmherramientas.tablaHerr.addMouseListener(this);
        

        this.frmprincipal.jmHerramientas.setActionCommand("__VER_HERRAMIENTAS");
        this.frmprincipal.jmHerramientas.addActionListener(this);
        
        

        this.frmherramientas.btnIngresarHerr.setActionCommand("__VER_HERRMAN");
        this.frmherramientas.btnIngresarHerr.addActionListener(this);

        this.frmherramientas.btnModificarHerr.setActionCommand("__MODIFICAR_HERRMAN");
        this.frmherramientas.btnModificarHerr.addActionListener(this);

        this.frmherrman.btnGuardarHerr.setActionCommand("__GUARDAR_HERRMAN");
        this.frmherrman.btnGuardarHerr.addActionListener(this);
        
        
        
        
        
        

    }

  /*  public void guardaHerramientas() {

        MENSAJE = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea guardar?", "Confirme",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (MENSAJE == JOptionPane.YES_OPTION) {

            String nombre_err = this.frmherrman.txtNombre.getText();
            String descripcion_herr = this.frmherrman.txtDescripcion.getText();
            int id_prov = frmherrman.getId_combo_pro();
            int valor_herr = Integer.parseInt(this.frmherrman.txtValor.getText());
            String fecha_ing_herr = this.frmherrman.lbFecha.getText();
            String fecha_mod_herr = this.frmherrman.lbFecha.getText();

            if (this.INT.validar_formularo_herramientas(nombre_err, Integer.toString(valor_herr))) {
                if (this.INT.IngresoHerramientas(nombre_err, descripcion_herr, id_prov, valor_herr, fecha_ing_herr, fecha_mod_herr)) {
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente");
                    this.frmherrman.setVisible(false);
                    this.LimpiarHerr();
                } else {
                    this.frmherrman.lbmensaje.setVisible(true);
                    this.frmherrman.lbmensaje.setText("Error: Con la Base de Datos.");
                }

            } else {
                this.frmherrman.lbmensaje.setVisible(true);
                this.frmherrman.lbmensaje.setText("Los campos con (*) son obligatorios");
            }
        }
    }*/

   /* public void LLenaFrmHerr() {
        herramientas tmp = this.modelo.getHerramientas(Integer.parseInt(IDtablaherr));
        this.frmherrman.txtNombre.setText(String.valueOf(tmp.getNombre_herr()));
        this.frmherrman.txtDescripcion.setText(String.valueOf(tmp.getDescripcion_herr()));
        this.frmherrman.txtValor.setText(String.valueOf(tmp.getValor_herr()));
        this.frmherrman.cmbProv.setSelectedItem("CASANOVA");
        
        //this.frmherrman.cmbProv.setToolTipText(String.valueOf(tmp.getNombre_prov()));
        this.frmherrman.lbUltimaMod.setText(String.valueOf(tmp.getFecha_ing_herr()));
       // this.frmherrman.cmbCristal.setSelectedItem(String.valueOf(tmp.getId_prov()));

    }*/

   /* public void LimpiarHerr() {

        this.frmherramientas.tablaHerr.setModel(this.modelo.getTablaHerr());
        this.frmherramientas.lbCantidadHerr.setText(Integer.toString(this.modelo.getRegistrosHerr()));

        this.frmherrman.txtNombre.setText("");
        this.frmherrman.txtDescripcion.setText("");
        this.frmherrman.txtValor.setText("");
        this.frmherrman.cmbProv.setModel(this.modelo.getProveedores());
        this.frmherrman.lbmensaje.setText("");
        this.frmherrman.lbmensaje.setVisible(false);
        this.frmherrman.lbFecha.setText(fechaSistema.getFecha());
    }*/
    
    
}
