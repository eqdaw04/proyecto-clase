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
    String mensaje;

    public Excepcion() {
    }

    public Excepcion(int cod) {
        this.cod = cod;
    }
    
    public Excepcion(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public String getMessage(){
        String dato = "";
        switch(cod){
            case 1:
                dato = "El usuario no puede estar vacío.";
                break;
                
            case 2:
                dato = "La contraseña no puede estar vacío.";
                break;
                
            case 3:
                dato = "El DNI debe tener el siguiente formato: LNNNNNNNL o NNNNNNNNL\nEjemplo X1234567Z o 12345678Z";
                break;
                
            case 4:
                dato = "El nombre ha de empezar con una mayúscula seguido de minúsculas con un rango mínimo total de 3 letras y sin números ni signos.";
                break;
                
            case 5:
                dato = "El apellido ha de empezar con una mayúscula seguido de minúsculas con un rango mínimo total de 3 letras y sin números ni signos.";
                break;
                
            case 6:
                dato = "El email debe ser coherente, ejemplo: ejemplo@compania.es";
                break;
                
            case 7:
                dato = "El usuario debe tener un mínimo de 3 letras.";
                break;
                
            case 8:
                dato = "La contraseña ha de tener un mínimo de 3 carácteres, tipo números, letras en mayúsculas o minúsculas. ";
                break;
                
            case 9:
                dato = "Debe seleccionar un perfil.";
                break;
        }
        return dato;
    }
    
    public String getMensaje(){
        return mensaje;
    }
}
