/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Excepciones.Excepcion;
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
     * @throws Exception salta excepcion
     */

    public BDConexion() throws Exception{
       try{
           // cargar el driver
            Class.forName("oracle.jdbc.OracleDriver");
            // establecer la conexión
            // cambiar cuando finaliza el proyecto main.geturl por
            // "jdbc:oracle:thin:@SrvOracle:1521:orcl"
            
            connection = DriverManager.getConnection(Main.getUrl(), "eqdaw04", "eqdaw04");
            // comprueba si está conectado, en caso contrario, mostrar error
            if(connection == null){
                //System.out.println("conexion establecida");
                throw new Excepcion(48);
            }
        }
       
        catch(Excepcion e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "El driver de la base de datos no esta disponible!" +e.getMessage());
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "problemas " +e.getMessage());
        }
    }
    
    /**
     * Metodo en el que realizamos la conexión.
     * @return objeto conexion
     */
    
    // enviar conexión establecida
    public Connection getConnection(){
        return connection;
    }
    
        /**
     * Metodo para desconectarnos de la base de datos.
     * @throws Exception salta excepcion
     */
 
    // cerrar conexión establecida
    public void desconectar() throws Exception{
        connection.close();
    }
}

