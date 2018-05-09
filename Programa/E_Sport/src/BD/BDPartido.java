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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;
import UML.Equipo;
import UML.Partido;
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
        lEquipo = new ArrayList();
    }
    
    public boolean insertarPartido(Date fecha, String hora, String lugar, int idJornada, BDConexion con) throws Exception{
        boolean estado = false;        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO partido (fecha, lugar, ID_JORNADA, hora) values( to_timestamp('10/05/18 12:26:52,000000000','DD/MM/RR HH24:MI:SSXFF'), ?, ?);");
        
        sentencia.setTimestamp(1, convertirTimeStamp(fecha, hora));
        sentencia.setString(2, lugar);
        sentencia.setInt(3, idJornada);
        int n = sentencia.executeUpdate();
        if(n==1){
            estado = true;
        }
        sentencia.close();
        return estado;
    }
    
    private Timestamp convertirTimeStamp(Date fecha, String hora) throws Exception{
        SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat ffh = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechas = ff.format(fecha) + " " + hora;
        Date dato = ffh.parse(fechas);
        Timestamp datoFinal = new Timestamp(dato.getTime());        
        return datoFinal;
    }
    
    
    
    
    public ArrayList<Partido> consultarPartidosPorJornada(int n) throws Exception{
        ArrayList<Partido> lPartido = new ArrayList();
        // abre la conexion
        BDConexion con = new BDConexion();
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
        while(rs.next()){
            Partido p = new Partido();
            p.setIdPartido(rs.getInt("idPartido"));
                        
            //p.setFecha(fecha); REVISARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            //p.setHora(); REVISARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            p.setLugar(rs.getString("lugar"));
            p.seteLocal(Main.ConsultarEquipoPorPartido(p.getIdPartido(), true));
            p.setmLocal(Main.ConsultarPuntoPorPartido(p.getIdPartido(), true));
            p.seteVisitante(Main.ConsultarEquipoPorPartido(p.getIdPartido(), false));
            p.setmVisitante(Main.ConsultarPuntoPorPartido(p.getIdPartido(), false));
            lPartido.add(p);
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return lPartido;
        
    }
    
    public ArrayList<Partido> insertarPartido() throws Exception{
        ArrayList<Partido> lPartido = new ArrayList();
        // abre la conexion
        BDConexion con = new BDConexion();
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
        while(rs.next()){
            Partido p = new Partido();
            p.setIdPartido(rs.getInt("idPartido"));
                        
            //p.setFecha(fecha); REVISARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            //p.setHora(); REVISARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
            p.setLugar(rs.getString("lugar"));
            p.seteLocal(Main.ConsultarEquipoPorPartido(p.getIdPartido(), true));
            p.setmLocal(Main.ConsultarPuntoPorPartido(p.getIdPartido(), true));
            p.seteVisitante(Main.ConsultarEquipoPorPartido(p.getIdPartido(), false));
            p.setmVisitante(Main.ConsultarPuntoPorPartido(p.getIdPartido(), false));
            lPartido.add(p);
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return lPartido;
        
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

}
