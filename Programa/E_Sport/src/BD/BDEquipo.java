/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.BDJugador.recorrer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1gdaw06
 */
public class BDEquipo {

    public static String BuscarNomEqui(String usu, BDConexion con) {
        ResultSet rs = null;
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT Nombre FROM Equipo WHERE Id_persona = (SELECT Id_persona FROM Persona WHERE Usuario = ?)");
        sentencia.setString(1,usu);
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
        
        } catch (SQLException ex) {
            Logger.getLogger(BDJugador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rs.toString();
    }
}
