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
import Views.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Clase controladora.
 * Fecha de creación de la clase: 24/04/2018
 * @author eqdaw04
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    
    private static BDEquipo bdEquipo;
    private static BDJornada bdJornada;
    private static BDJugador bdJugador;
    private static BDPartido bdPartido;
    private static BDPerfil bdPerfil;
    private static BDPersona bdPersona;
    private static Persona persona;
    private static Equipo equipo;
    private static Jugador jugador;
    //No se precisa objetos de jornada ni partido, ya que casi no se usa
    //El objeto perfil no es necesario, ya que sólo precisamos el nivel de la persona
    //Con estas omisiones de objetos, se ahorrá recursos del sistema 
    private static int perfil;
    private static float salarioMin, salarioMax;
    private static VLogin login;
    private static String driver, url, usuario, contrasenna;
    
    
    public static void main(String[] args) throws Exception {
        //driver para la conexion
        driver = "oracle.jdbc.OracleDriver";
        usuario = "eqdaw04";
        contrasenna = "eqdaw04";
        //construccion de la ruta completa.
        aplicarEstilo();
        inicializarValores();
        
        login = new VLogin();
        //new VPrincipal(1,"Jon");
    }
    
    /**
     * Metodo para aplicar el estilo de la interfaz gráfica
     * @throws Exception 
     */
    
    public static void aplicarEstilo() throws Exception {
        
        // http://codejavu.blogspot.com.es/2014/05/ejemplo-look-and-feel-en-java.html
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        // Nimbus
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        
        // Metal
        // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        
        // Windows
        // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        // Motif
        // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        
    }
    
    /**
     * Metodo para crear objetos de la base de datos.
     * @throws Exception 
     */
    
    public static void inicializarValores() throws Exception{
        bdEquipo = new BDEquipo();
        bdJornada = new BDJornada();
        bdJugador = new BDJugador();
        bdPartido = new BDPartido();
        bdPerfil = new BDPerfil();
        bdPersona = new BDPersona();
        salarioMin = 735.90f;
        salarioMax = 196320.00f;
    }
    
    /**
     * Metodo para introducir los datos del usuario y servidor.
     * @param usuario String
     * @param contrasenna char
     * @param numero int
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------

    public static void accederPrincipal(String usuario, char[] contrasenna, int numero) throws Exception{
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
            if(perfil == 3){
                new VUPrincipal();
            }
            else{
                new VPrincipal(perfil,persona.getUsuario());
            }
            
        }
        else if(cont <3){
            throw new Excepcion(12);
        }else if(cont == 3){
            login.setError(13);
            throw new Excepcion(13);
        }
    }
        /**
         * Metodo para seleccionar la ventana que se desea abrir.
         * @param n int
         * @param tipo String
         * @throws Exception 
         */
    //---------- JON XU JIN ----------
    
    public static void abrirVentana(int n, String tipo) throws Exception{
        switch(n){
            case 1:
                new VJugador(tipo, n);
                break;
                
            case 2:
                new VEquipo(tipo, n);
                break;
                
            case 3:
                new VPersona(tipo, n);
                break;

            case 5:
                new VModificarEquipo(tipo);
                break;
                
            case 6:
                new VIntroducirResultado(n);
                break;     
                
            case 7:
                new VGenerarLiga(n);
                break;
                
            case 8:
                new VCalendario();
                break; 
                
            case 9:
                new VDResultados(tipo);
                break;
        }
    }

    public static boolean borrarLiga() throws Exception{
        return bdJornada.borrarTodo();
    }
    /**
     * Metodo para cerrar la ventana abierta
     * @param v JDialog
     */
    
    //---------- JON XU JIN ----------
    
    public static void cerrar(JDialog v) {
        // Cierra la ventana abierta
        v.dispose();
    }
    
    /**
     * Metodo para cerrar la ventana abierta y volver a abrir según la ventana cerrada.
     * @param v JDialog
     * @param tipo String
     * @param n int
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static void reabrir(JDialog v, String tipo, int n) throws Exception {
        v.dispose();
        switch(n){
            case 1:
                new VJugador(tipo, n);
                break;
                
            case 2:
                new VEquipo(tipo, n);
                break;
                
            case 3:
                new VPersona(tipo, n);
                break;
                
            case 5:
                new VModificarEquipo(tipo);
                break;
                
            case 6:
                new VIntroducirResultado(n);
                break;
                
            case 7:
                new VGenerarLiga(n);
                break;
                
            case 8:
                new VCalendario();
                break;
                
            case 9:
                new VDResultados(tipo);
                break;
        }
    }
    
    /**
     * Metodo para abrir ventana jugador como consulta única.
     * @param j Jugador
     */
      //-------Mikel
 
    public static void abrirVJugador (Jugador j){
 
        new VJugador("consulta",1,j);
 
    }
    
    /**
     * Metodo para salir del programa
     * @param v  JFrame
     */

    
    public static void salir(JFrame v){
        //salir del programa
        v.dispose();
    }
    
    /**
     * Metodo para cerrar sesión y volver al login
     * @param v JFrame
     */
    
    //---------- JON XU JIN ----------
    
    public static void cerrarSesion(JFrame v){
        v.dispose();
        login = new VLogin();
    }
    
    /**
     * Metodo que devuelve una lista de todos los perfiles insertados en la base de datos.
     * @return lista de perfiles
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Perfil> consultarTodosLosPerfiles() throws Exception{
        return bdPerfil.buscarPerfiles();
    }
    
    /**
     * Metodo para consultar un perfil de la base de datos.
     * @param cod int
     * @return un perfil
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static Perfil consultarPerfil(int cod) throws Exception{
        return bdPerfil.buscarPorCodigo(cod);
    }
    
    /**
     * Metodo que inserta un usuario en la base de datos.
     * @param usuario String
     * @param contrasenna String
     * @param nombre String
     * @param ape1 String
     * @param ape2 String
     * @param email String
     * @param fecha Date
     * @param perfil String
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static void altaPersona( String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, Calendar fecha, String perfil) throws Exception{
        persona = new Persona(nombre, ape1, ape2, fecha, usuario, contrasenna, email);
        persona.setPerfil(bdPerfil.buscarPorNombre(perfil));
        bdPersona.altaPersona(persona);
    }
    
    /**
     * Metodo para eliminar un usuario de la base de datos.
     * @param usuario String
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------

    public static void bajaPersona(String usuario) throws Exception {
        bdPersona.bajaPersona(usuario);
    }
    
    /**
     * Metodo para modificar una persona de la base de datos.
     * @param id
     * @param usuario String
     * @param contrasenna String
     * @param nombre String
     * @param ape1 String
     * @param ape2 String
     * @param email String
     * @param perfil String
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static void modificarPersona(int id, String usuario, String contrasenna, String nombre, String ape1, String ape2, String email, String perfil, Calendar fecha) throws Exception {
        // en ved de modificar cada atributo, crear uno nuevo con su constructor se ahorra código

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        persona = new Persona(nombre, ape1, ape2, fecha, usuario, contrasenna, email);
        persona.setIdPersona(id);
        persona.setPerfil(bdPerfil.buscarPorNombre(perfil));
        bdPersona.modificarPersona(persona);
    }
    
    /**
     * Metodo para localizar a una persona por su usuario.
     * @param usuario String
     * @return una persona ya insertada en la base de datos
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static Persona consultarPersona(String usuario) throws Exception{
        persona = bdPersona.buscarPersonaPorUsuario(usuario);
        return persona;
    }
    
    /**
     * Metodo que devuelve todas las personas guardadas en la base de datos.
     * @return lista de personas
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Persona> consultarTodasLasPersonas() throws Exception{
        return bdPersona.buscarTodasLasPersona();
    }
    
    /**
     * Metodo que devuelve todos los partidos 
     * @return 
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Partido> consultarLosPartidosPorFecha(Calendar fecha) throws Exception{
        fecha.set(Calendar.HOUR_OF_DAY, 00);
        fecha.set(Calendar.MINUTE, 00);
        fecha.set(Calendar.SECOND, 00);
        fecha.set(Calendar.MILLISECOND, 00);
        return bdPartido.consultarPartidoPorFecha(fecha);
    }
    
    /**
     * Metodo para consultar los partidos de la jornada.
     * @param n int
     * @return una lista de partidos
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static ArrayList <Partido> consultarPartidosPorJornada(int n) throws Exception{
        return bdPartido.consultarPartidosPorJornada(n);
    }
    
    /**
     * Metodo para consultar el marcador por partido. 
     * @param p Partido
     * @return objeto partido
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static Partido consultarMarcadorPorPartido(Partido p) throws Exception{
        return bdPartido.consultarMarcadores(p);
    }
    
    /**
     * Metodo para consultar todas las jornadas.
     * @return lista de jornadas
     * @throws Exception 
     */
    
    
    //---------- JON XU JIN ----------
    
    public static ArrayList<Jornada> consultarTodasLasJornadas() throws Exception{
        return bdJornada.consultarTodasLasJornadas();
    }
    
    /**
     * Metodo para generar calendario de la liga.
     * @param fecha Calendar
     * @param horaF int
     * @return el dato obtenido de un objeto emparejamiento
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static String generarCalendario(Calendar fecha, int horaF) throws Exception{
        // extraer de la bbdd los equipos disponibles e instanciar el algoritmo de emparejamiento
        Emparejamiento emp = new Emparejamiento(bdEquipo.BuscarEquipo6());
        // ejecutar el algoritmo para los equipos aleatorios
        // Abrir conexion y mantenerlo abierto hasta que acabe que introducir las partidas para no tener que abrir y cerrar constantemente hasta introducir los X partidos
        emp.calcularPartido(fecha, horaF);
        return emp.getDato();
    }
    
    /**
     * Metodo para insertar una jornada.
     * @param nJornada int
     * @param fecha Calendar
     * @param con BDConexion
     * @return objeto jornada
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static Jornada insertarJornada(int nJornada, Calendar fecha, BDConexion con) throws Exception{
        return bdJornada.insertarJornada(nJornada, fecha, con);
    }
    
    /**
     * Metodo para modificar una jornada.
     * @param jornada Jornada
     * @param con BDConexion
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static void modificarJornada(Jornada jornada, BDConexion con) throws Exception{
        // modificar la fecha final de la jornada        
        bdJornada.modificarJornada(jornada, con);
        
    }
    
    /**
     * Metodo para insertar un partido.
     * @param partido Partido
     * @param jornada Jornada
     * @param con BDConexion
     * @return el estado "correcto" si se ha insertado sin problemas
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static boolean insertarPartido(Partido partido, Jornada jornada, BDConexion con) throws Exception{
        return bdPartido.insertarPartido(partido, jornada, con);
    }
    
    public static Jornada consultarInicioJornada() throws Exception{
        return bdJornada.consultarInicio();
    }
    
    /**
     * Metodo para modificar un partido.
     * @param partido Partido
     * @return el estado "correcto" si se ha insertado sin problemas
     * @throws Exception 
     */
  
    //---------- JON XU JIN ----------
    
    public static boolean modificarPartido(Partido partido) throws Exception{
        return bdPartido.modificarPartido(partido);
    }
    
    /**
     * Metodo para consultar un equipo por su id.
     * @param n int
     * @return objeto equipo
     * @throws Exception 
     */
    
    //---------- JON XU JIN ----------
    
    public static Equipo consultarEquipoPorNumero(int n) throws Exception{
        equipo = bdEquipo.consultarEquipoPorNumero(n);
        return equipo;
    }
    
    //---------- JON XU JIN ----------
    
    public static boolean modificarMarcador(Partido p) throws Exception{
        return bdPartido.modificarMarcador(p);
    }
    
    //----------JON XU JIN ----------
    public static void validar(int cod, JTextField campo) throws Exception{        
        Pattern p=Pattern.compile(datoPatron(cod));
        Matcher m=p.matcher(campo.getText());
        if(!m.matches())
        {
            campo.setBackground(Color.red);
            campo.grabFocus();
            throw new Excepcion(cod);
        }
        else{
            campo.setBackground(Color.white);
        }
    }
    
    
    public static ArrayList<Object> resultados() throws Exception{
        return bdEquipo.resultadoFinal();
    }
    
    public static ArrayList<Object> resultadosUltimaJornada() throws Exception{
        return bdEquipo.resultadoUltimaJornada();
    }
    
    /**
     * Metodo que guarda los patterns que utilizaremos en el programa.
     * @param cod int
     * @return devuelve el patrón a utilizar.
     */
    
    public static String datoPatron(int cod){
        String dato = "";
        switch(cod){

            case 46: // marcador
                dato = "^[0-9]{1,}$";
                break;
                
            case 3: // NIF
                dato = "^[A-Z0-9][0-9]{7}[A-Z]$";
                break;
                
            case 4: // Nombre
                dato = "^[A-ZÑ][a-zñ]{2,}$";
                break;
                
            case 5: // Apellidos
                dato = "^[A-ZÑ][a-zñ]{2,}$";
                break;
                
            case 6: // e-mail
                dato = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,})$";
                break;
                
            case 7: // Usuario
                dato = "^[A-ZÑña-z0-9]{3,}$";
                break;
                
            case 8: // Contraseña
                dato = "^[A-ZñÑa-z0-9]{3,}$";
                break;
                
            case 29: // lugar
                dato = "^[A-ZÑ][a-zñ]{2,}$";
                break;
        }
        return dato;
    }
    
    /**
     * Metodo para obtener un perfil.
     * @return perfil
     */

    public static int getPerfil() {
        return perfil;
    }

    /**
     * Metodo para establecer el perfil.
     * @param perfil  int
     */
    
    public static void setPerfil(int perfil) {
        Main.perfil = perfil;
    }
    
    /**
     * Metodo para obtener el login.
     * @return objeto login
     */

    public static VLogin getLogin() {
        return login;
    }
    
    /**
     *  Metodo para establecer el login.
     * @param login VLogin
     */

    public static void setLogin(VLogin login) {
        Main.login = login;
    }
    
    /**
     *  Metodo para obtener el driver de la conexion.
     * @return driver
     */

    public static String getDriver() {
        return driver;
    }
    
    /**
     *  Metodo para establecer el driver de la conexión.
     * @param driver String
     */

    public static void setDriver(String driver) {
        Main.driver = driver;
    }
    
    /**
     *  Metodo para obtener la url de la conexión.
     * @return url
     */

    public static String getUrl() {
        return url;
    }
    
    /**
     *  Metodo para establecer la url de la conexión.
     * @param url String
     */

    public static void setUrl(String url) {
        Main.url = url;
    }
    
    /**
     *  Metodo para obtener el usuario con el que se inicia sesión en la conexión.
     * @return usuario
     */

    public static String getUsuario() {
        return usuario;
    }
    
    /**
     *  Metodo para establecer el usuario con el que se inicia sesión en la conexión.
     * @param usuario String
     */

    public static void setUsuario(String usuario) {
        Main.usuario = usuario;
    }
    
    /**
     * Metodo para obtener la contraseña con la que se inicia sesión en la conexión.
     * @return 
     */

    public static String getContrasenna() {
        return contrasenna;
    }
    
    /**
     * Metodo para establecer la contraseña con ka que se inicia sesión en la conexión.
     * @param contrasenna 
     */

    public static void setContrasenna(String contrasenna) {
        Main.contrasenna = contrasenna;
    }
    
    /**
     * Metodo para obtener una persona.
     * @return objeto persona
     */

    public static Persona getPersona() {
        return persona;
    }
    
    /**
     * Metodo para establecer una persona.
     * @param persona Persona
     */

    public static void setPersona(Persona persona) {
        Main.persona = persona;
    }

    public static float getSalarioMin() {
        return salarioMin;
    }

    public static float getSalarioMax() {
        return salarioMax;
    }

    // se mantiene los set de salario max y min, por si un futuro se plantea integrar los salarios en la bbdd
    // aunque actualmente no tiene uso alguna
    public static void setSalarioMax(float salarioMax) {
        Main.salarioMax = salarioMax;
    }

    public static void setSalarioMin(float salarioMin) {
        Main.salarioMin = salarioMin;
    }
    
    /**
     * Metodo para dar de alta a un jugador en la base de datos.
     * @param dni String
     * @param nombre String
     * @param apellido1 String
     * @param apellido2 String
     * @param nickname String
     * @param sueldo String
     * @param fechaAlta Date
     * @param comentario String
     * @throws Exception 
     */
    
    // Imanol Luis
    public static void altaJugador(String dni, String nombre, String apellido1, String apellido2, String nickname, float sueldo, Date fechaAlta, String comentario) throws Exception {
        jugador = new Jugador(dni, nombre, apellido1, apellido2, nickname, sueldo, fechaAlta, comentario);
        bdJugador.insertarJugador(jugador);
    }
    
    /**
     * Metodo para dar de baja a un jugador de la base de datos.
     * @throws Exception 
     */

    // Imanol Luis
    public static void bajaJugador() throws Exception {
        bdJugador.eliminarJugador(jugador);
    }
    
    /**
     * Metodo para modificar a un jugador de la base de datos.
     * @param id
     * @param j
     * @param dni String
     * @param nombre String
     * @param apellido1 String
     * @param apellido2 String
     * @param nickname String
     * @param sueldo String
     * @param comentario String
     * @throws Exception 
     */
    
    // Imanol Luis
    public static void modificarJugador(int id , String dni, String nombre, String apellido1, String apellido2, String nickname, float sueldo,Date fecha, String comentario) throws Exception {
        jugador = new Jugador(dni, nombre, apellido1, apellido2, nickname, sueldo, fecha, comentario);
        jugador.setIdJugador(id);
        bdJugador.modificarJugador(jugador);
    }
    
    /**
     * Metodo para buscar a un jugador a traves del DNI.
     * @param dni String
     * @return objeto jugador
     * @throws Exception 
     */
    
    // Imanol Luis   
    public static Jugador buscarJugador(String dni) throws Exception {  
        jugador = bdJugador.BuscarJugador(dni);
       return jugador;
    }
    
    /**
     * Metodo para buscar todos los jugadores de la base de datos.
     * @return devuelve los jugadores introducidos en la clase BDJugador
     * @throws Exception 
     */
    
    // Imanol Luis   
    public static ArrayList<Jugador> buscarJugador() throws Exception {        
       return bdJugador.BuscarJugador();
    }
    
    /**
     * Metodo para buscar jugadores pertenecientes a un equipo.
     * @param id String
     * @return devuelve los ids introducidos en la clase BDJugador
     * @throws Exception 
     */
    
    //------------Mikel
    public static ArrayList<Jugador> obtenerJugEqui(String id) throws Exception{
        return bdJugador.BuscarEqui(id);
    }
    
    /**
     * Metodo para consultar el equipo de un dueño mediante su usuario
     * @param usu String
     * @return devuelve el equipo que dirige el dueño
     * @throws Exception 
     */

    //------------Mikel
    public static Equipo ConsultarEquipoPorUsuario(String usu) throws Exception{
        equipo = bdEquipo.BuscarEquipoPorUsuario(usu);
        return equipo;
    }
    
    /**
     * Metodo que consulta los jugadores que no pertenecen a ningún equipo.
     * @return devuelve jugadores sin equipo
     * @throws Exception 
     */
    
    //------------Mikel
    public static ArrayList <Jugador> consultarJugadoresDisponibles () throws Exception{
        return bdJugador.BuscarJugadoresDisponibles();
    }
    
    /**
     * Metodo para eliminar de un equipo a un jugador.
     * @param nickname String
     * @return devuelve el nickname del jugador y al eliminarlo pone el id del equipo al que pertenecía a null
     */
    
    //------------Mikel
    public static boolean EliminarJugadorEquipo (String nickname) throws Exception{
       
        return bdJugador.QuitarJugadorEquipo(nickname);
    }
    
    /**
     * Metodo para añadir un jugador a un equipo.
     * @param nickname String
     * @param id String
     * @return devuelve el nickname del jugador y le añade el id del equipo al que se le va a añadir.
     * @throws Exception 
     */
    
    //------------Mikel
    public static boolean AnnadirJugadorEquipo(String nickname, String id) throws Exception {
        return bdJugador.PonerJugadorEquipo(nickname,id);
    }
    //------------Mikel
 
    // Busca a un jugador por su nickname yle añade el id_equipo del equipo al que se le quiere añadir
 
    public static Jugador consultarJugadorNickname(String nickname) throws Exception {
 
        return bdJugador.buscarJugadorNickname(nickname);
 
    }
 
    /**
     * Metodo para dar de alta un equipo en la base de datos.
     * @param nombre String
     * @param lugar
     * @param usuario String
     * @param fechaCreacion Date
     * @param comentario String
     * @throws Exception 
     */
    
    // Imanol Luis
    public static void altaEquipo(String nombre, String lugar, String usuario, Date fechaCreacion, String comentario) throws Exception {
        equipo = new Equipo();
        equipo.setNombre(nombre);     
        equipo.setLugar(lugar);
        equipo.setPersona(bdPersona.buscarPersonaPorUsuario(usuario));
        equipo.setFechaCreacion(fechaCreacion);
        equipo.setComentario(comentario);
        bdEquipo.insertarEquipo(equipo);
    }
    
    /**
     * Metodo para dar de baja un equipo de la base de datos.
     * @throws Exception 
     */

    // Imanol Luis
    public static void bajaEquipo() throws Exception {
        bdEquipo.eliminarEquipo(equipo);
    }
    
    /**
     * Metodo para modificar un equipo de la base de datos.
     * @param nombre String
     * @param comentario String
     * @throws Exception 
     */

    // Imanol Luis
    public static void modificarEquipo(String nombre, String lugar, Date fecha, String comentario) throws Exception {
        equipo.setNombre(nombre);
        equipo.setLugar(lugar);
        equipo.setFechaCreacion(fecha);
        equipo.setComentario(comentario);
        bdEquipo.modificarEquipo(equipo);
    }
    
    /**
     * Metodo para buscar un equipo de la base de datos a traves del nombre
     * @param nombre String
     * @return objeto equipo
     * @throws Exception 
     */

    // Imanol Luis
    public static Equipo buscarEquipo(String nombre) throws Exception {
        equipo = bdEquipo.BuscarEquipo(nombre);
       return equipo;
    }
    
    /**
     * Metodo para buscar todos los equipos de la base de datos
     * @return todos los equipos de la base de datos
     * @throws Exception 
     */

    // Imanol Luis
    public static ArrayList<Equipo> buscarEquipo() throws Exception {
        return bdEquipo.BuscarEquipo();
    }
    
    /**
     * Metodo para obtener todos los datos de todos los jugadores de un equipo
     * @param equipo Equipo
     * @return String
     * @throws Exception 
     */

    public static String buscarPlantilla(Equipo equipo) throws Exception {
        String plantilla="";
        String dni, nombre, apellido1, apellido2, nickname;
        
        ArrayList<Jugador> listaJugadores=bdJugador.BuscarEqui(String.valueOf(equipo.getIdEquipo()));
        
        for(int x=0;x<listaJugadores.size();x++){
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
    
    /**
     * Metodo para buscar los usuarios que sean dueños.
     * @return Devuelve todos los usuarios que sean dueños.
     * @throws Exception 
     */

    // Imanol Luis
    public static ArrayList<Persona> buscarUsuariosDuennos() throws Exception {
         return bdPersona.buscarUsuariosDuennos();
    }
    
    /**
     * Metodo para comprobar que el dueño pertenece a un equipo.
     * @param usuario String
     * @return objeto equipo cuando todo está correcto.
     * @throws Exception 
     */

    // Imanol Luis
    public static boolean duennoTieneEquipo(String usuario) throws Exception {
        equipo = bdEquipo.BuscarEquipoPorUsuario(usuario);
        if(equipo == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }    
    
    /**
     * Metodo para obtener persona por su id.
     * @param idPersona int
     * @return objeto persona
     * @throws Exception 
     */

    public static Persona obtenerPersona(int idPersona) throws Exception {
        bdPersona.buscarPersona(idPersona);
        return persona;
    }
    //----------------MIKEL
    public static ArrayList <Partido> BuscarPartidosPorJornada (int j) throws Exception{
        return bdPartido.BuscarPartidosPorJornada (j);
    }
}
