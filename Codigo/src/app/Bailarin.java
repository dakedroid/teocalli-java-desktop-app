/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author teocali
 */
public class Bailarin {
    
    
    String clave;
    String nombre;
    String puntuacion;

    public Bailarin(String clave, String nombre, String puntuacion) {
        this.clave = clave;
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public Bailarin() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

}
