/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import UML.Equipo;
import java.util.ArrayList;

/**
 *
 * @author v6222
 */
public class Emparejamiento {
    
    int dia;
    ArrayList <Equipo> listadoEquipo;
    
    public void calcularJornada(){
        int t = listadoEquipo.size();   
        // obtener numero de jornadas
        int j = (t-1)*2;
        // establecemos que 1 jornada = 1 semana = 7 días
        
        
    }
}
