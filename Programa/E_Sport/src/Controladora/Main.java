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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
    
    public static int numero;
    
    public static void main(String[] args) throws Exception {
        //driver para la conexion
        driver = "oracle.jdbc.OracleDriver";
        //datos del usuario y servidor
        String tipo = "oracle",
        servidor = "10.10.10.9",//"localhost"
        puerto = "1521",
        bbdd = "orcl";
        usuario = "eqdaw04";
        contrasenna = "eqdaw04";
        //construccion de la ruta completa.
        url = "jdbc:" + tipo + ":thin:@" + servidor + ":" + puerto + ":" + bbdd;
        inicializarValores();
        switch(numero){
            case 1:
                servidor = "SrvOracle";
                bbdd = "orcl";
                break;
                
            case 2:
                servidor = "localhost";
                break;
                
            case 3:
                servidor = "10.10.10.9";
                break;
                        
        }
        login = new Login();
        //new Principal();
    }
    
    public static void inicializarValores() throws Exception{
        bdEquipo = new BDEquipo();
        bdJornada = new BDJornada();
        bdJugador = new BDJugador();
        bdMarcador = new BDMarcador();
        bdPartido = new BDPartido();
        bdPerfil = new BDPerfil();
        bdPersona = new BDPersona();
    }
    
    public static void accederPrincipal(String usuario, char[] contrasenna) throws Exception{

        persona = bdPersona.buscarPersonaPorUsuario(usuario);
        int cont = login.getCont()+1;
        login.setCont(cont);
        if(persona == null){
            throw new Excepcion(14);
        }
        else if(Arrays.equals(persona.getContrasenna().toCharArray(), contrasenna)){
            perfil = persona.getPerfil().getIdPerfil();
            login.dispose();
            new Principal(perfil,persona.getUsuario());
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
            case 5:
                new ModificarEquipo(tipo);
                break;
        }
    }
    
    public static void cerrar(JDialog v){
        //cierra una ventana abierta por ventana principal
        v.dispose();
        
    }

    public static void cerrarAbrir(JDialog v) {
        v.dispose();
        
        new VAltasBajas();
    }
    
    public static void salir(JFrame v){
        //salir del programa
        v.dispose();
    }
    
    public static Perfil buscarPerfil(int cod, BDConexion con) throws Exception{
        Perfil p = null;
        p = bdPerfil.buscarPorCodigo(cod, con);
        return p;
    }
    
    //---------- JON XU JIN ----------
    
    public static void altaPersona( String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, Date fecha, String perfil, String equipo){
        // Insertar usuario en la BD
        Persona p = new Persona(nombre, ape1, ape2, fecha, usuario, contrasenna, email);
        //p.setPerfil(buscarPerfil(perfil));
        if(equipo != null){
            //p.setEquipo(buscarEquipo(equipo));
        }
        
    }
    
    //---------- JON XU JIN ----------

    public static void bajaPersona(String usuario) {
        // Eliminar usuario en la BD
        Persona p = new Persona();
        p.setUsuario(usuario);
    }
    
    //---------- JON XU JIN ----------
    
    public static void modificarPersona(String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, String perfil, String equipo) {
        // Modificar usuario en la BD
        Persona p = new Persona();
        p.setNombre(nombre);
        p.setApellido1(ape1);
        p.setApellido2(ape2);
        p.setUsuario(usuario);
        p.setContrasenna(contrasenna);
        p.setEmail(email);
        //p.setPerfil(buscarPerfil(perfil));
        if(equipo != null){
            //p.setEquipo(buscarEquipo(equipo));
        }       
        
    }
    
    //---------- JON XU JIN ----------
    
    public static Persona ConsultarPersona(String usuario) throws Exception{
        // Localizar a una persona con su usuario
        persona = null;
        persona = bdPersona.buscarPersonaPorUsuario(con, usuario);

        return persona;
        
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
        // Insertar jugador en la BD
        Jugador j = new Jugador();
        j.setDni(dni);
        j.setNombre(nombre);
        j.setApellido1(apellido1);
        j.setApellido2(apellido2);
        j.setNickname(nickname);
        j.setComentario(comentario);
    }

    public static void bajaJugador(String dni) {
        // Eliminar jugador en la BD
        Jugador j = new Jugador();
        j.setDni(dni);
    }
    
    public static void modificarJugador(String dni, String nombre, String apellido1, String apellido2, String nickname, String comentario) {
        // Modificar jugador en la BD
        Jugador j = new Jugador();
        j.setDni(dni);
        j.setNombre(nombre);
        j.setApellido1(apellido1);
        j.setApellido2(apellido2);
        j.setNickname(nickname);
        j.setComentario(comentario);
    }
    //------------Mikel
    public static ArrayList buscarDNI(String dni) {
       return BDJugador.BuscarDni(dni,con);
    }
    //------------Mikel
    public static ArrayList<Jugador> obtenerJugEqui(String id){
        return BDJugador.BuscarEqui(id,con);
    }
<<<<<<< Updated upstream
    
    public static String obtenerNomEqui(String usu){
=======
    //------------Mikel
    public static Equipo obtenerNomEqui(String usu){
>>>>>>> Stashed changes
        return BDEquipo.BuscarNomEqui(usu,con);
    }
    
    public static Jugador buscarJugador() {
        Jugador j = null; // Variable global
        // Buscar jugador y devolver datos para mostrarlos
        return j;
    }

    public static void altaEquipo(String nombre, Date fechaCreacion, String comentario) {
        // Insertar equipo en la BD
        Equipo e = new Equipo();
        e.setNombre(nombre);
        e.setFechaCreacion(fechaCreacion);
        e.setComentario(comentario);
    }

    public static void bajaEquipo(String nombre) {
        // Eliminar equipo en la BD
        Equipo e = new Equipo();
        e.setNombre(nombre);
    }

    public static void modificarEquipo(String nombre, String comentario) {
        // Modificar equipo en la BD
        Equipo e = new Equipo();
        e.setNombre(nombre);
        e.setComentario(comentario);
    }

    public static boolean buscarNombreEquipo(String nombre) {
        boolean existe = false;
        // Buscar el nombre de equipo en la BD y retornar si existe
        return existe;
    }

    public static Equipo buscarEquipo() {
        Equipo e = null; // Variable global
        // Buscar equipo y devolver datos para mostrarlos
        return e;
    }

    public static String buscarPlantilla() {
        String plantilla="";
        // Buscar todos los jugadores de un equipo y devolverlos en un String
        return plantilla;
    }

    public static boolean comprobarSueldo(String sueldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean comprobarJugadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void tramitarAlta(String dni, String sueldo) {
        // Modificar jugador en la BD
        Jugador j = new Jugador();
        j.setDni(dni);
        j.setSueldo(Float.parseFloat(sueldo));
        j.setEquipo(persona.getEquipo());
    }

    public static void tramitarBaja(String dni) {
        // Modificar jugador en la BD
        Jugador j = new Jugador();
        j.setDni(dni);
        j.setSueldo((float)(0));
        j.setEquipo(null);
    }

    public static boolean esAgenteLibre(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean perteneceEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String buscarEquipoDuenno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Main.numero = numero;
    }
    
    

}
