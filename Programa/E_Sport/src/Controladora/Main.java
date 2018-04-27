/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;


import Recurso.Emparejamiento;
import UML.*;
import BD.*;
import Excepciones.Excepcion;
import Views.Login;
import Views.Principal;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 *
 * @author v6222
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static BDEquipo bdEquipo;
    private static BDJornada bdJornada;
    private static BDJugador bdJugador;
    private static BDMarcador bdMarcador;
    private static BDPartido bdPartido;
    private static BDPerfil bdPerfil;
    private static BDPersona bdPersona;
    private static BDConexion bdConexion;
    private static int perfil;
    private static Login login;
    
    public static void main(String[] args) {
        login = new Login();
        
    }
    
    public static void abrirVentana(int cont) throws Exception{

        //datos de prueba
        Persona p = new Persona();
        p.setIdPersona(1);
        p.setUsuario("Jon");
        p.setContrasenna("12345");
        Perfil per = new Perfil();
        per.setIdPerfil(1);
        p.setPerfil(per);
        
        cont ++;
        login.setCont(cont);
        if(cont < 3){
            if(login.getTfUsuario().getText().equals(p.getUsuario()) && login.getPfContrasenna().getText().equals(p.getContrasenna())){
                perfil = p.getPerfil().getIdPerfil();
                login.dispose();
                new Principal(perfil);
            }
            else{
                throw new Excepcion(12);
            }
        }
        else{
            if(login.getTfUsuario().getText().equals(p.getUsuario()) && login.getPfContrasenna().getText().equals(p.getContrasenna())){
                perfil = p.getPerfil().getIdPerfil();
                login.dispose();
                new Principal(perfil);
            }
            else{
                login.setError(13);
                throw new Excepcion(13);
            }
            
        }
    }
    
    public static void cerrar(JDialog v){
        v.dispose();
        new Principal(perfil);
    }
    
    public static void salir(JFrame v){
        v.dispose();
    }
    
    public static void probando(){
        ArrayList <Equipo> lEquipo = new ArrayList();
        Equipo e1 = new Equipo();
        e1.setIdEquipo(1);
        lEquipo.add(e1);
        Equipo e2 = new Equipo();
        e2.setIdEquipo(2);
        lEquipo.add(e2);
        Equipo e3 = new Equipo();
        e3.setIdEquipo(3);
        lEquipo.add(e3);
        Equipo e4 = new Equipo();
        e4.setIdEquipo(4);
        lEquipo.add(e4);
        
        Equipo e5 = new Equipo();
        e5.setIdEquipo(5);
        lEquipo.add(e5);
        Equipo e6 = new Equipo();
        e6.setIdEquipo(6);
        lEquipo.add(e6);
        Equipo e7 = new Equipo();
        e7.setIdEquipo(7);
        lEquipo.add(e7);
        Emparejamiento e = new Emparejamiento(12, lEquipo);
        e.calcularPartido();
        
    }
    
    
}
