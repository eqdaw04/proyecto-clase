/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import UML.Equipo;
import UML.Jornada;
import UML.Partido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Emparejamiento {
    
    int dia;
    ArrayList <Equipo> lEquipo;
    Jornada[] lJornada;
    Partido[] lPartido;
    
    public Emparejamiento() {
    }

    public Emparejamiento(int dia, ArrayList<Equipo> listaEquipo) {
        this.dia = dia;
        this.lEquipo = listaEquipo;
    }
    
    public void calcularJornada(){
        int e = lEquipo.size();
        // obtener numero de jornadas, partidos y crear Array
        int j = (e-1)*2;
        lJornada = new Jornada[j];
        int p = e/2;
        lPartido = new Partido[p];
        // establecemos que 1 jornada = 1 semana = 7 días
        //desordenar numero equipo
        Collections.shuffle(lEquipo);
        //random de un numero para seleccionar una posicion aleatoria del array
        Random rand = new Random();
        int n = rand.nextInt(e-1) + 1;
  
    }

}
