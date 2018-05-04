/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import Excepciones.Excepcion;
import UML.Persona;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author 1gdaw06
 */
public class BDPersona {

    public BDPersona() {
    }
    
    public Persona buscarPersonaPorUsuario(String usuario) throws Exception{
        // abre la conexion
        BDConexion con = new BDConexion();
        // Crear objeto persona nulo
        Persona p = null;
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM persona WHERE usuario = ?");
        // dato de la condicion
        sentencia.setString(1, usuario);
        // crear objeto para el resultado de la consulta
        ResultSet rs;
        // cargar objeto sentencia al objeto rs
        rs = sentencia.executeQuery();
       // buscar si existe datos en la rs
        if(rs.next()){
            // crear la persona con base Persona y llenar los datos
            p = new Persona();
            p.setIdPersona(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setApellido1(rs.getString(3));
            p.setApellido2(rs.getString(4));
            p.setFechaAlta(rs.getDate(5));
            p.setUsuario(rs.getString(6));
            p.setContrasenna(rs.getString(7));
            p.setEmail(rs.getString(8));
            p.setPerfil(Main.consultarPerfil(rs.getInt(9)));
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return p;
    }
    
    public ArrayList<Persona> buscarTodasLasPersona() throws Exception{
        // crear array de personas
        ArrayList <Persona> lPersona = new ArrayList();
        // abre la conexion
        BDConexion con = new BDConexion();
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM persona");
        // crear objeto para el resultado de la consulta
        ResultSet rs;
        // cargar objeto sentencia al objeto rs
        rs = sentencia.executeQuery();
       // buscar si existe datos en la rs
        while(rs.next()){
            // crear la persona con base Persona y llenar los datos
            Persona p = new Persona();
            p.setIdPersona(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setApellido1(rs.getString(3));
            p.setApellido2(rs.getString(4));
            p.setFechaAlta(rs.getDate(5));
            p.setUsuario(rs.getString(6));
            p.setContrasenna(rs.getString(7));
            p.setEmail(rs.getString(8));
            p.setPerfil(Main.consultarPerfil(rs.getInt(9)));
            lPersona.add(p);
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return lPersona;
    }
    
    public void altaPersona(Persona p) throws Exception{
        // abre la conexion
        BDConexion con = new BDConexion();
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO Persona (Nombre, Apellido1, Apellido2, Fecha_alta, Usuario, Contrasenna, Email, Id_perfil) VALUES (?,?,?,?,?,?,?,?)");
        // datos a insertar
        sentencia.setString(1, p.getNombre());        
        sentencia.setString(2, p.getApellido1());
        sentencia.setString(3, p.getApellido2());
        sentencia.setDate(4, formatearFecha(p.getFechaAlta()));
        sentencia.setString(5, p.getUsuario());
        sentencia.setString(6, p.getContrasenna());
        sentencia.setString(7, p.getEmail());
        sentencia.setInt(8, p.getPerfil().getIdPerfil());
        // ejecutar la sentencia
        if(sentencia.executeUpdate() != 1){
            throw new Excepcion(25);
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        sentencia.close();
        con.desconectar();
    }
    
    public void bajaPersona(Persona p) throws Exception{
        // abre la conexion
        BDConexion con = new BDConexion();
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("DELETE FROM persona WHERE usuario = ?");
        // datos a insertar
        sentencia.setString(1, p.getUsuario());
        // ejecutar la sentencia
        if(sentencia.executeUpdate() != 1){
            throw new Excepcion(25);
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        sentencia.close();
        con.desconectar();
    }
    
    public void modificarPersona(Persona p) throws Exception{
        // abre la conexion
        BDConexion con = new BDConexion();
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE Persona SET Nombre = ?, Apellido1 = ?, Apellido2 = ?, Contrasenna = ?, Email = ?, Id_perfil = ? WHERE usuario = ?");
        // datos a insertar
        sentencia.setString(1, p.getNombre());        
        sentencia.setString(2, p.getApellido1());
        sentencia.setString(3, p.getApellido2());
        sentencia.setString(4, p.getContrasenna());
        sentencia.setString(5, p.getEmail());
        sentencia.setInt(6, p.getPerfil().getIdPerfil());
        sentencia.setString(7, p.getUsuario());
        // ejecutar la sentencia
        if(sentencia.executeUpdate() != 1){
            throw new Excepcion(25);
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        sentencia.close();
        con.desconectar();
    }

    private Date formatearFecha(java.util.Date fechaE){
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        return Date.valueOf(fecha);
    }
}
