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

    public BDConexion() throws Exception{
       try{
            Class.forName(Main.getDriver());
            connection = DriverManager.getConnection(Main.getUrl(), Main.getUsuario(), Main.getContrasenna());
            if(connection != null){
                System.out.println("conexion establecida");
            }
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "El driver de la base de datos no esta disponible!" +e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "problemas " +e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
 
    public void desconectar() throws Exception{
        connection.close();
    }
}

