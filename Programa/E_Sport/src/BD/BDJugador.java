/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1gdaw06
 */
public class BDJugador {
    
    public static ArrayList <Jugador> BuscarDni (String dni) throws Exception{
        ResultSet rs = null;
        BDConexion con = new BDConexion();
        ArrayList<Jugador> a= new ArrayList();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni = ?");
        sentencia.setString(1,dni);
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
        a= recorrer (rs,a);
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return a ;
    }
    
    public static ArrayList<Jugador> BuscarEqui(String id) throws Exception {
       ResultSet rs = null;
       BDConexion con = new BDConexion();
       ArrayList<Jugador> a= new ArrayList();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo = ?");
        sentencia.setString(1,id);
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
        a= recorrer (rs,a);
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return a;
    }
    
    public static ArrayList recorrer (ResultSet rs, ArrayList <Jugador> a) throws SQLException{
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
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return a ;
    }
    public static boolean insertarJugador(Jugador j) throws Exception {
        try
        {
            ResultSet rs = null;
            BDConexion con = new BDConexion();
            PreparedStatement sentencia = con.getConnection().prepareStatement("SINSERT INTO Jugador (DNI, NOMBRE, APELLIDO1, APELLIDO2, NICKNAME, SUELDO, FECHA_ALTA, COMENTARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            sentencia.setString(1, j.getDni());
            sentencia.setString(2, j.getNombre());
            sentencia.setString(3, j.getApellido1());
            sentencia.setString(4, j.getApellido2());
            sentencia.setString(5, j.getNickname());
            sentencia.setFloat(6, j.getSueldo());
            sentencia.setDate(7, (Date)j.getFechaAlta());
            sentencia.setString(8, j.getComentario());            
            sentencia.executeUpdate();
            rs = sentencia.executeQuery();
            con.desconectar();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
}
