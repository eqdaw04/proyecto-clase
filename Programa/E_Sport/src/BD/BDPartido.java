/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import UML.Equipo;
import UML.Jornada;
import UML.Marcador;
import UML.Partido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    ArrayList <Equipo> lEquipo;
    Jornada jornada;

    public BDPartido() {
        iEquipo = new ArrayList();
    }
    
    public ArrayList<Equipo> consultarPartidosPorJornada(int n) throws Exception{
        // abre la conexion
        BDConexion con = new BDConexion();
        // Crear objeto persona nulo
        Equipo  = null;
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM partido WHERE id_jornada = ?");
        // formatear fecha a fecha para sql como condicion
        sentencia.setInt(1, n);
        // crear objeto para el resultado de la consulta
        ResultSet rs;
        // cargar objeto sentencia al objeto rs
        rs = sentencia.executeQuery();
       // buscar si existe datos en la rs
        if(rs.next()){
            // crear la persona con base Persona y llenar los datos
            e = new Equipo();
            p.setIdPartido(rs.getInt("idPartido"));
            //p.setFecha(fecha); REVISARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            //p.setHora(); REVISARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            p.setLugar(rs.getString("lugar"));
            p.setListaMarcadores(Main.consultarMarcadorPorPartido(p.getIdPartido()));
            lEquipo.add(p);
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return p;
        
    }
    
    public ArrayList <Marcador> marcadores(BDConexion con, int n) throws Exception{
        // Crear objeto persona nulo
        Marcador m = null;
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM marcador WHERE partido = ?");
        // condicion de la sentencia
        sentencia.setInt(1, n);
        // crear objeto para el resultado de la consulta
        ResultSet rs;
        // cargar objeto sentencia al objeto rs
        rs = sentencia.executeQuery();
       // buscar si existe datos en la rs
        if(rs.next()){
            // crear marcador y llenar los datos
            m = new Marcador();
            m.setIdMarcador(rs.getInt("id_marcador"));
            m.setPartido(partido);
            m.setEquipo(equipo);
            m.setPuntos(n);
            m.setVisitante(true);
            
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();

    }
    
    private String convertirFecha(Date fecha){
        String dato = "";
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        dato = f.format(fecha);
        
        return dato;
    }
}
