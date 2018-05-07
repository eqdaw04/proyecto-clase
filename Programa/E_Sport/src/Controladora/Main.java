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
    
    
    public static void main(String[] args) throws Exception {
        //driver para la conexion
        driver = "oracle.jdbc.OracleDriver";
        usuario = "eqdaw04";
        contrasenna = "eqdaw04";
        //construccion de la ruta completa.
        inicializarValores();
        
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
    
    //---------- JON XU JIN ----------
    
    public static void accederPrincipal(String usuario, char[] contrasenna, int numero) throws Exception{
        //datos del usuario y servidor
        String tipo = "oracle",
        servidor = "10.10.10.9",//"localhost"
        puerto = "1521",
        bbdd = "db12102";
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
        url = "jdbc:" + tipo + ":thin:@" + servidor + ":" + puerto + ":" + bbdd;
        persona = null;
        
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
    
    //---------- JON XU JIN ----------
    
    public static void abrirVentana(int n, String tipo) throws Exception{
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

            case 5:
                new ModificarEquipo(tipo);
                break;
        }
    }

    //---------- JON XU JIN ----------
    
    public static void cerrar(JDialog v) {
        // Cierra la ventana abierta
        v.dispose();
    }
    
    //---------- JON XU JIN ----------
    
    public static void reabrir(JDialog v, String tipo, int n) throws Exception {
        // Cierra la ventana abierta
        v.dispose();
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
                
            case 5:
                new ModificarEquipo(tipo);
                break;
        }
    }
    
    //---------- JON XU JIN ----------
    
    public static void salir(JFrame v){
        //salir del programa
        v.dispose();
    }
    
    //---------- JON XU JIN ----------
    
    public static void cerrarSesion(JFrame v){
        //salir del programa
        v.dispose();
        login = new Login();
    }
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Perfil> consultarTodosLosPerfiles() throws Exception{
        ArrayList <Perfil> listaPerfil =  new ArrayList();
        listaPerfil = bdPerfil.buscarPerfiles();
        return listaPerfil;
    }
    
    //---------- JON XU JIN ----------
    
    public static Perfil consultarPerfil(int cod) throws Exception{
        Perfil p = null;
        p = bdPerfil.buscarPorCodigo(cod);
        return p;
    }
    
    //---------- JON XU JIN ----------
    
    public static void altaPersona( String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, Date fecha, String perfil) throws Exception{
        // Insertar usuario en la BD
        Persona p = new Persona(nombre, ape1, ape2, fecha, usuario, contrasenna, email);
        p.setPerfil(bdPerfil.buscarPorNombre(perfil));
        bdPersona.altaPersona(p);
    }
    
    //---------- JON XU JIN ----------

    public static void bajaPersona(String usuario) throws Exception {
        // Eliminar usuario en la BD
        Persona p = new Persona();
        p.setUsuario(usuario);
        bdPersona.bajaPersona(p);
    }
    
    //---------- JON XU JIN ----------
    
    public static void modificarPersona(String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, String perfil) throws Exception {
        // Modificar usuario en la BD
        persona.setNombre(nombre);
        persona.setApellido1(ape1);
        persona.setApellido2(ape2);
        persona.setUsuario(usuario);
        persona.setContrasenna(contrasenna);
        persona.setEmail(email);
        persona.setPerfil(bdPerfil.buscarPorNombre(perfil));
        bdPersona.modificarPersona(persona);
    }
    
    //---------- JON XU JIN ----------
    
    public static Persona consultarPersona(String usuario) throws Exception{
        // Localizar a una persona con su usuario
        persona = null;
        persona = bdPersona.buscarPersonaPorUsuario(usuario); 
        return persona;
    }
    
    public static ArrayList <Persona> consultarTodasLasPersonas() throws Exception{
        ArrayList <Persona> listadoPersona = new ArrayList();
        listadoPersona = bdPersona.buscarTodasLasPersona();
        return listadoPersona;
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

    public static Persona getPersona() {
        return persona;
    }

    public static void setPersona(Persona persona) {
        Main.persona = persona;
    }

    
    
    // Imanol Luis
    public static void altaJugador(String dni, String nombre, String apellido1, String apellido2, String nickname, String sueldo, Date fechaAlta, String comentario) throws Exception {
        // Insertar jugador en la BD
        Jugador jugador=new Jugador();
        jugador.setDni(dni);
        jugador.setNombre(nombre);
        jugador.setApellido1(apellido1);
        jugador.setApellido2(apellido2);
        jugador.setNickname(nickname);
        jugador.setSueldo(Float.parseFloat(sueldo.replace(",", ".")));
        jugador.setFechaAlta(fechaAlta);
        jugador.setComentario(comentario);
        BDJugador.insertarJugador(jugador);
    }

    // Imanol Luis
    public static void bajaJugador(String dni) throws Exception {
        // Eliminar jugador en la BD
        Jugador jugador=new Jugador();
        jugador.setDni(dni);
        BDJugador.eliminarJugador(jugador);
    }
    
    // Imanol Luis
    public static void modificarJugador(String dni, String nombre, String apellido1, String apellido2, String nickname, String sueldo, String comentario) throws Exception {
        // Modificar jugador en la BD
        Jugador jugador=new Jugador();
        jugador.setDni(dni);
        jugador.setNombre(nombre);
        jugador.setApellido1(apellido1);
        jugador.setApellido2(apellido2);
        jugador.setNickname(nickname);
        jugador.setSueldo(Float.parseFloat(sueldo.replace(",", ".")));
        jugador.setComentario(comentario);
        BDJugador.modificarJugador(jugador);
    }
    
    // Imanol Luis   
    public static Jugador buscarJugador(String dni) throws Exception {        
       return BDJugador.BuscarJugador(dni);
    }
    
    // Imanol Luis   
    public static ArrayList<Jugador> buscarJugador() throws Exception {        
       return BDJugador.BuscarJugador();
    }
    
    public static ArrayList<Jugador> buscarDNI(String dni) throws Exception {      
       return BDJugador.BuscarDni(dni);
    }
    //------------Mikel
    // Busca Jugadores pertenecientes a un equipo
    public static ArrayList<Jugador> obtenerJugEqui(String id) throws Exception{
        return BDJugador.BuscarEqui(id);
    }

    //------------Mikel
    // consulta el equipo de un dueño mediante su usuario
    public static Equipo ConsultarEquipoPorUsuario(String usu) throws Exception{
        return BDEquipo.BuscarEquipoPorUsuario(usu);
    }
    //------------Mikel
    // Devuelve todos los jugadoers que no pertenezcan a ningún equipo
    public static ArrayList <Jugador> consultarJugadoresDisponibles () throws Exception{
        return BDJugador.BuscarJugadoresDisponibles();
    }
    //------------Mikel
    // Busca a un jugador por su nickname y pone su id_equipo a null (no pertenece a ningún equipo)
    public static boolean EliminarJugadorEquipo (String nickname){
       
        return BDJugador.QuitarJugadorEquipo(nickname);
    }
    //------------Mikel
    // Busca a un jugador por su nickname yle añade el id_equipo del equipo al que se le quiere añadir
    public static boolean AnnadirJugadorEquipo(String nickname, String id) {
        return BDJugador.PonerJugadorEquipo(nickname,id);
    }
    // Imanol Luis
    public static void altaEquipo(String nombre, Date fechaCreacion, String comentario) throws Exception {
        // Insertar equipo en la BD
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setFechaCreacion(fechaCreacion);
        equipo.setComentario(comentario);
        BDEquipo.insertarEquipo(equipo);
    }

    // Imanol Luis
    public static void bajaEquipo(String nombre) throws Exception {
        // Eliminar equipo en la BD
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        BDEquipo.eliminarEquipo(equipo);
    }

    // Imanol Luis
    public static void modificarEquipo(String nombre, String comentario) throws Exception {
        // Modificar equipo en la BD
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setComentario(comentario);
        BDEquipo.modificarEquipo(equipo);
    }

    // Imanol Luis
    public static Equipo buscarEquipo(String equipo) throws Exception {
        return BDEquipo.BuscarEquipo(equipo);
    }

    // Imanol Luis
    public static ArrayList<Equipo> buscarEquipo() throws Exception {
        return BDEquipo.BuscarEquipo();
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

    

}
