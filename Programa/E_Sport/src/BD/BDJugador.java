/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1gdaw06
 */
public class BDJugador {
    
    public static ArrayList BuscarDni (String dni, BDConexion con){
        ResultSet rs = null;
        ArrayList<Jugador> a= new ArrayList();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni =?");
        sentencia.setString(1,dni);
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
        while (rs.next()){
            Jugador j= new Jugador();
            j.setDni(rs.getString(1));
            j.setNombre(rs.getString(2));
            j.setApellido1(rs.getString(3));
            j.setApellido2(rs.getString(4));
            j.setNickname(rs.getString(5));
            j.setSueldo(Float.parseFloat(rs.getString(6)));
            j.setFechaAlta(rs.getString(7));
            j.setComentario(rs.getString(8));
            a.add(j);
                    
        }
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return ;
    }
}
