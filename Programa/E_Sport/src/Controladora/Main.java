/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;


<<<<<<< Updated upstream
import Recurso.Emparejamiento;
import UML.*;
import BD.*;
import Excepciones.Excepcion;
import Views.Login;
import Views.Principal;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;

=======
>>>>>>> Stashed changes

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
    
    public static void abrirVentana() throws Exception{
        int cont = 0;
        boolean u, c;
        
        u=true;
        c=true;
        if(cont < 4){
            if(u && c){
                Persona p = new Persona();
                p.setIdPersona(1);
                Perfil per = new Perfil();
                per.setIdPerfil(1);
                p.setPerfil(per);
                perfil = p.getPerfil().getIdPerfil();
                login.dispose();
                new Principal(perfil);

            }
            else{
                cont++;
                throw new Excepcion(12);
            }
        }
        else{
            login.setError(13);
            throw new Excepcion(13);
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
