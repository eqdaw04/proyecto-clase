/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Recurso.Emparejamiento;
import UML.*;
import BD.*;
import static BD.BDConexion.*;
import Excepciones.Excepcion;
import Views.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private static Persona persona;
    private static int perfil;
    private static Login login;
    private static String driver, url, usuario, contrasenna;
    
    public static void main(String[] args) {
        //driver para la conexion
        driver = "oracle.jdbc.OracleDriver";
        //datos del usuario y servidor
        String tipo = "oracle",
        servidor = "localhost",
        puerto = "1521",
        bbdd = "db12102";
        usuario = "eqdaw04";
        contrasenna = "eqdaw04";
        //construccion de la ruta completa.
        url = "jdbc:" + tipo + ":thin:@" + servidor + ":" + puerto + ":" + bbdd;
        inicializarValores();
        login = new Login();
        //new Principal();
    }
    
    public static void inicializarValores(){
        bdEquipo = new BDEquipo();
        bdJornada = new BDJornada();
        bdJugador = new BDJugador();
        bdMarcador = new BDMarcador();
        bdPartido = new BDPartido();
        bdPerfil = new BDPerfil();
        bdPersona = new BDPersona();
        
    }
    
    public static void accederPrincipal(String usuario, char[] contrasenna) throws Exception{
        persona = null;
        BDConexion con = new BDConexion();
        persona = bdPersona.buscarPersonaPorUsuario(usuario, con);
        con.desconectar();
        int cont = login.getCont()+1;
        login.setCont(cont);
        if(persona == null){
            throw new Excepcion(14);
        }
        else if(Arrays.equals(persona.getContrasenna().toCharArray(), contrasenna)){
            perfil = persona.getPerfil().getIdPerfil();
            login.dispose();
            new Principal(perfil);
        }
        else if(cont <3){
            throw new Excepcion(12);
        }else if(cont == 3){
            login.setError(13);
            throw new Excepcion(13);
        }
    }
    
    public static void abrirVentana(int n, String tipo){
        //abrir ventana según selección del usuario en la pantalla principal
        switch(n){
            case 1:
                new VJugador(tipo);
                break;
                
            case 2:
                new VEquipo(tipo);
                break;
                
            case 3:
                new VUsuario(tipo);
                break;
                
            case 4:
                new VAltasBajas();
                break;
        }
    }
    
    public static void cerrar(JDialog v){
        //cierra una ventana abierta por ventana principal
        v.dispose();
        
    }

    public static void cerrarAbrir(JDialog v, String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void salir(JFrame v){
        //salir del programa
        v.dispose();
    }
    
    public static boolean buscarUsuario(String usuario){
        boolean existe = false;
        //buscar por nombre de usuario  y retornar si existe
        //persona
        return existe;
    }
    
    public static Perfil buscarPerfil(int cod, BDConexion con) throws Exception{
        Perfil p = null;
        p = bdPerfil.buscarPorCodigo(cod, con);
        return p;
    }
    
    public static void altaUsuario( String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, Date fecha, String perfil, String equipo){
        Persona p =  new Persona(nombre, ape1, ape2, fecha, usuario, contrasenna, email);
        //p.setPerfil(buscarPerfil(perfil));
        if(equipo != null){
            //p.setEquipo(buscarEquipo(equipo));
        }
        
    }

    public static void bajaUsuario(String usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void modificarUsuario(String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, String perfil, String equipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public static int getPerfil() {
        return perfil;
    }

    public static void setPerfil(int perfil) {
        Main.perfil = perfil;
    }

    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        Main.login = login;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        Main.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Main.url = url;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Main.usuario = usuario;
    }

    public static String getContrasenna() {
        return contrasenna;
    }

    public static void setContrasenna(String contrasenna) {
        Main.contrasenna = contrasenna;
    }

    public static void altaJugador(String dni, String nombre, String apellido1, String apellido2, String nickname, String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void bajaJugador(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void modificarJugador(String dni, String nombre, String apellido1, String apellido2, String nickname, String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean buscarDNI(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Jugador buscarJugador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void altaEquipo(String nombre, Date fechaCreacion, String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void bajaEquipo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void modificarEquipo(String nombre, String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean buscarNombreEquipo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Equipo buscarEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String buscarPlantilla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Persona buscarPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean comprobarSueldo(String sueldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean comprobarJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void tramitarAlta(String dni, String salario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void tramitarBaja(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean esAgenteLibre(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void perteneceEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
