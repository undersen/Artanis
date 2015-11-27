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
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.IngresoSQL;
import modelo.MuestraSQL;
import modelo.RescataFechaSistema;
import ram.Herramientas;
import ram.Provedorees;
import vista.frmHerrMan;
import vista.frmHerramientas;
import vista.frmPrincipal;

public class Controlador implements ActionListener, MouseListener {

    //*** Importar Clases  ***
    private frmPrincipal frmprincipal;
    private frmHerrMan frmherrman = new frmHerrMan();
    private frmHerramientas frmherramientas = new frmHerramientas();
    private RescataFechaSistema fechaSistema = new RescataFechaSistema();
    private MuestraSQL modelo = new MuestraSQL();
    private IngresoSQL INT = new IngresoSQL();
    private Herramientas h = new Herramientas();

    //*** Variable globales ***
    private static int MENSAJE = 0;
    private static String IDtablaCot = null;
    private static String IDtablaherr = null;

    public enum Accion {

        __VER_HERRAMIENTAS,
        __VER_HERRMAN,
        __GUARDAR_HERRMAN,
        __MODIFICAR_HERRMAN,
    }

    public Controlador(JFrame padre) {
        this.frmprincipal = (frmPrincipal) padre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
           switch (Accion.valueOf(e.getActionCommand())) {

            case __VER_HERRAMIENTAS:

                this.frmherramientas.setVisible(true);
                break;

            case __VER_HERRMAN:

                this.frmherrman.setTitle("Ingresar Herramienta");
                this.frmherrman.setVisible(true);
                break;

            case __GUARDAR_HERRMAN:

                if (this.frmherrman.getTitle().equalsIgnoreCase("Ingresar Herramienta")) {

                    guardaHerramientas();

                } else if (this.frmherrman.getTitle().equalsIgnoreCase("Modificar Herramienta")) {

                }

                break;

            case __MODIFICAR_HERRMAN:

                LLenaFrmHerr();
                this.frmherrman.setTitle("Modificar Herramienta");
                this.frmherrman.setVisible(true);

                break;

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

    public void iniciar() {
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frmprincipal);
            this.frmprincipal.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
         
            this.frmprincipal.setLocationRelativeTo(null);
            this.frmprincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //this.frmprincipal.tabla.setModel(this.modelo.getTablaCotizaciones());
            this.frmprincipal.setTitle("Artanis");
            this.frmprincipal.setVisible(true);

            
            this.frmherramientas.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
            this.frmherramientas.setLocationRelativeTo(null);
            this.frmherramientas.setResizable(false);
            this.frmherramientas.setIconImage(new ImageIcon(getClass().getResource("/imagen/16herr.png")).getImage());
            this.frmherramientas.tablaHerr.setModel(this.modelo.getTablaHerr());
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

    public void guardaHerramientas() {

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
                    
                } else {
                    this.frmherrman.lbmensaje.setVisible(true);
                    this.frmherrman.lbmensaje.setText("Error: Con la Base de Datos.");
                }

            } else {
                this.frmherrman.lbmensaje.setVisible(true);
                this.frmherrman.lbmensaje.setText("Los campos con (*) son obligatorios");
            }
        }
    }

    public void LLenaFrmHerr() {
        Herramientas tmp = this.modelo.getHerramientas(Integer.parseInt(IDtablaherr));
        this.frmherrman.txtNombre.setText(String.valueOf(tmp.getNombre_herr()));
        this.frmherrman.txtDescripcion.setText(String.valueOf(tmp.getDescripcion_herr()));
        this.frmherrman.txtValor.setText(String.valueOf(tmp.getValor_herr()));
        this.frmherrman.cmbProv.setSelectedItem("CASANOVA");
        
        //this.frmherrman.cmbProv.setToolTipText(String.valueOf(tmp.getNombre_prov()));
        this.frmherrman.lbUltimaMod.setText(String.valueOf(tmp.getFecha_ing_herr()));
       // this.frmherrman.cmbCristal.setSelectedItem(String.valueOf(tmp.getId_prov()));

    }

  
}
