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
    private Date fecha;
    private String hora; 
    private String lugar;
    private int idPartido;
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

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
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
