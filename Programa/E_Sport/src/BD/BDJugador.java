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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase en la que controlaremos e introduciremos los jugadores a la base de datos.
 * Fecha de creación de la clase: 02/05/2018
 * @author eqdaw04
 */

public class BDJugador {
    
    public BDJugador() {
    } 
    
    /**
     * Metodo para insertar un jugador.
     * @param j Jugador
     * @throws Exception salta excepcion
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
        
        // Si no inserta fila, lanza excepción
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para eliminar un jugador.
     * @param j Jugador
     * @throws Exception salta excepcion
     */
    
    public void eliminarJugador(Jugador j) throws Exception {
        BDConexion con = new BDConexion();
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("DELETE FROM Jugador WHERE Id_jugador = ?");
        
        sentencia.setInt(1, j.getIdJugador());                
        
        // Si no elimina fila, lanza excepción
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        
        sentencia.close();
        con.desconectar();
    }
    
     /**
     * Metodo para modificar los datos de un jugador.
     * @param j Jugador
     * @throws Exception salta excepcion
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
        
        // Si no modifica fila, lanza excepción
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para buscar un jugador por DNI.
     * @param dni String
     * @return Devuelve un jugador
     * @throws Exception salta excepcion
     */
    
    public Jugador BuscarJugador(String dni) throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Jugador> a = new ArrayList();
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni = ?");
        
        sentencia.setString(1,dni);
        
        // Ejecuta la consulta e inserta filas en un ArrayList de jugadores
        ResultSet rs;
        rs = sentencia.executeQuery();
        a = recorrer(rs, a);
        
        rs.close();
        sentencia.close();
        con.desconectar();
        
        // Si está vacío, devuelve valor nulo, Sino devuelve el primero del ArrayList
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
     * @return Devuelve un ArrayList de jugadores
     * @throws Exception salta excepcion
     */    
    
    public ArrayList<Jugador> BuscarJugador() throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Jugador> a = new ArrayList();
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador ORDER BY Id_jugador");
        
        // Ejecuta la consulta e inserta las filas en un ArrayList de jugadores
        ResultSet rs;
        rs = sentencia.executeQuery();
        a = recorrer(rs, a);
        
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return a;
    }
    
    /**
     * Metodo para buscar todos los jugadores de un equipo. 
     * @param id String
     * @return Devuelve un ArrayList de jugadores
     * @throws Exception salta excepcion
     */
    
    public ArrayList<Jugador> BuscarEqui(String id) throws Exception {
       BDConexion con = new BDConexion();
       
       ArrayList<Jugador> a= new ArrayList();
       
       PreparedStatement sentencia;
       sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo = ? ORDER BY Id_jugador");
       
       sentencia.setString(1,id);
       
       // Ejecuta la consulta e inserta las filas en un ArrayList de jugadores
       ResultSet rs;
       rs = sentencia.executeQuery();
       a = recorrer(rs, a);
       
       rs.close();
       sentencia.close();
       con.desconectar();
       
       return a;
    }
    
    /**
     * Metodo para recorrer el resultado de una consulta para devolver un ArrayList de jugadores
     * @param rs ResultSet
     * @param a ArrayList de jugadores
     * @return devuelve un ArrayList de jugadores
     * @throws Exception salta excepcion
     */
    
    public ArrayList<Jugador> recorrer(ResultSet rs, ArrayList <Jugador> a) throws Exception {
        while (rs.next())
        {
            Jugador j= new Jugador();
            j.setIdJugador(Integer.parseInt(rs.getString("id_jugador")));
            j.setDni(rs.getString("dni"));
            j.setNombre(rs.getString("nombre"));
            j.setApellido1(rs.getString("apellido1"));
            j.setApellido2(rs.getString("apellido2"));
            j.setNickname(rs.getString("nickname"));
            j.setSueldo(Float.parseFloat(rs.getString("sueldo")));
            // Formato de la fecha
            long as = rs.getTimestamp("fecha_alta").getTime();
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(as);
            j.setFechaAlta(c.getTime());
            j.setComentario(rs.getString("comentario"));
            
            a.add(j);
        }
        
        return a;
    }
    
    /**
     * Metodo para buscar jugadores que no estén en ningún equipo.
     * @return Devuelve un ArrayList de jugadores
     * @throws Exception salta excepcion
     */

    public ArrayList<Jugador> BuscarJugadoresDisponibles() throws Exception {
       BDConexion con = new BDConexion();
       ArrayList<Jugador> a= new ArrayList();
        
       PreparedStatement sentencia;
       sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo is null ORDER BY Id_jugador");
       sentencia.executeUpdate();
        
       // Ejecuta la consulta e inserta las filas en un ArrayList de jugadores
       ResultSet rs;
       rs = sentencia.executeQuery();
       a = recorrer(rs, a);
       
       rs.close();
       sentencia.close();
       con.desconectar();
       
       return a;
    }
    
    /**
     * Metodo para buscar un jugador por su nickname.
     * @param nickname String
     * @return devuelve una lista de jugadores
     * @throws Exception salta excepcion
     */
    
    public Jugador buscarJugadorNickname(String nickname) throws Exception {
        BDConexion con = new BDConexion(); 
        ArrayList<Jugador> a = new ArrayList();
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Nickname = ?");
        sentencia.setString(1,nickname);
        
        // Ejecuta la consulta e inserta las filas en un ArrayList de jugadores
        ResultSet rs;
        rs = sentencia.executeQuery();
        a = recorrer(rs, a);
        
        rs.close();
        sentencia.close();
        con.desconectar();
        
        // Si está vacío, devuelve valor nulo, Sino devuelve el primero del ArrayList
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
     * Metodo para dar da alta un jugador de un equipo.
     * @param nickname String
     * @param id String
     * @return Devuelve valor booleano si la sentencia se ejecuta correctamente
     * @throws Exception salta excepcion
     */  

    public boolean PonerJugadorEquipo(String nickname, String id) throws Exception {
        BDConexion con = new BDConexion();
        boolean correcto;
        correcto = false;
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET Id_equipo = ? WHERE UPPER(Nickname) = UPPER(?)");
        
        sentencia.setString(1, id);
        sentencia.setString(2, nickname);
        
        // Si no se ejecuta, se trata después con la excepción correpondiente
        if(sentencia.executeUpdate()==1)
        {
            correcto=true;
        }
        
        sentencia.close();
        con.desconectar();
        
        return correcto;
    }
    
    /**
     * Metodo para dar da baja un jugador de un equipo.
     * @param nickname String
     * @return Devuelve valor booleano si la sentencia se ejecuta correctamente
     * @throws java.lang.Exception
     */

    public boolean QuitarJugadorEquipo(String nickname) throws Exception {
        BDConexion con = new BDConexion();
        boolean correcto;
        correcto = false;
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE Jugador SET Id_equipo = null WHERE UPPER(Nickname) = UPPER(?)");
        
        sentencia.setString(1, nickname);
        
        // Si no se ejecuta, se trata después con la excepción correpondiente
        if(sentencia.executeUpdate()==1)
        {
            correcto=true;
        }
        
        sentencia.close();
        con.desconectar();
        
        return correcto;
    }
    
    /**
     * Metodo para dar formato a fechas para trabajar con la Base de Datos.
     * @param fechaE Date
     * @return fecha
     */

    private Date formatearFecha(java.util.Date fechaE){
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        return Date.valueOf(fecha);
    }
    
}
