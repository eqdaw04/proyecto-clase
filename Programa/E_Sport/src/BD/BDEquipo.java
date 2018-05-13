/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import Excepciones.Excepcion;
import UML.Equipo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase en la que introduciremos y controlaremos los equipos a la base de datos.
 * Fecha de creación de la clase: 09/05/2018
 * @author eqdaw04
 */

public class BDEquipo {
    
    /**
     * Metodo para insertar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    

    public static void insertarEquipo(Equipo e) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia = con.getConnection().prepareStatement("INSERT INTO Equipo (NOMBRE, FECHA_CREACION, COMENTARIO, ID_PERSONA) VALUES (?, ?, ?, ?)");
        sentencia.setString(1, e.getNombre());
        sentencia.setDate(2, formatearFecha(e.getFechaCreacion()));
        sentencia.setString(3, e.getComentario());
        sentencia.setInt(4, e.getPersona().getIdPersona());
                                
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para eliminar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public static void eliminarEquipo(Equipo e) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia = con.getConnection().prepareStatement("DELETE FROM Equipo WHERE ID_EQUIPO = ?");
        sentencia.setInt(1, e.getIdEquipo());                 
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para modificar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public static void modificarEquipo(Equipo e) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia = con.getConnection().prepareStatement("UPDATE Equipo SET COMENTARIO=? WHERE ID_EQUIPO = ?");
        sentencia.setString(1, e.getComentario());
        sentencia.setInt(2, e.getIdEquipo());
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para buscar un equipo por nombre de un usuario integrante.
     * @param usu String
     * @return devuelve un objeto equipo
     * @throws Exception 
     */
    
    public static Equipo BuscarEquipoPorUsuario(String usu) throws Exception {
        BDConexion con = new BDConexion();
        Equipo e = new Equipo();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Id_persona = (SELECT Id_persona FROM Persona WHERE Usuario = ?)");
        sentencia.setString(1,usu);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()){
            e.setIdEquipo(Integer.parseInt(rs.getString(1)));
            e.setNombre(rs.getString(2));
            e.setFechaCreacion(rs.getDate(3));
            e.setComentario(rs.getString(4));
            e.setPersona(Main.obtenerPersona(Integer.parseInt(rs.getString(5))));
        }
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return e;
    }
    
    /**
     * Metodo para buscar una lista de equipos por nombre.
     * @param nombre String
     * @return devuelve el nombre del equipo encontrado
     * @throws Exception 
     */
    
    public static Equipo BuscarEquipo(String nombre) throws Exception {
        BDConexion con = new BDConexion();
        Equipo e = null;
        try
        {
            PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Nombre = ?");
            sentencia.setString(1, nombre);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
            e= new Equipo();
            e.setIdEquipo(Integer.parseInt(rs.getString(1)));
            e.setNombre(rs.getString(2));
            e.setFechaCreacion(rs.getDate(3));
            e.setComentario(rs.getString(4));
            e.setPersona(Main.obtenerPersona(Integer.parseInt(rs.getString(5))));
        }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectar();
        return e;
    }
    
    /**
     * Metodo para buscar una lista de todos los equipos.
     * @return devuelve una lista de equipos
     * @throws Exception 
     */
    
    public static ArrayList<Equipo> BuscarEquipo() throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Equipo> a = new ArrayList();
        try
        {
            PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo");
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
            Equipo e= new Equipo();
            e.setIdEquipo(Integer.parseInt(rs.getString(1)));
            e.setNombre(rs.getString(2));
            e.setFechaCreacion(rs.getDate(3));
            e.setComentario(rs.getString(4));
            e.setPersona(Main.obtenerPersona(Integer.parseInt(rs.getString(5))));
            
            a.add(e);
        }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectar();
        return a;
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
