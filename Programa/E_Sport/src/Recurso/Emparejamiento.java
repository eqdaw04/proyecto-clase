/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import BD.BDConexion;
import Controladora.Main;
import Excepciones.Excepcion;
import UML.Equipo;
import UML.Jornada;
import UML.Partido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
     * @param lEquipo ArrayList de equipo
     */

    public Emparejamiento(ArrayList<Equipo> lEquipo) {
        this.lEquipo = lEquipo;
    }
    
    /**
     * Metodo para calcular el partido.
     * Obtenemos el número de jornadas y partidos.
     */
    
    public void calcularPartido(BDConexion con, Date fecha, String lugar) throws Exception{
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
        llenarArray(j, p, e, con, fecha, lugar);
    }
    
    /**
     * Metodo en el que llenamos los arrays de los equipos locales y visitantes.
     * @param j int
     * @param p int
     * @param e int
     */
    
    public void llenarArray(int j, int p, int e, BDConexion con, Date fecha, String lugar) throws Exception{
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
        insertarBBDD(e, horizontal, con, fecha, lugar);
    }
    
    public int insertarBBDD(int e, int horizontal, BDConexion con, Date fecha, String lugar) throws Exception{
        //emplear este código para combinar los equipos en bbdd
        String dato = "Jornadas 1-" + (e-1) + " Equipos:\n";
        boolean sumar = true;
        int dia = 1;
        int jornada = 1;
        // comienza a asignar la primera mitad de la liga
        for(int x = 0; x<e-1; x++){
            dato += "Jornada " + jornada + " compiten: ";
            // insertar la jornada a la BBDD
            Jornada j = Main.insertarJornada(jornada, con);
            sumar = true;
            int d = 1;
            for(int y = 0; y< horizontal; y++){
                dato += "Día " + dia + "(" + d + ")" + " ";
                
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecha);
                calendar.add(Calendar.DAY_OF_YEAR, dia);
                Partido p = Main.insertarPartido(calendar.getTime(), lugar, j, con);
                dato += lJPEquipoL[x][y].getIdEquipo() + "x" + lJPEquipoV[x][y].getIdEquipo() + "   ";
                p.seteLocal(lJPEquipoL[x][y]);
                p.seteVisitante(lJPEquipoV[x][y]);
                if(!Main.insertarEquiposAPartido(p, con)){
                    throw new Excepcion(42);
                }
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
            // insertar la jornada a la BBDD
            Jornada j = Main.insertarJornada(jornada, con);
            sumar = true;
            int d = 1;
            for(int y = 0; y< horizontal; y++){
                dato += "Día " + dia + "(" + d + ")" + " ";
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fecha);
                calendar.add(Calendar.DAY_OF_YEAR, dia);
                Partido p = Main.insertarPartido(calendar.getTime(), lugar, j, con);
                dato += lJPEquipoV[x][y].getIdEquipo() + "x" + lJPEquipoL[x][y].getIdEquipo() + "   ";
                p.seteLocal(lJPEquipoV[x][y]);
                p.seteVisitante(lJPEquipoL[x][y]);
                if(!Main.insertarEquiposAPartido(p, con)){
                    throw new Excepcion(42);
                }
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
