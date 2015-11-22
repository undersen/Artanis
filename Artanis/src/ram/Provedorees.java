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
public class Provedorees {

    private String nombre_prov;
    private int id_prov;

    public Provedorees(String nombre, int id) {
        this.nombre_prov = nombre;
        this.id_prov = id;
    }

    public int getID() {
        return id_prov;
    }

    public String toString() {
        return nombre_prov;
    }

}
