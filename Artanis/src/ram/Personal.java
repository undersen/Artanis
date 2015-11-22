/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ram;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;

/**
 *
 * @author Tomas
 */
public class Personal {
    
    /*
    id_per bigint(10) auto_increment,
rut_per integer(8),
dv_per varchar(1),
nombre_per varchar(32),
apellidos_per  varchar(32),
direccion_per varchar(32),
fecha_nac_per date,
id_prev bigint(10),
id_afp bigint(10),
telefono_per  varchar(13),
celular_per  varchar(13),
fecha_ingreso_per date,
id_car bigint(10) ,
valor_hh_per integer(7),
sueldo_per integer(7),
tipo_jornada_per varchar(20),
foreign key (id_car) references cargo (id_car),
foreign key (id_prev) references prevision (id_prev),
foreign key (id_afp) references afp (id_afp),
PRIMARY KEY (id_per)
);
    */
    
    
    private int id_per;
    private int rut_per;    
    private char dv_per;    
    private String Pri_nombre_per;    
    private String Seg_nombre_per;    
    private String apellidoM_per;
    private String apellidoP_per;
    private Date fecha_nac_per;
    private int id_prev ;
    private int id_afp;
    private String telefono_per  ;
    private String celular_per ;
    private Date fecha_ingreso_per ;
    private int id_car ;
    private int valor_hh_per ;
private  int sueldo_per ;

    public Personal(int id_per, int rut_per, char dv_per, String Pri_nombre_per, String Seg_nombre_per, String apellidoM_per, String apellidoP_per, Date fecha_nac_per, int id_prev, int id_afp, String telefono_per, String celular_per, Date fecha_ingreso_per, int id_car, int valor_hh_per, int sueldo_per, int tipo_jornada_per) {
        this.id_per = id_per;
        this.rut_per = rut_per;
        this.dv_per = dv_per;
        this.Pri_nombre_per = Pri_nombre_per;
        this.Seg_nombre_per = Seg_nombre_per;
        this.apellidoM_per = apellidoM_per;
        this.apellidoP_per = apellidoP_per;
        this.fecha_nac_per = fecha_nac_per;
        this.id_prev = id_prev;
        this.id_afp = id_afp;
        this.telefono_per = telefono_per;
        this.celular_per = celular_per;
        this.fecha_ingreso_per = fecha_ingreso_per;
        this.id_car = id_car;
        this.valor_hh_per = valor_hh_per;
        this.sueldo_per = sueldo_per;
        this.tipo_jornada_per = tipo_jornada_per;
    }

    public Personal() {
    }
private int tipo_jornada_per ;

    public int getId_per() {
        return id_per;
    }

    public void setId_per(int id_per) {
        this.id_per = id_per;
    }

    public int getRut_per() {
        return rut_per;
    }

    public void setRut_per(int rut_per) {
        this.rut_per = rut_per;
    }

    public char getDv_per() {
        return dv_per;
    }

    public void setDv_per(char dv_per) {
        this.dv_per = dv_per;
    }

    public String getPri_nombre_per() {
        return Pri_nombre_per;
    }

    public void setPri_nombre_per(String Pri_nombre_per) {
        this.Pri_nombre_per = Pri_nombre_per;
    }

    public String getSeg_nombre_per() {
        return Seg_nombre_per;
    }

    public void setSeg_nombre_per(String Seg_nombre_per) {
        this.Seg_nombre_per = Seg_nombre_per;
    }

    public String getApellidoM_per() {
        return apellidoM_per;
    }

    public void setApellidoM_per(String apellidoM_per) {
        this.apellidoM_per = apellidoM_per;
    }

    public String getApellidoP_per() {
        return apellidoP_per;
    }

    public void setApellidoP_per(String apellidoP_per) {
        this.apellidoP_per = apellidoP_per;
    }

    public Date getFecha_nac_per() {
        return fecha_nac_per;
    }

    public void setFecha_nac_per(Date fecha_nac_per) {
        this.fecha_nac_per = fecha_nac_per;
    }

    public int getId_prev() {
        return id_prev;
    }

    public void setId_prev(int id_prev) {
        this.id_prev = id_prev;
    }

    public int getId_afp() {
        return id_afp;
    }

    public void setId_afp(int id_afp) {
        this.id_afp = id_afp;
    }

    public String getTelefono_per() {
        return telefono_per;
    }

    public void setTelefono_per(String telefono_per) {
        this.telefono_per = telefono_per;
    }

    public String getCelular_per() {
        return celular_per;
    }

    public void setCelular_per(String celular_per) {
        this.celular_per = celular_per;
    }

    public Date getFecha_ingreso_per() {
        return fecha_ingreso_per;
    }

    public void setFecha_ingreso_per(Date fecha_ingreso_per) {
        this.fecha_ingreso_per = fecha_ingreso_per;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public int getValor_hh_per() {
        return valor_hh_per;
    }

    public void setValor_hh_per(int valor_hh_per) {
        this.valor_hh_per = valor_hh_per;
    }

    public int getSueldo_per() {
        return sueldo_per;
    }

    public void setSueldo_per(int sueldo_per) {
        this.sueldo_per = sueldo_per;
    }

    public int getTipo_jornada_per() {
        return tipo_jornada_per;
    }

    public void setTipo_jornada_per(int tipo_jornada_per) {
        this.tipo_jornada_per = tipo_jornada_per;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
