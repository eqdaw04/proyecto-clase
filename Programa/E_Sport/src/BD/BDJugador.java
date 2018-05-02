/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1gdaw06
 */
public class BDJugador {
    
    public static boolean BuscarDni (String dni, BDConexion con){
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Jugador WHERE Dni =?");
        sentencia.setString(1,dni);
        sentencia.executeUpdate();
        ResultSet rs = sentencia.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return true;
    }
}
