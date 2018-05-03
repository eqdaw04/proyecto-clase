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
        // con abre la conexión y 
        BDConexion con = new BDConexion();
        Persona p = null;
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM persona WHERE usuario = ?");
        
        sentencia.setString(1, usuario);
        sentencia.executeUpdate();
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            p = new Persona();
            p.setIdPersona(rs.getInt(1));
            p.setNombre(rs.getString(2));
            p.setApellido1(rs.getString(3));
            p.setApellido2(rs.getString(4));
            p.setFechaAlta(rs.getDate(5));
            p.setUsuario(rs.getString(6));
            p.setContrasenna(rs.getString(7));
            p.setEmail(rs.getString(8));
            p.setPerfil(Main.buscarPerfil(rs.getInt(9)));
        }
        rs.close();
        sentencia.close();
        return p;
    }
}
