/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import UML.Equipo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase en la que definimos los emparejamientos de los equipos por partido.
 * Fecha de creación de la clase: 25/04/2018
 * @author eqdaw04
 */

/**
 * Metodo para emparejar equipos.
 * Obtenemos el día en el que se jugará el partido y los arrays de equipos locales y visitantes.
 */
public class Emparejamiento {
    ArrayList <Equipo> lEquipo;
    Equipo[][] lJPEquipoL;
    Equipo[][] lJPEquipoV;
    
    public Emparejamiento() {
    }
    
    /**
     * Constructor para emparejar los equipos.
     * @param diaInicio int
     * @param lEquipo ArrayList de equipo
     */

    public Emparejamiento(ArrayList<Equipo> lEquipo) {
        this.lEquipo = lEquipo;
    }
    
    /**
     * Metodo para calcular el partido.
     * Obtenemos el número de jornadas y partidos.
     */
    
    public void calcularPartido(){
        int e = lEquipo.size();
        // Si es impar añadir 1 numero equipo fantasma y crear Array
        if(e%2!=0){
            // si el equipo es impar, se añade un equipo fantasma
            Equipo f = new Equipo();
            f.setNombre("DESCANSO");
            lEquipo.add(f);
            e = lEquipo.size();
        }
        int j = (e-1);
        int p = e/2;
        lJPEquipoL = new Equipo[j][p];
        lJPEquipoV = new Equipo[j][p];
        // rellenar array con los equipos
        llenarArray(j, p, e);
    }
    
    /**
     * Metodo en el que llenamos los arrays de los equipos locales y visitantes.
     * @param j int
     * @param p int
     * @param e int
     */
    
    public void llenarArray(int j, int p, int e){
        //Algoritmo de construccion de equipos
        for(int x = 0; x<j; x++){
            if(x%2==0){
                lJPEquipoV[x][0] = lEquipo.get(e-1);
            }
            else{
                lJPEquipoL[x][0] = lEquipo.get(e-1);
            }
        }
        // Completar asignar equipos locales omitiendo array puesto 0, array[x][0 omitido]
        int horizontal = 0;
        horizontal = lJPEquipoL[0].length;
        int c = 0;
        for(int x = 0; x<e-1; x++){
            for(int y = 1; y< horizontal; y++){
                lJPEquipoL[x][y] = lEquipo.get(c);
                if(c == e-2){
                    c = 0;
                }
                else{
                    c ++;
                }
            }
        }
        //completar array visitante
        c = e-2;
        for(int x = 0; x<e-1; x++){
            for(int y = 0; y< horizontal; y++){
                //comprobar si visitante está libre, afirmativo llenar equipo, negativo saltar a rellenar local
                if(lJPEquipoV[x][y] == null){
                    lJPEquipoV[x][y] = lEquipo.get(c);
                }
                else{
                    lJPEquipoL[x][y] = lEquipo.get(c);
                }
                if(c == 0){
                    c = e-2;
                }
                else{
                    c --;
                }
            }
        }
        insertarBBDD(e, horizontal);
    }
    
    public int insertarBBDD(int e, int horizontal){
        //emplear este código para combinar los equipos en bbdd
        String dato = "Jornadas 1-" + (e-1) + " Equipos:\n";
        boolean sumar = true;
        int dia = 1;
        int jornada = 1;
        // comienza a asignar la primera mitad de la liga
        for(int x = 0; x<e-1; x++){
            dato += "Jornada " + jornada + " compiten: ";
            sumar = true;
            int d = 1;
            for(int y = 0; y< horizontal; y++){
                dato += "Día " + dia + "(" + d + ")" + " ";
                dato += lJPEquipoL[x][y].getIdEquipo() + "x" + lJPEquipoV[x][y].getIdEquipo() + "   ";
                if(d==7){
                    d=0;
                    sumar=false;
                }
                if(sumar){
                    dia++;
                } 
                d++;
            }
            dato += "\n";
            dia = dia + 8 - d;
            jornada++;
        }    
        // comienza a asignar la segunda mitad de la liga
        dato += "\nJornadas " + e + "-" + ((e-1)*2) + " Equipos:\n";
        for(int x = 0; x<e-1; x++){
            dato += "Jornada " + jornada + " compiten: ";
            sumar = true;
            int d = 1;
            for(int y = 0; y< horizontal; y++){
                dato += "Día " + dia + "(" + d + ")" + " ";
                dato += lJPEquipoV[x][y].getIdEquipo() + "x" + lJPEquipoL[x][y].getIdEquipo() + "   ";
                if(d==7){
                    d=0;
                    sumar=false;
                }
                if(sumar){
                    dia++;
                } 
                d++;
            }
            dato += "\n";
            if(x!=e-2){
                dia = dia + 8 - d;
            }
            jornada++;
        }
        JOptionPane.showMessageDialog(null, dato);
        dia--;
        return dia;
    }

    public Equipo[][] getlJPEquipoL() {
        return lJPEquipoL;
    }

    public void setlJPEquipoL(Equipo[][] lJPEquipoL) {
        this.lJPEquipoL = lJPEquipoL;
    }

    public Equipo[][] getlJPEquipoV() {
        return lJPEquipoV;
    }

    public void setlJPEquipoV(Equipo[][] lJPEquipoV) {
        this.lJPEquipoV = lJPEquipoV;
    }
    
    
}
