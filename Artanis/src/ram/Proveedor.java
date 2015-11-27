/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ram;

/**
 *
 * @author del_a
 */
public class Proveedor {

    private String nombre_pro;
    private int id_pro;
    private String ciudad_prov;
    private String ubicacion_prov;

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getCiudad_prov() {
        return ciudad_prov;
    }

    public void setCiudad_prov(String ciudad_prov) {
        this.ciudad_prov = ciudad_prov;
    }

    public String getUbicacion_prov() {
        return ubicacion_prov;
    }

    public void setUbicacion_prov(String ubicacion_prov) {
        this.ubicacion_prov = ubicacion_prov;
    }
    

}
