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

    private String nombre_pro;
    private int id_pro;

    public Provedorees(String nombre, int id) {
        this.nombre_pro = nombre;
        this.id_pro = id;
    }

    public int getID() {
        return id_pro;
    }

    public String toString() {
        return nombre_pro;
    }

}
