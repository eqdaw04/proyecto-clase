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
 *
 * @author 1gdaw06
 */
public class BDJornada {
    
    public boolean insertarJornada(int nJornada, BDConexion con) throws Exception{
        boolean estado = false;        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO jornada VALUES(?)");
        sentencia.setInt(1, nJornada);
        int n = sentencia.executeUpdate();
        if(n==1){
            estado = true;
        }
        sentencia.close();
        return estado;
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
            j.setnJornada(rs.getInt("njornada"));
            j.setListaPartidos(Main.consultarPartidosPorJornada(j.getnJornada()));
            lJornada.add(j);
        }
        
        rs.close();
        sentencia.close();
        con.desconectar();
        return lJornada;
    }
    
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
            j.setnJornada(rs.getInt("njornada"));
            j.setListaPartidos(Main.consultarPartidosPorJornada(j.getnJornada()));
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return j;
        
    }
    
}
