/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import UML.Perfil;
import UML.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        // ejecucion de la sentencia
        sentencia.executeUpdate();
        // crear objeto para el resultado de la consulta
        ResultSet rs;
        // cargar objeto sentencia al objeto rs
        rs = sentencia.executeQuery();
       // buscar si existe datos en la rd
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
        return p;
    }
}
