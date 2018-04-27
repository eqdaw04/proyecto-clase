/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author 1gdaw06
 */

public class BDConexion {
    public static void AbrirBD (){
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        
        String login = "eqdaw04";
        String password = "eqdaw04";
        String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
        Connection con = DriverManager.getConnection(url, login, password);
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "El driver de la base de datos no esta disponible!" +e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "problemas" +e.getMessage());
        }
        System.out.println("conexion establecida");
    }
}

