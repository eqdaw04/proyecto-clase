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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 1gdaw06
 */
public class BDJugador {
    
    public static ArrayList<Jugador> BuscarDni(String dni) throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Jugador> a= new ArrayList();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni = ?");
        sentencia.setString(1,dni);
        sentencia.executeUpdate();
        ResultSet rs = sentencia.executeQuery();
        a= recorrer (rs,a);
        con.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a ;
    }
    
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

    private static Date formatearFecha(java.util.Date fechaE){
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        return Date.valueOf(fecha);
    }
    
}
