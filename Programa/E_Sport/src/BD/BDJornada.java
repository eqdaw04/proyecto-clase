/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import UML.Jornada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Clase en la que controlaremos e introduciremos datos de la jornada actual a la base de datos.
 * Fecha de creación de la clase: 24/04/2018
 * @author eqdaw04
 */
public class BDJornada {
    
    /**
     * Metodo para insertar una jornada.
     * @param nJornada int
     * @param con BDConexion
     * @return devuelve un objeto jornada
     * @throws Exception 
     */
    
    public Jornada insertarJornada(int nJornada, BDConexion con) throws Exception{
        Jornada j = null;        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO jornada VALUES(?)");
        sentencia.setInt(1, nJornada);
        int n = sentencia.executeUpdate();
        if(n==1){
            j = new Jornada();
            j.setIdJornada(nJornada);
        }
        sentencia.close();
        return j;
    }
    
    /**
     * Metodo para consultar una lista de las jornadas.
     * @return devuelve una lista de jornadas
     * @throws Exception 
     */
    
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
            j.setListaPartidos(Main.consultarPartidosPorJornada(j.getIdJornada()));
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
