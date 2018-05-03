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
    private static ArrayList<Jugador> a= new ArrayList();
    
    public static ArrayList <Jugador> BuscarDni (String dni) throws Exception{
        ResultSet rs = null;
        BDConexion con = new BDConexion();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni = ?");
        sentencia.setString(1,dni);
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
        a= recorrer (rs);
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return a ;
    }
    
    public static ArrayList<Jugador> BuscarEqui(String id) throws Exception {
       ResultSet rs = null;
       BDConexion con = new BDConexion();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Id_equipo = ?");
        sentencia.setString(1,id);
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
        a= recorrer (rs);
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return a;
    }
    
    public static ArrayList recorrer (ResultSet rs) throws SQLException{
        while (rs.next()){
            Jugador j= new Jugador();
            j.setDni(rs.getString(2));
            j.setNombre(rs.getString(3));
            j.setApellido1(rs.getString(4));
            j.setApellido2(rs.getString(5));
            j.setNickname(rs.getString(6));
            j.setSueldo(Float.parseFloat(rs.getString(7)));
            System.out.println(rs.getString(8));
            System.out.println((rs.getDate(8)));
            j.setFechaAlta(rs.getDate(8));
            j.setComentario(rs.getString(9));
            a.add(j);       
        }
        return a;
    }

    
}
