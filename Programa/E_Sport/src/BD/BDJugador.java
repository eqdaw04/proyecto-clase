/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Excepciones.Excepcion;
import UML.Jugador;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Clase en la que controlaremos e introduciremos los jugadores a la base de datos.
 * Fecha de creación de la clase: 02/05/2018
 * @author eqdaw04
 */

public class BDJugador {

    public BDJugador() {
    }
    
     /**
     * Metodo para buscar un jugador por dni.
     * @param dni String
     * @return devuelve una lista de jugadores 
     * @throws Exception 
     */   
    
    public Jugador BuscarJugador(String dni) throws Exception {
        // abrir la conexión
        BDConexion con = new BDConexion();
        // instanciar un arraylist
        ArrayList<Jugador> a = new ArrayList();
        // preparar la sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni = ?");
        // cargar datos al ?
        sentencia.setString(1,dni);
        // instanciar rs, ejecutarlo y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // mandar rs a una funcion
        a = recorrer(rs,a);
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // comprobar si la lista tiene datos y devolver objeto
        if(a.isEmpty())
        {
            return null;
        }
        else
        {
            return a.get(0);
        }        
    }
    
    /**
     * Metodo para buscar una lista de todos los jugadores.
     * @return devuelve una lista de jugadores 
     * @throws Exception 
     */    
    
    public ArrayList<Jugador> BuscarJugador() throws Exception {
        // abrir conexion
        BDConexion con = new BDConexion();
        // instanciar una lista
        ArrayList<Jugador> a = new ArrayList();
        // preparar la sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador");
        // instanciar rs, ejecutar la sentencia y cargarlo al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // mandar el rs a una función
        a = recorrer(rs,a);
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver lista
        return a;
    }
    
        /**
     * Metodo para buscar la lista de jugadores de un equipo. 
     * @param id String
     * @return devuelve una lista de jugadores
     * @throws Exception 
     */
    
    public ArrayList<Jugador> BuscarEqui(String id) throws Exception {
        // abrir conexión
       BDConexion con = new BDConexion();
       // instanciar una lista
       ArrayList<Jugador> a= new ArrayList();
       // preparar la sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo = ?");
        // cargar dato al ?
        sentencia.setString(1,id);
        // instanciar rs, ejecutar la sentencia y cargar los datos obtenidos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // enviar el rs a una función
        a= recorrer (rs,a);
        // cerrar lo abierto
        rs.close();
        con.desconectar();
        // devolver la lista
        return a;
    }
    
        /**
     * Metodo para recorrer los datos de un jugador.
     * @param rs ResultSet
     * @param a ArrayList de jugador
     * @return devuelve los datos del jugador introducido en la lista
     * @throws SQLException 
     */
    
    public ArrayList<Jugador> recorrer(ResultSet rs, ArrayList <Jugador> a) throws SQLException {
        // comprobar si existe datos en el rs
        while (rs.next()){
            // instanciar objeto jugador y llenarlo de datos del rs
            Jugador j= new Jugador();
            j.setIdJugador(Integer.parseInt(rs.getString("id_jugador")));
            j.setDni(rs.getString("dni"));
            j.setNombre(rs.getString("nombre"));
            j.setApellido1(rs.getString("apellido1"));
            j.setApellido2(rs.getString("apellido2"));
            j.setNickname(rs.getString("nickname"));
            j.setSueldo(Float.parseFloat(rs.getString("sueldo")));
            j.setFechaAlta(rs.getDate("fecha_alta"));
            j.setComentario(rs.getString("comentario"));      
            // añadir el objeto a la lista
            a.add(j);
        }
        // devolver lista
        return a;
    }
    
        /**
     * Metodo para buscar jugadores que no estén en ningún equipo.
     * @return devuelve una lista de jugadores
     * @throws Exception 
     */

    public ArrayList<Jugador> BuscarJugadoresDisponibles() throws Exception {
        // abrir conexion
        BDConexion con = new BDConexion();
        // instanciar una lista
        ArrayList<Jugador> a= new ArrayList();
        // preparar la sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo is null");
        sentencia.executeUpdate();
        // instanciar rs, ejecutar sentencia y cargarlo al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // mandar el rs a una funcion
        a= recorrer (rs,a);
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver la lista
        return a;
    }
    
    /**
     * Metodo para buscar un jugador por su nickname.
     * @param nickname String
     * @return devuelve una lista de jugadores
     * @throws Exception 
     */
    
    
    
    
    
    
    
    
    
    
    
    // pendiente bdpartido, bdperfil y bdpersona
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Jugador buscarJugadorNickname(String nickname) throws Exception{ 
        BDConexion con = new BDConexion(); 
        ArrayList<Jugador> a = new ArrayList(); 
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Nickname = ?"); 
        sentencia.setString(1,nickname); 
        ResultSet rs;
        rs = sentencia.executeQuery(); 
        a = recorrer(rs,a); 
        rs.close();
        sentencia.close(); 
        con.desconectar(); 
        return a.get(0); 
    } 
    
    /**
     * Metodo para insertar jugadores.
     * @param j Jugador
     * @throws Exception 
     */    
    
    public void insertarJugador(Jugador j) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO Jugador (DNI, NOMBRE, APELLIDO1, APELLIDO2, NICKNAME, SUELDO, FECHA_ALTA, COMENTARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        sentencia.setString(1, j.getDni());
        sentencia.setString(2, j.getNombre());
        sentencia.setString(3, j.getApellido1());
        sentencia.setString(4, j.getApellido2());
        sentencia.setString(5, j.getNickname());
        sentencia.setFloat(6, j.getSueldo());
        sentencia.setDate(7, formatearFecha(j.getFechaAlta()));
        sentencia.setString(8, j.getComentario());
                                
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        sentencia.close();
        con.desconectar();
    }
    
        /**
     * Metodo para eliminar jugadores.
     * @param j Jugador
     * @throws Exception 
     */
    
    public void eliminarJugador(Jugador j) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("DELETE FROM Jugador WHERE Id_jugador = ?"); 
        sentencia.setInt(1, j.getIdJugador());                
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        sentencia.close();
        con.desconectar();
    }
    
        /**
     * Metodo para borrar jugadores de un equipo.
     * @param nickname String
     * @return devuelve correcto si el UPDATE se hace bien
     * @throws java.lang.Exception
     */

    public boolean QuitarJugadorEquipo(String nickname) throws Exception {
        boolean correcto;
        correcto = false;
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET Id_equipo = null WHERE UPPER(Nickname) = UPPER(?)");
        sentencia.setString(1, nickname);
        if(sentencia.executeUpdate()==1){
            correcto =true;
        }
        sentencia.close();
        con.desconectar();
        
        return correcto;
    }
    
     /**
     * Metodo para insertar un jugador en un equipo.
     * @param nickname String
     * @param id String
     * @return devuelve correcto si el UPDATE se hace bien
     * @throws Exception 
     */  

    public boolean PonerJugadorEquipo(String nickname, String id) throws Exception{
        boolean correcto;
        correcto = false;
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET Id_equipo = ? WHERE UPPER(Nickname) = UPPER(?)");
        sentencia.setString(1, id);
        sentencia.setString(2, nickname);
        if(sentencia.executeUpdate()==1){
            correcto =true;
        }
        sentencia.close();
        con.desconectar();
        return correcto;
    }
    
     /**
     * Metodo para modificar datos de un jugador.
     * @param j Jugador
     * @throws Exception 
     */   
    
    public void modificarJugador(Jugador j) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET DNI=?, NOMBRE=?, APELLIDO1=?, APELLIDO2=?, NICKNAME=?, SUELDO=?, COMENTARIO=? WHERE ID_JUGADOR=?"); 
        sentencia.setString(1, j.getDni()); 
        sentencia.setString(2, j.getNombre()); 
        sentencia.setString(3, j.getApellido1()); 
        sentencia.setString(4, j.getApellido2()); 
        sentencia.setString(5, j.getNickname()); 
        sentencia.setFloat(6, j.getSueldo()); 
        sentencia.setString(7, j.getComentario()); 
        sentencia.setInt(8, j.getIdJugador());                          
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        sentencia.close();
        con.desconectar();
    }
    
       /**
     * Metodo para formatear la fecha de alta.
     * @param fechaE Date
     * @return fecha
     */ 

    private Date formatearFecha(java.util.Date fechaE){
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        return Date.valueOf(fecha);
    }
    
}
