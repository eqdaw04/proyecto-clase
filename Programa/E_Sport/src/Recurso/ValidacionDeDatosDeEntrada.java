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
 *
 * @author v6222
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
    
    private static String datoPatron(int cod){
        String dato = "";
        switch(cod){

            case 3:
                dato = "^[A-Z0-9][0-9]{7}[A-Z]$";
                break;
                
            case 4:
                dato = "^[A-Z][a-z]{2,}$";
                break;
                
            case 5:
                dato = "^[A-Z][a-z]{2,}$";
                break;
                
            case 6:
                dato = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,}$";
                break;
                
            case 7:
                dato = "^[A-Za-z]{3,}$";
                break;
                
            case 8:
                dato = "^[A-Za-z0-9]{3,}$";
                break;
        }
        return dato;
    }
}
