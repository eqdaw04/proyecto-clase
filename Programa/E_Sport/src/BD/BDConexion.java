/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author 1gdaw06
 */



public class BDConexion {
    
    Connection connection;
    
    String driver = Main.getDriver(),
            url = Main.getUrl(),
            user = Main.getUsuario(),
            pass = Main.getContrasenna();
            
    
    public void AbrirBD () throws Exception{
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "El driver de la base de datos no esta disponible!" +e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "problemas" +e.getMessage());
        }
        System.out.println("conexion establecida");
    }
    
    public Connection getConnection(){
      return connection;
    }
 
    public void desconectar() throws Exception{
        connection.close();
    }
}
