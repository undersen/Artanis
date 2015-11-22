package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngresoSQL extends ConexionSQL {

    public boolean IngresoPersonal(
            int rut_per,
            String dv_per,
            String nombre_per,
            String apellidos_per,
            String direccion_per,
            String fecha_nac_per,
            int id_prev,
            int id_afp,
            String telefono_per,
            String celular_per,
            String fecha_ingreso_per,
            int id_car,
            int valor_hh_per,
            int sueldo_per,
            String tipo_jornada_per
    ) {

        String q = " INSERT INTO personal (rut_per,dv_per,nombre_per,apellidos_per,direccion_per,fecha_nac_per,id_prev,id_afp,telefono_per,celular_per,fecha_ingreso_per,id_car,valor_hh_per,sueldo_per,tipo_jornada_per)"
                + " VALUES"
                + "(" + rut_per + ","
                + "'" + dv_per + "',"
                + "'" + nombre_per + "',"
                + "'" + apellidos_per + "',"
                + "'" + direccion_per + "',"
                + "'" + fecha_nac_per + "',"
                + "" + id_prev + ","
                + "" + id_afp + ","
                + "'" + telefono_per + "',"
                + "'" + celular_per + "',"
                + "'" + fecha_ingreso_per + "',"
                + "" + id_car + ","
                + "" + valor_hh_per + ","
                + "" + sueldo_per + ","
                + "'" + tipo_jornada_per + "')";

        try {
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }

        return false;
    }

    public boolean validar_formularo_herramientas(String nombre_herr, String valor_herr) {

        System.out.println("Entro " + nombre_herr + " " + valor_herr);

        if (nombre_herr.length() > 0 && valor_herr.length() > 0) {
            return true;
        } else {
            return false;
        }
    }
          
            
    public boolean IngresoHerramientas(
            String nombre_herr,
            String descripcion_herr,
            int id_prov,
            int valor_herr,
            String fecha_ing_herr,
            String fecha_mod_herr
    ) {
        
        String q = " INSERT INTO herramientas (nombre_herr,descripcion_herr,valor_herr,fecha_ing_herr,fecha_mod_herr,id_prov)"
                + " VALUES"
                + "('" + nombre_herr + "',"
                + "'" + descripcion_herr + "',"
                + "" + valor_herr + ","
                + "'" + fecha_ing_herr + "',"
                + "'" + fecha_mod_herr + "',"
                + "" + id_prov + ")";

        System.out.println(q);

        try {
           
            PreparedStatement pstm = this.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getMessage());

           
            return false;
        }

    }
}
