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

/**
 *
 * @author 1gdaw06
 */
public class BDPerfil {
    
    public Perfil buscarPorCodigo(int cod) throws Exception{
        Perfil p = null;
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        
        sentencia = con.getConnection().prepareStatement("SELECT * FROM perfil WHERE id_perfil = ?");
        
        sentencia.setInt(1, cod);
        sentencia.executeUpdate();
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            p = new Perfil();
            p.setIdPerfil(rs.getInt(1));
            p.setNombre(rs.getString(2));
        }
        rs.close();
        sentencia.close();
        
        return p;
    }
    
}
