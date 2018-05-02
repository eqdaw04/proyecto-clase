/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_jornada.en.curso;

/**
 *
 * @author yaiza
 */
public class Equipo {
    private int idEquipo;
    private String nombre;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id_equipo=" + idEquipo + ", nombre=" + nombre + '}';
    }
    
    
}
