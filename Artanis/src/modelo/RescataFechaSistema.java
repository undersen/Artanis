/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author msaavedra
 */
public class RescataFechaSistema {
    
    
    java.util.Date utilDate = new java.util.Date(); //fecha actual
    long lnMilisegundos = utilDate.getTime();
    java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
    java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
    
    private String fecha = sqlDate.toString();
    private String hora = sqlTime.toString();
    private String ver=sqlTimestamp.toString();
    
    //modulo de recepcion de documento 

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

}
