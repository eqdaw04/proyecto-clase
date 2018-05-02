/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax_liga;

import java.util.ArrayList;

/**
 *
 * @author yaiza
 */
public class Jornada {
    
    private int id_jornada;
    private ArrayList <Partido> listapartidos;

    public Jornada() {
        listapartidos = new ArrayList();
    }

    public int getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(int id_jornada) {
        this.id_jornada = id_jornada;
    }

    public ArrayList<Partido> getListapartidos() {
        return listapartidos;
    }

    public void setListapartidos(Partido part){
       listapartidos.add(part);
        
    }

    @Override
    public String toString() {
        return "Jornada{" + "id_jornada=" + id_jornada + ", listapartidos=" + listapartidos + '}';
    }
    
    
}
