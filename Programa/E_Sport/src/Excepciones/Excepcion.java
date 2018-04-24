/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author v6222
 */
public class Excepcion extends Exception {
    
    int cod;

    public Excepcion() {
    }

    public Excepcion(int cod) {
        this.cod = cod;
    }
    
    public String getMensaje(){
        String dato = "";
        switch(cod){
            case 1:
                dato = "El usuario no puede estar vacío.";
                break;
                
            case 2:
                dato = "La contraseña no puede estar vacío.";
                break;
        }
        return dato;
    }
}
