/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_jornada.en.curso;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yaiza
 */
public class Partido {
    private int idPartido;
    private String fechaPartido;
    private String horaInicio, horaFin;
    private ArrayList <Equipo> listaequipos;
    
    public Partido() {
        listaequipos = new ArrayList();
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public ArrayList<Equipo> getListaequipos() {
        return listaequipos;
    }

    public void setListaequipos(Equipo eq) {
        listaequipos.add(eq);
    }

    @Override
    public String toString() {
        return "Partido{" + "idPartido=" + idPartido + ", fechaPartido=" + fechaPartido + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", listaequipos=" + listaequipos + '}';
    }

   
    
}
