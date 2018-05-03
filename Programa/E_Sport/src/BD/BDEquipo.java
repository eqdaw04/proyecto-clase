/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.BDJugador.recorrer;
import UML.Equipo;
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
    private static Equipo e = new Equipo();
    
    public static Equipo BuscarNomEqui(String usu) throws Exception {
        ResultSet rs = null;
        BDConexion con = new BDConexion();
        try {
        PreparedStatement sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Id_persona = (SELECT Id_persona FROM Persona WHERE Usuario = ?)");
        sentencia.setString(1,usu);
        sentencia.executeUpdate();
        rs = sentencia.executeQuery();
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
    
}
