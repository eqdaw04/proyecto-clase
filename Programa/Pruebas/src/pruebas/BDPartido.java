/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;


import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author 1gdaw06
 */
public class BDPartido {
    int idPartido;
    Date fecha;
    Timer horaInicio;
    String lugar;

    public BDPartido() {
    }
    
    public void insertarPartido(Calendar fechas) throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO partido (id_partido, fecha, ID_JORNADA) values(?, to_timestamp(?,?), ?)");
        sentencia.setInt(1, 1);
        java.sql.Timestamp fecha = new java.sql.Timestamp(fechas.getTimeInMillis());
        JOptionPane.showMessageDialog(null, fecha);
        sentencia.setString(2, "2018-12-12 12:12:00.00");
        sentencia.setString(3, "YYYY-MM-DD HH24:MI:SS.FF");
        sentencia.setInt(4, 1);
        sentencia.executeUpdate();
        
        sentencia.close();
    }
    
}
