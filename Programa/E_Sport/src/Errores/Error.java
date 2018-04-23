/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author v6222
 */
public class Error {
    
    int cod;

    public Error() {
    }

    public Error(int cod) {
        this.cod = cod;
    }
    
    public String getMessage(){
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
