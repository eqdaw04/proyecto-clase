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
    
    private int idJornada;
    private ArrayList <Partido> listapartidos;

    public Jornada() {
        listapartidos = new ArrayList();
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int id_jornada) {
        this.idJornada = idJornada;
    }

    public ArrayList<Partido> getListapartidos() {
        return listapartidos;
    }

    public void setListapartidos(Partido part){
       listapartidos.add(part);
        
    }

    @Override
    public String toString() {
        return "Jornada{" + "id_jornada=" + idJornada + ", listapartidos=" + listapartidos + '}';
    }
    
    
}
