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
    private static Equipo equipo;
    private static Jugador jugador;
    private static int perfil;
    private static VLogin login;
    private static String driver, url, usuario, contrasenna;
    
    
    public static void main(String[] args) throws Exception {
        //driver para la conexion
        driver = "oracle.jdbc.OracleDriver";
        usuario = "eqdaw04";
        contrasenna = "eqdaw04";
        //construccion de la ruta completa.
        inicializarValores();
        
        login = new VLogin();
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
            new VPrincipal(perfil,persona.getUsuario());
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
                new VJugador(tipo, n);
                break;
                
            case 2:
                new VEquipo(tipo, n);
                break;
                
            case 3:
                new VUsuario(tipo, n);
                break;

            case 5:
                new VModificarEquipo(tipo);
                break;
                
            case 6:
                new VIntroducirResultado(n);
                break;
        }
    }

    //---------- JON XU JIN ----------
    
    public static void cerrar(JDialog v) {
        // Cierra la ventana abierta
        v.dispose();
    }
    //-----Mikel
    public static void cerrar2(JFrame v) {
        // Cierra la ventana abierta
        v.dispose();
    }
    
    
    //---------- JON XU JIN ----------
    
    public static void reabrir(JDialog v, String tipo, int n) throws Exception {
        // Cierra la ventana abierta para volver a abrir según tipo de ventana cerrada
        v.dispose();
        switch(n){
            case 1:
                new VJugador(tipo, n);
                break;
                
            case 2:
                new VEquipo(tipo, n);
                break;
                
            case 3:
                new VUsuario(tipo, n);
                break;
                
            case 5:
                new VModificarEquipo(tipo);
                break;
                
            case 6:
                new VIntroducirResultado(n);
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
        login = new VLogin();
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
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Persona> consultarTodasLasPersonas() throws Exception{
        ArrayList <Persona> listadoPersona = new ArrayList();
        listadoPersona = bdPersona.buscarTodasLasPersona();
        return listadoPersona;
    }
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Persona> consultarTodosLosPartidos() throws Exception{
        ArrayList <Persona> listadoPersona = new ArrayList();
        listadoPersona = bdPersona.buscarTodasLasPersona();
        return listadoPersona;
    }
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Partido> consultarPartidosPorJornada(int n) throws Exception{
        ArrayList<Partido> lPartido = new ArrayList();
        lPartido = bdPartido.consultarPartidosPorJornada(n);
        return lPartido;
    }
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Partido> consultarMarcadorPorPartido(int n) throws Exception{
        ArrayList<Partido> lPartido = new ArrayList();
        lPartido = bdPartido.consultarPartidosPorJornada(n);
        return lPartido;
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

    public static VLogin getLogin() {
        return login;
    }

    public static void setLogin(VLogin login) {
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
        jugador=new Jugador();
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
    public static void bajaJugador() throws Exception {
        // Eliminar jugador en la BD
        BDJugador.eliminarJugador(jugador);
    }
    
    // Imanol Luis
    public static void modificarJugador(String dni, String nombre, String apellido1, String apellido2, String nickname, String sueldo, String comentario) throws Exception {
        // Modificar jugador en la BD
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
       jugador = new Jugador();
       jugador = BDJugador.BuscarJugador(dni);
       return jugador;
    }
    
    // Imanol Luis   
    public static ArrayList<Jugador> buscarJugador() throws Exception {        
       return BDJugador.BuscarJugador();
    }
    
    // Imanol Luis
    public static ArrayList<Jugador> buscarJugadores(String dni) throws Exception {      
       return BDJugador.BuscarJugadores(dni);
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
    public static boolean AnnadirJugadorEquipo(String nickname, String id) throws Exception {
        return BDJugador.PonerJugadorEquipo(nickname,id);
    }
    // Imanol Luis
    public static void altaEquipo(String nombre, Date fechaCreacion, String comentario) throws Exception {
        // Insertar equipo en la BD
        equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setFechaCreacion(fechaCreacion);
        equipo.setComentario(comentario);
        BDEquipo.insertarEquipo(equipo);
    }

    // Imanol Luis
    public static void bajaEquipo() throws Exception {
        // Eliminar equipo en la BD
        BDEquipo.eliminarEquipo(equipo);
    }

    // Imanol Luis
    public static void modificarEquipo(String nombre, String comentario) throws Exception {
        // Modificar equipo en la BD
        equipo.setNombre(nombre);
        equipo.setComentario(comentario);
        BDEquipo.modificarEquipo(equipo);
    }

    // Imanol Luis
    public static Equipo buscarEquipo(String nombre) throws Exception {
       equipo = new Equipo();
       equipo = BDEquipo.BuscarEquipo(nombre);
       return equipo;
    }

    // Imanol Luis
    public static ArrayList<Equipo> buscarEquipo() throws Exception {
        return BDEquipo.BuscarEquipo();
    }

    // Imanol Luis
    public static ArrayList<Equipo> buscarEquipos(String nombre) throws Exception {
        return BDEquipo.BuscarEquipos(nombre);
    }

    // Imanol Luis
    public static String buscarPlantilla(Equipo equipo) throws Exception {
        String plantilla="";
        String dni, nombre, apellido1, apellido2, nickname;
        
        ArrayList<Jugador> listaJugadores=BDJugador.BuscarEqui(String.valueOf(equipo.getIdEquipo()));
        
        for(int x=0;x<listaJugadores.size();x++)
        {
            if(x>0)
            {
                plantilla = plantilla + "\n";
            }
            
            dni=listaJugadores.get(x).getDni();
            nombre=listaJugadores.get(x).getNombre();
            apellido1=listaJugadores.get(x).getApellido1();
            apellido2=listaJugadores.get(x).getApellido2();
            nickname=listaJugadores.get(x).getNickname();
            
            plantilla=plantilla + dni + " – " + nombre + " " + apellido1 + " " + apellido2 + " – " + nickname;
        }
        
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
