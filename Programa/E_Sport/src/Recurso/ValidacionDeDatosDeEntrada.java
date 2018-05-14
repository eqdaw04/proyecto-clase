/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurso;

import Excepciones.Excepcion;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * Clase para validar todos los datos de entrada.
 * Fecha de creación de la clase: 25/04/2018
 * @author eqdaw04
 */
public class ValidacionDeDatosDeEntrada{

    public ValidacionDeDatosDeEntrada() {
    }
    
    public static void validar(int cod, JTextField campo) throws Exception{
        
        Pattern p=Pattern.compile(datoPatron(cod));
        Matcher m=p.matcher(campo.getText());
        if(!m.matches())
        {
            campo.setBackground(Color.red);
            campo.grabFocus();
            throw new Excepcion(cod);
        }
        else{
            campo.setBackground(Color.white);
        }
    }
    
    /**
     * Metodo que guarda los patterns que utilizaremos en el programa.
     * @param cod int
     * @return devuelve el patrón a utilizar.
     */
    
    private static String datoPatron(int cod){
        String dato = "";
        switch(cod){

            case 3: // NIF
                dato = "^[A-Z0-9][0-9]{7}[A-Z]$";
                break;
                
            case 4: // Nombre
                dato = "^[A-Z][a-zñ]{2,}$";
                break;
                
            case 5: // Apellidos
                dato = "^[A-Z][a-zñ]{2,}$";
                break;
                
            case 6: // e-mail
                dato = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,})$";
                break;
                
            case 7: // Usuario
                dato = "^[A-Za-z]{3,}$";
                break;
                
            case 8: // Contraseña
                dato = "^[A-Za-z0-9]{3,}$";
                break;
        }
        return dato;
    }
}
