package UML;

import java.sql.Time;
import java.util.Date;

public class Partido {
    private int idPartido;
    private Date fecha;
    private Time hora;
    private String lugar;
    
    private Equipo[] listaEquipos;
    private Marcador[] listaMarcadores;
    private Jornada jornada;
    
    public Partido() {
        listaEquipos = new Equipo[2];
    }
    
    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Equipo[] getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(Equipo[] listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Marcador[] getListaMarcadores() {
        return listaMarcadores;
    }

    public void setListaMarcadores(Marcador[] listaMarcadores) {
        this.listaMarcadores = listaMarcadores;
    }
}
