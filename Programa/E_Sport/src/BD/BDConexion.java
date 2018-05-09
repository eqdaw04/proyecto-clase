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
 * Clase para crear la conexión a la base de datos.
 * Fecha de la creación de la clase: 02/05/2018
 * @author eqdaw04
 */


public class BDConexion {
    
    Connection connection;
    
    /**
     * Metodo en el que controlamos si la conexión se ha establecido correctamente o no.
     * @throws Exception 
     */

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
    
    /**
     * Metodo en el que realizamos la conexión.
     * @return objeto conexion
     */
    
    public Connection getConnection(){
        return connection;
    }
    
        /**
     * Metodo para desconectarnos de la base de datos.
     * @throws Exception 
     */
 
    public void desconectar() throws Exception{
        connection.close();
    }
}

