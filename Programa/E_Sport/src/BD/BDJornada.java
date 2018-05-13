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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * Clase en la que controlaremos e introduciremos datos de la jornada actual a la base de datos.
 * Fecha de creación de la clase: 24/04/2018
 * @author eqdaw04
 */
public class BDJornada {
    
    public Jornada insertarJornada(int nJornada, Calendar fecha, BDConexion con) throws Exception{
        Jornada j = null;        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO jornada VALUES(?, TO_DATE(?,'DD/MM/YYYY'), null)");
        sentencia.setInt(1, nJornada);
        sentencia.setDate(2, convertirFechaASql(fecha.getTime()));
        int n = sentencia.executeUpdate();
        if(n==1){
            j = new Jornada();
            j.setIdJornada(nJornada);
            j.setFechaInicio(fecha.getTime());
        }
        sentencia.close();
        return j;
    }
    
    private Date convertirFechaASql(java.util.Date fecha) throws Exception{
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String ff = f.format(fecha);
        java.util.Date parsed = f.parse(ff);
        Date fSQL = new Date(parsed.getTime());
        return fSQL;
    }
    
    public void modificarJornada(Jornada jornada, BDConexion con) throws Exception{
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE jornada SET fecha_fin = TO_DATE(?,'DD/MM/YYYY') WHERE id_jornada = ?");
        sentencia.setDate(1, convertirFechaASql(jornada.getFechaFinal()));
        sentencia.setInt(2, jornada.getIdJornada());
        int n = sentencia.executeUpdate();
        if(n!=1){
            throw new Excepcion(43);
        }
        sentencia.close();
    }
    
    public ArrayList <Jornada> consultarTodasLasJornadas() throws Exception{
        ArrayList <Jornada> lJornada = new ArrayList();
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM jornada");
        ResultSet rs;
        rs = sentencia.executeQuery();
        while(rs.next()){
            Jornada j = new Jornada();
            j.setIdJornada(rs.getInt("id_jornada"));
            j.setFechaInicio(rs.getDate("fecha_inicio"));
            j.setFechaFinal(rs.getDate("fecha_fin"));
            // Se ha cargará los datos a la memoria según demanda, para así no cargar en excesiva con datos que no se va ha utilizar y precisa que esté 
            // actualizado en todo momento con la bbdd
            //j.setListaPartidos(Main.consultarPartidosPorJornada(j.getIdJornada()));
            lJornada.add(j);
        }
        
        rs.close();
        sentencia.close();
        con.desconectar();
        return lJornada;
    }
    
    /**
     * Metodo para consultar una jornada por su número.
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
        sentencia = con.getConnection().prepareStatement("SELECT * FROM jornada WHERE njornada = ?");
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
