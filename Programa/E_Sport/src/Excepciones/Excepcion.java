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
                dato += "El usuario no puede estar vacío.";
                break;
                
            case 2:
                dato += "La contraseña no puede estar vacía.";
                break;
                
            case 3:
                dato += "El DNI debe tener el siguiente formato: LNNNNNNNL o NNNNNNNNL\nEjemplo X1234567Z o 12345678Z";
                break;
                
            case 4:
                dato += "El nombre ha de empezar con una mayúscula seguido de minúsculas con un rango mínimo total de 3 letras y sin números ni signos.";
                break;
                
            case 5:
                dato += "El apellido ha de empezar con una mayúscula seguido de minúsculas con un rango mínimo total de 3 letras y sin números ni signos.";
                break;
                
            case 6:
                dato += "El email debe ser coherente, ejemplo: ejemplo@compania.es";
                break;
                
            case 7:
                dato += "El usuario debe tener un mínimo de 3 letras.";
                break;
                
            case 8:
                dato += "La contraseña ha de tener un mínimo de 3 carácteres, tipo números, letras en mayúsculas o minúsculas. ";
                break;
                
            case 9:
                dato += "Debe seleccionar un perfil.";
                break;
                
            case 10:
                dato += "El salario mínimo ha de ser de 735,90 y el máximo de 196320,00.";
                break;
                
            case 11:
                dato += "Seleccione si es un Alta o una Baja.";
                break;
                
            case 12:
                dato += "Los datos de login son incorrectos.";
                break;
                
            case 13:
                dato += "Has superado el límite de intentos.";
                break;
                
            case 14:
                dato += "Usuario no registrado en la Base de datos.";
                break;
                
            case 15:
                dato += "El Usuario ya existe en la Base de datos.";
                break;
                
            case 16:
                dato += "Debe seleccionar un equipo.";
                break;
                
            case 17:
                dato += "No existe ningún jugador con ese DNI.";
                break;
                
            case 18:
                dato += "No existe ningún usuario con ese nombre.";
                break;
                
            case 19:
                dato += "Ya existe un equipo con ese nombre.";
                break;
                
            case 20:
                dato += "No existe ningún equipo con ese nombre.";
                break;
                
            case 21:
                dato += "Has excedido el límite salarial.";
                break;
                
            case 22:
                dato += "Ya tienes 6 jugadores.";
                break;
                
            case 23:
                dato += "Ya existe un jugador con ese DNI.";
                break;
                
            case 24:
                dato += "Ese jugador no pertenece a tu equipo.";
                break;
                
            case 25:
                dato += "No se ha realizado cambios en la BBDD.";
                break;
                
            case 26:
                dato += "El nickname no puede estar vacío.";
                break;
                
            case 27:
                dato += "No hay jugadores en la base de datos.";
                break;
                
            case 28:
                dato += "No hay equipos en la base de datos";
                break;
                
            case 29:
                dato += "El formato del lugar ha de ser Xxx, primero mayúscula seguido de minúsculas";
                break;
                
            case 30:
                dato += "El salario del equipo es superior a 200.000 €. \n Escoge un jugador con un salario menor o retira uno de los jugadores";
                break;
                
            case 31:
                dato += "Has alcanzado el límite de 6 jugadores. Por favor retira un jugador antes de añadir uno nuevo";
                break;
                
            case 32:
                dato += "Ha habido un error al eliminar.";
                break;
                
            case 33:
                dato += "El dueño no tiene asignado un equipo.\nPida primero al administrador que le asigne un equipo.";
                break;
                
            case 34:
                dato += "La Fecha inicial debe ser posterior a la fecha actual.";
                break;
                
            case 35:
                dato += "La fecha no puede ser anterior a la de hoy ni de la jornada y tampoco puede ser después de la jornada.";
                break;
                
            case 36:
                dato += "No se ha generado la liga, ya que no hay suficientes equipos con sus respectivos jugadores.\nSe precisa un mínimo de 2 equipos para generar al menos 1 partida.";
                break;
                
            case 37:
                dato += "Actualmente no hay ninguna liga.";
                break;
                
            case 38:
                dato += "No se mostrará la información de la última jornada, ya que la jornada aún no ha comenzado.";
                break;
                
            case 39:
                dato += "Actualmente no hay datos de Clasificación.";
                break;
                
            case 40:
                dato += "Error al insertar la Jornada.";
                break;
                
            case 41:
                dato += "Error al insertar el Partido.";
                break;
                
            case 42:
                dato += "Error al insertar el Equipo";
                break;
                
            case 43:
                dato += "Error al insertar fecha fin de la jornada.";
                break;
                
            case 44:
                dato += "Error al modificar el partido.";
                break;
                
            case 45:
                dato += "Ha habido un error al consultar los datos del Equipo en relación con la Persona.";
                break;
                
            case 46:
                dato += "Los puntos ha de ser numéricos.";
                break;
                
            case 47:
                dato += "Error al modificar el Marcador.";
                break;
                
            case 48:
                dato += "Ha habido un problema con la conexión, la bbdd no está conectado.";
                break;
                
            case 49:
                dato += "El lugar del equipo es obligatorio.";
                break;
                
            case 50:
                dato += "El nombre del equipo es obligatorio.";
                break;
                
            case 51:
                dato += "No has seleccionado el dueño del equipo";
                break;
                
            case 52:
                dato += "Ese dueño ya tiene un equipo.";
                break;
                
            case 53:
                dato += "El lugar del equipo es obligatorio.";
                break;
        }
        return dato;
    }

    public int getCodigo() {
        return codigo;
    }
    
}


