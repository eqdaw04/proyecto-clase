/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_clasificacion;

/**
 *
 * @author yaiza
 */
public class Equipo {
    private String nombre;
    private int puntuacion, idEquipo;

    public Equipo() {
    }

    public Equipo(String nombre, int puntuacion, int idEquipo) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", puntuacion=" + puntuacion + ", id_equipo=" + idEquipo + '}';
    }
    
    
}
