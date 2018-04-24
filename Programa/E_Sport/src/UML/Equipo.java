package UML;

import java.util.ArrayList;
import java.util.Date;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private Date fechaCreacion;
    private String comentario;
    
    private Persona persona;
    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Marcador> listaMarcadores;

    public Equipo() {
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public ArrayList<Marcador> getListaMarcadores() {
        return listaMarcadores;
    }

    public void setListaMarcadores(ArrayList<Marcador> listaMarcadores) {
        this.listaMarcadores = listaMarcadores;
    }
}
