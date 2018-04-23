package UML;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Partido {
    private int idPartido;
    private Date fecha;
    private Time horaInicio, horaFin;
    private String lugar;
    
    private Jornada jornada;
    private Marcador[] marcador;
    
    private ArrayList<Jornada> listaJornadas;

    public Partido() {
        marcador = new Marcador[2];
    }

    public Partido(int idPartido) {
        this.idPartido = idPartido;
        marcador = new Marcador[2];
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

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Marcador[] getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcador[] marcador) {
        this.marcador = marcador;
    }
}
