/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import Excepciones.Excepcion;
import UML.Jornada;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase en la que controlaremos e introduciremos datos de la jornada actual a la base de datos.
 * Fecha de creación de la clase: 24/04/2018
 * @author eqdaw04
 */
public class BDJornada {
    
    public Jornada insertarJornada(int nJornada, Calendar fecha, BDConexion con) throws Exception{
        // instanciar objetoo en null
        Jornada j = null;        
        // preparar sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO jornada VALUES(?, TO_DATE(?,'DD/MM/RRRR'), null)");
        // cargar datos al ?
        sentencia.setInt(1, nJornada);
        sentencia.setDate(2, convertirFechaASql(fecha.getTime()));
        // ejecutar la sentencia y comprobar si se ha insertado
        if(sentencia.executeUpdate()==1){
            // instanciar objeto jornada
            j = new Jornada();
            // cargar los datos al objeto
            j.setIdJornada(nJornada);
            j.setFechaInicio(fecha.getTime());
        }
        // cerrar la sentencia
        sentencia.close();
        // devolver el objeto
        return j;
    }
    
    /**
     * Metodo para convertir la fecha.
     * @param fecha Java util date
     * @return devuelve la fecha en el tipo de dato date
     * @throws Exception 
     */
    
    private Date convertirFechaASql(java.util.Date fecha) throws Exception{
        // formatear la fecha con el formato establecido
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String ff = f.format(fecha);
        // parsearlo a formato fecha
        java.util.Date parsed = f.parse(ff);
        Date fSQL = new Date(parsed.getTime());
        return fSQL;
    }
    
    /**
     * Metodo para modificar la jornada
     * @param jornada Jornada
     * @param con BDConexion
     * @throws Exception 
     */
    
    public void modificarJornada(Jornada jornada, BDConexion con) throws Exception{
        // preparar sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE jornada SET fecha_fin = TO_DATE(?,'DD/MM/RRRR') WHERE id_jornada = ?");
        // cargar los datos al ?
        sentencia.setDate(1, convertirFechaASql(jornada.getFechaFinal()));
        sentencia.setInt(2, jornada.getIdJornada());
        // comprobar si se ha modificado el dato, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1){
            throw new Excepcion(43);
        }
        sentencia.close();
    }
    
    /**
     * Metodo para consultar una lista de todas las jornadas 
     * @return devuelve la lista de jornadas
     * @throws Exception 
     */
    
    public ArrayList <Jornada> consultarTodasLasJornadas() throws Exception{
        // instanciar una lista
        ArrayList <Jornada> lJornada = new ArrayList();
        // abrir la conexion
        BDConexion con = new BDConexion();
        // preparar la sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT id_jornada, fecha_inicio, fecha_fin FROM jornada");
        // instanciar rs, ejecutar la sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si existe datos en el rs
        while(rs.next()){
            // instanciar objeto jornada y cargar los datos del rs al objeto
            Jornada j = new Jornada();
            j.setIdJornada(rs.getInt("id_jornada"));
            j.setFechaInicio(rs.getDate("fecha_inicio"));
            j.setFechaFinal(rs.getDate("fecha_fin"));
            // añadir el objeto a la lista
            lJornada.add(j);
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver lista
        return lJornada;
    }
    
    /**
     * Metodo para consultar una jornada por su número.
     * @param j Id Jornada
     * @param n int
     * @return devuelve un objeto jornada
     * @throws Exception 
     */
    
    
    public Jornada consultarJornadaPorNumeroDeJornada(int n) throws Exception{
        // abre la conexion
        BDConexion con = new BDConexion();
        // Crear objeto persona nulo
        Jornada j = null;
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT id_jornada FROM jornada WHERE id_jornada = ?");
        // formatear fecha a fecha para sql como condicion
        sentencia.setInt(1, n);
        // crear objeto para el resultado de la consulta
        ResultSet rs;
        // cargar objeto sentencia al objeto rs
        rs = sentencia.executeQuery();
       // buscar si existe datos en la rs
        if(rs.next()){
            // crear la persona con base Persona y llenar los datos
            j = new Jornada();
            j.setIdJornada(rs.getInt("id_jornada"));
            j.setListaPartidos(Main.consultarPartidosPorJornada(j.getIdJornada()));
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return j;
        
    }
    
}
