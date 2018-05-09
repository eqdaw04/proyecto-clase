package UML;

import java.util.ArrayList;

/**
 * Clase en la que definiremos el nombre de perfil de la persona a registrar.
 * Fecha de creación de la clase: 23/04/2018
 * @author eqdaw04
 */

public class Perfil {
    private int idPerfil;
    private String nombre;
    
    private ArrayList<Persona> listaPersonas;

    public Perfil() {
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}
