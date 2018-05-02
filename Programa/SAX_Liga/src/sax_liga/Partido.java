/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_liga;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author yaiza
 */
public class Partido {
    private Date fecha; //Cambiar tipo a DATE
    private String hora; //Cambiar tipo a TIME
    private String lugar;
    private int id_partido;
    private ArrayList <Equipo> listaequipos;

    public Partido() {
        listaequipos = new ArrayList();
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public ArrayList<Equipo> getListaequipos() {
        return listaequipos;
    }

    public void setListaequipos(Equipo eq) {
        listaequipos.add(eq);
    }
    
    

    @Override
    public String toString() {
        return "Partido{" + "fecha=" + fecha + ", hora=" + hora + ", lugar=" + lugar + ", juegan " + listaequipos + '}';
    }
    
    
    
}
