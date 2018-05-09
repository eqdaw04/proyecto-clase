/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.BDJugador.recorrer;
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
 *
 * @author 1gdaw06
 */
public class BDEquipo {
    
    public static void insertarEquipo(Equipo e) throws Exception {
        BDConexion con = new BDConexion();
        PreparedStatement sentencia = con.getConnection().prepareStatement("INSERT INTO Equipo (NOMBRE, FECHA_CREACION, COMENTARIO) VALUES (?, ?, ?)");
        sentencia.setString(2, e.getNombre());
        sentencia.setDate(7, formatearFecha(e.getFechaCreacion()));
        sentencia.setString(8, e.getComentario());
                                
        if(sentencia.executeUpdate()!=1)
        {
            throw new Excepcion(25);
        }
        sentencia.close();
        con.desconectar();
    }
    
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
    
    public static Equipo BuscarEquipoPorUsuario(String usu) throws Exception {
        BDConexion con = new BDConexion();
        Equipo e = new Equipo();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Id_persona = (SELECT Id_persona FROM Persona WHERE Usuario = ?)");
        sentencia.setString(1,usu);
        sentencia.executeUpdate();
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()){
            e.setIdEquipo(Integer.parseInt(rs.getString(1)));
            e.setNombre(rs.getString(2));
            e.setFechaCreacion(rs.getDate(3));
            e.setComentario(rs.getString(4));
        }
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return e;
    }
    
    public static Equipo BuscarEquipo(String nombre) throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Equipo> a = new ArrayList();
        try
        {
            PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE NOMBRE = ?");
            sentencia.setString(1, nombre);
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
    
    public static ArrayList<Equipo> BuscarEquipo() throws Exception {
        BDConexion con = new BDConexion();
        ArrayList<Equipo> a = new ArrayList();
        try
        {
            PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo");
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
    
    public static ArrayList<Equipo> recorrer(ResultSet rs, ArrayList <Equipo> a) throws SQLException {
        while (rs.next()){
            Equipo e= new Equipo();
            e.setIdEquipo(Integer.parseInt(rs.getString(1)));
            e.setNombre(rs.getString(2));
            e.setFechaCreacion(rs.getDate(3));
            e.setComentario(rs.getString(4));      
            a.add(e);
        }
        return a;
    }

    private static Date formatearFecha(java.util.Date fechaE){
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        return Date.valueOf(fecha);
    }
    
}
