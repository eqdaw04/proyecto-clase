/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import UML.Equipo;
import UML.Jornada;
import java.util.ArrayList;

/**
 *
 * @author v6222
 */
public class Emparejamiento {
    
    int dia;
    ArrayList <Equipo> listaEquipo;
    Jornada[] listaJornada;
    
    public Emparejamiento() {
    }

    public Emparejamiento(int dia, ArrayList<Equipo> listaEquipo) {
        this.dia = dia;
        this.listaEquipo = listaEquipo;
    }
    
    public int calcularJornada(){
        int e = listaEquipo.size();
        // obtener numero de jornadas y crear Array
        int j = (e-1)*2;
        listaJornada = new Jornada[j];
        // establecemos que 1 jornada = 1 semana = 7 días
        return j;
    }
    
    public void agregarDatoJornada(){
        
        
        
        
        for(int x = 0; listaJornada.length < x ; x++){
            listaJornada[x].setListaPartidos(listaPartidos);
        }
    }
}
