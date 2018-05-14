/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Clase en la que controlaremos e introduciremos perfiles a la base de datos.
 * Fecha de creación de la clase: 03/05/2018
 * @author eqdaw04
 */

public class BDPerfil {
    
     /**
     * Metodo para buscar un perfil por código.
     * @param cod int
     * @return devuelve un objeto perfil
     * @throws Exception 
     */   
    
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
            p = recorrer(rs);
        }
        
        //cerrar conexion y devolver objeto
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return p;
    }
    
    private Perfil recorrer(ResultSet rs) throws Exception{
        Perfil p = new Perfil();
        p.setIdPerfil(rs.getInt("id_perfil"));
        p.setNombre(rs.getString("nombre"));
        return p;
    }
     /**
     * Metodo para buscar una lista de perfiles.
     * @return devuelve una lista de perfiles.
     * @throws Exception 
     */   
    
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
            Perfil p = recorrer(rs);
            listaPerfil.add(p);
        }
        
        //cerrar conexion y devolver lista
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return listaPerfil;
    }
    
     /**
     * Metodo para buscar un perfil por nombre.
     * @param nombre String
     * @return objeto perfil
     * @throws Exception 
     */
    
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
            p = recorrer(rs);
        }
        
        //cerrar conexion y devolver objeto
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return p;
    }
}
