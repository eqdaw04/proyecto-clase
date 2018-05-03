/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom.clasificacion;

/**
 *
 * @author yaiza
 */
public class Equipo {
    private int idEquipo, puntuacion;
    private String nombre;

    public Equipo() {
    }

    public Equipo(int idEquipo, int puntuacion, String nombre) {
        this.idEquipo = idEquipo;
        this.puntuacion = puntuacion;
        this.nombre = nombre;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", puntuacion=" + puntuacion + ", nombre=" + nombre + '}';
    }

   
}
