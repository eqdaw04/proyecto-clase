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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *Clase en la que introduciremos y controlaremos los equipos a la base de datos.
 * Fecha de creación de la clase: 09/05/2018
 * @author eqdaw04
 */

public class BDEquipo {

    public BDEquipo() {
    }
    
    /**
     * Metodo para insertar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public void insertarEquipo(Equipo e) throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        // cargar la sentencia
        sentencia = con.getConnection().prepareStatement("INSERT INTO Equipo (NOMBRE, FECHA_CREACION, COMENTARIO, LUGAR, ID_PERSONA) VALUES (?, ?, ?, ?, ?)");
        // enviar los datos a los ? 
        sentencia.setString(1, e.getNombre());
        // formatear la fecha
        sentencia.setDate(2, formatearFecha(e.getFechaCreacion()));
        sentencia.setString(3, e.getComentario());
        sentencia.setString(4, e.getLugar());
        sentencia.setInt(5, e.getPersona().getIdPersona());
        // ejecutar la sentencia y comprobar si se ha insertado la fila, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1)
        {
            // mostrar error
            throw new Excepcion(25);
        }
        // cerrar lo que se ha abierto
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para eliminar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public void eliminarEquipo(Equipo e) throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        // preparar la sentencia
        sentencia = con.getConnection().prepareStatement("DELETE FROM Equipo WHERE ID_EQUIPO = ?");
        // mandar el dato al ?
        sentencia.setInt(1, e.getIdEquipo());
        // ejecutar sentencia y comprobar si devuelve 1, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1)
        {
            // mostrar error
            throw new Excepcion(25);
        }
        // cerrar lo que se ha abierto
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para modificar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public void modificarEquipo(Equipo e) throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        // preparar la sentencia
        sentencia = con.getConnection().prepareStatement("UPDATE Equipo SET NOMBRE=?, COMENTARIO=?, LUGAR=? WHERE ID_EQUIPO = ?");
        // cargar los datos al ?
        sentencia.setString(1, e.getNombre());
        sentencia.setString(2, e.getComentario());
        sentencia.setString(3, e.getLugar());
        sentencia.setInt(4, e.getIdEquipo());
        // ejecutar sentencia y comprobar si devuelve 1, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1)
        {
            // mostrar error
            throw new Excepcion(25);
        }
        // cerrar lo que se ha abierto
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para buscar un equipo por nombre de un usuario integrante.
     * @param usu String
     * @return devuelve un objeto equipo
     * @throws Exception 
     */
    
    public Equipo BuscarEquipoPorUsuario(String usu) throws Exception  {
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar objeto equipo en null
        Equipo e = null;
        PreparedStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Id_persona = (SELECT Id_persona FROM Persona WHERE Usuario = ?)");
        // cargar los datos al ?
        sentencia.setString(1,usu);
        // ejecutar sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si hay registro
        if (rs.next()){
            // llenar el objeto equipo con los datos existentes en el rs con una función
            e = recorrer(rs);
        }
        // cerrar lo que se ha abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        return e;
    }
    
    private Equipo recorrer(ResultSet rs) throws Exception{
        // instanciar el objeto equipo y llenarlo con los datos del rs
        Equipo e = new Equipo();
        e.setIdEquipo(rs.getInt("id_equipo"));
        e.setNombre(rs.getString("nombre"));
        e.setFechaCreacion(rs.getDate("fecha_creacion"));            
        e.setComentario(rs.getString("comentario"));
        e.setLugar(rs.getString("lugar"));
        e.setPersona(Main.obtenerPersona(rs.getInt("id_persona")));
        // devolver el objeto cargado
        return e;
    }
    /**
     * Metodo para buscar una lista de equipos por nombre.
     * @param nombre String
     * @return devuelve el nombre del equipo encontrado
     * @throws Exception 
     */
    
    public Equipo BuscarEquipo(String nombre) throws Exception {
        // abrir conexion
        BDConexion con = new BDConexion();
        // instanciar objeto equipo en null
        Equipo e = null;
        PreparedStatement sentencia;
        // preparar  sentencia
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Nombre = ?");
        // cargar datos al ?
        sentencia.setString(1, nombre);
        // instanciar rs, ejecutar sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar sie xiste datos en el rs
        if (rs.next()){
            // mandar a la función recorrer el rs y devolver el objeto cargado
            e = recorrer(rs);
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver objeto cargado
        return e;
    }
    
    /**
     * Metodo para consultar un equipo por su número de id
     * @param n int
     * @return devuelve un objeto equipo
     * @throws Exception 
     */
    
    public Equipo consultarEquipoPorNumero(int n) throws Exception{
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar objeto en null
        Equipo e = null;
        PreparedStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareStatement("SELECT id_equipo, nombre, lugar FROM equipo WHERE id_equipo = ?");
        // cargar datos al ?
        sentencia.setInt(1, n);
        // instanciar rs, ejecutar sentencia y cargarlo al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si existe datos en rs
        if(rs.next()){
            // instanciar el objeto y cargarlo con datos del rs
            e = new Equipo();
            e.setIdEquipo(n);
            e.setNombre(rs.getString("nombre"));
            e.setLugar(rs.getString("lugar"));           
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver objeto
        return e;
    }
    /**
     * Metodo para buscar una lista de todos los equipos.
     * @return devuelve una lista de equipos
     * @throws Exception 
     */
    
    public ArrayList<Equipo> BuscarEquipo() throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar un array de tipo objeto equipo
        ArrayList<Equipo> a = new ArrayList();
        PreparedStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareStatement("SELECT * FROM equipo");
        // instanciar rs, ejecutar sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si hay datos
        while (rs.next()){
            // mandar a una función el rs
            Equipo e = recorrer(rs);
            // añadir objeto a la lista
            a.add(e);
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver lista
        return a;
    }
    
           /**
     * Metodo para formatear la fecha de alta.
     * @param fechaE Date
     * @return fecha
     */ 

    private Date formatearFecha(java.util.Date fechaE){
        // instanciar y formatear la fecha para ser reconocido con el formato establecido
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        // devolver fecha formateado
        return Date.valueOf(fecha);
    }
    
}
