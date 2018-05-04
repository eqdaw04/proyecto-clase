/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import UML.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1gdaw06
 */
public class BDPerfil {
    
    public Perfil buscarPorCodigo(int cod) throws Exception{
        // crear perfil vacio
        Perfil p = null;
        // preparar conexion y sentencia sql
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        
        sentencia = con.getConnection().prepareStatement("SELECT * FROM perfil WHERE id_perfil = ?");
        
        sentencia.setInt(1, cod);
        // crear rs para cargar los resultados
        ResultSet rs;
        rs = sentencia.executeQuery();
       // buscar si existe datos en rs
        if(rs.next()){
            // crear objeto con base y cargar datos.
            p = new Perfil();
            p.setIdPerfil(rs.getInt(1));
            p.setNombre(rs.getString(2));
        }
        
        //cerrar conexion y devolver objeto
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return p;
    }
    
    public ArrayList <Perfil> buscarPerfiles() throws Exception{
        // preparar lista para guardar los objetos de perfil
        ArrayList <Perfil> listaPerfil = new ArrayList();
        // preparar conexion y sentencia sql
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        
        sentencia = con.getConnection().prepareStatement("SELECT * FROM perfil");
        // crear rs para cargar los resultados
        ResultSet rs;
        rs = sentencia.executeQuery();
       // buscar si existe datos en rs
        while(rs.next()){
            // crear objeto con base, cargar datos y añadir a la lista
            Perfil p = new Perfil();
            p.setIdPerfil(rs.getInt(1));
            p.setNombre(rs.getString(2));
            listaPerfil.add(p);
        }
        
        //cerrar conexion y devolver lista
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return listaPerfil;
    }
    
    public Perfil buscarPorNombre(String nombre) throws Exception{
        // crear perfil vacio
        Perfil p = null;
        // preparar conexion y sentencia sql
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        
        sentencia = con.getConnection().prepareStatement("SELECT * FROM perfil WHERE nombre = ?");
        
        sentencia.setString(1, nombre);
        // crear rs para cargar los resultados
        ResultSet rs;
        rs = sentencia.executeQuery();
       // buscar si existe datos en rs
        if(rs.next()){
            // crear objeto con base y cargar datos.
            p = new Perfil();
            p.setIdPerfil(rs.getInt(1));
            p.setNombre(rs.getString(2));
        }
        
        //cerrar conexion y devolver objeto
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return p;
    }
}
