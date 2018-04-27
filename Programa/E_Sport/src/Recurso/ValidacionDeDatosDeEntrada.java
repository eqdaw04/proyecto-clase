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
    
    public static void validar(int error, JTextField campo, String patron) throws Exception{
        Pattern p=Pattern.compile(campo.getText());
        Matcher m=p.matcher(patron);
        if(!m.matches())
        {
            campo.setBackground(Color.red);
            campo.grabFocus();
            throw new Excepcion(error);
        }
        else{
            campo.setBackground(Color.white);
        }
    }
}
