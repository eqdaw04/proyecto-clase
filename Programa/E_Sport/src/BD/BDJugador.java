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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase en la que controlaremos e introduciremos los jugadores a la base de datos.
 * Fecha de creación de la clase: 02/05/2018
 * @author eqdaw04
 */

public class BDJugador {
    
     /**
     * Metodo para buscar una lista de jugadores por dni.
     * @param dni String
     * @return Devuelve una lista de jugadores 
     * @throws Exception 
     */   
    
    public static Jugador BuscarJugador(String dni) throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Jugador> a = new ArrayList();
        try
        {
            PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni = ?");
            sentencia.setString(1,dni);
            ResultSet rs = sentencia.executeQuery();
            a = recorrer(rs,a);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectar();
        return a.get(0);
    }
    
    /**
     * Metodo para buscar una lista de todos los jugadores.
     * @return Devuelve una lista de jugadores 
     * @throws Exception 
     */    
    
    public static ArrayList<Jugador> BuscarJugador() throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Jugador> a = new ArrayList();
        try
        {
            PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador");
            ResultSet rs = sentencia.executeQuery();
            a = recorrer(rs,a);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectar();
        return a;
    }
    
        /**
     * Metodo para buscar la lista de jugadores de un equipo. 
     * @param id String
     * @return Devuelve una lista de jugadores
     * @throws Exception 
     */
    
    public static ArrayList<Jugador> BuscarEqui(String id) throws Exception {
       BDConexion con = new BDConexion();
       ArrayList<Jugador> a= new ArrayList();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo = ?");
        sentencia.setString(1,id);
        sentencia.executeUpdate();
        ResultSet rs = sentencia.executeQuery();
        a= recorrer (rs,a);
        con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectar();
        return a;
    }
    
        /**
     * Metodo para recorrer los datos de un jugador.
     * @param rs ResultSet
     * @param a ArrayList de jugador
     * @return devuelve los datos del jugador introducido en la lista
     * @throws SQLException 
     */
    
    public static ArrayList<Jugador> recorrer(ResultSet rs, ArrayList <Jugador> a) throws SQLException {
        while (rs.next()){
            Jugador j= new Jugador();
            j.setIdJugador(Integer.parseInt(rs.getString(1)));
            j.setDni(rs.getString(2));
            j.setNombre(rs.getString(3));
            j.setApellido1(rs.getString(4));
            j.setApellido2(rs.getString(5));
            j.setNickname(rs.getString(6));
            j.setSueldo(Float.parseFloat(rs.getString(7)));
            j.setFechaAlta(rs.getDate(8));
            j.setComentario(rs.getString(9));      
            a.add(j);
        }
        return a;
    }
    
        /**
     * Metodo para buscar jugadores que no estén en ningún equipo.
     * @return devuelve una lista de jugadores
     * @throws Exception 
     */

    public static ArrayList<Jugador> BuscarJugadoresDisponibles() throws Exception {
        ResultSet rs = null;
        BDConexion con = new BDConexion();
        ArrayList<Jugador> a= new ArrayList();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo is null");
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
        a= recorrer (rs,a);
        con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        con.desconectar();
        return a;
    }
    
    /**
     * Metodo para buscar un jugador por su nickname.
     * @param nickname String
     * @return devuelve una lista de jugadores
     * @throws Exception 
     */
    
    public static Jugador buscarJugadorNickname(String nickname) throws Exception{ 
        BDConexion con = new BDConexion(); 
        ArrayList<Jugador> a = new ArrayList(); 
        try 
        { 
            PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Nickname = ?"); 
            sentencia.setString(1,nickname); 
            ResultSet rs = sentencia.executeQuery(); 
            a = recorrer(rs,a); 
        } 
        catch (SQLException ex) 
        { 
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex); 
        } 
        con.desconectar(); 
        return a.get(0); 
    } 
    
    /**
     * Metodo para insertar jugadores.
     * @param j Jugador
     * @throws Exception 
     */    
    
    public static void insertarJugador(Jugador j) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia = con.getConnection().prepareStatement("INSERT INTO Jugador (DNI, NOMBRE, APELLIDO1, APELLIDO2, NICKNAME, SUELDO, FECHA_ALTA, COMENTARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
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
    
    public static void eliminarJugador(Jugador j) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia = con.getConnection().prepareStatement("DELETE FROM Jugador WHERE Id_jugador = ?"); 
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
     */

    public static boolean QuitarJugadorEquipo(String nickname) {
        boolean correcto=false;
        try {
            BDConexion con = new BDConexion();
            PreparedStatement sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET Id_equipo = null WHERE UPPER(Nickname) = UPPER(?)");
            sentencia.setString(1, nickname);
            sentencia.executeUpdate();
            con.desconectar();
            correcto =true;
        } catch (Exception ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return correcto;
    }
    
     /**
     * Metodo para insertar un jugador en un equipo.
     * @param nickname String
     * @param id String
     * @return devuelve correcto si el UPDATE se hace bien
     * @throws Exception 
     */  

    public static boolean PonerJugadorEquipo(String nickname, String id) throws Exception{
        boolean correcto=false;
            BDConexion con = new BDConexion();
            PreparedStatement sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET Id_equipo = ? WHERE UPPER(Nickname) = UPPER(?)");
            sentencia.setString(1, id);
            sentencia.setString(2, nickname);
            sentencia.executeUpdate();
            con.desconectar();
            correcto =true;
        return correcto;
    }
    
     /**
     * Metodo para modificar datos de un jugador.
     * @param j Jugador
     * @throws Exception 
     */   
    
    public static void modificarJugador(Jugador j) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET DNI=?, NOMBRE=?, APELLIDO1=?, APELLIDO2=?, NICKNAME=?, SUELDO=?, COMENTARIO=? WHERE ID_EQUIPO=?"); 
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

    private static Date formatearFecha(java.util.Date fechaE){
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        return Date.valueOf(fecha);
    }
    
}
