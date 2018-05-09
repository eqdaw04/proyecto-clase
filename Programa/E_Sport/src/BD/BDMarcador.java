/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.Equipo;
import UML.Partido;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 1gdaw06
 */
public class BDMarcador {

    public BDMarcador() {
    }
    
    public int insertarEquiposAPartido(Partido partido, BDConexion con) throws SQLException{
        int n = 0;
        PreparedStatement sentencia;
        // insertar equipo local
        sentencia = con.getConnection().prepareStatement("INSERT INTO marcador(puntuacion, visitante, id_partido, id_equipo) VALUES(?,?,?,?)");
        sentencia.setInt(1, 0);
        sentencia.setInt(2, 0);
        sentencia.setInt(3, partido.getIdPartido());
        sentencia.setInt(4, partido.geteLocal().getIdEquipo());
        if(sentencia.executeUpdate()==1){
            // insertar equipo visitante
            sentencia = con.getConnection().prepareStatement("INSERT INTO marcador(puntuacion, visitante, id_partido, id_equipo) VALUES(?,?,?,?)");
            sentencia.setInt(1, 0);
            sentencia.setInt(2, 1);
            sentencia.setInt(3, partido.getIdPartido());
            sentencia.setInt(4, partido.geteVisitante().getIdEquipo());
            n = sentencia.executeUpdate();
        }
        sentencia.close();
        return n;
    }
}
