/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import Controladora.Main;

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
        String dato = "(" + cod + ") ";
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
                
            case 10:
                dato = "No has introducido el sueldo del jugador.";
                break;
                
            case 11:
                dato = "Seleccione si es un Alta o una Baja.";
                break;
                
            case 12:
                dato = "Los datos de login son incorrectos.";
                break;
                
            case 13:
                dato = "Has superado el límite de intentos.";
                break;
                
            case 14:
                dato = "Usuario no registrado en la Base de datos.";
                break;
                
            case 15:
                dato = "El Usuario ya existe en la Base de datos.";
                break;
                
            case 16:
                dato = "Debe seleccionar un equipo.";
                break;
                
            case 17:
                dato = "No existe ningún jugador con ese DNI.";
                break;
                
            case 18:
                dato = "No existe ningún usuario con ese nombre.";
                break;
                
            case 19:
                dato = "Ya existe un equipo con ese nombre.";
                break;
                
            case 20:
                dato = "No existe ningún equipo con ese nombre.";
                break;
                
            case 21:
                dato = "Has excedido el límite salario.";
                break;
                
            case 22:
                dato = "Ya tienes 6 jugaodres.";
                break;
                
            case 23:
                dato = "Ya existe un jugador con ese DNI.";
                break;
                
            case 24:
                dato = "Ese jugador no pertenece a tu equipo.";
                break;
        }
        return dato;
    }

    public int getCod() {
        return cod;
    }
    
    
}
