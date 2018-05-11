/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 * Clase en la que controlamos todas las excepciones que puedan aparecer en el programa.
 * Fecha de creación de la clase: 25/04/2018
 * @author eqdaw04
 */

public class Excepcion extends Exception {
    
    int codigo;

    public Excepcion(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String getMessage(){
        String dato = "(" + codigo + ") ";
        switch(codigo)
        {
            case 1:
                dato = dato + "El usuario no puede estar vacío.";
                break;
                
                
            case 2:
                dato = dato + "La contraseña no puede estar vacía.";
                break;
                
            case 3:
                dato = dato + "El DNI debe tener el siguiente formato: LNNNNNNNL o NNNNNNNNL\nEjemplo X1234567Z o 12345678Z";
                break;
                
            case 4:
                dato = dato + "El nombre ha de empezar con una mayúscula seguido de minúsculas con un rango mínimo total de 3 letras y sin números ni signos.";
                break;
                
            case 5:
                dato = dato + "El apellido ha de empezar con una mayúscula seguido de minúsculas con un rango mínimo total de 3 letras y sin números ni signos.";
                break;
                
            case 6:
                dato = dato + "El email debe ser coherente, ejemplo: ejemplo@compania.es";
                break;
                
            case 7:
                dato = dato + "El usuario debe tener un mínimo de 3 letras.";
                break;
                
            case 8:
                dato = dato + "La contraseña ha de tener un mínimo de 3 carácteres, tipo números, letras en mayúsculas o minúsculas. ";
                break;
                
            case 9:
                dato = dato + "Debe seleccionar un perfil.";
                break;
                
            case 10:
                dato = dato + "No has introducido el sueldo del jugador.";
                break;
                
            case 11:
                dato = dato + "Seleccione si es un Alta o una Baja.";
                break;
                
            case 12:
                dato = dato + "Los datos de login son incorrectos.";
                break;
                
            case 13:
                dato = dato + "Has superado el límite de intentos.";
                break;
                
            case 14:
                dato = dato + "Usuario no registrado en la Base de datos.";
                break;
                
            case 15:
                dato = dato + "El Usuario ya existe en la Base de datos.";
                break;
                
            case 16:
                dato = dato + "Debe seleccionar un equipo.";
                break;
                
            case 17:
                dato = dato + "No existe ningún jugador con ese DNI.";
                break;
                
            case 18:
                dato = dato + "No existe ningún usuario con ese nombre.";
                break;
                
            case 19:
                dato = dato + "Ya existe un equipo con ese nombre.";
                break;
                
            case 20:
                dato = dato + "No existe ningún equipo con ese nombre.";
                break;
                
            case 21:
                dato = dato + "Has excedido el límite salarial.";
                break;
                
            case 22:
                dato = dato + "Ya tienes 6 jugadores.";
                break;
                
            case 23:
                dato = dato + "Ya existe un jugador con ese DNI.";
                break;
                
            case 24:
                dato = dato + "Ese jugador no pertenece a tu equipo.";
                break;
                
            case 25:
                dato = dato + "No se ha realizado cambios en la BBDD.";
                break;
                
            case 26:
                dato = dato + "El nicname no puede estar vacío.";
                break;
                
            case 27:
                dato = dato + "No hay jugadores en la base de datos.";
                break;
                
            case 28:
                dato = dato + "No hay equipos en la base de datos";
                break;
                
            case 30:
                dato = dato + "El salario del equipo es superior a 200.000 €. \n Escoge un jugador con un salario menor o retira uno de los jugadores";
                break;
                
            case 31:
                dato = dato + "Has alcanzado el límite de 6 jugadores. Por favor retira un jugador antes de añadir uno nuevo";
                break;
                
            case 40:
                dato = "Error al insertar la Jornada.";
                break;
                
            case 41:
                dato = "Error al insertar el Partido.";
                break;
                
            case 42:
                dato = "Error al insertar el Equipo";
                break;
                
            case 50:
                dato = dato + "El nombre del equipo es obligatorio.";
                break;
                
            case 51:
                dato = dato + "No has seleccionado el dueño del equipo";
                break;
                
            case 52:
                dato = dato + "Ese dueño ya tiene un equipo.";
                break;
        }
        return dato;
    }

    public int getCodigo() {
        return codigo;
    }
    
}


